 -- [VI] SUB QUERY ; QUERY 안에 QUERY 가 내포
 
 --1 . 서브 쿼리 개념
 
 -- 급여를 제일 많이 받는 사람의 이름과 급여
 

 
 SELECT ENAME, MAX(SAL) 
    FROM EMP
    GROUP BY ENAME;  -- 한명이 아니고 다나온다
    
 
 SELECT MAX(SAL) 
    FROM EMP;    
    
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL = (SELECT MAX(SAL) FROM EMP); -- 메인쿼리 (실행할 쿼리) 괄호를 꼭 해야한다.
    
    
    
            
            
            
 -- 2. 단일행 서브쿼리
 
 -- SCOTT 이 근무하는 부서이름 출력
 -- 서브쿼리 종류 (1) 단일행 서브쿼리(서브쿼리 결과가 1행) = > >= != < <= ... EQUAL 연산자 사용 가능.
 
 
 SELECT DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
    AND ENAME = 'SCOTT'; -- EQUI JOIN
    
SELECT DEPTNO
    FROM EMP
    WHERE ENAME = 'SCOTT';     -- SUB QUERY
    
SELECT DNAME 
    FROM DEPT
    WHERE DEPTNO = (SELECT DEPTNO 
                    FROM EMP
                    WHERE ENAME = 'SCOTT');   --MAIN QUERY
                    
                    
                    
--     (2) 다중행 서브쿼리(서브쿼리 결과가 2행 이상) EQUAL 연산자 사용 불가 
    -- IN, ANY, ALL, EXISTS 

    --JOB 이 MANAGER인 사람의 부서 이름    
    
SELECT DEPTNO
    FROM EMP
    WHERE JOB = 'MANAGER';
    
SELECT DNAME 
    FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO
                     FROM EMP
                     WHERE JOB = 'MANAGER');
    
    
   -- SCOTT 과 같은 부서번호인 사람의 이름과 급여
   
SELECT DEPTNO
    FROM EMP
    WHERE ENAME = 'SCOTT';
    
    
SELECT ENAME, SAL
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                    FROM EMP
                    WHERE ENAME = 'SCOTT')
    AND ENAME != 'SCOTT';
    
    
INSERT INTO DEPT VALUES(50, 'IT', 'DALLAS');
DESC EMP;
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (9999,'HONG', 50);

    

    -- SCOTT 과 같은 근무지인 사람의 이름과 급여 

SELECT LOC
    FROM DEPT D, EMP E
    WHERE E.DEPTNO = D.DEPTNO
    AND ENAME = 'SCOTT'; -- 서브쿼리
    

SELECT ENAME, NVL(SAL ,0)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
    AND LOC = (SELECT LOC
               FROM DEPT D, EMP E
               WHERE E.DEPTNO = D.DEPTNO
               AND ENAME = 'SCOTT')
    AND ENAME != 'SCOTT'; -- 메인쿼리
    
    
ROLLBACK;




-- SCOTT 과 같은 부서에 근무하는 사람의 급여합

SELECT DEPTNO
    FROM EMP
    WHERE ENAME = 'SCOTT';
    

SELECT SUM(SAL)
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                    FROM EMP
                    WHERE ENAME = 'SCOTT')
    AND ENAME != 'SCOTT';
    


-- SCOTT 과 같은 JOB을 가진 사원의 모든 필드를 출력


SELECT JOB
    FROM EMP
    WHERE ENAME = 'SCOTT'; -- SUB
    
    
SELECT *
    FROM EMP
    WHERE JOB = (SELECT JOB
                 FROM EMP
                 WHERE ENAME = 'SCOTT');
                 
                 
                 
    --DALLAS 에서 근무하는 사원의 이름, 부서번호

SELECT DEPTNO
    FROM DEPT
    WHERE LOC = 'DALLAS';
    
SELECT ENAME, DEPTNO
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                 FROM DEPT
                 WHERE LOC = 'DALLAS');
    
    
    
-- SALES (DNAME) 부서에 근무하는 사원의 이름 급여

SELECT ENAME, SAL 
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                    FROM DEPT
                    WHERE DNAME = 'SALES');
                    
    -- KING 이 직속상사인 사원의 이름과 급여
    
SELECT ENAME, SAL
    FROM EMP
    WHERE MGR = (SELECT EMPNO
                 FROM EMP
                 WHERE ENAME = 'KING');
                 
    -- 평균 급여 이하로 받는 사원의 이름과 급여

SELECT AVG(SAL)
    FROM EMP;
   
    
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL)
                 FROM EMP);
    
    
    -- 평균 급여 이하로 받는 사원의 이름과 급여, 평균급여 출력

SELECT AVG(SAL)
    FROM EMP;
    
SELECT ENAME, SAL, (SELECT ROUND(AVG(SAL)) FROM EMP) AVG 
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL)
                  FROM EMP);
    
    
    
    -- 평균 급여 이하로 받는 사원의 이름과 급여, 평균급여와 차이를 출력

SELECT ENAME, SAL, ABS((SELECT ROUND(AVG(SAL),2) FROM EMP) - SAL) DIFF
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    
    
-- SCOTT과 JOB과 DEPTNO 가 같은 직원의 모든 필드 출력

SELECT JOB, DEPTNO 
    FROM EMP
    WHERE ENAME = 'SCOTT'; -- 다중열 서브쿼리
    
SELECT *
    FROM EMP
    WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO 
                           FROM EMP
                           WHERE ENAME = 'SCOTT')         -- 다중열 서브쿼리는 순서가 중요하다.
    AND ENAME != 'SCOTT';
                           
              
                           
                           
                           
                           
                           
                           
-- ★ 총 연습문제
--1. 사원테이블에서 가장 먼저 입사한 사람의 이름, 급여, 입사일

SELECT MIN(HIREDATE)
    FROM EMP;
    
SELECT ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE)
                      FROM EMP);


-- 2. 회사에서 가장 급여가 적은 사람의 이름, 급여

SELECT ENAME, SAL
    FROM EMP
    WHERE SAL = (SELECT MIN(SAL)
                 FROM EMP);


-- 3. 회사 평균보다 급여를 많이 받는 사람의 이름, 급여, 부서코드

SELECT ROUND(AVG(SAL), 2)
    FROM EMP;
    
SELECT ENAME, SAL, DEPTNO
    FROM EMP
    WHERE SAL >= (SELECT ROUND(AVG(SAL), 2)
                  FROM EMP);



--4. 회사 평균 이하의 급여를 받는 사람의 이름, 급여, 부서명

SELECT ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE SAL <= (SELECT AVG(SAL)
                  FROM EMP)
    AND E.DEPTNO = D.DEPTNO;



--5. SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급
SELECT HIREDATE
    FROM EMP
    WHERE ENAME = 'SCOTT';

SELECT * FROM SALGRADE;

SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    AND HIREDATE < (SELECT HIREDATE
                     FROM EMP
                     WHERE ENAME = 'SCOTT');
    


--6. 5번(SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급)에 부서명 추가하고 급여가 큰 순 정렬


SELECT ENAME, SAL, HIREDATE, GRADE, DNAME
    FROM EMP E, SALGRADE, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL
    AND HIREDATE < (SELECT HIREDATE
                     FROM EMP
                     WHERE ENAME = 'SCOTT')
    AND E.DEPTNO = D.DEPTNO
    ORDER BY SAL DESC;
 
--7. BLAKE 보다 급여가 많은 사원들의 사번, 이름, 급여

SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT SAL
                 FROM EMP
                 WHERE ENAME = 'BLAKE');


--8. MILLER보다 늦게 입사한 사원의 사번, 이름, 입사일

SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE > (SELECT HIREDATE
                        FROM EMP
                        WHERE ENAME = 'MILLER');


--9. 사원전체 평균 급여보다 급여가 많은 사원들의 사번, 이름, 급여

SELECT AVG(SAL)
    FROM EMP;


SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL)
                 FROM EMP);

--10. CLARK와 같은 부서번호이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원들의 사번, 이름, 급여

SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                    FROM EMP
                    WHERE ENAME = 'CLARK')
    AND SAL > (SELECT SAL
               FROM EMP
               WHERE EMPNO = 7698);
    
    
--    WHERE EMPNO = 7698;

--11.  응용심화. CLARK와 같은 부서명이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원들의 사번, 이름, 급여

SELECT DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    AND ENAME = 'CLARK';



--12. BLAKE와 같은 부서에 있는 모든 사원의 이름과 입사일자

SELECT ENAME, HIREDATE
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO 
                    FROM EMP
                    WHERE ENAME = 'BLAKE');



--13. 평균 급여 이상을 받는 모든 종업원에 대해서 사원번호와 이름 단 급여가 많은 순으로 출력)
SELECT EMPNO, ENAME FROM EMP
    WHERE SAL >= (SELECT AVG(SAL) FROM EMP)
    ORDER BY SAL DESC;





-- 3. 다중행 서브쿼리; IN, ALL, ANY = SOME, EXISTS

-- (1) IN  ; 서브쿼리 결과 중 하나라도 일치하면 TRUE가 됨
-- 부서별로 입사일이 가장 늦은 사람의 이름, 입사일, 부서번호
SELECT DEPTNO, MAX(HIREDATE)
    FROM EMP
    GROUP BY DEPTNO;

SELECT ENAME, HIREDATE, DEPTNO
    FROM EMP
    WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE)
                                 FROM EMP
                                 GROUP BY DEPTNO);

-- 급여가 3천이상인 사원이 소속된 부서에서 근무하는 사람의 모든 필드

SELECT DEPTNO   
    FROM EMP
    WHERE SAL >= 3000;
    
SELECT *
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO
                     FROM EMP
                     WHERE SAL >= 3000);


-- (2) ALL ; 모두 만족해야한다.

SELECT MAX(SAL)
    FROM EMP
    WHERE DEPTNO = 30;
    
    
    
SELECT * 
    FROM EMP
    WHERE SAL > ALL (SELECT SAL
                     FROM EMP
                     WHERE DEPTNO = 30);


SELECT *
    FROM EMP
    WHERE SAL > (SELECT MAX(SAL)
                 FROM EMP
                 WHERE DEPTNO = 30);


-- (3) ANY ; 서브쿼리 결과 하나라도 만족하면 참
-- 30번 부서 최소 급여보다 큰경우 

SELECT *  
    FROM EMP
    WHERE SAL > ANY (SELECT SAL
                     FROM EMP
                     WHERE DEPTNO = 30);
                     
SELECT *
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL)
                 FROM EMP
                 WHERE DEPTNO = 30);

-- (4) EXISTS ; 서브쿼리가 존재하면 참
-- 직속부하가 있는 직원들의 사번, 이름, 급여

SELECT EMPNO, ENAME, SAL
    FROM EMP MANAGER
    WHERE EXISTS (SELECT *
                  FROM EMP
                  WHERE MANAGER.EMPNO = MGR);

SELECT W.ENAME, M.EMPNO, M.ENAME, M.SAL
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
    
SELECT DISTINCT M.EMPNO, M.ENAME, M.SAL
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
    
-- 말단사원의 모든 필드 출력
SELECT *
    FROM EMP MANAGER
    WHERE NOT EXISTS (SELECT *
                      FROM EMP
                      WHERE MANAGER.EMPNO = MGR);
                      
SELECT M.*
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO
    AND W.ENAME IS NULL;
     
     
     --EX1 JOB 이 MANAGER 인 사람이 속한 부서의 부서번호와 지역명
SELECT DEPTNO, LOC
    FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO
                  FROM EMP
                  WHERE JOB = 'MANAGER');
    
     
     
     --EX2 연봉이 3천이상인 사람중 급여등급별 최고 연봉을 받는 사람들의 사번, 이름, 직업, 입사일, 급여, 급여등급 (4,5등급 최고 SAL 누구인가)
     
SELECT GRADE, MAX(SAL)
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >= 3000
    GROUP BY GRADE;
    
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    AND (GRADE, SAL) IN (SELECT GRADE, MAX(SAL)
                         FROM EMP, SALGRADE
                         WHERE SAL BETWEEN LOSAL AND HISAL 
                         AND SAL >= 3000
                         GROUP BY GRADE);
     
     
     --EX3 입사 분기별 최고 연봉을 받는 사원의 분기, 사번, 이름, 직업, 입사일, 급여, 상여
SELECT HIREDATE, CEIL(TO_CHAR(HIREDATE, 'MM') / 3) MONTH
    FROM EMP;                      -- 분기 구하는 식
     

SELECT CEIL(TO_CHAR(HIREDATE, 'MM') / 3) QUARTER, MAX(SAL)
    FROM EMP
    GROUP BY CEIL(TO_CHAR(HIREDATE, 'MM') / 3)
    ORDER BY QUARTER;
    
SELECT CEIL(TO_CHAR(HIREDATE, 'MM') / 3) QUARTER, EMPNO, ENAME, JOB, HIREDATE, SAL, NVL(COMM, 0)
    FROM EMP
    WHERE (CEIL(TO_CHAR(HIREDATE, 'MM') / 3), SAL) IN (SELECT CEIL(TO_CHAR(HIREDATE, 'MM') / 3) QUARTER, MAX(SAL)
                                                           FROM EMP
                                                           GROUP BY CEIL(TO_CHAR(HIREDATE, 'MM') / 3))
    ORDER BY QUARTER;
     
     

     --EX4 SALESMAN 의 모든 사원들보다 급여를 많이 받는 사원의 이름, 급여(ALL)
     
     
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL > ALL (SELECT SAL 
                         FROM EMP
                         WHERE JOB = 'SALESMAN');


SELECT ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT MAX(SAL)
                 FROM EMP
                 WHERE JOB = 'SALESMAN')
    ORDER BY SAL;
     

     
     --EX5 급여가 3천미만인 사람 중 최근 입사한 사람의 사번, 이름, 연봉, 입사일

SELECT MAX(HIREDATE)
    FROM EMP
    WHERE SAL < 3000;
    

SELECT EMPNO, ENAME, SAL * 12 + NVL(COMM, 0) ANNUAL_SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE)
                        FROM EMP
                        WHERE SAL < 3000);




-- 여기서부터는 다중행서브쿼리와 단일행서브쿼리, 이전은 단일행서브쿼리
-- 14.  이름에 “T”가 있는 사원이 근무하는 부서에서 근무하는 모든 직원의 사원 번호,이름,급여(단 사번 순 출력)

SELECT DEPTNO
    FROM EMP
    WHERE ENAME LIKE ('%T%');
    


SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO
                        FROM EMP
                        WHERE ENAME LIKE '%T%')
    ORDER BY EMPNO;


-- 15. 부서 위치가 Dallas인 모든 종업원에 대해 이름,업무,급여
SELECT LOC
    FROM DEPT
    WHERE LOC = 'DALLAS';
    
SELECT ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    AND LOC = (SELECT LOC
               FROM DEPT
               WHERE LOC = 'DALLAS');



-- 16. EMP 테이블에서 King에게 보고하는 모든 사원의 이름과 급여

SELECT EMPNO
    FROM EMP
    WHERE ENAME = 'KING';
    
SELECT ENAME, SAL
    FROM EMP
    WHERE MGR = (SELECT EMPNO
                   FROM EMP
                   WHERE ENAME = 'KING');



-- 17. SALES부서 사원의 이름, 업무

SELECT DNAME
    FROM DEPT
    WHERE DNAME = 'SALES';
    
SELECT ENAME, JOB
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    AND DNAME = (SELECT DNAME
                 FROM DEPT
                 WHERE DNAME = 'SALES');

    



-- 18. 월급이 부서 30의 최저 월급보다 높은 사원의 모든 필드

SELECT MIN(SAL)
    FROM EMP
    WHERE DEPTNO = 30;
    
SELECT *
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL)
                        FROM EMP
                        WHERE DEPTNO = 30);
                        



-- 19. 부서 10에서 부서 30의 사원과 같은 업무를 맡고 있는 사원의 이름과 업무

SELECT JOB
    FROM EMP
    WHERE DEPTNO = '30'
    GROUP BY JOB;
    
SELECT ENAME, JOB
    FROM EMP
    WHERE DEPTNO = '10' AND JOB IN (SELECT JOB
                                        FROM EMP
                                        WHERE DEPTNO = '30'
                                        GROUP BY JOB);


-- 20.  FORD와 업무도 월급도 같은 사원의 모든 필드

SELECT JOB, SAL
    FROM EMP
    WHERE ENAME = 'FORD';
    
    
SELECT *
    FROM EMP
    WHERE (JOB, SAL) IN (SELECT JOB, SAL
                            FROM EMP
                            WHERE ENAME = 'FORD')
    AND ENAME != 'FORD';

-- 21. 이름이 JONES인 직원의 JOB과 같거나 FORD의 SAL 이상을 받는 사원의 정보를 이름, 업무, 부서번호, 급여
    -- 단, 업무별 알파벳 순, 월급이 많은 순으로 출력

SELECT JOB
    FROM EMP
    WHERE ENAME = 'JONES';
    
SELECT SAL
    FROM EMP
    WHERE ENAME = 'FORD';

SELECT ENAME, JOB, EMPNO, SAL
    FROM EMP
    WHERE JOB = (SELECT JOB
                    FROM EMP
                    WHERE ENAME = 'JONES')
    OR SAL >= (SELECT SAL
                FROM EMP
                WHERE ENAME = 'FORD')
    ORDER BY JOB, SAL;

-- 22. SCOTT 또는 WARD와 월급이 같은 사원의 정보를 이름,업무,급여

SELECT ENAME, JOB, SAL FROM EMP
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME = 'SCOTT' OR ENAME = 'WARD');



-- 23. CHICAGO에서 근무하는 사원과 같은 업무를 하는 사원들의 이름,업무



-- 24. 부서별로 월급이 평균 월급보다 높은 사원을 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL, DEPTNO,  (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO) AVG
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO);
    




-- 25. 업무별로 평균 월급보다 적은 월급을 받는 사원을 부서번호, 이름, 급여

SELECT DEPTNO, ENAME, SAL, JOB
    FROM EMP E
    WHERE SAL < (SELECT AVG(SAL)
                 FROM EMP
                 WHERE JOB = E.JOB);



-- 26. 적어도 한 명 이상으로부터 보고를 받을 수 있는 사원을 업무, 이름, 사번, 부서번호를 출력(단, 부서번호 순으로 오름차순 정렬)
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP M
    WHERE EXISTS (SELECT *
                    FROM EMP
                    WHERE MGR = M.EMPNO);       -- EXISTS 이용
                    
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP
    WHERE EMPNO IN (SELECT MGR  
                        FROM EMP);         --  IN 이용
    
    
SELECT DISTINCT M.JOB, M.ENAME, M.EMPNO, M.DEPTNO
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;



-- 27.  말단 사원의 사번, 이름, 업무, 부서번호


SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP M
    WHERE NOT EXISTS (SELECT *
                        FROM EMP
                        WHERE NOT MGR IS NULL);
                        
                        
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP
    WHERE EMPNO NOT IN(7902, 7698);
    
    
    
SELECT W.ENAME, M.JOB, M.ENAME, M.EMPNO, M.DEPTNO
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL;
    
    
    
    