package com.lec.ex6_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

//부서번호를 받아 중복부서번호 여부 확인
	// 중복된 부서번호가 아닐 경우만 부서명, 근무지 dept 테이블 insert
public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection			 conn	 = null;
		PreparedStatement	 pstmt	 = null;
		ResultSet			 rs		 = null;
		String selectSql = "SELECT * FROM DEPT WHERE DEPTNO = ?";
		String insertSql = "INSERT INTO DEPT VALUES(?, ?, ?)";
		System.out.println("추가할 부서번호는 ?");
		int deptno = sc.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("중복된 부서번호");
			}else {
				System.out.println("부서 이름");
				String dname = sc.next();
				System.out.println("근무지");
				String loc = sc.next();
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(insertSql);
				pstmt.setInt(1, deptno);
				pstmt.setString(2, dname);
				pstmt.setString(3, loc);
				int result = pstmt.executeUpdate();
				if(result > 0) {
					System.out.println("추가 완료");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
