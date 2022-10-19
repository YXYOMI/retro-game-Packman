package application.model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;


/**
 * This class extends class Ghost.
 * Generate the blue ghost. Set its location, step and image. then create the animation.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class GhostBlue extends Ghost{

	/**
	 * Set the location, step and image. then create the animation.
	 * @param gameManager - to get the variables in GameManager (extends its super class)
	 */
	public GhostBlue(GameManager gameManager) {
		super(gameManager);
		this.setX(28.5 * BarObstacle.THICKNESS);
		this.setY(12.5 * BarObstacle.THICKNESS);
		this.setFill(new ImagePattern(new Image("inputFiles/ghost2.png")));
		this.step = 5;
		this.createAnimation();
	}



}
