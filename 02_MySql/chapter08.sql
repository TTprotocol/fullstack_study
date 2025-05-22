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

-- ------------------------
-- PK정렬이 있는 경우와 없는 경우의 select 속도 차이 비교
use employees;

select count(*) from employees;	-- 약 30만건 있음

select * from employees
where last_name = 'Facello'; -- 0.109sec

select * from employees
where emp_no = '32138';	-- 0sec
-- ------------------------
-- 뷰 select 해보기
use sakila;
select * from actor_info;
-- ------------------------














