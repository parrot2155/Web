package com.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dto.MyBoard;
import static common.JDBCTemplate.*;

public class MyBoardDao {
	
	//전체 출력
	public List<MyBoard> selectAll(){
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<MyBoard> res = new ArrayList<>();
		String sql = "SELECT * FROM MYBOARD ORDER BY MYNO";
		
		try {
			stmt = con.createStatement();
			System.out.println("3. query 준비: "+sql);
			
			rs = stmt.executeQuery(sql);
			System.out.println("4. query 실행 및 리턴");
			
			while(rs.next()) {
				MyBoard dto = new MyBoard(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				res.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("3,4 단계 에러");
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
			close(con);
			System.out.println("5. db 종료");
		}
		return res;
	}
	
	
	//글작성
	public int insert(MyBoard dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = "INSERT INTO MYBOARD VALUES(SEQ_MYBOARD.NEXTVAL, ?, ?, ?, SYSDATE)";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1,dto.getMyname());
			pstm.setString(2,dto.getMytitle());
			pstm.setString(3,dto.getMycontent());
			System.out.println("3. query 준비: "+sql);
			
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
			
			
			
			
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		return res;
	}

	//상세페이지
	public MyBoard selectOne(int myno) {
		String sql = "SELECT * FROM MYBOARD WHERE MYNO=?";
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyBoard res = null;
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1,myno);
			
			rs = pstm.executeQuery();
			if(rs.next()) {
				res = new MyBoard();
				res.setMyno(rs.getInt(1));
				res.setMyname(rs.getString(2));
				res.setMytitle(rs.getString(3));
				res.setMycontent(rs.getString(4));
				res.setMydate(rs.getDate(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("db 종료");
		}
		return res;
	}



}






















