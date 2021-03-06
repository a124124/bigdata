        -- [VII] DDL, DML, DCL
        
    --SQL == DDL(테이블 생성, 테이블삭제, 테이블 구조변경)
    
    
--      DML (SELECT, INSERT, UPDATE, DELETE)
--      DCL (계정생성, 사용자 권한 부여, 권한 박탈, 사용자 계정 삭제, 트랜젝션 명령어)



-- DDL 
    --1. 테이블 생성 (CREATE TABLE)
    
DESC EMP;


CREATE TABLE BOOK(
    BOOKID NUMBER(4), -- 도서번호 BOOKID 필드의 타입은 숫자 4자리
    BOOKNAME VARCHAR2(20), -- 도서 이름 BOOKNAME 필드의 타입은 문자 20BYTE
    PUBLISHER VARCHAR2(20), -- 출판사 문자 20BYTE
    RDATE     DATE,  -- 출판일 타입은 DATE형
    PRICE NUMBER(8),
    PRIMARY KEY(BOOKID)); -- 테이블 내 주키(PRIMARY KEY) 설정(유일, NOT NULL)
    
    
SELECT *
    FROM BOOK;
    
    
DROP TABLE BOOK; -- 테이블 삭제

CREATE TABLE BOOK(
    BOOKID NUMBER(4) PRIMARY KEY, -- PRIMARY KEY(제약 조건)
    BOOKNAME VARCHAR2(100),
    PUBLISHER VARCHAR2(20),
    RDATE DATE,
    PRICE NUMBER(8)
    );
    
SELECT *
    FROM BOOK;
    
-- EMP와 유사한 EMP01 : EMPNO(숫자4), ENAME(문자20), SAL(숫자7,2)

CREATE TABLE EMP01(
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(20),
    SAL NUMBER(7, 2) -- 전체 7자리중 소수점 앞 5자리, 소수점 2자리, .은 포함안함
   
);


SELECT *
    FROM EMP01;
    
-- DEPT 와 유사한 DEPT01 : DEPTNO(숫자2), DNAME(문자14), LOC(문자13)

CREATE TABLE DEPT01(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13)
    );
    
SELECT *
    FROM DEPT01;
    
-- 서브쿼리를 이용한 테이블 생성

CREATE TABLE EMP02
    AS
    SELECT * FROM EMP; -- 서브쿼리 결과만 EMP02 테이블 생성후 들어간다(제약조건은 미포함)
    
    
SELECT *
    FROM EMP02;
    
DESC EMP02;

--EMP03 : EMP테이블에서 EMPNO, ENAME, DEPTNO만 추출

CREATE TABLE EMP03
    AS
    SELECT EMPNO, ENAME, DEPTNO
    FROM EMP;
    
SELECT *
    FROM EMP03;
    
    
--EMP04 : EMP 테이블에서 10번 부서만 추출

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
        WHERE 1 = 0; -- 반드시 거짓인문장을 넣으면 구조만 복사가된다.
        
SELECT *
    FROM EMP05;    
        
        
    -- 2. 테이블 구조 변경 (ALTER TABLE)
    -- ALTER TABLE 테이블명 ADD || MODIFY || DROP ~
    -- (1) 필드 추가
    
SELECT *
    FROM EMP03; 
    
ALTER TABLE EMP03
    ADD (JOB VARCHAR2(20), SAL NUMBER(7, 2)); -- 필드 추가하면 데이터는 기본적으로 NULL 이된다.


ALTER TABLE EMP03
    ADD (COMM NUMBER(7, 2));
    
        
    -- (2) 필드 타입 수정(MODIFY)
    
SELECT *
    FROM EMP03;
    
    
ALTER TABLE EMP03
    MODIFY (EMPNO VARCHAR2(5));  -- 에러나는 이유 :  숫자 데이터가 들어있어서 숫자로만 변경 가능
    
DESC EMP03;

ALTER TABLE EMP03
    MODIFY (ENAME VARCHAR2(30));
    


SELECT MAX(LENGTH(ENAME))
    FROM EMP;
    
    
ALTER TABLE EMP03
    MODIFY (JOB VARCHAR2(3)); -- NULL 이면 다 바꿀수 있다
    
ALTER TABLE EMP03
    MODIFY (JOB NUMBER(5));
    
    
    
SELECT EMPNO, ENAME -- ROWNUM : 테이블에서 행의 논리적 순서
    FROM EMP;
    
SELECT ROWNUM, EMPNO, ENAME
    FROM EMP;
    
    
    --3. 필드 삭제(DROP)
    
ALTER TABLE EMP03
    DROP COLUMN JOB;        -- NULL 인 필드 삭제    
    
SELECT *
    FROM EMP03;
    
    
ALTER TABLE EMP03
    DROP COLUMN DEPTNO;      -- DEPTNO필드 삭제시 데이터까지 제거됨
    
    
-- 논리적으로 특정필드를 접근하지 못하게 하는 명령어

ALTER TABLE EMP03
    SET UNUSED (COMM);      --COMM 접근 불가
    
SELECT *
    FROM EMP03;
    

ALTER TABLE EMP03
    DROP UNUSED COLUMNS;
    
    
    -- 3. 테이블 삭제 (DROP TABLE)
    
    
DROP TABLE EMP01;
SELECT *
    FROM EMP01;
    
DROP TABLE DEPT;

SELECT *
    FROM DEPT; -- 다른 테이블에서 참조하는 데이터가 있을경우 DROP 불가


        -- 4. 테이블의 모든 행을 제거(TRUNCATE)
        
SELECT *
    FROM EMP03;
    
TRUNCATE TABLE EMP03; -- EMP03 안의 데이터가 제거되고 취소가 불가함

SELECT *
    FROM EMP03;
    
    
    
        -- 5. 테이블명 변경(RENAME)
        
        
RENAME EMP02 TO EMP2;

SELECT *
    FROM EMP02;
    
    
        -- 6. 데이터 딕셔너리(접근불가) vs 데이터 덱셔너리 뷰 (사용자 접근용)
         
        -- USER_XX : 현 계정이 소유하고있는 객체
            -- USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS 등
        -- ALL_XX : 현 계정이 접근 가능한 객체
            --ALL_TABLES, ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS
        -- DBA_XX : DBA만 접근가능
            --DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS
            
            
SHOW USER;

SELECT *
    FROM USER_TABLES;   -- 내 계정이 소유한 테이블 객체
    
SELECT *
    FROM USER_INDEXES;  -- 내 계정이 소유한 인덱스 객체
        
SELECT *
    FROM USER_CONSTRAINTS;  -- 내 계정이 소유한 제약조건
    
SELECT *
    FROM USER_VIEWS;    -- 내 계정이 소유한 뷰
    
SELECT *
    FROM ALL_TABLES;    -- 내 계정이 접근 가능한 테이블 객체

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
    
        --DCL (사용자 계정생성, 사용자 권한부여, 권한 박탈, 사용자 계정 삭제)
        
        
CREATE USER joeun IDENTIFIED BY tiger;

-- 권한 부여(세션 권하느 scott.emp, scott.dept 에 대한 모든권한을 주기)

GRANT CREATE SESSION TO JOEUN;

GRANT ALL ON EMP TO JOEUN;  -- 내 계정의 EMP 테이블에 대한 모든 권한 부여

GRANT SELECT ON DEPT TO JOEUN;;     -- 내 계정의 DEPT 테이블에 대한 SELECT 권한 부여





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
    VALUES (1005, 'YI', 'MANAGER', 80); -- 외래키 오류



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
    
INSERT INTO MAJOR VALUES(1,'경영정보','3층 인문실');
INSERT INTO MAJOR VALUES(2,'소프트웨어공학','3층 인문실');
INSERT INTO MAJOR VALUES(3,'디자인','4층 과학실');
INSERT INTO MAJOR VALUES(4,'경제','4층 과학실');
INSERT INTO MAJOR VALUES((SELECT MAX(MAJOR_CODE) FROM MAJOR)+1, '빅데이터', '정보관 606호');

SELECT *
    FROM MAJOR;
    
INSERT INTO STUDENT VALUES('A01','김길동',100,1);
INSERT INTO STUDENT VALUES('A02','문길동',90,2);
INSERT INTO STUDENT VALUES('A03','홍길동',95,1);
INSERT INTO STUDENT VALUES('A04','홍사동',96,4);


SELECT *
    FROM STUDENT;
    
    

    
SELECT M.*, STUDENT_CODE, STUDENT_NAME, SCORE
    FROM MAJOR M, STUDENT S
    WHERE M.MAJOR_CODE = S.MAJOR_CODE;
    
    
 
 
   