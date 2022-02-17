package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// insert
public class DBEx06 {

	public static void main(String[] args) {
		// 1. connection 연결 (세션생성) port, ip, id, password, protocol
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB연결완료");
			// 2. 버퍼 달아서 통신 (SELECT * FROM emp)
			String sql = "INSERT INTO userTbl(id, username, password, gender) VALUES(?,?,?,?)"; // 쿼리 끝에 ; 필요없음.
			PreparedStatement pstmt = conn.prepareStatement(sql); // 버퍼에담기
			pstmt.setInt(1, 4);
			pstmt.setString(2, "hong");
			pstmt.setString(3, "1234");
			pstmt.setString(4, "남");
			// 성공하면 row개수, 에러나면 -1, 아무변화 없으면 0 리턴
			int rs = pstmt.executeUpdate(); // 내부에 commit을 들고있음

			if (rs > 0) {
				System.out.println("성공"); // 1
			} else {
				System.out.println("실패"); // 0
			}
		} catch (Exception e) {
			e.printStackTrace(); // -1
		}

	}

}
