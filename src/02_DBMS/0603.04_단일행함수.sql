-- [IV] ������ �Լ�

--�Լ� = �������Լ� + �׷��Լ�(�����Լ�)

SELECT HIREDATE, TO_CHAR(HIREDATE, 'YY"��"MM/DD') 
    FROM EMP;
    
SELECT ENAME, INITCAP(ENAME) 
    FROM EMP;

SELECT SUM(SAL)
    FROM EMP; -- �׷��Լ�(�����Լ�) 
    
SELECT DEPTNO, SUM(SAL) 
    FROM EMP GROUP BY DEPTNO;     -- �μ���ȣ�� �հ�
     -- �������Լ��� �����Լ��� ���� �� �� ����.


-- EX. ���ڰ���, ���ڰ���, ��¥����, ����ȯ(��¥ ->���� ��), NULL����(NVL) ��...
-- 1. ���ڰ��� �Լ�


SELECT ABS(-9) -- ���밪�� ���´�
    FROM DUAL;      -- DUAL ���̺��� ���ӻ� : ����Ŭ���� �⺻������ �����ϴ� 1�� 1��¥�� ���� ���̺�
SELECT *
    FROM DUAL;
DESC DUAL;

SELECT *
    FROM DUMMY;
    
    
SELECT FLOOR(34.4265) -- �Ҽ������� ����
    FROM DUAL;
    
SELECT FLOOR(34.5696 * 100) / 100 -- �Ҽ��� 2��° �ڸ����� ����
    FROM DUAL;
    
SELECT TRUNC(34.5696)
    FROM DUAL;
    
SELECT TRUNC(34.5696,2) 
    FROM DUAL;
    
SELECT TRUNC(34.5696, -1) -- 1���ڸ����� ����
    FROM DUAL; 
    
  -- EMP ���̺��� �̸� �޿�(10���ڸ����� ����) ���  
SELECT ENAME, TRUNC(SAL, -2)
    FROM EMP;
    
SELECT CEIL(34.5678) -- �Ҽ��� �ø�
    FROM DUAL;
    
SELECT ROUND(34.5678) -- �Ҽ��� �ݿø�
    FROM DUAL;
    
SELECT ROUND(34.5678, 2) -- �Ҽ��� 2�ڸ����� �ݿø�
    FROM DUAL;
    
SELECT ROUND(34.5678, -1) -- 1���ڸ����� �ݿø�
    FROM DUAL;
    
    
    
SELECT MOD(19, 4) -- ������ ������
    FROM DUAL;
    
SELECT MOD('9' / '2')
    FROM DUAL;
    


    -- EMP ���� Ȧ���޿� �Ի��� ����� ���

SELECT *
    FROM EMP
    WHERE MOD(TO_CHAR(HIREDATE, 'MM'), 2) = 1;



-- 2. ���ڰ��� �Լ�