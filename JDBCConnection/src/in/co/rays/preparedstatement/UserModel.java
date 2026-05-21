package in.co.rays.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
	
	
	
	public int nextPK() throws ClassNotFoundException, SQLException {
		
		Connection conn = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		
		int pk = 0;
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}

		return pk + 1;
	}
		
		
		
		
		
	

	public void add(UserBean bean) throws ClassNotFoundException, SQLException {

		Connection conn = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("Insert into st_user values (?,?,?,?)");

		pstmt.setInt(1, nextPK());
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getLoginId());
		pstmt.setString(4, bean.getPassword());

		int i = pstmt.executeUpdate();

		System.out.println("Data successfully insert " + i + " row affected");

		conn.close();

	}

	public void update(UserBean bean) throws ClassNotFoundException, SQLException {

		Connection conn = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update st_user set name=? ,loginId=?,password=? where id=?");

		pstmt.setString(1, bean.getName());
		pstmt.setString(2, bean.getLoginId());
		pstmt.setString(3, bean.getPassword());
		pstmt.setInt(4, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("Data Update successfully" + i + "row affected");
	}

	public void delete(UserBean bean) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");
		pstmt.setInt(1, bean.getId());
		int i = pstmt.executeUpdate();

		System.out.println("Record deleted successfully" + i + "=row affected");

	}

	public List search(UserBean bean) throws Exception {

		Connection conn = null;
		List list = new ArrayList();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("select * from st_user");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setLoginId(rs.getString(3));
				bean.setPassword(rs.getString(4));
				list.add(bean);
			}
	
		} catch (Exception e) {
		
			e.printStackTrace();
		
		}

		conn.close();
		return list;

	}

}
