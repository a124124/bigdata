 -- [III] JOIN : ���̺� 2�� �̻��� �����Ͽ� �˻� 
 
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
SELECT * 
    FROM EMP
    WHERE ENAME = 'SCOTT';   -- �μ� ��ȣ(DEPTNO 20)

-- CROSS JOIN (FROM���� ���̺� 2���̻�)

SELECT *
    FROM EMP, DEPT
    WHERE ENAME = 'SCOTT' AND EMP.DEPTNO = DEPT.DEPTNO; -- 4�� = EMP���̺� 1�� * DEPT �� 4��
--SELECT *
--    FROM EMP, DEPT;

-- EQUI JOIN (���� �ʵ��� DEPTNO���� ��ġ�Ǵ� ���Ǹ� JOIN) RDBMS


SELECT EMPNO, ENAME, EMP.DEPTNO, DNAME, LOC 
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO;
    
SELECT EMPNO NO, ENAME, E.DEPTNO, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    ORDER BY NO;
    
    
-- �޿��� 2000�̻��� ������ ENAME, JOB, SAL, DNAME, LOC ���

SELECT ENAME, JOB, SAL, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE SAL>=2000 AND E.DEPTNO = D.DEPTNO
    ORDER BY SAL;
    
    
    
-- LOC �� CHICAGO �� ����� ENAME, JOB, SAL �� ���

SELECT ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO'
    ORDER BY ENAME;
    
    
-- LOC �� CHICAGO �� ����� ENAME, JOB, SAL, DNAME, LOC ���

SELECT ENAME, JOB, SAL, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO'
    ORDER BY ENAME;
    
    
    
    
SELECT *
    FROM EMP
    WHERE ENAME = 'SCOTT';
    
SELECT *
    FROM SALGRADE;
    
    
    
SELECT * 
    --CROSS 5�� = EMP 1�� * SALGRADE 5��
    FROM EMP, SALGRADE
--    WHERE SAL >= LOSAL AND SAL <= HISAL AND ENAME = 'SCOTT';
    WHERE SAL BETWEEN LOSAL AND HISAL AND ENAME = 'SCOTT';
    
    -- ��� ����� ���, �̸�, JOB, ���, �޿�, �޿����(1���, 2���)
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE||'���' "GRADE"
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
    
    --COMM�� NULL �� �ƴ� ����� �̸�, �޿�, �޿� ���, �μ���ȣ, �μ��̸�, �ٹ���
SELECT ENAME, SAL, GRADE, E.DEPTNO, DNAME, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND NOT COMM IS NULL;
    
    
    --ENAME, SAL, HIREDATE, GRADE
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
   
    
    --ENAME, SAL, HIREDATE, GRADE, DNAME, LOC
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;
    
    --ENAME, SAL, GRADE, SAL*12 + NVL(COMM, 0) -- �μ���ȣ, ��������
SELECT ENAME, SAL, GRADE, SAL*12 + NVL(COMM, 0) ����
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY DEPTNO, ����;


    --ENAME, JOB, SAL, GRADE, DEPTNO, DNAME  -- SAL�� 1000~3000, �μ�, ����, �޿�ū�� ����
SELECT ENAME, JOB, SAL, GRADE, E.DEPTNO, DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND SAL BETWEEN 1000 AND 3000
    ORDER BY DNAME, JOB, SAL DESC;
    
    -- ENAME, SAL, GRADE, HIREDATE, LOC -- 81�� �Ի��� ����� ��޳����� ����    
SELECT ENAME, SAL, GRADE, HIREDATE, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND TO_CHAR(HIREDATE, 'RR') = 81
    ORDER BY GRADE DESC;
    
    
    
-- SELF JOIN
SELECT EMPNO, ENAME, MGR
    FROM EMP   
    WHERE ENAME = 'SMITH'; -- ����� ��� 7566
    
SELECT EMPNO, ENAME
    FROM EMP
    WHERE EMPNO = 7902;
    
SELECT WORKER.EMPNO, WORKER.ENAME, WORKER.MGR, MANAGER.ENAME
    FROM EMP WORKER, EMP MANAGER
    WHERE WORKER.ENAME = 'SMITH' AND WORKER.MGR = MANAGER.EMPNO;
    

-- ��� ����� ���, �̸�, ����� ���, ����� �̸�

SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO; -- (KING �� MGR�� NULL �̶� ����� ��������)
    
-- 'SMITH�� ���� FORD��'

SELECT W.ENAME||'�� ���� '||M.ENAME||'��' "MESSAGE"
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
    
    -- 1. ����� �̸��� KING�� ������� �̸��� JOB ���
SELECT W.ENAME, W.JOB 
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO AND M.ENAME = 'KING';
    
    
    -- 2. SCOTT �� ������ �μ���ȣ���� �ٹ��ϴ� ����� �̸� ���
SELECT S.ENAME
    FROM EMP W, EMP S
    WHERE W.DEPTNO = S.DEPTNO AND W.ENAME = 'SCOTT' AND S.ENAME != 'SCOTT';

SELECT ENAME
    FROM EMP
    WHERE DEPTNO = 20;
    
    
    
    -- 3. SCOTT �� ������ �ٹ������� �ٹ��ϴ� ����� �̸� ���
INSERT INTO DEPT VALUES (50,'IT','DALLAS');
INSERT INTO EMP VALUES(9999,'AL',NULL,NULL,NULL,9000,NULL,50);
SELECT * 
    FROM DEPT;
SELECT * 
    FROM EMP 
    WHERE ENAME = 'SCOTT';

SELECT S.ENAME
    FROM EMP W, EMP S, DEPT D1, DEPT D2 
    
    WHERE W.ENAME = 'SCOTT' 
        AND W.DEPTNO = D1.DEPTNO 
        AND S.DEPTNO = D2.DEPTNO 
        AND D1.LOC = D2.LOC 
        AND S.ENAME != 'SCOTT';
    
    
ROLLBACK;  -- DML ���

SELECT * 
    FROM DEPT;
    
    
    
 -- OUTER JOIN : ���ν� ���ǿ� �������� �ʴ� ����� ��Ÿ����
 
 SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
    
    -- "SMITH�� �Ŵ����� FORD �Դϴ�"
    -- KING �� �Ŵ����� �����ϴ�
SELECT W.ENAME || '�� �Ŵ����� ' || NVL(M.ENAME, '����') || '�Դϴ�' MSG
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
    
    
    -- ���ܻ���� �̸�
    
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL;
    
SELECT M.EMPNO, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL;
    
    
    
    
--
SELECT * 
    FROM DEPT;  -- 10, 20, 30, 40
SELECT * 
    FROM EMP; -- 10, 20, 30
SELECT * 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO(+) = D.DEPTNO; -- 40���� ��µ�������
    
    
    
-- EMP DEPT SALGRADE

-- �� <��������> PART1
--1. �̸�, ���ӻ��
SELECT W.ENAME, M.ENAME MANAGER, W.SAL * 12 ANNUAL_SAL
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);


--2. �̸�, �޿�, ����, ���ӻ��
SELECT W.ENAME, W.SAL, W.JOB, M.ENAME MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);


--3. �̸�, �޿�, ����, ���ӻ��. (��簡 ���� �������� ��ü ���� �� ���.
    --��簡 ���� �� '����'���� ���)
SELECT W.ENAME, W.SAL, W.JOB, NVL(M.ENAME, '����') MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
    
    

--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT W.ENAME, W.SAL, DNAME, M.ENAME MANAGER
    FROM EMP W, EMP M, DEPT
    WHERE DEPT.DEPTNO = W.DEPTNO AND W.MGR = M.EMPNO(+);


--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT W.ENAME, W.SAL, W.DEPTNO, DNAME, M.ENAME MANAGER
    FROM EMP W, EMP M, DEPT D
    WHERE W.DEPTNO = D.DEPTNO AND W.MGR = M.EMPNO(+);
--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT W.ENAME, W.SAL, GRADE, DNAME, M.ENAME MANAGER
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.DEPTNO = D.DEPTNO AND W.MGR = M.EMPNO(+) AND W.SAL BETWEEN LOSAL AND HISAL AND W.SAL >= 2000;

--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT W.ENAME, W.SAL, GRADE, DNAME, M.ENAME MANAGER
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.DEPTNO = D.DEPTNO AND W.MGR = M.EMPNO(+) AND W.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME;

--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT W.ENAME, W.SAL, GRADE, DNAME, M.ENAME MANAGER, (W.SAL + NVL(W.COMM, 0)) * 12 ANNUAL_SAL
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.DEPTNO = D.DEPTNO AND W.MGR = M.EMPNO(+) AND W.SAL BETWEEN LOSAL AND HISAL;
--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT W.ENAME, W.SAL, GRADE, DNAME, M.ENAME MANAGER, (W.SAL + NVL(W.COMM, 0)) * 12 ANNUAL_SAL
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.DEPTNO = D.DEPTNO AND W.MGR = M.EMPNO(+) AND W.SAL BETWEEN LOSAL AND HISAL
    ORDER BY W.SAL DESC;

    
--  �� <��������> PART2
--1.EMP ���̺��� ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME, EMPNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO;



--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ���

SELECT ENAME, JOB, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';
    

--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT ENAME, DNAME, LOC, COMM
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND NOT COMM IS NULL AND COMM != 0;

--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT ENAME, JOB, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND ENAME LIKE '%L%';



--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO, ENAME, E.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    ORDER BY ENAME;
    



--6. ���, �����, �޿�, �μ����� �˻��϶�. 
    --�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL >= 2000
    ORDER BY SAL DESC;
    

--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
-- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO, ENAME, JOB, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND JOB = 'MANAGER' AND SAL >= 2500
    ORDER BY EMPNO;


--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, JOB, SAL, GRADE
    FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL DESC;



--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT W.ENAME, M.ENAME MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);



--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT W.ENAME, M.ENAME MANAGER, M2.ENAME MANA
    FROM EMP W, EMP M, EMP M2  
    WHERE W.MGR = M.EMPNO AND M.MGR = M2.EMPNO(+);



--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�

SELECT W.ENAME, M.ENAME MANAGER, M2.ENAME MANA
    FROM EMP W, EMP M, EMP M2  
    WHERE W.MGR = M.EMPNO(+) AND M.MGR = M2.EMPNO(+);    
    