package display;

<<<<<<< HEAD
import games.Hangman;
import games.Motus;
import games.WordSearchPuzzle;
=======
import java.io.File;
import java.util.Arrays;

import games.*;
>>>>>>> axel
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Home extends Application {

	public static void main(String[] args) {

		
		//Application.launch(Home.class, args);
		
		WordSearchPuzzle w = new WordSearchPuzzle();
		w.startGame();
		Motus m = new Motus();
    	m.startGame();
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	

<<<<<<< HEAD
=======
		// Hangman h = new Hangman();
		// h.startGame();

		Sudoku s = new Sudoku();
		s.afficherGrille();
		s.jouerUnCoup();
	} 
>>>>>>> axel


}

<<<<<<< HEAD
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Des Chiffres et Des Lettres");
        Group root = new Group();
        Scene scene = new Scene(root, 1200, 720, Color.LIGHTGREY);
       // MainMenu menu = new MainMenu();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
=======
	
>>>>>>> test

