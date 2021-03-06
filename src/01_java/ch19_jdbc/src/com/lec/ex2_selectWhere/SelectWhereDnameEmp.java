package com.lec.ex2_selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDnameEmp {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;	// DB연결 변수
		Statement stmt = null;	// SQL 문 전송 객체 변수
		ResultSet rs = null;	// SELECT 문 결과 받는 객체 변수
		Scanner scanner = new Scanner(System.in);
		System.out.println("부서 이름");
		String dname = scanner.next().toUpperCase();
		String sql1 = String.format("SELECT * FROM DEPT WHERE DNAME = '%s'", dname);
		String sql2 = String.format("SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER" + 
				"    FROM EMP W, EMP M, DEPT D" + 
				"    WHERE W.MGR = M.EMPNO AND W.DEPTNO = D.DEPTNO AND DNAME = '%s'", dname);
	
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			if(rs.next()) {
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				System.out.println("부서 번호 : " + deptno);
				System.out.println("부서 이름 : " + dname);
				System.out.println("부서 위치 : " + loc);
				rs.close();
				rs = stmt.executeQuery(sql2);
				if(rs.next()) {
					System.out.println("사번\t이름\t급여\t상사명");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager");
						System.out.printf("%d\t%s\t%d\t%s\n", empno, ename, sal, manager);
					}while(rs.next());
				}else {
					System.out.println("해당 부서 사원이 없습니다");
				}
			}else {
				System.out.println("해당 부서가 없습니다");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try { 	// 7단계 연결 해제
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
