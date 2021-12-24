package Controllers;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import models.User;

import org.json.simple.JSONObject;

import javax.mail.MessagingException;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;

import DAO.DAO;
import DAO.daoUser;
import application.Main;
import config.Config;
import factory.DaoFactory;
import helpers.MailJava;
import helpers.Navigations;
import helpers.bcrypt;
import helpers.log4jExample;







public class SampleController {
	JSONArray jrr =new JSONArray();
	
	 @FXML
	    private AnchorPane rootPane;
	 @FXML
	    private TextField passText;

	    @FXML
	    private TextField emailText;
	    @FXML
		private Object primaryStage;
		@FXML
	    private Button loginButton;
		 @FXML
		    private Button ToReistreButton;
		 
/////////////////////////////
		 static Logger log = Logger.getLogger(SampleController.class.getName());
		 
//////////////////////		 
		
		@FXML
	    public void login(ActionEvent event) throws SQLException {
			
			
			
			
	         String regexEmail = "^(.+)@(\\S+)$";
	         Pattern email = Pattern.compile(regexEmail);
	         Matcher Memail = email.matcher(emailText.getText());
			
			
			Window owner = loginButton.getScene().getWindow();
	    	
		    if (emailText.getText().isEmpty()|| !Memail.matches()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Please enter a Valid email ");
	            return;
	        }
	         
	        
		    String    passwordhached= bcrypt.hashing(passText.getText())  ;
		    
		    
		    String emailId = emailText.getText();
	        String passwordID = passwordhached;
		    
	    
	    
	        User user=new models.User(emailId, passwordID);

	        DAO <User> daoUser=DaoFactory.getUserImpl();
      
	        boolean flag= daoUser.login(user);
	        
	        


	        if (!flag) {
	            infoBox("Please enter correct Email and Password", null, "Failed");
	            
	           log.warn("authentication failed");
	           
	            
	            
	        } else {
	            infoBox("Login Successful!", null, "Failed");
	            log.info("authentication passed correctly");
	            ///// move ton next page 
      
	            Navigations navigations = new Navigations();
	            navigations.changeScene("Page2"); 
	            
	        }

	         
	    	}
//////////////////////////////////////////
	    ///////////////////////////////////////
	   
	    
	    
	    
	    
	/////////////////////////////////////////////////////////	
		
		
		
		
		 @FXML
		    void ToReistre(ActionEvent event) {
			 
			 Navigations navigations = new Navigations();
	            navigations.changeScene("Register"); 
			 
//	    	   try {
//	    		   
//	    			Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
//	    			Stage RegiStage =new Stage();
//	    			Scene scene = new Scene(root,821,559);
//	    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//	    			RegiStage.setScene(scene);
//	    			RegiStage.setTitle("Login");
//	    			RegiStage.show();
//	    		   
//
//      		} catch(Exception e) {
//      			e.printStackTrace();
//      		}
			 

	    	   
	    	   
	    	  
	    	   
	    	   
	    	   
	    	   
	    	   
	    	   
		    }
	














///////////////////////
		public static void infoBox(String infoMessage, String headerText, String title) {
	        Alert alert = new Alert(AlertType.CONFIRMATION);
	        alert.setContentText(infoMessage);
	        alert.setTitle(title);
	        alert.setHeaderText(headerText);
	        alert.showAndWait();
	    }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//////////////////////////////////////////
		
		 private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		        Alert alert = new Alert(alertType);
		        alert.setTitle(title);
		        alert.setHeaderText(null);
		        alert.setContentText(message);
		        alert.initOwner(owner);
		        alert.show();
		    }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	    
	    





	    private Scene getScene() {
			// TODO Auto-generated method stub
			return null;
		}









		private Object parseEmployeeObject(JSONObject emp) {
			// TODO Auto-generated method stub
			return null;
		}
	    	
	    	
	    	
	    	

	    
	    
	    
    
	
}
