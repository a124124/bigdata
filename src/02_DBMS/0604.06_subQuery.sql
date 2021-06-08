 -- [VI] SUB QUERY ; QUERY �ȿ� QUERY �� ����
 
 --1 . ���� ���� ����
 
 -- �޿��� ���� ���� �޴� ����� �̸��� �޿�
 

 
 SELECT ENAME, MAX(SAL) 
    FROM EMP
    GROUP BY ENAME;  -- �Ѹ��� �ƴϰ� �ٳ��´�
    
 
 SELECT MAX(SAL) 
    FROM EMP;    
    
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL = (SELECT MAX(SAL) FROM EMP); -- �������� (������ ����) ��ȣ�� �� �ؾ��Ѵ�.
    
    
    
            
            
            
 -- 2. ������ ��������
 
 -- SCOTT �� �ٹ��ϴ� �μ��̸� ���
 -- �������� ���� (1) ������ ��������(�������� ����� 1��) = > >= != < <= ... EQUAL ������ ��� ����.
 
 
 SELECT DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
    AND ENAME = 'SCOTT'; -- EQUI JOIN
    
SELECT DEPTNO
    FROM EMP
    WHERE ENAME = 'SCOTT';     -- SUB QUERY
    
SELECT DNAME 
    FROM DEPT
    WHERE DEPTNO = (SELECT DEPTNO 
                    FROM EMP
                    WHERE ENAME = 'SCOTT');   --MAIN QUERY
                    
                    
                    
--     (2) ������ ��������(�������� ����� 2�� �̻�) EQUAL ������ ��� �Ұ� 
    -- IN, ANY, ALL, EXISTS 

    --JOB �� MANAGER�� ����� �μ� �̸�    
    
SELECT DEPTNO
    FROM EMP
    WHERE JOB = 'MANAGER';
    
SELECT DNAME 
    FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO
                     FROM EMP
                     WHERE JOB = 'MANAGER');
    
    
   -- SCOTT �� ���� �μ���ȣ�� ����� �̸��� �޿�
   
SELECT DEPTNO
    FROM EMP
    WHERE ENAME = 'SCOTT';
    
    
SELECT ENAME, SAL
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                    FROM EMP
                    WHERE ENAME = 'SCOTT')
    AND ENAME != 'SCOTT';
    
    
INSERT INTO DEPT VALUES(50, 'IT', 'DALLAS');
DESC EMP;
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (9999,'HONG', 50);

    

    -- SCOTT �� ���� �ٹ����� ����� �̸��� �޿� 

SELECT LOC
    FROM DEPT D, EMP E
    WHERE E.DEPTNO = D.DEPTNO
    AND ENAME = 'SCOTT'; -- ��������
    

SELECT ENAME, NVL(SAL ,0)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
    AND LOC = (SELECT LOC
               FROM DEPT D, EMP E
               WHERE E.DEPTNO = D.DEPTNO
               AND ENAME = 'SCOTT')
    AND ENAME != 'SCOTT'; -- ��������
    
    
ROLLBACK;




-- SCOTT �� ���� �μ��� �ٹ��ϴ� ����� �޿���

SELECT DEPTNO
    FROM EMP
    WHERE ENAME = 'SCOTT';
    

SELECT SUM(SAL)
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                    FROM EMP
                    WHERE ENAME = 'SCOTT')
    AND ENAME != 'SCOTT';
    


-- SCOTT �� ���� JOB�� ���� ����� ��� �ʵ带 ���


SELECT JOB
    FROM EMP
    WHERE ENAME = 'SCOTT'; -- SUB
    
    
SELECT *
    FROM EMP
    WHERE JOB = (SELECT JOB
                 FROM EMP
                 WHERE ENAME = 'SCOTT');
                 
                 
                 
    --DALLAS ���� �ٹ��ϴ� ����� �̸�, �μ���ȣ

SELECT DEPTNO
    FROM DEPT
    WHERE LOC = 'DALLAS';
    
SELECT ENAME, DEPTNO
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                 FROM DEPT
                 WHERE LOC = 'DALLAS');
    
    
    
-- SALES (DNAME) �μ��� �ٹ��ϴ� ����� �̸� �޿�

SELECT ENAME, SAL 
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                    FROM DEPT
                    WHERE DNAME = 'SALES');
                    
    -- KING �� ���ӻ���� ����� �̸��� �޿�
    
SELECT ENAME, SAL
    FROM EMP
    WHERE MGR = (SELECT EMPNO
                 FROM EMP
                 WHERE ENAME = 'KING');
                 
    -- ��� �޿� ���Ϸ� �޴� ����� �̸��� �޿�

SELECT AVG(SAL)
    FROM EMP;
   
    
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL)
                 FROM EMP);
    
    
    -- ��� �޿� ���Ϸ� �޴� ����� �̸��� �޿�, ��ձ޿� ���

SELECT AVG(SAL)
    FROM EMP;
    
SELECT ENAME, SAL, (SELECT ROUND(AVG(SAL)) FROM EMP) AVG 
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL)
                  FROM EMP);
    
    
    
    -- ��� �޿� ���Ϸ� �޴� ����� �̸��� �޿�, ��ձ޿��� ���̸� ���

SELECT ENAME, SAL, ABS((SELECT ROUND(AVG(SAL),2) FROM EMP) - SAL) DIFF
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    
    
-- SCOTT�� JOB�� DEPTNO �� ���� ������ ��� �ʵ� ���

SELECT JOB, DEPTNO 
    FROM EMP
    WHERE ENAME = 'SCOTT'; -- ���߿� ��������
    
SELECT *
    FROM EMP
    WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO 
                           FROM EMP
                           WHERE ENAME = 'SCOTT')         -- ���߿� ���������� ������ �߿��ϴ�.
    AND ENAME != 'SCOTT';
                           
              
                           
                           
                           
                           
                           
                           
-- �� �� ��������
--1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���

SELECT MIN(HIREDATE)
    FROM EMP;
    
SELECT ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE)
                      FROM EMP);


-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�

SELECT ENAME, SAL
    FROM EMP
    WHERE SAL = (SELECT MIN(SAL)
                 FROM EMP);


-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�

SELECT ROUND(AVG(SAL), 2)
    FROM EMP;
    
SELECT ENAME, SAL, DEPTNO
    FROM EMP
    WHERE SAL >= (SELECT ROUND(AVG(SAL), 2)
                  FROM EMP);



--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���

SELECT ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE SAL <= (SELECT AVG(SAL)
                  FROM EMP)
    AND E.DEPTNO = D.DEPTNO;



--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT HIREDATE
    FROM EMP
    WHERE ENAME = 'SCOTT';

SELECT * FROM SALGRADE;

SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    AND HIREDATE < (SELECT HIREDATE
                     FROM EMP
                     WHERE ENAME = 'SCOTT');
    


--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� �޿��� ū �� ����


SELECT ENAME, SAL, HIREDATE, GRADE, DNAME
    FROM EMP E, SALGRADE, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL
    AND HIREDATE < (SELECT HIREDATE
                     FROM EMP
                     WHERE ENAME = 'SCOTT')
    AND E.DEPTNO = D.DEPTNO
    ORDER BY SAL DESC;
 
--7. BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿�

SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT SAL
                 FROM EMP
                 WHERE ENAME = 'BLAKE');


--8. MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի���

SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE > (SELECT HIREDATE
                        FROM EMP
                        WHERE ENAME = 'MILLER');


--9. �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿�

SELECT AVG(SAL)
    FROM EMP;


SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL)
                 FROM EMP);

--10. CLARK�� ���� �μ���ȣ�̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿�

SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                    FROM EMP
                    WHERE ENAME = 'CLARK')
    AND SAL > (SELECT SAL
               FROM EMP
               WHERE EMPNO = 7698);
    
    
--    WHERE EMPNO = 7698;

--11.  �����ȭ. CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿�

SELECT DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    AND ENAME = 'CLARK';



--12. BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի�����

SELECT ENAME, HIREDATE
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO 
                    FROM EMP
                    WHERE ENAME = 'BLAKE');



--13. ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸� �� �޿��� ���� ������ ���)
SELECT EMPNO, ENAME FROM EMP
    WHERE SAL >= (SELECT AVG(SAL) FROM EMP)
    ORDER BY SAL DESC;





-- 3. ������ ��������; IN, ALL, ANY = SOME, EXISTS

-- (1) IN  ; �������� ��� �� �ϳ��� ��ġ�ϸ� TRUE�� ��
-- �μ����� �Ի����� ���� ���� ����� �̸�, �Ի���, �μ���ȣ
SELECT DEPTNO, MAX(HIREDATE)
    FROM EMP
    GROUP BY DEPTNO;

SELECT ENAME, HIREDATE, DEPTNO
    FROM EMP
    WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE)
                                 FROM EMP
                                 GROUP BY DEPTNO);

-- �޿��� 3õ�̻��� ����� �Ҽӵ� �μ����� �ٹ��ϴ� ����� ��� �ʵ�

SELECT DEPTNO   
    FROM EMP
    WHERE SAL >= 3000;
    
SELECT *
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO
                     FROM EMP
                     WHERE SAL >= 3000);


-- (2) ALL ; ��� �����ؾ��Ѵ�.

SELECT MAX(SAL)
    FROM EMP
    WHERE DEPTNO = 30;
    
    
    
SELECT * 
    FROM EMP
    WHERE SAL > ALL (SELECT SAL
                     FROM EMP
                     WHERE DEPTNO = 30);


SELECT *
    FROM EMP
    WHERE SAL > (SELECT MAX(SAL)
                 FROM EMP
                 WHERE DEPTNO = 30);


-- (3) ANY ; �������� ��� �ϳ��� �����ϸ� ��
-- 30�� �μ� �ּ� �޿����� ū��� 

SELECT *  
    FROM EMP
    WHERE SAL > ANY (SELECT SAL
                     FROM EMP
                     WHERE DEPTNO = 30);
                     
SELECT *
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL)
                 FROM EMP
                 WHERE DEPTNO = 30);

-- (4) EXISTS ; ���������� �����ϸ� ��
-- ���Ӻ��ϰ� �ִ� �������� ���, �̸�, �޿�

SELECT EMPNO, ENAME, SAL
    FROM EMP MANAGER
    WHERE EXISTS (SELECT *
                  FROM EMP
                  WHERE MANAGER.EMPNO = MGR);

SELECT W.ENAME, M.EMPNO, M.ENAME, M.SAL
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
    
SELECT DISTINCT M.EMPNO, M.ENAME, M.SAL
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
    
-- ���ܻ���� ��� �ʵ� ���
SELECT *
    FROM EMP MANAGER
    WHERE NOT EXISTS (SELECT *
                      FROM EMP
                      WHERE MANAGER.EMPNO = MGR);
                      
SELECT M.*
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO
    AND W.ENAME IS NULL;
     
     
     --EX1 JOB �� MANAGER �� ����� ���� �μ��� �μ���ȣ�� ������
SELECT DEPTNO, LOC
    FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO
                  FROM EMP
                  WHERE JOB = 'MANAGER');
    
     
     
     --EX2 ������ 3õ�̻��� ����� �޿���޺� �ְ� ������ �޴� ������� ���, �̸�, ����, �Ի���, �޿�, �޿���� (4,5��� �ְ� SAL �����ΰ�)
     
SELECT GRADE, MAX(SAL)
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >= 3000
    GROUP BY GRADE;
    
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    AND (GRADE, SAL) IN (SELECT GRADE, MAX(SAL)
                         FROM EMP, SALGRADE
                         WHERE SAL BETWEEN LOSAL AND HISAL 
                         AND SAL >= 3000
                         GROUP BY GRADE);
     
     
     --EX3 �Ի� �б⺰ �ְ� ������ �޴� ����� �б�, ���, �̸�, ����, �Ի���, �޿�, ��
SELECT HIREDATE, CEIL(TO_CHAR(HIREDATE, 'MM') / 3) MONTH
    FROM EMP;                      -- �б� ���ϴ� ��
     

SELECT CEIL(TO_CHAR(HIREDATE, 'MM') / 3) QUARTER, MAX(SAL)
    FROM EMP
    GROUP BY CEIL(TO_CHAR(HIREDATE, 'MM') / 3)
    ORDER BY QUARTER;
    
SELECT CEIL(TO_CHAR(HIREDATE, 'MM') / 3) QUARTER, EMPNO, ENAME, JOB, HIREDATE, SAL, NVL(COMM, 0)
    FROM EMP
    WHERE (CEIL(TO_CHAR(HIREDATE, 'MM') / 3), SAL) IN (SELECT CEIL(TO_CHAR(HIREDATE, 'MM') / 3) QUARTER, MAX(SAL)
                                                           FROM EMP
                                                           GROUP BY CEIL(TO_CHAR(HIREDATE, 'MM') / 3))
    ORDER BY QUARTER;
     
     

     --EX4 SALESMAN �� ��� ����麸�� �޿��� ���� �޴� ����� �̸�, �޿�(ALL)
     
     
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL > ALL (SELECT SAL 
                         FROM EMP
                         WHERE JOB = 'SALESMAN');


SELECT ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT MAX(SAL)
                 FROM EMP
                 WHERE JOB = 'SALESMAN')
    ORDER BY SAL;
     

     
     --EX5 �޿��� 3õ�̸��� ��� �� �ֱ� �Ի��� ����� ���, �̸�, ����, �Ի���

SELECT MAX(HIREDATE)
    FROM EMP
    WHERE SAL < 3000;
    

SELECT EMPNO, ENAME, SAL * 12 + NVL(COMM, 0) ANNUAL_SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE)
                        FROM EMP
                        WHERE SAL < 3000);




-- ���⼭���ʹ� �����༭�������� �����༭������, ������ �����༭������
-- 14.  �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� ������ ��� ��ȣ,�̸�,�޿�(�� ��� �� ���)

SELECT DEPTNO
    FROM EMP
    WHERE ENAME LIKE ('%T%');
    


SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO
                        FROM EMP
                        WHERE ENAME LIKE '%T%')
    ORDER BY EMPNO;


-- 15. �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿�
SELECT LOC
    FROM DEPT
    WHERE LOC = 'DALLAS';
    
SELECT ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    AND LOC = (SELECT LOC
               FROM DEPT
               WHERE LOC = 'DALLAS');



-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿�

SELECT EMPNO
    FROM EMP
    WHERE ENAME = 'KING';
    
SELECT ENAME, SAL
    FROM EMP
    WHERE MGR = (SELECT EMPNO
                   FROM EMP
                   WHERE ENAME = 'KING');



-- 17. SALES�μ� ����� �̸�, ����

SELECT DNAME
    FROM DEPT
    WHERE DNAME = 'SALES';
    
SELECT ENAME, JOB
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    AND DNAME = (SELECT DNAME
                 FROM DEPT
                 WHERE DNAME = 'SALES');

    



-- 18. ������ �μ� 30�� ���� ���޺��� ���� ����� ��� �ʵ�

SELECT MIN(SAL)
    FROM EMP
    WHERE DEPTNO = 30;
    
SELECT *
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL)
                        FROM EMP
                        WHERE DEPTNO = 30);
                        



-- 19. �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ����

SELECT JOB
    FROM EMP
    WHERE DEPTNO = '30'
    GROUP BY JOB;
    
SELECT ENAME, JOB
    FROM EMP
    WHERE DEPTNO = '10' AND JOB IN (SELECT JOB
                                        FROM EMP
                                        WHERE DEPTNO = '30'
                                        GROUP BY JOB);


-- 20.  FORD�� ������ ���޵� ���� ����� ��� �ʵ�

SELECT JOB, SAL
    FROM EMP
    WHERE ENAME = 'FORD';
    
    
SELECT *
    FROM EMP
    WHERE (JOB, SAL) IN (SELECT JOB, SAL
                            FROM EMP
                            WHERE ENAME = 'FORD')
    AND ENAME != 'FORD';

-- 21. �̸��� JONES�� ������ JOB�� ���ų� FORD�� SAL �̻��� �޴� ����� ������ �̸�, ����, �μ���ȣ, �޿�
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ���

SELECT JOB
    FROM EMP
    WHERE ENAME = 'JONES';
    
SELECT SAL
    FROM EMP
    WHERE ENAME = 'FORD';

SELECT ENAME, JOB, EMPNO, SAL
    FROM EMP
    WHERE JOB = (SELECT JOB
                    FROM EMP
                    WHERE ENAME = 'JONES')
    OR SAL >= (SELECT SAL
                FROM EMP
                WHERE ENAME = 'FORD')
    ORDER BY JOB, SAL;

-- 22. SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿�

SELECT ENAME, JOB, SAL FROM EMP
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME = 'SCOTT' OR ENAME = 'WARD');



-- 23. CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,����



-- 24. �μ����� ������ ��� ���޺��� ���� ����� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL, DEPTNO,  (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO) AVG
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO);
    




-- 25. �������� ��� ���޺��� ���� ������ �޴� ����� �μ���ȣ, �̸�, �޿�

SELECT DEPTNO, ENAME, SAL, JOB
    FROM EMP E
    WHERE SAL < (SELECT AVG(SAL)
                 FROM EMP
                 WHERE JOB = E.JOB);



-- 26. ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����, �̸�, ���, �μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP M
    WHERE EXISTS (SELECT *
                    FROM EMP
                    WHERE MGR = M.EMPNO);       -- EXISTS �̿�
                    
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP
    WHERE EMPNO IN (SELECT MGR  
                        FROM EMP);         --  IN �̿�
    
    
SELECT DISTINCT M.JOB, M.ENAME, M.EMPNO, M.DEPTNO
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;



-- 27.  ���� ����� ���, �̸�, ����, �μ���ȣ


SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP M
    WHERE NOT EXISTS (SELECT *
                        FROM EMP
                        WHERE NOT MGR IS NULL);
                        
                        
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP
    WHERE EMPNO NOT IN(7902, 7698);
    
    
    
SELECT W.ENAME, M.JOB, M.ENAME, M.EMPNO, M.DEPTNO
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL;
    
    
    
    