package application.model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 * Set the location, radius, value, image of the cookie.
 * 
 * When pacman eat the cookie, his score will increase.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class Cookie extends Circle {

    private int value;
    
    /**
     * Constructor. Set the location, radius, value, image of the cookie.
     * @param x - the x coordinate of the cookie.
     * @param y - the y coordinate of the cookie.
     */
    public Cookie(double x, double y) {
        this.value = 5;
        this.setCenterX(x);
        this.setCenterY(y);
        this.setRadius(12.5);
        Image cookie = new Image("inputFiles/cookie.png");
        this.setFill(new ImagePattern(cookie));
    }

    
    /**
     * get the value of cookie.
     * @return - return the value.
     */
    public int getValue() {
        return value;
    }
    
    
    /**
     * hide the cookie(after eating it)
     */
    public void hide() {
        this.setVisible(false);
    }
    
    
    /**
     * show the cookie.
     */
    public void show() {
        this.setVisible(true);
    }

}