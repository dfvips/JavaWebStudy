<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/chapter8-4.css" />
<title>书籍信息管理页面</title>
</head>
<body>
	<c:if test="${sessionScope.username!=null&&sessionScope.username!=''}" var="flag">
		<div id="content">
			<h2>书籍信息录入</h2>
			<form action="" method="post">
			<div>
				<p>书号</p>
				<input type="text" name="username" />
			</div>
			<div>
				<p>书名</p>
				<input type="text" name="username" />
			</div>
			<div>
				<p>作者</p>
				<input type="text" name="username" />
			</div>
			<div>
				<p>价格</p>
				<input type="text" name="username" />
			</div>
			<div id="button">
				<input type="submit" value="提交" />
			</div>
			</form>
		</div>
	</c:if>
	<c:if test="${not flag}">
		<c:redirect url="chapter8-3.jsp"></c:redirect>
		<c:out value="${null}" escapeXml="false"><h2 Style='text-align:center;margin:0 auto'>您还没有登录！</h2></c:out>
	</c:if>
</body>
</html>