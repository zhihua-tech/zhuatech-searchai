/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
export const domain={
 code:'SEARCHAI',systemName:'知华企业智能搜索平台',englishName:'ENTERPRISE AI SEARCH',theme:{primary:'#365f83',dark:'#1e3448',accent:'#b88745',},
 workspace:'数字化中心 / 企业搜索运营组',fieldWorkspace:'知识检索组',period:'2026-08-04 · 实时运营',liveText:'运营数据于 10:36 更新',fieldContextLabel:'当前工作周期',fieldContext:'八月第一周',fieldUser:'许知',fieldRole:'知识运营专员',adminUser:'程越',adminRole:'搜索平台负责人',
 adminTitle:'企业搜索运营控制台',adminBreadcrumb:'搜索智能运营 / 全局态势',adminSubtitle:'统一监控数据源接入、索引健康、搜索质量、权限过滤和无答案问题。',exportAction:'导出运营报告',createAction:'新建索引任务',
 chartTitle:'搜索处理完成趋势',chartSubtitle:'本月实际完成率 / 运营目标',chartLabels:['01日','05日','09日','13日','17日','21日','25日','29日','31日'],loadTitle:'搜索领域负荷',loadSubtitle:'开放任务占团队处理能力',recordsTitle:'重点索引任务',recordsSubtitle:'按优先级、期限与失败排序',issueTitle:'需要关注的运营事项',issueSubtitle:'需要跨团队确认或升级处理',
 recordName:'索引任务',itemName:'知识域',unitName:'责任部门',batchName:'数据源类型',planName:'文档',doneName:'已索引',exceptionName:'失败',unitLabel:'项',
 listBreadcrumb:'搜索工作台 / 索引任务',listSubtitle:'为企业内部知识、文档、业务系统和数据目录提供权限感知的语义搜索、问答与引用溯源。',listSummary:[['知识数据源','68'],['本周处理','24'],['失败','9'],['高优先级','3',true]],tabs:['全部','待处理','进行中','待确认','已归档'],
 fieldBreadcrumb:'搜索运营 / 知识运营专员工作台',fieldTitle:'知识检索运营台',fieldSubtitle:'数据源 36 个 · 今日查询 8,426 次 · 待处理无答案 18 条',fieldSecondary:'查看工作日历',reportAction:'提交处理反馈',fieldNoticeTitle:'智能服务运行正常',fieldNotice:'任务数据完整率 93.8%',
 steps:[
 '连接数据源',
 '解析与切分',
 '构建索引',
 '质量评测',
 '查询运营'
],documentAction:'查看操作手册',printAction:'导出工作档案',resourceCardTitle:'智能资源状态',resourceValueLabel:'当前处理量',resourceHealthLabel:'服务健康度',quickSubtitle:'常用工作入口',quickActions:[
 [
  '搜索调试',
  '/shopfloor/report',
  '查询、召回、重排与引用'
 ],
 [
  '知识域',
  '/shopfloor/material',
  '数据源、负责人和同步策略'
 ],
 [
  '索引中心',
  '/shopfloor/resources',
  '切分、向量、关键词与质量'
 ],
 [
  '权限事件',
  '/shopfloor/andon',
  '越权风险、映射异常与阻断'
 ]
],
 reportDefaults:[6,1],reportTitle:'索引任务处理反馈',reportSubtitle:'记录已索引、失败和处理建议。',reportSuccess:'知识运营反馈已提交',reportPlaceholder:'填写处理结论、引用依据、后续要求与负责人',reportFootnote:'提交后自动进入负责人复核队列',ruleTitle:'智能处理质量门禁',ruleSubtitle:'SEARCHAI-POLICY · V1.0',rules:[['人工复核','关键结果必须'],['引用与依据','必须保留'],['权限检查','执行前完成'],['运行评估','每月',true]],fieldTotals:[['68','知识数据源'],['3','高优先级'],['9','失败'],['93.8%','数据完整率']],
 adminMenus:[['/admin','home','运营控制中心'],['/admin/work-orders','order','索引任务'],['/admin/samples','box','知识域台账'],['/admin/schedule','calendar','计划与排期'],['/admin/methods','process','规则与模板'],['/admin/reviews','quality','审核与决策'],['/admin/resources','machine','智能资源'],['/admin/report','chart','运营分析']],
 fieldMenus:[['/shopfloor','home','知识检索运营台'],['/shopfloor/report','report','处理反馈'],['/shopfloor/tasks','order','我的任务'],['/shopfloor/material','box','知识域台账'],['/shopfloor/resources','machine','智能资源'],['/shopfloor/andon','risk','问题升级',3]],
 moduleTitles:{tasks:['我的待办任务','查看优先级、期限与处理状态'],material:['知识域台账','查询完整资料、历史版本与责任人'],resources:['智能资源中心','管理知识、模型、连接器和处理服务'],andon:['问题升级','提交重大风险、争议或阻塞事项'],samples:['知识域台账','统一管理业务对象、资料与上下游依赖'],schedule:['计划与排期','协调负责人、参与方和交付窗口'],methods:['规则与模板','维护处理口径、质量标准和模板'],reviews:['审核与决策','记录确认、驳回和复核要求'],report:['运营分析','分析质量、效率、异常和处理周期']},
 tagline:'在正确的权限下，让每个问题找到可信答案',storyTitle:'在正确的权限下，<br/>让每个问题找到可信答案',storyText:'为企业内部知识、文档、业务系统和数据目录提供权限感知的语义搜索、问答与引用溯源。',pattern:[2,4,7,9,12,15,18,21,24,27,29,31],loginStats:[['60','知识数据源'],['93.8%','数据完整率'],['3','高优先级']],loginTitle:'企业搜索运营控制台',adminDemo:'管理 / 运营 / 分析',fieldDemo:'任务 / 处理 / 反馈'
}
export const records=[
 {no:'SEA-260804-018',name:'产品与解决方案知识域',code:'PRODUCT-KB',unit:'知识检索组',group:'数字化中心',plan:24,done:16,exception:3,due:'08-04',batch:'文档中心',status:'增量索引',progress:67,priority:'加急'},
 {no:'SEA-260804-021',name:'项目交付文档知识域',code:'DELIVERY-KB',unit:'交付知识组',group:'交付中心',plan:18,done:8,exception:2,due:'08-05',batch:'对象存储',status:'权限校验',progress:44,priority:'关注'},
 {no:'SEA-260804-026',name:'客户服务工单知识域',code:'CS-TICKET-KB',unit:'服务知识组',group:'客户成功中心',plan:12,done:0,exception:0,due:'08-06',batch:'业务 API',status:'待接入',progress:12,priority:'加急'},
 {no:'SEA-260803-015',name:'制度与流程知识域',code:'POLICY-KB',unit:'知识检索组',group:'数字化中心',plan:20,done:20,exception:1,due:'08-03',batch:'DMS',status:'已同步',progress:100,priority:'正常'},
 {no:'SEA-260804-031',name:'研发技术文档知识域',code:'RND-WIKI',unit:'研发知识组',group:'研发中心',plan:16,done:11,exception:2,due:'08-07',batch:'Wiki+Git',status:'质量优化',progress:76,priority:'关注'}
]
export const resources=[{code:'CONNECT-01',name:'企业数据源连接器',unit:'搜索平台组',status:'运行中',health:98,value:'36',valueUnit:'个',note:'最近同步成功率 99.2%'},{code:'INDEX-02',name:'向量与关键词混合索引',unit:'AI 能力中心',status:'复核中',health:91,value:'286万',valueUnit:'段',note:'3 个知识域正在重建'},{code:'ACL-03',name:'文档权限过滤服务',unit:'信息安全组',status:'预警',health:84,value:'67',valueUnit:'条',note:'2 条权限映射待修复'}]
export const reviews=[{no:'EVAL-260804-032',title:'产品问答集质量评测',type:'搜索评测',detail:'120 个问题 · 程越',result:'待确认'},{no:'ACL-260804-011',title:'交付文档权限抽查',type:'权限审计',detail:'18 个角色 · 许知',result:'通过'},{no:'ZERO-260803-018',title:'客服高频无答案问题复盘',type:'知识补全',detail:'缺口 12 条',result:'异常'}]
export const adminMetrics=[['知识数据源','68','较上月新增 6','blue'],['本周处理','24','平均周期 2.6 天','green'],['失败','9','其中 3 项临近期','orange'],['高优先级','3','需要负责人决策','red']]
export const fieldMetrics=[['我的任务','6','3 项高优先级','blue'],['今日已处理','18','质量检查已完成','green'],['失败','9','3 项临近期限','orange'],['数据完整率','93.8%','较上周提升 2.4%','slate']]
export const chartActual=[18,26,37,45,56,63,72,81,87],chartTarget=[20,30,40,50,60,70,80,90,96]
export const loads=[
 [
  '产品与解决方案',
  86,
  '知识文档 8.6 万份'
 ],
 [
  '项目与客户交付',
  78,
  '知识文档 12.3 万份'
 ],
 [
  '制度流程与职能',
  72,
  '知识文档 4.8 万份'
 ],
 [
  '研发与技术资产',
  64,
  '知识文档 18.2 万份'
 ]
]
export const issues=[
 [
  '权限',
  '交付知识域存在 2 条角色映射异常',
  '已阻断相关搜索结果',
  '待修复'
 ],
 [
  '质量',
  '客服退款政策问题无答案率升高',
  '近 7 日出现 42 次',
  '补充中'
 ],
 [
  '时效',
  '产品定价文档超过 30 天未同步',
  '影响销售助手引用',
  '待处理'
 ]
].map(x=>({type:x[0],title:x[1],detail:x[2],status:x[3]}))
