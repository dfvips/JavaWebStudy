window.onload=function(){
	xmlhttp=new XMLHttpRequest();

	xmlhttp.onreadystatechange=function()

	{

	  if (xmlhttp.readyState==4 && xmlhttp.status==200)

	  {

		  var result = xmlhttp.responseText;		  

		  if(result=="fail"){

			  document.getElementsByTagName("p")[0].innerHTML = "购物车中没有任何书籍，请访问<a href='chapter5-1.html'>购书页面</a>";

		  }else{

			  var booklist = document.getElementById("booklist");

			  var books = JSON.parse(result);

			  for(var i=0; i<books.length; i++){

				  var tr = document.createElement("tr");

				  book = books[i];

				  var td_id = document.createElement("td");

				  td_id.innerText = book.b_id;

				  tr.appendChild(td_id);
				  var td_name = document.createElement("td");

				  td_name.innerText = book.b_name;

				  tr.appendChild(td_name);
				  var td_author = document.createElement("td");

				  td_author.innerText = book.b_author;

				  tr.appendChild(td_author);
				  var td_price = document.createElement("td");

				  td_price.innerText = book.b_price;

				  tr.appendChild(td_price);

				  booklist.appendChild(tr);

			  } 		  

		  }	  	  

	  }

	};

	xmlhttp.open("POST","Chapter5_3Servlet",true);

	xmlhttp.send();
}