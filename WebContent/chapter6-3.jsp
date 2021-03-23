<%@page import="org.apache.commons.collections.ExtendedProperties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.Book,java.util.List,java.util.Map,java.util.Iterator,java.util.ArrayList,net.sf.json.JSONArray,net.sf.json.JSONObject,java.util.HashMap" %>
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
	<%
	List<Book> cart=null;
	try{
		Map<Book, Integer> book_map = new HashMap<Book, Integer>();  
		cart = (List<Book>)session.getAttribute("cart");
		for(Book book:cart){
			boolean flag=true;
			for(Book book_key:book_map.keySet()){
				if(book_key.getB_id().equals(book.getB_id())){
					book_map.put(book_key,book_map.get(book_key)+1);
					flag=false;
					break;
				}
			}
			if(flag){
				book_map.put(book,1);
			}
		}
	  	%>
	  	<%
	  	for(Book book_key:book_map.keySet()){
	  	%>
		<tr>
			<td><% out.print(book_key.getB_id()); %></td>

			<td><% out.print(book_key.getB_name()); %></td>

			<td><% out.print(book_key.getB_author()); %></td>

			<td><% out.print(book_key.getB_price()); %></td>
			
			<td><button onclick="del(this);">-</button><% out.print(" "+book_map.get(book_key)+" "); %><button onclick="add(this);" >+</button></td>
		</tr>
		<%
	  	}   
		  	}catch(Exception e){
		  		out.print("您还没有购买任何书籍"); 
		  		%>
		  		<p><a href="chapter5-2.html">去购物...</a></p>
		  	<%
		  	}   
        %>
       	</table>
       	<%
    		try{
    		 	String b_id=request.getParameter("b_id");
   		 	 	if(b_id!=null){
	    			for(int i = 0 ; i  <  cart.size()  -   1 ; i ++ )  {       
			           if  (b_id.equals(cart.get(i).getB_id()))  {   
			        	   cart.remove(i);    
			        	   break;    
			            }              
			      }  
    			}
    		}catch(Exception e){
    		
    		}
       	 %>
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