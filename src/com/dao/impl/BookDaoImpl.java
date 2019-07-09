package com.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Book;
import com.bean.BorrowInfor;
import com.dao.BookDao;
import com.utils.DBconn;

public class BookDaoImpl implements BookDao {
	public List<Book> queryAllBook() {
		List<Book> list = new ArrayList<Book>();
		try {
			DBconn.init();
			String sql = "select * from book";
			ResultSet rs = DBconn.selectSql(sql);
			while (rs.next()) {
				Book book = new Book();
				book.setbId(rs.getString("bId"));
				book.setbName(rs.getString("bName"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setbType(rs.getString("bType"));
				book.setCount(rs.getString("count"));
				book.setRemain(rs.getString("remain"));
				book.setDate(rs.getString("date"));
				list.add(book);
			}
			DBconn.closeConn();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Book> queryNewBook() {
		List<Book> list = new ArrayList<Book>();
		try {
			DBconn.init();
			String sql = "select * from book where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date( date )";
			ResultSet rs = DBconn.selectSql(sql);
			while (rs.next()) {
				Book book = new Book();
				book.setbName(rs.getString("bName"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setbType(rs.getString("bType"));
				book.setDate(rs.getString("date"));
				list.add(book);
			}
			DBconn.closeConn();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean checkBook(Book book) {
		try {
			DBconn.init();
			String sql = "select * from book where bId= '" + book.getbId()
					+ "' or bName= '" + book.getbName() + "' ";
			ResultSet rs = DBconn.selectSql(sql);
			if (rs.next()) {
				DBconn.closeConn();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addBook(Book book) {
		int i;
		boolean flag = checkBook(book);
		if (flag) {
			return false;
		} else {
			try {
				DBconn.init();
				String sql = "insert into book(bId,bName,author,publish,bType,count,remain,date) values('"
						+ book.getbId()
						+ "','"
						+ book.getbName()
						+ "','"
						+ book.getAuthor()
						+ "','"
						+ book.getPublish()
						+ "','"
						+ book.getbType()
						+ "','"
						+ book.getCount()
						+ "','"
						+ book.getRemain() + "','" + book.getDate() + "')";
				i = DBconn.addUpdDel(sql);
				if (i > 0) {
					DBconn.closeConn();
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateBook(Book book) {
		int i = 0;
		try {
			DBconn.init();
			String sql = "update book set bId='" + book.getbId() + "',bName='"
					+ book.getbName() + "',author='" + book.getAuthor()
					+ "',publish='" + book.getPublish() + "',bType='"
					+ book.getbType() + "',count='" + book.getCount()
					+ "',remain='" + book.getRemain() + "' where bId='" + book.getbId() + "'";
			i = DBconn.addUpdDel(sql);
			if (i > 0) {
				DBconn.closeConn();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delBook(String id) {
		int i = 0;
		try {
			DBconn.init();
			String sql = "delete from book where bId = '" + id + "'";
			i = DBconn.addUpdDel(sql);
			if (i > 0) {
				DBconn.closeConn();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Book queryById(String id) {
		Book book = new Book();
		try {
			DBconn.init();
			String sql = "select * from book where bId= '" + id + "'";
			ResultSet rs = DBconn.selectSql(sql);
			if (rs.next()) {
				book.setbId(rs.getString("bId"));
				book.setbName(rs.getString("bName"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setbType(rs.getString("bType"));
				book.setCount(rs.getString("count"));
				book.setRemain(rs.getString("remain"));
			}
			DBconn.closeConn();
			return book;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<BorrowInfor> queryBorrowInfor() {
		List<BorrowInfor> list = new ArrayList<BorrowInfor>();
		try {
			DBconn.init();
			String sql = "select * from borrow";
			ResultSet rs = DBconn.selectSql(sql);
			while (rs.next()) {
				BorrowInfor bInfo = new BorrowInfor();
				bInfo.setbName(rs.getString("bName"));
				bInfo.setAuthor(rs.getString("author"));
				bInfo.setrName(rs.getString("rName"));
				bInfo.setrId(rs.getString("rId"));
				bInfo.setOuttime(rs.getString("outtime"));
				bInfo.setIntime(rs.getString("intime"));
				bInfo.setIsreturn(rs.getString("isreturn"));
				bInfo.setIsdamage(rs.getString("isdamage"));
				list.add(bInfo);
			}
			DBconn.closeConn();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<BorrowInfor> queryReaderBorrow(String id) {
		List<BorrowInfor> list = new ArrayList<BorrowInfor>();
		try {
			DBconn.init();
			String sql = "select * from borrow where rId='"+id+"'";
			ResultSet rs = DBconn.selectSql(sql);
			while (rs.next()) {
				BorrowInfor bInfo = new BorrowInfor();
				bInfo.setbName(rs.getString("bName"));
				bInfo.setAuthor(rs.getString("author"));
				bInfo.setrName(rs.getString("rName"));
				bInfo.setrId(rs.getString("rId"));
				bInfo.setOuttime(rs.getString("outtime"));
				bInfo.setIntime(rs.getString("intime"));
				bInfo.setIsreturn(rs.getString("isreturn"));
				bInfo.setIsdamage(rs.getString("isdamage"));
				list.add(bInfo);
			}
			DBconn.closeConn();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean delBorrowInfo(String name,String id) {
		int i = 0;
		try {
			DBconn.init();
			String sql = "delete from borrow where rId = '" + id + "' and bName = '"+name+"'";
			i = DBconn.addUpdDel(sql);
			if (i > 0) {
				DBconn.closeConn();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean moreTime(String id , String name){
		int i=0;
		try {
			DBconn.init();
			String sql ="update borrow set intime=DATE_ADD(intime, INTERVAL 30 DAY) where rId ='"+id+"' and bName = '"+name+"'";
			i = DBconn.addUpdDel(sql);
			if(i>0){
				DBconn.closeConn();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean cancel(String id , String name){
		int i=0;
		try {
			DBconn.init();
			String sql="update borrow set intime=DATE(CURDATE()),isreturn='ÊÇ' where rId ='"+id+"' and bName = '"+name+"'";
			i = DBconn.addUpdDel(sql);
			if(i>0){
				DBconn.closeConn();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean borrowBook(BorrowInfor infor){
		boolean flag = isBorrow(infor.getbName(), infor.getrId());
		if(flag){
			return false;
		}
		int i=0;
		try {
			DBconn.init();
			String sql ="insert into borrow(bName,author,rId,rName,outtime,intime) value('"+infor.getbName()+"','"+infor.getAuthor()
					+"','"+infor.getrId()+"','"+infor.getrName()+"',DATE(CURDATE()),DATE_ADD(DATE(CURDATE()), INTERVAL 30 DAY))";
			i = DBconn.addUpdDel(sql);
			if(i>0){
				DBconn.closeConn();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean isBorrow(String name,String id){
		try {
			DBconn.init();
			String sql ="select * from borrow where bName='"+name+"' and rId='"+id+"' and isreturn ='·ñ' ";
			ResultSet rs = DBconn.selectSql(sql);
			if(rs.next()){
				DBconn.closeConn();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean isCollect(String name,String id){
		try {
			DBconn.init();
			String sql ="select * from collection where bName='"+name+"' and rId='"+id+"'";
			ResultSet rs = DBconn.selectSql(sql);
			if(rs.next()){
				DBconn.closeConn();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean addCollect(Book book,String id){
		boolean flag = isCollect(book.getbName(), id);
		if(flag){
			return false;
		}
		int i=0;
		try {
			DBconn.init();
			String sql ="insert into collection(rId,bId,bName,author,publish,bType) value('"+id+"','"+book.getbId()+"','"+book.getbName()
					+"','"+book.getAuthor()+"','"+book.getPublish()+"','"+book.getbType()+"')";
			i = DBconn.addUpdDel(sql);
			if(i>0){
				DBconn.closeConn();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
