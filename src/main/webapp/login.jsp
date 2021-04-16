<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>login</title>

    <link rel="stylesheet" type="text/css" href="${path }/css/style.css"/>
    <script type="text/javascript">
        function changeCaptcha() {
            // 根据ID获取到验证码图片对象
            var captchaImg = document.getElementById('captchaImg');
            captchaImg.src = '${pageContext.request.contextPath }/user/captcha?'
                + Math.random();
        }
        function unFout() {
            var val = document.getElementById("username").value;
            var sp = document.getElementById("sp1");
            if (val == '') {
                sp.innerText = '用户名为空';
            } else {
                sp.innerText = '用户名ok';
            }
        }
        function pwFout() {
            var val = document.getElementById("password").value;
            var sp = document.getElementById("sp2");
            if (val == '') {
                sp.innerText = '密码为空';
            } else if (val.length <= 2 || val.length > 6) {
                sp.innerText = '密码长度不符合';
            } else {
                sp.innerText = '密码ok';
            }
        }
        function ccFout() {
            var val = document.getElementById("captchaCode").value;
            var sp = document.getElementById("sp3");
            if (val == '') {
                sp.innerText = '验证码为空';
            } else if (val.length != 4) {
                sp.innerText = '验证码的长度不符合';
            }
            else {
                sp.innerText = '验证码ok';
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
                    <%@ page import="java.util.*"%> <%@ page import="java.text.*"%><%    String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); /*//获取系统时间*/%><%=datetime%> <br/> <br/> <br/>
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
            <h1>login</h1>
            <form action="${path }/user/user_LoginAction" method="post"
                  onsubmit="return subFout()">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">username:</td>
                        <td valign="middle" align="left"><input type="text"
                                                                class="inputgri" name="username" onblur="unFout()"
                                                                id="username" placeholder="请输入用户名"><span
                                id="sp1" style="color:red;"></span></td>

                        <br/>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">password:</td>
                        <td valign="middle" align="left"><input type="password"
                                                                class="inputgri" name="password" id="password"
                                                                onblur="pwFout()" placeholder="请输入密码"/><span
                                id="sp2" style="color:red;"></span></td>

                        <br/>
                    </tr>
                </table>
                验证码: <input type="text" name="captchaCode" onblur="ccFout()"
                            id="captchaCode" class="inputgri" value='' placeholder="请输入验证码"> <span id="sp3"
                                                                                                   style="color:red;"></span><br>
                <img src="${pageContext.request.contextPath }/user/captcha"
                     id="captchaImg"/> <a href="javascript:void(0)"
                                          onclick="changeCaptcha()">看不清，换一张!~</a>&nbsp;<span
                    style="color:red">${param.errorMsg }</span><br/>
                <p>
                    <input type="submit" class="button" value="Submit &raquo;"/>
                </p>
            </form>
            <a href="${path}/regist.jsp"><input type="button" class="button"
                                                value="注册"/></a>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">ABC@126.com</div>
    </div>
</div>
</body>
</html>
