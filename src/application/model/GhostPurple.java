package application.model;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * This class extends class Ghost.
 * Generate the purple ghost. Set its location, step and image. then create the animation.
 * 
 * This ghost will tour inside the ghost home.
 * And it will be created in "Hard" lever.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class GhostPurple extends Ghost{

	/**
	 * Set the location, step and image. then create the animation.
	 * @param gameManager - to get the variables in GameManager (extends its super class)
	 */
	public GhostPurple(GameManager gameManager) {
		super(gameManager);
		this.setX(18.5 * BarObstacle.THICKNESS);
		this.setY(9.5 * BarObstacle.THICKNESS);
		this.setFill(new ImagePattern(new Image("inputFiles/ghost5.png")));
		this.step = 6;
		this.direction = "up";
		this.createAnimation();
	}
	
	/**
	 * override the createAnimation(). change its route (to tour inside the ghost home).
	 */
	@Override
	public void createAnimation() {
		 this.animation = new AnimationTimer()
	        {
	            public void handle(long currentNanoTime)
	            {
	                check.checkGhostCoalition();
	                check.checkGhostGate();
	                double leftEdge = getX();
	                double topEdge = getY();
	                double rightEdge = getX() + getWidth();
	                double bottomEdge = getY() + getHeight();
	                double padding = 12;
	                timesWalked++;
	                int walkAtLeast = 4;
	                switch (direction) {
	                    case "left":
	                        moveUntilYouCant("left", "down", leftEdge, topEdge, rightEdge, bottomEdge, padding);
	                        if (timesWalked > walkAtLeast) {
	                            timesWalked = 0;
	                        }
	                        break;
	                    case "right":
	                        moveUntilYouCant("right", "up", leftEdge, topEdge, rightEdge, bottomEdge, padding);
	                        if (timesWalked > walkAtLeast) {
	                            timesWalked = 0;
	                        }
	                        break;
	                    case "up":
	                        moveUntilYouCant("up", "left", leftEdge, topEdge, rightEdge, bottomEdge, padding);
	                        if (timesWalked > walkAtLeast) {
	                            timesWalked = 0;
	                        }
	                        break;
	                    case "down":
	                        moveUntilYouCant("down", "right", leftEdge, topEdge, rightEdge, bottomEdge, padding);
	                        if (timesWalked > walkAtLeast) {
	                            timesWalked = 0;
	                        }
	                        break;
	                }
	            }
	        };
	}


}
