package com.csw.service;

import java.util.List;

import com.csw.entity.Emp;

public interface EmpService {

	List<Emp> findAll();

	List<Emp> queryPersonByArray(int currPage, int pageSize, Integer countPage);

	Integer countPageAction();

	Emp findByCardId(Integer cardId);

	void deleteAccount(Integer cardId);

	void updateBy(Emp emp);

	void addEmp(Emp emp);

}
