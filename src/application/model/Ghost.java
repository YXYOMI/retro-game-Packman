package application.model;

import javafx.animation.AnimationTimer;
import javafx.scene.shape.Rectangle;

import java.util.Random;

/**
 * This class provides the methods to support the basic algorithms for all kinds of ghosts.
 * All different kinds of ghosts extends this class.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class Ghost extends Rectangle implements Runnable{

    String direction;
    GameManager gameManager;
    Maze maze;
    AnimationTimer animation;
    int timesWalked;
    double step;
    Check check;

    /**
     * Constructor. Set the size of ghost and the default direction to move.
     * @param gameManager - to get the variables in GameManager.
     */
    public Ghost(GameManager gameManager) {
    	this.gameManager = gameManager;
    	this.maze = gameManager.maze;
    	this.setHeight(50);
        this.setWidth(50);
        this.timesWalked = 0;
        this.direction = "down"; 
        this.check = new Check(gameManager);
        
    }
    
    /**
     * get the random direction exclude the variables.
     * @param exclude1 - the exclude direction.(do not move to that direction)
     * @param exclude2 - the exclude direction.(do not move to that direction)
     * @return return the direction.
     */
    private String getRandomDirection(String exclude1, String exclude2) {
        String[] directions = {"left", "right", "up", "down"};
        int rnd = new Random().nextInt(directions.length);
        while (directions[rnd].equals(exclude1) || directions[rnd].equals(exclude2)) {
            rnd = new Random().nextInt(directions.length);
        }
        return directions[rnd];
    }

    /**
     * Gets the animation for the ghost
     * @return return the animation.
     */
    public AnimationTimer getAnimation() {
        return animation;
    }

    /**
     * Check if the direction has path to go.
     * @param direction - the direction to check.
     */
    private void checkIftheresPathToGo(String direction) {
        double rightEdge, leftEdge, topEdge, bottomEdge;
        switch (direction) {
            case "down":
                leftEdge = getX() - 10;
                bottomEdge = getY() + getHeight() + 15;
                rightEdge = getX() + getWidth() + 10;
                if (!maze.hasObstacle(leftEdge, rightEdge, bottomEdge - 1, bottomEdge)) {
                    this.direction = direction;
                }
                break;
            case "up":
                leftEdge = getX() - 10;
                rightEdge = getX() + getWidth() + 10;
                topEdge = getY() - 15;
                if (!maze.hasObstacle(leftEdge, rightEdge, topEdge - 1, topEdge)) {
                    this.direction = direction;
                }
                break;
            case "left":
                leftEdge = getX() - 15;
                bottomEdge = getY() + getHeight() + 10;
                topEdge = getY() - 10;
                if (!maze.hasObstacle(leftEdge - 1, leftEdge, topEdge, bottomEdge)) {
                    this.direction = direction;
                }
                break;
            case "right":
                bottomEdge = getY() + getHeight() + 10;
                rightEdge = getX() + getWidth() + 15;
                topEdge = getY() - 10;
                if (!maze.hasObstacle(rightEdge - 1, rightEdge, topEdge, bottomEdge)) {
                    this.direction = direction;
                }
                break;
        }
    }

    /**
     * move the ghost until there is no way to go.
     * @param whereToGo - the direction to go.
     * @param whereToChangeTo - the next direction to go.
     * @param leftEdge - the left edge of the ghost.
     * @param topEdge - the top edge of the ghost.
     * @param rightEdge - the right edge of the ghost.
     * @param bottomEdge - the bottom of the ghost
     * @param padding - the distance between the ghost and the obstacle.
     */
    public void moveUntilYouCant(String whereToGo, String whereToChangeTo, double leftEdge, double topEdge, double rightEdge, double bottomEdge, double padding) {
        switch (whereToGo) {
            case "left":
                if (!maze.isTouching(leftEdge, topEdge, padding)) {
                    setX(leftEdge - step);
                } else {
                    while (maze.isTouching(getX(), getY(), padding)) {
                        setX(getX() + 1);
                    }
                    direction = whereToChangeTo;
                }
                break;
            case "right":
                if (!maze.isTouching(rightEdge, topEdge, padding)) {
                    setX(leftEdge + step);
                } else {
                    while (maze.isTouching(getX() + getWidth(), getY(), padding)) {
                        setX(getX() - 1);
                    }
                    direction = whereToChangeTo;
                }
                break;
            case "up":
                if (!maze.isTouching(leftEdge, topEdge, padding)) {
                    setY(topEdge - step);
                } else {
                    while (maze.isTouching(getX(), getY(), padding)) {
                        setY(getY() + 1);
                    }
                    direction = "left";
                }
                break;
            case "down":
                if (!maze.isTouching(leftEdge, bottomEdge, padding)) {
                    setY(topEdge + step);
                } else {
                    while (maze.isTouching(getX(), getY() + getHeight(), padding)) {
                        setY(getY() - 1);
                    }
                    direction = "right";
                }
                break;
        }
    }
    


    /**
     * Creates an animation of the ghost
     */
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
                            checkIftheresPathToGo(getRandomDirection("left", "right"));
                            timesWalked = 0;
                        }
                        break;
                    case "right":
                        moveUntilYouCant("right", "up", leftEdge, topEdge, rightEdge, bottomEdge, padding);
                        if (timesWalked > walkAtLeast) {
                            checkIftheresPathToGo(getRandomDirection("left", "right"));
                            timesWalked = 0;
                        }
                        break;
                    case "up":
                        moveUntilYouCant("up", "left", leftEdge, topEdge, rightEdge, bottomEdge, padding);
                        if (timesWalked > walkAtLeast) {
                            checkIftheresPathToGo(getRandomDirection("up", "down"));
                            timesWalked = 0;
                        }
                        break;
                    case "down":
                        moveUntilYouCant("down", "right", leftEdge, topEdge, rightEdge, bottomEdge, padding);
                        if (timesWalked > walkAtLeast) {
                            checkIftheresPathToGo(getRandomDirection("up", "down"));
                            timesWalked = 0;
                        }
                        break;
                }
            }
        };
    }
    

    @Override
    public void run() {
        this.animation.start();
    }
}
