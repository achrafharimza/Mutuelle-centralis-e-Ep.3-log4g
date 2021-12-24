package JunitTesting;



import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Controllers.Page2Controller;

import daoImpl.ClientDaoImpl;
import daoImpl.UserDaoImpl;
import models.Client;

class TestAjouterClient {

	@Test
	void testAjouter() {
		
		ClientDaoImpl AddClient =new ClientDaoImpl();
		
		Client client= new Client("JUNIT", "JUNIT", "2030-07-31", "JUNIT", "JUNIT", "JU1234567", "063456789", "JUNIT@GMAIL.COM", "JUNIT");
		
		int flag = AddClient.add(client);
		
		
		assertEquals(1,flag);
		
		
		
	}

}
