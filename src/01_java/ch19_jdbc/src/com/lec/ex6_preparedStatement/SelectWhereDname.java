package com.lec.ex6_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

// 부서명 입력받아 해당 부서명의 사번, 이름, 급여, 상사이름 출력

public class SelectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection			 conn	 = null;
		PreparedStatement	 pstmt	 = null;
		ResultSet			 rs		 = null;
		String deptQuery = "SELECT * FROM DEPT WHERE DNAME = ?";
		String empQuery = "SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER" + 
				"    FROM EMP W, EMP M, DEPT D" + 
				"    WHERE DNAME = ? AND W.MGR = M.EMPNO AND D.DEPTNO = W.DEPTNO";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(deptQuery);
			System.out.println("검색하고자 하는 부서명");
			String dname = sc.next();
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(empQuery);
				pstmt.setString(1, dname);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					System.out.println(dname + "부서 정보");
					System.out.println("부서 번호 : " + rs.getInt("deptno"));
					System.out.println("부서 위치 : " + rs.getString("loc"));
					rs.close();
					pstmt.close();
					pstmt = conn.prepareStatement(empQuery);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						
						do {
							int empno = rs.getInt("empno");
							String ename = rs.getString("ename");
							int sal = rs.getInt("sal");
							String manager = rs.getString("manager");
							System.out.printf("%d\t %s\t %d\t %s\n", empno, ename, sal, manager);
						}while(rs.next());
						
					}
					
				}else {
					System.out.println(dname + "부서 사원 없음");
				}
				
			}else {
				System.out.println("해당 부서명이 존재하지 않습니다");
			}
		} catch (Exception e) {
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
		
		sc.close();
	}
}
