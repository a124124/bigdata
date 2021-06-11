package com.lec.ex1_selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";	// mysql 8.0
		String url = "jdbc:mysql://localhost:3306/kimdb?serverTimezone=UTC";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PERSONAL";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "mysql");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("사번\t이름\t직책\t상사\t사번\t입사일\t급여\t상여\t부서번호");
			while(rs.next()) {
				int pno = rs.getInt("pno");
				String pname = rs.getString("pname");
				String job = rs.getString("job");
				int manager = rs.getInt("manager");
				Date startdate = rs.getDate("startdate");
				int pay = rs.getInt("pay");
				int bonus = rs.getInt("bonus");
				int dno = rs.getInt("dno");
				System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\n", pno, pname, job, manager, startdate, pay, bonus, dno);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
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
