package application.model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


/**
 * Set the location, radius and image of the bomb. 
 * method hide() and show() set it is visible or not.
 * 
 * When pacman eat the bomb, his life will decrease and location will back to origin.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class Bomb extends Circle{
		
	
	    /**
	     * Constructor.Set the location, radius and image of the bomb. 
	     * @param x - the x coordinate of the bomb.
	     * @param y - the y coordinate of the bomb.
	     */
		public Bomb(double x, double y) {
			Image bomb = new Image("inputFiles/skull.png");
			this.setCenterX(x);
			this.setCenterY(y);
			this.setRadius(16);
			this.setFill(new ImagePattern(bomb));
		} 

		/**
		 * Hide the bomb.(after eating it)
		 */
	    public void hide() {
	        this.setVisible(false);
	    }
        
	    /**
	     * Show the bomb.
	     */
	    public void show() {
	        this.setVisible(true);
	    }
	
}
