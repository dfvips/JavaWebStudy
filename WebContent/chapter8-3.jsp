<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/chapter8-3.css" />
<title>用户登录</title>
</head>
<body>
	<c:if test="${cookie.usermsg.value!=null&&cookie.usermsg.value!=''}">
		<c:redirect url="chapter8-4.jsp"></c:redirect>
	</c:if>
	<div id="content">
	<h2>用户登录</h2>
	<form action="Chapter8_3Servlet" method="post">
	<div>
		<p>用户名</p>
		<input type="text" name="username" />
	</div>
	<div>
		<p>密码</p>
		<input type="password"
			name="password" /> 
	</div>
	<div id="remember">
		<input type="checkbox" name="checkbox"/>
		<label>请记住我</label>
	</div>
	<div id="button">
		<input type="submit" value="登录" />
	</div>
	</form>
	</div>
</body>
</html>