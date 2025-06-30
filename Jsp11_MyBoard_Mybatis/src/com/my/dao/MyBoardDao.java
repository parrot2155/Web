package com.my.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.my.dto.MyBoardDto;

public class MyBoardDao extends SqlMapConfig{
	public List<MyBoardDto> selectAll () {
		//준비
		List<MyBoardDto> res = new ArrayList<>();
		SqlSession session = null;
													//true => autoCommit하겠다
		session = getSqlSessionFactory().openSession(true);
		res = session.selectList("com.my.myboard.selectAll");
		
		session.close();
		
		return res;
		
	}
}
