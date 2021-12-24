package application;
	import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import Controllers.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import helpers.MailJava;
import helpers.log4jExample;

public class Main extends Application {

	
	
	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("/views/Sample.fxml"));
		
			Scene scene = new Scene(root,821,559);
			scene.getStylesheets().add(getClass().getResource("/views/application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Login");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		
		
		
		launch(args);
		}
}
