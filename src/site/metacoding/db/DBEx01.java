package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBEx01 {

	public static void main(String[] args) {
		// 1. connection 연결 (세션생성) port, ip, id, password, protocol
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB연결완료");
			// 2. 버퍼 달아서 통신 (SELECT * FROM emp)
			String sql = "SELECT empno,ename FROM emp"; // 쿼리 끝에 ; 필요없음.
			PreparedStatement pstmt = conn.prepareStatement(sql); // 버퍼에담기
			ResultSet rs = pstmt.executeQuery(); // SELECT쿼리 실행
			// pstmt.executeUpdate(); // INSERT,UPDATE,DELETE쿼리 실행
			// rs.next(); // 커서 한 칸 내리기
			// System.out.println(rs.next());

			while (rs.next()) {
				System.out.println("empno : " + rs.getInt("empno"));
				System.out.println("ename : " + rs.getString("ename"));
				System.out.println("==========");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
