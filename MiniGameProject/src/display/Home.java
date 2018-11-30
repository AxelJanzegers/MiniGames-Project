package display;

import games.Hangman;
import games.Motus;
import games.WordSearchPuzzle;

import java.io.File;
import java.util.Arrays;

import gui.*;

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
		WordSearchPuzzle w = new WordSearchPuzzle();
		//Hangman h = new Hangman();
		//w.startGame();
		
		
	}

	
	/*
	 * Lancement de la fenêtre d'affichage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
        primaryStage.setTitle("Des Chiffres et Des Lettres");
        Parent root = FXMLLoader.load(getClass().getResource("../gui/Dis.fxml"));
        Scene scene = new Scene(root);
       // MainMenu menu = new MainMenu();
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}



	


}

	

