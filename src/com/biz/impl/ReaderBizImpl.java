package com.biz.impl;

import java.util.List;

import com.bean.Book;
import com.bean.Reader;
import com.biz.ReaderBiz;
import com.dao.ReaderDao;
import com.dao.impl.ReaderDaoImpl;

public class ReaderBizImpl implements ReaderBiz {
	ReaderDao dao = new ReaderDaoImpl();

	public Reader queryReader(Reader reader) {
		return dao.queryReader(reader);
	}

	public boolean saveReader(Reader reader) {
		return dao.saveReader(reader);
	}

	public boolean update(Reader reader) {
		return dao.update(reader);
	}

	public boolean updatePwd(Reader reader) {
		return dao.updatePwd(reader);
	}

	public boolean updateByMan(Reader reader) {
		return dao.updateByMan(reader);
	}

	public Reader queryById(String id) {
		return dao.queryById(id);
	}

	public boolean delByMan(String id) {
		return dao.delByMan(id);
	}

	public List<Reader> queryAll() {
		return dao.queryAll();
	}

	public List<Book> queryCollection(String id) {
		return dao.queryCollection(id);
	}

	public boolean delCollection(String name, String id) {
		return dao.delCollection(name, id);
	}

}
