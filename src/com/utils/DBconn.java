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
			System.out.println("mysql���������ʼ��ʧ��");
			e.printStackTrace();
		}
	}
	
	public static int addUpdDel(String sql){
		int i = 0;
		try {
			ps = conn.prepareStatement(sql);
			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("mysql���ݿ���ɾ���쳣");
			e.printStackTrace();
		}
		return i;
	}
	
	public static ResultSet selectSql(String sql){
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (Exception e) {
			System.out.println("mysql���ݿ��ѯ�쳣");
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void closeConn(){
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("mysql���ݿ�ر��쳣");
			e.printStackTrace();
		}
	}
}
