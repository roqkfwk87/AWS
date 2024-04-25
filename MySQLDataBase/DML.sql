USE practice_sql;
# 사용할 데이터베이스를 지정해두지 않은 상태로 실행하면 에러남 

-- DML (데이터 조작어)
-- 테이블에 데이터를 삽입, 조회, 수정, 삭제 할때 사용 

-- INSERT : 테이블에 데이터를 삽입하는 명령어 

-- 1. 모든 열에 대하여 데이터 삽입
-- INSERT INTO 테이블명 VALUES (데이터1, 데이터2, ...);
INSERT INTO example_table 
VALUES ('문자열데이터', '텍스트데이터', 99, 3.14, 3.14, true, '2024-02-05', now());

-- 2. 특정 열에 대하여 데이터 삽입 
-- INSERT INTO 테이블명 (컬럼명1, 컬럼명2, ...)
-- VALUSE (데이터1, 데이터2, ...);
INSERT INTO example_table (int_column, boolean_column) # 지정한 컬럼의 맞는 값을 넣어야 함 
VALUES (50, false);

-- SELECT : 테이블에서 데이터를 조회할 때 사용하는 명령어 

-- 1. 모든 데이터 조회 
-- SELECT * FROM 테이블명
SELECT * FROM example_table;

-- 2. 테이블의 특정 컬럼 데이터 조회
-- SELECT 컬럼명1, 컬럼명2, ...FROM 테이블명
SELECT int_column, text_column FROM example_table;

-- 3. 테이블에서 특정 조건에 따른 데이터 조회
-- SELECT 조회할컬럼... FROM 테이블명 WHERE 조건;
SELECT * FROM example_table WHERE int_column = 50;
# sql에서는 같다를 '=' 하나로 사용 

-- UPDATE : 테이블에서 데이터를 수정할 때 사용하는 명령어 

-- UPDATE 테이블명 SET 컬럼1 = 데이터1, ...;
-- UPDATE 테이블명 SET 컬럼1 = 데이터1, ... WHERE 조건;
UPDATE example_table SET boolean_column = false;
UPDATE example_table SET datetime_column = now() WHERE int_column = 50;

-- DELETE : 테이블에서 데이터를 삭제할 때 사용하는 명령어

-- DELETE FROM 테이블명;
-- DELETE FROM 테이블명 WHERE 조건;
DELETE FROM example_table WHERE int_column = 50;
DELETE FROM example_table;

TRUNCATE TABLE example_table;
# DDL에서 사용 - 구조만 남기고 모두다 지우는 역할을 함 

# DROP은 구조 자체를 날려버림
# dELETE는 데이터를 날려버림, 구조는 남아있음 

CREATE TABLE auto_table (
	idx INT PRIMARY KEY AUTO_INCREMENT,
    num INT
);


insert into auto_table (num) values (0);
select * from auto_table;
delete from auto_table;
# 데이터만 지웠기 때문에 지운다음에 다시 실행하면 지우기 전 데이터 다음으로 실행됨 - 데이터만 남김
truncate table auto_table;
# 데이터를 초기화 시킴 - 구조만 남기고 다 삭제함 

-- drop table : DDL 테이블의 구조 전체를 제거
-- truncate table : DDL 테이블의 구조만 남기고 초기화 
-- delete from : DML 테이블에서 데이터만 제거 




