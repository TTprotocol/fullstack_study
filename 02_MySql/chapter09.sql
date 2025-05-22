CREATE DATABASE scoula_db;	-- db 생성
CREATE USER 'scoula'@'%' IDENTIFIED BY '1234';	-- user 생성
GRANT ALL PRIVILEGES ON scoula_db.* TO 'scoula'@'%';	-- scoula_db에 접근권한 부여
GRANT ALL PRIVILEGES ON sqldb.* TO 'scoula'@'%';	-- sqldb에 접근권한 부여
FLUSH PRIVILEGES;	-- 권한 설정 적용




