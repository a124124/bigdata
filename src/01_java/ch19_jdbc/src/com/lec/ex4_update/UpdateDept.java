package com.lec.ex4_update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;	// DB���� ����
		Statement stmt = null;	
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �μ���ȣ");
		String deptno = scanner.next();
		System.out.println("������ �μ��̸� �Է�");
		String dname = scanner.next();
		System.out.println("����� �μ���ġ");
		String loc = scanner.next();
		String sql = String.format("UPDATE DEPT SET DNAME = '%s', LOC = '%s' WHERE DEPTNO = %s", dname, loc, deptno);
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "���� ����" : "���� ����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"1");
		}finally {
			try {
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage()+"2");
			}
		}
	}
}