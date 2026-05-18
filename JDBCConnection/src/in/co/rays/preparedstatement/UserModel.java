package in.co.rays.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserModel {

	public void add(UserBean bean) throws ClassNotFoundException, SQLException {

		Connection conn = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("Insert into st_user values (?,?,?,?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getLoginId());
		pstmt.setString(4, bean.getPassword());

		int i = pstmt.executeUpdate();
		
		System.out.println("Data successfully insert " + i + " row affected");
		
		conn.close();
		
		

	}

}
