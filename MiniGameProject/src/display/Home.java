package display;

import games.Hangman;
import games.Motus;
import games.WordSearchPuzzle;
import java.io.File;
import java.util.Arrays;

import games.*;
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


}


