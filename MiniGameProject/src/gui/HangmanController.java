package gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


import games.Hangman;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HangmanController implements Initializable {

	
	//Déclaration du jeu
	Hangman h;
	
	//Mot affiché
	@FXML
	private Label word;
	//Score
	@FXML
	private Label score;
	//Bouton retour
	@FXML
	private Button quit;
	//Image du pendu affichée
	@FXML
	private ImageView theman;
	
	
	//Variable pour récupérer la lettre entrée
	private char l;
	//Tableau d'images
	private static File[] images = new File[8];
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		h = new Hangman();
		word.setText(h.getAnswer()); //On affiche le mot à trouver dès l'ouverture de la fenêtre
		images[0]=new File("/../../Pendu/Pendu0.jpg");
		images[1]=new File("/../../Pendu/Pendu1.jpg");
		images[2]=new File("/../../Pendu/Pendu2.jpg");
		images[3]=new File("/../../Pendu/Pendu3.jpg");
		images[4]=new File("/../../Pendu/Pendu4.jpg");
		images[5]=new File("/../../Pendu/Pendu5.jpg");
		images[6]=new File("/../../Pendu/Pendu6.jpg");
		images[7]=new File("/../../Pendu/Pendu7.jpg");
	}

	/*
	 * Fonction de retour au menu principal
	 */
	@FXML
	public void backToMenu(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Des Chiffres et des Letters");
		alert.setHeaderText("Voulez-vous quitter ?");
		alert.setContentText("Votre progression ne sera sauvegardée.");

		Optional<ButtonType> b = alert.showAndWait();
		if (b.get()==ButtonType.OK) {
			Parent root = FXMLLoader.load(getClass().getResource("dis.fxml"));
			Scene scene = new Scene(root);
			Stage playwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			playwindow.setScene(scene);
		}


	}
	
	/*
	 * Cliquer sur une lettre
	 */
	@FXML
	public void clickLetter(ActionEvent event) {
		Button bi = (Button) event.getSource(); //On récupère le bouton cliqué
		l=bi.getText().charAt(0); //Et on associe sa valeur à l
		bi.setOpacity(0);
		bi.setOnAction(null); //On efface le bouton de la partie
		h.verif(l);//On appelle les vérifications du pendu
		word.setText(h.getAnswer());
		if(h.getFails()<=7) theman.setImage(getImage(h.getFails()));
		score.setText(String.valueOf(h.getScore())+"$");;
	
	}

	public Image getImage(int x) {
		
		Image i = new Image(images[x].toURI().toString());
		return i;
	}
	
	  
}
