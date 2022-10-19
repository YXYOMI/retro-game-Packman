package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import application.model.BarObstacle;
import application.model.GameManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * This is the controller of the SetUp page.
 * There are two colorPickers to choose the color of wall and background
 * One button to save the changes and go back to the start page.
 * Two comboBox to choose the difficulty(level) and turn on/off the music.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class SetUpController {
	@FXML
	public ColorPicker colorpicker_bgc;
	@FXML
	public ColorPicker colorpicker_wc;
	@FXML
	private Button btn_back;
	@FXML
	public ComboBox<String> combo_difficulty;
	@FXML
	public ComboBox<String> combo_music;
    

	/** 
	 * Event Listener on Button[#btn_back].onAction
	 * If user click the "save" button, it will get the value of colorPickers and comboBoxes and assignment to the static strings in model to get the changes.
	 * Then hide this stage and show the start page.
	 * @param event - key event from user
	 * @throws IOException - exception if fail to load the FXML.
	 */
	@FXML
	public void backToMain(ActionEvent event) throws IOException {
        
		GameManager.difficulty = combo_difficulty.getValue();
		BarObstacle.wallColor = colorpicker_wc.getValue();
		GameManager.music = combo_music.getValue();
		StartPageController.bgColor = colorpicker_bgc.getValue();
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/StartPage.fxml"));
		Scene back = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.hide();
	    stage.setScene(back);
	    stage.show();
	    
	}
	
    /**
     * Set the options of comboBoxes and set the defaul value of them.
     */
	public void initialize() {
	
		ObservableList<String> difficulty_options = FXCollections.observableArrayList("Easy", "Normal", "Hard");
		combo_difficulty.setItems(difficulty_options);
		ObservableList<String> music_options = FXCollections.observableArrayList("ON", "OFF");
		combo_music.setItems(music_options);
		combo_difficulty.setValue("Normal");
		combo_music.setValue("ON");
		colorpicker_bgc.setValue(Color.WHITE);
		colorpicker_wc.setValue(Color.CADETBLUE);		
	}
}
