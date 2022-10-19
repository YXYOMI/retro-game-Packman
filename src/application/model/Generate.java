package application.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * Generate ghosts, cookies and hearts for pacman.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class Generate {
	public Set<Ghost> ghosts;
	public Set<Cookie> cookieSet;
	public Set<Heart> heartSet;
	public Set<Bomb> bombSet;
	private GameManager gameManager;
	private GhostFactoryImpl ghostFactory;
	
	
	/**
	 * Constructor. create the hashSets for ghosts/cookies/hearts/bombs.
	 * @param gameManager - to pass the gameManager as a parameter to GhostFactoryImpl.
	 */
	public Generate(GameManager gameManager){
		this.ghosts = new HashSet<>();
		this.cookieSet = new HashSet<>();
		this.heartSet = new HashSet<>();
		this.bombSet = new HashSet<>();
		this.gameManager = gameManager;
		this.ghostFactory = new GhostFactoryImpl(gameManager);
	}
	
	
	/**
     * Generates the different ghosts for the pacman from teh ghost factory and add the ghosts to the ghosts set.
     * For "Easy" level, generate three ghost(with lower move speed). 
     * For "Normal" level, generate another faster ghost.
     * For "Hard" level, generate another two ghost.
     */ 
	public void generateGhost() {
    	
    	this.ghosts.add(ghostFactory.createGhost("green"));
    	this.ghosts.add(ghostFactory.createGhost("blue"));
    	this.ghosts.add(ghostFactory.createGhost("pink"));
    	
    	if(GameManager.difficulty == "Normal") {
    		this.ghosts.add(ghostFactory.createGhost("yellow"));
    	}else if(GameManager.difficulty == "Hard") {
    		this.ghosts.add(ghostFactory.createGhost("yellow"));
    		this.ghosts.add(ghostFactory.createGhost("yellow"));
    		this.ghosts.add(ghostFactory.createGhost("purple"));
    	}
    	
	}
	
	
	/**
     * Generates the cookies for the pacman.
     * Add the cookies to the cookie set.
     * For "normal" level, it will add four other cookies in the ghost home.
     * For "hard" level, it will change two random cookies to bombs.
     */ 
	 public void generateCookies() {
	    	Integer skip[] = {5, 17};
	        for (int i = 1; i < 23; i++) {
	            if (!Arrays.asList(skip).contains(i)) {
	                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 2.5 * BarObstacle.THICKNESS);
	                this.cookieSet.add(cookie);
	            }
	        }

	        // 2nd line
	        skip = new Integer[]{1, 2, 3, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 19, 20, 21};
	        for (int i = 0; i < 23; i++) {
	            if (!Arrays.asList(skip).contains(i)) {
	                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 4.5 * BarObstacle.THICKNESS);
	                this.cookieSet.add(cookie);
	            }
	        }

	        // 3rd line
	        skip = new Integer[]{1, 21};
	        for (int i = 0; i < 23; i++) {
	            if (!Arrays.asList(skip).contains(i)) {
	                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 6.5 * BarObstacle.THICKNESS);
	                this.cookieSet.add(cookie);
	            }
	        }

	        // 4th line
	        skip = new Integer[]{1, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 21};
	        for (int i = 0; i < 23; i++) {
	            if (!Arrays.asList(skip).contains(i)) {
	                Cookie cookie = new Cookie(((2 * i) + 2.5) * BarObstacle.THICKNESS, 8.5 * BarObstacle.THICKNESS);
	                this.cookieSet.add(cookie);
	            }
	        }

	        // 5th line
	        skip = new Integer[]{1, 7, 8, 9, 10, 11, 12, 13, 14, 15, 21};
	        for (int i = 0; i < 23; i++) {
	            if (!Arrays.asList(skip).contains(i)) {
	                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 10.5 * BarObstacle.THICKNESS);
	                this.cookieSet.add(cookie);
	            }
	        }

	        // 6th line
	        skip = new Integer[]{3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19};
	        for (int i = 0; i < 23; i++) {
	            if (!Arrays.asList(skip).contains(i)) {
	                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 12.5 * BarObstacle.THICKNESS);
	                this.cookieSet.add(cookie);
	            }
	        }

	        // 7th line
	        skip = new Integer[]{1, 7, 8, 9, 10, 11, 12, 13, 14, 15, 21};
	        for (int i = 0; i < 23; i++) {
	            if (!Arrays.asList(skip).contains(i)) {
	                Cookie cookie = new Cookie(((2 * i) + 2.5) * BarObstacle.THICKNESS, 14.5 * BarObstacle.THICKNESS);
	                this.cookieSet.add(cookie);
	            }
	        }

	        // 8th line
	        skip = new Integer[]{1, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 21};
	        for (int i = 0; i < 23; i++) {
	            if (!Arrays.asList(skip).contains(i)) {
	                Cookie cookie = new Cookie(((2 * i) + 2.5) * BarObstacle.THICKNESS, 16.5 * BarObstacle.THICKNESS);
	                this.cookieSet.add(cookie);
	            }
	        }

	        // 9th line
	        skip = new Integer[]{1, 21};
	        for (int i = 0; i < 23; i++) {
	            if (!Arrays.asList(skip).contains(i)) {
	                Cookie cookie = new Cookie(((2 * i) + 2.5) * BarObstacle.THICKNESS, 18.5 * BarObstacle.THICKNESS);
	                this.cookieSet.add(cookie);
	            }
	        }

	        // 10th line
	        skip = new Integer[]{1, 2, 3, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 19, 20, 21};
	        for (int i = 0; i < 23; i++) {
	            if (!Arrays.asList(skip).contains(i)) {
	                Cookie cookie = new Cookie(((2 * i) + 2.5) * BarObstacle.THICKNESS, 20.5 * BarObstacle.THICKNESS);
	                this.cookieSet.add(cookie);
	            }
	        }

	        // 11th line
	        skip = new Integer[]{5, 17};
	        for (int i = 0; i < 23; i++) {
	            if (!Arrays.asList(skip).contains(i)) {
	                Cookie cookie = new Cookie(((2 * i) + 2.5) * BarObstacle.THICKNESS, 22.5 * BarObstacle.THICKNESS);
	                this.cookieSet.add(cookie);
	            }
	        }
	        
	        if(GameManager.difficulty == "Normal") {
		        
	        	//add cookies in the ghost home.
		        Integer newcookies[] = new Integer[] {9, 10, 12, 13};
		        for(int i = 0; i < 4; i++) {
		        	Cookie cookie = new Cookie(((2 * newcookies[i]) + 2.5) * BarObstacle.THICKNESS, 12.5 * BarObstacle.THICKNESS);
		        	this.cookieSet.add(cookie);
		        }	        
	        }else if (GameManager.difficulty == "Hard"){
	        	
	        	//add cookies in the ghost home.
		        Integer newcookies[] = new Integer[] {9, 10, 12, 13};
		        for(int i = 0; i < 4; i++) {
		        	Cookie cookie = new Cookie(((2 * newcookies[i]) + 2.5) * BarObstacle.THICKNESS, 12.5 * BarObstacle.THICKNESS);
		        	this.cookieSet.add(cookie);
		        }
		        
	            //change two random cookies to bombs (when pacman eat it, lifes will reduce)
	        	Iterator<Cookie> it = cookieSet.iterator();
	        	int i = 0;
	            while(it.hasNext()) {
	            	Cookie cookie = it.next();
	            	double x = cookie.getCenterX();
	            	double y = cookie.getCenterY();
	            	cookie.hide();
	            	gameManager.cookiesEaten ++;
	            	Bomb bomb = new Bomb(x,y);
	            	this.bombSet.add(bomb);
	            	i++;
	            	if(i == 2)
	            		break;
	            }
	        }
	    }
	 
	 /**
	  * Generates the "heart" for the pacman.
	  * Add the life to the life set.
	  */ 
	    
	 public void generateHeart() {
	    	Heart heart = new Heart(24.5 * BarObstacle.THICKNESS, 12.5 * BarObstacle.THICKNESS);
	    	this.heartSet.add(heart);
	    }
	
}
