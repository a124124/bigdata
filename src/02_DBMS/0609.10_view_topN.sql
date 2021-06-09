    --[X] VIEW, INLINE VIEW, TOP-N ����
    
    
    --1. VIEW : ������ ���̺�
        -- (1) ���Ϻ�

CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DEPTNO
        FROM EMP;
        
SELECT *
    FROM USER_VIEWS;

SELECT *
    FROM EMP;
        
SELECT *
    FROM EMPv0;
    
INSERT INTO EMPv0 VALUES(9000, 'ȫ', 'MANAGER', 40);
        
UPDATE EMPv0 SET JOB = 'ANALYST'
    WHERE EMPNO = 9000;


DELETE FROM EMPv0 WHERE EMPNO = 9000;


    --  EMPv0 �̶�� �� = EMP ���̺��� 30�� �μ���
    
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
    
    -- EMPv0 �� 30�� �μ��� �׼��� �Ҽ��ִ� �� = 40�� �μ� �Է��� �����ϳ� �������� ����
    
INSERT INTO EMPv0 VALUES(1112, 'KIM', NULL, NULL, NULL, NULL, NULL, 40);


DELETE FROM EMPv0
    WHERE EMPNO < 2000; -- 1111�� �����ǳ� 1112�� ������������ . 30�� �μ��� �������Ҽ��ֱ⶧����
    
SELECT *
    FROM EMP;
    
    --VIEW�� ���� ����
    --WITH CHECK OPTION �� ������ ��� ���ǿ� �ش�Ǵ� �����͸� ����,����,���� ����
    --WITH READ ONLY �� ������ ��� �б�����

    -- ���̺� NOT NULL �� ���� �÷��� ���ԵǾ����
    
CREATE OR REPLACE VIEW EMPv0
    AS SELECT ENAME, JOB
        FROM EMP;
        
        
INSERT INTO EMPv0 VALUES('��','MANAGER');

SELECT *
    FROM EMPv0;
    
    --WITH CHECK OPTION
    
CREATE OR REPLACE VIEW EMPv0
    AS SELECT *
        FROM EMP
        WHERE DEPTNO = 30
        WITH CHECK OPTION; -- ���ǿ� �´� ��츸 �߰� ����
        
        
INSERT INTO EMPv0 VALUES(1111,'G',NULL,NULL,NULL,NULL,NULL,30);

INSERT INTO EMPv0 VALUES(1121,'G',NULL,NULL,NULL,NULL,NULL,40); -- ������, 30�� �μ��� �ƴϱ⶧����


DELETE FROM EMPv0 WHERE EMPNO = 1111;


    -- VIEW READ ONLY
    
CREATE OR REPLACE VIEW EMPv1
    AS SELECT *
        FROM EMP
        WHERE DEPTNO = 20
        WITH READ ONLY;         -- �б� ���� ��
        
SELECT E.*, DNAME
    FROM EMPv1 E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO;
    
UPDATE EMPv1 
    SET SAL = 9000
    WHERE EMPNO = 7902;
    

        
        -- (2) ���պ� ; 2�� �̻��� ���̺�� ������ ��, DML ���� ���������θ� ���
        

CREATE OR REPLACE VIEW EMPV0
    AS SELECT EMPNO, ENAME, JOB, DNAME
    FROM DEPT D, EMP E
    WHERE D.DEPTNO = E.DEPTNO;
    
SELECT *
    FROM EMPv0;
    
INSERT INTO EMPv0 VALUES(1200,'HONG','MANAGER','RESEARCH');      -- ���պ�� ���� �Ұ�

    -- �÷��� ��Ī�� �̿��Ͽ� �並 ���� (�ʵ忡 Ư�����ڰ� �ִ� ��� �ݵ��)
    
CREATE OR REPLACE VIEW EMPv1
    AS SELECT EMPNO NO, ENAME NAME, SAL * 12 YEAR_SAL
    FROM EMP
    WHERE DEPTNO = 10;

SELECT *
    FROM EMPV1;
    
INSERT INTO EMPv1 VALUES(1000,'��',12000);  -- ������ �ʵ尡 �־ �Ұ�



CREATE OR REPLACE VIEW EMPv1
    AS SELECT EMPNO, ENAME, SAL * 12 SAL
    FROM EMP
    WHERE DEPTNO = 10;
    
    
    
    -- ���, �̸�, 10�� �ڸ����� �ݿø��� SAL �� �� ����
    
CREATE OR REPLACE VIEW EMPv1
    AS SELECT EMPNO, ENAME, ROUND(SAL, -2) SAL
    FROM EMP;
    

    
SELECT *
    FROM EMPV1;
    
    
    -- �μ���ȣ, �ּұ޿�, �ִ�޿�, �μ���� VIEW 
    
    
CREATE OR REPLACE VIEW DEPTv0
    AS SELECT DEPTNO, MIN(SAL) MIN, MAX(SAL) MAX, AVG(SAL) AVG
    FROM EMP
    GROUP BY DEPTNO;
    
    
    
    -- �μ���ȣ, �μ���, �ּұ޿�, �ִ�޿�, ��ձ޿� DEPTv1 ��
    
CREATE OR REPLACE VIEW DEPTv2
    AS 
    SELECT D0.DEPTNO, DNAME, MIN, MAX, AVG
    FROM DEPT D, DEPTv0 D0
    WHERE D.DEPTNO = D0.DEPTNO
    ;
    
SELECT *
    FROM DEPTv2;
    
    
    --DISTINCT Ű���带 �̿��� �� ; �ߺ��� ���ŵ� JOB, DEPTNO 

SELECT JOB, DEPTNO
    FROM EMP;
    
CREATE OR REPLACE VIEW EMPv0
    AS
    SELECT DISTINCT JOB, DEPTNO
    FROM EMP;
    
    
SELECT *
    FROM EMPV0;
    
INSERT INTO EMPv0 VALUES('MANAGER','10');   -- DISTINCT �� ������ ��� �б� ����




    -- 2. INLINE VIEW ; FROM �� ���� ���������� INLINE VIEW ��� �ϸ�, FROM ���� ���� ���������� VIEWó�� �ۿ�
    
    -- �޿��� 2õ�ʰ� ����� ��� �޿�
    
SELECT AVG(SAL)
    FROM EMP
    WHERE SAL > 2000;
    
SELECT AVG(SAL)
    FROM (SELECT SAL
            FROM EMP
            WHERE SAL > 2000);
            
    -- �� �μ����� �μ���ձ޿����� ���� ����� �̸�, �޿�, �μ���ȣ
    
SELECT ENAME, SAL, DEPTNO
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL)
                    FROM EMP
                    WHERE DEPTNO = E.DEPTNO);
                    
                    
    -- FROM ���� �� �������� (�μ���ȣ, ��ձ޿�) : 1�ܰ�

CREATE OR REPLACE VIEW GG
AS
SELECT DEPTNO, AVG(SAL) AVG
    FROM EMP
    GROUP BY DEPTNO;
    
    -- �̸�, �޿�, �μ���ȣ, �μ��� ��� : 2�ܰ�
SELECT ENAME, SAL, SS.DEPTNO, SS.AVGSAL
    FROM EMP, (SELECT DEPTNO, AVG(SAL) AVGSAL
                    FROM EMP
                    GROUP BY DEPTNO) SS
    WHERE ENAME = 'SCOTT';
        --SELECT �ʵ�1, �ʵ�2...
        --    FROM ���̺��1, (��������) ��Ī
        --    WHERE ��������
        
        

    -- �̸�, �޿�, �μ���ȣ(�μ��� ��պ��� ���� �����) : 3�ܰ�
    
SELECT ENAME, SAL, SS.DEPTNO
    FROM EMP, (SELECT DEPTNO, AVG(SAL) AVGSAL
                    FROM EMP
                    GROUP BY DEPTNO) SS
    WHERE EMP.DEPTNO = SS.DEPTNO AND SAL > AVGSAL;
    
    
    
    --TOP-N ���� ( ���Ǵ�� ��� ����)
    -- ROWNUM ; ���̺�κ��� ������ ����
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
            
        -- SAL ���� 1~5��
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT ENAME, SAL
            FROM EMP
            ORDER BY SAL)
    WHERE ROWNUM < 6;
    
    
    -- �Լ��� �̿��� RANK���
    
SELECT RANK() OVER(ORDER BY SAL) RANK,
    DENSE_RANK() OVER(ORDER BY SAL) D_RANK,
    ROW_NUMBER() OVER(ORDER BY SAL) N_RANK,
    ENAME, SAL
    FROM EMP;


    -- SAL �������� 6~10��
    
SELECT ROWNUM, ENAME, SAL
    FROM EMP
    WHERE ROWNUM BETWEEN 6 AND 10;
    
    
    --TOP N
    
SELECT ENAME, SAL
    FROM EMP
    ORDER BY SAL;                    -- 1�ܰ�
    
SELECT ROWNUM RN, ENAME, SAL
    FROM (SELECT ENAME, SAL
                FROM EMP
                ORDER BY SAL)
    ORDER BY SAL;                   -- 2�ܰ�
    

SELECT ROWNUM, RN, ENAME, SAL
    FROM (SELECT ROWNUM RN, ENAME, SAL
            FROM (SELECT ENAME, SAL
                        FROM EMP
                        ORDER BY SAL)
            ORDER BY SAL);              -- 3�ܰ�
            
            
SELECT ROWNUM, RN, ENAME, SAL
    FROM (SELECT ROWNUM RN, ENAME, SAL
                FROM (SELECT *
                        FROM EMP
                        ORDER BY SAL))
    WHERE RN BETWEEN 6 AND 10;          -- �ϼ�
    
    
    -- �̸��� ���ĺ� ������ �����ؼ� 6~10�� ��� (���, �̸�, ���, JOB, MGR, HIREDATE)


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
    
    
    
-- <�� ��������>
-- 1. �μ���� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VU
    AS
    SELECT DNAME, ENAME
    FROM DEPT D, EMP E
    WHERE D.DEPTNO = E.DEPTNO;

SELECT *    
    FROM DNAME_ENAME_VU;


-- 2. ������ ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ�



CREATE OR REPLACE VIEW WORKER_MANAGER_VU
    AS
    SELECT E.ENAME, W.ENAME WN
    FROM EMP E, EMP W
    WHERE E.MGR = W.EMPNO(+);



SELECT *
    FROM WORKER_MANAGER_VU;


-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���). ? ģ������



    

SELECT DEPTNO, SUM(SAL) SUMSAL
    FROM EMP E
    GROUP BY DEPTNO ORDER BY SUMSAL DESC;
   

SELECT ROWNUM RANK, A.*
    FROM (SELECT DEPTNO, SUM(SAL) SUMSAL
            FROM EMP 
            GROUP BY DEPTNO 
            ORDER BY SUMSAL DESC) A;    




-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�.

SELECT RANK, DEPTNO, SUMSAL
    FROM (SELECT ROWNUM RANK, DEPTNO, SUMSAL
                FROM (SELECT DEPTNO, SUM(SAL) SUMSAL
                        FROM EMP 
                        GROUP BY DEPTNO ORDER BY SUMSAL DESC) A)
    WHERE RANK BETWEEN 2 AND 3;
            





-- 4. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�


SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    ORDER BY HIREDATE DESC;



-- 5. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�

SELECT EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, A.*
                FROM (SELECT *
                        FROM EMP
                        ORDER BY HIREDATE) A
                ORDER BY HIREDATE)
    WHERE RN < 6;
         




-- 6. ��� ���̺��� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� ���

SELECT EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, A.*
                FROM (SELECT *
                        FROM EMP
                        ORDER BY HIREDATE) A
                ORDER BY HIREDATE)
    WHERE RN BETWEEN 6 AND 10;
    
    

