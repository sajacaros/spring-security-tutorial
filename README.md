# 🔐 Spring Security Demo

Spring Security를 사용한 기본 인증 및 권한 관리 예제 프로젝트입니다.

## 📋 프로젝트 개요

이 프로젝트는 Spring Security의 기본 기능들을 학습하기 위한 튜토리얼 애플리케이션입니다.

## 🛠️ 기술 스택

- **Spring Boot** 3.x
- **Spring Security** 6.x
- **Spring Data JPA**
- **H2 Database** (인메모리)
- **Lombok**

## 🚀 주요 기능

### 1. 사용자 관리
- 사용자 생성 및 관리
- 역할 기반 권한 시스템 (USER, ADMIN)
- 커스텀 UserDetailsService 구현

### 2. 보안 설정
- 폼 기반 로그인
- 역할별 접근 제어
- H2 Console 접근 허용

### 3. 엔드포인트
- `/` - 모든 사용자 접근 가능
- `/info` - USER 역할 이상 접근 가능
- `/dashboard` - ADMIN 역할만 접근 가능

## 📁 프로젝트 구조

```
src/main/java/kr/study/securitydemo/
├── SecurityDemoApplication.java     # 메인 애플리케이션
├── configure/
│   └── WebSecurityConfig.java      # Spring Security 설정
├── controller/
│   └── SampleController.java       # REST 컨트롤러
├── domain/
│   └── Member.java                 # 사용자 엔티티
├── repository/
│   └── MemberRepository.java       # 사용자 리포지토리
├── service/
│   └── MemberService.java          # 사용자 서비스
└── type/
    └── Role.java                   # 역할 enum
```

## 🔧 실행 방법

### 1. 프로젝트 클론
```bash
git clone <repository-url>
cd {Project Name}
```

### 2. 애플리케이션 실행
```bash
./gradlew bootRun
```

### 3. 접속 정보
- 애플리케이션 URL: `http://localhost:8080`
- H2 Console: `http://localhost:8080/h2-console`

## 👥 기본 사용자 계정

애플리케이션 시작 시 자동으로 생성되는 테스트 계정:

| 사용자명  | 비밀번호 | 역할 |
|-------|---------|------|
| user  | 123 | USER |
| admin | 123 | ADMIN |

## 🧪 테스트 방법

### 1. 기본 페이지 접속
- `http://localhost:8080/` - 로그인 없이 접근 가능

### 2. 권한이 필요한 페이지 접속
- `http://localhost:8080/info` - USER 권한 필요
- `http://localhost:8080/dashboard` - ADMIN 권한 필요

### 3. 로그인 테스트
1. 위 페이지에 접속하면 로그인 페이지로 리다이렉트
2. 기본 사용자 계정으로 로그인
3. 권한에 따른 페이지 접근 확인

## 미션1
- spring security의 전반적인 처리 과정을 설명하시오.
- https://docs.spring.io/spring-security/reference/servlet/architecture.html
## 미션2
- spring security 인증하는 과정을 설명하시오.
- https://docs.spring.io/spring-security/reference/servlet/authentication/architecture.html
## 미션3
- spring security 인가하는 과정을 설명하시오.
- https://docs.spring.io/spring-security/reference/servlet/authorization/architecture.html
## 미션4 - 실습
- ADMIN이 `/info`에 접근가능하게 수정하시오. 단, 유저-권한 매핑테이블에 USER 권한을 추가로 설정하진 마시오.
