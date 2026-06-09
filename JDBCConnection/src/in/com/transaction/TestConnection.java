package in.com.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnection {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		ResourceBundle rb = ResourceBundle.getBundle("in.com.transaction.app");

		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String username = rb.getString("username");
		String password = rb.getString("password");

		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url, username, password);

System.out.println("conecction sucessfully");
	
		
		
	}
	
}

