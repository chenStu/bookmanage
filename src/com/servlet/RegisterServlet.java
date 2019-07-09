package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Manager;
import com.bean.Reader;
import com.biz.ManagerBiz;
import com.biz.ReaderBiz;
import com.biz.impl.ManagerBizImpl;
import com.biz.impl.ReaderBizImpl;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String identify = request.getParameter("identify");
		if(identify.equals("manager")){
			String mId = request.getParameter("mId");
			String mName = request.getParameter("mName");
			String pwd = request.getParameter("password");
			String mSex = request.getParameter("mSex");
			String mTel = request.getParameter("mTel");

			Manager man = new Manager();
			man.setmId(mId);
			man.setmName(mName);
			man.setPassword(pwd);
			man.setmSex(mSex);
			man.setmTel(mTel);
			ManagerBiz manbiz = new ManagerBizImpl();
			boolean register = manbiz.saveManager(man);

			if (register == true) {
				request.setAttribute("message", "添加成功");
				request.getRequestDispatcher("manager_register.jsp").forward(
						request, response);
			} else {
				request.setAttribute("message", "学工号已存在");
				request.getRequestDispatcher("manager_register.jsp").forward(
						request, response);
			}
		}
		if(identify.equals("reader")){
			String rId = request.getParameter("rId");
			String rName = request.getParameter("rName");
			String pwd = request.getParameter("password");
			String rSex = request.getParameter("rSex");
			String rTel = request.getParameter("rTel");
			
			Reader reader = new Reader();
			reader.setrId(rId);
			reader.setrName(rName);
			reader.setPassword(pwd);
			reader.setrSex(rSex);
			reader.setrTel(rTel);
			ReaderBiz biz = new ReaderBizImpl();
			boolean register = biz.saveReader(reader);
			
			if (register == true) {
				request.setAttribute("message", "添加成功");
				request.getRequestDispatcher("reader_register.jsp").forward(
						request, response);
			} else {
				request.setAttribute("message", "学号已存在");
				request.getRequestDispatcher("reader_register.jsp").forward(
						request, response);
			}
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
