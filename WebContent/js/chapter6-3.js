function add(obj) {
	var td_node=obj.parentNode;
	var value=td_node.childNodes[1].nodeValue;
	td_node.childNodes[1].nodeValue=" "+(Number(value)+1)+" ";
	var b_id = obj.parentNode.parentNode.childNodes[1].innerText;
	var b_name= obj.parentNode.parentNode.childNodes[3].innerText;
	var b_author= obj.parentNode.parentNode.childNodes[5].innerText;
	var b_price= obj.parentNode.parentNode.childNodes[7].innerText;
	xmlhttp=new XMLHttpRequest();
	if (window.XMLHttpRequest){
	  // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
	  xmlhttp=new XMLHttpRequest();
	  }else{
	  // IE6, IE5 浏览器执行代码
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.open("POST","Chapter5_2Servlet",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("b_id="+b_id+"&b_name="+b_name+"&b_author="+b_author+"&b_price="+b_price);
}
function del(obj) {
	var td_node=obj.parentNode;
	var value=td_node.childNodes[1].nodeValue;
	var b_id = obj.parentNode.parentNode.childNodes[1].innerText;
	if(value<=1){
		if(confirm("是否删除该书籍")){	
			remove(b_id);
			td_node.parentNode.remove();
		}
	}else{
		td_node.childNodes[1].nodeValue=" "+(Number(value)-1)+" ";
		remove(b_id);
	}
}
function remove(b_id) {
	xmlhttp=new XMLHttpRequest();
	if (window.XMLHttpRequest){
	  // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
	  xmlhttp=new XMLHttpRequest();
	  }else{
	  // IE6, IE5 浏览器执行代码
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	//xmlhttp.open("POST","chapter6-3.jsp",true);
	xmlhttp.open("POST","Chapter7_4Servlet",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("b_id="+b_id);
}
function submit() {
	var o_id=new Date().getTime();
	var c_name=document.getElementsByName('c_name')[0].value;
	var c_phone=document.getElementsByName('c_phone')[0].value;
	var c_address=document.getElementsByName('c_address')[0].value;
	var book_node=document.getElementById('booklist').childNodes[1].childNodes;
	var bookList_string="";
	var o_price=0;
	for(i=0;i<book_node.length;i++){
		if(i%2==0&&i!=0){
			var book_id=book_node[i].childNodes[1].innerText;
			var book_num=book_node[i].childNodes[9].childNodes[1].nodeValue;
			var book_price=book_node[i].childNodes[7].innerText;
			bookList_string+="{'b_id':'"+book_id+"','b_num':"+Number(book_num)+"},";
			var num=(Number(book_price.replace('元',''))*Number(book_num));
			o_price=Number(o_price)+num;
		}
	}
	o_price=decimal(o_price);
	bookList_string="["+bookList_string.substr(0, bookList_string.length - 1)+"]";
	var Order="{'Order':[{'o_id':"+o_id+",'c_name':"+c_name+",'c_phone':"+c_phone+",'c_address':"+c_address+",'o_price':"+o_price+",'bookList_string':"+bookList_string+"}]}";
	Order=Order.replace(/'/g,"\"");
	xmlhttp=new XMLHttpRequest();
	if (window.XMLHttpRequest){
	  // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
	  xmlhttp=new XMLHttpRequest();
	  }else{
	  // IE6, IE5 浏览器执行代码
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  xmlhttp.open("POST","Chapter6_3Servlet",true);
	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	  xmlhttp.send("Order="+Order);
	  xmlhttp.onreadystatechange=function(){
		  
	  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		  var result = xmlhttp.responseText;		
		  console.log(result);
		  if(result!="fail"){
			  alert("生成订单成功,订单信息为:"+result);
			  console.log(result);
		  }else{
			 alert("生成订单失败！");
		  }	  	  
	  }
	};
}
function decimal(x) { 
	   var f = parseFloat(x); 
	   if (isNaN(f)) { 
	    return false; 
	   } 
	   var f = Math.round(x*100)/100; 
	   var s = f.toString(); 
	   var rs = s.indexOf('.'); 
	   if (rs < 0) { 
	    rs = s.length; 
	    s += '.'; 
	   } 
	   while (s.length <= rs + 2) { 
	    s += '0'; 
	   } 
	   return s; 
} 