use practice_sql;

-- 서브쿼리 : 쿼리 내부에 위치하는 또 다른 쿼리, 쿼리 결과를 조건이나 테이블로 사용할 수 있도록 함 

-- where 절에서 서브쿼리 : 쿼리 결과를 조건으로 사용하여 조건을 동적으로 지정 
-- where 절에서 비교 연산으로 사용될 때 조회하는 컬럼의 개수 및 레코드 개수 주의 

-- 에러 나는 이유
-- select * from employee 
-- where department_code = ( 
-- 	select code from department 
-- );
# 1개의 컬럼에는 1개의 값이 나와야 하는데 이 상태에서는 3개의 값(department의 값)이 나오기 때문에
# 결과 값을 찾을 수 없어서 에러가 남 

select * from employee 
where department_code = ( 
	select code from department where name = '인사부'
);
# 가장 위에 오는 쿼리를 메인쿼리라고 함 

-- from 절에서의 서브쿼리 : 쿼리 결과 테이블을 다시 from절에 사용하여 복합적인 테이블 조회
select * 
from (
	select name, department_code
    from employee
    where department_code is null # is not null일 때 에러남 is null로 변경함 
) as SQ # 임의로 이름을 지정시킴 (as SQ로 이름을 지정하지 않을 시 에러남)
where name = '홍길동';
# 서브쿼리를 사용할려면 테이블의 이름이 있어야 함 

select * 
from (
	select name as employee_name, department_code -- 에러 (as employee_name으로 변경상태에서 where절에 그대로 name을 사용했기 때문)
    from employee
    where department_code is null
) as SQ 
where employee_name = '홍길동'; # select에서 지정한 name으로 바꿔야지 사용가능
# select name as employee_name을 지정해줬기 때문에 where절에서 name이 없기 때문이다 

-- 부서 이름이 '개발부'인 사원이름, 부서코드, 부서명을 조회
# 하나의 테이블로는 찾을 수 없음 - 서브쿼리로 찾기 불가능 # 2개 이상의 테이블로 찾는 경우 join을 사용 

-- 부서 이름이 '개발부'인 사원이름, 부서코드를 조회 
# 하나의 테이블로 찾을 수 있음 - 서브쿼리로 찾기 가능 # 1개의 테이블로 찾는 경우 서브쿼리 가능 
# join도 가능하지만 서브쿼리가 join보다 처리속도가 빠르기 때문에 서브쿼리를 사용함 

select name, department_code
from employee
where department_code = (
	select code -- 부서코드를 조회
	from department
	where name = '개발부'
);















