package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import games.Hangman;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
	public void startHangman(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("hangmangui.fxml"));
		Scene scene = new Scene(root);
		Stage playwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
		playwindow.setScene(scene);
	}
	
	@FXML
	public void startMotus(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("motusgui.fxml"));
		Scene scene = new Scene(root);
		Stage playwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
		playwindow.setScene(scene);
	}
	
	@FXML
	public void startWSP(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("wspgui.fxml"));
		Scene scene = new Scene(root);
		Stage playwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
		playwindow.setScene(scene);
	}
	
	@FXML
	public void startSudoku(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("sudokugui.fxml"));
		Scene scene = new Scene(root);
		Stage playwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
		playwindow.setScene(scene);
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
