package com.cboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


import com.cboard.dto.CBoardDto;

public class CBoardDao extends SqlMapConfig{
	
	public List<CBoardDto> selectAll(){
		SqlSession session = null;
		List<CBoardDto> res = null;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectList("com.cboard.selectAll");
		
		session.close();
		
		return res;
		
	}
	public int insert(CBoardDto dto) {
		int res = 0;
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession(true);
	    res = session.insert("com.cboard.insert", dto);
	    session.close();
	    return res;

	}
	public CBoardDto selectOne(int no) {
		SqlSession session = null;
		CBoardDto res = null;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectOne("com.cboard.selectOne", no);
		session.close();
		
		return res;
		
	}
	public int update(CBoardDto dto) {
		int res = 0;
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.update("com.cboard.update", dto);
		
		
		session.close();
		return res;
	}
	
	public int delete(int no) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.delete("com.cboard.delete", no);
		session.close();
		
		return res;
	}
	
	
	
}


















