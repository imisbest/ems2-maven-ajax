package com.csw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.csw.entity.*;
import com.csw.service.*;

public class EmpAction {
	private Integer id;
	private String name;
	private Double salary;
	private Integer age;
	private Emp emp;
	private Dept dept;

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String AddEmpAction() {
		System.out
				.println("AddEmpAction()@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Integer deptid=Integer.parseInt(request.getParameter("deptss"));
		System.out.println("deptid(((((((((((((((((("+deptid);
		DeptService ddDept=new DeptServiceImpl();
		Dept ssDept=ddDept.queryBy(deptid);
		
		Emp emp = new Emp(id, name, salary, age, ssDept);
		
		EmpService es = new EmpServiceImpl();

		if (name == null || salary == null || age == null || name.length() <= 0) {
			return "addEmp";

		} else {

			es.addEmp(emp);
			return "FirstPageAction";
		}

	}

	public String CurrentPageAction() {
		System.out
				.println("CurrentPageAction()@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Integer countPage = (Integer) session.getAttribute("countPage");
		String currPageInteger = request.getParameter("currPage");
		Integer currPage = Integer.parseInt(currPageInteger);
		System.out.println("{{CurrentPageAction}=" + currPageInteger);
		System.out.println("{{CurrentPageAction}=" + currPage);

		EmpService ps = new EmpServiceImpl();
		List<Emp> list = ps.queryPersonByArray(currPage, 2, countPage);
		System.out.println(" {{CurrentPageAction list}=" + list);

		String judge = "judge";
		session.setAttribute("judge", judge);
		session.setAttribute("list", list);
		session.setAttribute("currPage", currPage);

		return "emplist";
	}

	public String DeleteAction() {
		System.out
				.println("DeleteAction()@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		EmpService as = new EmpServiceImpl();
		Emp acc = as.findByCardId(id);
		if (acc != null) {
			as.deleteAccount(id);
		}

		return "FirstPageAction";
	}

	public String FirstPageAction() {
		System.out
				.println("FirstPageAction()@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		HttpServletRequest request = ServletActionContext.getRequest();

		HttpSession session = request.getSession();
		DeptService dsDeptService = new DeptServiceImpl();
		List<Dept> listdept = dsDeptService.queryAll();
		System.out.println("listdeptLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL"+listdept);
		
		EmpService ps = new EmpServiceImpl();
		Integer countPage = ps.countPageAction();
		System.out.println("\\firstPage countPage//" + countPage);
		List<Emp> list = ps.queryPersonByArray(1, 2, countPage);
		System.out.println("\\firstPage//" + list);

		session.setAttribute("countPage", countPage);
		String judge = "judge";
		session.setAttribute("judge", judge);
		session.setAttribute("list", list);
		session.setAttribute("currPage", 1);
		session.setAttribute("listdept", listdept);
		return "emplist";
	}

	public String LastPageAction() {
		System.out
				.println("LastPageAction()@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Integer countPage = (Integer) session.getAttribute("countPage");
		System.out.println("\\firstPage countPage//" + countPage);

		EmpService ps = new EmpServiceImpl();
		List<Emp> list = ps.queryPersonByArray(countPage, 2, countPage);// /
		System.out.println(" CurrentPageAction list//" + list);
		String judge = "judge";
		session.setAttribute("judge", judge);
		session.setAttribute("list", list);
		session.setAttribute("currPage", countPage);

		return "emplist";
	}

	public String NextPageAction() {
		System.out
				.println("NextPageAction()@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Integer countPage = (Integer) session.getAttribute("countPage");
		String currPageInteger = request.getParameter("currPage");
		Integer currPage = Integer.parseInt(currPageInteger);
		System.out.println("\\next currPage//" + currPage);

		EmpService ps = new EmpServiceImpl();
		List<Emp> list = ps.queryPersonByArray(currPage, 2, countPage);

		System.out.println(" CurrentPageAction list//" + list);

		String judge = "judge";
		session.setAttribute("judge", judge);
		session.setAttribute("list", list);
		session.setAttribute("currPage", currPage);

		return "emplist";
	}

	public String PreviousPageAction() {
		System.out
				.println("PreviousPageAction()@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Integer countPage = (Integer) session.getAttribute("countPage");
		String currPageInteger = request.getParameter("currPage");
		Integer currPage = Integer.parseInt(currPageInteger);

		EmpService ps = new EmpServiceImpl();

		List<Emp> list = ps.queryPersonByArray(currPage, 2, countPage);
		System.out.println(" CurrentPageAction list//" + list);

		String judge = "judge";
		session.setAttribute("judge", judge);
		session.setAttribute("list", list);
		session.setAttribute("currPage", currPage);

		return "emplist";
	}

	public String UpdateAction() {
		System.out
				.println("UpdateAction()@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
	//	Integer deptid=Integer.parseInt(request.getParameter("deptss"));
		String depti=request.getParameter("deptss");
		Integer deptid=Integer.parseInt(depti);
		System.out.println("deptid(((((((((((((((((("+deptid);
		DeptService ddDept=new DeptServiceImpl();
		Dept ssDept=ddDept.queryBy(deptid);
		
		Emp emp = new Emp(id, name, salary, age, ssDept);
		System.out.println(emp+"EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEe");
		EmpService es = new EmpServiceImpl();
		es.updateBy(emp);
		return "FirstPageAction";
	}

	public String UpdateQueryByIdAction() {
		System.out
				.println("UpdateQueryByIdAction()@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		EmpService es = new EmpServiceImpl();
		Emp ems = es.findByCardId(id);
		session.setAttribute("ems", ems);
		return "update";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}
