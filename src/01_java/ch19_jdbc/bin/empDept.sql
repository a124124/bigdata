-- �μ� �̸��� �޾� �ش� �μ� ������ ��� ���� (���, �̸�, �޿�, ����̸�)

SELECT * FROM DEPT WHERE DNAME = 'OPERATIONS';


SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO AND W.DEPTNO = M.DEPTNO AND DNAME = 'OPERATIONS';

