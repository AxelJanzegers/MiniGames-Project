package display;

import games.Sudoku;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Home extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sudoku g1 = new Sudoku();
		
		g1.GenererGrille();
		g1.GridDisplay();
        
        
        
		//Library.test();
		//Application.launch(Home.class, args);
		
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Des Chiffres et Des Lettres");
		Group root = new Group();
        Scene scene = new Scene(root, 1200, 720, Color.LIGHTGREY);
       // MainMenu menu = new MainMenu();
        primaryStage.setScene(scene);    
        primaryStage.show();
	}

}
