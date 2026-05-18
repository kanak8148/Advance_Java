package in.co.rays.preparedstatement;

import java.sql.SQLException;

public class TestUserModel {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		testadd();
	
		
		
		
		
	}

	private static void testadd() throws ClassNotFoundException, SQLException {
		
		UserBean bean = new  UserBean ();
		UserModel model = new UserModel();
		
		
		bean.setId(1);
		bean.setName("prashant");
		bean.setLoginId("abc@gm,ail.com");
		bean.setPassword("abc");
		
		 model.add(bean);
		
		
		
		
	}

}
