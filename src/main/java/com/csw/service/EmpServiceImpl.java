package com.csw.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.csw.dao.EmpDao;
import com.csw.util.MybatisUtil;
import com.csw.entity.Emp;

public class EmpServiceImpl implements EmpService {

	@Override
	public List<Emp> findAll() {

		try {
			SqlSession sqlSession = MybatisUtil.openSession();
			EmpDao dao = sqlSession.getMapper(EmpDao.class);
			return dao.queryAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ����ʧ�ܣ�~PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPp");
		} finally {
			MybatisUtil.close();
		}
	}

	@Override
	public List<Emp> queryPersonByArray(int currPage, int pageSize,
			Integer countPage) {
		List<Emp> lists = new ArrayList<Emp>();
		List<Emp> list = new ArrayList<Emp>();
		try {
			SqlSession sqlSession = MybatisUtil.openSession();
			EmpDao dao = sqlSession.getMapper(EmpDao.class);
			lists = dao.queryPersonByArray();

			int firstIndex = (currPage - 1) * pageSize + 1;
			int lastIndex = currPage * pageSize;
			if (currPage != countPage) {
				for (int i = firstIndex; i <= lastIndex; i++) {
					list.add(lists.get(i - 1));
				}
			} else {
				for (int i = firstIndex; i <= lists.size(); i++) {
					list.add(lists.get(i - 1));
				}
			}
			System.out.println("{{service lists}=" + lists);
			System.out.println("{{service list}=" + list);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ����ʧ�ܣ�~PPPPPPPPPPPPPPPPPPPPPPPPPP");
		} finally {
			MybatisUtil.close();
		}
	}

	@Override
	public Integer countPageAction() {
		Integer pageInteger;
		try {
			SqlSession sqlSession = MybatisUtil.openSession();
			EmpDao dao = sqlSession.getMapper(EmpDao.class);
			Integer count = dao.countPage();
			System.out.println(" {{service count}=" + count);
			if (count % 2 == 0) {
				pageInteger = count / 2;
			} else {
				pageInteger = count / 2 + 1;
			}
			System.out.println(" {{service pageInteger}=" + pageInteger);
			return pageInteger;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯҳ��ʧ�ܣ�~PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
		} finally {
			MybatisUtil.close();
		}
	}

	@Override
	public Emp findByCardId(Integer cardId) {
		try {
			SqlSession sqlSession = MybatisUtil.openSession();
			EmpDao dao = sqlSession.getMapper(EmpDao.class);
			Emp emp = dao.findByCardId(cardId);
			return emp;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("����id��ѯʧ�ܣ�~PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP'p");
		} finally {
			MybatisUtil.close();
		}
	}

	@Override
	public void deleteAccount(Integer cardId) {
		try {
			SqlSession sqlSession = MybatisUtil.openSession();
			EmpDao dao = sqlSession.getMapper(EmpDao.class);
			dao.deleteAccount(cardId);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			e.printStackTrace();
			throw new RuntimeException("ɾ��ʧ�ܣ�~PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
		} finally {
			MybatisUtil.close();
		}
	}

	@Override
	public void updateBy(Emp emp) {
		try {
			SqlSession sqlSession = MybatisUtil.openSession();
			EmpDao dao = sqlSession.getMapper(EmpDao.class);
			dao.updateBy(emp);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			e.printStackTrace();
			throw new RuntimeException("����ʧ�ܣ�~PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP'p");
		} finally {
			MybatisUtil.close();
		}
	}

	@Override
	public void addEmp(Emp emp) {
		try {
			SqlSession sqlSession = MybatisUtil.openSession();
			EmpDao dao = sqlSession.getMapper(EmpDao.class);
			dao.addEmp(emp);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			e.printStackTrace();
			throw new RuntimeException("���ʧ�ܣ�~PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
		} finally {
			MybatisUtil.close();
		}
	}
}