package display;

import games.Hangman;
import games.Motus;
import games.WordSearchPuzzle;
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
	



}

	

