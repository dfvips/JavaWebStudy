<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

	html,body{
		width:98%;
		height:98%;
	}
	*{
		padding: 0;
		margin: 0；
		border: none;
	}
	table{
		text-align: center;
		margin: 0 auto;
	}
	td,th{
		padding: 10px;
	}
</style>
</head>
<%!
//int a=666,b=554; 
%>
<%!
//public String print(){
	//String str="test";
	//return str;
//}
%>
<body>
<% 
//out.println(a*b);
%>
<% 
//out.println(print());
%>
<table style="border:1px solid #000;border-collapse: collapse; text-align: center">
<%!int row=10,col=10; %>
<% for(int i=1;i<row;i++){
	%>
	<tr>
	<%
	for(int j=1;j<col&&i>=j;j++){
		%>
		<td style="border:1px solid #000;">
		<%=i %>×<%=j %>=<%=i*j %>
		</td>
	<% 
	}
} %>
	</tr>
</table>
<br/><br/><br/>
<%@ include file="chapter6-2.jsp" %>
</body>
</html>