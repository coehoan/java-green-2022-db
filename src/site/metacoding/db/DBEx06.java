package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// insert
public class DBEx06 {

	public static void main(String[] args) {
		// 1. connection ���� (���ǻ���) port, ip, id, password, protocol
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB����Ϸ�");
			// 2. ���� �޾Ƽ� ��� (SELECT * FROM emp)
			String sql = "INSERT INTO userTbl(id, username, password, gender) VALUES(?,?,?,?)"; // ���� ���� ; �ʿ����.
			PreparedStatement pstmt = conn.prepareStatement(sql); // ���ۿ����
			pstmt.setInt(1, 4);
			pstmt.setString(2, "hong");
			pstmt.setString(3, "1234");
			pstmt.setString(4, "��");
			// �����ϸ� row����, �������� -1, �ƹ���ȭ ������ 0 ����
			int rs = pstmt.executeUpdate(); // ���ο� commit�� �������

			if (rs > 0) {
				System.out.println("����"); // 1
			} else {
				System.out.println("����"); // 0
			}
		} catch (Exception e) {
			e.printStackTrace(); // -1
		}

	}

}
