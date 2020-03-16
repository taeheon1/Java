import java.sql.*;

public class CallableStatementEx {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null; // 오라클에서 구문분석을 안함 SQL문이 바뀌면 구문 분석을 함, Statement는 구문분석을 함
		CallableStatement cstmt = null; // 프로시저 호출
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

			System.out.println("----- 프로시저 호출 전 salary 테이블 -----");
			String sql = "SELECT name, pay FROM salary";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("name : " + rs.getString(1));
				System.out.println(", pay : " + rs.getInt(2));
			}
			System.out.println("--------------------------------------------------");
			cstmt = con.prepareCall("{call adjust(?, ?)}");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cstmt.setString(1, rs.getString("name"));
				cstmt.setFloat(2, (float) 0.05);
				cstmt.executeUpdate();
			}

			System.out.println("----- 프로시저 호출 후 salary 테이블 -----");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("name : " + rs.getString(1));
				System.out.println(", pay : " + rs.getInt(2));
			}
			System.out.println("--------------------------------------------------");

		} catch (SQLException sqle) {
			System.out.println("Connection Error");
			sqle.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException sqle) {
			}
		}
	}
}