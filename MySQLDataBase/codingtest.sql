-- substring(컬럼, 자를위치)
-- substring(컬럼, 시작위치, 길이)
-- 자를위치 from 시작위치 for 끝위치

-- left(컬럼 자를위치)
-- right(컬럼, 길이)

SELECT 
    DR_NAME, 
    DR_ID, 
    MCDP_CD, 
    left(HIRE_YMD, 10) as HIRE_YMD
from 
    DOCTOR
where 
    MCDP_CD = 'CS' or MCDP_CD = 'GS'
order by 
    HIRE_YMD desc, DR_NAME asc;
    
    

