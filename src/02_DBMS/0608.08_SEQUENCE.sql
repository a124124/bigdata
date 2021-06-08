    --[VIII] SEQUENCE ; ������ȣ ������ , ��κ� �������� PK ��� �뵵.
    
    
DROP SEQUENCE FRIEND_SEQ;

CREATE SEQUENCE FRIEND_SEQ
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 9999
    MINVALUE 1
    NOCACHE
    NOCYCLE;
    
    
DROP TABLE FRIEND;

CREATE TABLE FRIEND(
    NUM NUMBER(4) PRIMARY KEY,
    NAME VARCHAR2(30) NOT NULL,
    TEL VARCHAR(20) UNIQUE,
    ADDRESS VARCHAR2(100),
    LAST_MODIFYED DATE DEFAULT SYSDATE
);


INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) 
    VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ���', NULL, '�����');
    
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) 
    VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ���', '01048529484', '����� ������');

INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) 
    VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ����', '01085729487', '����� ������');    
    
SELECT *
    FROM FRIEND;
    
    
SELECT FRIEND_SEQ.CURRVAL
    FROM DUAL;
    
    
COMMIT;
--
--CREATE SEQUENCE FRIEND_SEQ
--    START WITH 1
--    INCREMENT BY 1
--    MAXVALUE 9999
--    MINVALUE 1
--    NOCACHE
--    NOCYCLE;

DROP SEQUENCE TEST_SEQ;
CREATE SEQUENCE TEST_SEQ
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;
    
    
SELECT TEST_SEQ.NEXTVAL
    FROM DUAL;
SELECT TEST_SEQ.CURRVAL 
    FROM DUAL;
    
--    [�䱸����]
--(1) ���� �̸��� ���̺��̳� �������� ���� �� ������ ���� �����ϰ� ���̺��� �����Ͻÿ�
--(2) CUSTOMER ���̺��� �ʵ� ���� ������ ���������� ���� �����Ͻÿ�.
--	�� CNO : �� Ű
--	�� CNAME : NULL���� �Է��� �� ����
--	�� JOINDATE : �Է����� ���� ��, �⺻������ ���糯¥�� �Էµȴ�.
--	�� PHONE : ��� �����ʹ� PHONE ���� ��� �ٸ��� �Էµȴ�.
--	�� LEVELNO : CUS_LEVEL ���̺��� LEVELNO �ʵ带 �����ϴ� �ܷ�Ű
--(3) CUS_LEVEL ���̺��� �ʵ� ���� ������ ���������� ��Ų��.
--	�� LEVELNO : ��Ű
--	�� LEVELNAME : NULL���� �Է��� �� ����	
--(4) CUSTOMER ���̺��� CNO��ȣ�� ������(CUS_SQ)�� ������ �� �ڵ����� ��ȣ�� �Էµǵ��� �Ѵ�

    
    
    -- (1) ���� �̸��� ���̺��̳� �������� ���� �� ������ ���� �����ϰ� ���̺��� �����Ͻÿ�
DROP SEQUENCE CUS_SQ;

CREATE SEQUENCE CUS_SQ
    MAXVALUE 999
    NOCACHE
    NOCYCLE;

    --(3) CUS_LEVEL ���̺��� �ʵ� ���� ������ ���������� ��Ų��.
    --	�� LEVELNO : ��Ű
    --	�� LEVELNAME : NULL���� �Է��� �� ����	
        
CREATE TABLE CUS_LEVEL(
    LEVELNO NUMBER(2) PRIMARY KEY,
    LEVELNAME VARCHAR2(10) NOT NULL
);

SELECT *
    FROM CUS_LEVEL;
    
   --(2) CUSTOMER ���̺��� �ʵ� ���� ������ ���������� ���� �����Ͻÿ�.
--	�� CNO : �� Ű
--	�� CNAME : NULL���� �Է��� �� ����
--	�� JOINDATE : �Է����� ���� ��, �⺻������ ���糯¥�� �Էµȴ�.
--	�� PHONE : ��� �����ʹ� PHONE ���� ��� �ٸ��� �Էµȴ�.
--	�� LEVELNO : CUS_LEVEL ���̺��� LEVELNO �ʵ带 �����ϴ� �ܷ�Ű

DROP TABLE CUSTOMER;

CREATE TABLE CUSTOMER(
    CNO NUMBER(4) PRIMARY KEY,
    CNAME VARCHAR2(30) NOT NULL,
    JOINDATE DATE DEFAULT SYSDATE,
    PHONE VARCHAR2(20) UNIQUE,
    POINT NUMBER(6),
    LEVELNO NUMBER(2),
    FOREIGN KEY(LEVELNO) REFERENCES CUS_LEVEL(LEVELNO)
);
    
SELECT *
    FROM CUSTOMER;
    
    
    --(4) CUSTOMER ���̺��� CNO��ȣ�� ������(CUS_SQ)�� ������ �� �ڵ����� ��ȣ�� �Էµǵ��� �Ѵ�
    
INSERT INTO CUS_LEVEL VALUES(1, 'VVIP');
INSERT INTO CUS_LEVEL VALUES(2, 'VIP');
INSERT INTO CUS_LEVEL VALUES(3, 'NORMAL');
INSERT INTO CUS_LEVEL VALUES(4, 'BLACK');

SELECT *
    FROM CUS_LEVEL;
    
    
INSERT INTO CUSTOMER (CNO, CNAME, JOINDATE, PHONE, POINT, LEVELNO)
    VALUES (CUS_SQ.NEXTVAL, 'ȫ�浿', '21/06/10', '010-9999-9999', 0, 1);
INSERT INTO CUSTOMER (CNO, CNAME, JOINDATE, PHONE, POINT, LEVELNO)
    VALUES (CUS_SQ.NEXTVAL, '��ö��', '21/11/12', '010-8888-8888', NULL, 2);
  

UPDATE CUSTOMER
    SET POINT = 300
    WHERE CNAME = 'ȫ�浿';
    
SELECT CNO, CNAME, JOINDATE, PHONE, POINT, LEVELNAME
    FROM CUS_LEVEL L, CUSTOMER C
    WHERE L.LEVELNO = C.LEVELNO;
    
    
SELECT *
    FROM CUSTOMER;
    
COMMIT;