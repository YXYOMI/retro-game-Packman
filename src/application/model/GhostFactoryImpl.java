package application.model;

/**
 * This is the ghost factory implement.
 * It can create different ghost inside the class.
 * @author @author Xinyi OUYANG / 20030865
 *
 */
public class GhostFactoryImpl implements GhostFactory{
	
	private GameManager gameManager;
	
	public GhostFactoryImpl(GameManager gameManager) {
		this.gameManager = gameManager;
	}
	
	/**
	 * create different ghost (with different color, speed, location and route).
	 */
	public Ghost createGhost(String color) {
	    	switch(color) {
	    	    case"green":
	    	    	return new GhostGreen(gameManager);
	    	    case"blue":
	    	    	return new GhostBlue(gameManager);
	    	    case"pink":
	    	    	return new GhostPink(gameManager);
	    	    case"yellow":
	    	    	return new GhostYellow(gameManager);
	    	    case"purple":
	    	        return new GhostPurple(gameManager);
	    	}
		return null;
	}

}
