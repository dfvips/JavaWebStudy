package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chapter8_3Servlet
 */
@WebServlet("/Chapter8_3Servlet")
public class Chapter8_3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chapter8_3Servlet() {
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
		String ischeck="";
		try{
			ischeck=request.getParameter("checkbox");
		}catch(Exception e){
			ischeck="";
		}
		boolean result;
		try{
		    result=pros.getProperty(username).equals(password);
		}catch(Exception e){
			result=false;
		}
		if(result){
			if(ischeck.equals("on")){
				Cookie cookie = new Cookie("usermsg", username+"&"+password);
				cookie.setMaxAge(60*60);
				response.addCookie(cookie);	
				request.getSession().setAttribute("username", "");
				out.print("<h2 Style='text-align:center;margin:0 auto'>Cookie获取成功，正在登录！</h2>");
				response.setHeader("Refresh", "1;url=chapter8-4.jsp");
			}
		}else{
			out.print("<h2 Style='text-align:center;margin:0 auto'>用户名或密码错误</h2>");
			response.setHeader("Refresh", "2;url=chapter8-3.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
