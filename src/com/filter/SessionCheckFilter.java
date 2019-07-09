package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "indexPage", value = "index.jsp"),
		@WebInitParam(name = "managerPage", value = "manager_login.jsp"),
		@WebInitParam(name = "readerPage", value = "reader_login.jsp"),
		@WebInitParam(name = "LoginServlet", value = "/LoginServlet") })
public class SessionCheckFilter implements Filter {
	private FilterConfig config;

	public void destroy() {
		this.config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String indexPage = config.getInitParameter("indexPage");
		String managerPage = config.getInitParameter("managerPage");
		String readerPage = config.getInitParameter("readerPage");
		String LoginServlet = config.getInitParameter("LoginServlet");
		String path = req.getServletPath();

		if (session.getAttribute("login") != null
				|| path.endsWith(indexPage) || path.endsWith(managerPage)
				|| path.endsWith(LoginServlet)
				|| path.endsWith(readerPage)) {
			fChain.doFilter(request, response);
		} else {
			request.getRequestDispatcher(indexPage).forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

}
