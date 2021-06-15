DROP TABLE PERSON;
DROP TABLE JOB;

-- 테이블 및 시퀀스 생성
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

INSERT INTO JOB VALUES(10, '배우');
INSERT INTO JOB VALUES(20, '가수');
INSERT INTO JOB VALUES(30, '엠씨');


-- 1번 쿼리(이름, 직업명, 국, 영, 수 입력받아 INSERT)
SELECT *
    FROM PERSON;

INSERT INTO PERSON
    VALUES (PERSON_NO_SQ.NEXTVAL, '홍길동', (SELECT JNO
                                                FROM JOB
                                                WHERE JNAME = '배우'), 60, 70, 80);

INSERT INTO PERSON
    VALUES (PERSON_NO_SQ.NEXTVAL, '정우성', (SELECT JNO
                                                FROM JOB
                                                WHERE JNAME = '배우'), 90, 80, 81);

INSERT INTO PERSON
    VALUES (PERSON_NO_SQ.NEXTVAL, '설현', (SELECT JNO
                                                FROM JOB
                                                WHERE JNAME = '가수'), 95, 95, 95);
 
 INSERT INTO PERSON
    VALUES (PERSON_NO_SQ.NEXTVAL, '배수지', (SELECT JNO
                                                FROM JOB
                                                WHERE JNAME = '가수'), 20, 90, 90); 

INSERT INTO PERSON
    VALUES (PERSON_NO_SQ.NEXTVAL, '박세영', (SELECT JNO
                                                FROM JOB
                                                WHERE JNAME = '배우'), 80, 90, 80);                                            

COMMIT;
-- 2번 쿼리(해당 직업 명의 등수,  이름(X번),직업,  국어(kor), 영어(eng), 수학(mat), 총점 정렬

SELECT NAME||'('||NO||'번)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
    FROM PERSON P, JOB J
    WHERE P.JNO = J.JNO AND JNAME = '배우'
    ORDER BY SUM DESC;


SELECT NAME||'('||NO||'번)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
    FROM PERSON P, JOB J
    WHERE P.JNO = J.JNO AND JNAME = '가수'
    ORDER BY SUM DESC;


SELECT ROWNUM RANK, S.*
    FROM (SELECT NAME||'('||NO||'번)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
                FROM PERSON P, JOB J
                WHERE P.JNO = J.JNO AND JNAME = '배우'
                ORDER BY SUM DESC) S;



-- 3번 쿼리(전체 입력된 사람의 등수, 이름, 직업, 국어(kor), 영어(eng), 수학(mat), 총점 정렬


SELECT ROWNUM RANK, S.*
    FROM (SELECT NAME||'('||NO||'번)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
            FROM PERSON P, JOB J
            WHERE P.JNO = J.JNO
            ORDER BY SUM DESC) S;
            
            
            
-- 4. 직업명 리스트

SELECT JNAME 
    FROM JOB
    ORDER BY JNO;
