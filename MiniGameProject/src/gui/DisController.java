package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import games.Hangman;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class DisController implements Initializable {

	@FXML
	private BorderPane rootPane;
	
	
	@FXML
	private Button hangman;
	@FXML
	private Button sudoku;
	@FXML
	private Button wordoku;
	@FXML
	private Button wsp;
	@FXML
	private Button motus;
	
	@FXML
	public void startHangman() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Hangman.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
