package com.lec.ex5_deleteDept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// �μ� ��ȣ�� �޾� ����

public class DeleteDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectSql = "SELECT * FROM EMP WHERE DEPTNO = ?";
		String deleteSql = "DELETE FROM DEPT WHERE DEPTNO = ?";
		System.out.println("������ �μ���ȣ");
		int deptno = sc.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if(rs.next()) {// �ش� �μ���ȣ ����� ����
				System.out.println("�ش� �μ� ����� �����Ͽ� ���� �Ұ�");
			}else { // �ش� �μ���ȣ ��� �������
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(deleteSql);
				pstmt.setInt(1, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result == 1 ? "���� ����" : "���� ����");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			try {
				if (rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
		}
		
	}
}