package com.csw.dao;

import java.util.List;

import com.csw.entity.Dept;

public interface DeptDao {
	List<Dept> queryAll();

	Dept queryBy(Integer deptid);
}
