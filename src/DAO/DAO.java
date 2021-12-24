package DAO;

import java.sql.Connection;
import java.util.List;

import config.Config;
import models.ChartClient;
import models.Client;
import models.User;

public abstract class DAO <T> {
	
	public Connection connection = Config.getInstance();
	
	
	//////USER
	public abstract boolean login (T obj);
	
	public abstract int inscription (T obj);
	
	//////Client
	

	
	public abstract int  add (T obj);
	
	public abstract List<T> afiicher();
	
	public abstract int  CountmMnth (T obj);
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
