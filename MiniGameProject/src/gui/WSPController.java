package gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import display.Grid;
import games.WordSearchPuzzle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
	
	@FXML
	private Label score;
	@FXML
	private Button noel;
	@FXML
	private Button legume;
	@FXML
	private AnchorPane choicebox;
	
	
	/*
	 * Construction du mot
	 */
	//Booleen pour savoir si une ligne est en cours de construction
	private Boolean isLine=false;
	/*
	 * Labels de la 1ère et dernière lettre sélectionnée
	 */
	private Label Lbeg;
	private Label Lend;
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		/*
		 * Initialisation
		 */
		
		
	}
	
	@FXML
	public void setFile(ActionEvent event) {
		if(event.getSource().equals(noel)) {
			w = new WordSearchPuzzle(new File("MotsMeles/Noel.txt"));
		}
		else {
			w = new WordSearchPuzzle(new File("MotsMeles/Legumes.txt"));
		}
		initialize2();
	}
	
	public void initialize2() {
		this.grid.setOpacity(1);
		this.choicebox.setOpacity(0);
		noel.setOnAction(null);
		legume.setOnAction(null);
		this.g = w.getG();
		this.letters = new Label[w.getG().getX()-1][w.getG().getY()];
		
		this.x=g.getX()-1;
		this.y=g.getY();
		setWords();
		/*
		 * Affichage de la grille
		 */
		for(int i=0; i<x;i++) {
			for(int j=0; j<y;j++) {
				setLabel(i,j);
			}
		}
	}
	
	public void setWords() {
		/*
		 * Affichage des mots à trouver
		 */
	
		this.words = new Label[w.getWords().length];
		for(int i = 0; i<w.getWords().length;i++) {
			words[i]=new Label(w.getWords()[i]);
			words[i].setTextFill(Color.WHITE);
			words[i].setPrefSize(200, 50);
			words[i].setAlignment(Pos.CENTER);
			pane.addRow(i+1, words[i]);
		}
		pane.setStyle("-fx-background-color:#aa0000; -fx-border-color: black;");
	}

	/*
	 * Creation du Label pour une case
	 */
	public void setLabel(int i, int j) {
		letters[i][j] = new Label(); 
		letters[i][j].setText(Character.toString(g.getLetterAtIndex(i,j)));
		
		letters[i][j].setStyle("-fx-background-color : lightyellow;");
		letters[i][j].setPrefSize(40,40);
		letters[i][j].setAlignment(Pos.CENTER);
		letters[i][j].setId("Normal");
		
		/*
		 * Effets au survol d'une case
		 */
		letters[i][j].setOnMouseEntered(new EventHandler<MouseEvent>
	    () {

	        @Override
	        public void handle(MouseEvent event) {
	        	if(!letters[i][j].getId().equals("Good")
	        			&& !letters[i][j].getId().equals("Selected")){
	        		letters[i][j].setStyle("-fx-background-color:red;");
	        	}
	        }
	    });
		letters[i][j].setOnMouseExited(new EventHandler<MouseEvent>
	    () {

	        @Override
	        public void handle(MouseEvent event) {
	           if(!letters[i][j].getId().equals("Good")
	        		   && !letters[i][j].getId().equals("Selected")) {
	        		   letters[i][j].setStyle("-fx-background-color:lightyellow;");
	           }
	        }
	    });
		letters[i][j].setOnMouseClicked(new EventHandler<MouseEvent>
	    () {

	        @Override
	        public void handle(MouseEvent event) {
	           drawALine(event);
	        }
	    });
		
		//Ajout du label dans la grille
		grid.add(letters[i][j], i, j);
	}
	 
	
	/*
	 * Dessine une ligne
	 */
	@FXML
	public void drawALine(MouseEvent event) {
		if(isLine==false) {
			w.setBeg(GridPane.getRowIndex((Label) event.getSource()), GridPane.getColumnIndex((Label) event.getSource()));
			Lbeg= ((Label) event.getSource());
			Lbeg.setStyle("-fx-border-color:red;");
			if(!Lbeg.getId().equals("Good")) {
				Lbeg.setId("Selected");
			}
			
			
			
			isLine=true;
		}
		else {
			w.setEnd(GridPane.getRowIndex((Label) event.getSource()), GridPane.getColumnIndex((Label) event.getSource()));
			Lend=((Label) event.getSource());
			
			/*
			 * Si la réponse est fausse
			 */
			if(w.submit().equals("")) {
				if(Lbeg.getId().equals("Selected")) {
				Lbeg.setId("Normal");
				Lbeg.setStyle("-fx-background-color:lightyellow;");}
				else if(Lbeg.getId().equals("Good")) {
					Lbeg.setStyle("-fx-border-color:green");
				}
			}
			/*
			 * Si la réponse est vraie
			 */
			else {
				if(w.getBeg()[0]==w.getEnd()[0]) { //Si ils sont sur la même ligne
					if(w.getBeg()[1]<w.getEnd()[1]) { //Si end est après beg
						for(int i=w.getBeg()[1];i<=w.getEnd()[1];i++) {
							letters[i][w.getBeg()[0]].setStyle("-fx-border-color:green");
							letters[i][w.getBeg()[0]].setId("Good");
						}
					}
					else { //Si beg est après end
						
						for(int i=w.getEnd()[1];i<=w.getBeg()[1];i++) {
							letters[i][w.getBeg()[0]].setStyle("-fx-border-color:green");
							letters[i][w.getBeg()[0]].setId("Good");
						}
					}
				}
				else { //Si ils sont sur la même colonne
					if(w.getBeg()[0]<w.getEnd()[0]) { //Si end est après beg
						for(int i=w.getBeg()[0];i<=w.getEnd()[0];i++) {
							letters[w.getBeg()[1]][i].setStyle("-fx-border-color:green");
							letters[w.getBeg()[1]][i].setId("Good");
						}
					}
					else { //Si beg est après end
						for(int i=w.getEnd()[0];i<=w.getBeg()[0];i++) {
							letters[w.getBeg()[1]][i].setStyle("-fx-border-color:green");
							letters[w.getBeg()[1]][i].setId("Good");
						}
					}
				}
				/*
				 * On barre le mot dans le tableau
				 */
				for(int i=0; i<words.length;i++) {
					if(w.getAnswer().equals(words[i].getText())) {
						words[i].setTextFill(Color.RED);
					}
				}
				score.setText(String.valueOf(w.getScore()));
			}
			
			isLine=false;
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
