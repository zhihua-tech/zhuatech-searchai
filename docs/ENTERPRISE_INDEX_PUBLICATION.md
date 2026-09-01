# 企业级搜索索引发布治理

`POST /api/enterprise/searchai/search-index-publication` 检查内容授权、ACL 同步、隐私、新鲜度、相关性、零结果率、监控、回滚和审批，返回 `PUBLISH / CANARY / BLOCKED`。

生产环境应把语料清单、权限快照、切分与索引版本及离线评测集统一归档，并持续检测越权搜索和结果过期。
