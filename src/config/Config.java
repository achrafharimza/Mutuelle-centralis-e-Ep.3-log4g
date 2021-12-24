package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import daoImpl.ChartDaoImpl;

public class Config {
/////////////////////////////
static Logger log = Logger.getLogger(Config.class.getName());

//////////////////////
	
	private static String databaseName ="breif";
	private static String url = "jdbc:mysql://localhost:3306/"+databaseName;
	
	
	
	
	 
	    private static String user = "root" ;
	    private static String passwd = "admin";
	    private static Connection connect;

	    public static Connection getInstance(){
	        if(connect == null){
	            try {
	                connect = DriverManager.getConnection(url, user, passwd);
	                log.info("data base connected successfully");
	            } catch (SQLException e) {
	            	log.debug("data base connected failde");
	                e.printStackTrace();
	            }
	        }
	        return connect;
	    }
	
	

}
