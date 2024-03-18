use practice_sql;

-- view : 논리 적으로만 존재하는 읽기 전용의 가상의 테이블 
-- 제한된 보기를 제공할 때, 특정 쿼리문(select)을 미리 작성해두는 용도 

create view employee_view as 
select
	E.employee_number as employee_number,
	E.name as employee_name, 
    D.code as department_code,
    D.name as department_name,
    D.tel_number as department_tel_number
from employee as E left join department as D
on E.department_code = D.code;  

select * from employee_view;
select * from employee_view where employee_name = '홍길동';

-- view는 물리적으로 데이터 복사되는 것이 아니고 논리적으로 결과를 불러오는 것이기 때문에 view 자체로 insert, update, delete가 불가능 

# insert into employee_view values (10, '김길동', 'MM', '물류부', '010-1111-1114'); -- 에러
# insert불가능 무조건 조회만 가능 

Drop view employee_view;

-- 인덱스 (index) : 테이블에서 데이터를 빠르게 조회할 수 있도록 도와주는 요소 

create index department_tel_number_index 
on department (tel_number);

select * from department where tel_number = '010-1111-1111';

create index department_index_1
on department (name, tel_number);

select * from department where name = '인사부' and tel_number = '010-1111-1111';

select * from department where tel_number = '010-1111-1111' and name = '인사부'; # 속도가 느려짐 # 어떤걸 먼저 찾는지에 대한 순서도 중요함 

drop index department_index_1 on department; # 인덱스 삭제 

# 자주 사용하는 컬럼들은 앞에 둬야 검색 속도가 빨라짐 

















# view 시험에 출제할 예정













