# 🚀 MOIT Project History

![MOIT배너](./images/MOIT배너.png)
MOIT은 목적형 모임 커뮤니티 플랫폼으로, 기술 스택을 발전시키며 여러 버전으로 개발한 프로젝트입니다.

| Version | Tech Stack | 주요 내용 | Link |
| ------- | ---------- | --------- | --------- |
| **v1** | Spring Framework, JSP, MyBatis, MySQL, Ajax | 기본 기능 구현 (회원) | [📂](https://github.com/kimwookjin219/2026-AI-FULLSTACK/tree/main/moit-project/2026-tjoeun-projects/moit-v1) |
| **v2** | Spring Boot, Thymeleaf, MyBatis, Oracle, Ajax, Open API | Spring Boot 기반으로 프로젝트 리팩토링 및 기능 고도화 | [📂](https://github.com/kimwookjin219/2026-AI-FULLSTACK/tree/main/moit-project/2026-tjoeun-projects/moit-v2) |
| **v3** | Spring Boot, Gradle, JPA, MyBatis, Oracle, JWT, Redis, OAuth2, React, Next.js, Ant Design | 회원관리 및 인증·인가 기능 고도화 | [📂](https://github.com/kimwookjin219/2026-AI-FULLSTACK/tree/main/moit-project/2026-tjoeun-projects/moit-v3) |
| **v4** | (예정) | 추가 기능 개발 | [📂]() |

## 📂 Version Details

### MOIT v1

- **Tech Stack:** Spring Framework, JSP, MyBatis, MySQL, Ajax
- **Features:** 기본 회원관리 및 서비스 기능 구현

<details>
<summary>📸 MOIT-V1 화면 보기</summary>

<br>

![회원가입](./images/v1/회원가입1.png)
① 회원가입 — 기본 회원가입 화면
![회원가입](./images/v1/회원가입2.png)
② 회원가입 — 입력 정보 검증

<br><br>

![헤더 / 회원기능](./images/v1/헤더1.png)
③ 헤더 — 로그인 전
![헤더 / 회원기능](./images/v1/헤더2.png)
④ 헤더 — 로그인 후

</details>

- 📁 README: [moit-v1](https://github.com/kimwookjin219/2026-AI-FULLSTACK/tree/main/moit-project/2026-tjoeun-projects/moit-v1)
- 📖 Notion: [MOIT 프로젝트 Notion](https://app.notion.com/p/MoA-37195798f73380cebe19e12b11b69dad?source=copy_link)

---

### MOIT v2

- **Tech Stack:** Spring Boot, Thymeleaf, MyBatis, Oracle, Ajax, Open API
- **Features:** Spring Boot 기반 프로젝트 구조 개선 및 기존 회원 기능 고도화

<details>
<summary>📸 MOIT-V2 화면 보기</summary>

<br>

![회원가입](./images/v2/회원가입.png)
① 회원가입 — 회원 등록

<br><br>

![로그인](./images/v2/로그인.png)
② 로컬로그인 & 소셜로그인

<br><br>

![소셜로그인 추가정보 입력](./images/v2/소셜추가입력.png)
③ 소셜 로그인 — 추가 회원정보 입력

<br><br>

![회원정보 수정](./images/v2/정보수정.png)
④ 회원정보 수정

<br><br>

![회원탈퇴(Soft Delete)](./images/v2/회원탈퇴.png)
⑤ 회원탈퇴 — Soft Delete

</details>

- 📁 README: [moit-v2](https://github.com/kimwookjin219/2026-AI-FULLSTACK/tree/main/moit-project/2026-tjoeun-projects/moit-v2)
- 📖 Notion: [MOIT 프로젝트 Notion](https://app.notion.com/p/MoA-37195798f73380cebe19e12b11b69dad?source=copy_link)

---

### MOIT v3

- **Tech Stack:** Spring Boot, Gradle, JPA, MyBatis, Oracle, JWT, Redis, OAuth2, React, Next.js, Ant Design

#### 👤 담당 업무 — 회원관리 / 인증·인가

**1. 회원가입 및 회원관리**

- 일반 회원가입 및 로그인 API 구현
- 회원정보 조회 및 수정 기능 구현
- 비밀번호 변경 및 프로필 이미지 관리
- 아이디 찾기 및 비밀번호 재설정 기능 구현
- 회원 상태 및 회원 유형 관리
- 관리자 회원 조회·검색·상태 관리 기능 구현

**2. 인증·인가**

- Spring Security 기반 인증·인가 구현
- JWT 기반 Access Token / Refresh Token 인증 구조 구현
- Access Token 만료 시 Refresh Token을 이용한 재발급 처리
- Redis 기반 Refresh Token 관리
- 회원 유형에 따른 접근 권한 제어

**3. 소셜 로그인**

- OAuth2 기반 소셜 로그인 구현
- 최초 소셜 로그인 사용자의 추가 회원정보 입력 처리
- 소셜 로그인 이후 회원가입 및 인증 Flow 구성

**4. 회원 보안**

- 이메일 인증 기능 구현
- 비밀번호 유출 여부 검사 적용
- 회원정보 및 인증 데이터의 보안 관리

**5. 프론트엔드 연동**

- Next.js 기반 회원관리 화면 구현
- Axios를 활용한 회원 관련 REST API 연동
- 로그인 상태 및 사용자 정보 관리
- 회원 유형별 화면 및 접근 경로 처리

<details>
<summary>📸 MOIT-V3 화면 보기</summary>

<br>

![회원가입](./images/v3/signcheck.png)
① 회원가입 — 회원가입 및 입력 검증, LLM 회원가입 도우미

<br><br>

![로그인](./images/v3/login.png)
② 로그인 — 사용자 인증

<br><br>

![회원정보](./images/v3/mypage.png)
③ 마이페이지 — 회원정보 관리

<br><br>

![출석체크](./images/v3/출석.png)
④ 출석체크 — 회원 활동 기능

<br><br>

![이메일/전화번호 인증](./images/v3/인증.png)
⑤ 이메일 / 전화번호 인증 — 회원정보 검증

<br><br>

![로그인 기기 관리](./images/v3/보안센터.png)
⑥ 보안센터 — 로그인 기기 관리

<br><br>

![로그인 기록](./images/v3/로그.png)
⑦ 로그인 기록 — 접속 이력 관리

<br><br>

![관리자 상태변경](./images/v3/관리자.png)
⑧ 관리자 회원관리 — 회원 상태 관리

</details>

- 📁 README: [moit-v3](https://github.com/kimwookjin219/2026-AI-FULLSTACK/tree/main/moit-project/2026-tjoeun-projects/moit-v3)
- 📖 Notion: [MOIT 프로젝트 Notion](https://app.notion.com/p/MoA-37195798f73380cebe19e12b11b69dad?source=copy_link)
- ☁ AWS: [MOIT 프로젝트 AWS](https://app.notion.com/p/MoA-37195798f73380cebe19e12b11b69dad?source=copy_link)

---

### MOIT v4

- **Tech Stack:** (예정)
- **Features:** 추가 기능 개발