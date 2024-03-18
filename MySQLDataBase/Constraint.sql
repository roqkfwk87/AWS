use practice_sql;

-- 제약조건 : 데이터베이스 컬럼에 적용되는 규칙
-- 데이터의 정확성, 일관성, 무결성을 보장

-- NOT NULL 제약조건 : 해당 컬럼에 null을 포함 

create table not_null_table (
	null_column int,
    not_null_column int not null
);

-- not null 제약조건이 걸린 not_null_column에 값을 지정하지 않음 
-- insert, update에 영향을 미침 
insert into not_null_table (null_column) values (1); -- 에러 

insert into not_null_table (not_null_column) values (1); 

-- not null이 지정된 컬럼은 insert시에 '반드시' null이 아닌 값이 입력되어야 함 
insert into not_null_table (not_null_column) values (null); -- 에러 

-- not null 이 지정된 컬럼은 update시에 null을 지정할 수 없음 
update not_null_table set not_null_column = null; -- 에러 

-- unique 제약조건 : 특정 컬럼에 들어오는 모든 값들을 중복없이 들어오도록 함 
create table unique_table (
	unique_column int unique,
    not_unique_column int 
);

insert into unique_table values (1, 1);

-- unique로 지정된 컬럼은 중복된 데이터를 지정할 수 없음 
insert into unique_table values (1, 1);
insert into unique_table values (2, 1);

-- unique로 지정된 컬럼은 update시에 중복된 값으로 변경할 수 없음 
update unique_table set unique_column = 3;

-- not null + unique = 후보키
-- 후보키 : 레코드를 식별하기 위한 컬럼 (중복X, nullX)
create table candidate_table (
	candidate_column int not null unique,
    unique_column int unique
);

insert candidate_table values (1, null); 

-- primary key : 특정 컬럼을 기본키로 지정함 
-- 기본키 : 후보키 중에 기능상 선택한 하나의 컬럼 
-- 자신 테이블에서 insert, update / 참조되어지는 테이블의 insert, update에 영향을 미침  

create table primary_table (
	primary_column int primary key,
    nomal_column int 
);

create table composite_table (
	-- primary1 int primary key,
	-- primary2 int primary key
    primary1 int,
    primary2 int,
	constraint primary_key primary key (primary1, primary2) 
);

select * from information_schema.table_constraints;

-- primery key 제약조건은 insert시에 not null의 조건과 unique의 조건을 만족해야 함 

insert into primary_table values (null, null); -- 에러 null, null값을 포함하기 때문에 실행 X
insert into primary_table values (1, null);
insert into primary_table values (1, null); -- 에러 중복컬럼이라서 실행x

-- primary key 제약조건은 update시에 not null 조건과 unique 조건을 만족해야 함
update primary_table set primary_column = null; -- 에러
update primary_table set primary_column = 2; 

# 두번 실행하면 중복된 테이블이라서 에러가 뜸 

-- foreign key : 특정 컬럼을 다른 테이블 혹은 같은 테이블의 기본키 컬럼과 연결 
create table foreign_table (
	primary_column int primary key,
	foreign_column int,
    constraint foreign_key foreign key (foreign_column)
    references primary_table (primary_column)
);

-- foreign key 제약조건이 걸린 컬럼에 insert 작업시 참조하고 있는 테이블의 컬럼에 값이 존재하지 않으면 지정 할 수 없음 
insert into foreign_table values (1, 1);
insert into foreign_table values (2, 3); -- 에러 

select * from primary_table;

-- foreign key 제약조건이 걸린 컬럼에 update 작업시 참조하고 있는 테이블의 컬럼에 값이 존재하지 않으면 지정 할 수 없음 
update foreign_table set foreign_column = 3; -- 에러 

-- 특정 테이블에서 기본키를 참조하고 있는 레코드가 존재한다면 해당 레코드를 삭제하지 못함 
delete from primary_table where primary_column = 1; -- 에러 

delete from foreign_table;

-- 특정 테이블을 참조하고 있는 테이블이 존재한다면 테이블 구조를 제거할 수 없음 
drop table primary_table;

-- 특정 테이블에서 기본키를 참조하고 있는 레코드가 존재한다면 해당 레코드를 수정하지 못함 
update primary_table 
set primary_column = 3
where primary_column = 1;

-- on update / on delete 옵션
-- on update : 참조하고 있는 테이블의 기본키가 변경되었을 때 동작 
-- on delete : 참조하고 있는 테이블의 기본키가 삭제되었을 때 동작

-- cascade : 참조하고 있는 테이블에서 데이터를 삭제하거나 수정했을 때, 참조하는 테이블에서도 삭제와 수정이 같이 일어남 
-- set null : 참조하고 있는 테이블에서 데이터를 삭제하거나 수정했을 때, 참조하는 테이블의 해당 데이터를 null로 지정 
-- restrict : 참조하는 테이블에 참조하는 데이터가 존재한다면, 수정, 삭제가 불가능 

# 기본키로 지정된 것은 수정하면 안됨 (수정은 가능) 

create table optional_foreign_table (
	primary_column int,
    foreign_column int,
    foreign key (foreign_column)
    references primary_table (primary_column)
    on update cascade
    on delete set null
);

insert into primary_table values (1, 1); 
insert into optional_foreign_table values (1, 1); 
select * from optional_foreign_table;

update primary_table set primary_column = 3
where primary_column = 1;
select * from optional_foreign_table;

delete from primary_table where primary_column = 3;
select * from optional_foreign_table;

-- check 제약조건 : 특정 컬럼에 값을 제안함 
create table check_table (
	primary_column int primary key,
    check_column varchar(10) check (check_column in ('남', '여'))
);

insert into check_table values (1, '남');

-- check로 지정된 컬럼은 지정 조건에 부합하지 않으면 insert 불가능 
insert into check_table values (2, '남자'); -- 에러 (유효한 데이터만 사용 가능)

-- check로 지정된 컬럼은 지정 조건에 부합하지 않으면 update 불가능
update check_table set check_column = '남자'; -- 에러 

-- default 제약조건 : 컬럼에 데이터가 지정되지 않았을 때 사용할 기본값 지정 
create table default_table (
	primary_column int primary key,
    default_column varchar(10) default '기본값'
);

insert into default_table (primary_column) values(1);
insert into default_table values(2, null);

select * from default_table; 




















































