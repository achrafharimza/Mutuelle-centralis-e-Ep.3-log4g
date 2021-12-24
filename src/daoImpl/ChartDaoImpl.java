package daoImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import DAO.DAO;
import DAO.daoChart;
import javafx.scene.chart.Chart;
import models.ChartClient;
import models.Client;

public class ChartDaoImpl extends DAO <ChartClient> {
	
/////////////////////////////
static Logger log = Logger.getLogger(ChartDaoImpl.class.getName());

//////////////////////
	@Override
	public int CountmMnth(ChartClient ChartClient) {
		
	
		try {
			PreparedStatement preparedStatement =this.connection.prepareStatement("SELECT COUNT(*) as CountMonth  FROM breif.clients where MONTH(DateInscription)="+ChartClient.getMounthof()+";");
		
			
			 int resultSet = preparedStatement.executeUpdate();
			 log.info("query executed successfully");
	         return resultSet;
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




}
