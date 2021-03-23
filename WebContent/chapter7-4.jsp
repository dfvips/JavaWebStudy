<%@page import="org.apache.commons.collections.ExtendedProperties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/chapter6-3.css" />
<title>Insert title here</title>
</head>
<body>
<h1>购物清单</h1>

	<table id="booklist">

		<tr>

			<th>书号</th>

			<th>书名</th>

			<th>作者</th>

			<th>价格</th>
			
			<th>数量</th>
		</tr>
		<c:forEach var="book" items="${sessionScope.book_map}"> 
			<tr>
				<td><c:out value="${book.key.getB_id()}"/></td>
	
				<td><c:out value="${book.key.getB_name()}"/></td>
	
				<td><c:out value="${book.key.getB_author()}"/></td>
	
				<td><c:out value="${book.key.getB_price()}"/></td>
				
				<td><button onclick="del(this);">-</button><c:out value=" ${book.value} "/><button onclick="add(this);" >+</button></td>
			</tr> 
		</c:forEach> 
       	</table>
  <h1>客户信息</h1>
  	<table>
		<tr>
			<td>收件人</td>
			<td><input type="text" name="c_name" required/></td><td>联系电话</td>
			<td><input type="text" maxlength="11" name="c_phone" required/></td>
		</tr>
		<tr>
			<td>收件地址</td><td colspan="3"><input type="text" id="place" name="c_address" required/></td>
		</tr>
		<tr><td colspan="4"><input type="button" value="提交" onclick="submit();"/></td></tr>
	</table> 
       	<script type="text/javascript" src="js/chapter6-3.js" ></script>
</body>
</html>