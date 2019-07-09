package com.biz.impl;

import com.bean.Manager;
import com.biz.ManagerBiz;
import com.dao.ManagerDao;
import com.dao.impl.ManagerDaoImpl;

public class ManagerBizImpl implements ManagerBiz{
	ManagerDao manager = new ManagerDaoImpl();
	public Manager queryManager(Manager man) {
		return manager.queryManager(man);
	}

	public boolean saveManager(Manager man) {
		return manager.saveManager(man);
	}

	public boolean update(Manager man){
		return manager.update(man);
	}

	public boolean updatePwd(Manager man) {
		return manager.updatePwd(man);
	}
}
