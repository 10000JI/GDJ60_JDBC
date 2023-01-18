package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	public static Connection getConnection() throws Exception {
		//객체를 만들지 않고 해당 메소드 호출하고 싶다 => 클래스 메서드(static)
		
		//1. 접속 정보 준비
		//1) id
		String username = "hr";
		//2) password
		String password = "hr";
		//3) url
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		
		//2. DB 접속 실행
		Connection connection = DriverManager.getConnection(url,username,password);
		
		return connection;
	}
	
	public static void disConnect(ResultSet rs,PreparedStatement st, Connection connection ) throws Exception {
		rs.close();
		st.close();
		connection.close();
	}
	
}
