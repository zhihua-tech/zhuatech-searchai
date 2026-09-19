/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.searchai;

import cn.zhuatech.searchai.service.SearchResultGovernanceService;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class SearchResultGovernanceServiceTests {
    private final SearchResultGovernanceService service = new SearchResultGovernanceService();
    @Test void releasesAuthorizedResultsWithEvidenceDiversity() {
        var result = service.govern(request(List.of(
                candidate("D-1", "TENANT-A", "dms", "0.96", true, false, true, true),
                candidate("D-2", "TENANT-A", "wiki", "0.88", true, true, true, true))));
        assertThat(result.decision()).isEqualTo(SearchResultGovernanceService.Decision.RELEASE);
        assertThat(result.citationCoverage()).isEqualByComparingTo("1.0000");
        assertThat(result.sourceDiversity()).isEqualTo(2);
    }
    @Test void removesUnauthorizedCrossTenantAndUnmaskedResults() {
        var result = service.govern(request(List.of(
                candidate("D-1", "TENANT-B", "dms", "0.96", true, false, true, true),
                candidate("D-2", "TENANT-A", "hr", "0.90", true, true, false, true))));
        assertThat(result.decision()).isEqualTo(SearchResultGovernanceService.Decision.BLOCKED);
        assertThat(result.rejectedResults()).hasSize(2);
    }
    @Test void reviewsWeakCitationOrSingleSourceResults() {
        var result = service.govern(request(List.of(
                candidate("D-1", "TENANT-A", "dms", "0.96", true, false, true, false),
                candidate("D-2", "TENANT-A", "dms", "0.85", true, false, true, true))));
        assertThat(result.decision()).isEqualTo(SearchResultGovernanceService.Decision.REVIEW);
        assertThat(result.actions()).hasSize(2);
    }
    private SearchResultGovernanceService.GovernanceRequest request(List<SearchResultGovernanceService.Candidate> c) {
        return new SearchResultGovernanceService.GovernanceRequest("TENANT-A", "U-1", "采购流程",
                false, new BigDecimal("0.70"), new BigDecimal("0.80"), 2, 10, c);
    }
    private SearchResultGovernanceService.Candidate candidate(String id, String tenant, String source,
            String score, boolean acl, boolean pii, boolean masked, boolean citation) {
        return new SearchResultGovernanceService.Candidate(id, tenant, source,
                SearchResultGovernanceService.Classification.INTERNAL, new BigDecimal(score),
                acl, pii, masked, citation);
    }
}
