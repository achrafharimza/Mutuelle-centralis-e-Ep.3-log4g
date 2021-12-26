package daoImpl;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import DAO.DAO;
import DAO.daoUser;

import models.User;

public class UserDaoImpl extends DAO <User> {
	
/////////////////////////////
static Logger log = Logger.getLogger(UserDaoImpl.class.getName());

//////////////////////
	@Override
	public int inscription(User user) {

		try {

			PreparedStatement preparedStatement =this.connection.prepareStatement("INSERT INTO breif.fonctionnaires (firstname,lastname ,password,cin,email,phone,entity) VALUES (?, ?, ?,?, ?, ?,?);");
             preparedStatement.setString(1, user.getFirstname());
	         preparedStatement.setString(2, user.getLastname());
	         preparedStatement.setString(3, user.getPasswordID());
	         preparedStatement.setString(4, user.getCin());
	         preparedStatement.setString(5, user.getEmailId());
	         preparedStatement.setString(6, user.getPhone());
	         preparedStatement.setString(7, user.getEntity());
			
			 int resultSet = preparedStatement.executeUpdate();
			 log.info("query executed successfully");
	         return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("query executed failde");
			return 0;
		}
		
	}
	//////////
	
	
	@Override
	public boolean login(User user) {
		
		try  {
		
				

	            

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM breif.fonctionnaires WHERE email = ? and password = ?");
	            preparedStatement.setString(1, user.getEmailId());
	            preparedStatement.setString(2, user.getPasswordID());

	           

	            ResultSet resultSet = preparedStatement.executeQuery();
	            log.info("query executed successfully");
	            if (resultSet.next()) {
	                return true;
	            }


	        } catch (SQLException e) {
	            // print SQL exception information
	        	log.debug("query executed failde");
	        	e.printStackTrace();
	        }
		
		
		
		return false;
	}
	@Override
	public int add(User obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<User> afiicher() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int CountmMnth(User obj) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<User> filter(String table, String searsh) {
		// TODO Auto-generated method stub
		return null;
	}




	
	
	
	
	
	
	
	
	
	
	
	
////////////////////////////
}
