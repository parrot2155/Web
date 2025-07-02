package com.cmember.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.cmember.dto.CMemberDto;

public class CMemberDao extends SqlMapConfig{
	
	
	public int signup(CMemberDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.insert("com.cmember.signup",dto);
		
		session.close();
		
		return res;
		
	}
	public CMemberDto login(String id,String pw) {
		SqlSession session = null;
	    CMemberDto res = null;
	    CMemberDto dto = new CMemberDto();
	    dto.setId(id);
	    dto.setPw(pw);
	    try {
	        session = getSqlSessionFactory().openSession(true);
	        res = session.selectOne("com.cmember.selectOne",dto );
	        //System.out.println("dao에서 이름:" + res.getName());

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return res;
	}
	public int deleteUser(String id) {
		int res = 0;
		
	    SqlSession session = getSqlSessionFactory().openSession(true);
	    res = session.update("com.cmember.deleteUser", id);
	    session.close();
	    return res;
	}
}















