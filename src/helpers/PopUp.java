package helpers;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;

public class PopUp {

	
	
	
	
///////////////////////
public static void infoBox(String infoMessage, String headerText, String title) {
Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setContentText(infoMessage);
alert.setTitle(title);
alert.setHeaderText(headerText);
alert.showAndWait();
}




//////////////////////////////////////////

public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
Alert alert = new Alert(alertType);
alert.setTitle(title);
alert.setHeaderText(null);
alert.setContentText(message);
alert.initOwner(owner);
alert.show();
}
	
	
	
	
	
	
	
	
}
