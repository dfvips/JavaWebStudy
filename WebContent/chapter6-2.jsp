<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
		Book book=new Book("978-7-115-50506-4",	"Python网络爬虫技术","张良均"	,"32元","");
%>
<table style="border:1px solid #000;border-collapse: collapse; text-align: center">

		<tr>
			<th style="border:1px solid #000;">书号</th>
			<th style="border:1px solid #000;">书名</th>
			<th style="border:1px solid #000;">作者</th>
			<th style="border:1px solid #000;">价格</th>
		</tr>
		<tr>
			<td style="border:1px solid #000;"><%=book.getB_id() %></td>
			<td style="border:1px solid #000;"><%=book.getB_name() %></td>
			<td style="border:1px solid #000;"><%=book.getB_author() %></td>
			<td style="border:1px solid #000;"><%=book.getB_price() %></td>
		</tr>
	</table>
</body>
</html>