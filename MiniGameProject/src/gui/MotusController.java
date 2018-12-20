package gui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import games.Motus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class MotusController implements Initializable {

	//Déclaration du jeu
	Motus m;

	//Bouton retour
	@FXML
	private Button quit;
	//Grille
	@FXML
	private GridPane gridP;
	private Label[][] letters = new Label[6][6];
	@FXML
	private Label score;



	//Entiers pour naviguer dans la grille
	private int x;
	private int y=0;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		m=new Motus();
		gridP.setOnKeyPressed(event->{
			letterInput(event);
		});
		for (x = 0; x < letters.length; x++) {
			setLabel();
		}
		x=0;
		setActual();

	}

	public void setActual() {
		letters[x][y].setStyle("-fx-background-color:green;-fx-font-size: 50; -fx-border-color:black");
	}

	/*
	 * Creation du Label pour une case
	 */
	public void setLabel() {
		letters[x][y] = new Label(); 
		letters[x][y].setText(Character.toString(m.getLetterAtIndex(x)));
		letters[x][y].setPrefSize(90, 90);
		letters[x][y].setTextFill(Color.WHITE);
		letters[x][y].setStyle("-fx-background-color:blue; -fx-font-size: 50; -fx-border-color:black");
		letters[x][y].setAlignment(Pos.CENTER);
		gridP.add(letters[x][y], x, y);
	}

	/*
	 * Keyhandler pour les lettres entrées
	 */
	@FXML 
	public void letterInput(KeyEvent event) {
		if(x<6 && y<6) {
			if(event.getCode().isLetterKey()) {
				letters[x][y].setText(event.getCode().toString());
				letters[x][y].setStyle("-fx-background-color:blue; -fx-font-size: 50; -fx-border-color:black");
				x++;
				if(x<6) setActual();
				if(x==6) wordComplete(event);
			}
		}

	}


	public void wordComplete(KeyEvent event) {
		/*
		 * Vérifications
		 */
		char[] GUIWord = new char[6];
		for(x=0;x<GUIWord.length;x++) {
			GUIWord[x] = letters[x][y].getText().charAt(0);

		}
		m.setWordSC(GUIWord);
		m.verif();

		/*
		 * Affichage
		 */

		int[] t = m.getTdis();

		for(x=0;x<GUIWord.length;x++) {
			if(t[x]==1) {

				letters[x][y].setStyle("-fx-background-color:yellow; -fx-background-radius:75; -fx-font-size: 50; -fx-border-color:black");
			}
			else if(t[x]==2) {
				letters[x][y].setStyle("-fx-background-color:red; -fx-font-size: 50; -fx-border-color:black");
			}
			else if(t[x]==0) {
				letters[x][y].setStyle("-fx-background-color:blue; -fx-font-size: 50; -fx-border-color:black");
			}
			
		}
		this.score.setText(String.valueOf(m.getScore()));


		if(m.win()) {
			try {
				this.gameFinished(event);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			/*
			 * Génération de la ligne suivante
			 */
			if(y<5) {
				y++;
				for(x=0;x<6;x++) {
					setLabel();
				}
				x=0;
				setActual();
			}
			else {
				try {
					gameFailed(event);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}

	}
	
	/*
	 * Fonction de fin de jeu (partie gagnée)
	 */
	@FXML
	public void gameFinished(KeyEvent event) throws IOException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Félicitations");
		alert.setHeaderText("Le mot a été trouvé !");
		alert.setContentText("Votre score est de "+m.getScore()); //Message de félicitations et score

		Optional<ButtonType> b = alert.showAndWait();
		if (b.get()==ButtonType.OK || b.get()==ButtonType.CANCEL || b.get()==ButtonType.CLOSE) {
			Parent root = FXMLLoader.load(getClass().getResource("dis.fxml"));
			Scene scene = new Scene(root);
			Stage playwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			playwindow.setScene(scene);
		}
	}
	
	/*
	 * Fonction de fin de jeu (partie perdue)
	 */
	@FXML
	public void gameFailed(KeyEvent event) throws IOException {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Perdu...");
		alert.setHeaderText("Le mot était "+m.getWord()); //On affiche la réponse
		alert.setContentText("Votre score est de "+m.getScore()); //et le score

		Optional<ButtonType> b = alert.showAndWait();
		if (b.get()==ButtonType.OK || b.get()==ButtonType.CANCEL || b.get()==ButtonType.CLOSE) {
			Parent root = FXMLLoader.load(getClass().getResource("dis.fxml"));
			Scene scene = new Scene(root);
			Stage playwindow = (Stage) (((Node) event.getSource()).getScene().getWindow());
			playwindow.setScene(scene);
		}
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
}
