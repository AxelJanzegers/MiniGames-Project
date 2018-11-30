package display;

import java.io.File;
import java.util.Arrays;

import games.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Home extends Application {

	public static void main(String[] args) {

		//Application.launch(Home.class, args);

		// Hangman h = new Hangman();
		// h.startGame();

		Sudoku s = new Sudoku();
		s.afficherGrille();
		s.jouerUnCoup();
	} 



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Des Chiffres et Des Lettres");
        Group root = new Group();
        Scene scene = new Scene(root, 1200, 720, Color.LIGHTGREY);
       // MainMenu menu = new MainMenu();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
}