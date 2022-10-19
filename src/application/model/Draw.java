package application.model;

import java.util.Set;

import javafx.scene.Group;

/**
 * This class is used to draw the board of the game with the cookies, ghost, hearts, bombs and the pacman.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class Draw {
	
	private GameManager gameManager;
	private Maze maze;
	private Generate generate;
    private Group root;
    private Set<Ghost> ghosts;
    private Set<Cookie> cookieSet;
    private Set<Heart> heartSet;
    public Set<Bomb> bombSet;
	
    /**
     * Constructor.
     * @param gameManager - to get the variables in the GameManager such as ghosts, cookieSet.
     */
	public Draw(GameManager gameManager) {
		
		this.gameManager = gameManager;
		this.maze = gameManager.maze;
		this.root = gameManager.root;
		this.generate = gameManager.generate;
		this.ghosts = gameManager.ghosts;
		this.cookieSet = gameManager.cookieSet;
		this.heartSet = gameManager.heartSet;		
		this.bombSet = gameManager.bombSet;
	}
	
	
	/**
	 * Draw the game board. include maze, ghosts, cookies, hearts, bombs, scores and pacman. 
	 * Add them into the root of the stage.
	 */
	public void drawBoard() {
		maze.CreateMaze(root);
		
		generate.generateGhost();
		generate.generateCookies();
		generate.generateHeart();
		
		root.getChildren().addAll(heartSet);
		root.getChildren().addAll(bombSet);
		root.getChildren().addAll(cookieSet);
		root.getChildren().add(Pacman.getPacman());
		root.getChildren().addAll(ghosts);
		
		gameManager.scoreBoard = new Score(root);
	}
}
