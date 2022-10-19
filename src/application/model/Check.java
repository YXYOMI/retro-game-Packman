package application.model;


/**
 * This class is used to check whether the pacman get the cookie/ghost/bomb/heart/gate when it move. and check whether the ghost get the gate.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class Check{
    
	public GameManager gameManager;
	private Pacman pacman;

	/**
	 * Constructor. get the pacman from the getPacman() methods in the singleton pattern Pacman.
	 * @param gameManager - to use the the variables in this class such as cookiesEaten, score and so on.
	 */
	public Check(GameManager gameManager) {
		this.gameManager = gameManager;
		this.pacman = Pacman.getPacman();
	}
	
	
	
    /**
     * Checks if the Pacman touches cookies. if touch it, the score and cookiesEaten will increase. and update the score in the game page.
     * If pacman eat all cookies in the cookieSet, it win the game.
     * @param axis - the string on behalf of the the direction that pacman move. (horizontal / vertical)
     */
    public void checkCookieCoalition(String axis) {
        double pacmanCenterY = pacman.getCenterY();
        double pacmanCenterX = pacman.getCenterX();
        double pacmanLeftEdge = pacmanCenterX - pacman.getRadius();
        double pacmanRightEdge = pacmanCenterX + pacman.getRadius();
        double pacmanTopEdge = pacmanCenterY - pacman.getRadius();
        double pacmanBottomEdge = pacmanCenterY + pacman.getRadius();
        for (Cookie cookie:gameManager.cookieSet) {
            double cookieCenterX = cookie.getCenterX();
            double cookieCenterY = cookie.getCenterY();
            double cookieLeftEdge = cookieCenterX - cookie.getRadius();
            double cookieRightEdge = cookieCenterX + cookie.getRadius();
            double cookieTopEdge = cookieCenterY - cookie.getRadius();
            double cookieBottomEdge = cookieCenterY + cookie.getRadius();
            if (axis.equals("x")) {
                // pacman goes right
                if ((cookieCenterY >= pacmanTopEdge && cookieCenterY <= pacmanBottomEdge) && (pacmanRightEdge >= cookieLeftEdge && pacmanRightEdge <= cookieRightEdge)) {
                    if (cookie.isVisible()) {
                    	gameManager.score += cookie.getValue();
                    	gameManager.cookiesEaten++;
                    	if (gameManager.cookiesEaten == gameManager.cookieSet.size()) {
                        	gameManager.winGame();      
                        }
                    }
                    cookie.hide();
                }
                // pacman goes left
                if ((cookieCenterY >= pacmanTopEdge && cookieCenterY <= pacmanBottomEdge) && (pacmanLeftEdge >= cookieLeftEdge && pacmanLeftEdge <= cookieRightEdge)) {
                    if (cookie.isVisible()) {
                    	gameManager.score += cookie.getValue();
                    	gameManager.cookiesEaten++;
                    	if (gameManager.cookiesEaten == gameManager.cookieSet.size()) {
                    		gameManager.winGame();      
                        }
                    }
                    cookie.hide();
                }
            } else {
                // pacman goes up
                if ((cookieCenterX >= pacmanLeftEdge && cookieCenterX <= pacmanRightEdge) && (pacmanBottomEdge >= cookieTopEdge && pacmanBottomEdge <= cookieBottomEdge)) {
                    if (cookie.isVisible()) {
                    	gameManager.score += cookie.getValue();
                    	gameManager.cookiesEaten++;
                    	if (gameManager.cookiesEaten == gameManager.cookieSet.size()) {
                    		gameManager.winGame();      
                        }
                    }
                    cookie.hide();
                }
                // pacman goes down
                if ((cookieCenterX >= pacmanLeftEdge && cookieCenterX <= pacmanRightEdge) && (pacmanTopEdge <= cookieBottomEdge && pacmanTopEdge >= cookieTopEdge)) {
                    if (cookie.isVisible()) {
                    	gameManager.score += cookie.getValue();
                    	gameManager.cookiesEaten++;
                    	if (gameManager.cookiesEaten == gameManager.cookieSet.size()) {
                    		gameManager.winGame();      
                        }
                    }
                    cookie.hide();
                }
            }
            gameManager.scoreBoard.score.setText("Score: " + gameManager.score);
        }
    }
    

    /**
     * Checks if pacman is touching a ghost. If so, life will lost and location will back to the origin.
     */
    public void checkGhostCoalition() {
        double pacmanCenterY = pacman.getCenterY();
        double pacmanCenterX = pacman.getCenterX();
        double pacmanLeftEdge = pacmanCenterX - pacman.getRadius();
        double pacmanRightEdge = pacmanCenterX + pacman.getRadius();
        double pacmanTopEdge = pacmanCenterY - pacman.getRadius();
        double pacmanBottomEdge = pacmanCenterY + pacman.getRadius();
        for (Ghost ghost : gameManager.ghosts) {
            double ghostLeftEdge = ghost.getX();
            double ghostRightEdge = ghost.getX() + ghost.getWidth();
            double ghostTopEdge = ghost.getY();
            double ghostBottomEdge = ghost.getY() + ghost.getHeight();
            if ((pacmanLeftEdge <= ghostRightEdge && pacmanLeftEdge >= ghostLeftEdge) || (pacmanRightEdge >= ghostLeftEdge && pacmanRightEdge <= ghostRightEdge)) {
                if ((pacmanTopEdge <= ghostBottomEdge && pacmanTopEdge >= ghostTopEdge) || (pacmanBottomEdge >= ghostTopEdge && pacmanBottomEdge <= ghostBottomEdge)) {
                	gameManager.lifeLost();
                }
            }
        }
    }
    
    /**
     * Check if pacman touches a "heart". If so, the life will increase and will update the lifes on the game page.
     * @param axis - the string on behalf of the the direction that pacman move. (horizontal / vertical)
     */
    public void checkHeartCoalition(String axis) {
    	double pacmanCenterY = pacman.getCenterY();
        double pacmanCenterX = pacman.getCenterX();
        double pacmanLeftEdge = pacmanCenterX - pacman.getRadius();
        double pacmanRightEdge = pacmanCenterX + pacman.getRadius();
        double pacmanTopEdge = pacmanCenterY - pacman.getRadius();
        double pacmanBottomEdge = pacmanCenterY + pacman.getRadius();
        for (Heart heart:gameManager.heartSet) {
            double heartCenterX = heart.getCenterX();
            double heartCenterY = heart.getCenterY();
            double heartLeftEdge = heartCenterX - heart.getRadius();
            double heartRightEdge = heartCenterX + heart.getRadius();
            double heartTopEdge = heartCenterY - heart.getRadius();
            double heartBottomEdge = heartCenterY + heart.getRadius();
            if (axis.equals("x")) {
                // pacman goes right
                if ((heartCenterY >= pacmanTopEdge && heartCenterY <= pacmanBottomEdge) && (pacmanRightEdge >= heartLeftEdge && pacmanRightEdge <= heartRightEdge)) {
                    if (heart.isVisible()) {
                    	gameManager.lifes ++;
                    }
                    heart.hide();
                }
                // pacman goes left
                if ((heartCenterY >= pacmanTopEdge && heartCenterY <= pacmanBottomEdge) && (pacmanLeftEdge >= heartLeftEdge && pacmanLeftEdge <= heartRightEdge)) {
                	if (heart.isVisible()) {
                    	gameManager.lifes ++;
                    }
                	heart.hide();
                }
            } else {
                // pacman goes up
                if ((heartCenterX >= pacmanLeftEdge && heartCenterX <= pacmanRightEdge) && (pacmanBottomEdge >= heartTopEdge && pacmanBottomEdge <= heartBottomEdge)) {
                	if (heart.isVisible()) {
                    	gameManager.lifes ++;
                    }
                	heart.hide();
                }
                // pacman goes down
                if ((heartCenterX >= pacmanLeftEdge && heartCenterX <= pacmanRightEdge) && (pacmanTopEdge <= heartBottomEdge && pacmanTopEdge >= heartTopEdge)) {
                	if (heart.isVisible()) {
                    	gameManager.lifes ++;
                    }
                	heart.hide();
                }
            }
            gameManager.scoreBoard.lifes.setText("Life: " + gameManager.lifes);
        }
    }
    
    
    /**
     * Check if pacman touches a "bomb". If so, life will lost and location will back to the origin.
     * @param axis - the string on behalf of the the direction that pacman move. (horizontal / vertical)
     */
    public void checkBombCoalition(String axis) {
    	double pacmanCenterY = pacman.getCenterY();
        double pacmanCenterX = pacman.getCenterX();
        double pacmanLeftEdge = pacmanCenterX - pacman.getRadius();
        double pacmanRightEdge = pacmanCenterX + pacman.getRadius();
        double pacmanTopEdge = pacmanCenterY - pacman.getRadius();
        double pacmanBottomEdge = pacmanCenterY + pacman.getRadius();
        for (Bomb bomb:gameManager.bombSet) {
            double bombCenterX = bomb.getCenterX();
            double bombCenterY = bomb.getCenterY();
            double bombLeftEdge = bombCenterX - bomb.getRadius();
            double bombRightEdge = bombCenterX + bomb.getRadius();
            double bombTopEdge = bombCenterY - bomb.getRadius();
            double bombBottomEdge = bombCenterY + bomb.getRadius();
            if (axis.equals("x")) {
                // pacman goes right
                if ((bombCenterY >= pacmanTopEdge && bombCenterY <= pacmanBottomEdge) && (pacmanRightEdge >= bombLeftEdge && pacmanRightEdge <= bombRightEdge)) {
                	if (bomb.isVisible()) {
                		bomb.hide();
                		gameManager.lifeLost();
                	}
                }
                // pacman goes left
                if ((bombCenterY >= pacmanTopEdge && bombCenterY <= pacmanBottomEdge) && (pacmanLeftEdge >= bombLeftEdge && pacmanLeftEdge <= bombRightEdge)) {
                	if (bomb.isVisible()) {
                		bomb.hide();
                		gameManager.lifeLost();
                	}
                }
            } else {
                // pacman goes up
                if ((bombCenterX >= pacmanLeftEdge && bombCenterX <= pacmanRightEdge) && (pacmanBottomEdge >= bombTopEdge && pacmanBottomEdge <= bombBottomEdge)) {
                	if (bomb.isVisible()) {
                		bomb.hide();
                		gameManager.lifeLost();
                	}
                }
                // pacman goes down
                if ((bombCenterX >= pacmanLeftEdge && bombCenterX <= pacmanRightEdge) && (pacmanTopEdge <= bombBottomEdge && pacmanTopEdge >= bombTopEdge)) {
                	
                	if (bomb.isVisible()) {
                		bomb.hide();
                		gameManager.lifeLost();
                	}
                }
            }
            gameManager.scoreBoard.lifes.setText("Life: " + gameManager.lifes);
        }
    }
    
    /**
     * Check if pacman is move into the gate. If so, the location will change to the other gate.
     */
	public void checkPacmanGate() {
		double pacmanCenterX = pacman.getCenterX();
		if(pacmanCenterX < 0.5 * BarObstacle.THICKNESS) 
			pacman.setCenterX(48 * BarObstacle.THICKNESS);
		
		if(pacmanCenterX > 48 * BarObstacle.THICKNESS) 
			pacman.setCenterX(0.5 * BarObstacle.THICKNESS);
		
	}
	
	/**
	 * Check if ghost is move into the gate. If so, the location will change to the other gate.
	 */
	public void checkGhostGate() {
		for (Ghost ghost : gameManager.ghosts) {
			double ghostCenterX = ghost.getX();
			if(ghostCenterX < 0.5 * BarObstacle.THICKNESS) 
				ghost.setX(48 * BarObstacle.THICKNESS);
			
			if(ghostCenterX > 48 * BarObstacle.THICKNESS)
				ghost.setX(0.5 * BarObstacle.THICKNESS);
		}
	}
	
}