package com.my.dao;

import java.util.ArrayList;

import java.util.List;

import javax.el.ELException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.my.dto.MyBoardDto;

public class MyBoardDao extends SqlMapConfig{
	private String namespace = "com.my.myboard";
	public List<MyBoardDto> selectAll() {
	    List<MyBoardDto> res = new ArrayList<>();
	    SqlSession session = null;
	    try {
	        session = getSqlSessionFactory().openSession(true);
	        res = session.selectList(namespace + ".selectAll");
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) session.close();
	    }
	    return res;
	}
	public MyBoardDto selectOne(int myno) {
	    SqlSession session = null;
	    MyBoardDto res = null;

	    try {
	        session = getSqlSessionFactory().openSession(true);
	        res = session.selectOne(namespace + ".selectOne", myno);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) session.close();
	    }

	    return res;
	}
	
	public int insert(MyBoardDto dto) {
	    SqlSession session = null;
	    int res = 0;
	    
	    try {
	        session = getSqlSessionFactory().openSession(true);
	        res = session.insert(namespace + ".myinsert", dto);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) session.close();
	    }
	    
	    return res;
	}
	
	public int update(MyBoardDto dto) {
	    SqlSession session = null;
	    int res = 0;

	    try {
	        session = getSqlSessionFactory().openSession(true);
	        res = session.update(namespace + ".myupdate", dto);
	    } catch (Exception e) {    // ELException 대신 일반 Exception 사용 권장
	        e.printStackTrace();
	    } finally {
	        if (session != null) session.close();  // Null 체크 꼭 하기
	    }
	    return res;
	}
	
	public int delete(int myno) {
	    SqlSession session = null;
	    int res = 0;
	    
	    try {
	        session = getSqlSessionFactory().openSession(true);
	        res = session.delete(namespace + ".mydelete", myno);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) session.close();
	    }
	    
	    return res; // 삭제 성공한 행 수를 반환하는 게 일반적입니다.
	}
	
}















