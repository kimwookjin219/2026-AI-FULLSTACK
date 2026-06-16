use mbasic;

create table member_type(
    member_type_id int primary key auto_increment,
    type_name varchar(30) unique not null
);

create table member_status(
    status_id int primary key auto_increment,
    status_name varchar(30) unique not null
);

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
    created_by int not null,
    updated_at datetime not null default current_timestamp on update current_timestamp,
    updated_by int not null,

    delete_yn char(1) not null default 'N',

    foreign key(member_type_id) references member_type(member_type_id),
    foreign key(status_id) references member_status(status_id),
    foreign key(created_by) references members(member_id),
    foreign key(updated_by) references members(member_id)
);