package in.com.rays;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays" , "root" ,"root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("delete from class where id=1");
		
		System.out.println(i + "row affected...(record delected)");
		
		conn.close();
	}
		
		
	}
	
	

