package bigd.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CacheFilter
 */
public class CacheFilter implements Filter {

	private String header = null;
	private String value = null;
    /**
     * Default constructor. 
     */
    public CacheFilter() {
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
//		  System.out.println("CacheFilter Running..");
		  HttpServletResponse hsresp = (HttpServletResponse) response;
		  hsresp.setHeader(header, value);
		  chain.doFilter(request, hsresp);
		  System.out.println("CacheFilter Done..");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.header = fConfig.getInitParameter("header");
		this.value = fConfig.getInitParameter("value");
//		System.out.println("header:" + this.header);
//		System.out.println("value:" + this.value);
	}

}
