DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    ID VARCHAR2(20) PRIMARY KEY,
    PW VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(20) NOT NULL,
    BIRTH DATE,
    GENDER VARCHAR2(1),
    EMAIL VARCHAR2(50),
    TEL VARCHAR2(30),
    ADDRESS VARCHAR2(100)
);
INSERT INTO MEMBER(ID, PW, NAME, BIRTH, GENDER)
    VALUES ('AAA','AAA','??????','1995-01-02','F');

INSERT INTO MEMBER(ID, PW, NAME, BIRTH, GENDER)
    VALUES ('BBB','BBB','??????','2002-01-02','M');
    
INSERT INTO MEMBER(ID, PW, NAME, BIRTH, GENDER)
    VALUES ('CCC','CCC','??????','1987-11-22','F');
    

COMMIT;
SELECT *
    FROM MEMBER;
    
    
-- id ?ߺ? üũ

SELECT *
    FROM MEMBER
    WHERE ID='aaa';