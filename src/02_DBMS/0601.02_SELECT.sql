-- [II] SELECT �� -- �˻�

SELECT * FROM TAB; -- �� ����(SCOTT)�� �������ִ� ���̺�

SELECT * FROM DEPT; -- DEPT ���̺� ��� ��(�ʵ�), ��� ���� ����Ѵ�.

SELECT * FROM EMP;     -- EMP ���̺� ��� ��(�ʵ�), ��� ��

-- DEPT ���̺��� ����

DESC DEPT; 


-- 2. SQL �� ����(Ư�� �ʵ常 ���)

SELECT EMPNO, ENAME, SAL, JOB FROM EMP;
SELECT EMPNO AS "���", ENAME AS "�̸�", SAL AS "�޿�", JOB AS "��å" FROM EMP;
SELECT EMPNO AS ���, ENAME AS �̸�, SAL AS �޿�, JOB AS ��å FROM EMP;
SELECT EMPNO ���, ENAME �̸�, SAL �޿�, JOB ��å FROM EMP;
SELECT EMPNO "�� ��" FROM EMP;
SELECT EMPNO NO, ENAME NAME, SAL SALARY FROM EMP;

--3. Ư�� �� ��� ; WHERE��(����)

SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP
    WHERE SAL = 3000;  -- ����
    
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP
    WHERE SAL != 3000;    -- �ٸ���
    
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP
    WHERE SAL <> 3000;    -- �ٸ���

SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP
    WHERE SAL ^= 3000;    -- �ٸ���

-- 10�� �μ� ����� ��� �ʵ带 ���

SELECT * FROM EMP
    WHERE DEPTNO = 10;
    
-- ENAME �� FORD�� ������ EMPNO, ENAME, MGR �� ���

SELECT EMPNO, ENAME, MGR FROM EMP 
    WHERE ENAME = 'FORD';   -- �����ʹ� ��ҹ��� �����ؾ��Ѵ�.
    
    
-- 4. �������� ; �޿�(SAL) �� 2000 ~ 3000�� ������ ��� �ʵ带 ���

SELECT * FROM EMP 
    WHERE SAL >= 2000 AND SAL < 3000;
    -- �񱳿����� ����, ����, DATE�� �ʵ� ��� �����ϴ�
    -- ����� �̸�(ENAME)�� 'A', 'B', 'C' �� �����ϴ� ����� ��� �ʵ带 ���
    
SELECT * FROM EMP
    WHERE ENAME < 'D';
    
    
    -- 81�� ������ �Ի��� ����� ��� �ʵ�

SELECT * FROM EMP WHERE HIREDATE < '81/01/01';

 -- EMP TABLE �� ����
DESC EMP;
    -- 82�⵵�� �Ի��� ����� ��� �ʵ�
    
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE < '83/01/01';

-- ��¥ ǥ��� ����(���� RR/MM/DD)

ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

SELECT HIREDATE FROM EMP;
    -- ������ 2400 �̻��� ������ ENAME, SAL, ������ ��� (SAL * 12);

SELECT ENAME, SAL, SAL*12 ����   -- 3.
    FROM EMP                    -- 1.
    WHERE SAL * 12 >= 24000     -- 2.  WHERE ������ �ʵ��� ��Ī�� �� �� ����.
    ORDER BY ����  ;           -- 4.     ORDER ������ ��� ����


    -- 10�� �μ����� JOB�� MANAGER �� ����� ��� �ʵ�


SELECT * FROM EMP
    WHERE DEPTNO = 10 AND JOB = 'MANAGER';
   

    
    -- 10�� �μ� �̰ų� JOB�� MANAGER �� ����� ��� �ʵ�
    
SELECT * FROM EMP
    WHERE DEPTNO = 10 OR JOB = 'MANAGER';
    
    
    -- �μ� ��ȣ�� 10���� �ƴ� ����� ��� �ʵ�
SELECT * FROM EMP
--    WHERE NOT DEPTNO = 10;
    WHERE DEPTNO != 10;
    
    
-- 5. ��� ǥ����

SELECT ENAME, SAL, SAL+100 UPGRADE_SAL FROM EMP 
    WHERE DEPTNO = 10;
    
    -- ��� ����� �̸�, ����(SAL), ��(COMM), ����(SAL*12+COMM) �� ���


SELECT ENAME, SAL, COMM, SAL*12 + COMM ���� FROM EMP; --NULL�� �ִ� �����͸� �̿��� ������� ����� NULL�̴�.

    -- NVL(NULL�ϼ��� �ִ� �ʵ��, ��ü��) �ݵ�� �Ű����� ���� Ÿ���� ���ƾ���.
SELECT ENAME, SAL, COMM, SAL * 12 + NVL(COMM, 0) FROM EMP;      

    --��� ����� �����, �����(MGR) �� ��� (��簡 ������ 0���� ���)
SELECT ENAME, NVL(MGR, 0) FROM EMP;


-- 6. ���Ῥ����(||) : ���̳� ���ڸ� ����
SELECT ENAME || '�� ' || JOB "EMPLOYEES" FROM EMP;

    -- "SMITH : 1 YEAR SALARY = XXXX" ���� �������� ���(����=SAL*12+COMM)
    
SELECT ENAME || ': 1 YEAR SALARY = ' || (SAL * 12 + NVL(COMM, 0)) "MESSAGE" FROM EMP;


-- 7. �ߺ� ����
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;




--1. emp ���̺��� ���� ���
DESC EMP;   -- ORACLE �� ����

--2. emp ���̺��� ��� ������ ��� 
SELECT * FROM EMP;

--3. �� scott �������� ��밡���� ���̺� ���
SELECT * FROM TAB;

--4. emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;

--5. emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE SAL < 2000;

--6. �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP
    WHERE HIREDATE >= '81/02/01';


--7. ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP
    WHERE JOB = 'SALESMAN';

--8. ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP
    WHERE JOB != 'CLERK';

--9. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE SAL >= 1500 AND SAL <= 3000;

--10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���

SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP
    WHERE DEPTNO = 10 OR DEPTNO = 30;

--11. ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP
    WHERE JOB = 'SALESMAN' OR SAL >= 3000;

--12. �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP
    WHERE JOB = 'MANAGER' AND SAL >= 2500;


--13.��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���(������ SAL*12+COMM)

SELECT ENAME || '�� ' || JOB || ' �����̰� ������ ' || (SAL * 12 + NVL(COMM, 0)) || '�̴�' "MESSAGE" FROM EMP;




--8 SQL ������        (BETWEEN, IN, LIKE, IS NULL) LIKE �� ���� ���̾���.

--SELECT EMPNO, ENAME, SAL FROM EMP
--    WHERE SAL >= 1500 AND SAL <= 3000;


--  (1) BETWEEN
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE SAL BETWEEN 1500 AND 3000;
     -- �ʵ�� BETWEEN A AND B , A ���� B����( �ݵ�� A�� �� �۾ƾ���)
     --82�⵵�� �Ի��� ������ ��� �ʵ� ���
     
SELECT * FROM EMP 
    WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';
    -- �̸��� B,C �� �����ϴ� ����� ��� �ʵ带 ���
SELECT * FROM EMP
    WHERE ENAME BETWEEN 'B' AND 'D' AND ENAME != 'D'; 
    
    
--  (2) IN 
    -- �μ� ��ȣ�� 10, 20�� ����� ��� �ʵ�
--SELECT * FROM EMP  
--    WHERE DEPTNO = 10 OR DEPTNO = 20;

SELECT * FROM EMP
    WHERE DEPTNO NOT IN (10, 20, 40);



    --����� 7902, 7788, 7566 �� ����� ��� �ʵ�
    
SELECT * FROM EMP
    WHERE EMPNO IN(7902, 7788, 7566);
    
DESC DEPT;
SELECT * FROM DEPT;


-- (3) LIKE ����    
    -- �̸��� M���� �����ϴ� ����� ��� �ʵ带 ���
SELECT * FROM EMP
    WHERE ENAME LIKE 'M%';       -- % : 0���� �̻�, _ : �ѱ���
    
    -- �̸��� N�� ���� ����� ��� �ʵ带 ���
SELECT * FROM EMP
    WHERE ENAME LIKE '%N%';
    
    -- �̸��� S�� ������ ����� ��� �ʵ�
SELECT * FROM EMP
    WHERE ENAME LIKE '%S';
    -- SAL �� 5�� ������ ����� ��� �ʵ�
SELECT * FROM EMP
    WHERE SAL LIKE '%5';
    
    -- 82�⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP
    WHERE HIREDATE LIKE '82%';
    -- 1���� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP
    WHERE HIREDATE LIKE '___01___'; -- 
    
    -- 82�Ⱑ �ƴ� ������ �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP
    WHERE HIREDATE NOT LIKE '82%';
    
    -- (4) IS NULL
    -- �󿩱��� ���� ����� ��� �ʵ�
SELECT * FROM EMP
    WHERE COMM IS NULL OR COMM = 0;

    -- �󿩱��� �ִ� ����� ��� �ʵ�
SELECT * FROM EMP  
    WHERE NOT COMM IS NULL AND COMM != 0;
    
-- 9. ���� (��������, ��������)
SELECT ENAME, SAL FROM EMP
    ORDER BY SAL;  -- ��������
    
SELECT ENAME, SAL FROM EMP
    ORDER BY SAL ASC; -- ��������
    
SELECT ENAME, SAL FROM EMP
    ORDER BY SAL DESC; -- ��������
    
SELECT ENAME, SAL FROM EMP
    ORDER BY ENAME;
    
SELECT ENAME, SAL FROM EMP
    ORDER BY HIREDATE;
        
SELECT ENAME, SAL FROM EMP
    ORDER BY HIREDATE DESC; -- �ֽ� ������� ����


    -- �̸�, ����(SAL * 12 + COMM) �� ��� (������ ���� ������, ������ ������ �̸�������)
    
SELECT ENAME, (SAL * 12 + NVL(COMM, 0)) "MONEY" FROM EMP
    ORDER BY MONEY DESC, ENAME;
    
    -- �̸�, ����(SAL * 12 + COMM) �� ��� (������ ���� ������, ������ ������ �̸�������)

SELECT ENAME, (SAL * 12 + NVL(COMM, 0)) "MONEY" FROM EMP
    ORDER BY MONEY, ENAME;
    
    -- ���, �̸�, SAL ���(�μ���, �μ��� ������ �Ի��ϼ�)
    
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP
    ORDER BY DEPTNO, HIREDATE;
    
-- <�� ��������>
--1.	EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
SELECT EMPNO, ENAME, SAL 
    FROM EMP  
    WHERE SAL >= 3000;
 
--2.	EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT ENAME, DEPTNO FROM EMP
    WHERE EMPNO = 7788;

--3.	������ 24000�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE (SAL * 12 + NVL(COMM , 0)) >= 24000
    ORDER BY SAL;

--4.	EMP ���̺��� hiredate�� 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� 
--ename,job,hiredate�� ����ϴ� SELECT ������ �ۼ� (�� hiredate ������ ���)
SELECT ENAME, JOB, HIREDATE FROM EMP
    WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/02';
    
    --��¥ ����
    --�������� ��¥������ ��ȯ : TO_DATE('81/02/02','RR/MM/DD')
    --��¥���� ���������� ��ȯ : TO_CHAR(��¥��, ����)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM/DD/RR';
SELECT ENAME, JOB, HIREDATE FROM EMP
    WHERE HIREDATE BETWEEN TO_DATE('81/02/20','RR/MM/DD') AND TO_DATE('81/05/02','RR/MM/DD');
    
    
    



--5.	EMP ���̺��� deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP
    WHERE DEPTNO IN (10, 20)
    ORDER BY ENAME;
    


--6.	EMP ���̺��� sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���
-- (�� HEADING�� employee�� Monthly Salary�� ���)
SELECT ENAME "employee", SAL "Monthly Salary" FROM EMP
    WHERE DEPTNO IN (10, 30) AND SAL >= 1500;
    

--7.	EMP ���̺��� hiredate�� 1982���� ����� ��� ������ ���
SELECT * FROM EMP
    WHERE HIREDATE LIKE '%82%';


-- TO_DATE(), TO_CHAR()
SELECT *
    FROM EMP
    WHERE TO_CHAR(HIREDATE, 'YYYY') = '1982';


--8.	�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT ENAME, SAL FROM EMP
    WHERE ENAME BETWEEN 'C' AND 'Q' ORDER BY ENAME;

--9.	EMP ���̺��� comm�� sal���� 10%�� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� 
--����ϴ� SELECT ���� �ۼ�
SELECT ENAME, SAL, COMM FROM EMP
    WHERE COMM * 1.1 >= SAL;
    

--10.	EMP ���̺��� job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� ��� ����� ������ ���
SELECT * FROM EMP
    WHERE JOB IN('CLERK', 'ANALYST') AND NOT SAL IN (1000, 3000, 5000);

--11.	EMP ���̺��� ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� ����� 
--��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP
    WHERE ENAME LIKE '%L%L%' AND DEPTNO = 30 OR MGR = 7782;

--12.	��� ���̺��� �Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP
    WHERE HIREDATE LIKE '%81%';
    
    --TO_CHAR() �Լ� �̿��Ͽ� � �ý��ۿ��� �� ����ǵ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL 
    FROM EMP
    WHERE TO_CHAR(HIREDATE, 'RR') = 81;
    
      
    

--13.	��� ���̺��� �Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, 
-- ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP
    WHERE HIREDATE LIKE '%81%' AND JOB != 'SALESMAN';

--14.	��� ���̺��� ���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, 
-- �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP
    ORDER BY SAL, HIREDATE;

--15.	��� ���̺��� ������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP
    WHERE ENAME LIKE '__N%';

--16.	��� ���̺�������(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO, ENAME, SAL * 12 AS MONEY FROM EMP
    WHERE SAL * 12 >= 35000;
    
    
-- �̸��� A�� �� ����� ��� �ʵ带 ���
SELECT *
    FROM EMP
    WHERE ENAME LIKE '%A%';


-- �̸��� %�� �� ����� ��� �ʵ带 ���
SELECT *
    FROM EMP
    WHERE ENAME LIKE '%\%%' ESCAPE'\' ;
    
INSERT INTO EMP VALUES (9999, 'LI%SA', NULL, NULL, NULL, 9000, 9900, 40);

ROLLBACK; -- DML (������ ���۾�)�� ����ϴ� ��ɾ�
