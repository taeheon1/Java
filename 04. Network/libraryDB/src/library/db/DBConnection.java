package library.db;

import java.sql.Connection;
import java.sql.DriverManager;

class DBConnection {

	private Connection con = null;
	private String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	private String jbdc_url = "jdbc:oracle:thin:@218.50.121.249:1521:orcl";
//	private String jbdc_url = "jdbc:oracle:thin:@192.168.0.2:1521:orcl";

	Connection connect() {
		try {
			Class.forName(jdbc_driver);
			con = DriverManager.getConnection(jbdc_url, "taeh", "0201");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	void disconnect() {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}