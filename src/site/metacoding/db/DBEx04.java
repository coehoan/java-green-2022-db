package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// SQL injection ���� ��� (SQL ���� ����)
// password�� ���� �α����� �����ϴ�.
public class DBEx04 {

	public static void login(String username, String password) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB����Ϸ�");

			String sql = "SELECT * FROM userTbl WHERE username =  " + username + " AND password = " + password;
			Statement pstmt = conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				Session.isLogin = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		login("'ssar'", "'12345333' OR 1=1");

		System.out.println(Session.isLogin);
	}

}