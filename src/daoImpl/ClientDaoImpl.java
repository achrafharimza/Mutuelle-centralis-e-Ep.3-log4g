package daoImpl;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import DAO.DAO;
import DAO.daoClient;
import models.ChartClient;
import models.Client;
import models.User;

public class ClientDaoImpl extends DAO <Client> {
	
/////////////////////////////
static Logger log = Logger.getLogger(ClientDaoImpl.class.getName());

//////////////////////
	
	@Override
	public  int add(Client client) {
	
		String DateInscription = java.time.LocalDate.now().toString();
		String DateDebut = client.getDateDebut().toString();
		try {
			PreparedStatement preparedStatement =this.connection.prepareStatement("INSERT INTO breif.clients (Prenom,Adresse,Email ,DateDebut,IdentificationNum,Phone,NomEntreprise,NumBadge,Nom,DateInscription) VALUES (?, ?, ?,?, ?, ?,?,?,?,?);");
			preparedStatement.setString(1, client.getPrenom());
	         preparedStatement.setString(2, client.getAdresse());
	         preparedStatement.setString(3, client.getEmail());
	         preparedStatement.setString(4, DateDebut);
	         preparedStatement.setString(5, client.getCNIPassport());
	         preparedStatement.setString(6, client.getPhone());
	         preparedStatement.setString(7, client.getNomEntreprise());
	         preparedStatement.setString(8, client.getNbadge());
	         preparedStatement.setString(9, client.getNom());
	         preparedStatement.setString(10, DateInscription);
			
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
	public List<Client> afiicher() {
		
		try {
			String query = "select * from breif.clients";
			
			PreparedStatement preparedStatement =this.connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			 log.info("query executed successfully");
			List<Client> clients = new ArrayList<Client>();
            while (resultSet.next()) {
				clients.add(new Client(
						 
						resultSet.getString("NumBadge"),
						resultSet.getString("NomEntreprise"),
						resultSet.getString("DateDebut"),
						 
						resultSet.getString("Prenom"),
						resultSet.getString("Nom"),
						resultSet.getString("IdentificationNum"),
						resultSet.getString("Phone"),
						resultSet.getString("Email"),
						resultSet.getString("Adresse")));
			}
            return clients;
           
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.debug("query executed failde");
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	@Override
	public List<Client> filter(String table ,String searsh) {
		System.out.println(table);
		System.out.println(searsh);
		
		
		
		try {
			String query = "";
			
			if (!table.equals("all")) {
				
				 query = "select * from breif.clients where " +table+" LIKE '"+searsh+"';";
				
				
			}
			
			else {
				
				 query = "select * from breif.clients where NomEntreprise like '"+searsh+"' or IdentificationNum like '"+searsh+"' or Nom like '"+searsh+"' or Prenom like '"+searsh+"' or Email like '"+searsh+"' or NumBadge like '"+searsh+"' or DateInscription like '"+searsh+"';";
				
				
			}
			
			
			
			
			PreparedStatement preparedStatement =this.connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			 log.info("query executed successfully");
			List<Client> clients = new ArrayList<Client>();
            while (resultSet.next()) {
            	System.out.println(resultSet.getString("Phone"));
				clients.add(new Client(
						 
						resultSet.getString("NumBadge"),
						resultSet.getString("NomEntreprise"),
						resultSet.getString("DateDebut"),
						 
						resultSet.getString("Prenom"),
						resultSet.getString("Nom"),
						resultSet.getString("IdentificationNum"),
						resultSet.getString("Phone"),
						resultSet.getString("Email"),
						resultSet.getString("Adresse")));
			}
            return clients;
           
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.debug("query executed failde");
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	

	@Override
	public boolean login(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int inscription(Client obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int CountmMnth(Client obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	





	
	
	


}
