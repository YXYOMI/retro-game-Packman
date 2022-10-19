package application.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 * Set the location, height, width, color of the bar obstacle.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class BarObstacle extends Rectangle {

    public static double THICKNESS = 25;
    public static Color wallColor = Color.CADETBLUE;

    
    /**
     * Constructor.Set the location, height, width, color of the bar obstacle.
     * @param x - the x coordinate of the obstacle.
     * @param y - the y coordinate of the obstacle.
     * @param orientation - horizontal or vertical
     * @param length - the length of the bar (1 == 100px)
     */
    public BarObstacle(double x, double y, String orientation, double length) {
    	
    	this.setX(x);
        this.setY(y);
        if (orientation.equals("horizontal")) {
            this.setHeight(BarObstacle.THICKNESS);
            this.setWidth(length * BarObstacle.THICKNESS);
        } else {
            this.setHeight(length * BarObstacle.THICKNESS);
            this.setWidth(BarObstacle.THICKNESS);
        }

        this.setFill(wallColor);
        this.setStrokeWidth(3);
    }
}
