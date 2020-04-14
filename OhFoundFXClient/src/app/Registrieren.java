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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Registrieren implements Initializable {

	@FXML
	private TextField tfVorname;

	@FXML
	private TextField tfEmail;

	@FXML
	private TextField tfNachname;

	@FXML
	private PasswordField pfPasswort;

	@FXML
	private PasswordField tfPasswortWieder;

	@FXML
	private Button btnOK;

	@FXML
	private RadioButton rbAdmin;

	private DatabaseManager db = null;

	@FXML
	void btnOnActionOK(ActionEvent event) {

		try {

			if (!tfPasswortWieder.getText().equals(pfPasswort.getText())) {
				throw new Exception("Passwort wiederholen");
			}

			if (rbAdmin.isSelected()) {
				System.out.println("hehehe"+ new User(-1, tfVorname.getText(), tfNachname.getText(), tfEmail.getText(),
						pfPasswort.getText(), tfPasswortWieder.getText(), true).toString());
				db.registerUser(new User(-1, tfVorname.getText(), tfNachname.getText(), tfEmail.getText(),
						pfPasswort.getText(), tfPasswortWieder.getText(), true));
			} else {
				db.registerUser(new User(-1, tfVorname.getText(), tfNachname.getText(), tfEmail.getText(),
						pfPasswort.getText(), tfPasswortWieder.getText(), false));
			}

			FXMLLoader loader = new FXMLLoader(getClass().getResource("./Login.fxml"));
			Parent pane = loader.load();

			pfPasswort.getScene().setRoot(pane);

			/*
			 * FXMLLoader loader = new FXMLLoader(getClass().getResource("./Login.fxml"));
			 * Parent root = (Parent) loader.load();
			 * 
			 * Login controller = loader.getController(); Stage stage = new Stage();
			 * stage.setScene(new Scene(root)); stage.show();
			 */

			/*
			 * FXMLLoader loader = new FXMLLoader(getClass().getResource("./Login.fxml"));
			 * 
			 * Parent root;
			 * 
			 * root = (Parent)loader.load();
			 * 
			 * Login controller = loader.getController();
			 * 
			 * 
			 * 
			 * Stage stage = (Stage) btnAddGegenstand.getScene().getWindow();
			 * stage.setScene(new Scene(root));
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void rbAdminOnAction(ActionEvent event) {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		db = DatabaseManager.newInstance();

	}

}
