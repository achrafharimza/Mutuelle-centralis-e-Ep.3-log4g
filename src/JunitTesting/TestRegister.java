package JunitTesting;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;


import DAO.daoUser;
import daoImpl.UserDaoImpl;
import models.User;

class TestRegister {

	@Test
	void testRegistreF() {
		UserDaoImpl UserDaoImpl = new UserDaoImpl();
		
		

        
        

		
		
		 User user=new models.User("JUNIT", "JUNIT", "JU1234567", "063456789", "JUNIT@GMAIL.COM", "JUNIT", "JUNIT");
		
		
		 int flag= UserDaoImpl.inscription(user);
		
		assertEquals(1,flag);
		
	}

}
