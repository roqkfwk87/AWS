-- 1. 로그인 화면
-- : 아이디와 비밀번호를 입력하여 로그인 / 카카오, 네이버로 SNS 로그인을 할 수 있음

-- 2. 회원가입 화면
-- : 아이디, 비밀번호, 비밀번호확인, 이메일, 인증번호를 입력하여 회원가입 
-- : 아이디에 대한 중복확인이 필요
-- : 이메일 인증을 통해서 인증코드를 지정한 이메일로 전송
-- : 전송받은 인증 코드를 입력하여 이메일 인증 처리를 함
-- : 카카오, 네이버로 SNS 회원가입을 할 수 있음 

-- 3. Q&A 게시판 목록 화면
-- : 관리자 계정만 미완료 보기를 할 수 있음
-- : 미완료 보기 체크시 답변이 미완료된 게시물을 조회 
-- : 게시물 목록은 하나의 아이템에 대하여 접수번호, 완료상태, 제목, 작성자 아이디, 작성일, 조회수를 보여줌 (접수번호 기준으로 내림차순 정렬하여 보여줌)
-- : 게시물 제목으로 검색을 할 수 있음

-- 4. Q&A 게시물 작성 화면
-- : 제목, 내용을 작성할 수 있음 

-- 5. 게시물 보기 화면
-- : 제목, 작성자 아이디, 작성일, 조회수, 내용, 답변 내용을 조회  
-- : 만약 관리자로 로그인 상태이면 답변 내용으로 답변을 작성할 수 있음 
-- : 게시물을 삭제 할 수 있음 

-- 6. 게시물 수정 화면 
-- : 제목과 내용을 수정할 수 있음 

---------------------------------------------------------------------------------------------

# Entity(객체) - (행위를 하는 독립적인 주체), attribute(속성)
-- User(회원)
-- : id, password, email, join_path(카카오, 네이버 같은 sns 로그인), role(회원 또는 관리자 가입), authentication_code(인증코드)
-- Q&A (qna 게시물)
-- : reception_number, title, write_datetime, contents, view_count, writer_id, reply, reply_status 

-------------------------------------------------------------------------------------------------

# relationship(관계)
-- user - Q&A
-- : 일반 회원이 게시물을 작성한다.
-- : 관리자 회원이 답변을 작성한다. 

-----------------------------------------------------------------------------------------------------

# table
-- user
-- 	   id varchar(20) primary key, # 중복되는지 확인이 가능하기 때문에 unique, not null 가능, 기본키 지정
--     password varchar(13) not null, # 필수 입력  
--     email varchar(50) not null unique, 
--     join_path varchar(5) not null default 'HOME' check(join_path in('HOME', 'KAKAO', 'NAVER')), # home으로 지정해줌  
--     role varchar(5) not null default 'nomal' check(role in('admin', 'nomal'))

--    # authentication_code varchar(4) not null # authentication_code는 이메일을 설명함 

# 이 코드를 추가하여 authentication_code varchar(4) not null 제거 시킴 
-- Email_authentication
-- 	email varchar(50) primary key,
-- 	authentication_code varchar(4) not null

/* 반정규화를 시키기 때문에 따로 테이블을 생성하지 않아도 사용가능 
# 접수번호, 완료상태, 제목, 작성자 아이디, 작성일, 조회수 -- 완료상태가 Q&A 쪽에 없어서 reply랑 join을 해야 함 
# 제목, 작성자 아이디, 작성일, 조회수, 내용, 답변 내용을 조회 -- 답변 내용을 join 함 
# 이렇게 설정하면 처리 속도가 늦어지기 때문에 반정규화를 진행시킴 

reply # reply 테이블을 따로 생성 
    reception_number int,
    reply varchar(20),
    reply Text, 
    reply_status boolean not null default false 
*/

-- Q&A
-- 	   reception_number Int primary key auto_increment,
-- 	   title Text not null, 
--     contents Text not null, 
--     write_datetime datatime not null default now(), 
--     view_count Int not null default 0, 
--     writer_id varchar(20) not null, 
--     reply Text , 
--     reply varchar(20),
--     reply_status boolean not null default false 

----------------------------------------------------------------------------------------------------------

# relationship(관계)
# user - Q&A : 회원은 여러 개의 게시물을 작성할 수 있고 게시물은 반드시 한 명의 회원에 의해 작성되어짐 
# user - Q&A : 관리자 회원은 여러 개의 게시물에 답변을 작성할 수 있고 게시물은 한 명의 관리자에 의해 작성되어짐 

# FK writer User (id) - Q&A (writer_id)  
# FK replyer User (id) - Q&A (replyer)  

# FK email_auth Email_Authentication (email) - user (email)  

-----------------------------------------------------------------------------------------------------------

-- 1. 아이디 중복환인 
select * from user where user_id = 'userID'; 

-- 2. 이메일 인증 전송 
insert into email_authentication values ('email@email.com', 'QWER');

-- 3. 이메일 인증 확인 
select * from email_authentication 
where email = 'email@email.com' and authentication_code = 'QWER';

-- 4. 회원가입 처리
insert into user (user_id, password, email)
values ('user_id', 'P!ssw0rd', 'email@email.com');

-- 5. 로그인 처리 
select user_id from user
where user_id = 'user_id' and password = 'P!ssw0rd';

-- 6. 게시물 작성 
insert into qna (title, contents, writer_id)
values ('질문있습니다.', '데이터는 언제 데이터인가요?', 'user_id');

-- 7. 게시물 목록 보기
-- 접수번호, 완료 상태, 제목, 작성자 아이디, 작성일, 조회수 
select reception_number, reply_status, title, writer_id, write_datetime, view_count
from qna
order by reception_number desc;

-- 8. 관리자로 미완료 게시물 보기
select reception_number, reply_status, title, writer_id, write_datetime, view_count
from qna
where reply_status is false 
order by reception_number desc;

-- 9. 검색 게시물 목록 보기 
select reception_number, reply_status, title, writer_id, write_datetime, view_count
from qna
where title like '%질문%'
order by reception_number desc;

-- 10. 특정 게시물 보기 
select title, writer_id, write_datetime, view_count, contents, reply 
from qna 
where reception_number = 1;

-- 11. 관리자로 답변 작성
update qna set reply = '2023년 데이터입니다.', replyer_id ='user_ID', reply_status = 1 
where reception_number = 1;

-- 12. 게시물 수정하기 
update qna set title = '변경한 제목입니다.', contents = '변경한 내용입니다.'
where reception_number = 1;

-- 13. 게시물 삭제하기 
delete from qna where reception_number = 1;

# 이런 형식으로 시험 출제 됨 
# DML 13개 만들기
# DCL 권한부여 
# veiw로 검색하는 것












