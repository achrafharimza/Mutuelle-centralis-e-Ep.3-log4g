package factory;

import DAO.DAO;
import DAO.daoUser;
import daoImpl.ChartDaoImpl;
import daoImpl.ClientDaoImpl;
import daoImpl.UserDaoImpl;
import javafx.scene.chart.Chart;
import models.ChartClient;
import models.Client;
import models.User;

public class DaoFactory {
	
	
	
	public static DAO<User> getUserImpl(){
		
        return new UserDaoImpl();
    } 
	
	
	public static DAO<Client> getClientImpl(){
		
        return new ClientDaoImpl();
    } 
	
	
	public static DAO<ChartClient> getChartImpl(){
		
        return new ChartDaoImpl();
    } 
	
	

}
