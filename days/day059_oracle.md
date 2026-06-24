## 1. oraclce

- 데이터베이스 언어
1. 데이터 정의어 (DDL) : Create, Alter, Drop (cad)
2. 데이터 조작어 (DML) : Insert, Select, Update, Delete (crud) ★면접질문 많이 나옴
3. 데이터 제어어 (DCL) : Grant, Revoke


1) oracle 설치
[www.oracle.com](https://www.oracle.com/database/technologies/express-edition-downloads.html)


2) sql developer 설치 (sql 편집)
[Oracle SQL Developer]https://www.oracle.com/database/sqldeveloper/technologies/download/

3) 사용 ★면접질문 많이 나옴
<실습1>
```sql(cmd)
sqlplus
conn system/1234

-- 유저만들기 (오라클 12버전 이상에서는 기존의 방식으로 사용자를 생성 허용 - c#scott / tiger)
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
create user scott identified by tiger;

-- 권한부여
grant connect, resource to scott;

ALTER USER scott DEFAULT TABLESPACE users QUOTA UNLIMITED ON users; -- 물리적 공간 이용
grant create table to scott;
```
<실습2>
```sql(sqldeveloper)

--1. 테이블 만들기
-- 테이블명   자료형   옵션
create table dept(
    deptno number primary key,
    dname varchar2(14),
    loc   varchar2(13)
);

--2. DML (CRUD)


```

## 2. boot

1) spring + jsp
2) spring boot + thymleaf (권장사항 html)
3) 