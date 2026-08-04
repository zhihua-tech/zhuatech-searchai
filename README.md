# ZhuaTech SearchAI · 知华企业智能搜索平台

为企业内部知识、文档、业务系统和数据目录提供权限感知的语义搜索、问答与引用溯源。

由 **上海如静知华信息科技有限公司（知华科技）** 发布维护。官网：[https://www.zhuatech.cn/](https://www.zhuatech.cn/)。

![Java 21](https://img.shields.io/badge/Java-21-365f83) ![Vue 3](https://img.shields.io/badge/Vue-3-42b883) ![MySQL 8](https://img.shields.io/badge/MySQL-8-4479A1) ![License](https://img.shields.io/badge/license-Non--Commercial-b88745)

## 搜索答案之前，先确认谁能看什么

为企业内部知识、文档、业务系统和数据目录提供权限感知的语义搜索、问答与引用溯源。

采用混合召回、权限过滤、语义重排和段落级引用的参考架构，避免“能检索但不可审计”的黑盒问答。

## 功能全景

- 管理端：企业搜索运营控制台、任务台账、计划排期、规则模板、审核决策、资源监控和运营分析。
- H5 工作台：我的任务、资料查询、智能处理、人工反馈、证据查看和问题升级。
- AI 参考能力：`EnterpriseSearchService` 提供“权限感知搜索计划”的确定性实现，可替换为企业自有模型。
- 工程能力：JWT 权限、JPA、Flyway、MySQL、演示数据、Docker Compose、响应式 Vue 3 前端。

## 页面预览

### 企业搜索运营台

![企业搜索运营台](docs/images/searchai-admin.png)

### 知识运营 H5

![知识运营 H5](docs/images/searchai-h5.png)

演示账号：管理端 `planner / Demo@2026`，H5 端 `operator / Demo@2026`。截图和演示数据均为虚构内容。

## 本地运行

```bash
cd frontend
npm install
npm run dev:demo
```

浏览器访问 `http://localhost:5173`。后端使用 Java 21、Spring Boot 与 MySQL 8，完整容器方式：

```bash
cp .env.example .env
docker compose up --build
```

Java 包名为 `cn.zhuatech.searchai`，数据库名为 `zhuatech_searchai`。API 摘要见 [docs/api.md](docs/api.md)。

## 使用许可与商业授权

本工程仅限个人学习、研究和非商业技术交流，**不得商用**。企业内部生产使用、SaaS、私有化部署、客户交付、收费培训、品牌替换或商业分发，须事先取得上海如静知华信息科技有限公司书面授权。详细条款见 [LICENSE](LICENSE)。

需要 企业智能搜索平台 私有化部署、模型接入、系统集成或深度定制，请访问[知华科技官网](https://www.zhuatech.cn/)，也可扫码咨询：

| 产品与方案咨询 | 深度开发定制 |
| --- | --- |
| ![微信咨询二维码一](docs/images/zhuatech-wechat-consulting.png) | ![微信咨询二维码二](docs/images/zhuatech-wechat-consulting-2.png) |

SEO：企业智能搜索、AI搜索、语义检索、RAG搜索、Java企业搜索源码、知华科技、上海如静知华信息科技有限公司。
