<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
<title>emplist</title>

<link rel="stylesheet" type="text/css" href="${path }/css/style.css" />
<script type="text/javascript">
</script>
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader">
					<p>
						<a href="${pageContext.request.contextPath }/user/user_safeOut"><input
							type="button" value="安全退出" onsubmit=" return onsafe()"></a>
					</p>
					<p>
						<%@ page import="java.util.*"%> <%@ page import="java.text.*"%><%    String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); /*//获取系统时间*/%><%=datetime%> <br/> <br/> <br />
					</p>
				</div>
				<div id="topheader">
					<h1 id="title">
						<a href="#">main</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>Welcome!</h1>
				<table class="table">
					<tr class="table_header">
						<td>ID</td>
						<td>Name</td>
						<td>Salary</td>
						<td>Age</td>
						<td>deptname</td>
						<td>Operation</td>
					</tr>
					<c:forEach items="${list }" var="p">
						<!-- private Integer id;
	private String name;
	private Double salary;
	private Integer age; -->
						<tr class="row1">
							<td>${p.id }</td>
							<td>${p.name }</td>
							<td>${p.salary }</td>
							<td>${p.age }</td>
							<td>${p.dept.deptname }</td>
							<td><a href="${path }/emp/emp_DeleteAction?id=${p.id}">删除</a>&nbsp;&nbsp;<a
								href="${path }/emp/emp_UpdateQueryByIdAction?id=${p.id}">修改</a></td>
						</tr>
					</c:forEach>

				</table>
				<%
					Integer currPage = (Integer) request.getAttribute("currPage");
					Integer countPage = (Integer) session.getAttribute("countPage");
					System.out.print("{main countPage}" + countPage);
					System.out.print("{main currPage}" + currPage);
				%>
				<c:if test="${countPage==1 }">
					<center>
						<c:forEach begin="1" end="${countPage}" var="i">
							<a href="${path }/emp/emp_CurrentPageAction?currPage=${i }">${i }</a> &nbsp;&nbsp;
				</c:forEach>
				</c:if>
				<c:if test="${countPage>1 }">




					<center>
						<c:if test="${currPage>1&&currPage<countPage}">
							<a href="${path }/emp/emp_FirstPageAction">首页</a>&nbsp;&nbsp;
				<a href="${path }/emp/emp_PreviousPageAction?currPage=${ currPage - 1}">上一页</a>&nbsp;&nbsp;
					<c:forEach begin="1" end="${countPage}" var="i">
								<a href="${path }/emp/emp_CurrentPageAction?currPage=${i }">${i }</a> &nbsp;&nbsp;
					</c:forEach>
							<a href="${path }/emp/emp_NextPageAction?currPage=${ currPage + 1}">下一页</a>&nbsp;&nbsp;
				<a href="${path }/emp/emp_LastPageAction">尾页</a>&nbsp;&nbsp;
			</c:if>

						<c:if test="${currPage==1 }">

							<c:forEach begin="1" end="${countPage}" var="i">
								<a href="${path }/emp/emp_CurrentPageAction?currPage=${i }">${i }</a> &nbsp;&nbsp;
				</c:forEach>
							<a href="${path }/emp/emp_NextPageAction?currPage=${currPage + 1}">下一页</a>&nbsp;&nbsp;
				<a href="${path }/emp/emp_LastPageAction?currPage=${countPage}">尾页</a>&nbsp;&nbsp;
			</c:if>


						<c:if test="${currPage==countPage }">
							<a href="${path }/emp/emp_FirstPageAction">首页</a>&nbsp;&nbsp;
				<a href="${path }/emp/emp_PreviousPageAction?currPage=${currPage - 1}">上一页</a>&nbsp;&nbsp;
				<c:forEach begin="1" end="${countPage}" var="i">
								<a href="${path }/emp/emp_CurrentPageAction?currPage=${i }">${i }</a> &nbsp;&nbsp;
				</c:forEach>
						</c:if>
				</c:if>
				<p>

					<a href="${path}/addEmp.jsp"><input type="button"
						class="button" value="添加员工" /></a>
				</p>

			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">ABC@126.com</div>
		</div>
	</div>
</body>
</html>
