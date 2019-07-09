package com.biz;

import java.util.List;

import com.bean.Book;
import com.bean.Reader;

public interface ReaderBiz {
	public Reader queryReader(Reader reader);
	public boolean saveReader(Reader reader);
	public List<Reader> queryAll();
	public boolean update(Reader reader);
	public boolean updatePwd(Reader reader);
	public boolean updateByMan(Reader reader);
	public Reader queryById(String id);
	public boolean delByMan(String id);
	public List<Book> queryCollection(String id);
	public boolean delCollection(String name,String id);
}
