package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/Chapter4_2Servlet")
public class Chapter4_2Servlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chapter4_2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		ServletContext servletContext = this.getServletContext();
		String username="";
		try{
			username=request.getSession().getAttribute("username").toString();
		}catch (Exception e) {
			// TODO: handle exception
		}
        String message=request.getParameter("messages");
        String org=(String)servletContext.getAttribute("messages");
        if(org==null){
        	org="";
        }
        if(message.equals("")){
        	 servletContext.setAttribute("messages",org);
        }else{
        	servletContext.setAttribute("messages",org+username+"£º"+message+"</br>");
        }
		String messages=servletContext.getAttribute("messages").toString();
		if(username.equals("")){
			response.setHeader("Refresh", "1;url=chapter4-1.html");
		}else{
			out.print(username+"&"+messages);
		}
//		System.out.println(messages);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter out=response.getWriter();
//		out.write("the same way of the doPost");
		doGet(request, response);

	}

}
