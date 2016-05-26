package com.briup.cms.common;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 连接工厂
 * */
public class ConnectionFactory {
	private static String driver;
	private static String url ;
	private static String user;
	private static String password;
	
	static{
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://127.0.0.1:3306/cms?useUnicode=true&amp;characterEncoding=UTF-8";
		user = "root";
		password = "root";
	}
	public static Connection getConn () {
		Connection conn = null;
		try {
			//1.注册驱动
			Class.forName(driver);
			//2.获取连接
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
