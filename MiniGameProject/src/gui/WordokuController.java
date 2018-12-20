package gui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import games.SudokuL;
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
import javafx.stage.Stage;

public class WordokuController implements Initializable{

	
	
	private SudokuL s;

	//Bouton retour
	@FXML
	private Button quit;
	//Grille
	@FXML
	private GridPane grid;
	private Label[][] numbers = new Label[9][9];
	private Label Lselected = new Label();
	private Boolean selection=false;
	
	@FXML
	private Button cancel;
	
	@FXML
	private AnchorPane choiceBox;
	@FXML
	private Button facile;
	@FXML
	private Button normal;
	@FXML
	private Button difficile;
	@FXML
	private Button expert;

	@FXML
	private AnchorPane buttons;
	@FXML
	private Button b1;
	@FXML
	private Button b2;
	@FXML
	private Button b3;
	@FXML
	private Button b4;
	@FXML
	private Button b5;
	@FXML
	private Button b6;
	@FXML
	private Button b7;
	@FXML
	private Button b8;
	@FXML
	private Button b9;
	
	@FXML
	private Label score;
	@FXML 
	private Label err;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		err.setText("Choisissez une grille");
		
		
	}


	public void initialize2() {
		
		/*
		 * Affichage de la grille
		 */
		
		for(int i=0; i<9;i++) {
			for(int j=0; j<9;j++) {
				setLabel(i,j);
			}
		}
		b1.setText(String.valueOf(s.getGrille().getTabAuto()[0]));
		b2.setText(String.valueOf(s.getGrille().getTabAuto()[1]));
		b3.setText(String.valueOf(s.getGrille().getTabAuto()[2]));
		b4.setText(String.valueOf(s.getGrille().getTabAuto()[3]));
		b5.setText(String.valueOf(s.getGrille().getTabAuto()[4]));
		b6.setText(String.valueOf(s.getGrille().getTabAuto()[5]));
		b7.setText(String.valueOf(s.getGrille().getTabAuto()[6]));
		b8.setText(String.valueOf(s.getGrille().getTabAuto()[7]));
		b9.setText(String.valueOf(s.getGrille().getTabAuto()[8]));
		
	}
	@FXML
	public void setFile(ActionEvent event) {
		err.setText("");
		buttons.setOpacity(1);
		grid.setOpacity(1);
		choiceBox.setOpacity(0);
		
		if (event.getSource().equals(facile)) {
			s= new SudokuL("GrilleSudoku/grilleL_facile.dat");
		}
		else if(event.getSource().equals(normal)) {
			s= new SudokuL("GrilleSudoku/grilleL_moyen.dat");
		}
		else if(event.getSource().equals(difficile)) {
			s= new SudokuL("GrilleSudoku/grilleL_difficile.dat");
		}
		else {
			s= new SudokuL("GrilleSudoku/grilleL_expert.dat");
		}
		facile.setOnAction(null);
		normal.setOnAction(null);
		difficile.setOnAction(null);
		expert.setOnAction(null);
		initialize2();
	}
	
	/*
	 * Creation du Label pour une case
	 */
	public void setLabel(int i, int j) {

		numbers[i][j] = new Label(); 
		numbers[i][j].setText(Character.toString(s.getGrille().getLetterAtIndex(j,i)));
		numbers[i][j].setPrefSize(60,60);
		numbers[i][j].setId("");
		/*
		 * Si la case est vide au démarrage
		 */
		if(numbers[i][j].getText().equals("0")) {
			numbers[i][j].setText("");
			numbers[i][j].setStyle("-fx-border-color:black;-fx-background-color : white;-fx-font-size: 35;");
			/*
			 * On associe l'élément au clic de la souris
			 */
			numbers[i][j].setOnMouseClicked(new EventHandler<MouseEvent>
		    () {

		        @Override
		        public void handle(MouseEvent event) {
		           input(event);
		        }
		    });
		}
		/*
		 * Si la case est complétée au démarrage 
		 */
		else {
			numbers[i][j].setId("base");
			numbers[i][j].setStyle("-fx-border-color:black;-fx-background-color : lightyellow;-fx-font-size: 35;");
		}
		numbers[i][j].setPrefSize(60,60);
		numbers[i][j].setAlignment(Pos.CENTER);



		grid.add(numbers[i][j], i, j);
	}

	/*
	 * Réception des clics
	 */
	@FXML
	public void input(MouseEvent event) {
		if(!this.selection) {
			this.selection=true;
			Lselected=((Label) event.getSource());
			Lselected.setStyle("-fx-border-color:black;-fx-background-color : red;-fx-font-size: 35;");
			cancel.setOpacity(1);
		}
		else {
			Lselected.setStyle("-fx-border-color:black;-fx-background-color : white;-fx-font-size: 35;");
			Lselected=((Label) event.getSource());
			Lselected.setStyle("-fx-border-color:black;-fx-background-color : red;-fx-font-size: 35;");
		}
	}
	
	/*
	 * Réception de la lettre
	 */
	@FXML
	public void charaInput(ActionEvent event) {
		if(selection) {
			this.selection=false;
			Button bi = (Button) event.getSource();
			Lselected.setText(String.valueOf((s.makeAMove(bi.getText().charAt(0), GridPane.getRowIndex(Lselected), GridPane.getColumnIndex(Lselected)))));
			if(Lselected.getText().equals("0")) {
				Lselected.setText("");
			}
			switch(s.getErr()) {
			case 1: err.setText("Cette variable est déjà sur la ligne.");break;
			case 2: err.setText("Cette variable est déjà sur la colonne.");break;
			case 3: err.setText("Cette variable est déjà dans la région.");break;
			default:break;
			}
			err.wrapTextProperty();
			Lselected.setStyle("-fx-border-color:black;-fx-background-color : white;-fx-font-size: 35;");
			score.setText("Score : "+s.getScore());
			cancel.setOpacity(0);
		}
		
	}
	
	/*
	 * Annuler son coup
	 */
	@FXML
	public void cancelMove(ActionEvent event) {
		if(selection) {
			this.selection=false;
			Lselected.setStyle("-fx-border-color:black;-fx-background-color : white;-fx-font-size: 35;");
			cancel.setOpacity(0);
		}
	}

	/*
	 * Effacer le contenu d'une case
	 */
	@FXML
	public void delete(ActionEvent event) {
		if(selection) {
			this.selection=false;
			cancel.setOpacity(0);
			s.deleteValue(GridPane.getRowIndex(Lselected), GridPane.getColumnIndex(Lselected));
			Lselected.setText("");
			Lselected.setStyle("-fx-border-color:black;-fx-background-color : white;-fx-font-size: 35;");
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
