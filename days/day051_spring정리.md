###  Spring
■ 기술스택 : spring + mysql  + mybatis  + security + jsp/jstl + ajax

- [ ] 1. project 만들기
    1. dynamic web project - project2
    2. configure  - [Convert to Maven Project]
    3. spring      - add Spring project Nature
    4. java se-11 / project facts, build path

- [ ] 2. pom.xml 
    : (.jar)부품객체 다운로드 -> Maven Dependencies에서 확인 가능

 ```
    <dependencies>
   <!-- TEST Unit  --> 
   <!-- https://mvnrepository.com/artifact/junit/junit -->
   <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
   </dependency>
   
   <!-- spring di, context-info  --> 
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
   <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.3.27.RELEASE</version>
   </dependency>
   
   
   <!-- spring test tool --> 
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
   <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>4.3.27.RELEASE</version>
      <scope>test</scope>
   </dependency>
   
   <!-- LOMBOK : getters/setters, constructor, toString -->      
   <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
   <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <version>1.18.18</version>
       <scope>provided</scope>
   </dependency>   
    
    <!--  MYSQL/ORACLE    
   <dependency>
      <groupId>com.oracle.database.jdbc</groupId>
      <artifactId>ojdbc11</artifactId>
      <version>21.9.0.0</version>
   </dependency> -->
   
   <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>8.0.28</version>
   </dependency>
   
   <!-- jdbc -->
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-jdbc</artifactId>
       <version>4.3.20.RELEASE</version>
   </dependency>
         
   <!-- MYBATIS - mapper -->
   <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis</artifactId>
       <version>3.5.6</version>
   </dependency>
   
   <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis-spring</artifactId>
       <version>2.0.6</version>
   </dependency> 
   
   
   <!-- HikariCP : connector pool  -->
   <!-- https://mvnrepository.com/artifact/com.zaxxer/HikariCP -->
   <dependency>
       <groupId>com.zaxxer</groupId>
       <artifactId>HikariCP</artifactId>
       <version>2.7.4</version>
   </dependency>
      
   <!--  sql query  -->   
   <!-- https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4 -->
   <dependency>
       <groupId>org.bgee.log4jdbc-log4j2</groupId>
       <artifactId>log4jdbc-log4j2-jdbc4</artifactId>
       <version>1.16</version>
   </dependency>
      
         
   <dependency>
     <groupId>org.apache.logging.log4j</groupId>
     <artifactId>log4j-core</artifactId>
     <version>2.17.2</version>
   </dependency>
   <dependency>
     <groupId>org.apache.logging.log4j</groupId>
     <artifactId>log4j-api</artifactId>
     <version>2.17.2</version>
   </dependency> 
   <dependency>
     <groupId>org.apache.logging.log4j</groupId>
     <artifactId>log4j-slf4j-impl</artifactId>
     <version>2.17.2</version>
   </dependency>       
      
      
   
   <!-- spring-webmvc -->   
   <!-- spring-webmvc -->   
   <!-- spring-webmvc -->    
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
     <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-webmvc</artifactId>
       <version>4.3.27.RELEASE</version>
     </dependency>
   <!-- jstl -->    
   <!-- jstl -->    
     <!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
   <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
   </dependency>
   
   <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
   </dependency>     
      
      
<!-- img upload -->   
<!-- img upload -->    
   <!-- commons-fileupload -->
   <dependency>
      <groupId>commons-fileupload</groupId>
      <artifactId>commons-fileupload</artifactId>
      <version>1.3.1</version>
   </dependency>

   <!-- commons-io -->
   <dependency>
      <groupId>commons-io</groupId>
      <artifactId>commons-io</artifactId>
      <version>2.11.0</version>
   </dependency>
<!-- img upload -->   
<!-- img upload -->          
      
      
      <!-- SECURITY -->
      <!-- SECURITY -->
      <!-- SECURITY -->
      <!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-core -->
      <dependency>
         <groupId>org.springframework.security</groupId>
         <artifactId>spring-security-web</artifactId>
         <version>4.2.2.RELEASE</version>
         <!-- <version>5.0.7.RELEASE</version> -->
      </dependency>
      <dependency>
         <groupId>org.springframework.security</groupId>
         <artifactId>spring-security-config</artifactId>
         <version>4.2.2.RELEASE</version>
      </dependency>
      <dependency>
         <groupId>org.springframework.security</groupId>
         <artifactId>spring-security-core</artifactId>
         <version>4.2.2.RELEASE</version>
      </dependency>
      <dependency>
         <groupId>org.springframework.security</groupId>
         <artifactId>spring-security-taglibs</artifactId>
         <version>4.2.2.RELEASE</version>
      </dependency>
      <!-- SECURITY -->
      <!-- SECURITY -->
      <!-- SECURITY -->      
      <!-- jackson -->
      <!-- jackson -->
      
      <!-- https://mvnrepository.com/artifact/org.codehaus.jackson/jackson-mapper-asl -->
      <!-- <dependency> <groupId>org.codehaus.jackson</groupId> <artifactId>jackson-mapper-asl</artifactId> 
         <version>1.9.13</version> </dependency> -->
      <dependency>
         <groupId>com.fasterxml.jackson.core</groupId>
         <artifactId>jackson-databind</artifactId>
         <version>2.17.2</version> <!-- 최신 안정 버전 사용 -->
      </dependency>
      <dependency>
         <groupId>com.fasterxml.jackson.core</groupId>
         <artifactId>jackson-core</artifactId>
         <version>2.17.2</version>
      </dependency>
      <dependency>
         <groupId>com.fasterxml.jackson.core</groupId>
         <artifactId>jackson-annotations</artifactId>
         <version>2.17.2</version>
      </dependency>
      
  </dependencies>

  <resources>
       <resource>
          <directory>src/main/resources</directory>
       </resource>
  </resources> 
```

- [ ] 3. web.xml

- [ ] 4. confing  
    1. root-context.xml (namespace : beans,context,jdbc,mybatis)
    - DB 관련
    애플리케이션 전체에서 공통으로 사용하는 객체들을 관리
    주로 비즈니스 계층(Service), DAO, DB 연결 관련 설정이 들어갑니다.

    2. servlet-context.xml (namespace : beans,context,jdbc,mybatis)
    -화면과 컨트롤러
    웹(MVC) 계층 설정
    DispatcherServlet이 관리하는 영역입니다.
    주로 Controller와 View(JSP) 를 연결하는 역할을 합니다.

    3. security-context.xml (namespace : beans,context,jdbc,mybatis)
    Spring Security 관련 설정
    로그인, 로그아웃, 권한 관리, 인증 등을 담당합니다.

- [ ] 5. 각종설정파일
    1. root-context.xml
        - config/db.properties
            DB 접속 정보를 따로 관리하는 파일
            DB 주소, 아이디, 비밀번호 등을 XML에서 분리하여 관리합니다.
        - config/mybatis-config.xml
            MyBatis 전체 설정
            SqlSessionFactory가 읽어가는 설정 파일입니다.
        - config/test-mapper.xml
            SQL을 작성하는 Mapper XML
            실제 SQL문이 들어있는 곳입니다.
        - com.the703.dao.Mapper
            Mapper 인터페이스
            Java 메서드와 XML의 SQL을 연결합니다.

        - resources/log4j2.properties       
            -> 보안관련 : log 
            - 로그기록 분석
            - 어떻게 효율적으로 관리관련 고민

            프로젝트 전체 로그 설정
            로그 출력 레벨과 형식을 관리합니다.
        - resources/log4jdbc.log4j2.properties
            DB에서 실행되는 SQL을 로그로 출력
            MyBatis가 실제로 어떤 SQL을 실행했는지 보여줍니다.
    2. servlet-context.xml 

    3. security-context.xml  

- [ ] 6. 부품테스트
    0. context, ds, sqlSession 
    1. test-mapper.xml / TestMapper (interface)
    select now()    public String now()
.............................................................
.............................................................
- [ ] 7. 개발 - Model
    0) 테이블 
    1) boardDto - com.the703.dto / mybatis-config.xml
    2) BoardMapper , board-mapper.xml - root-context.xml
    3) BoardService, BoardServiceImpl

- [ ] 8. 개발 - Controller
    4) BoardController - Service 사용 - security-context.xml (허용)

- [ ] 9. 개발 - View
    5) [view]-[board]   - csrf


<면접질문>
AI 활용했나? yes
ai 없이 복구 얼마나 걸림?

바이브코딩
목표를 잡고 체크, 공부
기본 코드 뼈대 가지고 어느정도 할 수 있나 

[web.xml]

   <!-- filter multipartFilter -->
   <!-- filter multipartFilter -->
   <filter>
      <filter-name>multipartFilter</filter-name>
      <filter-class>org.springframework.web.multipart.support.MultipartFilter</filter-class>
   </filter>
   <filter-mapping>
      <filter-name>multipartFilter</filter-name>
      <url-pattern>/*</url-pattern>
   </filter-mapping>   
   
    
[META-INF] - [context.xml]

<?xml version="1.0" encoding="UTF-8"?>
<Context  allowCasualMultipartParsing="true" path="/">

    <!-- Default set of monitored resources. If one of these changes, the    -->
    <!-- web application will be reloaded.                                   -->
    <WatchedResource>WEB-INF/web.xml</WatchedResource>
    <WatchedResource>WEB-INF/tomcat-web.xml</WatchedResource>
    <WatchedResource>${catalina.base}/conf/web.xml</WatchedResource>

       <!-- 케시문제 해결 -->
   <Resources cachingAllowed="true" cacheMaxSize="100000"></Resources>
</Context>
