package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 모델링 - DB테이블을 자바 클래스로 똑같이 만드는 행위
public class DBEx05 {

	public static void main(String[] args) {

		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			String sql = "SELECT deptno,dname,loc FROM dept";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			List<Dept> depts = new ArrayList<>();
			while (rs.next()) {
				Dept dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				depts.add(dept);
			}

			// for each문 사용해서 출력
			for (Dept dept : depts) {
				System.out.println("deptno : " + dept.getDeptno());
				System.out.println("dname : " + dept.getDname());
				System.out.println("loc : " + dept.getLoc());
				System.out.println("==========");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
