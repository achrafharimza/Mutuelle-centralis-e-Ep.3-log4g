package Controllers;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;

import DAO.DAO;
import DAO.daoUser;
import factory.DaoFactory;
import helpers.MailJava;
import helpers.Navigations;
import helpers.bcrypt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.User;

public class RegisterController {

    @FXML
    private Button RegisterButton;

    @FXML
    private TextField cinText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField entityText;

    @FXML
    private TextField firstnameText;

    @FXML
    private TextField lastnameText;

    @FXML
    private TextField passwordText;

    @FXML
    private TextField phoneText;
/////////////////////////////
static Logger log = Logger.getLogger(RegisterController.class.getName());

//////////////////////
    @FXML
    void RegistreF(ActionEvent event) throws SQLException, MessagingException {
    	String regexEmail = "^(.+)@(\\S+)$";
        Pattern email = Pattern.compile(regexEmail);
        Matcher Memail = email.matcher(emailText.getText());
        
        
        String regexCin = "[a-zA-Z]{2}\\d{7}";
        Pattern cni = Pattern.compile(regexCin);
        Matcher Mcni = cni.matcher(cinText.getText());
        
        String regexPhone = "[0-9]+";
        Pattern phonep = Pattern.compile(regexPhone);
        Matcher Mphone = phonep.matcher(phoneText.getText());
        
        Window owner = RegisterButton.getScene().getWindow();
        
    	
    	 if (passwordText.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","password Should not empty ");
	            return;
	        }
    	 if (firstnameText.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","firstname Should not empty ");
	            return;
	        }
    	 if (lastnameText.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","lastname Should not empty ");
	            return;
	        }
    	 if (entityText.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","entity Should not empty ");
	            return;
	        }
 	 
    	 if (emailText.getText().isEmpty()|| !Memail.matches()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Please enter a Valid email ");
	            return;
	        }
 	
 	 if (cinText.getText().isEmpty()|| !Mcni.matches()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Please enter a Valid cin ");
	            return;
	        }
 	 if (phoneText.getText().isEmpty()|| !Mphone.matches()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Please enter a Valid phone ");
	            return;
	        }
    	 
    	 
 	String    passwordhached= bcrypt.hashing(passwordText.getText())  ;
    	 
    	
    	String emailId = emailText.getText();
        String passwordID = passwordhached;
        String cin = cinText.getText();
        String firstname = firstnameText.getText();
        String lastname = lastnameText.getText();
        String entity = entityText.getText();
        String phone = phoneText.getText();
        
        
        User user=new models.User(firstname, lastname, cin, phone, emailId, passwordID, entity);
//        
        
       

        DAO <User> daoUser=DaoFactory.getUserImpl();
  
       
        
        int flag= daoUser.inscription(user);
        
        
        if (flag==1) {
        	infoBox("votre compte a bien été créé !", null, "Failed");
        	MailJava.SendMail(emailId);
        	  log.info("account created successfully");
        	
//          ///// move ton next page 
          
        	 Navigations navigations = new Navigations();
	            navigations.changeScene("Sample"); 
	            ((Node)(event.getSource())).getScene().getWindow().hide();

          
          
          
    		
		} else {
			infoBox("error!!data NOT save", null, "Failed");
			  log.warn("inscription failed");
		}
        

       
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	

    }
    
    
    
    
/////////////////////////////
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
