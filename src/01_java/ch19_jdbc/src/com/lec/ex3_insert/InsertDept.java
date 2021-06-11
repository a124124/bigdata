package com.lec.ex3_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�Է��� �μ� ��ȣ");
		int deptno = scanner.nextInt();
		System.out.println("�Է��� �μ���");
		String dname = scanner.next();
		System.out.println("�Է��� �μ� ��ġ");
		String loc = scanner.next();
		String sql = String.format("INSERT INTO DEPT VALUES(%d, '%s', '%s')", deptno, dname, loc);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result == 1? "�μ��߰� ����" : "�μ��߰� ����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			try {
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		scanner.close();
		
	}
}