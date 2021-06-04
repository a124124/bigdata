-- [IV] 단일행 함수

--함수 = 단일행함수 + 그룹함수(집계함수)

SELECT HIREDATE, TO_CHAR(HIREDATE, 'YY"년"MM/DD') 
    FROM EMP;
    
SELECT ENAME, INITCAP(ENAME) 
    FROM EMP;

SELECT SUM(SAL)
    FROM EMP; -- 그룹함수(집계함수) 
    
SELECT DEPTNO, SUM(SAL) 
    FROM EMP GROUP BY DEPTNO;     -- 부서번호별 합계
     -- 단일행함수와 집계함수는 같이 쓸 수 없다.


-- EX. 숫자관련, 문자관련, 날짜관련, 형변환(날짜 ->문자 등), NULL관련(NVL) 등...
-- 1. 숫자관련 함수


SELECT ABS(-9) -- 절대값이 나온다
    FROM DUAL;      -- DUAL 테이블의 쓰임새 : 오라클에서 기본적으로 제공하는 1행 1열짜리 더미 테이블
SELECT *
    FROM DUAL;
DESC DUAL;

SELECT *
    FROM DUMMY;
    
    
SELECT FLOOR(34.4265) -- 소수점에서 내림
    FROM DUAL;
    
SELECT FLOOR(34.5696 * 100) / 100 -- 소수점 2번째 자리에서 내림
    FROM DUAL;
    
SELECT TRUNC(34.5696)
    FROM DUAL;
    
SELECT TRUNC(34.5696,2) 
    FROM DUAL;
    
SELECT TRUNC(34.5696, -1) -- 1의자리에서 내림
    FROM DUAL; 
    
  -- EMP 테이블에서 이름 급여(10의자리에서 내림) 출력  
SELECT ENAME, TRUNC(SAL, -2)
    FROM EMP;
    
SELECT CEIL(34.5678) -- 소수점 올림
    FROM DUAL;
    
SELECT ROUND(34.5678) -- 소수점 반올림
    FROM DUAL;
    
SELECT ROUND(34.5678, 2) -- 소수점 2자리에서 반올림
    FROM DUAL;
    
SELECT ROUND(34.5678, -1) -- 1의자리에서 반올림
    FROM DUAL;
    
    
    
SELECT MOD(19, 4) -- 나머지 연산자
    FROM DUAL;
    
SELECT MOD('9' / '2')
    FROM DUAL;
    


    -- EMP 에서 홀수달에 입사한 사람만 출력

SELECT *
    FROM EMP
    WHERE MOD(TO_CHAR(HIREDATE, 'MM'), 2) = 1;



-- 2. 문자관련 함수

SELECT UPPER('abcABC')
    FROM DUAL;
    
SELECT LOWER('abcABC')
    FROM DUAL;

SELECT INITCAP('WELCOME TO ORACLE')
    FROM DUAL;

    -- JOB 이 MANAGER인 직원의 모든 필드

SELECT *
    FROM EMP
    WHERE UPPER(JOB) = 'MANAGER';
    
    --이름이 SCOTT인 직원의 필드
    
SELECT *
    FROM EMP
    WHERE INITCAP(ENAME) = 'Scott';



-- 문자연결 (CONCAT 함수, ||연산자)

SELECT 'AB'||'CD'||'EF'||'GH'   
    FROM DUAL;
    
    
SELECT CONCAT(CONCAT('AB','CD'), CONCAT('EF','GH'))
    FROM DUAL;
    
 -- XXX는 XX다 (SCOTT은 JOB이다) 출력
 
 SELECT CONCAT(CONCAT(ENAME,'은'), CONCAT(JOB,'다'))
    FROM EMP;
    
 -- SUBSTR(STR, 시작BYTE위치, 문자갯수) 첫번째 위치가 1
 SELECT SUBSTR('ORACLE', 3, 2)  --3 번째 글자부터 2글자 추출
    FROM DUAL;
SELECT SUBSTR('데이터베이스', 4, 2)   
    FROM DUAL; 
 
 --SUBSTRB(STR, 시작위치, 문자 BYTE수)
 
 
SELECT SUBSTRB('ORACLE', 3, 2)   -- 3번째 글자부터 2BYTE를 추출
    FROM DUAL;
SELECT SUBSTRB('데이터베이스', 4, 2)   
    FROM DUAL;    
    
    -- 영어는 1BYTE, 한글은 3BYTE
    
    
-- -는 뒤에서부터세고 +는 앞에서부터 센다.
SELECT SUBSTR('WELCOME TO ORACLE', -6, 6)
    FROM DUAL;
    

-- 9월에 입사한 사원의 모든 필드 81/09/01
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

SELECT *
    FROM EMP 
    WHERE SUBSTR(HIREDATE, 4, 2) = '09';
    
SELECT *
    FROM EMP
    WHERE SUBSTR(HIREDATE, -2, 2)= '09';
    
    
SELECT LENGTH('ABCD') 
    FROM DUAL;
    
SELECT LENGTHB('ABCD') 
    FROM DUAL;
    
SELECT LENGTH('오라클') 
    FROM DUAL;
    
SELECT LENGTHB('오라클') 
    FROM DUAL;
-- INSTR(STR, 찾을글자) ; STR 에서 찾을 글자의 위치(첫번째 1), 없으면 0을 리턴한다
-- INSTR(STR, 찾을글자, 시작위치) ; STR 에서 찾을 글자의 위치(첫번째 1), 없으면 0을 리턴한다

SELECT INSTR('ABCABCABC', 'B')
    FROM DUAL;
    
SELECT INSTR('ABCABCABC', 'B', 3)
    FROM DUAL;    

SELECT * 
    FROM EMP
    WHERE INSTR(HIREDATE, '09', 3) = 4;

SELECT *
    FROM EMP
    WHERE INSTR(HIREDATE, '09', 6)= 7;
    
-- LPAD(STR, 자리수, 채울문자) STR을 자리수만큼 확보하고 왼쪽 빈자리에 채울 문자를 출력

SELECT LPAD('ORACLE', 10, '#')
    FROM DUAL;
    
    
SELECT ENAME, SAL 
    FROM EMP;
    
SELECT ENAME, LPAD(SAL, 6, '*')
    FROM EMP;
    
    -- 사번, S**** (이름 앞 한글자만 출력)
    -- RPAD, SUBSTR, LENGTH 사용

SELECT RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*')
    FROM EMP;
ROLLBACK;
    --  사번  이름  입사일
    -- 7499 _***H 80/12/**
    
SELECT EMPNO, LPAD(LPAD(SUBSTR(ENAME, -1, 1), LENGTH(ENAME), '*'), 10, ' ') NAME,
       RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*')HIRE
    FROM EMP;



-- 이름의 세번째 자리가 R인 사원의 모든 필드 출력(LIKE, INSTR, SUBSTR)

SELECT *
    FROM EMP
    WHERE ENAME LIKE '__R%';
    
SELECT *
    FROM EMP
    WHERE INSTR(ENAME, 'R', 3) = 3;

SELECT *
    FROM EMP
    WHERE SUBSTR(ENAME, 3, 1) ='R';
    
    
SELECT TRIM(' ORACLE DB     ') MSG 
    FROM DUAL;
    
SELECT LTRIM('         ORACLE DB     ') MSG 
    FROM DUAL;
    
SELECT RTRIM('      ORACLE DB     ') MSG 
    FROM DUAL;
 
 
 SELECT REPLACE(ENAME, 'A', 'XX')
    FROM EMP;
    
SELECT REPLACE(HIREDATE, '0', 'XXX')
    FROM EMP;
    
    
    
-- 3. 날짜관련 함수 및 예약어 

SELECT SYSDATE 
    FROM DUAL;
    
SELECT TO_CHAR(SYSDATE, 'YY-MM-DD HH24:MI:SS')
    FROM DUAL;
    
    -- 오라클 타입 : 문자, 숫자, DATE
    
    
SELECT SYSDATE -1, SYSDATE, SYSDATE +1
    FROM DUAL;
    
-- 14일 후

SELECT SYSDATE + 14
    FROM DUAL;
    
    
-- EMP 에서 이름, 입사일, 근무날짜를 계산

SELECT ENAME, HIREDATE, FLOOR(SYSDATE - HIREDATE)
    FROM EMP;
    
    --이름, 입사일, 근무주수, 근무년수
SELECT ENAME, HIREDATE, FLOOR((SYSDATE - HIREDATE) / 7) WEEK
    FROM EMP;    
SELECT ENAME, HIREDATE, FLOOR((SYSDATE - HIREDATE) / 365) YEAR
    FROM EMP;
    
    --이름, 입사일, 근무월수 MONTHS_BETWEEN() 함수를 사용
    
SELECT ENAME, HIREDATE, FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE)) MONTHS
    FROM EMP;
    
    -- 이름, 입사일, 수습종료시점(수습 3개월이라고 치자) ADD_MONTHS()함수
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 3) AN
    FROM EMP;
    
    
-- 이름, 입사한 이후 받은 급여와 상여(급여는 매달 SAL을 받고 상여금은 2번 COMM을 받음)

SELECT ENAME, TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE) * SAL +
              TRUNC((SYSDATE-HIREDATE)/365)*2*NVL(COMM,0)) "COST" 
              FROM EMP;


-- NEXT_DAY(특정날자, '수') 특정날짜로부터 처음 맞는 수요일

SELECT NEXT_DAY(SYSDATE,'토')
    FROM DUAL;


--LAST_DAY(특정날짜) ; 특정날짜 달의 말일

SELECT LAST_DAY(SYSDATE)
    FROM DUAL;
    
    
-- EMP 이름, 입사일, 첫월급날(월급날 말일)

SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE)
    FROM EMP;
    

-- ROUND; 날짜 반올림 TRUNC ; 날짜 버림

SELECT ROUND(34.5678,2) 
    FROM DUAL;

SELECT ROUND(SYSDATE, 'YEAR') -- 가까운 1월 1일
    FROM DUAL;

SELECT ROUND(SYSDATE, 'MONTH') -- 가까운 1일
    FROM DUAL;
    
SELECT ROUND(SYSDATE, 'DAY') -- 가까운 일요일
    FROM DUAL;
    
SELECT ROUND(SYSDATE)       -- 가까운 0시
    FROM DUAL; 
    
SELECT TRUNC(SYSDATE, 'YEAR')
    FROM DUAL;

SELECT TRUNC(SYSDATE, 'MONTH')
    FROM DUAL;

SELECT TRUNC(SYSDATE, 'DAY')
    FROM DUAL;

SELECT TRUNC(SYSDATE)
    FROM DUAL;
    
-- 이름 , 입사일, 입사한 달의 2일
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH') +1
    FROM EMP;
-- 이름 , 입사일, 월급날(5일) ; 입사한지 한달이 안되어도 5일되면 무조건 지급
SELECT ENAME, HIREDATE, ROUND(HIREDATE +11, 'MONTH') +4 
    FROM EMP;
-- 이름 , 입사일, 월급날(15일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE +1, 'MONTH') +14 
    FROM EMP;
-- 이름 , 입사일, 월급날(25일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9, 'MONTH') +24 
    FROM EMP;
    
    
    
-- 4 형변환 함수 TO_CHAR() 문자로 형변환// TO_DATE() DATE형으로 형변환
-- 1. TO_CHAR(DATE형 데이터, '출력형식')
SELECT TO_CHAR(SYSDATE, 'YY"년"MM"월"DD"일"DY"요일"HH24:MI:SS')
    FROM DUAL;
    -- YYYY 년도 RR 년도 MM 월 DD 일 
    --DAY 요일 / DY 요일 요약표현
    --AM PM HH12 HH24 MI SS
    
SELECT ENAME, TO_CHAR(HIREDATE, 'YY/MM/DD DY AM HH12:MI:SS')
    FROM EMP;
    
 
SELECT TO_CHAR(12345678, '999,999,999') -- 자리수가 많아도 숫자만큼만 출력
    FROM DUAL;
    
    
SELECT TO_CHAR(12345678, '000,000,000') -- 자리수가 많으면 0으로 출력
    FROM DUAL;
    
    -- 세자리마다 , 가능 . 소수점 가능
    -- l 지역통화단위
    
SELECT TO_CHAR(1000, 'L9,999')
    FROM DUAL;
    
SELECT ENAME, SAL, TO_CHAR(SAL, '$99,999') 
    FROM EMP;
    
    
    --2. TO_DATE(문자, '패턴')
    
SELECT TO_DATE('81/01/01', 'YY/MM/DD')
    FROM DUAL;
    
SELECT *
    FROM EMP
    WHERE HIREDATE BETWEEN '81/05/01' AND '83/05/01';
    
    
    
    ROLLBACK;
    
    
-- TO_NUMBER(문자, 패턴)

SELECT TO_NUMBER('3,456.78', '9,999.99') 
    FROM DUAL;

SELECT '3456.78' +1
    FROM DUAL;
    
 --5. NVL(NULL 일수 있는 데이터, NULL 이면 대신할 값) -- 타입이 일치해야함
 -- 이름, 상사의 사번(MGR) 을 출력 , 직속 상사가 없을 경우 CEO 라고 출력
 
 SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO')
    FROM EMP;
    
    
    --6. ETC
    
    --1 EXTRACT ; 년도나 월만 추출하고자 할 때
    
SELECT EXTRACT(YEAR FROM SYSDATE) 
    FROM DUAL;
    
SELECT TO_CHAR(SYSDATE, 'YYYY')
    FROM DUAL;
    
SELECT EXTRACT(MONTH FROM SYSDATE) 
    FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'MM')  
    FROM DUAL;
    
    --81 년도에 입사한 직원
    
SELECT *
    FROM EMP
    WHERE EXTRACT(YEAR FROM HIREDATE) = 1981;
    
SELECT *
    FROM EMP
    WHERE HIREDATE BETWEEN
        TO_DATE('1981-01-01', 'YYYY-MM-DD') AND TO_DATE('1981-12-31', 'YYYY-MM-DD');
        


    --(2) 레벨별 출력 : LEVEL , START WITH 조건, CONNECT BY PRIOR 조건
    
    
SELECT LEVEL, LPAD(' ', LEVEL * 2) ||  ENAME 
    FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO = MGR;
    
    -- <총 연습문제>
-- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT SYSDATE "Current Date"
    FROM DUAL;


-- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여,
-- 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장
SELECT EMPNO, ENAME, JOB, SAL, SAL * 1.15 "New Salary", SAL * 0.15 "Increase"
    FROM EMP;


ROLLBACK;
--3. 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.

SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '월') "6MONTHLATER"
    FROM EMP;

--4. 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 출력
SELECT ENAME, HIREDATE, FLOOR((SYSDATE - HIREDATE) / 7) WEEK, SAL, FLOOR((SYSDATE - HIREDATE) / 7) * SAL TOTSAL
    FROM EMP;


--5. 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력
SELECT ENAME, LPAD(SAL, 15, '*') 
    FROM EMP;
-- RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*')HIRE



--6. 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY') DAY
    FROM EMP;


--7. 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력
SELECT ENAME, LENGTH(ENAME) , JOB
    FROM EMP
    WHERE LENGTH(ENAME) >=6;



--8. 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력
SELECT ENAME, JOB, SAL, NVL(COMM ,0) COMM, SAL + NVL(COMM ,0) TOTAL
    FROM EMP;


-- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT SUBSTR(ENAME, 2, 3)
    FROM EMP;
 



--10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 
--  시스템에 따라 DATEFORMAT 다를 수 있으므로 아래의 방법도 알아보자

SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE TO_CHAR(HIREDATE, 'MM') = 12;


--11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO		ENAME		급여
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--……. 

SELECT EMPNO, ENAME, LPAD(SAL ,10, '*') 급여
    FROM EMP;





-- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
-- EMPNO	 ENAME 	입사일
-- 7369	  SMITH		1980-12-17
-- ….

SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') 입사일
    FROM EMP;


--13. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.
    --(급여는 앞에 $를 삽입하고3자리마다 ,를 출력한다)
    
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$999,999,999') "SAL"
    FROM EMP
    WHERE DEPTNO = 20;
    



-- [V] 그룹 함수

SELECT ENAME, ROUND(SAL, -3)     -- 단일행 함수
    FROM EMP;
    
SELECT MAX(SAL)    -- 그룹함수 
    FROM EMP;
    
SELECT ENAME, MAX(SAL)
    FROM EMP;              -- VI 장 서브쿼리에서 해결
    
SELECT DEPTNO, MAX(SAL) 
    FROM EMP
    GROUP BY DEPTNO;


--1. 그룹함수들 실습

SELECT ROUND(AVG(SAL),2) 
    FROM EMP;
    
SELECT COUNT(SAL)  -- SAL 이 포함된 행의 갯수
    FROM EMP;
    
SELECT COUNT(*)  -- EMP 테이블의 총 행(로우)의 개수
    FROM EMP;


SELECT COMM
    FROM EMP;
    
SELECT SUM(COMM)
    FROM EMP;

SELECT AVG(COMM)
    FROM EMP;
    
SELECT COUNT(COMM)
    FROM EMP;
    
    --모든 그룹함수는 NULL 값을 제외한다.
    
    --SAL 의 평균, 합, 최소값, 최대값, 분산, 표준편차
    
    
SELECT AVG(SAL), SUM(SAL), MIN(SAL), MAX(SAL), ROUND(VARIANCE(SAL)), ROUND(STDDEV(SAL)), COUNT(SAL)
    FROM EMP;
    
SELECT SQRT(VARIANCE(SAL)), STDDEV(SAL)
    FROM EMP;
    
-- 그룹함수 MAX, MIN, COUNT 는 숫자형, 문자형, 날짜형 모두 사용 가능

    --가장 최근에 입사한 사원의 입사일과 오래된 사원의 입사일

SELECT MIN(HIREDATE), MAX(HIREDATE)
    FROM EMP;
    -- 83/01/12 : XXX,XXX일(근무일수)

SELECT '최근입사일은 ' || MAX(HIREDATE) || '근무 일수는 ' || TO_CHAR(MIN(TRUNC(SYSDATE-HIREDATE)), '99,999') ||'일' MSG,
       '최초입사일은 ' || MIN(HIREDATE) || '근무 일수는 ' || TO_CHAR(MAX(TRUNC(SYSDATE-HIREDATE)), '99,999') ||'일' MSG2
    FROM EMP;
    
    -- 10번 부서 사원의 평균 급여
    
SELECT AVG(SAL)
    FROM EMP
    WHERE DEPTNO= 10;
    
    
    
    --2. GROUP BY 절
    
    --부서번호별 최대급여
    
SELECT DEPTNO, MAX(SAL)
    FROM EMP
    GROUP BY DEPTNO;
    
    --부서번호별 사원수, 최대급여 최소급여 평균급여 소수점 2자리
    
SELECT DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL), 2)
    FROM EMP
    GROUP BY DEPTNO;

-- SAL 이 5000미만인 사원에 대해서만 부서번호별 사원수, 최대급여, 최소급여, 평균급여

SELECT DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL), 2)
    FROM EMP
    WHERE SAL < 5000
    GROUP BY DEPTNO
    ORDER BY DEPTNO;
    
    -- 부서명별 사원수, 최대급여, 최소급여, 평균급여

SELECT DNAME, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL), 2)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    
    GROUP BY DNAME
    ORDER BY DNAME;
    
    
-- 3. HAVING 절 ; 그룹 함수 결과의 조건

--부서별 평균 급여( 평균 급여가 2000 이상인 부서만 출력)

SELECT DEPTNO, ROUND(AVG(SAL), 2) AVG_SAL
    FROM EMP
    HAVING AVG(SAL) >= 2000
    GROUP BY DEPTNO
    ORDER BY AVG_SAL DESC ; -- 필드의 별칭은 ORDER BY 절에서만 사용 가능
    -- HAVING 은 별칭을 사용할 수 없음. 
    
    

-- 4. 결과 집합 내 집계갑 생성

SELECT DEPTNO, SUM(SAL)
    FROM EMP
    GROUP BY ROLLUP(DEPTNO);
    
    
    
    -- ★<총 연습문제>

-- 1. 사원 테이블에서 인원수,최대 급여,최소 급여,급여의 합을 계산하여 출력


SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL)
    FROM EMP;


-- 2. 사원테이블에서 업무별 인원수를 구하여 출력하는 SELECT 문장을 작성하여라.

SELECT JOB, COUNT(*)
    FROM EMP
    GROUP BY JOB;



--- 3. 사원테이블에서 최고 급여와 최소 급여의 차이는 얼마인가 출력하는 SELECT문장을 작성하여라.

SELECT MAX(SAL), MIN(SAL), MAX(SAL) - MIN(SAL) SN
    FROM EMP;


-- 4. 각 부서별로 인원수, 급여 평균, 최저 급여, 최고 급여, 급여의 합을 출력하되 급여의 합이 많은 순으로 출력하라.

SELECT DEPTNO, COUNT(*), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO
    ORDER BY SUM(SAL) DESC;
    
    
SELECT DNAME, COUNT(*), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    GROUP BY DNAME
    ORDER BY SUM(SAL) DESC;


-- 5. 부서별, 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 
    --구하여 출력하라(출력결과는 부서번호, 업무순으로 오름차순 정렬)

SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO, JOB;


-- 6. 업무별, 부서별 그룹하여 결과를  업무, 부서번호, 인원수, 급여의 평균, 급여의 합을 구하여 
-- 출력하라.(출력결과는 업무순, 부서번호 순 오름차순 정렬)

SELECT JOB, DEPTNO, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB, DEPTNO
    ORDER BY JOB, DEPTNO;



--7. 사원수가 5명이상 넘는 부서번호와 사원수를 출력하시오.

SELECT DEPTNO, COUNT(*) C
    FROM EMP
    HAVING COUNT(*) >= 5
    GROUP BY DEPTNO;


-- 8. 사원수가 5명이상 넘는 부서명과 사원수를 출력하시오
SELECT DNAME, COUNT(*)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    HAVING COUNT(*) >= 5
    GROUP BY DNAME;

--9. 사원 테이블에서 업무별 급여의 평균이 3000이상인 업무에 대해서 업무명, 평균 급여, 
--급여의 합을 구하여 출력하라

SELECT JOB, AVG(SAL), SUM(SAL)
    FROM EMP
    HAVING AVG(SAL) >= 3000
    GROUP BY JOB;




--10. 사원테이블에서 급여합이 5000을 초과하는 각 업무에 대해서 업무와 급여합계를 출력하라 
        --단, 급여 합계로 내림차순 정렬하라.
        
SELECT JOB, SUM(SAL)
    FROM EMP
    HAVING SUM(SAL) > 5000
    GROUP BY JOB
    ORDER BY SUM(SAL) DESC;
        

--11. 부서별 급여평균, 부서별 급여합계, 부서별 최소급여를 출력하라.

SELECT DEPTNO, AVG(SAL), SUM(SAL), MIN(SAL)
    FROM EMP
    GROUP BY DEPTNO;



--12. 위의 11번을 수정하여, 부서별 급여평균 최대치, 부서별 급여합의 최대치, 
            --부서별 최소급여의 최대치를 출력하라.

SELECT MAX(AVG(SAL)), MAX(SUM(SAL)), MAX(MIN(SAL))
    FROM EMP
    GROUP BY DEPTNO;         
            

--13. 사원 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.(년도별 연봉합)
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--     80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100

SELECT  TO_CHAR(HIREDATE, 'RR') H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE, 'RR')
    ORDER BY H_YEAR;

    
    





-- 14.  사원테이블에서 아래의 결과를 출력하는 SELECT 문 작성
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	

SELECT NVL(TO_CHAR(HIREDATE, 'YYYY'), 'TOTAL') YEAR, COUNT(*) CNT
    FROM EMP
    
    GROUP BY ROLLUP(TO_CHAR(HIREDATE, 'YYYY'))
    
    ORDER BY TO_CHAR(HIREDATE, 'YYYY');



--15. 사원테이블에서 최대급여, 최소급여, 전체급여합, 평균을 구하시오

SELECT MAX(SAL), MIN(SAL), SUM(SAL), AVG(SAL)
    FROM EMP;


--16. 사원테이블에서 부서별 인원수를 구하시오

SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO;

--17. 사원 테이블에서 부서별 인원수가 6명이상인 부서코드를 구하시오

SELECT DEPTNO
    FROM EMP
    HAVING COUNT(*) >= 6
    GROUP BY DEPTNO;

--18. 사원테이블에서 급여가 높은 순서대로 등수를 부여하여 다음과 같은 결과가 나오게 하시오. 
-- (힌트 self join, group by, count사용)
--ENAME	    등수
--________________________
--KING		1
--SCOTT		2
--……


SELECT E1.ENAME, E1.SAL, E2.ENAME, E2.SAL
    FROM EMP E1, EMP E2
    WHERE E1.SAL < E2.SAL(+); -- 1단계



SELECT E1.ENAME, COUNT(E2.ENAME) + 1 "RANK"
    FROM EMP E1, EMP E2
    WHERE E1.SAL < E2.SAL(+)
    GROUP BY E1.ENAME
    ORDER BY RANK;  -- GROUP BY, COUNT




SELECT ENAME, RANK() OVER(ORDER BY SAL DESC) "RANK",
              DENSE_RANK() OVER(ORDER BY SAL DESC) "DENSE_RANK",
              ROW_NUMBER() OVER(ORDER BY SAL DESC) "ROW_NUMBER"
    FROM EMP;



