/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.searchai.controller;import cn.zhuatech.searchai.common.ApiResponse;import cn.zhuatech.searchai.service.SearchQualityService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/searchai/insights/search-quality") public class SearchQualityController{private final SearchQualityService service;/**
                                                                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                          */
public SearchQualityController(SearchQualityService service){this.service=service;}/**
                                                                                                                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                             */
@PostMapping ApiResponse<SearchQualityService.Result> evaluate(@Valid @RequestBody SearchQualityService.Request r){return ApiResponse.ok(service.evaluate(r));}}
