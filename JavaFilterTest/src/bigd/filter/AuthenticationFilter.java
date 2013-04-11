package bigd.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(
			ServletRequest request, 
			ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest hsresq = (HttpServletRequest) request;
		
		//current request server url(Don't include host and sitename)
		String serverletPath = hsresq.getServletPath();
		String contextPath = hsresq.getContextPath();
		String requestURL = hsresq.getRequestURI();
		
		HttpServletResponse hsresp = (HttpServletResponse)response;
		hsresp.reset();
//		System.out.println("AuthenticationFilter contextPath:" + contextPath);
//		System.out.println("AuthenticationFilter serverletPath:" + serverletPath);
		System.out.println("AuthenticationFilter requestURL:" + requestURL);
		//hsresp.setHeader("Content-Type", "application/json");
		// final output content
				PrintWriter out = hsresp.getWriter();
				out.write("Content had changed!! XD");
				out.flush();
				out.close();
		
		//chain.doFilter(request, response);
		
		System.out.println("AuthenticationFilter done");
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
