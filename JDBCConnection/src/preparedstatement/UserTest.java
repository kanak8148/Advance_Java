package preparedstatement;

import java.text.SimpleDateFormat;

public class UserTest {

	public static void main(String[] args) throws Exception {

		testAdd();

	}

	public static void testAdd() throws Exception  {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setFirstname("kanak");
		bean.setLastname("soni");
		bean.setLogin("kanak@gmail.com");
		bean.setPassword("kanak1234");
		bean.setDob(sdf.parse("2005-09-24"));
		
		model.add(bean);

	}
	
	

} 
