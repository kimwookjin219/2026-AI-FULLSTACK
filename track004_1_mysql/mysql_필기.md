#### 1. MySQL?
> 1. mysql why?
1. DBMS (Database Management System)
-  데이터베이스를 관리해주는 시스템

2. Database?
- Data + Base 
- Data 1. 데이터(수집된 사실,값)  2. 정보(의미 부여)
- Data(의미를 제공하는 데이터) + Base(체계와 구격을 가진 집합)

Q1. 다음 빈칸을 채우시오
      1.     (#1  데이터    )는  수집된 사실이나 값을 의미하고
      2.     (#2   정보   )는  데이터들 중에서 의미를 제공하는 데이터를 의미

3. Database 종류
- Oracle(유료) SI 대기업 공기업쪽에서 주로 사용 / 복구시스템이 좋음
- Mysql 중소기업에서 주로 사용 
- MSSql
등등

> 2. mysql Setting
1. MYSQL 다운로드
       https://dev.mysql.com/
       -Download
       - MySQL Community Server

2. MySQL 설치

3. MySQL 환경설정 (1) path

4. MySQL 환경설정 (2) UTF-8  
chcp 65001  cmd창에서 설정하는 명령어   

#### 2. RDBMS 

> 1. RDBMS (Relational Database Management System)
- 관계형 데이터베이스 관리 시스템
- 테이블들의 관계

> 2. RDBMS 구성요소
- 개체(Entity : Table)
- 관계(Relationship)
- 속성(Attribute : 필드)

  ※ 스키마 - 데이터베이스 구조와 제약조건을 명세정의
     외부스키마 = 사용자뷰
     개념스키마 = 전체적인뷰
     내부스키마 = 저장스키마

  ※ 데이터베이스 설계단계
   #1. 개념적설계 - 요구사항분석 후 개념적 설계 ERD (집을 어떻게? 방 몇개? 주방 어디? .....)
   #2. 논리적설계 - ERD를 이용하여 데이터베이스 스키마를 설계  (방 = 테이블 / 사람 = 엔티티 / 관계 = 외래키)
   #3. 물리적설계 - 테이블 저장구조 설계 ( mysql,oracle,,,,) 
       (실제 건축 자재로 만들기 - mysql,oracle)

> 3. 데이터베이스 언어 ★★ 암기하기!!!
1. 정의어 (DDL = Data Definition Language )
       CREATE, ALTER, DROP             →  CAD
2. 조작어 (DML = Data Manipulation Language )
       INSERT, SELECT, UPDATE, DELETE  →  CRUD
3. 제어어 (DCL = Data Control Language ) 
       GRANT, REVOKE

> 4. [실습] Database 만들기

1. 만들기            : create database db명
2. 확인              : show databases
3. 삭제(※복구안됨..) : drop database db명
4. DB사용            : use db명

1) 접속
 mysql -uroot -p
 pass: 

2) mysql

> 5. [연습]
1. db명 : test , mbasic , db703 3개 db만들기
2. db만들어진것 확인
3. db703 삭제
mysql> create database test;

mysql> create database mbsic;

mysql> create database db703;

mysql> show databases;

mysql> drop database db703;

---
#### 복습문제 

1.   MySQL은 __데이터베이스___ 관리 시스템(DBMS)이다.
2.  (#1 __데이터___)는 수집된 사실이나 값을 의미하고 (#2 __정보__)는 의미를 제공하는 데이터를 의미한다.
3. 대표적인 데이터베이스 종류에는 __Oracle__, __MySQL__, ___MSSQL__ 등이 있다.
4.  RDBMS는 ________ Database Management System의 약자이다.
5. RDBMS의 구성요소는   __개체___, ___관계__, ___속성__ 
6. 데이터베이스 언어
DDL(  정의어   )  CREATE, ALTER, DROP 
DML( 조작어  )    INSERTE, SELECT, UPDATE , DELETE 
DCL( 제어어 )     GRANT, REVOKE

7. 데이터베이스  mbasic, 를 생성하는 SQL 명령어를 작성하시오.
create database mbasic;

8.  생성된 데이터베이스 목록을 확인하는 SQL 명령어를 작성하시오.
show databases;

9. 데이터베이스 db703을 삭제하는 SQL 명령어를 작성하시오.

drop database db703;

#### 3. 테이블

1. RDBMS (Relational Database Management System)
- 관계형 데이터베이스
- 테이블의 관계
- 속성(필드) 연결

2. 테이블 만들기(집 안의 방, 가방 안의 분류표)
DDL(정의 : create, alter, drop) , DML(조작 : ) , DCL(제어 : )
-----------------------------------
CREATE TABLE table명 (
       필드1 자료형 옵션,
       필드2 자료형 옵션
);
-----------------------------------
자료형 : 
       1. 숫자 : int(정수 , 1,2,3), double(실수 , 1.23)
       2. 문자 : char(고정, 남/여), varchar(가변, abc, abcd, abcde)
       3. 날짜 : date, datetime
옵션 : 
       필수입력 - not null
       숫자 자동 증가 - auto_increment
       기본키 - primary key

[실습]
create table t1( 
       name varchar(100) not null,
       age int
 ); 

show tables; -- 전체 테이블 목록 확인
desc t1;     -- 구조확인     

※ ERROR 1046 (3D000): No database selected
use db명

create table t11(
       no int not null,               -- not(안돼) null(빈 공간) 
       name varchar(30) not null
);

create table t12(
       bookid int not null,
       title varchar(100) not null
);

show tables;
desc t12;

mysql> show databases;
mysql> use mbasic;
mysql> status  -- 상태확인

※ 참고사항) not null 필수입력
not null을 지정했으면 무조건(필수로) 입력값을 넣어줘야함

mysql> insert into t1 (age) values (1);
ERROR 1364 (HY000): Field 'name' doesn't have a default value (값넣어!)

mysql> insert into t1 (name, age) values ('aaa', 1);
Query OK, 1 row affected (0.00 sec)

mysql> insert into t1 (name) values ('bbb');
Query OK, 1 row affected (0.00 sec)

mysql> select * from t1;
+------+------+
| name | age  |
+------+------+
| aaa  |    1 |
| bbb  | NULL |
+------+------+
2 rows in set (0.00 sec)

[실습2] auto_increment(숫자 자동증가), primary key(기본키)

create table t2(
       jumin int not null auto_increment primary key,
       name varchar(100) not null,
       age int 
);

※ 참고사항)
insert into  t2 (name, age)  values ('aaa' , 1);   -- 숫자자동증가
insert into  t2 (name)  values ('bbb');            -- 숫자자동증가
insert into  t2 (jumin, name, age)  values (1 , 'ccc' , 1);  -- error 기본키
insert into  t2 (jumin, name, age)  values (3 , 'ccc' , 1);  

mysql> select * from t2;
+-------+------+------+
| jumin | name | age  |
+-------+------+------+
|     1 | aaa  |    1 |
|     2 | bbb  | NULL |
|     3 | aaa  |    1 |  <-- aaa, 1 / aaa,1 구분을 해줄수 있는 필드는  jumin  1,3  
+-------+------+------+
2 rows in set (0.00 sec)

