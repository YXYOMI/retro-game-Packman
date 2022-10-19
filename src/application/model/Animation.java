package application.model;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;


/**
 * This class provides a method to Create the animations of pacman's movements.
 * @authorXinyi OUYANG / 20030865
 *
 */
public class Animation{

	public Maze maze;
	private Pacman pacman;
	private Check check;
	
	public Animation(GameManager gameManager){
		this.maze = gameManager.maze;
		this.pacman = Pacman.getPacman();
		this.check = new Check(gameManager);
		
	}
	
	
    /**
     * Creates an animation of the movement. 
     * When changing the move direction of pacman, his mouse will change to that direction.
     * @param direction - the direction that pacman move to.
     * @return return the animation.
     */
    public AnimationTimer createAnimation(String direction) {
    	Image right = new Image("inputFiles/pacman.png");
    	Image left = new Image("inputFiles/pacmanLeft.png");
    	Image up = new Image("inputFiles/pacmanUp.png");
    	Image down = new Image("inputFiles/pacmanDown.png");
    	
        double step = 5;
    	
        return new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
            switch (direction) {
                case "left":
                	pacman.setFill(new ImagePattern(left));
                    if (!maze.isTouching(pacman.getCenterX() - pacman.getRadius(), pacman.getCenterY(), 15)) {
                        pacman.setCenterX(pacman.getCenterX() - step);
                        check.checkCookieCoalition("x");
                        check.checkGhostCoalition();
                        check.checkPacmanGate();
                        check.checkHeartCoalition("x");
                        check.checkBombCoalition("x");
                    }
                    break;
                case "right":
                	pacman.setFill(new ImagePattern(right));
                    if (!maze.isTouching(pacman.getCenterX() + pacman.getRadius(), pacman.getCenterY(), 15)) {
                        pacman.setCenterX(pacman.getCenterX() + step);
                        check.checkCookieCoalition("x");
                        check.checkGhostCoalition();
                        check.checkPacmanGate();
                        check.checkHeartCoalition("x");
                        check.checkBombCoalition("x");
                    }
                    break;
                case "up":
                	pacman.setFill(new ImagePattern(up));
                    if (!maze.isTouching(pacman.getCenterX(), pacman.getCenterY() - pacman.getRadius(), 15)) {
                        pacman.setCenterY(pacman.getCenterY() - step);
                        check.checkCookieCoalition("y");
                        check.checkGhostCoalition();
                        check.checkPacmanGate();
                        check.checkHeartCoalition("y");
                        check.checkBombCoalition("y");
                    }
                    break;
                case "down":
                	pacman.setFill(new ImagePattern(down));
                   if (!maze.isTouching(pacman.getCenterX(), pacman.getCenterY() + pacman.getRadius(), 15)) {
                       pacman.setCenterY(pacman.getCenterY() + step);
                       check.checkCookieCoalition("y");
                       check.checkGhostCoalition();
                       check.checkPacmanGate();
                       check.checkHeartCoalition("y");
                       check.checkBombCoalition("y");
                   }
                   break;
            }
            }
        };
    }

	
}
