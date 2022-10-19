package application.model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;


/**
 * This class extends class Ghost.
 * Generate the pink ghost. Set its location, step and image. then create the animation.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class GhostPink extends Ghost{

	/**
	 * Set the location, step and image. then create the animation.
	 * @param gameManager - to get the variables in GameManager (extends its super class)
	 */
	public GhostPink(GameManager gameManager) {
		super(gameManager);
		this.setX(18.5 * BarObstacle.THICKNESS);
		this.setY(12.5 * BarObstacle.THICKNESS);
		this.setFill(new ImagePattern(new Image("inputFiles/ghost3.png")));
		this.step = 5;
		this.createAnimation();
	}


}
