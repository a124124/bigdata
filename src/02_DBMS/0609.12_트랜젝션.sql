    -- [XII] 트랜젝션 명령어 ; (DML 명령어) ; COMMIT, ROLLBACK, SAVEPOINT
    
    
COMMIT; -- 새로운 트랜젝션 시작( INSERT, UPDATE, DELETE 작업 새로 추가될예정)


DROP TABLE DEPT01;

CREATE TABLE DEPT01
    AS 
    SELECT * FROM DEPT;
    
DESC DEPT01;

SELECT *
    FROM DEPT01; -- 10, 20, 30, 40번 부서
    
    
DELETE FROM DEPT01
    WHERE DEPTNO = 40;
    
SELECT *
    FROM DEPT01;
    
ROLLBACK;

    -- 새로운 트랜젝션 시작
    
SELECT *
    FROM DEPT01;
    
DELETE FROM DEPT01
    WHERE DEPTNO = 40;
    
DELETE FROM DEPT01
    WHERE DEPTNO = 30;
    
SAVEPOINT C1;

DELETE FROM DEPT01
    WHERE DEPTNO = 20;
    
SELECT *
    FROM DEPT01;
    
SAVEPOINT C2;

DELETE FROM DEPT01
    WHERE DEPTNO = 10;


ROLLBACK TO C2;



SELECT *
    FROM DEPT01;