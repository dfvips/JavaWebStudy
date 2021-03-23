package filter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Chapter8_4Filter
 */
@WebFilter("/chapter8-4.jsp")
public class Chapter8_4Filter implements Filter {

    /**
     * Default constructor. 
     */
    public Chapter8_4Filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		PrintWriter out = response.getWriter();
		ServletContext context =request.getServletContext();
        String path = context.getRealPath("/WEB-INF/userPW.properties");
        FileInputStream in = new FileInputStream(path);
        Properties pros = new Properties();
        pros.load(in);
		Cookie[] cookies = req.getCookies();
		String token[] = null;
		for (Cookie cookie : cookies) {
			 if (cookie.getName().equals("usermsg")) {
				 token = URLDecoder.decode(cookie.getValue(), "utf-8").split("&");
				 String username=token[0];
				 String password=token[1];
				 boolean result;
					try{
					    result=pros.getProperty(username).equals(password);
					}catch(Exception e){
						result=false;
					}
				 if(result){
					// pass the request along the filter chain
					req.getSession().setAttribute("username", username);
					chain.doFilter(request, response);
				 }else{
					out.print("<h2 Style='text-align:center;margin:0 auto'>Cookie信息异常，请重新登录！</h2>");
					res.setHeader("Refresh", "2;url=chapter8-3.jsp");
				 }
			 }
		}
		if(token==null){
			 out.print("<h2 Style='text-align:center;margin:0 auto'>您还没有登录！</h2>");
			 res.setHeader("Refresh", "2;url=chapter8-3.jsp");
 		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
