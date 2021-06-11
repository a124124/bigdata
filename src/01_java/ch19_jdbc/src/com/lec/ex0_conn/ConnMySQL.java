package com.lec.ex0_conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";	// mysql 8.0
		String url = "jdbc:mysql://localhost:3306/kimdb?serverTimezone=UTC";
		Connection conn = null;
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(url,"root","mysql");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "드라이버 로드 오류");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
}
