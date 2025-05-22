-- 기본
-- 현재 서버에 존재하는 데이터베이스 확인
SHOW databases;

-- 현재 데이터베이스를 employees로 설정하기
USE employees;

-- employees 데이터베이스의 테이블 목록 보기
SHOW tables;

-- employees 테이블의 열 목록 출력하기
DESCRIBE employees;

-- titles 테이블의 데이터 출력하기
SELECT * 
FROM titles;

-- employees 테이블에서 first_name 컬럼만 출력하기
SELECT first_name 
FROM employees;

-- employees 테이블에서 first_name 컬럼, last_name 컬럼, gender 컬럼 출력하기
SELECT first_name, last_name, gender 
FROM employees;

-- usertbl 테이블에서 이름이 '김경호'인 행을 출력하세요.
USE sqldb;
SELECT * 
FROM usertbl 
WHERE name = '김경호';

-- usertbl 테이블에서 생년이 1970 이상이고 키가 182이상인 데이터를 출력하세요.
SELECT userid, name 
FROM usertbl 
WHERE birthyear >= 1970 
AND height >= 182;

-- usertbl 테이블에서 키가 180~183 범위인 데이터를 출력하세요.
SELECT name, height 
FROM usertbl 
WHERE height BETWEEN 180 AND 183;

-- usertbl 테이블에서 주소가 '경남' 또는 '전남' 또는 '경북'인 데이터를 출력하세요.
SELECT name, addr 
FROM usertbl 
WHERE addr IN ('경남', '전남', '경북');

-- usertbl 테이블에서 이름이 '김'으로 시작하는 데이터를 출력하세요.
SELECT name, height 
FROM usertbl 
WHERE name LIKE '김%';

-- usertbl에서 김경호 보다 큰 사람들의 이름과 키를 출력하세요.
SELECT name, height 
FROM usertbl 
WHERE height > (
	SELECT height FROM usertbl WHERE name = '김경호'
);

-- usertbl을 mdata의 오름 차순으로 정렬하여 출력하세요.
SELECT name, mDate 
FROM usertbl 
ORDER BY mDate ASC;

-- usertbl을 mdata의 내림 차순으로 정렬하여 출력하세요.
SELECT name, mDate 
FROM usertbl 
ORDER BY mDate DESC;

-- usertbl을 height의 내림차순으로 정렬하고, 동률인 경우 name의 내림차순으로 정렬하여 출력하세요.
SELECT name, height 
FROM usertbl 
ORDER BY height DESC, 
name DESC;

-- usertbl의 주소지를 중복없이 오름 차순으로 출력하세요.
SELECT DISTINCT addr 
FROM usertbl 
ORDER BY addr;

-- 국가 코드가 'KOR'인 도시를 찾아 인구수를 역순으로 표시하세요.
USE world;
SELECT Population
FROM city
WHERE CountryCode = "KOR"
ORDER BY Population DESC;

-- city 테이블에서 국가코드와 인구수를 출력하라. 정렬은 국가코드별로 오름차순으로, 동일한 코드(국가) 안에서는 인구 수의 역순으로 표시하세요.
SELECT CountryCode, Population
FROM city
ORDER BY CountryCode ASC,
Population DESC;

-- city 테이블에서 국가코드가 'KOR'인 도시의 수를 표시하세요.
SELECT count(*)
FROM city
WHERE CountryCode = "KOR";

-- city 테이블에서 국가코드가 'KOR', 'CHN', 'JPN'인 도시를 찾으세요.
SELECT *
FROM city
WHERE CountryCode IN ('KOR', 'CHN', 'JPN');

-- 국가코드가 'KOR'이면서 인구가 100만 이상인 도시를 찾으세요.
SELECT *
FROM city
WHERE CountryCode = "KOR"
AND Population >= 1000000;

-- 국가 코드가 'KOR'인 도시 중 인구수가 많은 순서로 상위 10개만 표시하세요.
SELECT *
FROM city
WHERE CountryCode = "KOR"
ORDER BY Population ASC
LIMIT 10;

-- city 테이블에서 국가코드가 'KOR'이고, 인구가 100만 이상 500만 이하인 도시를 찾으세요.
SELECT *
FROM city
WHERE CountryCode = "KOR"
AND Population >= 1000000
AND Population <= 5000000;


-- 심화
-- 1.
USE sqldb;
SELECT userID AS '사용자 아이디', SUM(amount) AS '총 구매 개수' 
FROM buytbl
GROUP BY userID;

SELECT userID AS '사용자 아이디', SUM(amount*price) AS '총 구매액' 
FROM buytbl
GROUP BY userID;

-- 2.
SELECT AVG(amount) AS '평균 구매 개수' 
FROM buytbl;

SELECT userID, AVG(amount) AS '평균 구매 개수' 
FROM buytbl
GROUP BY userID;

-- 3.
SELECT name, height
FROM usertbl
WHERE height = (SELECT MIN(height) FROM usertbl)
OR height = (SELECT MAX(height) FROM usertbl);

-- 4.
SELECT COUNT(*) AS '휴대폰이 있는 사용자'
FROM usertbl
WHERE mobile1 IS NOT NULL;

-- 5.
SELECT userID AS '사용자', SUM(price * amount) AS '총구매액'
FROM buytbl
GROUP BY userID;

SELECT userID AS '사용자', SUM(price * amount) AS '총구매액'
FROM buytbl
GROUP BY userID
HAVING SUM(price * amount) >= 1000;

-- 6.
USE world;
SELECT SUM(Population)
FROM city
WHERE CountryCode = "KOR";

SELECT MIN(Population) AS '최소값'
FROM city
WHERE CountryCode = "KOR";

SELECT AVG(Population)
FROM city
WHERE CountryCode = "KOR";

SELECT MAX(Population) AS '최대값'
FROM city
WHERE CountryCode = "KOR";

SELECT length(Name)
FROM country;

SELECT CONCAT(UPPER(LEFT(Name, 3)), LOWER(SUBSTRING(Name, 4)))
FROM country;

SELECT ROUND(LifeExpectancy, 1) AS RoundedLifeExpectancy
FROM country;

-- 7. 
USE employees;
SELECT *
FROM employees
WHERE emp_no IN (SELECT emp_no FROM dept_manager);

SELECT *
FROM employees
WHERE emp_no IN (SELECT emp_no FROM dept_manager WHERE dept_no = 'd005');

-- 8.
SELECT *
FROM employees
ORDER BY hire_date DESC
LIMIT 0, 20;

-- 9. 
SELECT count(*)
FROM employees
WHERE emp_no in (SELECT emp_no FROM dept_emp WHERE to_date = '9999-01-01');

SELECT AVG(salary)
FROM salaries
WHERE emp_no in (SELECT emp_no FROM dept_emp WHERE to_date = '9999-01-01');

-- 10. 
SELECT *
FROM employees
WHERE emp_no IN (
    SELECT emp_no
    FROM salaries
    WHERE emp_no IN (
        SELECT emp_no 
        FROM dept_emp 
        WHERE to_date = '9999-01-01'
    )
    AND salary > (
        SELECT AVG(salary)
        FROM salaries
        WHERE emp_no IN (
            SELECT emp_no 
            FROM dept_emp 
            WHERE to_date = '9999-01-01'
        )
    )
);

-- 11.
SELECT dept_no, COUNT(*)
FROM dept_emp
WHERE to_date = '9999-01-01'
GROUP BY dept_no
ORDER BY dept_no ASC;















