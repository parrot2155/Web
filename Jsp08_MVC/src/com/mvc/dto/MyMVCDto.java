package com.mvc.dto;
/*DROP TABLE MYMVCBOARD;
DROP SEQUENCE SEQ_MYMVCBOARD;

CREATE SEQUENCE SEQ_MYMVCBOARD;

CREATE TABLE MYMVCBOARD(
SEQ NUMBER PRIMARY KEY,
WRITER VARCHAR2(200) NOT NULL,
TITLE VARCHAR2(2000) NOT NULL,
CONTENT VARCHAR2(4000) NOT NULL,
REGDATE DATE NOT NULL
);

INSERT INTO MYMVCBOARD VALUES(SEQ_MYMVCBOARD.NEXTVAL,'관리자','테스트','테스트 중입니다.123','22/02/22');

SELECT * FROM MYMVCBOARD;*/
import java.util.Date;

public class MyMVCDto {

	
	private int seq;
	private String writer;
	private String title;
	private String content;
	private Date regdate;
	
	public MyMVCDto() {}

	public MyMVCDto(int seq, String writer, String title, String content, Date regdate) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}

















