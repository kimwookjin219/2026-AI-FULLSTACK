use mbasic;

create table mvcboard1 (
 bno int not null auto_increment primary key,
 bname varchar(200) not null,
 bpass varchar(50) not null,
 btitle varchar(1000) not null,
 bcontent text not null,
 bdate timestamp not null,
 bhit int not null default '0',
 bip varchar(50) not null
);

desc mvcboard1;

alter table mvcboard1 modify bdate timestamp not null default current_timestamp;

insert into mvcboard1 (bname,bpass,btitle,bcontent,bip) values ('aa',1234,'첫글','안녕하세요','123.456.789');

select * from mvcboard1;