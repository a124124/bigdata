package com.lec.ex5_deleteDept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �μ� ��ȣ��?");
		int deptno = scanner.nextInt();
		Connection conn = null;
		Statement stmt = null;
		String sql = String.format("DELETE FROM DEPT WHERE DEPTNO = %d", deptno);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if(result > 0) {
				System.out.println(deptno + "�� �μ� ���� �Ϸ�");
			}else {
				System.out.println("�������� �ʴ� �μ��Դϴ�");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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