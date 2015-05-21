import java.awt.Color;
import java.awt.Graphics;
/**
 * @author zacharymailloux
 *The GoldenDuck class extends the Target class and draws a duck
 */
public class GoldenDuck extends Target{
	/**
	 * The GoldenDuck constructor calls on the Targets Constructor to set the x and y to varaibles that other methods 
	 * can use to draw their picture.
	 * @param randomX
	 * @param randomY
	 */
	public GoldenDuck(int randomX, int randomY, int facing, boolean isFlapping){
		super(randomX, randomY, facing, isFlapping);	
	}
	public void duckbody(Graphics pane){
		pane.setColor(new Color(220,200,130));
		super.duckbody(pane);
	}

	public void duckbodyflapping(Graphics pane){
		pane.setColor(new Color(220,200,130));
		super.duckbodyflapping(pane);
	}

	/**
	 * The beak method draws the beak of the duck
	 */

	public void duckbodyLeft(Graphics pane){
		pane.setColor(new Color(220,200,130));
		super.duckbodyLeft(pane);
	}

	public void duckbodyLeftflapping(Graphics pane){
		pane.setColor(new Color(220,200,130));
		super.duckbodyLeftflapping(pane);
	}


	/**
	 * The fly method is the method that calls all the other painting methods in an order that paints a duck
	 * in the proper layering format
	 */

	}
	