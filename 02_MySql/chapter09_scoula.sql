use sqldb;
select * from buytbl;
select * from employees.employees;	-- Error Code: 1142. SELECT command **denied** to user 'scoula'@'localhost' for table 'employees' 	-- denied 됨.

select @@autocommit;	-- @@ : 환경변수를 보기 위한 접두사

-- 트랜잭션 실습
use sqldb;
select * from buytbl;

START TRANSACTION;
DELETE FROM buytbl where num = 1;
DELETE FROM buytbl where num = 2;

select * from buytbl ;	-- 1, 2 삭제 완료

ROLLBACK;

select * from buytbl ;	-- 1, 2 복구됨


















































