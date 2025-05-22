select * from employees.titles;

use employees;
select * from titles;
-- 모두 대문자를 쓰거나, 혹은 모두 소문자를 쓰는것이 권장된다.

show databases;	-- 전체 DB 목록 조회

show tables;	-- 테이블 이름만 간단히 보기

USE sqldb;
SELECT * 
FROM usertbl
WHERE name = '김경호';

-- ------------------------------------------------------------

use employees;

select *
from employees
where first_name = 'Georgi';	
-- where first_name = 'georgi';	
-- mysql은 동등연산을 할 때 대소문자를 구분하지 않는다.

-- 집계함수 count 사용
select count(*) from employees;