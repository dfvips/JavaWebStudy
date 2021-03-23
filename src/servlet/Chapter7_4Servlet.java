package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Book;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Servlet implementation class Chapter7_4Servlet
 */
@WebServlet("/Chapter7_4Servlet")
public class Chapter7_4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chapter7_4Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);	
		List<Book> cart=null;
		Map<Book, Integer> book_map=null;
		try{
			book_map = new HashMap<Book, Integer>();  
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
			request.getSession().setAttribute("book_map", book_map);
			response.sendRedirect("chapter7-4.jsp");
		 }catch(Exception e){
		  		out.print("您还没有购买任何书籍"); 
		  		out.print("<p><a href='chapter5-2.html'>去购物...</a></p>");
		 }
		try{
			if(cart.size()<=1){
				cart.clear();
				book_map.clear();
			}else{
			 	String b_id=request.getParameter("b_id");
		 	 	if(b_id!=null){
    			for(int i = 0 ; i  <  cart.size()  -   1 ; i ++ )  {       
			           if  (b_id.equals(cart.get(i).getB_id()))  {   
			        	   cart.remove(i);    
			        	   break;    
			           }              
			      }
		 	 	}
			}
		}catch(Exception e){
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
