package application.model;


/**
 * This class creates the object Grade with the combination of the score and the level.
 * @author Xinyi OUYANG / 20030865
 */
public class Grade {
	private int score;
	private String difficulty;
	
	/**
	 * Constructor. set the score and the difficulty
	 * @param score - the score of this round.
	 * @param difficulty - the level of this round.
	 */
	public Grade(int score, String difficulty) {
		this.score = score;
		this.difficulty = difficulty;
	}
	
	/**
	 * Set the score
	 * @param score - the score of this round.
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * Set the level
	 * @param difficulty - the level of this round.
	 */
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	/**
	 * Get the score.
	 * @return return the score.
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Get the level.
	 * @return return the level.
	 */
	public String getDifficulty() {
		return difficulty;
	}

}
