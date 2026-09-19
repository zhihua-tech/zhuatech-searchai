/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.searchai;import cn.zhuatech.searchai.service.SearchQualityService;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class SearchQualityServiceTests{private final SearchQualityService s=new SearchQualityService();/**
                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                 */
@Test void blocksPermissionLeak(){var r=s.evaluate(new SearchQualityService.Request(1000,10,800,80,5,2,1));assertEquals("BLOCK",r.status());}/**
                                                                                                                                                                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                              */
@Test void acceptsHealthySearch(){var r=s.evaluate(new SearchQualityService.Request(1000,10,800,80,5,2,0));assertEquals("HEALTHY",r.status());}}
