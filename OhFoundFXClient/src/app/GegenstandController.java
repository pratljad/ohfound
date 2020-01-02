package app;

import java.awt.image.BufferedImage;
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

public class GegenstandController implements Initializable{

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		db = DatabaseManager.newInstance();
		fillUeberbgeriffe();
	}
	
	@FXML
    void chooseFile(ActionEvent event) {

		 FileChooser chooser = new FileChooser();
		    chooser.setTitle("Open File");
		    File file = chooser.showOpenDialog(new Stage());
		    if(file != null) {
				try {
					imagepath = file.getAbsolutePath();
					System.out.println("file:");
			        Image image = new Image(file.toURI().toURL().toString());
			        ivGegenstand.setImage(image);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    else
		    {
		        Alert alert = new Alert(Alert.AlertType.INFORMATION);
		        alert.setTitle("Information Dialog");
		        alert.setHeaderText("Please Select a File");
		        /*alert.setContentText("You didn't select a file!");*/
		        alert.showAndWait();
		    }
    }
	
	 @FXML
	    void saveGegenstand(ActionEvent event) {
		 
		 BufferedImage bImage;
		try {
			bImage = ImageIO.read(new File(imagepath));
			 ByteArrayOutputStream bos = new ByteArrayOutputStream();
		      ImageIO.write(bImage, "jpg", bos );
		      byte [] data = bos.toByteArray();
		      
			 	db.addGegenstand(new Gegenstand(-1, cbUeberbegriffe.getSelectionModel().getSelectedItem(),
			 			tfBeschreibung.getText(),tfOrt.getText(),data));
			    Stage stage = (Stage) tfBeschreibung.getScene().getWindow();
			    stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));

		} catch (Exception e) {
			e.printStackTrace();
		}
	     
		 
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
