import java.sql.*;

public class Main {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			Statement stmt = con.createStatement();

			// --------------------------------------------------
			StringBuffer sb = new StringBuffer();
			sb.append("CREATE TABLE test1 (    ");
			sb.append("       id varchar2(10), ");
			sb.append("       age number )    ");

			int updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("createCount : " + updateCount);
			// --------------------------------------------------
			sb.setLength(0); // StringBuffer 초기화
			sb.append("INSERT INTO test1 ");
			sb.append("values ('홍길동', 10)");
			updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("insertCount : " + updateCount);
			// --------------------------------------------------
			sb.setLength(0);
			sb.append("SELECT * FROM test1");
			ResultSet rs = stmt.executeQuery(sb.toString());
			while (rs.next()) {
				System.out.print("id : " + rs.getString(1) + ", ");
				System.out.println("age : " + rs.getString("age"));
			}
			// --------------------------------------------------
			sb.setLength(0);
			sb.append("UPDATE test1 ");
			sb.append("SET id = '전우치', ");
			sb.append("age = 20 ");
			sb.append("WHERE id = '홍길동'");
			updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("updateCount : " + updateCount);
			// --------------------------------------------------
			sb.setLength(0);
			sb.append("SELECT * FROM test1");
			rs = stmt.executeQuery(sb.toString());
			while (rs.next()) {
				System.out.print("id : " + rs.getString(1) + ", ");
				System.out.println("age : " + rs.getString("age"));
			}
			// --------------------------------------------------
			sb.setLength(0);
			sb.append("DELETE FROM test1");
			updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("deleteCount : " + updateCount);
			// --------------------------------------------------
			sb.setLength(0);
			sb.append("DROP TABLE test1");
			updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("dropCount : " + updateCount);
			// -------------------------------------------------
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException sqle) {
			System.out.println("Connection Error");
			sqle.printStackTrace();
		}
	}
}