package display;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Home extends Application {

	
	public static void main(String[] args) {		
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
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
	}
}


