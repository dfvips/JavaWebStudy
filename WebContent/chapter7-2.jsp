<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");%>
	<p>请求参数用户名：${param.username}</p>
	<p>请求参数密码：${param.password}</p>
	<p>请求参数水果：${paramValues.fruit[0]}</p>
	
	
</body>
</html>