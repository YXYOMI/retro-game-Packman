package application.model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


/**
 * It is a singleton pattern. Because nomatter you continue the game or restart the game, the pacman is the only one pacman during the whole game.
 * 
 * This class generate the pacman inside it.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class Pacman extends Circle{
	
	private static Pacman pacman = new Pacman(2.5 * BarObstacle.THICKNESS, 2.5 * BarObstacle.THICKNESS);

	/**
	 * Set the radius, location and image for pacman.
	 * @param x - the x coordinate for pacman.
	 * @param y - the y coordinate for pacman.
	 */
    private Pacman(double x, double y) {
        this.setCenterX(x);
        this.setCenterY(y);
        this.setRadius(25);
        Image pacman = new Image("inputFiles/pacman.png");
        this.setFill(new ImagePattern(pacman));
    }
    
    /**
     * Get the pacman.
     * @return return the pacman.
     */
    public static Pacman getPacman() {
    	return pacman;
    }
    
}