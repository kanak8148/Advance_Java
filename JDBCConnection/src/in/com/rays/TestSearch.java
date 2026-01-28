package in.com.rays;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSearch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		// Make connection to the Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		// Create Statement
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from st_user");

		while (rs.next()) {
			System.out.printf("| %-3d | %-10s | %-10s | %-20s | %-12s | %-10s |%n", rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));

		}

		conn.close();

	}

}
