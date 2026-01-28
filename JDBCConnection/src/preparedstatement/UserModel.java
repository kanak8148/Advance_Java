package preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserModel {

	ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");

	String driver = rb.getString("driver");
	String url = rb.getString("url");
	String username = rb.getString("username");
	String password = rb.getString("password");

	public int nextPK() throws ClassNotFoundException, SQLException {

		int pk = 0;
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = conn.prepareStatement("select max(id)from st_user");

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);

		}

		return pk + 1;

	}

	// ADD Method
	public void add(UserBean bean) throws SQLException {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);

			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(? ,? ,? ,? ,? ,?)");
			pstmt.setInt(1, nextPK());
			pstmt.setString(2, bean.getFirstname());
			pstmt.setString(3, bean.getLastname());
			pstmt.setString(4, bean.getLogin());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			int i = pstmt.executeUpdate();

			System.out.println(i + "row affected(records inserted...)");
			conn.commit();
			conn.close();

		} catch (Exception e) {
			conn.rollback();

		}

	}
	// update Method

	public void update(UserBean bean) throws Exception {

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_user set firstName = ? ,lastName = ?,login = ?,password = ?,dob = ? where id = ?");

		pstmt.setString(1, bean.getFirstname());
		pstmt.setString(2, bean.getLastname());
		pstmt.setString(3, bean.getLogin());
		pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println(i + "row affected(records updated....)");
		conn.close();
		pstmt.close();

	}
	// delete Method

	public void delete(UserBean bean) throws Exception {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = conn.prepareStatement("delete From st_user where id = ?");

		pstmt.setInt(1, bean.getId());
		int i = pstmt.executeUpdate();
		System.out.println(i + "row affected(records deleted..)");

		conn.close();
		pstmt.close();
	}

	public UserBean findByLogin(String login) throws Exception {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where login = ?");

		pstmt.setString(1, login);
		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLogin(rs.getString(5));
			bean.setPassword(rs.getString(6));
			bean.setDob(rs.getDate(6));
		}
		conn.close();
		pstmt.close();
		return bean;

	}

}
