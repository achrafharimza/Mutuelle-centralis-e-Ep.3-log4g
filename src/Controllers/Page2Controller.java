package Controllers;
import java.awt.Component;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import DAO.DAO;
import DAO.daoClient;
import DAO.daoUser;

import factory.DaoFactory;

import helpers.Navigations;
import helpers.bcrypt;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.Printer;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import models.Client;
import models.User;

public class Page2Controller implements Initializable {
	  @FXML
	  private TextArea AdresseC;

	    @FXML
	    private Button Ajouter;

	    @FXML
	    private RadioButton CINC;

	    @FXML
	    private DatePicker DateDébut;

	    @FXML
	    private TextField EmailC;

	    @FXML
	    private ToggleGroup Identification;
	    
	    @FXML
	    private TextField IdentificationNumCP;

	    @FXML
	    private TextField Nbadge;

	    @FXML
	    private TextField NomC;

	    @FXML
	    private TextField NomEntrepriseC;

	    @FXML
	    private RadioButton PasseportC;

	    @FXML
	    private TextField PhoneC;

	    @FXML
	    private TextField PrénomC;
	    
	    @FXML
	    private Label Ladrss;

	    @FXML
	    private Label Lbage;

	    @FXML
	    private Label Ldate;

	    @FXML
	    private Label Lemail;

	    @FXML
	    private Label Lidenti;

	    @FXML
	    private Button ListeClients;

	    @FXML
	    private Label Lnom;

	    @FXML
	    private Label LnomEntr;

	    @FXML
	    private Label Lphone;

	    @FXML
	    private Label Lprenom;
	    
	    @FXML
	    private Label invalidinp;
	    
	    @FXML
	    private ChoiceBox<String> CodePays;
	    @FXML
	    private Button QuitterButton;
	    
	    @FXML
	    private Button ChartButt;
	/////////////////////////////////
	    
	    
/////////////////////////////
static Logger log = Logger.getLogger(Page2Controller.class.getName());

//////////////////////
		
	    
/////////////////////////////////////////////////////////
	    @SuppressWarnings({ "unchecked", "unlikely-arg-type" })
		@FXML
	public    void Ajouter(ActionEvent event) {
	    	
	    	 String regexCin = "[a-zA-Z]{2}\\d{7}";
	         String regexPassport = "[a-zA-Z]{2}\\d{6}";
	         String regexPhone = "[0-9]+";
	         String regexEmail = "^(.+)@(\\S+)$";
	         
	         Pattern cni = Pattern.compile(regexCin);
	         Pattern passport = Pattern.compile(regexPassport);
	         Pattern phone = Pattern.compile(regexPhone);
	         Pattern email = Pattern.compile(regexEmail);
	         
	         Matcher Mcni = cni.matcher(IdentificationNumCP.getText());
	         Matcher Mpassport = passport.matcher(IdentificationNumCP.getText());
	         Matcher Mphone = phone.matcher(PhoneC.getText());
	         Matcher Memail = email.matcher(EmailC.getText());
	         
	    	
	         
	    	 
	     	
	     	
	        

	         
	         
	         Window owner = Ajouter.getScene().getWindow();
	         
	     	
	    	 if (PrénomC.getText().length() > 50 || PrénomC.getText().isEmpty() ) {
		            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Prénom Should not empty ");
		            PrénomC.setText("");
		            return;
		        }
	    	 if (AdresseC.getText().isEmpty()  ) {
		            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Adresse Should not empty ");
		            AdresseC.setText("");
		            return;
		        }
	    	 if (EmailC.getText().isEmpty()|| !Memail.matches()  ) {
		            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Please enter a Valid email ");
		            EmailC.setText("");
		            return;
		        }
	    	 if (DateDébut.getValue()== null ) {
		            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Adresse Should not Date de Début ");
		            DateDébut.setValue(null);
		            return;
		        }
	    	 
	    	 if (PhoneC.getText().isEmpty() || PhoneC.getLength() < 9 || !Mphone.matches()) {
		            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Please enter a Valid Phone number ");
		            PhoneC.setText("");
		            return;
		        }
	    	 
	    	 
	    	 if (NomEntrepriseC.getText().isEmpty() ||(NomEntrepriseC.getText().length() > 10  ) ){
		            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Nom Entreprise  Should not empty");
		            NomEntrepriseC.setText("");
		            return;
		        }
	         
	    	 if (Nbadge.getText().isEmpty() ||Nbadge.getText().length() > 10 ) {
		            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Num badge Should not empty ");
		            Nbadge.setText("");
		            return;
		        }
	         
	    	 if (NomC.getText().length() > 50 || NomC.getText().isEmpty() ) {
		            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Nom Should not empty ");
		            NomC.setText("");
		            return;
		        }
	    	 
	    	 RadioButton selectedRadioButton=(RadioButton) Identification.getSelectedToggle();
	         
	         if (selectedRadioButton ==null) {
	        	 showAlert(Alert.AlertType.ERROR, owner, "Form Error!","*type of identification should be selected ");
		           
		            return; 
	         }
	         if (IdentificationNumCP.getText().isEmpty()  ) {
		            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","CIN/Passeport Should not empty ");
		            
		            return;
		        }
	    	 
	         if (selectedRadioButton.getText().equals("CIN") &&  !Mcni.matches())  {
		            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","CIN should containe two alphabit and 6 digit");
		            IdentificationNumCP.setText("");
		            return;
		        }
	         if (selectedRadioButton.getText().equals("Passeport") &&  !Mpassport.matches())  {
		            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Passeport should containe two alphabit and 7 digit");
		            IdentificationNumCP.setText("");
		            return;
		        }
	         
	        
	         
	    	 
	         String Prenom = PrénomC.getText();
	         String Adresse = AdresseC.getText();
		     String Email = EmailC.getText();
		     String DateDebut = DateDébut.getValue().toString();
		     String IdentificationNum = IdentificationNumCP.getText(); 
	         String Phone = PhoneC.getText();
	         String NomEntreprise = NomEntrepriseC.getText();
	         String NumBadge = Nbadge.getText();
	         String Nom = NomC.getText();
	         
	         
	         
	         
	         
	         
	         Client client= new Client(NumBadge, NomEntreprise, DateDebut, Prenom, Nom, IdentificationNum, Phone, Email, Adresse);
	       
	         DAO <Client> daoClient=DaoFactory.getClientImpl();
	         
	         int flag= daoClient.add(client);
	         
	         
	         
	         
	         
	         
	         if (flag==1) {
	        	 infoBox("saving Successful!", null, "Failed");
	        	 log.info("Client added successfully ");
	     		
	 		} else {
	 			infoBox("error!!data NOT save", null, "Failed");
	 			log.warn("Client added failed");
	 		}
	         
	      
	         
	         
	         
    	

	    }
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
	    	

	    
	    }
	  	
	    	///////////
 
	    

	    @FXML
	    void Quitter(ActionEvent event) {
	    	Stage stage =(Stage) QuitterButton.getScene().getWindow();
	    	stage.close();

	    	System.exit(0);
	    }
	    
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
			JSONParser jsonParser = new JSONParser();
	        try (FileReader reader = new FileReader("CodePays.json"))
	        {

	            Object obj = jsonParser.parse(reader);

	            JSONArray country = (JSONArray) obj;

	            for (Object o : country) {
	                JSONObject country_obj = (JSONObject) o;
	                String country_code = (String) country_obj.get("dial_code");
	                String codel = (String) country_obj.get("name");

	                CodePays.getItems().add(codel+"|"+country_code);
	            }


	        } catch (IOException e) {
	            e.printStackTrace();

	        } catch (org.json.simple.parser.ParseException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
			
			
			
			
		}

		  private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		        Alert alert = new Alert(alertType);
		        alert.setTitle(title);
		        alert.setHeaderText(null);
		        alert.setContentText(message);
		        alert.initOwner(owner);
		        alert.show();
		    }
		    ///////////////////////
			public static void infoBox(String infoMessage, String headerText, String title) {
		        Alert alert = new Alert(AlertType.CONFIRMATION);
		        alert.setContentText(infoMessage);
		        alert.setTitle(title);
		        alert.setHeaderText(headerText);
		        alert.showAndWait();
		    }
	

}
