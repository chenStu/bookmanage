package com.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Book;
import com.bean.Reader;
import com.dao.ReaderDao;
import com.utils.DBconn;

public class ReaderDaoImpl implements ReaderDao {

	public Reader queryReader(Reader reader) {
		try {
			DBconn.init();
			String sql = "select * from reader where rId='" + reader.getrId()
					+ "' and password='" + reader.getPassword() + "'";
			ResultSet rs = DBconn.selectSql(sql);
			while (rs.next()) {
				if ((rs.getString("rId").equals(reader.getrId()))
						&& (rs.getString("password").equals(reader
								.getPassword()))) {
					reader.setrName(rs.getString("rName"));
					reader.setrSex(rs.getString("rSex"));
					reader.setrTel(rs.getString("rTel"));
					DBconn.closeConn();
					return reader;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Reader> queryAll() {
		List<Reader> list = new ArrayList<Reader>();
		try {
			DBconn.init();
			String sql = "select * from reader";
			ResultSet rs = DBconn.selectSql(sql);
			while (rs.next()) {
				Reader reader = new Reader();
				reader.setrId(rs.getString("rId"));
				reader.setrName(rs.getString("rName"));
				reader.setrSex(rs.getString("rSex"));
				reader.setrTel(rs.getString("rTel"));
				list.add(reader);
			}
			DBconn.closeConn();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
	public boolean checkRid(String rId) {
		try {
			DBconn.init();
			String sql = "select rId from reader where rId='" + rId + "'";
			ResultSet rs = DBconn.selectSql(sql);
			while (rs.next()) {
				if (rs.getString("rId").equals(rId)) {
					DBconn.closeConn();
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean saveReader(Reader reader) {
		boolean flag = checkRid(reader.getrId());
		int i = 0;
		if (flag == true) {
			return false;
		} else {
			try {
				DBconn.init();
				String sql = "insert into reader (rId,rName,password,rSex,rTel) "
						+ "values ('"
						+ reader.getrId()
						+ "','"
						+ reader.getrName()
						+ "','"
						+ reader.getPassword()
						+ "','"
						+ reader.getrSex()
						+ "','"
						+ reader.getrTel()
						+ "')";
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

	public boolean update(Reader reader) {
		int i = 0;
		try {
			DBconn.init();
			String sql = "update reader set rName='" + reader.getrName()
					+ "',rSex='" + reader.getrSex() + "',rTel='"
					+ reader.getrTel() + "' where rId='" + reader.getrId()
					+ "' ";
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

	public boolean updatePwd(Reader reader) {
		int i = 0;
		try {
			DBconn.init();
			String sql = "update reader set password='" + reader.getPassword()
					+ "' where rId='" + reader.getrId() + "' ";
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

	public boolean updateByMan(Reader reader) {
		int i = 0;
		try {
			DBconn.init();
			String sql = "update reader set rName='" + reader.getrName()
					+ "',rSex='"+reader.getrSex()+"',rTel='"+reader.getrTel()+"' where rId='" + reader.getrId() + "' ";
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

	public Reader queryById(String id) {
		Reader reader = new Reader();
		try {
			DBconn.init();
			String sql = "select * from reader where rId= '" + id + "'";
			ResultSet rs = DBconn.selectSql(sql);
			if (rs.next()) {
				reader.setrId(id);
				reader.setrName(rs.getString("rName"));
				reader.setrSex(rs.getString("rSex"));
				reader.setrTel(rs.getString("rTel"));
			}
			DBconn.closeConn();
			return reader;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delByMan(String id) {
		int i = 0;
		try {
			DBconn.init();
			String sql = "delete from reader where rId = '" + id + "'";
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
	
	public List<Book> queryCollection(String id) {
		List<Book> list = new ArrayList<Book>();
		try {
			DBconn.init();
			String sql = "select * from collection where rId='"+id+"'";
			ResultSet rs = DBconn.selectSql(sql);
			while (rs.next()) {
				Book book = new Book();
				book.setbId(rs.getString("bId"));
				book.setbName(rs.getString("bName"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setbType(rs.getString("bType"));
				list.add(book);
			}
			DBconn.closeConn();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean delCollection(String name,String id){
		int i=0;
		try {
			DBconn.init();
			String sql = "delete from collection where rId='"+id+"' and bName = '"+name+"'";
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
