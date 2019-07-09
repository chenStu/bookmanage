package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Manager;
import com.bean.Reader;
import com.biz.ManagerBiz;
import com.biz.ReaderBiz;
import com.biz.impl.ManagerBizImpl;
import com.biz.impl.ReaderBizImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session == null) {
			response.sendRedirect("index.jsp");
		}
		String identify = request.getParameter("identify");
		String exit = request.getParameter("exit");
		if (exit!=null && exit.equals("1")) {
			session.removeAttribute("login");
//			session.invalidate();
			response.sendRedirect("index.jsp");
		} else {
			if (identify.equals("manager")) {
				String mId = request.getParameter("mId");
				String pwd = request.getParameter("password");
				Manager man = new Manager();
				man.setmId(mId);
				man.setPassword(pwd);
				ManagerBiz manbiz = new ManagerBizImpl();
				Manager login = manbiz.queryManager(man);
				if (login != null) {
					session.setAttribute("login", login);
					session.setAttribute("identify", identify);
//					System.out.println(session.getId());
					response.sendRedirect("manager_index.jsp");
				} else {
					request.setAttribute("message", "—ßπ§∫≈ªÚ√‹¬Î¥ÌŒÛ");
					request.getRequestDispatcher("manager_login.jsp").forward(
							request, response);
				}
			}
			if (identify.equals("reader")) {
				String rId = request.getParameter("rId");
				String pwd = request.getParameter("password");
				Reader reader = new Reader();
				reader.setrId(rId);
				reader.setPassword(pwd);
				ReaderBiz readerBiz = new ReaderBizImpl();
				Reader login = readerBiz.queryReader(reader);
				if (login != null) {
					session.setAttribute("login", login);
					session.setAttribute("identify", identify);
					response.sendRedirect("reader_index.jsp");
				} else {
					request.setAttribute("message", "—ß∫≈ªÚ√‹¬Î¥ÌŒÛ");
					request.getRequestDispatcher("reader_login.jsp").forward(
							request, response);
				}
			}

		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
