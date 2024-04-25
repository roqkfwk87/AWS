-- 학교 (school) 데이터베이스

-- 엔터티 및 속성:

-- 학과 (department)

-- - 학과ID (department_id): 유일한 식별자로 5자리의 문자열로 구성된다.
-- - 학과명 (name): 학과의 이름으로 20자 이하의 문자열로 구성되며 고유한 값을 가지며 필수로 입력되어야 한다.
-- - 사무실 위치 (office_location): 학과 사무실의 위치로 150자 이하의 문자열로 구성되며 필수로 입력되어야 한다.
-- - 연락처 (contact_number): 학과 사무실 연락처로 15자 이하의 문자열로 구성되며 고유한 값을 가지며 필수로 입력되어야 한다.

CREATE TABLE department (
    department_id VARCHAR(5) PRIMARY KEY,
    name VARCHAR(20) UNIQUE NOT NULL,
    office_location VARCHAR(150) NOT NULL,
    contact_number VARCHAR(15) UNIQUE NOT NULL
);

-- 학생 (student)

-- - 학번 (student_number): 유일한 식별자로 7자리의 숫자로 이루어진 문자열로 구성된다.
-- - 이름 (name): 학생의 이름으로 20자 이하의 문자열로 구성되며 필수로 입력되어야 한다.
-- - 학년 (year): 학생의 학년으로 1~4의 정수를 가질수 있으며 필수로 입력되어야 한다.
-- - 이메일 (email): 학생의 이메일 주소로 50자 이하의 문자열로 구성되며 고유한 값을 가지며 필수로 입력되어야 한다.
-- - 학과ID (department_id): 학생이 속한 학과의 ID로 필수로 입력되어야 한다.

CREATE TABLE student (
    student_number VARCHAR(7) PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    -- check문으로 year BETWEEN 1 AND 4 비교함 (부호, 숫자 비교, 문자 비교)
    year INT NOT NULL CHECK (year BETWEEN 1 AND 4),
    email VARCHAR(50) UNIQUE NOT NULL,
    department_id VARCHAR(5) REFERENCES department(department_id) ON DELETE CASCADE
);

-- 과목 (course)

-- - 과목코드 (course_code): 유일한 식별자로 5자리의 문자열로 구성된다.
-- - 과목명 (title): 과목의 이름으로 40자 이하의 문자열로 구성되며 고유한 값을 가지며 필수로 입력되어야 한다.
-- - 학점 (credits): 과목이 부여하는 학점으로 실수를 가질수 있으며 필수로 입력되어야 한다.

CREATE TABLE course (
    course_code VARCHAR(5) PRIMARY KEY,
    title VARCHAR(40) UNIQUE NOT NULL,
    credits FLOAT NOT NULL
);

-- 교수 (professor)

-- - 교수ID (professor_id): 유일한 식별자로 7자리의 문자열로 구성된다.
-- - 이름 (name): 교수의 이름으로 20자 이하의 문자열로 구성되며 필수로 입력되어야 한다.
-- - 전공 (specialization): 교수의 전공 분야로 40자 이하의 문자열로 구성되며 필수로 입력되어야 한다.
-- - 사무실 위치 (office_location): 교수의 사무실 위치로 150자 이하의 문자열로 구성되며 필수로 입력되어야 한다.
-- - 학과ID (department_id): 교수가 속한 학과의 ID

CREATE TABLE professor (
    professor_id VARCHAR(7) PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    specialization VARCHAR(40) NOT NULL,
    office_location VARCHAR(150) NOT NULL,
    department_id VARCHAR(5) REFERENCES department(department_id) ON DELETE CASCADE
);

-- 관계:

-- 학과와 학생: 한 한과에는 여러 학생이 속할 수 있으며 학생은 반드시 하나의 학과에 속해야 한다.
-- 학과와 교수: 한 학과에는 여러 교수가 속할 수 있으며 교수는 반드시 하나의 학과에 속해야 한다.
-- 교수와 과목: 한 교수는 여러 과목을 가르칠 수 있으며 과목은 반드시 한명의 교수에 의해 진행되어야 하고 교수는 강의를 반드시 하지는 않는다.
-- 학생과 과목: 학생은 여러 과목을 수강할 수 있으며 과목은 여러 학생에 의해 수강될 수 있다. 또한 학생이 특정 과목을 수강하면 실수 형태의 평점(grade)이 나온다.

-- 학생과 과목의 관계를 나타내는 테이블 생성
CREATE TABLE student_course (
    student_number VARCHAR(7) REFERENCES student(student_number) ON DELETE CASCADE,
    course_code VARCHAR(5) REFERENCES course(course_code) ON DELETE CASCADE,
    grade FLOAT,
    PRIMARY KEY (student_number, course_code)
);

-- 교수와 과목의 관계를 나타내는 테이블 생성
CREATE TABLE professor_course (
    professor_id VARCHAR(7) REFERENCES professor(professor_id) ON DELETE CASCADE,
    course_code VARCHAR(5) REFERENCES course(course_code) ON DELETE CASCADE,
    PRIMARY KEY (professor_id, course_code)
);


----------------------------------------------------------------------------------------------------
# NOT NULL 제약 조건은 해당 열이 NULL 값을 허용하지 않음을 나타냄. 즉, 해당 열에는 항상 데이터가 있어야 함

# department(department_id)와 같은 형식은 
# 외래 키(Foreign Key)를 정의할 때 사용하는데, 이 형식은 외래 키가 참조하는 테이블과 해당 테이블의 열을 지정하는 것이다.
# ex) student(department_id) REFERENCES department(department_id)

# REFERENCES 사용 법 
-- CREATE TABLE 테이블이름 (
--     열이름 데이터타입,
--     FOREIGN KEY (현재열이름) REFERENCES 참조테이블이름(참조열이름)
-- );

# ON DELETE CASCADE는 외래 키(Foreign Key) 제약 조건에서 사용되는 옵션 중 하나
# 이 옵션은 참조된 행이 삭제될 때 연결된 모든 행을 자동으로 삭제하도록 데이터베이스에 지시함
# 데이터의 무결성을 유지하고 연결된 데이터를 일관된 상태로 유지

# PRIMARY KEY (student_number, course_code)는 두 열인 student_number와 
# course_code를 함께 복합 기본 키(Composite Primary Key)로 설정한 것
# 이렇게 함으로써 데이터베이스에서 각 행을 고유하게 식별할 수 있습니다.
