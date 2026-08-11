
1. CSR VS SSR
- SSR : 서버가 웹페이지에 렌더링 , 초기속도가 빠르고 / 서버 부하가 커지고, 깜빡임
- CSR : 브라우저가 웹페이지를 렌더링 , 화면 바뀜(처리속도) 빠름 / 초기속도 느림  

2. 기술스택
- SSR + CSR
[PROJECT]
ㄴ BACK  : boot  + jpa  + oracle  + (Mybatis) + jwt + redis
ㄴ FRONT : react + next + antd

스프링4STS + docker + redis

### 1. BACK
1. JAVA 17
2. SPRING BOOT (gradle)
3. security + jwt + redis + oauth2.0 + jpa + mybatis + oracle

1) spring boot     - 애플리케이션 기반의 프레임워크 / 특징 : 내장 Tomcat이 설정되어있음 / 자동설정
2) spring security - 인증(본인여부 확인), 인가(어디까지 사용가능한지?) / 필터체인의 요청 보호 / oauth2.0(외부인증 - 카카오, 네이버, 구글)와 쉬운 연동
3) mybatis         - xml sql 복잡한* 쿼리 작성
4) jwt             - json web token  / 토큰 기반의 인증방식
                     토큰 안에 사용자의 정보와 권한을 담아서 전달,
                     서버가 세션을 직접 관리하지 않고, 
                     클라이언트가 토큰을 보관
5) redis           - 캐시 & 세션 관리 , 서버가 가벼워짐 , refresh token을 저장 , 
                     캐싱처리(자주 사용하는 값을 미리 넣어놓고 요청이 있을때 서버를 거치지 않고 빠르게 제공)에 활용
                        
                        사용자 화면  
                          redis
                     a      b       c   
6) jpa             - sql 작성없이 객체 중심의 처리      

##### [실습]  1. 스프링부트 프로젝트 
- [x] 1. 개발개요안내
- [x] 2. java.sun.com - JAVA 17 다운로드 - 설치
- [x] 3. SPRING BOOT   - https://spring.io/ - 다운로드 - 설치
  > 이전버젼
  https://github.com/spring-projects/spring-tools/wiki/Previous-Versions
- [ ] 4. SPRING BOOT 프로젝트 만들기
- [ ] 5. lombok

##### [실습]  2. docker 설치
1. docker 설치
- https://www.docker.com/products/docker-desktop/   (AMD)
- 다운로드 및 설치 → 1. window 업데이트   /  2. USE WSL 2 instead .... 체크 확인

```bash
wsl --update
```

```bash
java --version
docker --version
docker ps
```

2. redis 설치 
```
docker pull  redis
docker run   -d  --name  my-redis  -p 6379:6379   redis

docker  exec  -it  my-redis  redis-cli
docker  exec  -it  my-redis  redis-cli  FLUSHALL
keys *
get  저장이름
```
<필기>
docker pull  redis  -- 최신버전 redis 다운로드 
    docker run      -d      --name  my-redis          -p 6379:6379   redis
--> 생성 및 실행   백그라운드     생성될 이름        내컴퓨터(6379) 번호로 내부의 6379로 연결   

docker  exec      -it                        my-redis  redis-cli
-->     실행      i: 표준입력 / t: 가상터미널

docker  exec  -it  my-redis  redis-cli  FLUSHALL
keys *
get  저장이름


1.  JWT  VS  세션
- 세션 : 서버 메모리에 사용자 상태를 저장 →  서버확장시 부담  
                                    (서버에서 출입명단 직접 들고 있는 것)
- JWT(Json Web Token) : 토큰 자체에 인증정보를 포함  → 확장성
                                    (사용자가 출입증을 직접 들고다니기)

2.  Access  Token vs  Refresh Token 
1) Access  Token :  짧은 기간 유효(출입증)    → api 호출 시 사용    
2) Refresh Token :  긴   기간 유효(장기체류증) →  redis 냉장고에 안전보관   

3. Redis 사용이유?
- 토큰냉장고 → 장기체류증 안전하게 보관, 필요시 꺼내 씀
- Refresh Token 중앙에서 관리
- TTL(만료 시간)로 자동 만료처리
- 로그아웃 시 즉시 삭제  

##### [실습] 3. oracle 유저셋팅
```sql
-- cmd
-- sqlplus
-- conn  system/1234
 
-- 유저만들기 ( 오라클 12 이상에서 기존방식으로 사용자 생성 허용 )
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
create user boot  identified by react;

-- 권한부여
grant  connect , resource  to boot;

ALTER USER boot DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;    -- 물리적공간이용
grant  create table to boot;

```

##### [실습] 4. Boot + React - ver1 (기본 게시판 + 회원가입)

1. board
- 1. project
- 2. 부품객체 () : gradle - refresh gradle 해야함!!
  ※ https://mvnrepository.com/
- 3. application.yml
```
spring:
  datasource:
    url: jdbc:oracle:thin:@localhost:1521/XE     # jdbc url 설정
    username: boot                               # 사용자 계정
    password: react                              # 사용자 암호
    driver-class-name: oracle.jdbc.OracleDriver  # oracle, mysql...

  jpa:
    hibernate:
      ddl-auto: update    # 엔티티 변경사항 : DB테이블 자동으로 변경사항 반영
                          # update : 수정반영, 기존데이터 유지 / create-drop : 생성후 삭제, 매번 초기화
                          # 배포할때는 none(기본), validate
    properties:
      hibernate:
        format_sql: true  # 콘솔 및 로그에 출력되는 sql 들여쓰기 속성
        show_sql: true    # sql 쿼리 문장을 그대로 로그 출력

  servlet:
    multipart:
      enabled: true           # 파일 업로드처리 기능 활성화
      max-file-size: 10MB     # 업로드하는 최대허용 용량
      max-request-size: 20MB  # 한번에 전송되는 총 용량    

  data:
    redis:
      host: localhost   # redis 연결주소 
      port: 6379        # 서버 포트
      timeout: 2000     # 서버와 연결 대기시간

  config:
    import: 
      - optional:application-oauth.yml   # api 설정관련
      - optional:file:.env[.properties]  # .env 파일 실제 보관 키

mybatis:
  config-location: classpath:mybatis-config.xml  # 전역 설정파일
  mapper-locations: classpath:mapper/**/*.xml    # mapper 경로패턴
  type-aliases-package: com.thejoa703.domain     # 도매인 설정

jwt:
  issuer: thejoa703                    # jwt 토큰 발행한 주체자
  secret: ${JWT_SECRET}                # 사용한 비밀 키
  access-token-exp-seconds: 900        # 유효시간
  refresh-token-exp-seconds: 1209600   # 유효시간
  header: Authorization                # http 토큰 전달시 http 요청헤더 이름 지정
  prefix: Bearer                       # 토큰 앞에 붙는 이름(접두사)  

file:
  upload-dir: uploads  # 업로드된 파일 설정 경로

#server:
#  port: 8484 
```

  ※ (oracle DB : table) → mapper     → dto → service → controller → view
  ※ @Entity             → repository → dto → service → controller → view

- 4. entity (테이블을 객체로 처리)
  back1
    ㄴ src/main/java
      ㄴ com.thejoa703.entity
        - AppUser
        - Post

  A. JPA
  - ORM(Object-Relational Mapping)
  부품객체(자바클래스)와 RDB(관계형 데이터베이스)의 불일치 해결하려고
  SQL중심이 아니라 객체 중심으로 데이터를 다룰 수 있게 해주는 기술

  - 1. @Entity  -  DB의 테이블과 mapping 
  - 테이블 컬럼 변경시 SQL을 일일이 수정할 필요 없이 엔티티 클래스만 수정하면 됨
  - 데이터베이스 방언(Dialect) 지원 - oracle, mysql 특정데이터에 종속

  - 2. JpaRepository - DB에 접속해서 crud 작업을 처리하는 인터페이스
  - 3. 외래키 설정
    > 한 사람이 여러 글을 쓸 수 있다.

    > AppUser
    @OneToMany

    > Post
    @ManyToOne
    ```
    ```
    
- 5. Repository
back1
  ㄴ src/main/java
    ㄴ com.thejoa703.repository
      - AppUserRepository
      - PostRepository
https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html  

- 6. Dto
back1
  ㄴ src/main/java
    ㄴ com.thejoa703.dto
      - UserDto
      - PostDto 

- 7. Service
back1
  ㄴ src/main/java
    ㄴ com.thejoa703.service
      - UserService
      - PostService 

- 8. Controller
back1
  ㄴ src/main/java
    ㄴ com.thejoa703.controller
      - UserController
      - PostController

1. User Api    - 사용자 관련 API
- POST     /api/users        회원가입  ※ createUser
- GET      /api/users/{id}   사용자 단건조회 ※ getUser

2. Post API     - 게시글 관련 API
- GET      /api/posts/{id}      게시글 단건 조회 ※ getPostById
- PUT      /api/posts/{id}      게시글 수정 ※ updatePost
- DELETE   /api/posts/{id}      게시글 삭제 ※ deletePost
- GET      /api/posts      전체 게시글 조회 ※ getAllPosts or getPostPaged
- POST     /api/posts      게시글 작성  ※ createPost    

※ Swagger는 갱신 안되므로 서버 재부팅!

---------------------------------

- 9. View   

1. 회원가입
   ↓
2. 마이페이지
   ↓
3. 글쓰기
   ↓
4. 글수정   
   ↓
5. 글삭제   

front/
├── .next/                  # Next.js 빌드 결과물 (자동 생성, 배포 시 사용)
├── components/         # 재사용 가능한 UI 컴포넌트 폴더
│   └── Layout.js         # 페이지 공통 레이아웃 컴포넌트
├── node_modules/       # 설치된 npm 패키지들
├── pages/                  # Next.js 라우팅 기반 페이지 폴더
│   ├── posts/             
│   │  └──new.js       #  글쓰기 파일
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   ├── signup.js              # 회원가입
│   ├── mypage.js         # 마이페이지
│   └── index.js            # 메인 페이지
├── reducers/               # Redux 리듀서 폴더
│   ├── __tests__/       
│   │  ├── post.test.js        # 게시판 테스트 코드 
│   │  └── user.test.js        # 리듀서 테스트 코드
│   ├── index.js            # 루트 리듀서 (combineReducers)
│   ├── authReducer.js             # 사용자 관련 리듀서
│   └── postReducer.js             # 게시판 관련 리듀서 
├── sagas/                  # Redux-Saga 폴더
│   ├── __tests__/       
│   │  ├── post.test.js        # 게시판 사가 테스트 코드
│   │  └── user.test.js        #  유저   사가  테스트 코드
│   ├── index.js            # 루트 사가
│   ├── authSaga.js             # 사용자 관련 사가
│   └── postSaga.js             # 게시판 관련 사가 
├── store/                  # Redux 스토어 설정 폴더
│   ├── configureStore.js   # Redux 스토어 설정
│   └── configureStore.test.js # 스토어 테스트 코드
├── styles/                 # CSS 스타일 폴더
│   └── globals.css         # 글로벌 스타일
├── .babelrc                # Babel 설정 파일
├── .eslintrc               # ESLint 설정 파일
├── package-lock.json       # npm 의존성 잠금 파일
├── package.json            # 프로젝트 메타 정보 및 의존성
└── setupTests.js           #  테스트 환경 설정 파일


step1) 프로젝트만들기
```
mkdir front
cd front
npm init
```

step2) 기본셋팅(store)
```
package.json 셋팅
npm install
```
step3) Reducer
step4) saga
step5) view
1. Layout
2. 경로
```
├── pages/                  # Next.js 라우팅 기반 페이지 폴더
│   ├── posts/             
│   │  └──new.js       #  글쓰기 파일
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   ├── signup.js              # 회원가입
│   ├── mypage.js         # 마이페이지
│   └── index.js            # 메인 페이지
```

<Link href="/">            index.js          # 메인 페이지
<Link href="/mypage">      mypage.js         # 마이 페이지
<Link href="/signup">      signup.js         # 회원가입
<Link href="/posts/new">   posts/new.js      # 글쓰기 파일

##### [■실습]  4.   Boot + React  - ver1  (기본게시판 + 회원가입)

##### [실습]  5.   Boot + React + 세션/쿠키  - ver2  (기본게시판 + 회원가입 + 이미지 / 해쉬태그 / 좋아요 / 팔로우)
※ entity → repository  → service  →  controller 

- 람다식 참고 p479 (자바책)
- day028 

■ 과정명   : [취업기업확대]AI활용 풀스택(프론트엔드,백엔드)부트캠프(자바,파이썬,플러터)
■ 훈련과목 : (비NCS)프로젝트(완성된 웹서비스 플랫폼 프로젝트 리뉴얼)
> 
> python + django
> flutter

※ 참고)  PostController  
      - list 항목가져오기 
      - 람다식참고 : p479  (자바책)
      - day028 : https://hi-sally03915.tistory.com/1980

■10주
> 1. 포트폴리오 완성 ~9월초
  - boot + security + jwt + redis / jpa(mybatis) + oracle/react + next → aws (9월초까지)

---

<포트폴리오>
1. 2차 프로젝트를 RestController로 변경
> 테이블 + Dto + mapper + service + controller(RestController: swagger)

2. 3차 새로 만들것들
  1) @Entity (새로만들거만) > Repository > Service > RestController
  2) mybatis는 건들 X, 사용 가능한것들은 사용(그대로 가져가기)
  3) Security + jwt + redis

--- 

> 2. 이력서 + 회사지원 ~10월
  - python + django
  - flutter

  - 리팩토링 개별
  - backend : jpa + @entity

##### [실습]  6.   Boot + React + jwt+ security+redis  - ver3  (기본게시판 + 회원가입 + 이미지 / 해쉬태그 / 좋아요 / 팔로우 )


## (1) : 회원가입 + board (crud)
## (2) : 멤버기능 + board (이미지업로드, 해쉬태그, 좋아요 - crud)
boot2 - 프로젝트 만들기
- table    →  mapper     (dto) → service → controller
- @Entity  →  repository (dto) → service → controller

1) 유저는 많은 글을 쓸 수 있다.
<AppUser> → <Post>
```
<AppUser>
@OneToMany( mappedBy = "user" ,cascade = CascadeType.ALL, orphanRemoval = true )
private List<Post> posts = new ArrayList<>(); 

<Post>
@ManyToOne   //1. 다대일 (테이블의 필드명)
@JoinColumn(name="APP_USER_ID" , nullable = false)
private AppUser user; 
```

2) 글은 많은 이미지를 갖는다.
<Post> → <Image>

```
<Post>
@OneToMany(mappedBy = "post" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

<Image>
@ManyToOne
	@JoinColumn(name = "POST_ID", nullable = false) // POST_ID 외래키 (FK) POST엔티티의 PK(ID) 참조
	private Post post;
```

3) 글은 많은 해쉬태그를 갖는다.  /  해쉬태그는 많은 글을 갖는다.
  1) 다 : 다
  2) 중간 테이블 사용
<Post> → <HashTag> 여러 글은 많은 해쉬태그를 갖는다.
@ManyToMany

<HashTag> → <Post>  여러 해쉬태그는 많은 글을 갖는다.

<Post>                  <Hashtag>
content                 1 test123
deleted                 2 like
    ↔ <Post_Hashtag> ↔ 
            1 1
            1 2

            2 1
            2 2
          1번글 test 123
          1번글 like    

```
<Post>
@ManyToMany
    @JoinTable(name = "POST_HASHTAG",
    	joinColumns = @JoinColumn(name = "POST_ID"),
    	inverseJoinColumns = @JoinColumn(name = "HASHTAG_ID")
    )
    private List<Hashtag> hashtags = new ArrayList<>();

<Hashtag>
@ManyToMany(mappedBy = "hashtags")
	private List<Post> posts = new ArrayList<>();

```  

4) 글은 많은 좋아요를 갖는다.
하나의 글에 여러 유저가 좋아요를 누를 수 있다.
<Post>                                     <POST_LIKE>
@OneToMany   List<POST_LIKE> likes;        @ManyToOne AppUser user;
@OneToMany   List<POST_LIKE> likes;        @ManyToOne Post    post;
<AppUser>
                                          좋아요 번호  글번호  유저번호
                                          1           1      1
                                          2           1      2
                                          3           1      3
                                          4           2      2
                                          5           2      3
       

5) 리트윗

6) 팔로우

■ 멤버관리
회원가입 (이메일 중복검사, 닉네임 중복검사) 
↓
로그인 
↓
마이페이지 (닉네입변경, 프로필 이미지변경, 회원탈퇴, 로그아웃) ※ 팔로워 / 팔로잉

1) UserDto : UserRequestDto / UserResponseDto 
UserRequestDto  < email, password, nickname, *image(ufile: Multipart 빠짐) / provider, mobile, mbtitype>
UserResponseDto < email,     role, nickname, ufile / provider >

2) LoginRequest < email, password, provider >

■ 게시글관리
게시글 작성
↓
게시글 목록 ( 전체 글 / 좋아요한 글 / 내 글 + 리트윗 )
※ 1. 각 세부내용 / 수정 / 삭제 

※ 2. 좋아요, 리트윗, 댓글

[5] RestController

> Ver2. frontend

1. 프로젝트 만들기
```
mkdir front2
cd front2
npm init
```

2. 프로그램 설치
```
npm install
```

3. 개발
1) reducer
2) saga
3) page



4. 보안 + 시큐리티
0) 프로젝트 복사

1) 설정파일 : bulid.gradle 시큐리티 / .env (필요한 설정파일)
   각종 설정파일 : WebConfig (세션, 쿠키 - false / jwt)

2) security : Jwt + Redis
  com.thejoa703.security
    ㄴ JwtAuthenticationFilter (4) 출입증 검사
    ㄴ JwtProperties   (1) Jwt 토큰
    ㄴ JwtProvider     (2) 발급
    ㄴ TokenStore      (3) Redis 보관 / RedisConfig / SecurityConfig


3) OAuth2 : 소셜 처리 (구글/카카오/네이버 인증)
  com.thejoa703.oauth2
    ㄴ UserInfoOAuth2 (1) 소셜 공통속성 추출
    ㄴ UserInfoGoogle / UserInfoKakao / UserInfoNaver  (2) 각 소셜마다 처리
    ㄴ CustomOAuth2User (3) Security : local + Oauth2 : 소셜 - 유저정보
    ㄴ OAuth2SuccessHandler (4) 로그인시 - Redis / Jwt 설정 (소셜 로그인시 유저저장, 토큰 설정)

4) Service - 기존활용
  ㄴ AuthUserJwtService (유저정보 활용)
5) Controller
  ㄴ UserController (로그인시 - access Token, refresh Token / cookie 설정)
  ㄴ post에서 AuthUserJwtService 활용해서 가져오기
6) react 

STEP1)
```
[사용자]
   ├─▶ 로컬 회원가입/로그인
   │       - 이메일/비밀번호 (local) → DB 저장
   │       - 로그인 성공 시 JWT 발급
   │
   └─▶ 소셜 로그인(OAuth2)
           - 구글/카카오/네이버 인증
           - OAuth2SuccessHandler 실행
             • 사용자 정보 추출
             • DB 저장/조회
             • Access Token 발급 (출입증)
             • Refresh Token 발급 (장기체류증) → Redis 저장 + 쿠키
```

STEP2)
```
[프론트엔드]
   └─▶ Access Token localStorage 저장
        API 호출 시 Authorization 헤더에 Bearer 붙임
```

STEP3)
```
[Spring Boot 서버]
   ├─▶ JwtAuthenticationFilter
   │       - 토큰 검증 (출입증 검사)
   │       - SecurityContext에 사용자 정보 저장
   │
   └─▶ Controller/Service
           - userId 기반 DB 조회
           - 응답 반환 (사원증 스캔)
```

■ 핵심정리
1. JWT vs Session
- 세션 : 서버 메모리에 사용자 상태를 저장 → 서버 확장시 부담
        (서버에서 출입명단을 직접 들고 있기)
- JWT (Json Web Token) : 토큰 자체에 인증정보를 포함 → 
        (사용자가 직접 출입증을 들고 다니기)

2. Access Token vs Refresh Token
- Access Token  : 짧은 기간 유효 (출입증) → api 호출시 사용
- Refresh Token : 긴 기간 유효(장기체류증) → redis 냉장고에 보관 (안전보관)

3. Redis 사용
- 토큰 냉장고 → 장기 체류증 안전하게 보관, 필요시 꺼내쓰기
- Refresh Token 중앙에서 관리
- TTL (만료시간)로 자동만료 처리
- 로그아웃 시 즉시 삭제

4. 구조확인)
1) security + jwt + redis
  - JwtProperties  : 토큰 
    * secret, issuer, expSeconds 기본속성
  - JwtProvider    : 토큰 제공(발급) / 검증
    AccessToken(출입증)
    RefreshToken(장기)
  - TokenStore     : 토큰 저장소
    Redis 저장소, RefreshToken
  - JwtAuthenticationFilter  : 보안 게이트
    * 매 요청마다 Authorization 헤더 확인 → 토큰 검증 → SecurityContext에 사용자 정보저장
    * api 사용시 신분증 검사하는 게이트

2) oauth2.0
  - OAuth2  : 입국 심사대
  - UserInfoOAuth2 / UserInfoNaver , UserInfoKakao , UserInfoGoogle
  - CustomOAuth2User
  - OAuth2SuccessHandler

3) 설정파일
  - SecurityConfig
  - WebConfig
  - RedisConfig
  - SwaggerConfig

4) jwt 구조

1. Header → 토큰의 머릿말 ( 이 토큰은 HS256 알고리즘으로 서명했어!  정보 )
```json
   { "alg": "HS256", "typ": "JWT" }
```
2. Payload(Claims)   →  토큰의 몸통 ( 누가, 어떤권한, 언제까지  사용자의 신분증정보)
```json
   {
     "iss": "thejoa703",   // 발급자
     "sub": "12345",       // 사용자 ID
     "role": "USER",       // 권한
     "email": "user@test.com",
     "exp": 1737000000     // 만료 시간
   }
```
3. Signature     →  토큰의 도장 ( 서버만 아는 비밀키로 찍은 도장 → 위변조 방지)
```json
   HMACSHA256(base64UrlEncode(header) + "." + base64UrlEncode(payload), secret)
```

1. boot
1) docker → redis
3) boot 구동

2. react
1) 폴더만들기
2) 프로젝트 설치
3) reducer → saga → page
4) jwt 사용
front3
ㄴ api/axios.js
ㄴ pages
  ㄴ signup.js
  ㄴ login.js
  ㄴ mypage.js

```
mkdir front3
cd front3
front2 프로젝트 .next / node_module 빼고 안에 콘텐츠 넣기
npm install
```