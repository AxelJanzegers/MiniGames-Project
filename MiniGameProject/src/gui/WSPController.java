package gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import display.Grid;
import games.WordSearchPuzzle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class WSPController implements Initializable {
	
	
	WordSearchPuzzle w;
	
	//Bouton retour
	@FXML
	private Button quit;
	//Grille
	private Grid g;
	//Grille
	@FXML
	private GridPane grid;
	private Label[][] letters;
	int x,y;
	
	//affichage des mots à trouver
	private Label[] words;
	@FXML
	private GridPane pane;
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		/*
		 * Initialisation
		 */
		w = new WordSearchPuzzle(new File("MotsMeles/Fruits.txt"));
		this.g = w.getG();
		this.letters = new Label[w.getG().getX()-1][w.getG().getY()];
		this.words = new Label[w.getWords().length];
		this.x=g.getX()-1;
		this.y=g.getY();
		/*
		 * Affichage des mots à trouver
		 */
		pane.addRow(0, new Label("Mots à trouver"));
		for(int i = 0; i<w.getWords().length;i++) {
			words[i]=new Label(w.getWords()[i]);
			pane.addRow(i+1, words[i]);
		}
		
		/*
		 * Affichage de la grille
		 */
		for(int i=0; i<x;i++) {
			for(int j=0; j<y;j++) {
				setLabel(i,j);
			}
		}
		
	}

	/*
	 * Creation du Label pour une case
	 */
	public void setLabel(int i, int j) {
		letters[i][j] = new Label(); 
		letters[i][j].setText(Character.toString(g.getLetterAtIndex(i,j)));
		
		
		letters[i][j].setAlignment(Pos.CENTER);
		grid.add(letters[i][j], i, j);
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
