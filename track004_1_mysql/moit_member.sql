use moit;

show databases;

show tables;

create database moit;

set sql_safe_updates =0;

create table member_type(
    member_type_id int primary key auto_increment,
    type_name varchar(30) unique not null
);

insert into member_type(type_name) value('ROLE_MEMBER');
insert into member_type(type_name) value('ROLE_PARTNER');
insert into member_type(type_name) value('ROLE_ADMIN');
insert into member_type(type_name) value('ROLE_SUPERADMIN');
 

create table member_status(
    status_id int primary key auto_increment,
    status_name varchar(30) unique not null
);

insert into member_status (status_id , status_name) values(1,'ACTIVE');
insert into member_status (status_id , status_name) values(2,'PENDING');
insert into member_status (status_id , status_name) values(3,'SUSPENDED');
insert into member_status (status_id , status_name) values(4,'DELETED');

create table members(
    member_id int auto_increment primary key,
    login_id varchar(50) unique not null,
    mobile varchar(20) unique not null,
    nickname varchar(50) unique not null,
    email varchar(100) unique not null,
    password varchar(255) not null,
    profile_url varchar(255),

    member_type_id int not null default 1,
    status_id int not null default 1,
    
    created_at datetime not null default current_timestamp,
    updated_at datetime not null default current_timestamp on update current_timestamp,

    delete_yn char(1) not null default 'N',

    foreign key(member_type_id) references member_type(member_type_id),
    foreign key(status_id) references member_status(status_id)
);

 SET SQL_SAFE_UPDATES=0; 
delete from members;
drop table members;

desc members;
desc member_status;
desc member_type;

select * from member_type order by member_type_id asc;
select * from member_status order by status_id asc;
select * from members;
select count(*) from members where email='first@gmail.com' and password='1234';

select m.email, m.password, mt.type_name 
	    from members m join member_type mt
	    on m.member_type_id = mt.member_type_id
	    where m.email = "second@gmail.com";
        
SELECT mt.type_name
FROM member_type mt;    
   
select login_id from members where email='second@gmail.com' and mobile='010-1111-1111' ;
select password from members where login_id='second02' and mobile='010-1111-1111';

INSERT INTO members (
            login_id, mobile, nickname, email, password, member_type_id, status_id
        ) VALUES (
            'first', '010-1234-1234', 'first', 'first@gmail.com', '1324', 1, 1 
        );