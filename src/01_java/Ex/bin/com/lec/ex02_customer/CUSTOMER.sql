DROP TABLE CUSTOMER;

CREATE TABLE CUSTOMER (
    ID NUMBER(8) PRIMARY KEY,
    PHONE VARCHAR2(15) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    POINT NUMBER(8) DEFAULT 1000
);

DROP SEQUENCE CUSTOMER_ID_SQ;
CREATE SEQUENCE CUSTOMER_ID_SQ
    MAXVALUE 99999999
    NOCACHE
    NOCYCLE;
    
-- 입력

INSERT INTO CUSTOMER VALUES(CUSTOMER_ID_SQ.NEXTVAL, '01044445353','홍길동',1000);
INSERT INTO CUSTOMER VALUES(CUSTOMER_ID_SQ.NEXTVAL, '01034594343','일길동',1000);
INSERT INTO CUSTOMER VALUES(CUSTOMER_ID_SQ.NEXTVAL, '01012921034','김길동',4000);

-- 폰번호 조회

SELECT *
    FROM CUSTOMER WHERE PHONE LIKE '%9999';

SELECT *
    FROM CUSTOMER WHERE PHONE LIKE '%' || '9999'; -- 자바에서 쓸 쿼리
    
    
-- 출력

SELECT *
    FROM CUSTOMER
    ORDER BY ID;
    
