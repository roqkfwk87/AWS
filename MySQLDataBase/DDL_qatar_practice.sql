-- qatar asian cup 데이터베이스

# 필드(컬럼)로 생성
-- 참가국 (국가명, 조, 감독, 피파랭킹)
-- 경기장 (경기장명, 수용인원, 주소)
-- 축구선수 (이름, 나이, 포지션, 소속프로팀, 등번호, 국가)
-- 심판 (이름, 나이, 포지션)
# 축구선수는 참가국에 소속된다는 관계가 있음

# 테이블로 생성 
-- 경기 (경기일정, 국가1, 국가2, 경기장, 주심, 선심, 경기결과)
# 참가국끼리 경기를 한다는 관계가 있음 

-- qatar_asian_cup # 테이블 명
-- country (name[가변문자열 30], group_name[가변문자열 1], manager[가변문자열 30], lanking[정수])
 
-- stadium (name[가변문자열 50], capacity[정수], address[가변문자열 255])

-- player (name[가변문자열 30], age[정수], position[가변문자열 15], pro_team[가변문자열 30], uniform_number[정수], country[가변문자열 30]) 
# country name으로 가변문자열 30을 지정해두었기에 똑같이 가져와야 함 / 위에 정의해둔 대로 가져와야 함 

-- referee (name[가변문자열 30], age[정수], position[가변문자열 15])

-- game (schedule[날짜 및 시간], country1[가변문자열 30], country2[가변문자열 30], stadium[가변문자열 50], chief_referee[가변문자열 30], second_referee[가변문자열 30], winning_country[가변문자열 30])

create database qatar_asian_cup;
use qatar_asian_cup;

-- country (name[가변문자열 30], group_name[가변문자열 1], manager[가변문자열 30], lanking[정수])
create table country (
	name varchar(30),
    group_name varchar(1),
    manager varchar(30),
    lanking int
);

-- stadium (name[가변문자열 50], capacity[정수], address[가변문자열 255])
create table stadium (
	name varchar(50),
    capacity int,
    address varchar(255)
);

-- player (name[가변문자열 30], age[정수], position[가변문자열 15], pro_team[가변문자열 30], uniform_number[정수], country[가변문자열 30]) 
create table player (
	name varchar(30),
    age int,
    position varchar(15),
    pro_team varchar(30),
    uniform_number int,
    country varchar(30)
);

-- referee (name[가변문자열 30], age[정수], position[가변문자열 15])
create table referee (
	name varchar(30),
    age int,
    position varchar(15)
);

-- game (schedule[날짜 및 시간], country1[가변문자열 30], country2[가변문자열 30], stadium[가변문자열 50], chief_referee[가변문자열 30], second_referee[가변문자열 30], winning_country[가변문자열 30])
create table game (
	schedule datetime,
    country1 varchar(30),
    country2 varchar(30),
    stadium varchar(50),
    chief_referee varchar(30),
    second_referee varchar(30),
    winning_country varchar(30)
);







# 관계 DBMS 객체 DBMS 차이점
# 객체지향에는 참조변수를 넣을 수 있음 - 하나의 컬럼에다가 여러개의 값을 넣을 수 있음
# 관계 데이터베이스는 하나의 컬럼에다가 한개의 값을 넣을 수 있음 

