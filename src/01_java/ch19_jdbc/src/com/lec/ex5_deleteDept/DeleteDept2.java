package com.lec.ex5_deleteDept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 부서 번호를 받아 삭제

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
		System.out.println("삭제할 부서번호");
		int deptno = sc.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if(rs.next()) {// 해당 부서번호 사원이 존재
				System.out.println("해당 부서 사원이 존재하여 삭제 불가");
			}else { // 해당 부서번호 사원 존재안함
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(deleteSql);
				pstmt.setInt(1, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result == 1 ? "삭제 성공" : "삭제 실패");
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
