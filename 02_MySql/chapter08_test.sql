-- 기본
drop database tabledb;
create database tabledb;
use tabledb;

drop table if exists usertbl;
create table usertbl(
userID CHAR(8) NOT NULL PRIMARY KEY, name VARCHAR(10) NOT NULL,
birthYear INT NOT NULL, addr CHAR(2) NOT NULL, mobile1 CHAR(3) NULL,
mobile2 CHAR(8) NULL, height SMALLINT NULL, mDate DATE NULL
);

drop table if exists buytbl;
create table buytbl(
num INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
userid CHAR(8) NOT NULL,
prodName CHAR(6) NOT NULL, 
groupName CHAR(4) NULL, 
price INT NOT NULL,
amount SMALLINT NOT NULL, 
FOREIGN KEY(userid) REFERENCES usertbl(userID)
);

insert into usertbl values
('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8'), 
('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4'), 
('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');

INSERT INTO buytbl VALUES
(NULL, 'KBS', '운동화', NULL, 30, 2), 
(NULL, 'KBS', '노트북', '전자', 1000, 1); 
INSERT INTO buytbl VALUES (NULL, 'JYP', '모니터', '전자', 200, 1);
-- usertbl 테이블에 JYP라는 key를 가진 데이터가 없음.

drop table if exists usertbl;
create table usertbl (
userID char(8) not null primary key,
name varchar(10) not null,
birthyear int not null
);

drop table if exists prodtbl;
create table prodtbl (
prodCode char(3) not null,
prodID char(4) not null,
prodDate datetime not null,
proCur char(10),
constraint primary key (prodCode, prodID) 
);

create view result as (
select u.userid, u.name, b.prodName, u.addr, concat(u.mobile1, u.mobile2) as '연락처'
from usertbl u
inner join buytbl b
on u.userID = b.userID
);

select * from result
where userID = '김범수';

-- 심화
drop table if exists usertbl;
create table usertbl (
userID char(8) not null primary key,
name varchar(10) not null,
brithyear int not null
);

drop table if exists buytbl;
create table buytbl(
num int auto_increment not null primary key,
userID char(8) not null,
prodName char(6) not null,
FOREIGN KEY(userID) REFERENCES usertbl(userID)
);

drop table if exists usertbl;
create table usertbl (
userID char(8) not null primary key,
name varchar(10) not null,
brithyear int not null,
email char(30) unique
);

drop table if exists usertbl;
create table usertbl (
userID char(8) not null primary key,
name varchar(10),
brithyear int check (brithyear >= 1900 and brithyear <= 2023),
mobile char(3) not null
);

drop table if exists usertbl;
create table usertbl (
userID char(8) not null primary key,
name varchar(10),
brithyear int check (brithyear >= 1900 and brithyear <= 2023),
addr char(2),
mobile char(3) not null,
mobile char(8) not null,
height smallint not null,
mDate date null 
);

alter table usertbl drop mobile1;

alter table usertbl change name uName varchar(8);

alter table usertbl drop primary key;

-- 실습

CREATE DATABASE recruitDB;
USE recruitDB;
-- 1
create table departments (
dept_id int not null primary key,
dept_name varchar(30) not null
);
select * from departments;

-- 2
create table applicants (
applicant_id INT PRIMARY KEY,
name VARCHAR(50),
email VARCHAR(50) UNIQUE,
phone VARCHAR(15),
dept_id INT,
apply_date timestamp,
foreign key(dept_id) references departments(dept_id)
);

select * from applicants;

-- 3
ALTER TABLE applicants
MODIFY apply_date TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP;

-- 4
alter table applicants add constraint chk_name_length check(char_length(name) between 2 and 20);
alter table applicants add constraint chk_phone_length check(char_length(phone) between 10 and 13);

-- 5
insert into departments values (1, "개발팀"), (2, "인사팀"), (3, "마케팅팀");
select * from departments ;

-- 6
insert into applicants(applicant_id, name, email, phone, dept_id) values
(101, '김지은', 'jkim@example.com', '01012345678', 1),
(102, '이현수', 'hyunlee@example.com', '01098765432', 2);

select * from applicants;

-- 7
insert into applicants(applicant_id, name, email, phone, dept_id) values
(103, '최은비', 'eunbi@example.com', '01022223333', 99);

-- 8
insert into applicants(applicant_id, name, email, phone, dept_id) values
(104, '강민수', 'jkim@example.com', '01044445555', 1);

-- 9
update applicants
set name = '김지혜'
where  applicant_id = 101;

select * from applicants;

-- 10
update departments
set dept_name = '연구개발팀'
where dept_id = 1;

select * from departments;

-- 11
alter table applicants add column is_interviewed BOOLEAN DEFAULT FALSE;

select * from applicants ;

-- 12
alter table applicants drop column phone;

select * from applicants ;

-- 13
alter table applicants drop check chk_name_length;
alter table applicants change column name applicant_name VARCHAR(100);
alter table applicants add constraint chk_name_length check(char_length(applicant_name) between 2 and 20);

select * from applicants ;

-- 14
show create table applicants;
/*'applicants', 'CREATE TABLE `applicants` (
  `applicant_id` int NOT NULL,
  `applicant_name` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `dept_id` int DEFAULT NULL,
  `apply_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_interviewed` tinyint(1) DEFAULT \'0\',
  PRIMARY KEY (`applicant_id`),
  UNIQUE KEY `email` (`email`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `applicants_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `departments` (`dept_id`),
  CONSTRAINT `chk_name_length` CHECK ((char_length(`applicant_name`) between 2 and 20))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci' 
*/

alter table applicants drop foreign key applicants_ibfk_1;

show create table applicants;
/* 'applicants', 'CREATE TABLE `applicants` (
  `applicant_id` int NOT NULL,
  `applicant_name` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `dept_id` int DEFAULT NULL,
  `apply_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_interviewed` tinyint(1) DEFAULT \'0\',
  PRIMARY KEY (`applicant_id`),
  UNIQUE KEY `email` (`email`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `chk_name_length` CHECK ((char_length(`applicant_name`) between 2 and 20))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci'
*/

-- 15
create view vw_applicant_summary as 
select applicant_id, applicant_name, email, dept_id, apply_date
from applicants;

select * from vw_applicant_summary;

-- 16
create view vw_dev_applicants as
select a.applicant_name, a.email, d.dept_name
from applicants a
left outer join departments d
on a.dept_id = d.dept_id
where d.dept_name = '연구개발팀'
;

select * from vw_dev_applicants;

-- 17
create view vw_h_email_applicants as
select applicant_name, email, apply_date
from applicants
where email like 'h%'
;

select * from vw_h_email_applicants;

-- 18
select applicant_name, email from vw_applicant_summary;

-- 19
update vw_applicant_summary 
set applicant_name = '김수진'
where email = 'jkim@example.com';

select * from vw_applicant_summary;

-- 20
insert into vw_applicant_summary (applicant_id, applicant_name, email, dept_id) values
(999, '박지현', 'jhpark@example.com', 1);

select * from vw_applicant_summary;




































