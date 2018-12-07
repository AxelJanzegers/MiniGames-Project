package display;

import games.Hangman;
import games.Motus;
import games.WordSearchPuzzle;
<<<<<<< HEAD

import java.io.File;
import java.util.Arrays;


import gui.*;

=======
import java.io.File;
import java.util.Arrays;

import games.*;
>>>>>>> axel
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
<<<<<<< HEAD
		
		Application.launch(args);
		
		
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



	
=======

		
	

		// Hangman h = new Hangman();
		// h.startGame();

		Sudoku s = new Sudoku();
		s.afficherGrille();
		s.jouerUnCoup();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	} 
>>>>>>> axel


}


