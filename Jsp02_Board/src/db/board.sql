CREATE SEQUENCE SEQ_BOARD NOCACHE;

CREATE TABLE BOARD(
	SEQ NUMBER PRIMARY KEY,
	WRITER VARCHAR2(500) NOT NULL,
	TITLE VARCHAR2(2000) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	REGDATE DATE NOT NULL
);

INSERT INTO BOARD VALUES(SEQ_BOARD.NEXTVAL,'관리자','테스트중','TEST1234',SYSDATE);

SELECT * FROM BOARD;