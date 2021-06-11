package com.lec.ex4_update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;	// DB���� ����
		Statement stmt = null;	
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �μ���ȣ");
		String deptno = scanner.next();
		
		
		// �Է��� �ش� �μ� ��ȣ�� �ִ��� ������ üũ
		
		String selectSql = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno;
		
		System.out.println("������ �μ��̸� �Է�");
		String dname = scanner.next();
		System.out.println("����� �μ���ġ");
		String loc = scanner.next();
		String sql = String.format("UPDATE DEPT SET DNAME = '%s', LOC = '%s' WHERE DEPTNO = %s", dname, loc, deptno);
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSql);
			if(rs.next()) {
				System.out.println("������ �μ��̸� �Է�");
				String dname = scanner.next();
				System.out.println("����� �μ���ġ");
				String loc = scanner.next();
				String sql = String.format("UPDATE DEPT SET DNAME = '%s', LOC = '%s' WHERE DEPTNO = %s", dname, loc, deptno);
				
			}else {
				System.out.println("���������ʴ� �μ��̸�");
			}
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