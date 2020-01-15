package app;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import bll.Gegenstand;
import bll.Ueberbegriff;
import bll.User;
import dal.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class OhfoundMainController implements Initializable {

	@FXML
	private TableView<Gegenstand> tvGegenstaende;

	@FXML
	private TableColumn<Gegenstand, Integer> tcGegId;

	@FXML
	private TableColumn<Gegenstand, Ueberbegriff> tcGegUeberbegriff;

	@FXML
	private TableColumn<Gegenstand, String> tcGegBeschreibung;

	@FXML
	private TableColumn<Gegenstand, String> tcGegOrt;

	@FXML
	private Button btnAddGegenstand;

	@FXML
	private Button btnDeleteGegenstand;

	@FXML
	private Button btnUpdateGegenstand;

	@FXML
	private ImageView ivGegenstand;

	@FXML
	private TextField tfFilter;

	@FXML
	private Label lbUser;

	private DatabaseManager db = null;

	private static User curUser = null;

	public static User getCurUser() {
		return curUser;
	}

	public static void setCurUser(User isAdmin) {
		OhfoundMainController.curUser = isAdmin;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		db = DatabaseManager.newInstance();

		lbUser.setText(curUser.getVorname());

		btnDeleteGegenstand.setDisable(true);
		btnUpdateGegenstand.setDisable(true);

		tcGegId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tcGegUeberbegriff.setCellValueFactory(new PropertyValueFactory<>("ueberbegriff"));
		tcGegBeschreibung.setCellValueFactory(new PropertyValueFactory<>("beschreibung"));
		tcGegOrt.setCellValueFactory(new PropertyValueFactory<>("ort"));

		fillTable();

		tvGegenstaende.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
//				System.out.println("mkdsf" + newSelection.getUser());
//
//				System.out.println("mkdsf" + curUser);

				Image img = new Image(new ByteArrayInputStream(newSelection.getImage()));
				ivGegenstand.setImage(img);

				if (newSelection.getUser().equals(curUser) || curUser.getIsAdmin()) {
					System.out.println("okoko");
					btnDeleteGegenstand.setDisable(false);
					btnUpdateGegenstand.setDisable(false);
				} else {
					btnDeleteGegenstand.setDisable(true);
					btnUpdateGegenstand.setDisable(true);

				}
			}
		});
	}

	@FXML
	void onPress(KeyEvent event) {
		try {
			if (event.getCode() == KeyCode.ENTER && event.getSource().equals(tfFilter)) {
				//System.out.println("okok");
				filterGegenstaende();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void filterGegenstaende() throws Exception {
		ArrayList<Gegenstand> filteredGegenstand;
		String filterVal = tfFilter.getText();
		if (filterVal.isEmpty()) {
			filteredGegenstand = db.getGegenstaende();
		} else {
			filteredGegenstand = db.filterGegenstande(filterVal);
			System.out.println(filteredGegenstand);
		}
		tvGegenstaende.getItems().setAll(filteredGegenstand);
	}

	@FXML
	void btnAddGegenstandAction(ActionEvent event) {

		try {
			GegenstandController.setUpdateGegenstand(null);

			FXMLLoader loader = new FXMLLoader(getClass().getResource("./GegenstandController.fxml"));
			Parent root = (Parent) loader.load();

			GegenstandController controller = loader.getController();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Neuer Gegenstand");
			stage.show();
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent we) {
					fillTable();
				}
			});
			stage.getOnCloseRequest().handle(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void btnDeleteGegenstandAction(ActionEvent event) {

		Gegenstand selectedItem = tvGegenstaende.getSelectionModel().getSelectedItem();

		try {
			if (selectedItem == null) {
				throw new Exception("please select an item");
			}
			db.removeGegenstand(selectedItem.getId());
			fillTable();
			btnDeleteGegenstand.setDisable(true);
			btnUpdateGegenstand.setDisable(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void btnUpdateGegenstandAction(ActionEvent event) {
		Gegenstand selectedItem = tvGegenstaende.getSelectionModel().getSelectedItem();

		try {
			if (selectedItem == null) {
				throw new Exception("please select an item");
			}
			GegenstandController.setUpdateGegenstand(selectedItem);

			FXMLLoader loader = new FXMLLoader(getClass().getResource("./GegenstandController.fxml"));
			Parent root = (Parent) loader.load();
			GegenstandController controller = loader.getController();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("Neuer Gegenstand");
			stage.show();
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent we) {
					fillTable();
					btnDeleteGegenstand.setDisable(true);
					btnUpdateGegenstand.setDisable(true);

				}
			});
			stage.getOnCloseRequest().handle(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void fillTable() {
		try {
			this.tvGegenstaende.getItems().setAll(db.getGegenstaende());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
