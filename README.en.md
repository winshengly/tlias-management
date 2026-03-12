# TLIAS Teaching Management System

[TLIAS (Teaching Logistics Information Administration System)](https://gitee.com/winshengly/tlias-management) is a front-end and back-end separated human resources and teaching management system developed using the Vue 3 + Spring Boot technology stack.

## Project Overview

This system provides comprehensive human resources and teaching management functionalities, including modules such as employee management, department management, class management, student management, and data reporting. The system uses JWT for authentication and supports operation logging and file upload features.

## Technology Stack

### Front-end
- **Vue 3** - Progressive JavaScript framework
- **Vite** - Build tool
- **Vue Router** - Routing management
- **Pinia** - State management
- **Axios** - HTTP request library

### Back-end
- **Spring Boot** - Back-end framework
- **MyBatis** - ORM framework
- **MySQL** - Database
- **JWT** - Authentication
- **AOP** - Aspect-Oriented Programming (operation logging)
- **Aliyun OSS** - Cloud storage (file upload)

## Functional Modules

### Employee Management (`/emps`)
- Query employee list (pagination, conditional filtering)
- Add new employee (including work experience)
- Edit employee information
- Bulk delete employees
- Employee list (without pagination)

### Department Management (`/depts`)
- Query department list
- Add new department
- Edit department information
- Delete department

### Class Management (`/clazzs`)
- Query class list (pagination, date filtering)
- Add new class
- Edit class information
- Delete class
- Class list (without pagination)

### Student Management (`/students`)
- Query student list (pagination, conditional filtering)
- Add new student
- Edit student information
- Bulk delete students
- Discipline handling (point deduction)

### Data Reports (`/report`)
- Employee position statistics
- Employee gender statistics
- Student education level statistics
- Student count per class statistics

### Log Management (`/log`)
- Query operation logs
- Paginated display

### File Upload (`/upload`)
- Aliyun OSS file upload

### Login Authentication (`/login`)
- User login
- JWT token authentication

## Project Structure

```
tlias-management/
├── tails-manergement/          # Front-end project
│   ├── src/
│   │   ├── api/                # API interfaces
│   │   │   ├── clazz.js
│   │   │   ├── dept.js
│   │   │   ├── emp.js
│   │   │   ├── log.js
│   │   │   ├── login.js
│   │   │   ├── report.js
│   │   │   └── stu.js
│   │   ├── assets/             # Static resources
│   │   ├── router/             # Routing configuration
│   │   ├── stores/             # State management
│   │   ├── utils/              # Utility functions
│   │   ├── views/              # Page components
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
└── web-ai-project02/           # Back-end project
    └── hr-manegement/
        ├── src/main/java/com/hr/
        │   ├── anno/            # Custom annotations
        │   │   └── Log.java
        │   ├── aop/             # Aspect-oriented programming
        │   │   └── OperationLogAspect.java
        │   ├── config/          # Configuration classes
        │   │   └── WebConfig.java
        │   ├── controller/      # Controllers
        │   │   ├── ClazzController.java
        │   │   ├── DeptController.java
        │   │   ├── EmpController.java
        │   │   ├── EmpLogController.java
        │   │   ├── LoginController.java
        │   │   ├── ReportController.java
        │   │   ├── SessionController.java
        │   │   ├── StudentController.java
        │   │   └── UploadController.java
        │   ├── exception/       # Exception handling
        │   │   ├── BusinessException.java
        │   │   └── GlobalExceptionHandler.java
        │   ├── filter/          # Filters
        │   │   ├── DemoFilter.java
        │   │   ├── TokenFilter.java
        │   │   └── XyzFilter.java
        │   ├── interceptor/     # Interceptors
        │   │   ├── DemoInterceptor.java
        │   │   └── TokenInterceptor.java
        │   ├── mapper/          # MyBatis Mappers
        │   ├── pojo/            # Entity classes
        │   ├── service/         # Business logic
        │   │   └── impl/
        │   └── utils/           # Utility classes
        │       ├── AliyunOSSOperator.java
        │       ├── AliyunOSSProperties.java
        │       ├── CurrentHolder.java
        │       └── JwtUtils.java
        └── src/main/resources/
            ├── application.yml
            └── com/hr/mapper/   # Mapper XML files
```

## Quick Start

### Start Front-end

```bash
# Navigate to the front-end project directory
cd tails-manergement

# Install dependencies
npm install

# Start development server
npm run dev
```

### Start Back-end

```bash
# Navigate to the back-end project directory
cd web-ai-project02/hr-manegement

# Start using Maven
mvn spring-boot:run
```

## Configuration Guide

### Back-end Configuration File (`application.yml`)

Key configuration items:
- Database connection
- JWT secret key and expiration time
- Aliyun OSS configuration
- File upload size limits

### Front-end Configuration

The front-end encapsulates an Axios instance via `src/utils/request.js`, configuring request and response interceptors.

## System Features

1. **Operation Logging**: Automatically logs method calls using the `@Log` annotation
2. **JWT Authentication**: Stateless token-based authentication mechanism
3. **File Upload**: Supports Aliyun OSS cloud storage
4. **Unified Exception Handling**: Global exception capture and handling
5. **Transaction Management**: Transaction configuration for Service layer methods
6. **Paged Query**: Supports pagination and conditional filtering

## License

This project is intended solely for learning and communication purposes.