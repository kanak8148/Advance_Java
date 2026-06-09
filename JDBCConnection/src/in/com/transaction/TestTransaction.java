package in.com.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransaction {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("insert into st_user values(69, 'Suresh', 'Yadav')");

		
			conn.commit();
			System.out.println("transaction coplited:(records saved)");

			conn.close();
			stmt.close();

		} catch (Exception e) {
			 conn.rollback();
			e.printStackTrace();
		}
	}
}
