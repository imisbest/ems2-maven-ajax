package com.csw.service;

import java.util.List;

import com.csw.entity.Dept;

public interface DeptService {
	List<Dept> queryAll();

	Dept queryBy(Integer deptid);
}
