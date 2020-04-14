package app;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StartGuiController implements Initializable {

	@FXML
	private Button btnLogin;

	@FXML
	private Button btnRegistrieren;

	@FXML
	void btnLoginOnAction(ActionEvent event) {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("./Login.fxml"));
			Parent root = (Parent) loader.load();

			Login controller = loader.getController();
			Stage stage = new Stage();
			stage.setTitle("Login");
			stage.setScene(new Scene(root));
			stage.show();
			//stage.getOnCloseRequest().handle(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void btnRegistrierenOnAction(ActionEvent event) {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("./Registrieren.fxml"));
			Parent root = (Parent) loader.load();

			Registrieren controller = loader.getController();
			Stage stage = new Stage();
			stage.setTitle("Registrieren");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
