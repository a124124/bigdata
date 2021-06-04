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

SELECT UPPER('abcABC')
    FROM DUAL;
    
SELECT LOWER('abcABC')
    FROM DUAL;

SELECT INITCAP('WELCOME TO ORACLE')
    FROM DUAL;

    -- JOB �� MANAGER�� ������ ��� �ʵ�

SELECT *
    FROM EMP
    WHERE UPPER(JOB) = 'MANAGER';
    
    --�̸��� SCOTT�� ������ �ʵ�
    
SELECT *
    FROM EMP
    WHERE INITCAP(ENAME) = 'Scott';



-- ���ڿ��� (CONCAT �Լ�, ||������)

SELECT 'AB'||'CD'||'EF'||'GH'   
    FROM DUAL;
    
    
SELECT CONCAT(CONCAT('AB','CD'), CONCAT('EF','GH'))
    FROM DUAL;
    
 -- XXX�� XX�� (SCOTT�� JOB�̴�) ���
 
 SELECT CONCAT(CONCAT(ENAME,'��'), CONCAT(JOB,'��'))
    FROM EMP;
    
 -- SUBSTR(STR, ����BYTE��ġ, ���ڰ���) ù��° ��ġ�� 1
 SELECT SUBSTR('ORACLE', 3, 2)  --3 ��° ���ں��� 2���� ����
    FROM DUAL;
SELECT SUBSTR('�����ͺ��̽�', 4, 2)   
    FROM DUAL; 
 
 --SUBSTRB(STR, ������ġ, ���� BYTE��)
 
 
SELECT SUBSTRB('ORACLE', 3, 2)   -- 3��° ���ں��� 2BYTE�� ����
    FROM DUAL;
SELECT SUBSTRB('�����ͺ��̽�', 4, 2)   
    FROM DUAL;    
    
    -- ����� 1BYTE, �ѱ��� 3BYTE
    
    
-- -�� �ڿ������ͼ��� +�� �տ������� ����.
SELECT SUBSTR('WELCOME TO ORACLE', -6, 6)
    FROM DUAL;
    

-- 9���� �Ի��� ����� ��� �ʵ� 81/09/01
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

SELECT *
    FROM EMP 
    WHERE SUBSTR(HIREDATE, 4, 2) = '09';
    
SELECT *
    FROM EMP
    WHERE SUBSTR(HIREDATE, -2, 2)= '09';
    
    
SELECT LENGTH('ABCD') 
    FROM DUAL;
    
SELECT LENGTHB('ABCD') 
    FROM DUAL;
    
SELECT LENGTH('����Ŭ') 
    FROM DUAL;
    
SELECT LENGTHB('����Ŭ') 
    FROM DUAL;
-- INSTR(STR, ã������) ; STR ���� ã�� ������ ��ġ(ù��° 1), ������ 0�� �����Ѵ�
-- INSTR(STR, ã������, ������ġ) ; STR ���� ã�� ������ ��ġ(ù��° 1), ������ 0�� �����Ѵ�

SELECT INSTR('ABCABCABC', 'B')
    FROM DUAL;
    
SELECT INSTR('ABCABCABC', 'B', 3)
    FROM DUAL;    

SELECT * 
    FROM EMP
    WHERE INSTR(HIREDATE, '09', 3) = 4;

SELECT *
    FROM EMP
    WHERE INSTR(HIREDATE, '09', 6)= 7;
    
-- LPAD(STR, �ڸ���, ä�﹮��) STR�� �ڸ�����ŭ Ȯ���ϰ� ���� ���ڸ��� ä�� ���ڸ� ���

SELECT LPAD('ORACLE', 10, '#')
    FROM DUAL;
    
    
SELECT ENAME, SAL 
    FROM EMP;
    
SELECT ENAME, LPAD(SAL, 6, '*')
    FROM EMP;
    
    -- ���, S**** (�̸� �� �ѱ��ڸ� ���)
    -- RPAD, SUBSTR, LENGTH ���

SELECT RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*')
    FROM EMP;
ROLLBACK;
    --  ���  �̸�  �Ի���
    -- 7499 _***H 80/12/**
    
SELECT EMPNO, LPAD(LPAD(SUBSTR(ENAME, -1, 1), LENGTH(ENAME), '*'), 10, ' ') NAME,
       RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*')HIRE
    FROM EMP;



-- �̸��� ����° �ڸ��� R�� ����� ��� �ʵ� ���(LIKE, INSTR, SUBSTR)

SELECT *
    FROM EMP
    WHERE ENAME LIKE '__R%';
    
SELECT *
    FROM EMP
    WHERE INSTR(ENAME, 'R', 3) = 3;

SELECT *
    FROM EMP
    WHERE SUBSTR(ENAME, 3, 1) ='R';
    
    
SELECT TRIM(' ORACLE DB     ') MSG 
    FROM DUAL;
    
SELECT LTRIM('         ORACLE DB     ') MSG 
    FROM DUAL;
    
SELECT RTRIM('      ORACLE DB     ') MSG 
    FROM DUAL;
 
 
 SELECT REPLACE(ENAME, 'A', 'XX')
    FROM EMP;
    
SELECT REPLACE(HIREDATE, '0', 'XXX')
    FROM EMP;
    
    
    
-- 3. ��¥���� �Լ� �� ����� 

SELECT SYSDATE 
    FROM DUAL;
    
SELECT TO_CHAR(SYSDATE, 'YY-MM-DD HH24:MI:SS')
    FROM DUAL;
    
    -- ����Ŭ Ÿ�� : ����, ����, DATE
    
    
SELECT SYSDATE -1, SYSDATE, SYSDATE +1
    FROM DUAL;
    
-- 14�� ��

SELECT SYSDATE + 14
    FROM DUAL;
    
    
-- EMP ���� �̸�, �Ի���, �ٹ���¥�� ���

SELECT ENAME, HIREDATE, FLOOR(SYSDATE - HIREDATE)
    FROM EMP;
    
    --�̸�, �Ի���, �ٹ��ּ�, �ٹ����
SELECT ENAME, HIREDATE, FLOOR((SYSDATE - HIREDATE) / 7) WEEK
    FROM EMP;    
SELECT ENAME, HIREDATE, FLOOR((SYSDATE - HIREDATE) / 365) YEAR
    FROM EMP;
    
    --�̸�, �Ի���, �ٹ����� MONTHS_BETWEEN() �Լ��� ���
    
SELECT ENAME, HIREDATE, FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE)) MONTHS
    FROM EMP;
    
    -- �̸�, �Ի���, �����������(���� 3�����̶�� ġ��) ADD_MONTHS()�Լ�
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 3) AN
    FROM EMP;
    
    
-- �̸�, �Ի��� ���� ���� �޿��� ��(�޿��� �Ŵ� SAL�� �ް� �󿩱��� 2�� COMM�� ����)

SELECT ENAME, TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE) * SAL +
              TRUNC((SYSDATE-HIREDATE)/365)*2*NVL(COMM,0)) "COST" 
              FROM EMP;


-- NEXT_DAY(Ư������, '��') Ư����¥�κ��� ó�� �´� ������

SELECT NEXT_DAY(SYSDATE,'��')
    FROM DUAL;


--LAST_DAY(Ư����¥) ; Ư����¥ ���� ����

SELECT LAST_DAY(SYSDATE)
    FROM DUAL;
    
    
-- EMP �̸�, �Ի���, ù���޳�(���޳� ����)

SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE)
    FROM EMP;
    

-- ROUND; ��¥ �ݿø� TRUNC ; ��¥ ����

SELECT ROUND(34.5678,2) 
    FROM DUAL;

SELECT ROUND(SYSDATE, 'YEAR') -- ����� 1�� 1��
    FROM DUAL;

SELECT ROUND(SYSDATE, 'MONTH') -- ����� 1��
    FROM DUAL;
    
SELECT ROUND(SYSDATE, 'DAY') -- ����� �Ͽ���
    FROM DUAL;
    
SELECT ROUND(SYSDATE)       -- ����� 0��
    FROM DUAL; 
    
SELECT TRUNC(SYSDATE, 'YEAR')
    FROM DUAL;

SELECT TRUNC(SYSDATE, 'MONTH')
    FROM DUAL;

SELECT TRUNC(SYSDATE, 'DAY')
    FROM DUAL;

SELECT TRUNC(SYSDATE)
    FROM DUAL;
    
-- �̸� , �Ի���, �Ի��� ���� 2��
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH') +1
    FROM EMP;
-- �̸� , �Ի���, ���޳�(5��) ; �Ի����� �Ѵ��� �ȵǾ 5�ϵǸ� ������ ����
SELECT ENAME, HIREDATE, ROUND(HIREDATE +11, 'MONTH') +4 
    FROM EMP;
-- �̸� , �Ի���, ���޳�(15��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE +1, 'MONTH') +14 
    FROM EMP;
-- �̸� , �Ի���, ���޳�(25��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9, 'MONTH') +24 
    FROM EMP;
    
    
    
-- 4 ����ȯ �Լ� TO_CHAR() ���ڷ� ����ȯ// TO_DATE() DATE������ ����ȯ
-- 1. TO_CHAR(DATE�� ������, '�������')
SELECT TO_CHAR(SYSDATE, 'YY"��"MM"��"DD"��"DY"����"HH24:MI:SS')
    FROM DUAL;
    -- YYYY �⵵ RR �⵵ MM �� DD �� 
    --DAY ���� / DY ���� ���ǥ��
    --AM PM HH12 HH24 MI SS
    
SELECT ENAME, TO_CHAR(HIREDATE, 'YY/MM/DD DY AM HH12:MI:SS')
    FROM EMP;
    
 
SELECT TO_CHAR(12345678, '999,999,999') -- �ڸ����� ���Ƶ� ���ڸ�ŭ�� ���
    FROM DUAL;
    
    
SELECT TO_CHAR(12345678, '000,000,000') -- �ڸ����� ������ 0���� ���
    FROM DUAL;
    
    -- ���ڸ����� , ���� . �Ҽ��� ����
    -- l ������ȭ����
    
SELECT TO_CHAR(1000, 'L9,999')
    FROM DUAL;
    
SELECT ENAME, SAL, TO_CHAR(SAL, '$99,999') 
    FROM EMP;
    
    
    --2. TO_DATE(����, '����')
    
SELECT TO_DATE('81/01/01', 'YY/MM/DD')
    FROM DUAL;
    
SELECT *
    FROM EMP
    WHERE HIREDATE BETWEEN '81/05/01' AND '83/05/01';
    
    
    
    ROLLBACK;
    
    
-- TO_NUMBER(����, ����)

SELECT TO_NUMBER('3,456.78', '9,999.99') 
    FROM DUAL;

SELECT '3456.78' +1
    FROM DUAL;
    
 --5. NVL(NULL �ϼ� �ִ� ������, NULL �̸� ����� ��) -- Ÿ���� ��ġ�ؾ���
 -- �̸�, ����� ���(MGR) �� ��� , ���� ��簡 ���� ��� CEO ��� ���
 
 SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO')
    FROM EMP;
    
    
    --6. ETC
    
    --1 EXTRACT ; �⵵�� ���� �����ϰ��� �� ��
    
SELECT EXTRACT(YEAR FROM SYSDATE) 
    FROM DUAL;
    
SELECT TO_CHAR(SYSDATE, 'YYYY')
    FROM DUAL;
    
SELECT EXTRACT(MONTH FROM SYSDATE) 
    FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'MM')  
    FROM DUAL;
    
    --81 �⵵�� �Ի��� ����
    
SELECT *
    FROM EMP
    WHERE EXTRACT(YEAR FROM HIREDATE) = 1981;
    
SELECT *
    FROM EMP
    WHERE HIREDATE BETWEEN
        TO_DATE('1981-01-01', 'YYYY-MM-DD') AND TO_DATE('1981-12-31', 'YYYY-MM-DD');
        


    --(2) ������ ��� : LEVEL , START WITH ����, CONNECT BY PRIOR ����
    
    
SELECT LEVEL, LPAD(' ', LEVEL * 2) ||  ENAME 
    FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO = MGR;
    
    -- <�� ��������>
-- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date"
    FROM DUAL;


-- 2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�,
-- �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ����
SELECT EMPNO, ENAME, JOB, SAL, SAL * 1.15 "New Salary", SAL * 0.15 "Increase"
    FROM EMP;


ROLLBACK;
--3. �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.

SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '��') "6MONTHLATER"
    FROM EMP;

--4. �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ���
SELECT ENAME, HIREDATE, FLOOR((SYSDATE - HIREDATE) / 7) WEEK, SAL, FLOOR((SYSDATE - HIREDATE) / 7) * SAL TOTSAL
    FROM EMP;


--5. ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ���
SELECT ENAME, LPAD(SAL, 15, '*') 
    FROM EMP;
-- RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*')HIRE



--6. ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY') DAY
    FROM EMP;


--7. �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ���
SELECT ENAME, LENGTH(ENAME) , JOB
    FROM EMP
    WHERE LENGTH(ENAME) >=6;



--8. ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ���
SELECT ENAME, JOB, SAL, NVL(COMM ,0) COMM, SAL + NVL(COMM ,0) TOTAL
    FROM EMP;


-- 9.��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT SUBSTR(ENAME, 2, 3)
    FROM EMP;
 



--10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 
--  �ý��ۿ� ���� DATEFORMAT �ٸ� �� �����Ƿ� �Ʒ��� ����� �˾ƺ���

SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE TO_CHAR(HIREDATE, 'MM') = 12;


--11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--����. 

SELECT EMPNO, ENAME, LPAD(SAL ,10, '*') �޿�
    FROM EMP;





-- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
-- EMPNO	 ENAME 	�Ի���
-- 7369	  SMITH		1980-12-17
-- ��.

SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') �Ի���
    FROM EMP;


--13. ��� ���̺��� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.
    --(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)
    
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$999,999,999') "SAL"
    FROM EMP
    WHERE DEPTNO = 20;
    



-- [V] �׷� �Լ�

SELECT ENAME, ROUND(SAL, -3)     -- ������ �Լ�
    FROM EMP;
    
SELECT MAX(SAL)    -- �׷��Լ� 
    FROM EMP;
    
SELECT ENAME, MAX(SAL)
    FROM EMP;              -- VI �� ������������ �ذ�
    
SELECT DEPTNO, MAX(SAL) 
    FROM EMP
    GROUP BY DEPTNO;


--1. �׷��Լ��� �ǽ�

SELECT ROUND(AVG(SAL),2) 
    FROM EMP;
    
SELECT COUNT(SAL)  -- SAL �� ���Ե� ���� ����
    FROM EMP;
    
SELECT COUNT(*)  -- EMP ���̺��� �� ��(�ο�)�� ����
    FROM EMP;


SELECT COMM
    FROM EMP;
    
SELECT SUM(COMM)
    FROM EMP;

SELECT AVG(COMM)
    FROM EMP;
    
SELECT COUNT(COMM)
    FROM EMP;
    
    --��� �׷��Լ��� NULL ���� �����Ѵ�.
    
    --SAL �� ���, ��, �ּҰ�, �ִ밪, �л�, ǥ������
    
    
SELECT AVG(SAL), SUM(SAL), MIN(SAL), MAX(SAL), ROUND(VARIANCE(SAL)), ROUND(STDDEV(SAL)), COUNT(SAL)
    FROM EMP;
    
SELECT SQRT(VARIANCE(SAL)), STDDEV(SAL)
    FROM EMP;
    
-- �׷��Լ� MAX, MIN, COUNT �� ������, ������, ��¥�� ��� ��� ����

    --���� �ֱٿ� �Ի��� ����� �Ի��ϰ� ������ ����� �Ի���

SELECT MIN(HIREDATE), MAX(HIREDATE)
    FROM EMP;
    -- 83/01/12 : XXX,XXX��(�ٹ��ϼ�)

SELECT '�ֱ��Ի����� ' || MAX(HIREDATE) || '�ٹ� �ϼ��� ' || TO_CHAR(MIN(TRUNC(SYSDATE-HIREDATE)), '99,999') ||'��' MSG,
       '�����Ի����� ' || MIN(HIREDATE) || '�ٹ� �ϼ��� ' || TO_CHAR(MAX(TRUNC(SYSDATE-HIREDATE)), '99,999') ||'��' MSG2
    FROM EMP;
    
    -- 10�� �μ� ����� ��� �޿�
    
SELECT AVG(SAL)
    FROM EMP
    WHERE DEPTNO= 10;
    
    
    
    --2. GROUP BY ��
    
    --�μ���ȣ�� �ִ�޿�
    
SELECT DEPTNO, MAX(SAL)
    FROM EMP
    GROUP BY DEPTNO;
    
    --�μ���ȣ�� �����, �ִ�޿� �ּұ޿� ��ձ޿� �Ҽ��� 2�ڸ�
    
SELECT DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL), 2)
    FROM EMP
    GROUP BY DEPTNO;

-- SAL �� 5000�̸��� ����� ���ؼ��� �μ���ȣ�� �����, �ִ�޿�, �ּұ޿�, ��ձ޿�

SELECT DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL), 2)
    FROM EMP
    WHERE SAL < 5000
    GROUP BY DEPTNO
    ORDER BY DEPTNO;
    
    -- �μ��� �����, �ִ�޿�, �ּұ޿�, ��ձ޿�

SELECT DNAME, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL), 2)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    
    GROUP BY DNAME
    ORDER BY DNAME;
    
    
-- 3. HAVING �� ; �׷� �Լ� ����� ����

--�μ��� ��� �޿�( ��� �޿��� 2000 �̻��� �μ��� ���)

SELECT DEPTNO, ROUND(AVG(SAL), 2) AVG_SAL
    FROM EMP
    HAVING AVG(SAL) >= 2000
    GROUP BY DEPTNO
    ORDER BY AVG_SAL DESC ; -- �ʵ��� ��Ī�� ORDER BY �������� ��� ����
    -- HAVING �� ��Ī�� ����� �� ����. 
    
    

-- 4. ��� ���� �� ���谩 ����

SELECT DEPTNO, SUM(SAL)
    FROM EMP
    GROUP BY ROLLUP(DEPTNO);
    
    
    
    -- ��<�� ��������>

-- 1. ��� ���̺��� �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ����Ͽ� ���


SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL)
    FROM EMP;


-- 2. ������̺��� ������ �ο����� ���Ͽ� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT JOB, COUNT(*)
    FROM EMP
    GROUP BY JOB;



--- 3. ������̺��� �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ����ϴ� SELECT������ �ۼ��Ͽ���.

SELECT MAX(SAL), MIN(SAL), MAX(SAL) - MIN(SAL) SN
    FROM EMP;


-- 4. �� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ����ϵ� �޿��� ���� ���� ������ ����϶�.

SELECT DEPTNO, COUNT(*), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO
    ORDER BY SUM(SAL) DESC;
    
    
SELECT DNAME, COUNT(*), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    GROUP BY DNAME
    ORDER BY SUM(SAL) DESC;


-- 5. �μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� 
    --���Ͽ� ����϶�(��°���� �μ���ȣ, ���������� �������� ����)

SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO, JOB;


-- 6. ������, �μ��� �׷��Ͽ� �����  ����, �μ���ȣ, �ο���, �޿��� ���, �޿��� ���� ���Ͽ� 
-- ����϶�.(��°���� ������, �μ���ȣ �� �������� ����)

SELECT JOB, DEPTNO, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB, DEPTNO
    ORDER BY JOB, DEPTNO;



--7. ������� 5���̻� �Ѵ� �μ���ȣ�� ������� ����Ͻÿ�.

SELECT DEPTNO, COUNT(*) C
    FROM EMP
    HAVING COUNT(*) >= 5
    GROUP BY DEPTNO;


-- 8. ������� 5���̻� �Ѵ� �μ���� ������� ����Ͻÿ�
SELECT DNAME, COUNT(*)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    HAVING COUNT(*) >= 5
    GROUP BY DNAME;

--9. ��� ���̺��� ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, 
--�޿��� ���� ���Ͽ� ����϶�

SELECT JOB, AVG(SAL), SUM(SAL)
    FROM EMP
    HAVING AVG(SAL) >= 3000
    GROUP BY JOB;




--10. ������̺��� �޿����� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿��հ踦 ����϶� 
        --��, �޿� �հ�� �������� �����϶�.
        
SELECT JOB, SUM(SAL)
    FROM EMP
    HAVING SUM(SAL) > 5000
    GROUP BY JOB
    ORDER BY SUM(SAL) DESC;
        

--11. �μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ����϶�.

SELECT DEPTNO, AVG(SAL), SUM(SAL), MIN(SAL)
    FROM EMP
    GROUP BY DEPTNO;



--12. ���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ, 
            --�μ��� �ּұ޿��� �ִ�ġ�� ����϶�.

SELECT MAX(AVG(SAL)), MAX(SUM(SAL)), MAX(MIN(SAL))
    FROM EMP
    GROUP BY DEPTNO;         
            

--13. ��� ���̺��� �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.(�⵵�� ������)
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--     80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100

SELECT  TO_CHAR(HIREDATE, 'RR') H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE, 'RR')
    ORDER BY H_YEAR;

    
    





-- 14.  ������̺��� �Ʒ��� ����� ����ϴ� SELECT �� �ۼ�
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	

SELECT NVL(TO_CHAR(HIREDATE, 'YYYY'), 'TOTAL') YEAR, COUNT(*) CNT
    FROM EMP
    
    GROUP BY ROLLUP(TO_CHAR(HIREDATE, 'YYYY'))
    
    ORDER BY TO_CHAR(HIREDATE, 'YYYY');



--15. ������̺��� �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���Ͻÿ�

SELECT MAX(SAL), MIN(SAL), SUM(SAL), AVG(SAL)
    FROM EMP;


--16. ������̺��� �μ��� �ο����� ���Ͻÿ�

SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO;

--17. ��� ���̺��� �μ��� �ο����� 6���̻��� �μ��ڵ带 ���Ͻÿ�

SELECT DEPTNO
    FROM EMP
    HAVING COUNT(*) >= 6
    GROUP BY DEPTNO;

--18. ������̺��� �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�. 
-- (��Ʈ self join, group by, count���)
--ENAME	    ���
--________________________
--KING		1
--SCOTT		2
--����


SELECT E1.ENAME, E1.SAL, E2.ENAME, E2.SAL
    FROM EMP E1, EMP E2
    WHERE E1.SAL < E2.SAL(+); -- 1�ܰ�



SELECT E1.ENAME, COUNT(E2.ENAME) + 1 "RANK"
    FROM EMP E1, EMP E2
    WHERE E1.SAL < E2.SAL(+)
    GROUP BY E1.ENAME
    ORDER BY RANK;  -- GROUP BY, COUNT




SELECT ENAME, RANK() OVER(ORDER BY SAL DESC) "RANK",
              DENSE_RANK() OVER(ORDER BY SAL DESC) "DENSE_RANK",
              ROW_NUMBER() OVER(ORDER BY SAL DESC) "ROW_NUMBER"
    FROM EMP;



