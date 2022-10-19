package application.model;

import java.io.IOException;
import java.util.Set;

import application.controller.MovePac;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

/**
 * This class is to manage the whole game.
 * It provides three methods.
 * They will be called when life lost/ game end/ game win.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class GameManager{

    public Group root;
    public Set<Heart> heartSet;
    public Set<Cookie> cookieSet;
    public Set<Ghost> ghosts;
    public Set<Bomb> bombSet;
    private Pacman pacman;
    public MovePac movePac;
    public Maze maze;
    public int lifes;
    public int score;
    public Score scoreBoard;
    public int cookiesEaten;
    public static String difficulty = new String();
    public static String music = new String();
    public Generate generate;
    public Draw draw;
    public Music musicPlay;
    
    /**
     * Constructor. instantiate the classes which will be used when initialize the game and run the game such as class Generate, MovePac..
     * @param root - the group of the elements that will be shown on the stage.
     * @param maze - the game maze.
     */
    public GameManager(Group root, Maze maze) {
    	
    	//if user start the game without set the difficulty, set the default difficulty to normal
        if(difficulty.length() == 0)
        	difficulty = "Normal";
        
        this.musicPlay = new Music();
        
        if(music == "ON" || music.length() == 0) {
        	musicPlay.turnOn();
        }
    	
        this.pacman = Pacman.getPacman();
        this.lifes = 3;
        this.score = 0;
        this.cookiesEaten = 0;
        
        this.root = root;
        this.maze = maze;
        
        this.generate = new Generate(this);
        
        this.maze = maze;
        this.ghosts = generate.ghosts;
        this.cookieSet = generate.cookieSet;
        this.heartSet = generate.heartSet;
        this.bombSet = generate.bombSet;
        this.movePac = new MovePac(this);       
    }
    
	 /**
     * Set one life less. Stop the pacman and ghosts. Set the pacman to the origin location.
     * If life equals to zero, game ended.
     */
    public void lifeLost() {
    	this.movePac.leftPacmanAnimation.stop();
    	this.movePac.rightPacmanAnimation.stop();
    	this.movePac.upPacmanAnimation.stop();
    	this.movePac.downPacmanAnimation.stop();
        for (Ghost ghost : this.ghosts) {
            ghost.getAnimation().stop();
        }
        pacman.setFill(new ImagePattern(new Image("inputFiles/pacman.png")));
        pacman.setCenterX(2.5 * BarObstacle.THICKNESS);
        pacman.setCenterY(2.5 * BarObstacle.THICKNESS);
        this.lifes--;
        
        this.score -= 10;
        this.scoreBoard.lifes.setText("Lifes: " + this.lifes);
        this.scoreBoard.score.setText("Score: " + this.score);
        if (this.lifes == 0) {
            this.endGame();
        }
    }

    
    /**
     * Ends the game, turn down the music, hide the current stage and show the score board page.
     */
    public void endGame() {
    	this.musicPlay.turnOff();
		Stage stage = (Stage)this.root.getScene().getWindow();
		stage.hide();
        
        ScoreList scorelist = new ScoreList(this.score);
        scorelist.updateList();
        
        Parent parent = null;
		try {
			parent = FXMLLoader.load(getClass().getResource("/application/view/ScoreBoard.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scene scoreBoard = new Scene(parent);
	    stage.setScene(scoreBoard);
	    stage.show();
        
    }
    
    
    /**
     * Ends the game if the pacman has eaten all cookies.
     */
    public void winGame() {
    	this.movePac.leftPacmanAnimation.stop();
    	this.movePac.rightPacmanAnimation.stop();
    	this.movePac.upPacmanAnimation.stop();
    	this.movePac.downPacmanAnimation.stop();
        for (Ghost ghost : this.ghosts) {
            ghost.getAnimation().stop();
        }
        this.endGame();
    } 
    
}
