package com.csw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import com.csw.entity.User2;
import com.csw.service.User2Service;
import com.csw.service.User2ServiceImpl;

import java.io.PrintWriter;

public class User2Action  extends ActionSupport{
	private String username;
	private String password;
	private String truename;
	private String sex;
	private String captchaCode;

	public String getCaptchaCode() {
		return captchaCode;
	}

	public void setCaptchaCode(String captchaCode) {
		this.captchaCode = captchaCode;
	}

	private User2 user2;
	public String safeOut() {
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out
				.println("welcome to SafeOut$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
		// response.sendRedirect(request.getContextPath() + "/LoginView.jsp");
	}
	public String LoginAction() {
		System.out
				.println(" LoginAction()@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		User2Service userService = new User2ServiceImpl();
		User2 user2 = userService.login(username, password);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String secrutiyCodeString = (String) session
				.getAttribute("securityCode");
		if (user2 != null && secrutiyCodeString.equals(captchaCode)) {
			session.setAttribute("user2", user2);
			System.out
					.println(" LoginSuccess()@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			return "FirstPageAction";
		} else {
			return "login";
		}
	}

	public String RegistAction() throws  Exception{
		System.out.println("RegistAction()@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		///////////////////////////////////////////////////////
		User2 user2 = new User2(username, password, truename, sex);
		User2Service user2Service = new User2ServiceImpl();

		HttpServletRequest request = ServletActionContext.getRequest();

		HttpSession session = request.getSession();
		String secrutiyCodeString = (String) session
				.getAttribute("securityCode");
		System.out.println("username:"+username);
		User2 uu=user2Service.queryBy(username);
		System.out.println("uu:"+uu);
		System.out.println("uu!=null:"+(uu!=null));
		if(uu!=null){
			out.print("username is regiseed1！！！");
			// 不做视图跳转
			return null;
		}else{
			out.print("username is ok！！！");
			if (secrutiyCodeString.equals(captchaCode)) {
				Boolean f = user2Service.addUser(user2);
				System.out.println("ActionF" + f);
				if (f) {
					return "login";
				}
			}

			return null;
		}

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public User2 getUser2() {
		return user2;
	}

	public void setUser2(User2 user2) {
		this.user2 = user2;
	}

}
