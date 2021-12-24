package JunitTesting;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;


import org.junit.jupiter.api.Test;


import daoImpl.UserDaoImpl;
import helpers.bcrypt;
import models.User;

class TestLogin {


	
	@Test
	public void testlogin()       {
	 
		UserDaoImpl UserDaoImpl = new UserDaoImpl();
		
		 User user=new models.User("admin@gmail.com", bcrypt.hashing("admin"));
    	 
		 boolean flag= UserDaoImpl.login(user);
		
		
		
		
		
		assertEquals(true,flag);
	
	
	}
	
	
	
	
	
	
	
}
