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
 * Servlet implementation class Chapter5_1Servlet
 */
@WebServlet("/Chapter5_1Servlet")
public class Chapter5_1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chapter5_1Servlet() {
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
		String mode=request.getParameter("mode");
		if(mode.equals("1")){
			Cookie[] cookies = request.getCookies();
	        String userName = "";
	        String passWord = "";
	        for(int i=0; cookies!=null && i<cookies.length; i++){
	            if("userName".equals(cookies[i].getName())){
	                userName = cookies[i].getValue();
	            }            
	            if("passWord".equals(cookies[i].getName())){
	            	passWord = cookies[i].getValue();
	            }        
	        }
	        out.print(userName+"/"+passWord);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		ServletContext context = this.getServletContext();
		Enumeration<String> paramNames = context.getInitParameterNames();
        String path = context.getRealPath("/WEB-INF/userPW.properties");
        FileInputStream in = new FileInputStream(path);
        Properties pros = new Properties();
        pros.load(in);
		String remember=request.getParameter("remember");
        String username=request.getParameter("username");
		String password=request.getParameter("password");   
		boolean result;
		try{
		    result=pros.getProperty(username).equals(password);
		}catch(Exception e1){
			result=false;
		}
		if(result){
			out.print("用户名密码正确");
		    Cookie CookieName = new Cookie("userName", username);    
		    Cookie CookiePwd = new Cookie("passWord", password);   
			if("user_pw".equals(remember)){          
	            CookieName.setMaxAge(60*60);       
	            CookiePwd.setMaxAge(60*60);  
			}else{
				CookieName.setMaxAge(0);
				CookiePwd.setMaxAge(0);  
			}
            response.addCookie(CookieName);
            response.addCookie(CookiePwd);
		}else{
			out.print("用户名密码错误");
			response.setHeader("Refresh", "1;url=chapter5-1.html");
		}

	}

}
