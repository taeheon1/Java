import java.sql.*;
import java.util.Scanner;

public class Test2 {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 개의 정수를 입력하시오.");
		System.out.print("부서번호 : ");
		int num1 = sc.nextInt();

		System.out.print("급여 : ");
		int num2 = sc.nextInt();

		Connection con = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

			String sql = "select * from employee" + " where dno = ?" + "   and salary > ?";

			pstmt1 = con.prepareStatement(sql); // statement 생성
			pstmt1.setInt(1, num1);
			pstmt1.setInt(2, num2);

			rs = pstmt1.executeQuery(); // select는 데이터가 1개가 나오든 여러개가 나오든 executeQuery 사용
			System.out.println("사원번호\t사원이름\t급여\t부서번호");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			while (rs.next()) {

				String sEno = rs.getString("eno");
				String sEname = rs.getString("ename");
				int nSalary = rs.getInt("salary");
				String sDno = rs.getString("dno");

				System.out.print(sEno + "\t\t");
				System.out.print(sEname + "\t\t");
				System.out.print(nSalary + "\t\t");
				System.out.print(sDno + "\n");
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