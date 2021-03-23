<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("UTF-8");
	//String username=(String)request.getAttribute("username");
	//String password=(String)request.getAttribute("password");
	//String username=(String)session.getAttribute("username");
	//String password=(String)session.getAttribute("password");
%>
<p>request用户名：${requestScope.username}</p>
<p>request密     码：${requestScope.password}</p>
<p>session用户名：${sessionScope.username}</p>
<p>session密     码：${sessionScope.password}</p>
</body>
</html>