import java.awt.Color;
import java.awt.Graphics;


public class Score {
	// Data fields
	
	/**
	 * Integer value that holds the current score.
	 */
	private int score;
	
	/** Default constructor that sets integer score
	 * to zero.
	 */
	public Score(){
		score = 0;
	}
	
	/** Method that increments the score variable
	 * by one. Called when an UpScore pellet is found
	 * within the Eat Zone and the "eat" button is clicked.
	 */
	public void addPoint() {
		score++;
	}
	
	/** Method that decrements the score variable
	 * by one. Called when an DownScore pellet is found
	 * within the Eat Zone and the "eat" button is clicked.
	 */
	public void subtractPoint() {
		score--;
	}
	/**
	 * Paint method that paints the score to the screen and updates
	 * to show the current score.
	 * @param pane The Graphics pane to which the score will be painted.
	 */
	public void paint(Graphics pane){
		pane.setColor(Color.WHITE);
		pane.drawString("Score: " + String.valueOf(score), 50, 50);
	}
	
	/**
	 * Getter method to return the integer value of the score.
	 * @return the integer value of score.
	 */
	public int getScore(){
		return score;
	}

}
