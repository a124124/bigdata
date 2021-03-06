package com.lec.ex01_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

// 입력, 직업별 검색, 전체검색, 콤보박스에 들어갈 직업명 리스트

public class PersonDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static PersonDAO INSTANCE;

	private PersonDAO() {
		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public static PersonDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonDAO();

		}
		return INSTANCE;
	}

	// 1. 입력
	public int insertPerson(PersonDTO dto) {
		int result = FAIL;
		// 로직 수행
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON\r\n" + "    VALUES (PERSON_NO_SQ.NEXTVAL, ?, (SELECT JNO"
				+ "                                                FROM JOB"
				+ "                                                WHERE JNAME = ?), ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return result;
	}
	
	// 2. 직업별 출력
	
	public ArrayList<PersonDTO> selectJname(String jname){
		ArrayList<PersonDTO> dtos = new ArrayList<PersonDTO>();
		// 로직 수행
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, S.*" + 
				"    FROM (SELECT NAME||'('||NO||'번)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
				"                FROM PERSON P, JOB J" + 
				"                WHERE P.JNO = J.JNO AND JNAME = ?" + 
				"                ORDER BY SUM DESC) S";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new PersonDTO(rank, name, jname, kor, eng, mat, sum));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return dtos;
	}
	
	// 3. 전체 출력
	
	public ArrayList<PersonDTO> selectAll(){
		ArrayList<PersonDTO> dtos = new ArrayList<PersonDTO>();
		// 로직 수행
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, S.*" + 
				"    FROM (SELECT NAME||'('||NO||'번)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
				"            FROM PERSON P, JOB J" + 
				"            WHERE P.JNO = J.JNO" + 
				"            ORDER BY SUM DESC) S";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String name = rs.getString("name");
				String jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new PersonDTO(rank, name, jname, kor, eng, mat, sum));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return dtos;
	}
	
	// 4. 직업명 리스트 
	
	public Vector<String> jnamelist() {
		Vector<String> jnames = new Vector<String>();
		jnames.add("");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT JNAME" + 
				"    FROM JOB" + 
				"    ORDER BY JNO";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jnames.add(rs.getString("jname"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return jnames;
	}
	
}
