package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Show the start page.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/StartPage.fxml"));
		primaryStage.setTitle("pacman");
		primaryStage.setScene(new Scene(root, 1225, 750));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
