package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBconn {
	static String url = "jdbc:mysql://localhost:3306/bookmanage?useUnicode=true&"
			+ "characterEncoding=UTF-8&serverTimezone=GMT&useSSL=false";
	static String username = "root";
	static String password = "123456";
	static Connection conn = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	public static void init(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			System.out.println("mysql驱动程序初始化失败");
			e.printStackTrace();
		}
	}
	
	public static int addUpdDel(String sql){
		int i = 0;
		try {
			ps = conn.prepareStatement(sql);
			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("mysql数据库增删改异常");
			e.printStackTrace();
		}
		return i;
	}
	
	public static ResultSet selectSql(String sql){
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (Exception e) {
			System.out.println("mysql数据库查询异常");
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void closeConn(){
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("mysql数据库关闭异常");
			e.printStackTrace();
		}
	}
}
