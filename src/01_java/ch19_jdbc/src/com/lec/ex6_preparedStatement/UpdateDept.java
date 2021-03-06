package com.lec.ex6_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection			 conn	 = null;
		PreparedStatement	 pstmt	 = null;
		String sql = "UPDATE DEPT SET DNAME = ?, LOC = ? WHERE DEPTNO = ?";
		System.out.println("수정할 부서번호");
		int deptno = sc.nextInt();
		System.out.println("수정할 부서명");
		String dname = sc.next();
		System.out.println("수정할 근무지");
		String loc = sc.next();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, deptno);
			int result = pstmt.executeUpdate();
			System.out.println(result == 1 ? "수정 성공" : "실패");
			
			
		} catch (Exception e) {
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
