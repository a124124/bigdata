SHOW USER;

SELECT *
    FROM USER_TABLES;       --�� ������ ������ ���̺�
    
SELECT *
    FROM ALL_TABLES
    WHERE TABLE_NAME IN ('DEPT', 'EMP');--�� ������ ���� ������ ���̺�
    
SELECT *
    FROM DBA_TABLES;        -- �Ϲ� ���������� �Ұ�

SELECT ENAME, DNAME, LOC
    FROM SCOTT.EMP E, SCOTT.DEPT D
    WHERE E.DEPTNO = D.DEPTNO;
    
SELECT *
    FROM SCOTT.EMP;
    
EXIT;

SHOW USER;

REVOKE ALL ON EMP FROM JOEUN;
REVOKE ALL ON DEPT FROM JOEUN;

    --����� ���� ���� (�������� �ƴҶ��� ���� ����)
    
DROP USER JOEUN CASCADE;



    -- DML (SELECT, INSERT, UPDATE, DELETE)
    
    --1. INSERT INTO ���̺��̸� VALUES( ��1, ��2...);
    --  INSERT INTO ���̺��̸�( �ʵ��1, �ʵ��2) VALUES(��1, ��2)
    
    
SELECT *
    FROM DEPT01;
    
INSERT INTO DEPT01 VALUES(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01(DEPTNO, DNAME, LOC) VALUES(20, 'SALES', 'BOSTON');
INSERT INTO DEPT01 (DNAME, LOC, DEPTNO) VALUES ('IT', NULL, 30); --��������� NULL �߰�
INSERT INTO DEPT01(DEPTNO, DNAME) VALUES(40, 'OPERATION');



    -- ���������� �̿��� INSERT;
        -- DEPT ���̺��� 10~30 �� �μ��� INSERT
        
        
DESC DEPT01;

TRUNCATE TABLE DEPT01;

INSERT INTO DEPT01 SELECT *
                    FROM DEPT
                    WHERE DEPTNO < 40;
                    
SELECT *
    FROM DEPT01;
    
        --BOOK ���̺��� 11(å��ȣ)��, ����������, �Ѽ�����, ������(����), ���� 90000 
        
DESC BOOK;

INSERT INTO BOOK VALUES(11, '����������', '�Ѽ�����', SYSDATE, 90000);

SELECT *
    FROM BOOK;
    
    
COMMIT ;    -- Ʈ������ ������ ����. �� Ʈ������� �۾��� DB�� �ݿ�
ROLLBACK;

--  ?	SAM01�� ���� : EMPNO(���) ? NUMBER(4)
--	    ENAME(�̸�) ? VARCHAR2(10)
--  	JOB(��å) ? VARCHAR2(9)
--  	SAL(�޿�) ? NUMBER(7,2)
--  ?	SAM01���̺� ������ ���� �����͸� �߰��Ͻÿ�


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


    --2. UPDATE ���̺�� SET �ʵ��1 = ��1[, �ʵ��2 = ��2, ] [WHERE ����];
    
SELECT *
    FROM EMP01;
    
CREATE TABLE EMP01
    AS
    SELECT *
        FROM EMP;
        
    -- �μ� ��ȣ�� 30������ ����
    
UPDATE EMP01 SET DEPTNO = 30;

ROLLBACK;

-- ��� ������ �޿��� 10%�� �λ�

UPDATE EMP01 SET SAL = (SAL * 1.1);



    --10�� �μ� ������ �Ի����� ���÷�, �μ���ȣ�� 30�� �μ��� ����
    
UPDATE EMP01
    SET DEPTNO = 30, HIREDATE = SYSDATE
    WHERE DEPTNO = 10;
    
    -- SAL �� 3000�̻��� ����� �޿�(SAL)�� 10% �λ�
    
UPDATE EMP01
    SET SAL = SAL * 1.1
    WHERE SAL >= 3000;
    
    --DALLAS �� �ٹ��ϴ� ������ �޿��� 1000�޷� �λ�
    
UPDATE EMP01 
    SET SAL = SAL + 1000
    WHERE DEPTNO = (SELECT DEPTNO
                        FROM DEPT
                        WHERE LOC = 'DALLAS');
                        
                        
    --SCOTT �� �μ���ȣ�� 20����, JOB�� MANAGER�� ����
    
UPDATE EMP01
    SET DEPTNO = 20, JOB = 'MANAGER', SAL = SAL + 500, COMM = NVL(COMM, 0) + 500, MGR = (SELECT EMPNO
                                                                                            FROM EMP
                                                                                            WHERE ENAME = 'KING')
    WHERE ENAME = 'SCOTT'; -- ���������� �̿��� UPDATE
    
    
    -- DEPT01 ���� 20������ �������� 60�������� ���������� ����
    
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
    
    -- EMP01 ���̺��� ��� ����� �޿��� �Ի����� KING�� �޿��� �Ի��Ϸ� ����
    
SELECT *
    FROM EMP01;

UPDATE EMP01
    SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE
                                FROM EMP01
                                WHERE ENAME = 'KING');
                                
                                
COMMIT;

    --3. DELETE (DELETE FROM ���̺�� WHERE ����;
    
SELECT *
    FROM EMP01;
DELETE FROM EMP01;

ROLLBACK; -- DML ��� ����

    --  EMP01 ���̺��� 30�μ� ������ ����
DELETE FROM EMP01
        WHERE DEPTNO = 30;
        
    -- EMP01 ���� ������� 'FORD'�� ����� ����
DELETE FROM EMP01
        WHERE ENAME = 'FORD';
        
    -- SAM01 ���̺��� JOB�� �������� �ʴ� ����� ����
DELETE FROM SAM01
        WHERE JOB IS NULL;
        
SELECT *
    FROM SAM01;
    -- EMP01 ���̺��� �μ���(DNAME)�� SALES �� ����� ����

DELETE FROM EMP01
        WHERE DEPTNO = (SELECT DEPTNO
                            FROM DEPT
                            WHERE DNAME = 'SALES');
                            
    --EMP01 ���̺��� RESEARCH �μ� �Ҽ� ����� ����
    
DELETE FROM EMP01
        WHERE DEPTNO = (SELECT DEPTNO
                            FROM DEPT
                            WHERE DNAME = 'RESEARCH');
                            
COMMIT;


    -- �������� PDT PT.1
    -- 1. ���̺� ����

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

    --5. ID 3�� SAL 65000

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


-- ��������

    --  1. PRIMARY KEY : �����ϰ� ���̺��� �� ���� �ĺ��ϴ� �ʵ� (�ߺ�X)
    
    -- 2. NOT NULL : NULL ���� �������� ����.
    
    -- 3. UNIQUE : ��� �࿡ ���� ������, NULL �� ����
    
    -- 4. FOREIGN KEY : ���̺��� ���� �ٸ� ���̺��� ���� ����
    
    -- 5. CHECK(����) : �ش� ������ ����.
    
    -- 6. DEFAULT : �⺻�� ���� (�ش� ���� ������ �Է��� ������ NULL)
    




