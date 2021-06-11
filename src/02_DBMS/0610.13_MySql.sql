-- ORACLE 이랑 다른점
-- DCL (계정 생성, 권한부여, 권한박탈, 계정삭제)
-- DDL (제약조건, 시퀀스 X)
-- DML (OUTER JOIN, AND &&, OR ||, 일부단일행함수)


show databases;  -- database 들의 리스트


use sakila;

show tables;           -- select * from tab;

use world;

-- DCL (계정 생성, 권한부여, 권한박탈, 계정삭제)


create user user01 identified by 'password';

grant all on *.* to user01;
grant all privileges on *.* to user01;
flush privileges;

revoke all privileges on *.* from user01;

drop user user01;


	-- DDL
    -- sql 실행 전 데이터베이스로 들어감
    
    
show databases;

create database kimdb;

use kimdb;		-- kimdb 데이터베이스로 들어감
select database();	-- 현재 들어와있는 데이터 베이스 출력

use world;
use kimdb;
show tables;	-- 들어와 있는 데이터베이스 내의 테이블들


drop table if exists emp;

create table emp (
	empno numeric(4),
    ename varchar(20) not null,
    nickname varchar(20),
    sal numeric(7, 2) ,
    hiredate datetime default now(),
    comm numeric(7, 2) default 0,
     primary key(empno),
     unique(nickname),
     check(sal > 0)
    );
    
select *
	from emp;
    
    
drop table if exists emp;
    
insert into emp(empno, ename, nickname, sal) values(1000, 'kim', 'kim', 9000);


	-- major 테이블 (mCode 시퀸스를 순차번호 pk, mName, mOffice)
    -- student 테이블 (sNo, sName, mCode; foreign key)
    
create table major(
	mCode int primary key auto_increment,  -- auto_increment 일 경우 int
    mName varchar(20),
    mOffice varchar(30));
    
insert into major (mName, mOffice) values ('컴공', '707호');
insert into major (mName, mOffice) values ('경영', '507호');
insert into major (mName, mOffice) values ('디자인', '703호');
insert into major (mName, mOffice) values ('기계', '207호');

select *
	from major;
    
    
create table student(
	sNo int primary key,
    sName varchar(20),
    mCode int references major(mCode)
);


select *
	from student s, major m
    where s.mCode = m.mCode(+);
    
select *
	from student s left join major m
    on s.mCode = m.mCode;
    
    

insert into student values (1111, '홍', 1);
insert into student values (1113, '박', 5);



drop table if exists student;
drop table if exists major;

create table major(
	mCode int auto_increment,
    mName varchar(20),
    mOffice varchar(50),
    primary key(mCode)
);

insert into major(mName, mOffice) values ('컴공', '707호');
insert into major(mName, mOffice) values ('경영', '507호');
insert into major(mName, mOffice) values ('통계', '307호');
insert into major(mName, mOffice) values ('디자인', '107호');

select *
	from major;
    
create table student(
	sNo numeric(4),
    sName varchar(20),
    mCode int,
    primary key(sNo),
    foreign key(mCode)
    references major(mCode)
);

insert into student values(1001, '홍', 5);
insert into student values(1001, '홍', 1);
insert into student values(1004, '김', 2);

select *
	from student s, major m
    where s.mCode = m.mCode;
    
select *
	from student s right outer join major m on s.mCode = m.mCode;
    
    
    
	-- java 시간과 python 시간에 쓸 테이블과 데이터 insert 
    
drop table if exists personal;	-- 사원 테이블
drop table if exists division;	-- 부서 테이블


create table division(
	dno int, 			-- 부서 번호
    dname varchar(20),	-- 부서 이름
    phone varchar(20),	-- 부서 전화
    position varchar(20), -- 부서 위치
    primary key(dno)
);

select *
	from division;
    
create table personal(
	pno int,					-- 사번
    pname varchar(20) not null,	-- 사원명
    job varchar(20) not null, 	-- 직책
    manager int, 				-- 상사의 사번
    startdate date, 			-- 입사일
    pay int,					-- 급여
    bonus int,                  -- 보너스
    dno int,					
    primary key(pno),
    foreign key(dno) references division(dno)
);

select *
	from personal;
    
show tables;
insert into division values (10, 'finance', '021231234', '신촌');
insert into division values (20, 'research', '024355313', '강남');
insert into division values (30, 'sales', '021226434', '마포');
insert into division values (40, 'marketing', '028965543', '강복');


select *
	from division;
    
    
    
insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);

select *
	from personal;
    
commit;
    	
-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay
	from personal;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드

select *
	from personal
    where pay between 2000 and 5000;

-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호

select pno, pname, dno
	from personal
    where dno in(10,20);

-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬

select pno, pname, pay
	from personal
    where bonus is null
    order by pay desc;


-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno, pname, dno, pay
	from personal
    order by dno desc, pay desc;


-- 6. 사번, 이름, 부서명
select pno, pname, dname
	from personal p, division d
    where p.dno = d.dno;


-- 7. 사번, 이름, 상사이름

select p.pno, p.pname, m.pname
	from personal p, personal m
    where p.manager = m.pno;

-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)


select p.pno, p.pname, ifnull(m.pname, '상사없음') manager
	from personal p left outer join personal m on p.manager = m.pno;
   
select *
	from personal;
select *
	from division;


-- 9. 이름이 s로 시작하는 사원 이름

select pname
	from personal
    where pname like 's%';


-- 10. 사번, 이름, 급여, 부서명, 상사이름

select p.pno, p.pname, p.pay, dname, m.pname
	from division d, personal p left outer join personal m on p.manager = m.pno
    where d.dno = p.dno;

use kimdb;


-- 11. 부서코드, 급여합계, 최대급여

select dno, sum(pay) sumpay, max(pay) maxpay
	from personal
    group by dno;

-- 12. 부서명, 급여평균, 인원수

select dname, avg(pay), count(*)
	from personal p, division d
    where p.dno = d.dno
    group by dname;

select *
	from personal;


-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력

select dno, sum(pay) sumpay, count(*) count
	from personal 
    group by dno
    having count(dno) >= 4;



-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람

select pno, pname, pay, max(pay) maxpay
	from personal 
    group by pay
    order by max(pay) desc;
    
   


-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호

select pname, pay, dno
	from personal 
    where pay >= (select avg(pay)
					from personal);


-- 16. 14번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순

select pno, pname, pay, max(pay) maxpay, dname
	from personal p, division d
    where p.dno = d.dno
    group by pay
    order by dname, max(pay) desc;



-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균

select pname, pay, dno, round((select avg(pay) from personal where dno=p.dno)) davgpay
	from personal p
    where pay >= (select avg(pay) from personal where dno=p.dno)
	group by pname;



select dno, avg(pay) from personal p group by dno;

-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명

select pname, pay, dname
	from personal p, division d
    where p.dno = d.dno
    order by startdate;
    

select *
	from personal;


-- 19. 이름, 급여, 해당부서평균

select pname, pay, (select avg(pay) from personal where dno=p.dno) davg
	from personal p
    where (select avg(pay) from personal where dno=p.dno);

-- 20. 이름, 급여, 부서명, 해당부서평균

select pname, pay, dname, (select avg(pay) from personal where dno=p.dno) davg
	from personal p, division d
    where p.dno = d.dno;
    
    
    -- Oracle에서 단일행 함수와 MySQL에서 컬럼함수의 다른 부분
    

select pname, length(pname)
	from personal; 		-- 바이트 수
    
select concat(pname, '은', job, '이다')
	from personal;

select round(34.5678, 1) ;

select year(startdate)
	from personal;
    
select year(startdate), month(startdate), date(startdate)
	from personal;
select monthname(startdate), startdate 
	from personal;
    
insert into personal values (1000, '홍길동', 'manager', 1001, curdate(),null, null, 40);


	-- date_format 에서 포맷 글자 %y (년도 2자리)
		-- %y (년도 2자리) %Y 년도 4자리 %M 월이름 %m 1월,2월
        -- %b (짧은 월이름) %c 월 (1, 2)
        -- %e 일 (1,2,3) %d 일 (01,02,03)
		-- %H (24시간) %h (12시간) %p (오전 오후) %i분 %s초
        
select date_format(sysdate(), '%Y년%m월%d일%H시%i분%s초');

select format(pay, 0) from personal;	--  세자리마다 ,가 찍힌다
select format(pay, 2) from personal;	--  세자리마다 ,가 찍힌다, 소수점 2자리

	--현재 시간날짜
select sysdate();
select now();
	-- 현재 날짜
select current_date();
select curdate();
	-- 현재 시간
select current_time();
select curtime();


	-- top-N 구문
    
select pname, pay
	from personal
    order by pay desc;
	-- limit n 1~n 등
select pname, pay
	from personal
    order by pay desc limit 5;
    
    -- limit n1, n2   n1부터 n2개 가져옴 (첫번째는 0번)
select pname, pay
	from personal
    order by pay desc limit 5, 5;	-- 6~10 까지 출력
    
    -- 4~9 3, 6
select pname, pay
	from personal
    order by pay desc limit 3, 6;    
    -- 6~9 5,4



	-- personal 이름, 급여, 급여가 3천이상인지 아닌지 여부
    
select pname, pay, 