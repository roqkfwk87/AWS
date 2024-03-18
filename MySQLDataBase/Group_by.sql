use practice_sql;

create table jeju2 
as 
select * from jeju ;

update jeju2 set observe_date = '7월 상반기'
where observe_date between '2023-07-01' and '2023-07-15';
update jeju2 set observe_date = '7월 하반기'
where observe_date between '2023-07-16' and '2023-07-31';

update jeju2 set observe_date = '8월 상반기'
where observe_date between '2023-08-01' and '2023-08-15';
update jeju2 set observe_date = '8월 하반기'
where observe_date between '2023-08-16' and '2023-08-31';

update jeju2 set observe_date = '9월 상반기'
where observe_date between '2023-09-01' and '2023-09-15';
update jeju2 set observe_date = '9월 하반기'
where observe_date between '2023-09-16' and '2023-09-31';

select * from jeju2;

-- 그룹화(group by) : 레코드를 하나 이상의 컬럼으로 그룹하여 결과를 도출하고자 할때 사용 
-- 일반적으로 집계함수와 함께 사용됨 
# select * from jeju2 group by observe_date; -- 에러 
select observe_date from jeju2 group by observe_date; # select위치에서 표현을 해줘야 실행됨  
# select observe_date, speed_80m from jeju2 group by observe_date; -- 에러  
select observe_date, speed_80m from jeju2 group by observe_date, speed_80m; # select위치에서 표현을 해둔것은 group by절에도 표현을 해줘야 함      

select observe_date, avg(speed_80m) from jeju2 group by observe_date;
# 하나로 표현시켜 줘야 함 ?

-- 필터링(HAVING) : 그룹화된 결과에 필터링을 적용하는 명령어 
-- 주의! where절과 사용방법이 같지만 where절은 select 이전에 실행되고 having절은 select 이후에 실행 
select observe_date, avg(speed_80m) as avg 
from jeju2 
group by observe_date
having avg > 5.5;

select observe_date, avg(speed_80m) as avg 
from jeju2 
group by observe_date
having speed_80m > 5.5; -- 에러 #speed_80m는 이 테이블에 대해서는 존재하지 않음 

select observe_date, avg(speed_80m) as avg 
from jeju2 
where speed_80m > 5.5 # 사용하기 위해서는 where절에서 사용해야 함 
group by observe_date; 












