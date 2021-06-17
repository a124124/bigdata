package com.lec.ex01_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PersonManager {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		String fn, sql;
		// 1�ܰ� dowhile ��
		
		try {
			Class.forName(driver);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		do {
			System.out.println("1.�Է� || 2. ������ ��� || 3. ��ü ��� || �׿�. ����");
			fn = sc.next();
			switch (fn) {
			case "1":
//				System.out.println("�̸�, ����, ������ �Է¹޾� insert");
				System.out.println("�̸�");
				String name = sc.next();
				System.out.println("����(���, ����, ����)");
				String jname = sc.next();
				System.out.println("����");
				int kor = sc.nextInt();
				System.out.println("����");
				int eng = sc.nextInt();
				System.out.println("����");
				int mat = sc.nextInt();
				sql = "INSERT INTO PERSON" + 
						"    VALUES (PERSON_NO_SQ.NEXTVAL, ?, (SELECT JNO" + 
						"                                                FROM JOB" + 
						"                                                WHERE JNAME = ?), ?, ?, ?)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, jname);
					pstmt.setInt(3, kor);
					pstmt.setInt(4, eng);
					pstmt.setInt(5, mat);
					int result = pstmt.executeUpdate();
					System.out.println(result == 1? name + "�� �Է� ����" : "�Է� ����");
					
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
				
				break;
			
			case "2":
//				System.out.println("������ �Է¹޾� ������ ���");
				System.out.println("��ȸ�� ������(���, ����, ����)");
				jname = sc.next();
				sql = "SELECT ROWNUM RANK, S.*" + 
						"    FROM (SELECT NAME||'('||NO||'��)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
						"                FROM PERSON P, JOB J" + 
						"                WHERE P.JNO = J.JNO AND JNAME = ?" + 
						"                ORDER BY SUM DESC) S";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, jname);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						System.out.println("rank\t�̸�\t\t����\t����\t����\t����\t����");
						do {
							int rank = rs.getInt("rank");
							name = rs.getString("name");
							jname = rs.getString("jname");
							kor = rs.getInt("kor");
							eng = rs.getInt("eng");
							mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.printf("%d\t%s\t%s\t%d\t%d\t%d\t%d\n", rank, name, jname, kor, eng, mat, sum);
							
							
						}while(rs.next());
					}else {
						System.out.println("����");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}finally {
					try {
						if(rs != null)
							rs.close();
						if(pstmt != null)
							pstmt.close();
						if(conn != null)
							conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
				
				
				
				break;
				
			case "3":
//				System.out.println("��ü ���");
				sql = "SELECT ROWNUM RANK, S.*" + 
						"    FROM (SELECT NAME||'('||NO||'��)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
						"            FROM PERSON P, JOB J" + 
						"            WHERE P.JNO = J.JNO" + 
						"            ORDER BY SUM DESC) S";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
						System.out.println("rank\t�̸�\t\t����\t����\t����\t����\t����");
						do {
							int rank = rs.getInt("rank");
							name = rs.getString("name");
							jname = rs.getString("jname");
							kor = rs.getInt("kor");
							eng = rs.getInt("eng");
							mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.printf("%d\t%s\t%s\t%d\t%d\t%d\t%d\n", rank, name, jname, kor, eng, mat, sum);
						} while(rs.next());
					}else {
						System.out.println("�Էµ� ����� �����ϴ�");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						if(rs != null)
							rs.close();
						if(pstmt != null)
							pstmt.close();
						if(conn != null)
							conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
				break;

			}
		}while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		sc.close();
		System.out.println("����");
	}
}