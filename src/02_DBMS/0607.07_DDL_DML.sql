        -- [VII] DDL, DML, DCL
        
    --SQL == DDL(���̺� ����, ���̺����, ���̺� ��������)
    
    
--      DML (SELECT, INSERT, UPDATE, DELETE)
--      DCL (��������, ����� ���� �ο�, ���� ��Ż, ����� ���� ����, Ʈ������ ��ɾ�)



-- DDL 
    --1. ���̺� ���� (CREATE TABLE)
    
DESC EMP;


CREATE TABLE BOOK(
    BOOKID NUMBER(4), -- ������ȣ BOOKID �ʵ��� Ÿ���� ���� 4�ڸ�
    BOOKNAME VARCHAR2(20), -- ���� �̸� BOOKNAME �ʵ��� Ÿ���� ���� 20BYTE
    PUBLISHER VARCHAR2(20), -- ���ǻ� ���� 20BYTE
    RDATE     DATE,  -- ������ Ÿ���� DATE��
    PRICE NUMBER(8),
    PRIMARY KEY(BOOKID)); -- ���̺� �� ��Ű(PRIMARY KEY) ����(����, NOT NULL)
    
    
SELECT *
    FROM BOOK;
    
    
DROP TABLE BOOK; -- ���̺� ����

CREATE TABLE BOOK(
    BOOKID NUMBER(4) PRIMARY KEY, -- PRIMARY KEY(���� ����)
    BOOKNAME VARCHAR2(100),
    PUBLISHER VARCHAR2(20),
    RDATE DATE,
    PRICE NUMBER(8)
    );
    
SELECT *
    FROM BOOK;
    
-- EMP�� ������ EMP01 : EMPNO(����4), ENAME(����20), SAL(����7,2)

CREATE TABLE EMP01(
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(20),
    SAL NUMBER(7, 2) -- ��ü 7�ڸ��� �Ҽ��� �� 5�ڸ�, �Ҽ��� 2�ڸ�, .�� ���Ծ���
   
);


SELECT *
    FROM EMP01;
    
-- DEPT �� ������ DEPT01 : DEPTNO(����2), DNAME(����14), LOC(����13)

CREATE TABLE DEPT01(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13)
    );
    
SELECT *
    FROM DEPT01;
    
-- ���������� �̿��� ���̺� ����

CREATE TABLE EMP02
    AS
    SELECT * FROM EMP; -- �������� ����� EMP02 ���̺� ������ ����(���������� ������)
    
    
SELECT *
    FROM EMP02;
    
DESC EMP02;

--EMP03 : EMP���̺��� EMPNO, ENAME, DEPTNO�� ����

CREATE TABLE EMP03
    AS
    SELECT EMPNO, ENAME, DEPTNO
    FROM EMP;
    
SELECT *
    FROM EMP03;
    
    
--EMP04 : EMP ���̺��� 10�� �μ��� ����

CREATE TABLE EMP04
    AS
    SELECT * 
        FROM EMP
        WHERE DEPTNO = 10;
        
        
SELECT *
    FROM EMP04;
    
    
CREATE TABLE EMP05
    AS
    SELECT *
        FROM EMP
        WHERE 1 = 0; -- �ݵ�� �����ι����� ������ ������ ���簡�ȴ�.
        
SELECT *
    FROM EMP05;    
        
        
    -- 2. ���̺� ���� ���� (ALTER TABLE)
    -- ALTER TABLE ���̺�� ADD || MODIFY || DROP ~
    -- (1) �ʵ� �߰�
    
SELECT *
    FROM EMP03; 
    
ALTER TABLE EMP03
    ADD (JOB VARCHAR2(20), SAL NUMBER(7, 2)); -- �ʵ� �߰��ϸ� �����ʹ� �⺻������ NULL �̵ȴ�.


ALTER TABLE EMP03
    ADD (COMM NUMBER(7, 2));
    
        
    -- (2) �ʵ� Ÿ�� ����(MODIFY)
    
SELECT *
    FROM EMP03;
    
    
ALTER TABLE EMP03
    MODIFY (EMPNO VARCHAR2(5));  -- �������� ���� :  ���� �����Ͱ� ����־ ���ڷθ� ���� ����
    
DESC EMP03;

ALTER TABLE EMP03
    MODIFY (ENAME VARCHAR2(30));
    


SELECT MAX(LENGTH(ENAME))
    FROM EMP;
    
    
ALTER TABLE EMP03
    MODIFY (JOB VARCHAR2(3)); -- NULL �̸� �� �ٲܼ� �ִ�
    
ALTER TABLE EMP03
    MODIFY (JOB NUMBER(5));
    
    
    
SELECT EMPNO, ENAME -- ROWNUM : ���̺��� ���� ���� ����
    FROM EMP;
    
SELECT ROWNUM, EMPNO, ENAME
    FROM EMP;
    
    
    --3. �ʵ� ����(DROP)
    
ALTER TABLE EMP03
    DROP COLUMN JOB;        -- NULL �� �ʵ� ����    
    
SELECT *
    FROM EMP03;
    
    
ALTER TABLE EMP03
    DROP COLUMN DEPTNO;      -- DEPTNO�ʵ� ������ �����ͱ��� ���ŵ�
    
    
-- �������� Ư���ʵ带 �������� ���ϰ� �ϴ� ��ɾ�

ALTER TABLE EMP03
    SET UNUSED (COMM);      --COMM ���� �Ұ�
    
SELECT *
    FROM EMP03;
    

ALTER TABLE EMP03
    DROP UNUSED COLUMNS;
    
    
    -- 3. ���̺� ���� (DROP TABLE)
    
    
DROP TABLE EMP01;
SELECT *
    FROM EMP01;
    
DROP TABLE DEPT;

SELECT *
    FROM DEPT; -- �ٸ� ���̺��� �����ϴ� �����Ͱ� ������� DROP �Ұ�


        -- 4. ���̺��� ��� ���� ����(TRUNCATE)
        
SELECT *
    FROM EMP03;
    
TRUNCATE TABLE EMP03; -- EMP03 ���� �����Ͱ� ���ŵǰ� ��Ұ� �Ұ���

SELECT *
    FROM EMP03;
    
    
    
        -- 5. ���̺�� ����(RENAME)
        
        
RENAME EMP02 TO EMP2;

SELECT *
    FROM EMP02;
    
    
        -- 6. ������ ��ųʸ�(���ٺҰ�) vs ������ ���ųʸ� �� (����� ���ٿ�)
         
        -- USER_XX : �� ������ �����ϰ��ִ� ��ü
            -- USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS ��
        -- ALL_XX : �� ������ ���� ������ ��ü
            --ALL_TABLES, ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS
        -- DBA_XX : DBA�� ���ٰ���
            --DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS
            
            
SHOW USER;

SELECT *
    FROM USER_TABLES;   -- �� ������ ������ ���̺� ��ü
    
SELECT *
    FROM USER_INDEXES;  -- �� ������ ������ �ε��� ��ü
        
SELECT *
    FROM USER_CONSTRAINTS;  -- �� ������ ������ ��������
    
SELECT *
    FROM USER_VIEWS;    -- �� ������ ������ ��
    
SELECT *
    FROM ALL_TABLES;    -- �� ������ ���� ������ ���̺� ��ü

SELECT *
    FROM ALL TABLES
    WHERE TABLE_NAME = 'EMP';
    
SELECT *
    FROM ALL_INDEXES;

SELECT *
    FROM ALL_CONSTRAINTS;
    
SELECT *
    FROM ALL_VIEWS;
    
SELECT *
    FROM DBA_INDEXES;
    
        --DCL (����� ��������, ����� ���Ѻο�, ���� ��Ż, ����� ���� ����)
        
        
CREATE USER joeun IDENTIFIED BY tiger;

-- ���� �ο�(���� ���ϴ� scott.emp, scott.dept �� ���� �������� �ֱ�)

GRANT CREATE SESSION TO JOEUN;

GRANT ALL ON EMP TO JOEUN;  -- �� ������ EMP ���̺� ���� ��� ���� �ο�

GRANT SELECT ON DEPT TO JOEUN;;     -- �� ������ DEPT ���̺� ���� SELECT ���� �ο�





CREATE TABLE DEPT1(
    DEPTNO NUMBER(2) NOT NULL PRIMARY KEY,
    DNAME  VARCHAR2(14) UNIQUE,
    LOC    VARCHAR2(13) NOT NULL
    
);


SELECT *
    FROM DEPT1;
    
DROP TABLE DEPT1;

CREATE TABLE DEPT1(
    DEPTNO NUMBER(2) NOT NULL,
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13) NOT NULL,
    PRIMARY KEY(DEPTNO),
    UNIQUE(DNAME)
);


CREATE TABLE EMP1(
    EMPNO    NUMBER(4) NOT NULL PRIMARY KEY,
    ENAME    VARCHAR2(10) NOT NULL,
    JOB      VARCHAR2(9) NOT NULL,
    MGR      NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE,
    SAL      NUMBER(7, 2) CHECK(SAL > 0),
    COMM     NUMBER(7, 2),
    DEPTNO NUMBER(2) REFERENCES DEPT1(DEPTNO)
    
);

DROP TABLE EMP1;

CREATE TABLE EMP1(
    EMPNO NUMBER(4) NOT NULL,
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9) NOT NULL,
    MGR NUMBER(4)
    HIREDATE DATE DEFAULT SYSDATE,
    SAL NUMBER(7, 2),
    COMM NUMBER(7, 2),
    DEPTNO NUMBER(2),
    PRIMARY KEY(EMPNO),
    CHECK(SAL > 0),
    FOREIGN KEY(DEPTNO) REFERENCES DEPT1(DEPTNO)
    

);






SELECT *
    FROM DEPT1;
    
INSERT INTO DEPT1 (DEPTNO, DNAME, LOC)
    VALUES(50, 'IT', 'MAPO');

INSERT INTO DEPT1 VALUES(60, 'PLANNING', 'MAPO');


-- EMP PK, NOT NULL(ENAME, JOB), DEFAULT, CHECK

INSERT INTO EMP1 (EMPNO, ENAME, JOB, SAL, COMM, DEPTNO)
    VALUES(1001, 'KIM', 'MANAGER', 9000, 9000, 50);
    
SELECT *
    FROM EMP1;
    
    
INSERT INTO EMP1 (EMPNO, ENAME, JOB, DEPTNO)
    VALUES (1002, 'PARK', 'MANAGER', 60);   -- PK

        

INSERT INTO EMP1(EMPNO, JOB, DEPTNO)
    VALUES (1003, 'MANAGER', 40);       --NOT NULL
    
    
INSERT INTO EMP1(EMPNO, ENAME, JOB, SAL, DEPTNO)
    VALUES(1004, 'YUN', 'MANAGER', 0, 30);  -- CHECK 
    
    
SELECT *
    FROM DEPT1;
    
INSERT INTO EMP1(EMPNO, ENAME, JOB, DEPTNO)
    VALUES (1005, 'YI', 'MANAGER', 80); -- �ܷ�Ű ����



    --
CREATE TABLE BOOKCATEGORY(
    CATEGORY_CODE NUMBER(3) NOT NULL PRIMARY KEY,
    CATEGORY_NAME VARCHAR2(20) UNIQUE,
    OFFICE_LOC VARCHAR2(20) NOT NULL
);

SELECT *
    FROM BOOKCATEGORY;

SELECT *
    FROM BOOK;

    --
CREATE TABLE BOOK(
    CATEGORY_CODE NUMBER(3) REFERENCES BOOKCATEGORY(CATEGORY_CODE),
    bookNO VARCHAR2(10) NOT NULL PRIMARY KEY,
    bookNAME VARCHAR2(50),
    PUBLISHER VARCHAR2(20),
    PUBYEAR NUMBER(4) DEFAULT EXTRACT(YEAR FROM SYSDATE)
);


DROP TABLE BOOK;




-----------------------------------------------------------


CREATE TABLE MAJOR(
    MAJOR_CODE NUMBER(2) NOT NULL,
    MAJOR_NAME VARCHAR2(30) UNIQUE,
    MAJOR_OFFICE_LOC VARCHAR2(40) NOT NULL,
    PRIMARY KEY(MAJOR_CODE)
);

SELECT *
    FROM MAJOR;


DROP TABLE MAJOR;

DROP TABLE STUDENT;
--FOREIGN KEY(DEPTNO) REFERENCES DEPT1(DEPTNO)    


CREATE TABLE STUDENT(
    STUDENT_CODE VARCHAR2(10) NOT NULL,
    STUDENT_NAME VARCHAR2(20) NOT NULL,
    SCORE NUMBER(3) CHECK (SCORE BETWEEN 0 AND 100),
    MAJOR_CODE NUMBER(2),
    PRIMARY KEY(STUDENT_CODE),
    FOREIGN KEY(MAJOR_CODE) REFERENCES MAJOR(MAJOR_CODE)    
);

SELECT *
    FROM STUDENT;


--    INSERT INTO DEPT1 VALUES(60, 'PLANNING', 'MAPO');
    
INSERT INTO MAJOR VALUES(1,'�濵����','3�� �ι���');
INSERT INTO MAJOR VALUES(2,'����Ʈ�������','3�� �ι���');
INSERT INTO MAJOR VALUES(3,'������','4�� ���н�');
INSERT INTO MAJOR VALUES(4,'����','4�� ���н�');
INSERT INTO MAJOR VALUES((SELECT MAX(MAJOR_CODE) FROM MAJOR)+1, '������', '������ 606ȣ');

SELECT *
    FROM MAJOR;
    
INSERT INTO STUDENT VALUES('A01','��浿',100,1);
INSERT INTO STUDENT VALUES('A02','���浿',90,2);
INSERT INTO STUDENT VALUES('A03','ȫ�浿',95,1);
INSERT INTO STUDENT VALUES('A04','ȫ�絿',96,4);


SELECT *
    FROM STUDENT;
    
    

    
SELECT M.*, STUDENT_CODE, STUDENT_NAME, SCORE
    FROM MAJOR M, STUDENT S
    WHERE M.MAJOR_CODE = S.MAJOR_CODE;
    
    
 
 
   