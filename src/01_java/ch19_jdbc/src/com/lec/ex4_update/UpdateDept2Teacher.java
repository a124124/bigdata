package com.lec.ex4_update;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class UpdateDept2Teacher {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �μ���ȣ�� ? ");
		String deptno = scanner.next();
		// �Է��� �ش� �μ���ȣ�� �ִ��� ������ üũ
		String selectSql = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs   = stmt.executeQuery(selectSql);
			if(rs.next()) { // �ش�μ���ȣ�� �����ϴ� ���
				System.out.print("�ٲ� �μ��̸��� ? ");
				String dname = scanner.next();
				System.out.print("�ٲ� �μ� ��ġ�� ?");
				String loc = scanner.next();
				String updateSql = "UPDATE DEPT SET DNAME='"+dname+"', LOC='"+loc+
							"' WHERE DEPTNO="+deptno;
				int result = stmt.executeUpdate(updateSql); 
				System.out.println(result>0? deptno+"�� �μ� ���� ����":"���� ����");
			}else {
				System.out.println("�ش� �μ���ȣ�� �������� �ʾ� ���� �Ұ��մϴ�");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try { // (7)
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}//try-catch
	}//main
}//class