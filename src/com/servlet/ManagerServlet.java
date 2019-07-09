package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Manager;
import com.biz.ManagerBiz;
import com.biz.impl.ManagerBizImpl;

@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String updPwd = request.getParameter("do");
		if (updPwd.equals("updPwd")) {
			String mId = request.getParameter("id");
			String oldpwd = request.getParameter("oldPwd");
			String newpwd = request.getParameter("newPwd");
			Manager manager = (Manager) session.getAttribute("login");
			if (!manager.getPassword().equals(oldpwd)) {
				request.setAttribute("message", "旧密码错误");
				request.getRequestDispatcher("updatePwd.jsp").forward(request, response);
			} else {
				Manager man = new Manager();
				man.setmId(mId);
				man.setPassword(newpwd);
				ManagerBiz biz = new ManagerBizImpl();
				boolean upd = biz.updatePwd(man);
				if (upd) {
					request.setAttribute("message", "<a href='LoginServlet?exit=1' style='color: red;' target='_parent'>修改成功，点击重新登录</a>");
					request.getRequestDispatcher("updatePwd.jsp").forward(request, response);
				} else {
					request.setAttribute("message", "修改失败");
					request.getRequestDispatcher("updatePwd.jsp").forward(request, response);
				}
			}
		}
		if (updPwd.equals("upd")) {
			String mId = request.getParameter("mId");
			String mName = request.getParameter("mName");
			String mSex = request.getParameter("mSex");
			String mTel = request.getParameter("mTel");
			Manager man = new Manager();
			man.setmId(mId);
			man.setmName(mName);
			man.setmSex(mSex);
			man.setmTel(mTel);
			ManagerBiz biz = new ManagerBizImpl();
			boolean upd = biz.update(man);
			if (upd) {
				session.setAttribute("login", man);
				request.setAttribute("message", "修改成功");
				request.getRequestDispatcher("manager_update.jsp").forward(
						request, response);
			} else {
				request.setAttribute("message", "修改失败");
				request.getRequestDispatcher("manager_update.jsp").forward(
						request, response);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
