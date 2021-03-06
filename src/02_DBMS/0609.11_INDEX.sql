    
    
    --[XI] INDEX : 주키가 아닌 필드 중심으로 조회를 많이 하는 경우 조회속도 향상을 위해 만든다.
    
    
SELECT *
    FROM USER_INDEXES;  --SCOTT 계정이 소유한 인덱스 정보
    
    
DROP TABLE EMP01;

CREATE TABLE EMP01
    AS
    SELECT *
        FROM EMP;
        
SELECT *
    FROM EMP01;
    
INSERT INTO EMP01
    SELECT *
        FROM EMP01;
        
        
SELECT TO_CHAR(COUNT(*), '9,999,999')
    FROM EMP01;
    
    
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO)
    VALUES (1111, 'HONG', 40);
    
INSERT INTO EMP01
    SELECT *
    FROM EMP01;
    
    
    
    -- 인덱스 생성 전 조회속도
    
SELECT *
    FROM EMP01
    WHERE ENAME = 'HONG';
    

CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME);
DROP INDEX IDX_EMP01_ENAME;

SELECT *
    FROM USER_INDEXES
    WHERE INDEX_NAME = 'IDX_EMP01_ENAME';
    
    
    