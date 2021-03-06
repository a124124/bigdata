package com.lec.ex6_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// 부서 번호를 받아 삭제

public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM DEPT WHERE DEPTNO = ?";
		System.out.println("삭제할 부서번호");
		int deptno = sc.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno); // ? 채우는 과정
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println(deptno +"번 부서 삭제 완료");
			}else {
				System.out.println(deptno + "번 부서는 존재하지 않습니다.");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				
			}
		}
		
	}
}
