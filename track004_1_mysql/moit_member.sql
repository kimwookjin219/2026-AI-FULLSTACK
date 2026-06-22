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

        SELECT m.login_id, m.password, mt.type_name, m.nickname,m.profile_url
        FROM members m
        JOIN member_type mt ON m.member_type_id = mt.member_type_id
        WHERE m.login_id = 'first01' AND m.delete_yn = 'N' AND status_id=1;


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
        
CREATE TABLE meetups (
  meetup_id INT AUTO_INCREMENT PRIMARY KEY,
  member_id INT NOT NULL,
  title VARCHAR(100) NOT NULL,
  content TEXT NOT NULL,
  max_participants INT NOT NULL,
  min_participants INT NOT NULL,
  sigungu_id INT NOT NULL,
  category_id INT NOT NULL,
  address VARCHAR(255),
  meetup_at DATETIME NOT NULL,

  status ENUM('RECRUITING','CLOSED','CANCELED','DELETED') NOT NULL DEFAULT 'RECRUITING',
  delete_yn CHAR(1) NOT NULL DEFAULT 'N',
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 

  CONSTRAINT fk_meetup_member FOREIGN KEY (member_id) REFERENCES members(member_id),
  CONSTRAINT fk_meetup_sigungu FOREIGN KEY (sigungu_id ) REFERENCES sigungus (sigungu_id ),
  CONSTRAINT fk_meetup_category FOREIGN KEY (category_id) REFERENCES categories(category_id),
  CONSTRAINT chk_participants CHECK (min_participants <= max_participants)
);

CREATE TABLE meetup_applications (
  application_id INT AUTO_INCREMENT PRIMARY KEY,
  meetup_id INT NOT NULL,
  member_id INT NOT NULL,
  status ENUM('PENDING','APPROVED','REJECTED','CANCELED') NOT NULL DEFAULT 'PENDING',
  reject_reason VARCHAR(255) DEFAULT NULL,

  delete_yn CHAR(1) NOT NULL DEFAULT 'N',
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  CONSTRAINT fk_application_meetup FOREIGN KEY (meetup_id) REFERENCES meetups(meetup_id),
  CONSTRAINT fk_application_member FOREIGN KEY (member_id) REFERENCES members(member_id),
  CONSTRAINT chk_reject_reason CHECK (
    (status = 'REJECTED' AND reject_reason IS NOT NULL) OR
    (status IN ('APPROVED','PENDING','CANCELED') AND reject_reason IS NULL)
  )
);     

CREATE TABLE sidos (
  sido_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

INSERT INTO sidos (name) VALUES ('서울특별시'); -- sido_id: 1
INSERT INTO sidos (name) VALUES ('경기도');     -- sido_id: 2
INSERT INTO sidos (name) VALUES ('부산광역시'); -- sido_id: 3

CREATE TABLE sigungus (
  sigungu_id INT AUTO_INCREMENT PRIMARY KEY,
  sido_id INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  FOREIGN KEY (sido_id) REFERENCES sidos(sido_id)
);

-- 서울특별시 (sido_id: 1)에 속한 시군구
INSERT INTO sigungus (sido_id, name) VALUES (1, '영등포구');
INSERT INTO sigungus (sido_id, name) VALUES (1, '강남구');
INSERT INTO sigungus (sido_id, name) VALUES (1, '마포구');
INSERT INTO sigungus (sido_id, name) VALUES (1, '종로구');

-- 경기도 (sido_id: 2)에 속한 시군구
INSERT INTO sigungus (sido_id, name) VALUES (2, '수원시');
INSERT INTO sigungus (sido_id, name) VALUES (2, '성남시');
INSERT INTO sigungus (sido_id, name) VALUES (2, '고양시');

-- 부산광역시 (sido_id: 3)에 속한 시군구
INSERT INTO sigungus (sido_id, name) VALUES (3, '중구');
INSERT INTO sigungus (sido_id, name) VALUES (3, '해운대구');
INSERT INTO sigungus (sido_id, name) VALUES (3, '수영구');

CREATE TABLE categories (
    category_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    parent_id INT NULL,
    category_name VARCHAR(100) NOT NULL,
    
    CONSTRAINT fk_categories_parent
        FOREIGN KEY (parent_id)
        REFERENCES categories(category_id)
);


INSERT INTO categories(category_name, parent_id)
VALUES
('운동', NULL),
('문화', NULL),
('스터디', NULL);

INSERT INTO categories(category_name, parent_id)
VALUES
('러닝', 1),
('등산', 1),
('영화', 2),
('전시회', 2),
('취업스터디', 3);

CREATE TABLE images (
  image_id INT AUTO_INCREMENT PRIMARY KEY,
  image_path VARCHAR(255) NOT NULL,  
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO images (image_path) VALUES
-- 1. 한강 야경 러닝 모임 (2개)
('/images/meetups/running_night1.jpg'),
('/images/meetups/running_night2.jpg'),
-- 3. 주말 등산 모임 (1개)
('/images/meetups/mountain_hiking.jpg'),
-- 4. 보드게임 번개 모임 (2개)
('/images/meetups/boardgame_cafe1.jpg'),
('/images/meetups/boardgame_cafe2.jpg'),
-- 6. 영화 감상 모임 (1개)
('/images/meetups/cinema_view.jpg'),
-- 7. 주말 축구 경기 (2개)
('/images/meetups/soccer_field1.jpg'),
('/images/meetups/soccer_field2.jpg'),
-- 9. 독서 토론 모임 (1개)
('/images/meetups/book_discussion.jpg'),
-- 10. 카페 투어 모임 (1개)
('/images/meetups/cafe_interior.jpg'),
-- 11. 사진 촬영 출사 (2개)
('/images/meetups/photo_cityscape1.jpg'),
('/images/meetups/photo_cityscape2.jpg'),
-- 13. 맛집 탐방 모임 (1개)
('/images/meetups/gourmet_food.jpg'),
-- 14. 자전거 라이딩 (1개)
('/images/meetups/han_river_riding.jpg'),
-- 15. 코딩 스터디 (1개)
('/images/meetups/coding_study.jpg'),
-- 16. 영어 회화 모임 (1개)
('/images/meetups/english_convo.jpg'),
-- 17. 반려견 산책 모임 (2개)
('/images/meetups/dog_walking1.jpg'),
('/images/meetups/dog_walking2.jpg'),
-- 19. 야구 직관 모임 (1개)
('/images/meetups/baseball_stadium.jpg'),
-- 20. 전시회 관람 (1개)
('/images/meetups/art_exhibition.jpg'),
-- 21. 주말 캠핑 모임 (2개)
('/images/meetups/camping_tent1.jpg'),
('/images/meetups/camping_tent2.jpg'),
-- 23. 요가 클래스 (1개)
('/images/meetups/yoga_class.jpg'),
-- 24. 주식 투자 스터디 (1개)
('/images/meetups/stock_invest.jpg'),
-- 25. 베이킹 클래스 (1개)
('/images/meetups/baking_cookies.jpg');
-- (※ 20번 삭제된 테스트 모임은 이미지가 없는 것으로 설정하여 누락 처리)

CREATE TABLE meetup_images (
  meetup_id INT NOT NULL,
  image_id INT NOT NULL,
  PRIMARY KEY (meetup_id, image_id),
  CONSTRAINT fk_meetup FOREIGN KEY (meetup_id) REFERENCES meetups(meetup_id),
  CONSTRAINT fk_image FOREIGN KEY (image_id) REFERENCES images(image_id)
);

INSERT INTO meetup_images (meetup_id, image_id) VALUES
(1, 1),   -- 1번 모임(러닝): 1번 이미지
(1, 2),   -- 1번 모임(러닝): 2번 이미지 (다중 이미지 예시)
(2, 3),   -- 2번 모임(등산): 3번 이미지
(3, 4),   -- 3번 모임(보드게임): 4번 이미지
(3, 5),   -- 3번 모임(보드게임): 5번 이미지
(4, 6),   -- 4번 모임(영화): 6번 이미지
(5, 7),   -- 5번 모임(축구): 7번 이미지
(5, 8),   -- 5번 모임(축구): 8번 이미지
(6, 9),   -- 6번 모임(독서): 9번 이미지
(7, 10),  -- 7번 모임(카페): 10번 이미지
(8, 11),  -- 8번 모임(사진): 11번 이미지
(8, 12),  -- 8번 모임(사진): 12번 이미지
(9, 13),  -- 9번 모임(맛집): 13번 이미지
(10, 14), -- 10번 모임(자전거): 14번 이미지
(11, 15), -- 11번 모임(코딩): 15번 이미지
(12, 16), -- 12번 모임(영어): 16번 이미지
(13, 17), -- 13번 모임(반려견): 17번 이미지
(13, 18), -- 13번 모임(반려견): 18번 이미지
(14, 19), -- 14번 모임(야구): 19번 이미지
(15, 20), -- 15번 모임(전시회): 20번 이미지
(16, 21), -- 16번 모임(캠핑): 21번 이미지
(16, 22), -- 16번 모임(캠핑): 22번 이미지
(17, 23), -- 17번 모임(요가): 23번 이미지
(18, 24), -- 18번 모임(주식): 24번 이미지
(19, 25); -- 19번 모임(베이킹): 25번 이미지
-- (20번 '삭제된 테스트 모임'은 이미지를 매핑하지 않음으로써 LEFT JOIN 테스트 등에 활용 가능)

CREATE TABLE meetup_likes (
  meetup_id INT NOT NULL,
  member_id INT NOT NULL,

  PRIMARY KEY (meetup_id, member_id),
  CONSTRAINT fk_like_meetup FOREIGN KEY (meetup_id) REFERENCES meetups(meetup_id),
  CONSTRAINT fk_like_member FOREIGN KEY (member_id) REFERENCES members(member_id)
);

CREATE TABLE sidos (
  sido_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE sigungus (
  sigungu_id INT AUTO_INCREMENT PRIMARY KEY,
  sido_id INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  FOREIGN KEY (sido_id) REFERENCES sidos(sido_id)
);