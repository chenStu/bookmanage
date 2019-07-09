package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Book;
import com.bean.Reader;
import com.biz.ReaderBiz;
import com.biz.impl.ReaderBizImpl;

@WebServlet("/ReaderServlet")
public class ReaderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String doing = request.getParameter("do");
		String id = request.getParameter("id");
		String oldpwd = request.getParameter("oldPwd");
		String newpwd = request.getParameter("newPwd");
		String name = request.getParameter("bName");
		
		String rId = request.getParameter("rId");
		String rName = request.getParameter("rName");
		String rSex = request.getParameter("rSex");
		String rTel = request.getParameter("rTel");
		
		Reader reader = new Reader();
		ReaderBiz biz = new ReaderBizImpl();
		if (doing.equals("updPwd")) {
			Reader re = (Reader) session.getAttribute("login");
			if (!re.getPassword().equals(oldpwd)) {
				request.setAttribute("message", "���������");
				request.getRequestDispatcher("updatePwd.jsp").forward(request,
						response);
			} else {
				reader.setrId(id);
				reader.setPassword(newpwd);
				boolean updpwd = biz.updatePwd(reader);
				if (updpwd) {
					request.setAttribute(
							"message",
							"<a href='LoginServlet?exit=1' style='color: red;' target='_parent'>�޸ĳɹ���������µ�¼</a>");
					request.getRequestDispatcher("updatePwd.jsp").forward(
							request, response);
				} else {
					request.setAttribute("message", "�޸�ʧ��");
					request.getRequestDispatcher("updatePwd.jsp").forward(
							request, response);
				}
			}
		}
		if (doing.equals("upd")) {
			reader.setrId(rId);
			reader.setrName(rName);
			reader.setrSex(rSex);
			reader.setrTel(rTel);
			boolean upd = biz.update(reader);
			if (upd == true) {
				session.setAttribute("login", reader);
				request.setAttribute("message", "�޸ĳɹ�");
				request.getRequestDispatcher("reader_update.jsp").forward(
						request, response);
			} else {
				request.setAttribute("message", "�޸�ʧ��");
				request.getRequestDispatcher("reader_update.jsp").forward(
						request, response);
			}
		}
		if(doing.equals("all")){
			List<Reader> list = biz.queryAll();
			session.setAttribute("allReader", list);
			response.sendRedirect("reader_query.jsp");
		}
		if (doing.equals("update")) {
			Reader reader1 = (Reader) session.getAttribute("reader");
			if(reader1.getrName().equals(rName)&&reader1.getrSex().equals(rSex)&&reader1.getrTel().equals(rTel)){
				request.setAttribute("message", "û�����κ��޸�");
				request.getRequestDispatcher("reader_edit.jsp").forward(request,response);
			}else{
				reader.setrId(id);
				reader.setrName(rName);
				reader.setrSex(rSex);
				reader.setrTel(rTel);
				boolean flag = biz.updateByMan(reader);
				if (flag){
					request.setAttribute("message", "�޸Ķ�����Ϣ�ɹ�");
					List<Reader> list = biz.queryAll();
					session.setAttribute("allReader", list);
					request.getRequestDispatcher("reader_query.jsp").forward(request,response);
				}
				else{
					request.setAttribute("message", "�޸�ʧ��");
					request.getRequestDispatcher("reader_edit.jsp").forward(request,response);
				}
			}
		}
		if (doing.equals("find")) {
			reader = biz.queryById(id);
			session.setAttribute("reader", reader);
			response.sendRedirect("reader_edit.jsp");
		}
		if (doing.equals("del")) {
			boolean flag = biz.delByMan(id);
			if(flag){
				request.setAttribute("message", "ɾ���ɹ�");
				List<Reader> list = biz.queryAll();
				session.setAttribute("allReader", list);
			}else{
				request.setAttribute("message", "ɾ��ʧ��");
			}
			request.getRequestDispatcher("reader_query.jsp").forward(request,response);
		}
		if(doing.equals("collect")){
			List<Book> collections = (List<Book>) biz.queryCollection(id);
			session.setAttribute("collections", collections);
			if(collections.isEmpty()){
				request.setAttribute("message", "�㻹û���ղ�ϲ������");
				request.getRequestDispatcher("my_collect.jsp").forward(request,response);
			}else{
				response.sendRedirect("my_collect.jsp");
			}
		}
		if(doing.equals("delCollection")){
			boolean flag = biz.delCollection(name, id);
			if(flag){
				request.setAttribute("message", "�ɹ��Ƴ��ղ�");
				List<Book> collections = (List<Book>) biz.queryCollection(id);
				session.setAttribute("collections", collections);
				if(collections.isEmpty()){
					request.setAttribute("message", "�㻹û���ղ�ϲ������");
					request.getRequestDispatcher("my_collect.jsp").forward(request,response);
				}else{
					request.getRequestDispatcher("my_collect.jsp").forward(request,response);
				}
			}else{
				request.setAttribute("message", "����ʧ��");
			}
			request.getRequestDispatcher("my_collect.jsp").forward(request,response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
