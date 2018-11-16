package display;

<<<<<<< HEAD
=======
import java.io.File;
<<<<<<< HEAD
import java.util.Arrays;
=======
>>>>>>> 110b683fa9cd9fe4769bc67f47af3d2e129e393b
>>>>>>> ae7853de5f81c3c84d9ae56510c3a13e7b6a32c6

import games.Hangman;
import games.Motus;
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
		// TODO Auto-generated method stub
<<<<<<< HEAD

<<<<<<< HEAD
		Application.launch(Home.class, args);


=======
		
		//Application.launch(Home.class, args);
		
		Motus m = new Motus();
		Hangman h = new Hangman();
		m.startGame();
		//h.startGame();
			
>>>>>>> matthieu
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Des Chiffres et Des Lettres");
		Group root = new Group();
		Scene scene = new Scene(root, 1200, 720, Color.LIGHTGREY);
		Button btn = new Button();


		btn.setLayoutX(500);
		btn.setLayoutY(380);
		btn.setText("Pendu");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Hangman h = new Hangman();
				h.startGame();
			}
		});

		root.getChildren().add(btn);
		// MainMenu menu = new MainMenu();

		primaryStage.setScene(scene);    
		primaryStage.show();
	}

} s
=======
		//Application.launch(Home.class, args);

		// Hangman h = new Hangman();
		// h.startGame();

		Grid grille = new Grid(10,9);
		System.out.println(Arrays.deepToString(grille.getTab()));

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
>>>>>>> 110b683fa9cd9fe4769bc67f47af3d2e129e393b
