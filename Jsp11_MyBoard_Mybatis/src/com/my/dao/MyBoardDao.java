package com.my.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.my.dto.MyBoardDto;

public class MyBoardDao extends SqlMapConfig{
	private String namespace = "com.my.myboard";
	public List<MyBoardDto> selectAll () {
		//준비
		List<MyBoardDto> res = new ArrayList<>();
		SqlSession session = null;
													//true => autoCommit하겠다
		session = getSqlSessionFactory().openSession(true);
		res = session.selectList(namespace+".selectAll");
		
		session.close();
		
		return res;
		
	}
	public MyBoardDto selectOne(int myno) {
		SqlSession session = null;
	    MyBoardDto res = null;

	    try {
	        session = getSqlSessionFactory().openSession(true);
	        res = session.selectOne(namespace+".selectOne", myno);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }

	    return res;
	}
	
	public int insert(MyBoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.insert(namespace+".myinsert",dto);
		
		session.close();
		
		return res;
		
	}
	
}















