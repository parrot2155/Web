package com.my.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		
		//config파일의 경로
		String resource = "com/my/db/Config.xml";
		
		try {
			//config.xml의 파일 정보를 읽어온다.
			Reader reader = Resources.getResourceAsReader(resource);
			
			//읽어온 정보를 가지고 sqlSessionFactory객체 생성
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
}
