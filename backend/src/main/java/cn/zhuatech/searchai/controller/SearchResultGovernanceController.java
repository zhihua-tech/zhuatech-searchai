/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.searchai.controller;

import cn.zhuatech.searchai.common.ApiResponse;
import cn.zhuatech.searchai.service.SearchResultGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enterprise/searchai")
public class SearchResultGovernanceController {
    private final SearchResultGovernanceService service;
    public SearchResultGovernanceController(SearchResultGovernanceService service) { this.service = service; }
    @PostMapping("/result-governance")
    public ApiResponse<SearchResultGovernanceService.GovernanceResult> govern(
            @Valid @RequestBody SearchResultGovernanceService.GovernanceRequest request) {
        return ApiResponse.ok("搜索结果治理完成", service.govern(request));
    }
}
