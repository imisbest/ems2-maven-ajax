package com.csw.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory factory;
	
	// ��̬��ʼ����飬��дֻ��Ҫִ��һ�εĲ����� ��̬������еĴ���ֻ������ص�ʱ��ִ��һ��
	static{
		InputStream in = null;
		try {
			// ��ȡ���������ļ� mybatis-config.xml
			in = Resources.getResourceAsStream("mybatis-config.xml");
			// ����SqlSessionFactory
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��ʼ������ʧ�ܣ�~");
		} finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	// ����һ���̰߳󶨶���
	private static ThreadLocal<SqlSession> tol = new ThreadLocal<SqlSession>();
	// ����һ��SqlSession
	public static SqlSession openSession() {
		// �ȵ���ǰ�߳�ȡһ��
		SqlSession sqlSession = tol.get();
		if(sqlSession==null){
			// ����SqlSession 
			sqlSession = factory.openSession();
			// �󶨵���ǰ�߳�
			tol.set(sqlSession); 
		}
		return sqlSession;
	}
	// �ͷ���Դ 
	public static void close() {
		SqlSession sqlSession = tol.get();
		if(sqlSession!=null) {
			sqlSession.close();
			tol.remove();// �ӵ�ǰ�߳��Ƴ� 
		}
	}
	// �ύ����
	public static void commit(){
		SqlSession sqlSession = tol.get();
		if(sqlSession!=null) {
			sqlSession.commit();
		}
	}
	// �ع�����
	public static void rollback(){
		SqlSession sqlSession = tol.get();
		if(sqlSession!=null) {
			sqlSession.rollback();
		}
	}
}
