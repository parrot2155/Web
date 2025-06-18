package com.my.dao;

import java.sql.Connection;
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
		String sql = "SELECT * FROM MYBOARD";
		
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
}






















