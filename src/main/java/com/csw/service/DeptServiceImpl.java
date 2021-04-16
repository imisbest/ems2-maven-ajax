package com.csw.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.csw.dao.DeptDao;
import com.csw.entity.Dept;
import com.csw.util.MybatisUtil;

public class DeptServiceImpl implements DeptService {

	public List<Dept> queryAll() {

		try {
			SqlSession sqlSession = MybatisUtil.openSession();
			DeptDao dao = sqlSession.getMapper(DeptDao.class);
			List<Dept> list=dao.queryAll();
			System.out.println("list***************"+list);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ����ʧ�ܣ�~PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPp");
		} finally {
			MybatisUtil.close();
		}
	}

	@Override
	public Dept queryBy(Integer deptid) {

		try {
			SqlSession sqlSession = MybatisUtil.openSession();
			DeptDao dao = sqlSession.getMapper(DeptDao.class);
			Dept dept=dao.queryBy(deptid);
			System.out.println("list***************"+dept);
			return dept;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ����ʧ�ܣ�~PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPp");
		} finally {
			MybatisUtil.close();
		}
	}

}
