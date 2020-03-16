import java.sql.*;

public class Testjdbc {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String sRtn = selectQuery("이순신" , "0000");
		System.out.println(sRtn);
	}

	public static String selectQuery(String param1, String param2) {
		Connection conn = null;
		PreparedStatement pstmt = null; // 오라클에서 구문분석을 안함 SQL문이 바뀌면 구문 분석을 함, Statement는 구문분석을 함
		ResultSet rs = null;
		String sReturn = "";

		try {
			String jdbc_driver = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(jdbc_driver, "scott", "tiger");

			String sql = "SELECT * FROM test3 WHERE id = ?"
	                     + "  and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, param1);
			pstmt.setString(2, param2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print("id : " + rs.getString("id"));
				sReturn += rs.getString("password");
				System.out.println(", password : " + sReturn);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException sqle) {
			}
		}
		return sReturn;
	}
}
/*
 *  1. 드라이버 로드
 *  2. Connection(접속) 
 *  3. Statement 생성(프리페이드 스테이트먼트 포함) 
 *  4. SQL문을 만들고
 *     Statement.executeQuery < -ResultSet 이 있을때 
 *     Statement.executeUpdate 
 *  5. ResultSet 클로즈 
 *  6. Statement 클로즈 
 *  7. Connection 클로즈
 */