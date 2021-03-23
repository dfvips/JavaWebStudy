package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/Chapter4_1Servlet")
public class Chapter4_1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chapter4_1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		ServletContext context = this.getServletContext();
		Enumeration<String> paramNames = context.getInitParameterNames();
       // String name = paramNames.nextElement();
       // String value = context.getInitParameter(name);
       // out.println(name + ": " + value);
       // out.println("<br>");
        String path = context.getRealPath("/WEB-INF/userPW.properties");
        FileInputStream in = new FileInputStream(path);
        Properties pros = new Properties();
        pros.load(in);
        String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username+"/"+password);
		boolean result;
		try{
		    result=pros.getProperty(username).equals(password);
		}catch(Exception e){
			result=false;
		}
		if(result){
			out.print("用户名密码正确");
			response.setHeader("Refresh", "1;url=chapter4-2.html");
			request.getSession().setAttribute("username", username);
		}else{
			out.print("用户名密码错误");
			response.setHeader("Refresh", "1;url=chapter4-1.html");
		}
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
