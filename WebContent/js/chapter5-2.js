/**
	 * 
	 */
	window.onload=function(){
			xmlhttp=new XMLHttpRequest();
			if (window.XMLHttpRequest){
			  // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			  xmlhttp=new XMLHttpRequest();
			  }else{
			  // IE6, IE5 浏览器执行代码
			  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			  }
			  xmlhttp.open("POST","xml/chapter5-2.xml",true);
			  xmlhttp.send();
			  xmlhttp.onreadystatechange=function(){		
				    if (xmlhttp.readyState==4 && xmlhttp.status==200){
				       var xmlDoc=xmlhttp.responseXML;   
				       var book_count=xmlDoc.getElementsByTagName("bookstore")[0].childElementCount;
					   var book_ele=xmlDoc.getElementsByTagName("book")[0].childElementCount;
					   for(var i=0;i<book_count;i++){
						   var p_div_node = document.createElement("div");				
						   for(var j=0;j<book_ele-1;j++){
						   		 var p_node = document.createElement("p");
						  		 p_node.innerHTML=xmlDoc.getElementsByTagName("book")[i].children[j].childNodes[0].nodeValue;
						  		 p_div_node.appendChild(p_node);
						   }
						   var img_value=xmlDoc.getElementsByTagName("book")[i].children[4].childNodes[0].nodeValue;
						   var book_div_node=document.createElement("div");
						   var img_div_node = document.createElement("div");
						   var img_node = document.createElement("img");
						   var bookstore=document.getElementById("bookstore");
						   img_node.setAttribute("src", img_value);		
						   img_div_node.appendChild(img_node);		
						   book_div_node.appendChild(img_div_node);
						   book_div_node.appendChild(p_div_node)
						   book_div_node.setAttribute("class", "book");
						   book_div_node.setAttribute("draggable", "true");
						   book_div_node.setAttribute("ondragstart", "drag(event)");
						   book_div_node.setAttribute("id", "book"+(i+1));
						   bookstore.appendChild(book_div_node);
					   }
					}
				}
		};

		function drop(ev){
			ev.stopPropagation(); 
			ev.preventDefault();
			var data=ev.dataTransfer.getData("Text");        //获取被拖动元素id
			var b_img = document.getElementById(data).firstChild.childNodes[0].getAttribute("src");
			var b_id = document.getElementById(data).lastChild.childNodes[0].innerText;
			b_id = b_id.split("：")[1];
			var b_name=document.getElementById(data).lastChild.childNodes[1].innerText;
			b_name = b_name.split("：")[1];
			var b_author=document.getElementById(data).lastChild.childNodes[2].innerText;
			b_author = b_author.split("：")[1];
			var b_price=document.getElementById(data).lastChild.childNodes[3].innerText;
			b_price = b_price.split("：")[1];
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
			xmlhttp.send("b_id="+b_id+"&b_name="+b_name+"&b_author="+b_author+"&b_price="+b_price+"&b_img="+b_img);
		}
		function allowDrop(ev){
			ev.preventDefault();
		}
		function drag(e){
			var a=e.target.id;
			e.dataTransfer.setData("Text",a);
		}