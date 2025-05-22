CREATE DATABASE sejong_festival_2025;


create table eventTbl(
eventID INT primary key auto_increment,
eventName VARCHAR(256),
eventDate DATE,
location VARCHAR(256)
);
insert into eventTbl values
(null, '세종대 대동제', '2025-05-14', '대운동장'),
(null, '세종대 대동제', '2025-05-15', '대운동장'),
(null, '세종대 대동제', '2025-05-16', '대운동장')
;

create table artistTbl(
artistID INT primary key auto_increment,
artistName VARCHAR(256),
genre VARCHAR(256),
debutYear INT
);
insert into artistTbl values
(null, '로시', 'R&B', '2017'),
(null, '잔나비', '밴드', '2014'),
(null, 'NMIXX', '아이돌', '2022'),
(null, '스컬&하하', '레게', '2008'),
(null, 'KISS OF LIFE', '아이돌', '2023'),
(null, 'ZICO', '힙합', '2011'),
(null, '나상현씨 밴드', '인디', '2015'),
(null, 'Apink', '아이돌', '2011'),
(null, 'HIGHLIGHT', '아이돌', '2009')
;

create table stageTbl(
stageID INT primary key auto_increment,
stageName VARCHAR(256),
capacity INT
);
insert into stageTbl values
(null, '재학생존', 3000),
(null, '외부인존', 1000)
;

create table scheduleTbl (
scheduleID INT primary key auto_increment,
eventID INT,
artistID INT,
stageID INT,
performTime time,
durationMin INT
);
insert into scheduleTbl values
(null, 1, 1, 1, '18:00:00', 30),
(null, 1, 2, 1, '19:00:00', 40),
(null, 1, 3, 1, '20:00:00', 35),
(null, 2, 4, 1, '18:00:00', 30),
(null, 2, 5, 1, '19:00:00', 30),
(null, 2, 6, 1, '20:00:00', 45),
(null, 3, 7, 1, '18:00:00', 30),
(null, 3, 8, 1, '19:00:00', 35),
(null, 3, 9, 1, '20:00:00', 40)
;

-- --------------------------------------------------------------------------------------------------------------------

use sejong_festival_2025;

select eventDate, concat(artistName) as "아티스트수"
from scheduleTbl s
left outer join eventTbl e
on s.eventID = e.eventID
left outer join artistTbl a
on s.artistID = a.artistID
left outer join stageTbl st
on s.stageID = st.stageID
group by eventDate
having concat(artistName) = (
select max(cnt)
from (
select concat(artistName) as cnt
from artistTbl
group by genre
) as sub
)
;


SELECT genre, SUM(durationMin) AS '총공연시간'
FROM scheduleTbl s
JOIN artistTbl a ON s.artistID = a.artistID
GROUP BY genre
ORDER BY SUM(durationMin) DESC
LIMIT 1;






