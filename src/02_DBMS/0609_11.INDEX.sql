    
    
    --[XI] INDEX : ��Ű�� �ƴ� �ʵ� �߽����� ��ȸ�� ���� �ϴ� ��� ��ȸ�ӵ� ����� ���� �����.
    
    
SELECT *
    FROM USER_INDEXES;  --SCOTT ������ ������ �ε��� ����
    
    
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
    
    
    
    -- �ε��� ���� �� ��ȸ�ӵ�
    
SELECT *
    FROM EMP01
    WHERE ENAME = 'HONG';
    

CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME);
DROP INDEX IDX_EMP01_ENAME;

SELECT *
    FROM USER_INDEXES
    WHERE INDEX_NAME = 'IDX_EMP01_ENAME';
    
    
    