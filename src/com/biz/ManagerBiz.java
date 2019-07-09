package com.biz;

import com.bean.Manager;

public interface ManagerBiz {
	public Manager queryManager(Manager man);
	public boolean saveManager(Manager man);
	public boolean update(Manager man);
	public boolean updatePwd(Manager man);
}
