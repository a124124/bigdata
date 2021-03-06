package com.lec.ex3_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// 1 부서번호 받아 해당 부서 번호가 있는지 조회
// 2-1 부서가 없을 경우 - 부서명과 위치를 받아 insert
// 2-2 부서가 있을경우 - 이미 있다 메세지

public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력할 부서번호");
		int deptno = scanner.nextInt();
		String sql1 = String.format("SELECT DEPTNO FROM DEPT WHERE DEPTNO = %d", deptno);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			if(rs.next()) {
				System.out.println("부서번호 중복");
			}else {
				System.out.println("입력할 부서명");
				String dname = scanner.next();
				System.out.println("부서 위치");
				String loc = scanner.next();
				String sql2 = String.format("INSERT INTO DEPT VALUES(%d, '%s', '%s')", deptno, dname, loc);
				int result = stmt.executeUpdate(sql2);
				if(result > 0) {
					System.out.println("입력 성공");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
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
