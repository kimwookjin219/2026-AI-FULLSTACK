use mbasic;

create table userinfo_e(
  no int not null primary key auto_increment,
  email varchar(100) not null,
  age int
);

desc userinfo_e;

insert into userinfo_e (email,age) values('12@12',11);

show tables;

create table mvcboard2(
  bno int not null primary key auto_increment,
  bname varchar(20) not null,
  bpass varchar(50) not null,
  btitle varchar(1000) not null,
  bcontent text not null,
  bdate timestamp not null default CURRENT_TIMESTAMP ,
  bhit int not null,
  bip varchar(50) not null
);

desc mvcboard2;
select * from mvcboard2;