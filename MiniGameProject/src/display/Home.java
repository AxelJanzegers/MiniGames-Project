package display;

import games.Hangman;
import games.Motus;
import games.WordSearchPuzzle;

import java.io.File;
import java.util.Arrays;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Home extends Application {

	
	public static void main(String[] args) {
		
		Application.launch(args);
		//Hangman h = new Hangman();
		//w.startGame();
		Motus m = new Motus();
		m.startGame();
		
		
	}

	
	/*
	 * Lancement de la fenêtre d'affichage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Motus m = new Motus();
		//m.startGame();
		//Hangman h = new Hangman();
		//h.startGame();
		WordSearchPuzzle w = new WordSearchPuzzle();
		w.startGame();
	}



	


}

	

