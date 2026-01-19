package in.com.rays;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCreateTable {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays" , "root" ,"root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("create table class(id int primary key, name varchar(45), school varchar(45))");
		
		System.out.println(i + "table created");
		
		conn.close();
		stmt.close();
		
		
	}

}
