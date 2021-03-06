package com.lect.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class StudentDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static StudentDAO INSTANCE;

	public static StudentDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new StudentDAO();

		}
		return INSTANCE;
	}

	private StudentDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}


//////////////////////////////////////////////////////////////////////////////
	// 1. 학번 검색
	public ArrayList<StudentDTO> selectSearchSNo(String searchSNo) {
		ArrayList<StudentDTO> dtos = new ArrayList<StudentDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT *" + 
							"    FROM STUDENT" + 
							"    WHERE SNO LIKE ('%' || ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchSNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String sNo = rs.getString("sNo");
				String sName = rs.getString("sName");
				int mNo = rs.getInt("mNo");
				int score = rs.getInt("score");
				dtos.add(new StudentDTO(sNo, sName, mNo, score));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
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
//////////////////////////////////////////////////////////////////////////////
	// 2. 이름 검색
	public ArrayList<StudentDTO> selectSearchSName(String searchSName) {
		ArrayList<StudentDTO> dtos = new ArrayList<StudentDTO>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT *" + 
						"    FROM STUDENT" + 
						"    WHERE SNAME = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchSName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String sNo = rs.getString("sNo");
				String sName = rs.getString("sName");
				int mNo = rs.getInt("mNo");
				int score = rs.getInt("score");
				dtos.add(new StudentDTO(sNo, sName, mNo, score));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			try {
				if (rs != null)
					rs.close();
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
//////////////////////////////////////////////////////////////////////////////
	// 3. 전공 검색
	public ArrayList<StudentDTO> selectSearchMName(String searchMName) {
		ArrayList<StudentDTO> dtos = new ArrayList<StudentDTO>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT ROWNUM RANK, A.*" + 
				"    FROM (SELECT SNAME||'('||SNO||')' NAME, MNAME||'('||M.MNO||')' MNAME, SCORE" + 
				"        FROM STUDENT S, MAJOR M" + 
				"        WHERE S.MNO=M.MNO and mname=?" + 
				"        ORDER BY SCORE DESC) A ";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchMName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dtos.add(new StudentDTO(rank, sName, mName, score));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
		}
		return dtos;
	}
	
	
	
	public Vector<String> majorList(){
		Vector<String> mNames = new Vector<String>();
		mNames.add("");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, A.*" + 
				"    FROM (SELECT SNAME||'('||SNO||')' NAME, MNAME||'('||M.MNO||')' MNAME, SCORE" + 
				"        FROM STUDENT S, MAJOR M" + 
				"        WHERE S.MNO=M.MNO " + 
				"        ORDER BY SCORE DESC) A ";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mNames.add(rs.getString("mname"));
			}
		} catch (Exception e) {
			// TODO: handle exception
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
		return mNames;
	}
//////////////////////////////////////////////////////////////////////////
	// 4. 학생 정보 입력
	public int insertStudent(StudentDTO dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES" + "(TO_CHAR(SYSDATE, 'YYYY')"
				+ "||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL,?))," + "?,(SELECT mNO FROM MAJOR WHERE mNAME=?), ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getsNo());
			pstmt.setString(2, dto.getsName());
			pstmt.setString(3, dto.getmName());
			pstmt.setInt(4, dto.getScore());
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
//////////////////////////////////////////////////////////////////////////
	// 5. 학생 정보 수정
	public int updateStudent(StudentDTO dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT" + 
				"    SET SNAME = ?, MNO = ?, SCORE = ?, SEXPEL = 0" + 
				"    WHERE SNO = '2021001'";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getmName());
			pstmt.setInt(2, dto.getmNo());
			pstmt.setInt(3, dto.getScore());
			result = pstmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return result;
	}
	

//////////////////////////////////////////////////////////////////////////
	// 6. 학생 출력
	public ArrayList<StudentDTO> selectAll() {
		ArrayList<StudentDTO> dtos = new ArrayList<StudentDTO>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT ROWNUM RANK, A.*" + 
				"    FROM (SELECT SNAME||'('||SNO||')' NAME, MNAME||'('||M.MNO||')' MNAME, SCORE" + 
				"        FROM STUDENT S, MAJOR M" + 
				"        WHERE S.MNO=M.MNO and SEXPEL = 0" + 
				"        ORDER BY SCORE DESC) A ";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dtos.add(new StudentDTO(rank, sName, mName, score));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			try {
				if (rs != null)
					rs.close();
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
//////////////////////////////////////////////////////////////////////////
	// 7. 제적자 출력	
	public ArrayList<StudentDTO> selectEAll() {
		ArrayList<StudentDTO> dtos = new ArrayList<StudentDTO>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT ROWNUM RANK, A.*" + 
				"    FROM (SELECT SNAME||'('||SNO||')' NAME, MNAME||'('||M.MNO||')' MNAME, SCORE" + 
				"        FROM STUDENT S, MAJOR M" + 
				"        WHERE S.MNO=M.MNO AND SEXPEL = 1" + 
				"        ORDER BY SCORE DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String sNo = rs.getString("sNo");
				String sName = rs.getString("sName");
				int mNo = rs.getInt("mNo");
				int score = rs.getInt("score");
				dtos.add(new StudentDTO(sNo, sName, mNo, score));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			try {
				if (rs != null)
					rs.close();
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
	
//////////////////////////////////////////////////////////////////////////
	// 8. 제적 처리
	public int sNoExpel(String sNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " UPDATE STUDENT" + 
				"    SET SEXPEL = 1" + 
				"    WHERE SNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sNo);
			result = pstmt.executeUpdate(sql);
			
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
		return result;
	}
}
