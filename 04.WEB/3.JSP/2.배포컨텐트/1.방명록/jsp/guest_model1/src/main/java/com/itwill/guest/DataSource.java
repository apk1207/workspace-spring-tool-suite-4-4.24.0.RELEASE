package com.itwill.guest;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
 * Connection을 생성하고,해지하는역할을하는클래스
 *   - Dao객체들이 사용
 */
public class DataSource {

	public Connection getConnection() throws Exception {
		/*********************DB접속정보*********************/
		InputStream in = DataSource.class.getResourceAsStream("jdbc.properties"); 
		Properties properties=new Properties();
		properties.load(in);
		/*
		 * jdbc.properties파일을 읽어서 Map객체(Properties객체)로 만들어줌
		 */
		
		String driverClass = properties.getProperty("driverClassName");
		String url =properties.getProperty("url");;
		String username = properties.getProperty("username");;
		String password =properties.getProperty("password");;
		/*******************************************/
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}

	
}
