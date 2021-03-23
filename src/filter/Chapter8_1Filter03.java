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
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class Chapter8_1Filter03
 */
@WebFilter(
		urlPatterns = { "/Chapter8_1Servlet" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "utf-8")
		})
public class Chapter8_1Filter03 implements Filter {

    /**
     * Default constructor. 
     */
	FilterConfig fConfig;
	String encoding;
    public Chapter8_1Filter03() {
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
		encoding=fConfig.getInitParameter("encoding");
		out.println("encoding:"+encoding);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.fConfig=fConfig;
	}

}
