package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import DAO.DAO;

import models.ChartClient;


public class ChartDaoImpl extends DAO <ChartClient> {
	
/////////////////////////////
static Logger log = Logger.getLogger(ChartDaoImpl.class.getName());

//////////////////////
	@Override
	public int CountmMnth(ChartClient ChartClient) {
		
		
		int month=ChartClient.getMounthof();
		int NbrInscInt = 0;
	
		try {
			PreparedStatement preparedStatement =this.connection.prepareStatement("SELECT COUNT(*) as CountMonth  FROM breif.clients where MONTH(DateInscription)="+month+";");
		
			
			 ResultSet results = preparedStatement.executeQuery();
			
			 
			 while(results.next()){
			
				 NbrInscInt =Integer.parseInt(results.getString("CountMonth"));
				    }

			 log.info("query executed successfully");
	         return NbrInscInt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.debug("query executed failde");
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean login(ChartClient obj) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public int inscription(ChartClient obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(ChartClient obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ChartClient> afiicher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChartClient> filter(String table, String searsh) {
		// TODO Auto-generated method stub
		return null;
	}




}
