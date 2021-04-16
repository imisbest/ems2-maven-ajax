package com.csw.dao;

import java.util.List;

import com.csw.entity.Emp;

public interface EmpDao {

	List<Emp> queryAll();

	List<Emp> queryPersonByArray();

	Integer countPage();

	Emp findByCardId(Integer cardId);

	void deleteAccount(Integer cardId);

	void updateBy(Emp emp);

	Integer addEmp(Emp emp);


}
