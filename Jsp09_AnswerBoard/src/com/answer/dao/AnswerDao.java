package com.answer.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.answer.dto.AnswerDto;


public class AnswerDao {
	
	public List<AnswerDto> selectAll(Connection con){
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<AnswerDto> res = new ArrayList<>();
		String sql = " SELECT * FROM ANSWERBOARD ORDER BY GROUPNO DESC, GROUPSQ ";
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("03. query 준비 : "+sql);
			rs = pstm.executeQuery();
			System.out.println("04. query 실행 및 리턴");
			
			while(rs.next()) {
				AnswerDto dto = new AnswerDto();
				dto.setBoardno(rs.getInt(1));
				dto.setGroupno(rs.getInt(2));
				dto.setGroupsq(rs.getInt(3));
				dto.setTitletab(rs.getInt(4));
				dto.setTitle(rs.getString(5));
				dto.setContent(rs.getString(6));
				dto.setWriter(rs.getString(7));
				dto.setRegdate(rs.getDate(8));
				
				res.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("3/4단계 에러");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
		}
		return res;
		
	}
	
	public int insert(Connection con, AnswerDto dto) {
		PreparedStatement pstm = null;
		String sql = " INSERT INTO ANSWERBOARD VALUES(BOARDNOSQ.NEXTVAL, GROUPNOSQ.NEXTVAL, 1, 0, ?, ?, ?, SYSDATE)  ";
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setString(3, dto.getWriter());
			System.out.println("03. query 준비: "+sql);
			
			res = pstm.executeUpdate();
			System.out.println("04. query 실행 및 리턴");
		} catch (SQLException e) {
			System.out.println("3/4단계 에러");
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return res;
	}
	
	public AnswerDto selectOne(Connection con, int boardno) {
		PreparedStatement pstm = null;
		String sql = " SELECT * FROM ANSWERBOARD WHERE BOARDNO=? ";
		ResultSet rs = null;
		AnswerDto res = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, boardno);
			System.out.println("03. query 준비: "+sql);
			
			rs = pstm.executeQuery();
			System.out.println("04. query 실행 및 리턴");
			
			while(rs.next()) {
				res = new AnswerDto(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8));
			}
			

		} catch (SQLException e) {
			System.out.println("3/4단계 에러");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
		}
		return res; 
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}


















