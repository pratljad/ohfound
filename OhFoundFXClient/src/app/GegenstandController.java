package app;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import bll.Gegenstand;
import bll.Ueberbegriff;
import dal.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GegenstandController implements Initializable {

	@FXML
	private ComboBox<Ueberbegriff> cbUeberbegriffe;

	@FXML
	private TextField tfBeschreibung;

	@FXML
	private TextField tfOrt;

	@FXML
	private ImageView ivGegenstand;

	@FXML
	private Button btnOk;

	@FXML
	private Button btnBildaus;

	private DatabaseManager db = null;

	private String imagepath;
	
	private static Gegenstand updatedGegenstand=null;
	

	public static void setUpdateGegenstand(Gegenstand b) {
		updatedGegenstand=b;		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		db = DatabaseManager.newInstance();
		fillUeberbgeriffe();
		if(updatedGegenstand!=null) {
			System.out.println("kdjsfhsk");
			btnOk.setText("update");
			fillUeberbgeriffe();
			cbUeberbegriffe.getSelectionModel().select(updatedGegenstand.getUeberbegriff());
			tfBeschreibung.setText(updatedGegenstand.getBeschreibung());
			tfOrt.setText(updatedGegenstand.getOrt());
			
			Image img = new Image(new ByteArrayInputStream(updatedGegenstand.getImage()));
			ivGegenstand.setImage(img);
		}
	}

	
	@FXML
	void chooseFile(ActionEvent event) {

		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open File");
		File file = chooser.showOpenDialog(new Stage());
		if (file != null) {
			try {
				
				imagepath = file.getAbsolutePath();
				Image image = new Image(file.toURI().toURL().toString());
				ivGegenstand.setImage(image);
				if(updatedGegenstand!=null) {
					updatedGegenstand.setImage(convertImageToByteArray(imagepath));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("Please Select a File");
			/* alert.setContentText("You didn't select a file!"); */
			alert.showAndWait();
		}
	}

	@FXML
	void saveGegenstand(ActionEvent event) {
		try {
			if(updatedGegenstand==null) {
				db.addGegenstand(new Gegenstand(-1, cbUeberbegriffe.getSelectionModel().getSelectedItem(),
						tfBeschreibung.getText(), tfOrt.getText(), convertImageToByteArray(imagepath)));
				
				Stage stage = (Stage) tfBeschreibung.getScene().getWindow();
				stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
			}else {
				
				updatedGegenstand.setBeschreibung(tfBeschreibung.getText());
				updatedGegenstand.setOrt(tfOrt.getText());
				updatedGegenstand.setUeberbegriff(cbUeberbegriffe.getSelectionModel().getSelectedItem());
				System.out.println(updatedGegenstand);
				db.updateGegenstand(updatedGegenstand);
				
				Stage stage = (Stage) tfBeschreibung.getScene().getWindow();
				stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
			
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private byte[] convertImageToByteArray(String filepath) throws Exception{
		BufferedImage bImage;
		bImage = ImageIO.read(new File(filepath));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(bImage, "jpg", bos);
		return bos.toByteArray();
	}
	private void fillUeberbgeriffe() {
		try {
			cbUeberbegriffe.getItems().setAll(db.getUeberbegriff());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
