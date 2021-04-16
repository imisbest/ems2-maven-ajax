package com.csw.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestSqlSession {
	public static void main(String[] args) throws Exception {
		//1.��ȡ���������ļ� mybatis-config.xml
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		//2.����SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.����SqlSession
		SqlSession sqlSession = factory.openSession();
		System.out.println(sqlSession);
	}
}
