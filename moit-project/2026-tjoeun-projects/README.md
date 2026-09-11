# 🚀 MOIT Project History

MOIT는 목적형 모임 커뮤니티 플랫폼으로, 기술 스택을 발전시키며 여러 버전으로 개발한 프로젝트입니다.

| Version | Tech Stack                                              | 주요 내용                               |
| ------- | ------------------------------------------------------- | ----------------------------------- |
| **v1**  | Spring Framework, JSP, MyBatis, MySQL, Ajax             | 기본 기능 구현 (회원)   |
| **v2**  | Spring Boot, Thymeleaf, MyBatis, Oracle, Ajax, Open API | Spring Boot 기반으로 프로젝트 리팩토링 및 기능 고도화 |
| **v3**  | Spring Boot, Gradle, JPA, MyBatis, Oracle, JWT, Redis, OAuth2, React, Next.js, Ant Design                                                    | 회원관리 및 인증·인가 기능 고도화                      |
| **v4**  | (예정)                                                    | 추가 기능 개발                            |

## 📂 Version Details

### MOIT v1

* **Tech Stack:** Spring Framework, JSP, MyBatis, MySQL, Ajax
* **Features:** 기본 회원관리 및 서비스 기능 구현
* 📁 README: moit-v1/README.md
* 📖 Notion: https://app.notion.com/p/MoA-37195798f73380cebe19e12b11b69dad?source=copy_link

### MOIT v2

* **Tech Stack:** Spring Boot, Thymeleaf, MyBatis, Oracle, Ajax, Open API
* **Features:** Spring Boot 기반 프로젝트 구조 개선 및 기존 회원 기능 고도화
* 📁 README: moit-v2/README.md
* 📖 Notion: https://app.notion.com/p/MoA-37195798f73380cebe19e12b11b69dad?source=copy_link

### MOIT v3

* **Tech Stack:** Spring Boot, Gradle, JPA, MyBatis, Oracle, JWT, Redis, React, Next.js, Ant Design
* **👤 담당 업무 — 회원관리 / 인증·인가**
  * *** 회원가입 및 회원관리 ***
  * 일반 회원가입 및 로그인 API 구현
  * 회원정보 조회 및 수정 기능 구현
  * 비밀번호 변경 및 프로필 이미지 관리
  * 아이디 찾기 및 비밀번호 재설정 기능 구현
  * 회원 상태 및 회원 유형 관리
  * 관리자 회원 조회·검색·상태 관리 기능 구현
  * *** 인증·인가 ***
  * Spring Security 기반 인증·인가 구현
  * JWT 기반 Access Token / Refresh Token 인증 구조 구현
  * Access Token 만료 시 Refresh Token을 이용한 재발급 처리
  * Redis 기반 Refresh Token 관리
  * 회원 유형에 따른 접근 권한 제어
  * *** 소셜 로그인 ***
  * OAuth2 기반 소셜 로그인 구현
  * 최초 소셜 로그인 사용자의 추가 회원정보 입력 처리
  * 소셜 로그인 이후 회원가입 및 인증 Flow 구성
  * *** 회원 보안 ***
  * 이메일 인증 기능 구현
  * 비밀번호 유출 여부 검사 적용
  * 회원정보 및 인증 데이터의 보안 관리
  * *** 프론트엔드 연동 ***
  * Next.js 기반 회원관리 화면 구현
  * Axios를 활용한 회원 관련 REST API 연동
  * 로그인 상태 및 사용자 정보 관리
  * 회원 유형별 화면 및 접근 경로 처리

* 📁 README: moit-v3/README.md
* 📖 Notion: https://app.notion.com/p/MoA-37195798f73380cebe19e12b11b69dad?source=copy_link
