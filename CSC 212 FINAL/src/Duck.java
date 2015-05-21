import java.awt.Color;
import java.awt.Graphics;
/**
 * @author zachary mailloux
 *The duck class extends the Target class and draws a duck
 */
public class Duck extends Target{
	/**
	 * The Duck constructor calls on the Targets Constructor to set the x and y to variables that other methods 
	 * can use to draw their picture.
	 * @param randomX
	 * @param randomY
	 */
	public Duck(int randomX, int randomY, int facing, boolean isFlapping){
		super(randomX, randomY,facing, isFlapping);	
	}
	public void duckbody(Graphics pane){
		pane.setColor(Color.white);
		super.duckbody(pane);	
	}
	public void duckbodyflapping(Graphics pane){
		pane.setColor(Color.white);
		super.duckbodyflapping(pane);
	}
	public void duckbodyLeft(Graphics pane){
		pane.setColor(Color.white);
		super.duckbodyLeft(pane);
	}
	public void duckbodyLeftflapping(Graphics pane){
		pane.setColor(Color.white);
		super.duckbodyLeftflapping(pane);
		}
	}
	


