package com.lec.ex02_customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static CustomerDAO INSTANCE;
	public static CustomerDAO getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new CustomerDAO();
		}
		return INSTANCE;
	}
	
	private CustomerDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	
	public int insertCustomer(CustomerDTO dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER VALUES (CUSTOMER_ID_SQ.NEXTVAL, ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url,"scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPhone());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getPoint());
			result = pstmt.executeUpdate();
			
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
		return result;
		
	}
	
	public ArrayList<CustomerDTO> selectSearchPhone(String searchPhone){
		ArrayList<CustomerDTO> dtos = new ArrayList<CustomerDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE PHONE LIKE '%' || ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String phone = rs.getString("phone");
				String name  = rs.getString("name");
				int    point    = rs.getInt("point");
				dtos.add(new CustomerDTO(id, phone, name, point));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
				if(rs != null)
					rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return dtos;
		
	}
	
	public ArrayList<CustomerDTO> selectAll() {
		ArrayList<CustomerDTO> dtos = new ArrayList<CustomerDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
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
				dtos.add(new CustomerDTO(id, phone, name, point)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return dtos;
		
		
	}
	
}
