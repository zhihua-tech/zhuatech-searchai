# SEARCHAI API 摘要

版权所有 © 2026 上海如静知华信息科技有限公司。

| 方法 | 路径 | 说明 |
| --- | --- | --- |
| POST | `/api/auth/login` | 登录并获取 JWT |
| GET | `/api/admin/dashboard` | 企业搜索运营控制台 |
| GET | `/api/admin/work-orders` | 索引任务列表 |
| GET | `/api/shopfloor/dashboard` | 知识检索运营台 |
| POST | `/api/shopfloor/work-orders/{id}/reports` | 提交处理反馈 |
| POST | `/api/ai/search/plan` | 权限感知搜索计划 |
| POST | `/api/shopfloor/ai-risk-assessment` | AI 功能上线风险初筛 |

除登录外均需 `Authorization: Bearer <token>`。社区演示实现不调用外部模型，不需要 API Key。
