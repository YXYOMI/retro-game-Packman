package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

import application.model.Draw;
import application.model.GameManager;
import application.model.Maze;
import javafx.event.ActionEvent;


/**
 * This is the controller of StartPage.
 * There are three buttons: go to the set up page/ start the game/ exit this program.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class StartPageController {
	@FXML
	private Button btn_setup;
	@FXML
	private Button btn_start;
	@FXML
	private Button btn_quit;
	
	public static Color bgColor = Color.WHITE;

	
	/**
	 * Event Listener on Button[#btn_setup].onAction
	 * If user click the "Setup" button, it will hide the current stage and show the set up page.
	 * @param event - key event from user.
	 * @throws IOException - exception if fail to load the FXML.
	 */
	@FXML
	public void gotoSetUp(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/SetUp.fxml"));
		Scene setup = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.hide();
	    stage.setScene(setup);
	    stage.show();
	}
	
	
	/**
	 *  Event Listener on Button[#btn_start].onAction
	 *  If user click the "start" button, it will hide the current page and show the start game page.
	 * @param aEvent - key event from user.
	 */
	@FXML
	public void startGame(ActionEvent aEvent) {   
		
		Stage stage= (Stage) ((Node) aEvent.getSource()).getScene().getWindow();
        stage.hide();
        Group root = new Group();
        Maze maze = new Maze(root);
        GameManager gameManager = new GameManager(root, maze);
        Draw draw = new Draw(gameManager); 
        draw.drawBoard(); 
        
        Scene startGame = new Scene(root);
        
        startGame.setFill(bgColor);
        
        startGame.addEventHandler(KeyEvent.KEY_PRESSED, event -> gameManager.movePac.movePacman(event));
        startGame.addEventHandler(KeyEvent.KEY_RELEASED, event -> gameManager.movePac.stopPacman(event));
        
        stage.setScene(startGame);
        stage.show();
       

	}
	/**
	 *  Event Listener on Button[#btn_quit].onAction
	 *  If user click the "exit" button, it will close the window and stop the program.
	 * @param - event key event from user.
	 */
	@FXML
	public void quitGame(ActionEvent event) {
		Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
		
	}
	
	

}
