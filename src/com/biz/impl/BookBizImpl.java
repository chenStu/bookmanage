package com.biz.impl;

import java.util.List;

import com.bean.Book;
import com.bean.BorrowInfor;
import com.biz.BookBiz;
import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;

public class BookBizImpl implements BookBiz{
	BookDao book = new BookDaoImpl();
	public List<Book> queryAllBook() {
		
		return book.queryAllBook();
	}

	public List<Book> queryNewBook() {
		
		return book.queryNewBook();
	}

	public boolean addBook(Book bk) {
		
		return book.addBook(bk);
	}

	public boolean updateBook(Book bk) {
		
		return book.updateBook(bk);
	}

	public boolean delBook(String id) {
		return book.delBook(id);
	}

	public Book queryById(String id) {
		return book.queryById(id);
	}

	public List<BorrowInfor> queryBorrowInfor() {
		return book.queryBorrowInfor();
	}

	public List<BorrowInfor> queryReaderBorrow(String id) {
		return book.queryReaderBorrow(id);
	}

	public boolean moreTime(String id, String name) {
		return book.moreTime(id, name);
	}

	public boolean cancel(String id, String name) {
		return book.cancel(id, name);
	}

	public boolean borrowBook(BorrowInfor infor) {
		return book.borrowBook(infor);
	}

	public boolean delBorrowInfo(String name, String id) {
		return book.delBorrowInfo(name, id);
	}

	public boolean addCollect(Book books,String id) {
		return book.addCollect(books,id);
	}

}
