Todo1 : MySQL
Todo2 : JAVA

---

### ■1. MySQL

1) Web basic - HTML + CSS + JS (화면단)
2) JAVA (프로그래밍)
3) MySQL/ORACLE (DB)
4) JSP (HTML + JAVA)

1. MySQL 셋팅


2. Database 만들기

숙제[5월13일까지] : 집에서 MySQL 설치 / 셋팅

---

### ■2. JAVA

숙제[5월18일까지] : Bank프로젝트 JAVA 마무리 <가장 자신있는 버전으로>

옵션 - 파일 입출력 / 채팅창 / Lambda 

---

### ■3. JSP

---

### ■4. 복습문제

1.  데이터베이스 언어
-- DDL(  정의어   )  CREATE, ALTER, DROP 
-- DML( 조작어  )    select, insert, update , delete 
-- DCL( 제어어  )     grant, revoke


2. 다음과 같이 테이블준비
-- DB명     : mbasic    
-- 테이블명: userinfo
-- 필드1 -  필수입력 no    ,  숫자자동증가, 기본키      정수형
-- 필드2 -  필수입력  name  가변형문자열(100)
-- 필드3 -  필수입력  age      정수형
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| no    | int          | NO   | PRI | NULL    | auto_increment |
| name  | varchar(100) | NO   |     | NULL    |                |
| age   | int          | NO   |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)

create table mbasic(
    no int not null primary key auto_increment,
    name varchar(100) not null,
    age int not null
);


3. 다음을 수정  
-- 1. 이메일 필드 추가(add)       email varchar(100)
-- 2. 이메일 필드 수정(change)   email을 email2로  자료형은 varchar(50) 으로 
-- 3. 이메일 필드 수정(modify)   email을 email2로  자료형은 varchar(50) 으로 
-- 4. 이메일 필드 삭제(drop)   