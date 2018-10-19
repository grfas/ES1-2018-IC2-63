package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.Element;
import javax.swing.text.html.ListView;

import Twitter.TwitterApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import twitter4j.Status;

public class GUIController implements Initializable{
	
	ObservableList list=FXCollections.observableArrayList();
	@FXML
	private javafx.scene.control.ListView<String> listView = new javafx.scene.control.ListView<String>();
	
	public void initListTwitter() {
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}	
