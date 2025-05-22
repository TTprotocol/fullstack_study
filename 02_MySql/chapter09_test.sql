use sqldb;

-- 기본
-- 1 
create table tbl1(
a int primary key,
b int,
c int
);
show index from tbl1;

-- 2
create table tbl2(
a int primary key,
b int unique,
c int unique,
d int
);
show index from tbl2;

-- 3
create table tbl3(
a int unique,
b int unique,
c int unique,
d int
);
show index from tbl3;

-- 4
create table tbl4(
a int unique not null,
b int unique,
c int unique,
d int
);
show index from tbl4;

-- 5
create table tbl5(
a int unique not null,
b int unique,
c int unique,
d int primary key
);
show index from tbl5;

-- 6
create table usertbl_test (
userID char(8) not null primary key,
name varchar(10) not null,
birthyear int not null,
addr nchar(2) not null
);

insert into usertbl_test values
('LSG', '이승기', 1987, '서울'),
('KBS', '김범수', 1979, '경남'),
('KKH', '김경호', 1971, '전남'),
('JYP', '조용필', 1950, '경기'),
('S나', '성시경', 1979, '서울')
;

show index from usertbl_test;

-- 7
alter table usertbl_test drop primary key;
alter table usertbl_test add constraint pk_name primary key(name);
show index from usertbl_test ;


-- 심화
-- 1
select * from usertbl_test;
show index from usertbl_test;
show table status like 'usertbl_test';

-- 2
create index index_usertbl_addr on usertbl_test(addr);
show index from usertbl_test;

-- 3
show table status like 'usertbl_test';

-- 4
create index idx_usertbl_test_birthyear on usertbl_test(birthyear);
create index idx_usertbl_test_name on usertbl_test(name);
show index from usertbl_test;

-- 5
drop index idx_usertbl_test_name on usertbl_test;
show index from usertbl_test;
create index idx_usertbl_test_name_birthyear on usertbl_test(name, birthyear);
show index from usertbl_test;
drop index idx_usertbl_test_name_birthyear on usertbl_test;
show index from usertbl_test;

-- 6
drop index idx_usertbl_test_name on usertbl_test;
drop index index_usertbl_addr on usertbl_test;
drop index idx_usertbl_test_birthyear on usertbl_test;
drop index idx_usertbl_test_name_birthyear on usertbl_test;
show index from usertbl_test;


-- 실습
-- 1 
create database job_platform;
use job_platform;

create table company (
company_id INT PRIMARY KEY AUTO_INCREMENT,
company_name VARCHAR(100) NOT NULL,
industry VARCHAR(50),
founded_year INT CHECK (founded_year >= 1900)
);
create index idx_company_industry on company(industry);
show index from company;
select * from company;

create table recruit_post (
post_id INT PRIMARY KEY AUTO_INCREMENT,
company_id INT ,
title VARCHAR(100),
job_type VARCHAR(20) check (job_type in ('정규직', '계약직', '인턴')),
deadline DATE ,
is_active BOOLEAN default true,
foreign key (company_id) references company(company_id)
);
create index idx_company_industry on company(industry);
show index from recruit_post;
select * from recruit_post;

-- 2
insert into company (company_name, industry, founded_year) values
('네이버', 'IT', 1995),
('삼성전자', '전자', 1995)
;
select * from company;


insert into recruit_post (company_id, title, job_type, deadline, is_active) values
(
(select company_id from company where company_name = '카카오'),
'AI 연구원 채용',
'정규직',
'2025-07-01',
'1'
)
;
select * from recruit_post;

-- 3
select post_id, title, job_type, deadline, is_active
from recruit_post 
where is_active
order by deadline
;

-- 4
select c.company_name, title, job_type, deadline, is_active
from recruit_post r
left outer join company c
on r.company_id = c.company_id
order by c.company_name
;

-- 5
select company_name, industry, title, job_type, deadline, is_active
from recruit_post r
left outer join company c
on r.company_id = c.company_id
where industry in ('IT', '핀테크')
order by deadline desc
;

-- 6
select company_name, title, job_type, deadline
from recruit_post r
left outer join company c
on r.company_id = c.company_id
where deadline >= '2025-05-25'
and deadline <= '2025-06-01'
order by deadline
;

-- 7
select company_name, title, job_type, deadline
from recruit_post r
left outer join company c
on r.company_id = c.company_id
where title like '%데이터%'
order by deadline
;

-- 8
select company_name,  (COUNT(*)) as '공고수'
from recruit_post r
left outer join company c
on r.company_id = c.company_id
group by company_name
order by (COUNT(*)) desc
;

-- 9
select company_name,  (COUNT(*)) as '공고수'
from recruit_post r
left outer join company c
on r.company_id = c.company_id
group by company_name
having (COUNT(*)) >= 2
order by (COUNT(*)) desc
;

-- 10
select job_type,  (COUNT(*)) as '공고수'
from recruit_post 
group by job_type
order by (COUNT(*)) desc
;

-- 11
select company_name, title, job_type, deadline, is_active
from recruit_post r
left outer join company c
on r.company_id = c.company_id
where job_type = '정규직'
and industry = 'IT'
order by deadline
;

-- 12
INSERT INTO company (company_name, industry, founded_year)
VALUES ('네이버', 'IT', 1999);

select company_name, title, job_type, deadline
from company c
left outer join recruit_post r
on r.company_id = c.company_id
order by company_name
;

-- 13
select company_name, industry, founded_year
from company c
left outer join recruit_post r
on r.company_id = c.company_id
where title is null
order by company_name
;

-- 14
INSERT INTO recruit_post (company_id, title, job_type, deadline, is_active)
VALUES (
  (SELECT company_id FROM company WHERE company_name = '카카오'),
  'AI 연구원 채용',
  '정규직',
  '2025-06-28',
  TRUE
);

select company_name, industry, COUNT(*) as '공고수'
from recruit_post r
left outer join company c
on r.company_id = c.company_id
group by company_name, industry
order by (COUNT(*)) desc
limit 1
;

-- 15
select company_name, COUNT(*) as '공고수'
from recruit_post r
left outer join company c
on r.company_id = c.company_id
group by company_name
HAVING SUM(is_active = 0) = 0
order by (COUNT(*)) desc
;

-- 16
select company_name, industry, founded_year
from company
where company_id in (
select company_id
from recruit_post
where is_active
)
order by company_name
;

-- 17
INSERT INTO company (company_name, industry, founded_year)
VALUES ('삼성전자', '전자', 1969);

select distinct company_name, industry, founded_year
from company
where company_id not in (
select company_id
from recruit_post
where is_active
)
order by company_name
;

-- 18
-- ① 외래키 제약 해제
SET FOREIGN_KEY_CHECKS = 0;

-- ② 존재하지 않는 company_id를 참조하는 테스트 공고 삽입
INSERT INTO recruit_post (company_id, title, job_type, deadline, is_active)
VALUES (999, '테스트용 유효하지 않은 공고', '정규직', '2025-07-01', TRUE);

-- ③ 외래키 제약 다시 활성화
SET FOREIGN_KEY_CHECKS = 1;

select title, company_id, deadline, is_active
from recruit_post r
where not exists (
select company_id
from company c
where c.company_id = r.company_id
);

-- 19
create index idx_post_deadline on recruit_post(deadline);
create index idx_post_jobtype on recruit_post(job_type );
show index from recruit_post;

-- 20
select industry, count(*) as '정규직_공고수'
from recruit_post r
left outer join company c
on r.company_id = c.company_id
where job_type = '정규직'
group by industry
HAVING count(*) >= 1
order by (COUNT(*)) desc
;

-- 21
create user 'job_reader'@'localhost' identified by 'job1234';
SHOW GRANTS FOR 'job_reader'@'localhost';

-- 22
grant select on job_platform.* to 'job_reader'@'localhost';
flush privileges;
SHOW GRANTS FOR 'job_reader'@'localhost';

-- 23
revoke select on job_platform.* from 'job_reader'@'localhost';
flush privileges;
SHOW GRANTS FOR 'job_reader'@'localhost';

-- 24
DROP USER 'job_reader'@'localhost';
SHOW GRANTS FOR 'job_reader'@'localhost';

-- 25
create view vw_active_post as (
select post_id, title, job_type, deadline, is_active
from recruit_post
where is_active = TRUE
);
SELECT * FROM vw_active_post;

-- 26
SELECT * 
FROM vw_active_post
where job_type = '정규직'
order by deadline
;

-- 27
-- 기존 뷰 삭제
DROP VIEW IF EXISTS vw_active_post;

-- company_id를 포함하여 뷰 재생성
CREATE VIEW vw_active_post AS
SELECT post_id, title, job_type, deadline, is_active, company_id
FROM recruit_post
WHERE is_active = TRUE;

SELECT company_name, title, job_type, deadline
FROM vw_active_post v
left outer join company c
on v.company_id = c.company_id
order by deadline
;
 
-- 28
start transaction;
update recruit_post 
set title = '🔥 실수로 수정된 제목 🔥'
where post_id = 1;

select post_id, title from recruit_post where post_id = 1;

rollback;

select post_id, title from recruit_post where post_id = 1;

-- 29
start transaction;
update recruit_post 
set title = '백엔드 개발자 채용 (수정됨)'
where post_id = 1;

select post_id, title from recruit_post where post_id = 1;

commit;

select post_id, title from recruit_post where post_id = 1;

rollback;

select post_id, title from recruit_post where post_id = 1;

-- 30
select company_name, title, job_type, deadline
from recruit_post r
left outer join company c
on r.company_id = c.company_id
where deadline >= '2025-06-25'
and job_type = '정규직'
and is_active
order by deadline
;





















































































