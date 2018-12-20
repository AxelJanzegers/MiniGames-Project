package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SudokuController implements Initializable {

	@FXML
	private Button quit;
	//Image du pendu affichée
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Fonction de retour au menu principal
	 */
	@FXML
	public void backToMenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("dis.fxml"));
		Scene scene = new Scene(root);
		Stage playwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
		playwindow.setScene(scene);
	}
	

}
