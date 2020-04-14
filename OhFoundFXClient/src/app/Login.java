package app;

import java.net.URL;
import java.util.ResourceBundle;

import bll.User;
import dal.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Login implements Initializable {

	@FXML
	private TextField tfEmail;

	@FXML
	private PasswordField pfPasswort;

	
	@FXML
	private Button btnOK;

	private DatabaseManager db = null;

	@FXML
	void btnOnActionOK(ActionEvent event) {

		try {
			User u = db.loginUser(new User(tfEmail.getText(), pfPasswort.getText()));
			OhfoundMainController.setCurUser(u);

			FXMLLoader loader = new FXMLLoader(getClass().getResource("./OhfoundMain.fxml"));
			Parent root = (Parent) loader.load();

			OhfoundMainController controller = loader.getController();
			Stage stage = new Stage();
			stage.setTitle("Verloren/Gefunden");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = DatabaseManager.newInstance();
	}

}
