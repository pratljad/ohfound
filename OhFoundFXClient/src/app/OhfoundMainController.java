package app;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import bll.Gegenstand;
import bll.Ueberbegriff;
import dal.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class OhfoundMainController implements Initializable{
	
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
	    
	    private DatabaseManager db = null;
	    
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
	    	
	    	db  = DatabaseManager.newInstance();
			
	    	tcGegId.setCellValueFactory(new PropertyValueFactory<>("id"));
	    	tcGegUeberbegriff.setCellValueFactory(new PropertyValueFactory<>("ueberbegriff"));
	    	tcGegBeschreibung.setCellValueFactory(new PropertyValueFactory<>("beschreibung"));
	    	tcGegOrt.setCellValueFactory(new PropertyValueFactory<>("ort"));
	    	
	    	fillTable();
			
		}

	    @FXML
	    void btnAddGegenstandAction(ActionEvent event) {
	    	
	    	try {
/*	    		  FXMLLoader loader = new FXMLLoader(getClass().getResource("./GegenstandController.fxml"));

	    		    Parent root;
	    		    
	    		        root = (Parent)loader.load();
	    		        
	    		            GegenstandController controller = loader.getController();
	    		           
	    		     
	    		        
	    		        Stage stage = (Stage) btnAddGegenstand.getScene().getWindow();
	    		        stage.setScene(new Scene(root));
	*/
	    		  FXMLLoader loader = new FXMLLoader(getClass().getResource("./GegenstandController.fxml"));
	    		  Parent root = (Parent)loader.load();
  		        
		            GegenstandController controller = loader.getController();
	    		    Stage stage = new Stage();
	    		    stage.setScene(new Scene(root));
	    		    stage.show();
	    		    stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	    		          public void handle(WindowEvent we) {
	    		              fillTable();
	    		          }
	    		      });   
	    		    stage.getOnCloseRequest().handle(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
	    		  
	    		    
			} catch(Exception e) {
				e.printStackTrace();
			}
	    	

	    }

	    @FXML
	    void btnDeleteGegenstandAction(ActionEvent event) {

	    }

	    @FXML
	    void btnUpdateGegenstandAction(ActionEvent event) {

	    }
	    
	    private void fillTable() {
	    	try {
				this.tvGegenstaende.getItems().setAll(db.getGegenstaende());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

		
	
}
