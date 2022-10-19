package application.controller;


import java.util.Set;

import application.model.Animation;
import application.model.GameManager;
import application.model.Ghost;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;


/**
 * This class is use to move or stop the pacman by monitoring the player's key event.
 * It provides two methods: movePacman(), stopPacman().
 * When having a key event, pacman will move to that direction, if not, pacman will stop.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class MovePac{
	
	private Set<Ghost> ghosts;
	private GameManager gameManager;
    public AnimationTimer leftPacmanAnimation;
    public AnimationTimer rightPacmanAnimation;
    public AnimationTimer upPacmanAnimation;
    public AnimationTimer downPacmanAnimation;
    public Animation animation;

	/**
	 * Constructor
	 * Instantiate class Animation to create the animations of different directions from 
	 * @param gameManager - to get the ghost set in GameManager.
	 */
	public MovePac(GameManager gameManager) {
		this.gameManager = gameManager;
		this.ghosts = gameManager.ghosts;
		this.animation = new Animation(this.gameManager);
		this.leftPacmanAnimation = animation.createAnimation("left");
        this.rightPacmanAnimation = animation.createAnimation("right");
        this.upPacmanAnimation = animation.createAnimation("up");
        this.downPacmanAnimation = animation.createAnimation("down");
	}

	
    /**
     * Moves the pacman by monitoring the key event.
     * @param event - key event from user.
     */
    public void movePacman(KeyEvent event) {
        for (Ghost ghost : ghosts) {
            ghost.run();
        }
        switch(event.getCode()) {
            case RIGHT:
                this.rightPacmanAnimation.start();
                break;
            case LEFT:
                this.leftPacmanAnimation.start();
                break;
            case UP:
                this.upPacmanAnimation.start();
                break;
            case DOWN:
                this.downPacmanAnimation.start();
                break;
		default:
			break;
        }
    }

    /**
     * Stops the pacman if do not have key event
     * @param event - key event from user.
     */
    public void stopPacman(KeyEvent event) {
        switch(event.getCode()) {
            case RIGHT:
                this.rightPacmanAnimation.stop();
                break;
            case LEFT:
                this.leftPacmanAnimation.stop();
                break;
            case UP:
                this.upPacmanAnimation.stop();
                break;
            case DOWN:
                this.downPacmanAnimation.stop();
                break;
		default:
			break;
        }
    }   
    
	
}
