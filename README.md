


# TLIAS 教学管理系统

[TLIAS (Teaching Logistics Information Administration System)](https://gitee.com/winshengly/tlias-management) 是一个前后端分离的人力资源与教学管理系统，采用 Vue 3 + Spring Boot 技术栈开发。

## 项目简介

本系统提供了完善的人力资源管理和教学管理功能，包括员工管理、部门管理、班级管理、学生管理、数据报表统计等模块。系统采用 JWT 进行身份认证，支持操作日志记录和文件上传功能。

## 技术栈

### 前端
- **Vue 3** - 渐进式前端框架
- **Vite** - 构建工具
- **Vue Router** - 路由管理
- **Pinia** - 状态管理
- **Axios** - HTTP 请求库

### 后端
- **Spring Boot** - 后端框架
- **MyBatis** - ORM 框架
- **MySQL** - 数据库
- **JWT** - 身份认证
- **AOP** - 面向切面编程（操作日志）
- **Aliyun OSS** - 云存储（文件上传）

## 功能模块

### 员工管理 (`/emps`)
- 员工列表查询（分页、条件筛选）
- 新增员工（包含工作经历）
- 编辑员工信息
- 批量删除员工
- 员工列表（不分页）

### 部门管理 (`/depts`)
- 部门列表查询
- 新增部门
- 编辑部门信息
- 删除部门

### 班级管理 (`/clazzs`)
- 班级列表查询（分页、日期筛选）
- 新增班级
- 编辑班级信息
- 删除班级
- 班级列表（不分页）

### 学生管理 (`/students`)
- 学生列表查询（分页、条件筛选）
- 新增学生
- 编辑学生信息
- 批量删除学生
- 违纪处理（扣分）

### 数据报表 (`/report`)
- 员工岗位统计
- 员工性别统计
- 学生学历统计
- 各班级学生人数统计

### 日志管理 (`/log`)
- 操作日志查询
- 分页展示

### 文件上传 (`/upload`)
- 阿里云 OSS 文件上传

### 登录认证 (`/login`)
- 用户登录
- JWT Token 认证

## 项目结构

```
tlias-management/
├── tails-manergement/          # 前端项目
│   ├── src/
│   │   ├── api/                # API 接口
│   │   │   ├── clazz.js
│   │   │   ├── dept.js
│   │   │   ├── emp.js
│   │   │   ├── log.js
│   │   │   ├── login.js
│   │   │   ├── report.js
│   │   │   └── stu.js
│   │   ├── assets/             # 静态资源
│   │   ├── router/             # 路由配置
│   │   ├── stores/             # 状态管理
│   │   ├── utils/              # 工具函数
│   │   ├── views/              # 页面组件
│   │   │   ├── clazz/
│   │   │   ├── dept/
│   │   │   ├── emp/
│   │   │   ├── index/
│   │   │   ├── layout/
│   │   │   ├── log/
│   │   │   ├── login/
│   │   │   ├── report/
│   │   │   └── stu/
│   │   ├── App.vue
│   │   └── main.js
│   ├── index.html
│   ├── package.json
│   └── vite.config.js
│
└── web-ai-project02/           # 后端项目
    └── hr-manegement/
        ├── src/main/java/com/hr/
        │   ├── anno/            # 自定义注解
        │   │   └── Log.java
        │   ├── aop/             # 切面编程
        │   │   └── OperationLogAspect.java
        │   ├── config/          # 配置类
        │   │   └── WebConfig.java
        │   ├── controller/      # 控制器
        │   │   ├── ClazzController.java
        │   │   ├── DeptController.java
        │   │   ├── EmpController.java
        │   │   ├── EmpLogController.java
        │   │   ├── LoginController.java
        │   │   ├── ReportController.java
        │   │   ├── SessionController.java
        │   │   ├── StudentController.java
        │   │   └── UploadController.java
        │   ├── exception/       # 异常处理
        │   │   ├── BusinessException.java
        │   │   └── GlobalExceptionHandler.java
        │   ├── filter/          # 过滤器
        │   │   ├── DemoFilter.java
        │   │   ├── TokenFilter.java
        │   │   └── XyzFilter.java
        │   ├── interceptor/     # 拦截器
        │   │   ├── DemoInterceptor.java
        │   │   └── TokenInterceptor.java
        │   ├── mapper/          # MyBatis Mapper
        │   ├── pojo/            # 实体类
        │   ├── service/         # 业务逻辑
        │   │   └── impl/
        │   └── utils/           # 工具类
        │       ├── AliyunOSSOperator.java
        │       ├── AliyunOSSProperties.java
        │       ├── CurrentHolder.java
        │       └── JwtUtils.java
        └── src/main/resources/
            ├── application.yml
            └── com/hr/mapper/   # Mapper XML 文件
```

## 快速开始

### 前端启动

```bash
# 进入前端项目目录
cd tails-manergement

# 安装依赖
npm install

# 启动开发服务器
npm run dev
```

### 后端启动

```bash
# 进入后端项目目录
cd web-ai-project02/hr-manegement

# 使用 Maven 启动
mvn spring-boot:run
```

## 配置说明

### 后端配置文件 (`application.yml`)

主要配置项：
- 数据库连接
- JWT 密钥和过期时间
- 阿里云 OSS 配置
- 文件上传大小限制

### 前端配置

前端通过 `src/utils/request.js` 封装 Axios 实例，配置了请求拦截器和响应拦截器。

## 系统特性

1. **操作日志记录**：通过 `@Log` 注解自动记录方法调用日志
2. **JWT 认证**：无状态 Token 认证机制
3. **文件上传**：支持阿里云 OSS 云存储
4. **统一异常处理**：全局异常捕获和处理
5. **事务管理**：Service 层方法事务配置
6. **分页查询**：支持分页和条件筛选

## 许可证

本项目仅供学习交流使用。