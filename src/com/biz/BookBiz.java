package com.biz;

import java.util.List;
import com.bean.Book;
import com.bean.BorrowInfor;

public interface BookBiz {
	public List<Book> queryAllBook();
	public List<Book> queryNewBook();
	public boolean addBook(Book book);
	public boolean updateBook(Book book);
	public boolean delBook(String id);
	public Book queryById(String id);
	public List<BorrowInfor> queryBorrowInfor();
	public List<BorrowInfor> queryReaderBorrow(String id);
	public boolean moreTime(String id , String name);
	public boolean cancel(String id , String name);
	public boolean borrowBook(BorrowInfor infor);
	public boolean delBorrowInfo(String name,String id);
	public boolean addCollect(Book book,String id);
}
