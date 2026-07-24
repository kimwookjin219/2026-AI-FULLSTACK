
1. CSR VS SSR
- SSR : 서버가 웹페이지에 렌더링 , 초기속도가 빠르고 / 서버 부하가 커지고, 깜빡임
- CSR : 브라우저가 웹페이지를 렌더링 , 화면 바뀜(처리속도) 빠름 / 초기속도 느림  

2. 기술스택
- SSR + CSR
[PROJECT]
ㄴ BACK  : boot  + jpa  + oracle  + (Mybatis) + jwt + redis
ㄴ FRONT : react + next + antd

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

