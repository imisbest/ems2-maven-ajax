package com.csw.service;

import org.apache.ibatis.session.SqlSession;

import com.csw.dao.User2Dao;
import com.csw.entity.User2;
import com.csw.util.MybatisUtil;

public class User2ServiceImpl implements User2Service {

	@Override
	public User2 login(String username, String password) {
		try {
			SqlSession sqlSession = MybatisUtil.openSession();
			User2Dao dao = sqlSession.getMapper(User2Dao.class);
			User2 user = dao.queryByUsernameAndPassword(username, password);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ����ʧ�ܣ�~");
		} finally {
			MybatisUtil.close();
		}
	}

	@Override
	public Boolean addUser(User2 user2) {
		try {
			SqlSession sqlSession = MybatisUtil.openSession();
			User2Dao dao = sqlSession.getMapper(User2Dao.class);
			Integer i = dao.addUser(user2);
			if(i>0){
				MybatisUtil.commit();
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			MybatisUtil.rollback();
			e.printStackTrace();
			throw new RuntimeException("��ѯ����ʧ�ܣ�~");
		} finally {
			MybatisUtil.close();
		}
	}
	public User2 queryBy(String username){
		try {
			SqlSession sqlSession = MybatisUtil.openSession();
			User2Dao dao = sqlSession.getMapper(User2Dao.class);
			User2 uu = dao.queryBy(username);
			return uu;
		} catch (Exception e) {
			MybatisUtil.rollback();
			e.printStackTrace();
			throw new RuntimeException("��ѯ����ʧ�ܣ�~");
		} finally {
			MybatisUtil.close();
		}
	}
}
