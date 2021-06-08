SHOW USER;

SELECT *
    FROM USER_TABLES;       --내 계정이 소유한 테이블
    
SELECT *
    FROM ALL_TABLES
    WHERE TABLE_NAME IN ('DEPT', 'EMP');--내 계정이 접근 가능한 테이블
    
SELECT *
    FROM DBA_TABLES;        -- 일반 계정에서는 불가

SELECT ENAME, DNAME, LOC
    FROM SCOTT.EMP E, SCOTT.DEPT D
    WHERE E.DEPTNO = D.DEPTNO;
    
SELECT *
    FROM SCOTT.EMP;
    
EXIT;

SHOW USER;

REVOKE ALL ON EMP FROM JOEUN;
REVOKE ALL ON DEPT FROM JOEUN;

    --사용자 계정 삭제 (접속중이 아닐때만 삭제 가능)
    
DROP USER JOEUN CASCADE;



    -- DML (SELECT, INSERT, UPDATE, DELETE)
    
    --1. INSERT INTO 테이블이름 VALUES( 값1, 값2...);
    --  INSERT INTO 테이블이름( 필드명1, 필드명2) VALUES(값1, 값2)
    
    
SELECT *
    FROM DEPT01;
    
INSERT INTO DEPT01 VALUES(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01(DEPTNO, DNAME, LOC) VALUES(20, 'SALES', 'BOSTON');
INSERT INTO DEPT01 (DNAME, LOC, DEPTNO) VALUES ('IT', NULL, 30); --명시적으로 NULL 추가
INSERT INTO DEPT01(DEPTNO, DNAME) VALUES(40, 'OPERATION');



    -- 서브쿼리를 이용한 INSERT;
        -- DEPT 테이블에서 10~30 번 부서를 INSERT
        
        
DESC DEPT01;

TRUNCATE TABLE DEPT01;

INSERT INTO DEPT01 SELECT *
                    FROM DEPT
                    WHERE DEPTNO < 40;
                    
SELECT *
    FROM DEPT01;
    
        --BOOK 테이블에서 11(책번호)번, 스포츠의학, 한솔출판, 출판일(오늘), 가격 90000 
        
DESC BOOK;

INSERT INTO BOOK VALUES(11, '스포츠의학', '한솔출판', SYSDATE, 90000);

SELECT *
    FROM BOOK;
    
    
COMMIT ;    -- 트랜젝션 단위로 진행. 현 트랜잭션의 작업을 DB에 반영
ROLLBACK;

--  ?	SAM01의 구조 : EMPNO(사번) ? NUMBER(4)
--	    ENAME(이름) ? VARCHAR2(10)
--  	JOB(직책) ? VARCHAR2(9)
--  	SAL(급여) ? NUMBER(7,2)
--  ?	SAM01테이블에 다음과 같은 데이터를 추가하시오


DROP TABLE SAM01;

CREATE TABLE SAM01(
                   EMPNO NUMBER(4) CONSTRAINT SAM_PK PRIMARY KEY,
                   ENAME VARCHAR2(10),
                   JOB VARCHAR2(9),
                   SAL NUMBER(7,2)
                   );
        
INSERT INTO SAM01 VALUES(1000, 'APPLE', 'POLICE', 10000);        
INSERT INTO SAM01 VALUES(1010, 'BANANA', 'NURSE', 15000);
INSERT INTO SAM01 VALUES(1020, 'ORANGE', 'DOCTOR', 25000);
INSERT INTO SAM01(EMPNO, ENAME, SAL) VALUES(1030, 'VERY', 25000);
INSERT INTO SAM01(EMPNO, ENAME, SAL) VALUES(1040, 'CAT', 2000);
INSERT INTO SAM01 VALUES(7782, 'CLARK', 'MANAGER', 2450);
INSERT INTO SAM01 VALUES(7839, 'KING', 'PRESIDENT', 5000);
INSERT INTO SAM01 VALUES(7934, 'MILLER', 'CLERK', 1300);
INSERT INTO SAM01
    SELECT EMPNO, ENAME, JOB, SAL   
    FROM EMP
    WHERE DEPTNO = 10;
                   
SELECT *
    FROM SAM01;

SELECT *
    FROM USER_CONSTRAINTS;
    
    
ROLLBACK;

TRUNCATE TABLE SAM01;


    --2. UPDATE 테이블명 SET 필드명1 = 값1[, 필드명2 = 값2, ] [WHERE 조건];
    
SELECT *
    FROM EMP01;
    
CREATE TABLE EMP01
    AS
    SELECT *
        FROM EMP;
        
    -- 부서 번호를 30번으로 수정
    
UPDATE EMP01 SET DEPTNO = 30;

ROLLBACK;

-- 모든 직원의 급여를 10%씩 인상

UPDATE EMP01 SET SAL = (SAL * 1.1);



    --10번 부서 직원의 입사일을 오늘로, 부서번호는 30번 부서로 수정
    
UPDATE EMP01
    SET DEPTNO = 30, HIREDATE = SYSDATE
    WHERE DEPTNO = 10;
    
    -- SAL 이 3000이상인 사원만 급여(SAL)을 10% 인상
    
UPDATE EMP01
    SET SAL = SAL * 1.1
    WHERE SAL >= 3000;
    
    --DALLAS 에 근무하는 직원의 급여를 1000달러 인상
    
UPDATE EMP01 
    SET SAL = SAL + 1000
    WHERE DEPTNO = (SELECT DEPTNO
                        FROM DEPT
                        WHERE LOC = 'DALLAS');
                        
                        
    --SCOTT 의 부서번호는 20으로, JOB은 MANAGER로 수정
    
UPDATE EMP01
    SET DEPTNO = 20, JOB = 'MANAGER', SAL = SAL + 500, COMM = NVL(COMM, 0) + 500, MGR = (SELECT EMPNO
                                                                                            FROM EMP
                                                                                            WHERE ENAME = 'KING')
    WHERE ENAME = 'SCOTT'; -- 서브쿼리를 이용한 UPDATE
    
    
    -- DEPT01 에서 20부터의 지역명을 60번부터의 지역명으로 변경
    
SELECT * FROM DEPT01;



CREATE TABLE DEPT01
    AS
    SELECT *
        FROM DEPT;
        
UPDATE DEPT01 
    SET LOC = (SELECT LOC
                FROM DEPT
                WHERE DEPTNO = 60)
    WHERE DEPTNO = 20;
    
    -- EMP01 테이블의 모든 사원의 급여와 입사일을 KING의 급여와 입사일로 수정
    
SELECT *
    FROM EMP01;

UPDATE EMP01
    SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE
                                FROM EMP01
                                WHERE ENAME = 'KING');
                                
                                
COMMIT;

    --3. DELETE (DELETE FROM 테이블명 WHERE 조건;
    
SELECT *
    FROM EMP01;
DELETE FROM EMP01;

ROLLBACK; -- DML 취소 가능

    --  EMP01 테이블에서 30부서 직원만 삭제
DELETE FROM EMP01
        WHERE DEPTNO = 30;
        
    -- EMP01 에서 사원명이 'FORD'인 사원을 삭제
DELETE FROM EMP01
        WHERE ENAME = 'FORD';
        
    -- SAM01 테이블에서 JOB이 정해지지 않는 사원을 삭제
DELETE FROM SAM01
        WHERE JOB IS NULL;
        
SELECT *
    FROM SAM01;
    -- EMP01 테이블에서 부서명(DNAME)이 SALES 인 사원을 삭제

DELETE FROM EMP01
        WHERE DEPTNO = (SELECT DEPTNO
                            FROM DEPT
                            WHERE DNAME = 'SALES');
                            
    --EMP01 테이블에서 RESEARCH 부서 소속 사원을 삭제
    
DELETE FROM EMP01
        WHERE DEPTNO = (SELECT DEPTNO
                            FROM DEPT
                            WHERE DNAME = 'RESEARCH');
                            
COMMIT;


    -- 연습문제 PDT PT.1
    -- 1. 테이블 생성

    --1.
DROP TABLE MY_DATA;
CREATE TABLE MY_DATA(
    ID NUMBER(4) NOT NULL PRIMARY KEY,
    NAME VARCHAR2(10),
    USERID VARCHAR2(30),
    SALARY NUMBER(10, 2)
    );
    
    --2.
INSERT INTO MY_DATA VALUES(1, 'Scott', 'sscott', TO_NUMBER('10,000.00','99,999.99'));
INSERT INTO MY_DATA VALUES(2, 'Ford', 'fford', 13000);
INSERT INTO MY_DATA VALUES(3, 'Patel', 'ppatel', 33000);
INSERT INTO MY_DATA VALUES(4, 'Report', 'rreport', 23500);
INSERT INTO MY_DATA VALUES(5, 'Good', 'ggood', 44450);

    --3.
    
SELECT ID, NAME, USERID, TO_CHAR(SALARY, '99,999.99') SALARY
    FROM MY_DATA;

    --4.
COMMIT;

    --5. ID 3번 SAL 65000

UPDATE MY_DATA
    SET SALARY = 65000
    WHERE ID = 3;
COMMIT;

    --6. 
DELETE FROM MY_DATA
    WHERE NAME = 'Ford';
COMMIT;

    --7.
UPDATE MY_DATA
    SET SALARY = 15000
    WHERE SALARY <= 15000;
    
    --8.

DROP TABLE MY_DATA;


-- 제약조건

    --  1. PRIMARY KEY : 유일하게 테이블의 각 행을 식별하는 필드 (중복X)
    
    -- 2. NOT NULL : NULL 값을 포함하지 않음.
    
    -- 3. UNIQUE : 모든 행에 대해 유일함, NULL 값 가능
    
    -- 4. FOREIGN KEY : 테이블의 열은 다른 테이블의 열을 참조
    
    -- 5. CHECK(조건) : 해당 조건이 만족.
    
    -- 6. DEFAULT : 기본값 설정 (해당 열의 데이터 입력이 없으면 NULL)
    




