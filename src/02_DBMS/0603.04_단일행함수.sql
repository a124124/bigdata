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