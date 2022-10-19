package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import application.model.Draw;
import application.model.GameManager;
import application.model.Grade;
import application.model.Maze;
import application.model.ScoreList;
import javafx.event.ActionEvent;

/**
 * This is the controller of the ScoreBoard page.
 * There are two button. one is for going back to the start page, the other is for restart the game.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class ScoreBoardController {
	@FXML
	private Button btn_back;
	@FXML
	private Button btn_continue;
	@FXML
	private Text score1;
	@FXML
	private Text score2;
	@FXML
	private Text score3;
	@FXML
	private Text score4;
	@FXML
	private Text score5;
	@FXML
	private Text score6;
	@FXML
	private Text scoreThis;
	@FXML
	private Text diffi1;
	@FXML
	private Text diffi2;
	@FXML
	private Text diffi3;
	@FXML
	private Text diffi4;
	@FXML
	private Text diffi5;
	@FXML
	private Text diffi6;
	@FXML
	private Text difficultyThis;
	

	/**
	 * Event Listener on Button[#btn_back].onAction
	 * If user click the "back" button, it will hide current page and show to the start page.
	 * @param event - key event from user.
	 * @throws IOException - exception if fail to load the FXML.
	 */
	@FXML
	public void btn_back(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/StartPage.fxml"));
		Scene back = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.hide();
	    stage.setScene(back);
	    stage.show();
	}
	
	
	/** 
	 * Event Listener on Button[#btn_continue].onAction
	 * If user click the "restart" button, it will restart the game.
	 * @param aEvent - event key event from user.
	 */
	@FXML
	public void btn_restart(ActionEvent aEvent){
		Stage stage= (Stage) ((Node) aEvent.getSource()).getScene().getWindow();
        stage.hide();
        Group root = new Group();
        Maze maze = new Maze(root);
        GameManager gameManager = new GameManager(root, maze);
        Draw draw = new Draw(gameManager); 
        draw.drawBoard(); 
        
        Scene startGame = new Scene(root);
        startGame.setFill(StartPageController.bgColor);
        
        startGame.addEventHandler(KeyEvent.KEY_PRESSED, event -> gameManager.movePac.movePacman(event));
        startGame.addEventHandler(KeyEvent.KEY_RELEASED, event -> gameManager.movePac.stopPacman(event));
        
        stage.setScene(startGame);
        stage.show();
		
	}
	
	
	/**
	 * set the text(show the Top6 grades) from the grades arrayList(score and difficulty) created in class ScoreList.
	 * If the size of arrayList smaller than 6, fill in the arrayList to 6 with "0, (..)" which means do not have the grade.
	 */
	public void initialize() {
		
		int myGradeIndex = ScoreList.grades.size() - 1;
		scoreThis.setText(String.valueOf(ScoreList.grades.get(myGradeIndex).getScore()));
		difficultyThis.setText(ScoreList.grades.get(myGradeIndex).getDifficulty());
		ScoreList.grades.remove(myGradeIndex);
		
		if(ScoreList.grades.size() < 6) {
			
			for(int i = ScoreList.grades.size(); i <= 6; i++) {
				Grade emptyGrade = new Grade(0,"(..)");
				ScoreList.grades.add(emptyGrade);
			}
		}
			score1.setText(String.valueOf(ScoreList.grades.get(0).getScore()));
			score2.setText(String.valueOf(ScoreList.grades.get(1).getScore()));
			score3.setText(String.valueOf(ScoreList.grades.get(2).getScore()));
			score4.setText(String.valueOf(ScoreList.grades.get(3).getScore()));
			score5.setText(String.valueOf(ScoreList.grades.get(4).getScore()));
			score6.setText(String.valueOf(ScoreList.grades.get(5).getScore()));
		
			
			diffi1.setText(ScoreList.grades.get(0).getDifficulty());
			diffi2.setText(ScoreList.grades.get(1).getDifficulty());
			diffi3.setText(ScoreList.grades.get(2).getDifficulty());
			diffi4.setText(ScoreList.grades.get(3).getDifficulty());
			diffi5.setText(ScoreList.grades.get(4).getDifficulty());
			diffi6.setText(ScoreList.grades.get(5).getDifficulty());
			
		}
}
