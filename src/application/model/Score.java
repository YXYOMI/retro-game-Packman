package application.model;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/**
 * This class create a object Score with combination of two texts (score and lifes).
 * Set the location, text, color and font for the score board (under the maze).
 * It will show the scores and the remaining lives.
 * 
 * @author Xinyi OUYANG / 20030865
 *
 */
public class Score {

    public Text score;
    public Text lifes;

    /**
     * Set the location, text, color and font and add it to root.
     * @param root - the group of the elements that will be shown on the stage.
     */
    public Score(Group root) {
        this.score = new Text(BarObstacle.THICKNESS * 4, BarObstacle.THICKNESS * 28, "Score: 0");
        this.lifes = new Text(BarObstacle.THICKNESS * 20, BarObstacle.THICKNESS * 28,"Lifes: 3");
        score.setFill(Color.MAGENTA);
        score.setFont(Font.font("Arial", 30));

        lifes.setFill(Color.MAROON);
        lifes.setFont(Font.font("Arial", 30));

        root.getChildren().add(score);
        root.getChildren().add(lifes);
    }
}
