package application.model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


/**
 * Set the location, radius and image of the heart. 
 * method hide() and show() set it is visible or not.
 * 
 * When pacman eat it, his life will increase.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class Heart extends Circle{
	
	/**
	 * Constructor.Set the location, radius and image of the heart. 
	 * @param x - the x coordinate of the heart.
	 * @param y - the y coordinate of the heart.
	 */
	public Heart(double x, double y) {
		Image heart = new Image("inputFiles/heart.png");
		this.setCenterX(x);
		this.setCenterY(y);
		this.setRadius(13);
		this.setFill(new ImagePattern(heart));
	} 
	

	/**
	 *  Hide the heart (after eating it).
	 */
    public void hide() {
        this.setVisible(false);
    }

    /**
     * Show the heart.
     */
    public void show() {
        this.setVisible(true);
    }

}
