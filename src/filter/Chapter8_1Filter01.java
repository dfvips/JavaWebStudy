package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Chaper8_1Filter01
 */
@WebFilter("/Chapter8_1Servlet")
public class Chapter8_1Filter01 implements Filter {

    /**
     * Default constructor. 
     */
    public Chapter8_1Filter01() {
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
		PrintWriter out=response.getWriter();
		out.println("Chapter8_1Filter01 doFilter before!");
		// pass the request along the filter chain
		int a=1;
		if(a==1){
			chain.doFilter(request, response);
			out.println("Chapter8_1Filter01 doFilter after!");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
