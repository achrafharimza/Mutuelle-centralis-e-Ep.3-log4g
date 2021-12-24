package JunitTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;


import config.Config;

class TestDBConnect {

	@Test
	void testGetConnection() {
		
		Config DataBConnect =new Config();
		Connection flag = DataBConnect.getInstance();
		assertNotNull(flag);
		
		
		
	}

}
