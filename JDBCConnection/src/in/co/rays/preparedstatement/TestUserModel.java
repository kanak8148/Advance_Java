package in.co.rays.preparedstatement;

import java.sql.SQLException;

public class TestUserModel {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//testadd();
		//testupdate();
		testdelete();
	
		
		
		
		
	}

	private static void testdelete() throws ClassNotFoundException, SQLException {
	
		UserBean bean = new  UserBean ();
		UserModel model = new UserModel();
		bean.setId(1);
		model.delete(bean);
	}

	private static void testupdate() throws ClassNotFoundException, SQLException {
		
		UserBean bean = new  UserBean ();
		UserModel model = new UserModel();
		bean.setId(1);
		bean.setName("Karishma");
		bean.setLoginId("abc@gm,ail.com");
		bean.setPassword("abc1234");
		
		model.update(bean);
		
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
