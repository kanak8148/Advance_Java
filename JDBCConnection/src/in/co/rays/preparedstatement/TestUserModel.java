package in.co.rays.preparedstatement;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	
	
	public static void main(String[] args) throws Exception {
		
		testadd();
		//testupdate();
		//testdelete();
		//testSearch();
		
		
	}

	public static void testSearch() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		List list = model.search(bean);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println("--------------");
		}

		
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
		
		
	
		bean.setName("dfghjkl");
		bean.setLoginId("abcdfghjkl@gm,ail.com");
		bean.setPassword("asdfghjklbc");
		
		 model.add(bean);
		
		
		
		
	}

}
