package com.lec.ex2_selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;	// DB���� ����
		Statement stmt = null;	// SQL �� ���� ��ü ����
		ResultSet rs = null;	// SELECT �� ��� �޴� ��ü ����
		Scanner scanner = new Scanner(System.in);
		System.out.println("�μ� �̸�");
		String dname = scanner.next();
		String sql = "SELECT * FROM DEPT WHERE DNAME = '"+ dname + "'";
//		sql = String.format("SELECT * FROM DEPT WHERE DNAME = '%s'", dname);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				System.out.println(deptno + "�� �μ� ������ ������ �����ϴ�");
				System.out.println("�μ� �̸� : "+ dname);
				System.out.println("�μ� ��ġ : " + loc);
				
			}else {
				System.out.println("�ش� �μ��� �������� �ʽ��ϴ�");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			try { 	// 7�ܰ� ���� ����
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
}