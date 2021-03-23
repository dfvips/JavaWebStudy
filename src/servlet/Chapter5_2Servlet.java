package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Book;

/**
 * Servlet implementation class Chapter5_2Servlet
 */
@WebServlet("/Chapter5_2Servlet")
public class Chapter5_2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chapter5_2Servlet() {
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
		String b_id=request.getParameter("b_id");
        String b_name=request.getParameter("b_name");
		String b_author=request.getParameter("b_author");   
		String b_price=request.getParameter("b_price");   
		String b_img=request.getParameter("b_img");   
		Book book = new Book(b_id, b_name, b_author, b_price, b_img);
		HttpSession session = request.getSession();			
		List<Book> cart = (List<Book>)session.getAttribute("cart");
		if(cart==null){
			cart = new ArrayList<Book>();
			session.setAttribute("cart",cart);			
		}
		if(cart.add(book)){
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);	
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
