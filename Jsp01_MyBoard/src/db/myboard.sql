DROP TABLE MYBOARD;
DROP SEQUENCE SEQ_MYBOARD;


CREATE SEQUENCE SEQ_MYBOARD NOCACHE;
CREATE TABLE MYBOARD(
	MYNO NUMBER PRIMARY KEY,
	MYNAME VARCHAR2(20) NOT NULL,
	MYTITLE VARCHAR2(1000) NOT NULL,
	MYCONTENT VARCHAR2(4000) NOT NULL,
	MYDATE DATE NOT NULL
);

INSERT INTO MYBOARD VALUES(SEQ_MYBOARD.NEXTVAL, '관리자','게시판 테스트','테스트 중입니다.123456789ABCD',SYSDATE);

SELECT * FROM MYBOARD;