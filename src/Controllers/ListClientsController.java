package Controllers;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import DAO.DAO;
import DAO.daoClient;


import factory.DaoFactory;
import helpers.Navigations;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Client;
import javafx.event.ActionEvent;
public class ListClientsController implements Initializable {

	 @FXML
	    private TableColumn<Client, String> Adresse;

	    @FXML
	    private TableColumn<Client, String> CNIPassportT;

	    @FXML
	    private TableColumn<Client, String> DateDebut;

	    @FXML
	    private TableColumn<Client, String> EmailT;

	    @FXML
	    private TableColumn<Client, String> Nbadge;

	    @FXML
	    private TableColumn<Client, String> NomT;

	    @FXML
	    private TableColumn<Client, String> NomEntreprise;

	    @FXML
	    private TableColumn<Client, String> Phone;

	    @FXML
	    private TableColumn<Client, String> PrenomT;

	    @FXML
	    private TableView<Client> TableofClient;
	    
	    @FXML
	    private TextField filterField;
	    
	    @FXML
	    private Button ChartButt;
	    @FXML
	    private Button ListeClients;

	    @FXML
	    private Button QuitterButton;
	    
	    @FXML
	    private ToggleGroup recherche;
	    @FXML
	    private RadioButton Prenom;

	    @FXML
	    private RadioButton Nom;
	    @FXML
	    private RadioButton Email;

	    @FXML
	    private RadioButton IdentificationNumt;
	   
/////////////////////////////
static Logger log = Logger.getLogger(ListClientsController.class.getName());

//////////////////////

		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			

//			
			
			DAO <Client> daoClient=DaoFactory.getClientImpl();
	         
	       
			
			
		
				
				
				 ObservableList<Client> list = FXCollections.observableArrayList(daoClient.afiicher());
				 
				
				 log.info("Client list show successfully "); 
					 
		          
				 
		   
		    	 PrenomT.setCellValueFactory(new PropertyValueFactory<Client,String>("Prenom"));
		    	 NomT.setCellValueFactory(new PropertyValueFactory<Client,String>("Nom"));
		    	 NomEntreprise.setCellValueFactory(new PropertyValueFactory<Client,String>("NomEntreprise"));
		    	 CNIPassportT.setCellValueFactory(new PropertyValueFactory<Client,String>("CNIPassport"));
		    	 EmailT.setCellValueFactory(new PropertyValueFactory<Client,String>("Email"));
		    	 Nbadge.setCellValueFactory(new PropertyValueFactory<Client,String>("Nbadge"));
		    	 Adresse.setCellValueFactory(new PropertyValueFactory<Client,String>("Adresse"));
		    	 Phone.setCellValueFactory(new PropertyValueFactory<Client,String>("Phone"));
		    	 DateDebut.setCellValueFactory(new PropertyValueFactory<Client,String>("DateDebut"));
		    	
		    	 TableofClient.setItems(list);
		    	
		    	 //////////////////////////////////

		    	 
		    	 


		    	 
		    	           }  
		///////////////////////
   	 @FXML
	    void filtre(ActionEvent  event) {
   		 System.out.println("hollaa");
   		 
			DAO <Client> daoClient=DaoFactory.getClientImpl();
			String check="";
			
	
	    	if (Prenom.isSelected()) {
				check = "Prenom";
				
			} else if (Nom.isSelected()) {
				check = "Nom";
			
			} else if (Email.isSelected()) {
				check = "Email";
				
			} else if (IdentificationNumt.isSelected()) {
				check = "IdentificationNum";
			} else {
	    		check = "all";
			}
	       
			
			
		
				
				
				 ObservableList<Client> listf = FXCollections.observableArrayList(daoClient.filter(check,filterField.getText()));
				 
				
				 log.info("Client list filtre show successfully "); 
					 
		          
				 
		   
		    	 PrenomT.setCellValueFactory(new PropertyValueFactory<Client,String>("Prenom"));
		    	 NomT.setCellValueFactory(new PropertyValueFactory<Client,String>("Nom"));
		    	 NomEntreprise.setCellValueFactory(new PropertyValueFactory<Client,String>("NomEntreprise"));
		    	 CNIPassportT.setCellValueFactory(new PropertyValueFactory<Client,String>("CNIPassport"));
		    	 EmailT.setCellValueFactory(new PropertyValueFactory<Client,String>("Email"));
		    	 Nbadge.setCellValueFactory(new PropertyValueFactory<Client,String>("Nbadge"));
		    	 Adresse.setCellValueFactory(new PropertyValueFactory<Client,String>("Adresse"));
		    	 Phone.setCellValueFactory(new PropertyValueFactory<Client,String>("Phone"));
		    	 DateDebut.setCellValueFactory(new PropertyValueFactory<Client,String>("DateDebut"));
		    	
		    	 TableofClient.setItems(listf);
   		 
   		 
   		 
   		 
   		 
   		 
   		 

	    }
	 

	 
	 
	 
///////////////////////////////  	 
		
		
		
		
		
		
		/////////////////
		  
		 @FXML
		    void GoToList(ActionEvent event) {
		    	
			  Navigations navigations = new Navigations();
	            navigations.changeScene("ListClients"); 
	            ((Node)(event.getSource())).getScene().getWindow().hide();

		    }
		    	   
		    	////////////////////////////////////////   
		    	   
		    @FXML
		    void GoToGraphe(ActionEvent event) {
		    	 Navigations navigations = new Navigations();
		            navigations.changeScene("ChartPage"); 
		            ((Node)(event.getSource())).getScene().getWindow().hide();
//		    	

		    
		    }
		  	
		    	///////////

		    

		    @FXML
		    void Quitter(ActionEvent event) {
		    	Stage stage =(Stage) QuitterButton.getScene().getWindow();
		    	stage.close();

		    	System.exit(0);
		    }
			
			
			
		}
		
	
		
		
		
	
	
		
		
		
		

