use mbasic;

show tables;

desc t1;

drop table t1;
drop table t2;

set sql_safe_updates=0;

-- 부모테이블
create table t1(
no int not null primary key auto_increment,
name varchar(100)
);

-- 자식테이블
create table t2(
ino int not null primary key ,
foreign key(ino) references t1(no)
); -- 외래키 (ino) 참고테이블 t1(no필드) 

insert into t1(no, name) values(1, 'first');
insert into t1(no, name) values(2, 'second');

select * from t1;

insert into t2 (ino) values(1);
insert into t2 (ino) values(3);
-- Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails 
-- (`mbasic`.`t2`, CONSTRAINT `t2_ibfk_1` FOREIGN KEY (`ino`) REFERENCES `t1` (`no`))

select * from t2;

create table t3(
no int not null primary key auto_increment,
name varchar(100)
);

create table t4(
ino int not null primary key ,
foreign key(ino) references t3(no) on delete cascade on update cascade
);

select * from t3;
select * from t4;

insert into t3(no, name) values(1, 'first');
insert into t3(no, name) values(2, 'second');
insert into t4 (ino) values(2);

update t3 set no=20 where no=2;
delete from t3 where no=20;