/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.searchai.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** 对检索候选执行租户、ACL、分类、脱敏、引用和来源多样性控制。 */
@Service
public class SearchResultGovernanceService {
    public GovernanceResult govern(GovernanceRequest request) {
        List<Candidate> eligible = new ArrayList<>();
        List<RejectedCandidate> rejected = new ArrayList<>();
        for (Candidate candidate : request.candidates()) {
            List<String> reasons = new ArrayList<>();
            if (!request.tenantId().equals(candidate.tenantId())) reasons.add("租户不匹配");
            if (!candidate.aclAllowed()) reasons.add("用户无文档访问权限");
            if (candidate.classification() == Classification.RESTRICTED
                    && !request.restrictedAccessApproved()) reasons.add("受限文档访问未审批");
            if (candidate.containsPersonalData() && !candidate.piiMasked()) reasons.add("个人信息未脱敏");
            if (candidate.relevanceScore().compareTo(request.minRelevanceScore()) < 0) reasons.add("相关度低于阈值");
            if (reasons.isEmpty()) eligible.add(candidate);
            else rejected.add(new RejectedCandidate(candidate.documentId(), List.copyOf(reasons)));
        }
        List<Candidate> released = eligible.stream()
                .sorted(Comparator.comparing(Candidate::relevanceScore).reversed())
                .limit(request.maxResults()).toList();
        BigDecimal citationCoverage = ratio(released.stream().filter(Candidate::citationAvailable).count(), released.size());
        int sourceDiversity = (int) released.stream().map(Candidate::sourceSystem).distinct().count();
        List<String> actions = new ArrayList<>();
        Decision decision;
        if (released.isEmpty()) {
            decision = Decision.BLOCKED;
            actions.add("不向用户或生成模型返回结果，记录权限与质量门禁原因");
        } else if (citationCoverage.compareTo(request.minCitationCoverage()) < 0
                || sourceDiversity < request.minSourceDiversity()) {
            decision = Decision.REVIEW;
            if (citationCoverage.compareTo(request.minCitationCoverage()) < 0) actions.add("补充可定位原文的页码或段落引用");
            if (sourceDiversity < request.minSourceDiversity()) actions.add("扩大可信数据源召回并抑制单一来源偏置");
        } else {
            decision = Decision.RELEASE;
            actions.add("仅返回已授权结果，并携带引用、分类和来源审计上下文");
        }
        return new GovernanceResult(decision, released, List.copyOf(rejected), citationCoverage,
                sourceDiversity, List.copyOf(actions));
    }

    private BigDecimal ratio(long numerator, int denominator) {
        if (denominator == 0) return BigDecimal.ZERO.setScale(4);
        return BigDecimal.valueOf(numerator).divide(BigDecimal.valueOf(denominator), 4, RoundingMode.HALF_UP);
    }

    public record GovernanceRequest(@NotBlank String tenantId, @NotBlank String userId,
            @NotBlank String query, boolean restrictedAccessApproved,
            @DecimalMin("0") @DecimalMax("1") BigDecimal minRelevanceScore,
            @DecimalMin("0") @DecimalMax("1") BigDecimal minCitationCoverage,
            @Min(1) @Max(10) int minSourceDiversity, @Min(1) @Max(100) int maxResults,
            @NotEmpty List<@Valid Candidate> candidates) {}
    public record Candidate(@NotBlank String documentId, @NotBlank String tenantId,
            @NotBlank String sourceSystem, @NotNull Classification classification,
            @DecimalMin("0") @DecimalMax("1") BigDecimal relevanceScore,
            boolean aclAllowed, boolean containsPersonalData, boolean piiMasked,
            boolean citationAvailable) {}
    public record RejectedCandidate(String documentId, List<String> reasons) {}
    public record GovernanceResult(Decision decision, List<Candidate> releasedResults,
            List<RejectedCandidate> rejectedResults, BigDecimal citationCoverage,
            int sourceDiversity, List<String> actions) {}
    public enum Classification { PUBLIC, INTERNAL, CONFIDENTIAL, RESTRICTED }
    public enum Decision { RELEASE, REVIEW, BLOCKED }
}
