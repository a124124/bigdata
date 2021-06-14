package com.lec.ex02_customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOteacher {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL    = 0;
	private static CustomerDAOteacher INSTANCE;
	public static CustomerDAOteacher getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new CustomerDAOteacher();
		}
		return INSTANCE;
	}
	private CustomerDAOteacher() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// �Է�
	public int insertCustomer(CusTomerDTOteacher dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER VALUES (CUSTOMER_ID_SQ.NEXTVAL, ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPhone());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getPoint());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) { }
		}
		return result;
	}
	// ����ȣ ��ȸ
	public ArrayList<CusTomerDTOteacher> selectSearchPhone(String searchPhone){
		ArrayList<CusTomerDTOteacher> dtos = new ArrayList<CusTomerDTOteacher>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM CUSTOMER WHERE PHONE LIKE '%' || ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchPhone);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    id    = rs.getInt("id");
				String phone = rs.getString("phone");
				String name  = rs.getString("name");
				int    point    = rs.getInt("point");
				dtos.add(new CusTomerDTOteacher(id, phone, name, point));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) { }
		}
		return dtos;
	}
	// ��ü ���
	public ArrayList<CusTomerDTOteacher> selectAll(){
		ArrayList<CusTomerDTOteacher> dtos = new ArrayList<CusTomerDTOteacher>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM CUSTOMER";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    id    = rs.getInt("id");
				String phone = rs.getString("phone");
				String name  = rs.getString("name");
				int    point    = rs.getInt("point");
				dtos.add(new CusTomerDTOteacher(id, phone, name, point));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) { }
		}
		return dtos;
	}
}