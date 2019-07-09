package com.dao.impl;

import java.sql.ResultSet;

import com.bean.Manager;
import com.dao.ManagerDao;
import com.utils.DBconn;

public class ManagerDaoImpl implements ManagerDao {

	public Manager queryManager(Manager man) {
		try {
			DBconn.init();
			String sql = "select * from manager where mId='" + man.getmId()
					+ "' and password='" + man.getPassword() + "'";
			ResultSet rs = DBconn.selectSql(sql);
			while (rs.next()) {
				if ((rs.getString("mId").equals(man.getmId()))
						&& (rs.getString("password").equals(man.getPassword()))) {
					man.setmName(rs.getString("mName"));
					man.setmSex(rs.getString("mSex"));
					man.setmTel(rs.getString("mTel"));
					DBconn.closeConn();
					return man;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean checkMid(String mId) {
		try {
			DBconn.init();
			String sql = "select mId from manager where mId='" + mId + "'";
			ResultSet rs = DBconn.selectSql(sql);
			while (rs.next()) {
				if (rs.getString("mId").equals(mId)) {
					DBconn.closeConn();
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean saveManager(Manager man) {
		boolean flag = checkMid(man.getmId());
		int i = 0;
		if (flag == true) {
			return false;
		} else {
			try {
				DBconn.init();
				String sql = "insert into manager (mId,mName,password,mSex,mTel) "
						+ "values ('"
						+ man.getmId()
						+ "','"
						+ man.getmName()
						+ "','"
						+ man.getPassword()
						+ "','"
						+ man.getmSex()
						+ "','" + man.getmTel() + "')";
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

	public boolean update(Manager man) {
		int i = 0;
		try {
			DBconn.init();
			String sql = "update manager set mName='" + man.getmName()
					+ "',mSex='" + man.getmSex() + "',mTel='" + man.getmTel()
					+ "' where mId='" + man.getmId() + "' ";
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

	public boolean updatePwd(Manager man) {
		int i = 0;
		try {
			DBconn.init();
			String sql = "update manager set password='" + man.getPassword()
					+ "' where mId='" + man.getmId() + "' ";
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
}
