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
alter table mvcboard2 modify bhit int not null default '0';

alter table mvcboard2 add bfile varchar(500) default 'the703.png';

desc mvcboard2;
select * from mvcboard2;

select bname,bpass, btitle, bcontent, bip, bfile from mvcboard2;

insert into mvcboard2 (bname,bpass, btitle, bcontent, bip, bfile)
    select bname,bpass, btitle, bcontent, bip, bfile from mvcboard2;
    
select * from mvcboard2 order by bno desc limit 0,10;
select * from mvcboard2 order by bno desc limit 10,10;    
select count(*) from mvcboard2;