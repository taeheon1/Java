import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JDBC 2.0 : excuteBatch()
// INSERT, UPDATE, DELETE, CREATE, DROP, ALTER 등에서만 사용할 수 있다.
// 여러개의 CRUD의 커밋을 한번만 할라고 씀
public class BatchInsertEx {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean commit = false;

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

			stmt = con.createStatement();
			sql = "create table test4 (id varchar2(10), password varchar2(10))";
			stmt.executeUpdate(sql);

			con.setAutoCommit(false);

			stmt.addBatch("INSERT INTO test4 VALUES('홍길동', '1111')");
			stmt.addBatch("INSERT INTO test4 VALUES('전우치', '2222')");
			stmt.addBatch("INSERT INTO test4 VALUES('손오공', '3333')");
			stmt.addBatch("INSERT INTO test4 VALUES('이지함', '4444')");
			stmt.addBatch("UPDATE TEST4 SET id = '손오공2' where id = '손오공' ");

			int[] updateCounts = stmt.executeBatch();
			commit = true;
			con.commit();

			rs = stmt.executeQuery("SELECT * FROM test4");
			while (rs.next()) {
				String id = rs.getString("id");
				String password = rs.getString("password");
				System.out.println("id : " + id + ", password : " + password);
			}
			// --------------------------------------------------
			sql = "DROP TABLE test4";
			stmt.executeUpdate(sql);
			System.out.println(updateCounts.length);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if (!commit)
					con.rollback();
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}
}