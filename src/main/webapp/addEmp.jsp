<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
<title>add Emp</title>

<link rel="stylesheet" type="text/css" href="${path }/css/style.css" />
<script type="text/javascript">
	function unFout() {
		var val = document.getElementById("username").value;
		var sp = document.getElementById("sp1");
		if (val == '') {
			sp.innerText = '员工姓名为空';
		} else {
			sp.innerText = '姓名ok';
		}
	}
	function saFout() {
		var val = document.getElementById("salary").value;
		var sp = document.getElementById("sp2");
		if (val == '') {
			sp.innerText = '薪水为空';
		} else if (val<2000||val>1000000) {
			sp.innerText = '你输入的薪水不符合要求';
		} else {
			sp.innerText = '薪水ok';
		}
	}
	function agFout() {
		var val = document.getElementById("age").value;
		var sp = document.getElementById("sp3");
		if (val == '') {
			sp.innerText = '年龄为空';
		} else if (val<18||val>60) {
			sp.innerText = '你输入的年龄不符合';
		} else {
			sp.innerText = '年龄ok';
		}
	}
	function subFout() {
		var nn = document.getElementsByClassName('inputgri');
		for (var i = 0; i < nn.length; i++) {
			if (!nn[i].value) {
				alert("请检查之后在重新提交");
				return false;
			}
		}
		var b = window.confirm("请确认提交是否提交表单");
		if (b) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>

<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader">
					<p>
						<%@ page import="java.util.*"%> <%@ page import="java.text.*"%><%    String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); /*//获取系统时间*/%><%=datetime%> <br/> <br/> <br />
					</p>
				</div>
				<div id="topheader">
					<h1 id="title">
						<a href="#">Main</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>add Emp info:</h1>
				<form action="${path }/emp/emp_AddEmpAction" method="post" onsubmit="return subFout()">
					<table cellpadding="0" cellspacing="0" border="0"
						class="form_table">
						<tr>
							<td valign="middle" align="right">name:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="name" placeholder="请输入员工姓名" id="username" value='' onblur="unFout()">
								<span
								id="sp1"  style="color:red;"></span>
								</td>
						</tr>
						<tr>
							<td valign="middle" align="right">salary:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="salary" placeholder="请输入该员工薪水" id="salary" value="" onblur="saFout()">
								<span
								id="sp2"  style="color:red;"></span>
								</td>
						</tr>
						<tr>
							<td valign="middle" align="right">age:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="age" placeholder="请输入该员工年龄" id="age" value="" onblur="agFout()">
								<span
								id="sp3"  style="color:red;"></span>
								</td>
						</tr>
						<tr>
							<td valign="middle" align="right">department:</td>
							<td valign="middle" align="left"><select name="deptss">
									<c:forEach items="${listdept }" var="m">
										<option value="${m.deptid}">${m.deptname}</option>
									</c:forEach>
							</select></td>
						</tr>
					</table>
					<p>
						<input type="submit" class="button" value="Confirm" />
					</p>
				</form>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">ABC@126.com</div>
		</div>
	</div>
</body>
</html>
