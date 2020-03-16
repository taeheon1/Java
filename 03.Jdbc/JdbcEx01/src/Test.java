import java.sql.*;

public class Test {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

			String sql = "select a.시도,a.시군구,a.법정동명 from (select 시도,시군구,법정동명, count(법정동명)as \"구별수\" from zipcode where 시도 = '서울특별시' or 시도 = '인천광역시' group by 시도, 시군구, 법정동명) A,"
					+ "		(select 법정동명, count(법정동명) as \"총수\" from zipcode where 시도 = '서울특별시' or 시도 = '인천광역시' group by 법정동명) B"
					+ "	where a.법정동명 = b.법정동명 and 총수 > 구별수 order by 법정동명";

			pstmt1 = con.prepareStatement(sql); // statement 생성
			rs = pstmt1.executeQuery(); // select는 데이터가 1개가 나오든 여러개가 나오든 executeQuery 사용
			System.out.println("시도\t\t시군구\t\t법정동명");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			while (rs.next()) {
				System.out.println(rs.getString("시도") + "\t\t" + rs.getString("시군구") + "\t\t" + rs.getString("법정동명"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt1 != null)
					pstmt1.close();
				if (con != null)
					con.close();
			} catch (SQLException sqle) {
			}
		}

	}

}
