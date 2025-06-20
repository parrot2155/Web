package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mvc.dto.MVCBoardDto;
import static common.JDBCTemplate.*;

public class MVCBoardDao {
	public List<MVCBoardDto> selectAll(){
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<MVCBoardDto> res = new ArrayList<>();
		
		String sql = " SELECT * FROM MVCBOARD ORDER BY SEQ DESC ";
		
		try {
			stmt = con.createStatement();
			System.out.println("03. query 준비: "+sql);
			rs = stmt.executeQuery(sql);
			System.out.println("04. query 실행 및 리턴");
			while(rs.next()) {
				MVCBoardDto tmp = new MVCBoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				
				res.add(tmp);
			}
		} catch (SQLException e) {
			System.out.println("3,4 단계 에러");
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
			close(con);
			System.out.println("05. db 종료\n");
		}
		return res;
	}
	
	public MVCBoardDto selectOne(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MVCBoardDto res = new MVCBoardDto();
		
		String sql = " SELECT * FROM MVCBOARD WHERE SEQ=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1,seq);
			System.out.println("03.query 준비: "+sql);
			rs = pstm.executeQuery();
			System.out.println("04. query 실행 및 리턴");
			
			if(rs.next()) {
				res.setSeq(rs.getInt(1));
				res.setWriter(rs.getString(2));
				res.setTitle(rs.getString(3));
				res.setContent(rs.getString(4));
				res.setRegdate(rs.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("05. db 종료");
		}
		return res;
	}
	
	public int insert(MVCBoardDto dto) {
		return 0;
	}
	
	public int update(MVCBoardDto dto) {
		return 0;
	}
	
	public int delete(int seq) {
		return 0;
	}
	
}
