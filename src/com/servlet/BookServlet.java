package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Book;
import com.bean.BorrowInfor;
import com.bean.Page;
import com.biz.BookBiz;
import com.biz.impl.BookBizImpl;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String doing = request.getParameter("do");
		String id = request.getParameter("id");
		String rid = request.getParameter("rId");
		String name = request.getParameter("name");
		
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String author = request.getParameter("author");
		String publish = request.getParameter("publish");
		String bType = request.getParameter("bType");
		String count = request.getParameter("count");
		String remain = request.getParameter("remain");
		String date = request.getParameter("date");
		
		String page = request.getParameter("page");

		BookBiz book = new BookBizImpl();
		Book bk = new Book();
		if (doing.equals("new")) {
			List<Book> newBook = book.queryNewBook();
			session.setAttribute("newBook", newBook);
			response.sendRedirect("main.jsp");
		}
		
		if(doing.equals("all")){
			Page pages = new Page();
			List<Book> allBook = book.queryAllBook();
			if(page==null){
				pages.setCurPage(1);
			}else{
				pages.setCurPage(Integer.valueOf(page));
			}
			pages.setFirstPage(1);
			pages.setPageItems(8);
			pages.setTotalItems(allBook.size());
			int num = (int) Math.ceil(allBook.size()/(pages.getPageItems()*1.0));
			pages.setTotalPages(num);
			if(pages.getCurPage()<1){
				pages.setCurPage(1);
			}
			if(pages.getCurPage()>=pages.getTotalPages()){
				pages.setCurPage(pages.getTotalPages());
			}
			List<Book> list = new ArrayList<Book>();
			for(int i=(pages.getCurPage()-1)*pages.getPageItems() ;i<pages.getCurPage()*pages.getPageItems()&&i<allBook.size() ; i++){
				list.add(allBook.get(i));
			}
			session.setAttribute("pages", pages);
			session.setAttribute("allBook", list);
			response.sendRedirect("book_query.jsp");
		}
		if (doing.equals("add")) {
			bk.setbId(bId);
			bk.setbName(bName);
			bk.setAuthor(author);
			bk.setPublish(publish);
			bk.setbType(bType);
			bk.setCount(count);
			bk.setRemain(remain);
			bk.setDate(date);
			boolean flag = book.addBook(bk);
			if (flag){
				request.setAttribute("message", "成功添加图书");
			}
			else
				request.setAttribute("message", "添加失败，编号或书名已存在");
			request.getRequestDispatcher("book_add.jsp").forward(request,
					response);

		}
		if (doing.equals("update")) {
			Book book1 = (Book) session.getAttribute("book");
			if (book1.getbName().equals(bName)
					&& book1.getAuthor().equals(author)
					&& book1.getPublish().equals(publish)
					&& book1.getbType().equals(bType)
					&& book1.getCount().equals(count)
					&& book1.getRemain().equals(remain)) {
				request.setAttribute("message", "没有做任何修改");
				request.getRequestDispatcher("book_update.jsp").forward(
						request, response);
			} else {
				bk.setbId(id);
				bk.setbName(bName);
				bk.setAuthor(author);
				bk.setPublish(publish);
				bk.setbType(bType);
				bk.setCount(count);
				bk.setRemain(remain);
				boolean flag = book.updateBook(bk);
				if (flag) {
					request.setAttribute("message", "修改图书信息成功");
					List<Book> allBook = book.queryAllBook();
					session.setAttribute("allBook", allBook);
					request.getRequestDispatcher("book_query.jsp").forward(
							request, response);
				} else {
					request.setAttribute("message", "修改失败，编号或书名已存在");
					request.getRequestDispatcher("book_update.jsp").forward(
							request, response);
				}

			}
		}
		if (doing.equals("find")) {
			bk = book.queryById(id);
			session.setAttribute("book", bk);
			response.sendRedirect("book_update.jsp");
		}
		if (doing.equals("del")) {
			boolean flag = book.delBook(id);
			if (flag) {
				request.setAttribute("message", "删除成功");
				List<Book> allBook = book.queryAllBook();
				session.setAttribute("allBook", allBook);

			} else {
				request.setAttribute("message", "删除失败");
			}
			request.getRequestDispatcher("book_query.jsp").forward(request,
					response);
		}
		if (doing.equals("borrow")) {
			List<BorrowInfor> infors = book.queryBorrowInfor();
			session.setAttribute("allBorrowInfo", infors);
			if(infors.isEmpty()){
				request.setAttribute("message", "暂没有任何借书信息");
				request.getRequestDispatcher("book_borrow.jsp").forward(request,
						response);
			}else{
				response.sendRedirect("book_borrow.jsp");
			}
		}
		if (doing.equals("rBorrow")) {
			List<BorrowInfor> infors = book.queryReaderBorrow(id);
			session.setAttribute("ReaderBorrow", infors);
			if(infors.isEmpty()){
				request.setAttribute("message", "你暂时没有借任何书");
				request.getRequestDispatcher("reader_borrow.jsp").forward(request,
						response);
			}else{
				response.sendRedirect("reader_borrow.jsp");
			}
		}
		if (doing.equals("moretime")) {
			boolean flag = book.moreTime(id, name);
			if(flag){
				request.setAttribute("message", "续借成功");
				List<BorrowInfor> infors = book.queryReaderBorrow(id);
				session.setAttribute("ReaderBorrow", infors);
			}else{
				request.setAttribute("message", "操作失败");
			}
			request.getRequestDispatcher("reader_borrow.jsp").forward(request,
					response);
		}
		if (doing.equals("cancel")) {
			boolean flag = book.cancel(id, name);
			if(flag){
				request.setAttribute("message", "还书成功");
				List<BorrowInfor> infors = book.queryReaderBorrow(id);
				session.setAttribute("ReaderBorrow", infors);
			}else{
				request.setAttribute("message", "操作失败");
			}
			request.getRequestDispatcher("reader_borrow.jsp").forward(request,
					response);
		}
		if (doing.equals("borrowbook")) {
			BorrowInfor infor = new BorrowInfor();
			infor.setbName(bName);
			infor.setAuthor(author);
			infor.setrId(id);
			infor.setrName(name);
			boolean flag = book.borrowBook(infor);
			if(flag){
				request.setAttribute("message", "借阅成功");
				List<BorrowInfor> infors = book.queryReaderBorrow(id);
				session.setAttribute("ReaderBorrow", infors);
				request.getRequestDispatcher("reader_borrow.jsp").forward(request,
						response);
			}else{
				request.setAttribute("message", "你借的该书未还，如需阅读，请到我的借阅中续借！");
				request.getRequestDispatcher("book_query.jsp").forward(request,
						response);
			}
		}
		if(doing.equals("delBorrow")){
			boolean flag = book.delBorrowInfo(name, id);
			if(flag){
				List<BorrowInfor> infors = book.queryBorrowInfor();
				session.setAttribute("allBorrowInfo", infors);
				request.setAttribute("message", "删除成功");
			}else{
				request.setAttribute("message", "操作失败");
			}
			request.getRequestDispatcher("book_borrow.jsp").forward(request,
					response);
		}
		if(doing.equals("addCollection")){
			bk = book.queryById(id);
			boolean flag = book.addCollect(bk,rid);
			if(flag){
				request.setAttribute("message", "收藏成功");
			}else{
				request.setAttribute("message", "此书已经加入收藏");
			}
			request.getRequestDispatcher("book_query.jsp").forward(request,
					response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
