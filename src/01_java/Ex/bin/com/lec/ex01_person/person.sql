DROP TABLE PERSON;
DROP TABLE JOB;

-- ���̺� �� ������ ����
CREATE TABLE JOB(
    JNO NUMBER(2) PRIMARY KEY,
    JNAME VARCHAR2(30) NOT NULL
    );

CREATE TABLE PERSON(
    NO NUMBER(8) PRIMARY KEY,
    NAME VARCHAR2(30) NOT NULL,
    JNO NUMBER(2) NOT NULL REFERENCES JOB(JNO),
    KOR NUMBER(3),
    ENG NUMBER(3),
    MAT NUMBER(3)
    
);

DROP SEQUENCE PERSON_NO_SQ;
CREATE SEQUENCE PERSON_NO_SQ 
    MAXVALUE 99999999
    NOCYCLE
    NOCACHE
    ;

INSERT INTO JOB VALUES(10, '���');
INSERT INTO JOB VALUES(20, '����');
INSERT INTO JOB VALUES(30, '����');


-- 1�� ����(�̸�, ������, ��, ��, �� �Է¹޾� INSERT)
SELECT *
    FROM PERSON;

INSERT INTO PERSON
    VALUES (PERSON_NO_SQ.NEXTVAL, 'ȫ�浿', (SELECT JNO
                                                FROM JOB
                                                WHERE JNAME = '���'), 60, 70, 80);

INSERT INTO PERSON
    VALUES (PERSON_NO_SQ.NEXTVAL, '���켺', (SELECT JNO
                                                FROM JOB
                                                WHERE JNAME = '���'), 90, 80, 81);

INSERT INTO PERSON
    VALUES (PERSON_NO_SQ.NEXTVAL, '����', (SELECT JNO
                                                FROM JOB
                                                WHERE JNAME = '����'), 95, 95, 95);
 
 INSERT INTO PERSON
    VALUES (PERSON_NO_SQ.NEXTVAL, '�����', (SELECT JNO
                                                FROM JOB
                                                WHERE JNAME = '����'), 20, 90, 90); 

INSERT INTO PERSON
    VALUES (PERSON_NO_SQ.NEXTVAL, '�ڼ���', (SELECT JNO
                                                FROM JOB
                                                WHERE JNAME = '���'), 80, 90, 80);                                            

COMMIT;
-- 2�� ����(�ش� ���� ���� ���,  �̸�(X��),����,  ����(kor), ����(eng), ����(mat), ���� ����

SELECT NAME||'('||NO||'��)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
    FROM PERSON P, JOB J
    WHERE P.JNO = J.JNO AND JNAME = '���'
    ORDER BY SUM DESC;


SELECT NAME||'('||NO||'��)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
    FROM PERSON P, JOB J
    WHERE P.JNO = J.JNO AND JNAME = '����'
    ORDER BY SUM DESC;


SELECT ROWNUM RANK, S.*
    FROM (SELECT NAME||'('||NO||'��)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
                FROM PERSON P, JOB J
                WHERE P.JNO = J.JNO AND JNAME = '���'
                ORDER BY SUM DESC) S;



-- 3�� ����(��ü �Էµ� ����� ���, �̸�, ����, ����(kor), ����(eng), ����(mat), ���� ����


SELECT ROWNUM RANK, S.*
    FROM (SELECT NAME||'('||NO||'��)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
            FROM PERSON P, JOB J
            WHERE P.JNO = J.JNO
            ORDER BY SUM DESC) S;
            
            
            
-- 4. ������ ����Ʈ

SELECT JNAME 
    FROM JOB
    ORDER BY JNO;
