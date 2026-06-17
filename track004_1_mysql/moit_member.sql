use moit;

show databases;

show tables;

create database moit;

set sql_safe_updates =0;

create table member_type(
    member_type_id int primary key auto_increment,
    type_name varchar(30) unique not null
);

insert into member_type(type_name) value('MEMBER');
insert into member_type(type_name) value('PARTNER');
insert into member_type(type_name) value('ADMIN');
insert into member_type(type_name) value('SUPERADMIN');

update member_type 
set type_name = 'ROLE_MEMBER'
where member_type_id = 1;

update member_type 
set type_name = 'ROLE_PARTNER'
where member_type_id = 2;

update member_type 
set type_name = 'ROLE_ADMIN'
where member_type_id = 3;

update member_type 
set type_name = 'ROLE_SUPERADMIN'
where member_type_id = 4;

create table member_status(
    status_id int primary key auto_increment,
    status_name varchar(30) unique not null
);

insert into member_status (status_id , status_name) values(1,'ACTIVE');
insert into member_status (status_id , status_name) values(2,'PENDING');
insert into member_status (status_id , status_name) values(3,'SUSPENDED');
insert into member_status (status_id , status_name) values(4,'DELETED');

delete from member_status;


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

ALTER TABLE members
drop created_by;

ALTER TABLE members
drop updated_by;

drop table members;

desc members;
desc member_status;
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