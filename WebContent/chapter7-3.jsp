<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:out value="&lt要显示的数据对象（未使用转义字符）&gt" escapeXml="false" default="默认值"></c:out><br/>
<c:set var="salary" scope="session" value="${2000*2}"/>

<c:if test="${salary > 2000}">

   <p>我的工资为: <c:out value="${salary}"/><p>

</c:if>
<table border="1px solid #000">
<c:forEach var="i" begin="1" end="9">
	<tr>
	<c:forEach var="j" begin="1" end="9">
		<c:if test="${i >= j}">
			<td>	
		    	<c:out value="${i}x${j}=${i*j}"/>
		    </td>
	    </c:if>
	 </c:forEach>
	</tr>
</c:forEach>
</table>
</body>
</html>