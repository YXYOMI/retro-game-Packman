package application.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is used to generate the permanent high score list.
 * It provides methods to read the score file, add text to the file, sort the file and update the arrayList that save the grades.
 * 
 * @author Xinyi OUYANG / 20030865
 *
 */
public class ScoreList {
	
	public static ArrayList<Grade> grades;
	private int score;
	private String difficulty;
	
	/**
	 * Create a new arrayList for all the grades.
	 * @param score - the score of this round.
	 */
	public ScoreList(int score) {

		grades = new ArrayList<Grade>();
		this.score = score;
		this.difficulty = GameManager.difficulty;
		
	}
	
	/**
	 * get the new sorted arrayList for all grades.
	 */
	public void updateList() {
		writeScores();
		readScores();
		
		sortList();
		Grade myGrade = new Grade(score, difficulty);
		grades.add(myGrade);
	}
	
	
	/**
	 * sort the ArrayList by descending order.
	 */
	public void sortList() {
		
		for(int i = 0; i < grades.size() - 1; i++) {
			for(int j = 0; j < grades.size() - 1 - i; j++) {
				if(grades.get(j).getScore() < grades.get(j+1).getScore()) {
					Grade temp = grades.get(j);
					grades.set(j, grades.get(j + 1));
					grades.set(j + 1, temp);
				}
			}
		}
		
	}
    
	
	/**
	 * Read the scores file.
	 */
	public void readScores() {
		
		BufferedReader reader = null;
    	try {
    		reader = new BufferedReader(new FileReader("./src/inputFiles/scores.txt"));
    		String tempString = null;
    		
    		while((tempString = reader.readLine()) != null) {
    			String[] newScore = tempString.split(",");
    			int tempscore = Integer.parseInt(newScore[0]);
    			
    			String tempDiffi = newScore[1];
    			
    			Grade newGrade = new Grade(tempscore, tempDiffi);
    			grades.add(newGrade);
    		}
    		reader.close();
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    }
	
	
	/**
	 * write the grade of this time into the end of the scores file.
	 */
	public void writeScores() {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter (new FileWriter("./src/inputFiles/scores.txt", true));
			writer.write("\r\n" + score + "," + difficulty);
		    writer.flush();
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
}
