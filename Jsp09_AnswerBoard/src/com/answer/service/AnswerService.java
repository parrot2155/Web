package com.answer.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.answer.dao.AnswerDao;
import com.answer.dto.AnswerDto;

public class AnswerService {
	
	AnswerDao dao = new AnswerDao();
	
	public List<AnswerDto> selectAll() {
		Connection con = getConnection();
		
		List<AnswerDto> res = dao.selectAll(con);
		
		close(con);
		System.out.println("05. db 종료\n");
		
		return res;
		
	}
	
	public int insert(AnswerDto dto) {
		Connection con = getConnection();
		
		int res = dao.insert(con, dto);
		
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		System.out.println("05. db 종료\n");
		return res;
		
	}
	
	public AnswerDto selectOne(int boardno) {
		Connection con = getConnection();
		
		AnswerDto dto = dao.selectOne(con, boardno);
		
		close(con);
		System.out.println("05. db 종료\n");
		return dto;
	}
	
	public int update(AnswerDto dto) {
		Connection con = getConnection();
		int res = dao.update(con, dto);
		
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		System.out.println("05. db 종료");
		
		return res;
	}
	
	public boolean answerinsert(int parentboardno, AnswerDto dto) {
		Connection con = getConnection();
		
		
		AnswerDto parent = dao.selectOne(con, parentboardno);
		int parentgroupno = parent.getGroupno();
		int parentgroupsq = parent.getGroupsq();
		int parenttitletab = parent.getTitletab(); 
		
		
		
		//update (밑에 애들 한칸식 밑으로 밀어줘야함)
		
		//업데이트 전 업데이트될 글이 몇개인지 확인해보자. 나중에 몇개 변경되었는지 확인할 용도.
		int cnt = dao.countUpdate(con, parentgroupno, parentgroupsq);
		
		int uRes = dao.updateAnswer(con, parentgroupno, parentgroupsq); //밑에 변경돨 답글이 몇개인가? res 0~
		
		//insert
		dto.setGroupno(parentgroupno);
		dto.setGroupsq(parentgroupsq);
		dto.setTitletab(parenttitletab);
		
		int iRes = dao.insertAnswer(con, dto);
		
		if(uRes==cnt  && iRes==1) {	//변경할 개수와 변경한 개수가 일치
			System.out.println("결과1: "+(uRes));
			System.out.println("결과2: "+(iRes));
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		System.out.println("05. db 종료");
		
		return (uRes==cnt  && iRes==1);
		
	}
	
	
	
	
}











