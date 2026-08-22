/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.searchai.config;
import cn.zhuatech.searchai.model.*; import cn.zhuatech.searchai.repository.*; import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.*; import org.springframework.security.crypto.password.PasswordEncoder; import java.time.LocalDate; import java.util.List;
@Configuration public class DataInitializer {
 @Bean CommandLineRunner seed(OperatingUnitRepository units,WorkRecordRepository orders,ResourceRegisterRepository resources,ReviewRecordRepository reviews,UserRepository users,PasswordEncoder encoder){return args->{if(units.count()>0)return;
 var u1=units.save(new OperatingUnit("SEARCH-OPS","知识检索组","数字化中心",180));var u2=units.save(new OperatingUnit("SEARCH-DEL","交付知识组","交付中心",120));var u3=units.save(new OperatingUnit("SEARCH-RND","研发知识组","研发中心",96));
 var t1=orders.save(new WorkRecord("SEA-260804-018","PRODUCT-KB","产品与解决方案知识域",u1,24,16,1,LocalDate.now().plusDays(1),WorkRecord.Status.RUNNING,"文档中心"));
 var t2=orders.save(new WorkRecord("SEA-260804-021","DELIVERY-KB","项目交付文档知识域",u2,18,8,0,LocalDate.now().plusDays(2),WorkRecord.Status.RUNNING,"对象存储"));
 var t3=orders.save(new WorkRecord("SEA-260804-026","CS-TICKET-KB","客户服务工单知识域",u1,12,0,0,LocalDate.now().plusDays(3),WorkRecord.Status.RELEASED,"业务 API"));
 var t4=orders.save(new WorkRecord("SEA-260803-015","POLICY-KB","制度与流程知识域",u3,20,20,1,LocalDate.now(),WorkRecord.Status.COMPLETED,"DMS"));
 resources.saveAll(List.of(new ResourceRegister("CONNECTOR-01","数据源连接服务",u1,ResourceRegister.Status.RUNNING,98),new ResourceRegister("HYBRID-INDEX-02","混合检索索引",u2,ResourceRegister.Status.IDLE,91),new ResourceRegister("RERANK-03","语义重排服务",u3,ResourceRegister.Status.RUNNING,93),new ResourceRegister("ACL-FILTER-04","权限过滤网关",u1,ResourceRegister.Status.ALARM,84)));
 reviews.saveAll(List.of(new ReviewRecord("RV-260804-032",t1,"人工复核",6,0,ReviewRecord.Result.PASSED,"程越"),new ReviewRecord("RV-260804-011",t2,"质量检查",3,0,ReviewRecord.Result.PASSED,"许知"),new ReviewRecord("RV-260803-018",t4,"结果抽查",5,1,ReviewRecord.Result.FAILED,"程越"),new ReviewRecord("RV-260804-003",t3,"上线确认",4,0,ReviewRecord.Result.PENDING,"许知")));
 String demo=encoder.encode("Demo@2026");users.saveAll(List.of(new UserAccount("operator",demo,"许知",UserAccount.Role.DOMAIN_USER,"SEARCH-OPS"),new UserAccount("planner",demo,"程越",UserAccount.Role.DOMAIN_OPERATOR,null),new UserAccount("quality",demo,"顾清",UserAccount.Role.QUALITY,null),new UserAccount("admin",encoder.encode("ZhuaTech@2026"),"系统管理员",UserAccount.Role.ADMIN,null)));};}
}