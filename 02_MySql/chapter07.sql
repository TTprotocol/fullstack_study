
use sqldb;

select * 
from buytbl
right outer join usertbl
on buytbl.userID = usertbl.userID
order by buytbl.userID ;

select *
from buytbl b
right outer join usertbl u
on b.userID = u.userID
where b.userID is null
order by b.userID;

select NULLIF(10, 10);
SELECT IFNULL(1, 0);
select TRUNCATE(3.14159, 2);


