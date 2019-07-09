package com.dao;

import com.bean.Manager;

public interface ManagerDao {
	public Manager queryManager(Manager man);
	public boolean saveManager(Manager man);
	public boolean update(Manager man);
	public boolean updatePwd(Manager man);
}
