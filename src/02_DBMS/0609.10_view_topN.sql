    --[X] VIEW, INLINE VIEW, TOP-N 구문
    
    
    --1. VIEW : 가상의 테이블
        -- (1) 단일뷰

CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DEPTNO
        FROM EMP;
        
SELECT *
    FROM USER_VIEWS;

SELECT *
    FROM EMP;
        
SELECT *
    FROM EMPv0;
    
INSERT INTO EMPv0 VALUES(9000, '홍', 'MANAGER', 40);
        
UPDATE EMPv0 SET JOB = 'ANALYST'
    WHERE EMPNO = 9000;


DELETE FROM EMPv0 WHERE EMPNO = 9000;


    --  EMPv0 이라는 뷰 = EMP 테이블에서 30번 부서만
    
CREATE OR REPLACE VIEW EMPv0
    AS SELECT *
        FROM EMP
        WHERE DEPTNO = 30;

SELECT *
    FROM EMPV0;
    
DESC EMPv0;
INSERT INTO EMPv0 VALUES(1111, 'HONG', NULL, NULL, NULL, NULL, NULL, 30);

SELECT *
    FROM EMPv0 
    WHERE EMPNO = 1111;
    
SELECT *
    FROM EMP
    WHERE EMPNO = 1111;
    
    -- EMPv0 은 30번 부서만 액세스 할수있는 뷰 = 40번 부서 입력은 가능하나 보이지는 않음
    
INSERT INTO EMPv0 VALUES(1112, 'KIM', NULL, NULL, NULL, NULL, NULL, 40);


DELETE FROM EMPv0
    WHERE EMPNO < 2000; -- 1111은 삭제되나 1112는 삭제되지않음 . 30번 부서만 엑세스할수있기때문에
    
SELECT *
    FROM EMP;
    
    --VIEW의 제한 조건
    --WITH CHECK OPTION 을 설정한 뷰는 조건에 해당되는 데이터만 삽입,수정,삭제 가능
    --WITH READ ONLY 를 설정한 뷰는 읽기전용

    -- 테이블에 NOT NULL 로 만든 컬럼은 포함되어야함
    
CREATE OR REPLACE VIEW EMPv0
    AS SELECT ENAME, JOB
        FROM EMP;
        
        
INSERT INTO EMPv0 VALUES('훙','MANAGER');

SELECT *
    FROM EMPv0;
    
    --WITH CHECK OPTION
    
CREATE OR REPLACE VIEW EMPv0
    AS SELECT *
        FROM EMP
        WHERE DEPTNO = 30
        WITH CHECK OPTION; -- 조건에 맞는 경우만 추가 가능
        
        
INSERT INTO EMPv0 VALUES(1111,'G',NULL,NULL,NULL,NULL,NULL,30);

INSERT INTO EMPv0 VALUES(1121,'G',NULL,NULL,NULL,NULL,NULL,40); -- 에러남, 30번 부서가 아니기때문에


DELETE FROM EMPv0 WHERE EMPNO = 1111;


    -- VIEW READ ONLY
    
CREATE OR REPLACE VIEW EMPv1
    AS SELECT *
        FROM EMP
        WHERE DEPTNO = 20
        WITH READ ONLY;         -- 읽기 전용 뷰
        
SELECT E.*, DNAME
    FROM EMPv1 E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO;
    
UPDATE EMPv1 
    SET SAL = 9000
    WHERE EMPNO = 7902;
    

        
        -- (2) 복합뷰 ; 2개 이상의 테이블로 구성한 뷰, DML 문을 제한적으로만 사용
        

CREATE OR REPLACE VIEW EMPV0
    AS SELECT EMPNO, ENAME, JOB, DNAME
    FROM DEPT D, EMP E
    WHERE D.DEPTNO = E.DEPTNO;
    
SELECT *
    FROM EMPv0;
    
INSERT INTO EMPv0 VALUES(1200,'HONG','MANAGER','RESEARCH');      -- 복합뷰는 갱신 불가

    -- 컬럼에 별칭을 이용하여 뷰를 생성 (필드에 특수문자가 있는 경우 반드시)
    
CREATE OR REPLACE VIEW EMPv1
    AS SELECT EMPNO NO, ENAME NAME, SAL * 12 YEAR_SAL
    FROM EMP
    WHERE DEPTNO = 10;

SELECT *
    FROM EMPV1;
    
INSERT INTO EMPv1 VALUES(1000,'행',12000);  -- 가상의 필드가 있어서 불가



CREATE OR REPLACE VIEW EMPv1
    AS SELECT EMPNO, ENAME, SAL * 12 SAL
    FROM EMP
    WHERE DEPTNO = 10;
    
    
    
    -- 사번, 이름, 10의 자리에서 반올림한 SAL 의 뷰 생성
    
CREATE OR REPLACE VIEW EMPv1
    AS SELECT EMPNO, ENAME, ROUND(SAL, -2) SAL
    FROM EMP;
    

    
SELECT *
    FROM EMPV1;
    
    
    -- 부서번호, 최소급여, 최대급여, 부서평균 VIEW 
    
    
CREATE OR REPLACE VIEW DEPTv0
    AS SELECT DEPTNO, MIN(SAL) MIN, MAX(SAL) MAX, AVG(SAL) AVG
    FROM EMP
    GROUP BY DEPTNO;
    
    
    
    -- 부서번호, 부서명, 최소급여, 최대급여, 평균급여 DEPTv1 뷰
    
CREATE OR REPLACE VIEW DEPTv2
    AS 
    SELECT D0.DEPTNO, DNAME, MIN, MAX, AVG
    FROM DEPT D, DEPTv0 D0
    WHERE D.DEPTNO = D0.DEPTNO
    ;
    
SELECT *
    FROM DEPTv2;
    
    
    --DISTINCT 키워드를 이용한 뷰 ; 중복이 제거된 JOB, DEPTNO 

SELECT JOB, DEPTNO
    FROM EMP;
    
CREATE OR REPLACE VIEW EMPv0
    AS
    SELECT DISTINCT JOB, DEPTNO
    FROM EMP;
    
    
SELECT *
    FROM EMPV0;
    
INSERT INTO EMPv0 VALUES('MANAGER','10');   -- DISTINCT 를 포함한 뷰는 읽기 전용




    -- 2. INLINE VIEW ; FROM 절 상의 서브쿼리를 INLINE VIEW 라고 하며, FROM 절에 오는 서브쿼리는 VIEW처럼 작용
    
    -- 급여가 2천초과 사원의 평균 급여
    
SELECT AVG(SAL)
    FROM EMP
    WHERE SAL > 2000;
    
SELECT AVG(SAL)
    FROM (SELECT SAL
            FROM EMP
            WHERE SAL > 2000);
            
    -- 각 부서에서 부서평균급여보다 높은 사원의 이름, 급여, 부서번호
    
SELECT ENAME, SAL, DEPTNO
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL)
                    FROM EMP
                    WHERE DEPTNO = E.DEPTNO);
                    
                    
    -- FROM 절에 올 서브쿼리 (부서번호, 평균급여) : 1단계

CREATE OR REPLACE VIEW GG
AS
SELECT DEPTNO, AVG(SAL) AVG
    FROM EMP
    GROUP BY DEPTNO;
    
    -- 이름, 급여, 부서번호, 부서별 평균 : 2단계
SELECT ENAME, SAL, SS.DEPTNO, SS.AVGSAL
    FROM EMP, (SELECT DEPTNO, AVG(SAL) AVGSAL
                    FROM EMP
                    GROUP BY DEPTNO) SS
    WHERE ENAME = 'SCOTT';
        --SELECT 필드1, 필드2...
        --    FROM 테이블명1, (서브쿼리) 별칭
        --    WHERE 조인조건
        
        

    -- 이름, 급여, 부서번호(부서별 평균보다 높은 사람만) : 3단계
    
SELECT ENAME, SAL, SS.DEPTNO
    FROM EMP, (SELECT DEPTNO, AVG(SAL) AVGSAL
                    FROM EMP
                    GROUP BY DEPTNO) SS
    WHERE EMP.DEPTNO = SS.DEPTNO AND SAL > AVGSAL;
    
    
    
    --TOP-N 구문 ( 조건대로 등수 정렬)
    -- ROWNUM ; 테이블로부터 가져온 순서
SELECT ROWNUM, ENAME 
    FROM EMP
    WHERE DEPTNO = 20;
    
    
SELECT *
    FROM EMP
    ORDER BY SAL;
    
DELETE FROM EMP
    WHERE SAL IS NULL;
    
    
SELECT ROWNUM, ENAME, SAL
    FROM EMP;
    
    
SELECT ROWNUM, ENAME, SAL
    FROM EMP
    ORDER BY SAL;
    
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT *
            FROM EMP
            ORDER BY SAL);
            
        -- SAL 기준 1~5등
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT ENAME, SAL
            FROM EMP
            ORDER BY SAL)
    WHERE ROWNUM < 6;
    
    
    -- 함수를 이용한 RANK출력
    
SELECT RANK() OVER(ORDER BY SAL) RANK,
    DENSE_RANK() OVER(ORDER BY SAL) D_RANK,
    ROW_NUMBER() OVER(ORDER BY SAL) N_RANK,
    ENAME, SAL
    FROM EMP;


    -- SAL 기준으로 6~10등
    
SELECT ROWNUM, ENAME, SAL
    FROM EMP
    WHERE ROWNUM BETWEEN 6 AND 10;
    
    
    --TOP N
    
SELECT ENAME, SAL
    FROM EMP
    ORDER BY SAL;                    -- 1단계
    
SELECT ROWNUM RN, ENAME, SAL
    FROM (SELECT ENAME, SAL
                FROM EMP
                ORDER BY SAL)
    ORDER BY SAL;                   -- 2단계
    

SELECT ROWNUM, RN, ENAME, SAL
    FROM (SELECT ROWNUM RN, ENAME, SAL
            FROM (SELECT ENAME, SAL
                        FROM EMP
                        ORDER BY SAL)
            ORDER BY SAL);              -- 3단계
            
            
SELECT ROWNUM, RN, ENAME, SAL
    FROM (SELECT ROWNUM RN, ENAME, SAL
                FROM (SELECT *
                        FROM EMP
                        ORDER BY SAL))
    WHERE RN BETWEEN 6 AND 10;          -- 완성
    
    
    -- 이름을 알파벳 순으로 정렬해서 6~10번 출력 (등수, 이름, 사번, JOB, MGR, HIREDATE)


SELECT ROWNUM, RN, ENAME, EMPNO, JOB, MGR, HIREDATE
    FROM (SELECT ROWNUM RN, A.*
            FROM (SELECT *
                    FROM EMP
                    ORDER BY ENAME) A
            ORDER BY ENAME)
    WHERE RN BETWEEN 10 AND 14;
    
    
SELECT *
    FROM EMP
    ORDER BY ENAME;
    
    
    
-- <총 연습문제>
-- 1. 부서명과 사원명을 출력하는 용도의 뷰, DNAME_ENAME_VU 를 작성하시오
CREATE OR REPLACE VIEW DNAME_ENAME_VU
    AS
    SELECT DNAME, ENAME
    FROM DEPT D, EMP E
    WHERE D.DEPTNO = E.DEPTNO;

SELECT *    
    FROM DNAME_ENAME_VU;


-- 2. 사원명과 직속상관명을 출력하는 용도의 뷰,  WORKER_MANAGER_VU를 작성하시오



CREATE OR REPLACE VIEW WORKER_MANAGER_VU
    AS
    SELECT E.ENAME, W.ENAME WN
    FROM EMP E, EMP W
    WHERE E.MGR = W.EMPNO(+);



SELECT *
    FROM WORKER_MANAGER_VU;


-- 3. 부서별 급여합계 등수를 출력하시오(부서번호, 급여합계, 등수). ? 친구출제



    

SELECT DEPTNO, SUM(SAL) SUMSAL
    FROM EMP E
    GROUP BY DEPTNO ORDER BY SUMSAL DESC;
   

SELECT ROWNUM RANK, A.*
    FROM (SELECT DEPTNO, SUM(SAL) SUMSAL
            FROM EMP 
            GROUP BY DEPTNO 
            ORDER BY SUMSAL DESC) A;    




-- 3-1. 부서별 급여합계 등수가 2~3등인 부서번호, 급여합계, 등수를 출력하시오.

SELECT RANK, DEPTNO, SUMSAL
    FROM (SELECT ROWNUM RANK, DEPTNO, SUMSAL
                FROM (SELECT DEPTNO, SUM(SAL) SUMSAL
                        FROM EMP 
                        GROUP BY DEPTNO ORDER BY SUMSAL DESC) A)
    WHERE RANK BETWEEN 2 AND 3;
            





-- 4. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 순으로 정렬하시오


SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    ORDER BY HIREDATE DESC;



-- 5. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 5명을 출력하시오

SELECT EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, A.*
                FROM (SELECT *
                        FROM EMP
                        ORDER BY HIREDATE) A
                ORDER BY HIREDATE)
    WHERE RN < 6;
         




-- 6. 사원 테이블에서 사번, 사원명, 입사일을 최신부터 오래된 순으로 6번째로 늦은 사원부터 10번째 사원까지 출력

SELECT EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, A.*
                FROM (SELECT *
                        FROM EMP
                        ORDER BY HIREDATE) A
                ORDER BY HIREDATE)
    WHERE RN BETWEEN 6 AND 10;
    
    

