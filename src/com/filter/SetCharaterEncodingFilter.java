package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SetCharaterEncodingFilter implements Filter {
	private String encoding = null;

	public void destroy() {
		encoding = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain Fchain) throws IOException, ServletException {
		if( encoding != null ){
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
		}
		Fchain.doFilter(request, response);
	}

	public void init(FilterConfig Fconfig) throws ServletException {
		encoding = Fconfig.getInitParameter("encoding");
	}

}
