/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.searchai.controller;import cn.zhuatech.searchai.common.ApiResponse;import cn.zhuatech.searchai.service.SearchIndexPublicationService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/enterprise/searchai") public class SearchIndexPublicationController{private final SearchIndexPublicationService service;/**
                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                               */
public SearchIndexPublicationController(SearchIndexPublicationService service){this.service=service;}/**
                                                                                                                                                                                                                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                    */
@PostMapping("/search-index-publication")public ApiResponse<SearchIndexPublicationService.Assessment>assess(@Valid @RequestBody SearchIndexPublicationService.Request request){return ApiResponse.ok(service.assess(request));}}
