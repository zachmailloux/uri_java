import java.awt.Color;
import java.awt.Graphics;
/**
 * @author zacharymailloux
 *The RareDuck class extends the Target class and draws a duck
 */
public class RareDuck extends Target{
	/**
	 * The RareDuck constructor calls on the Targets Constructor to set the x and y to varaibles that other methods 
	 * can use to draw their picture.
	 * @param randomX
	 * @param randomY
	 */
	public RareDuck(int randomX, int randomY, int facing, boolean isFlapping){
		super(randomX, randomY, facing, isFlapping);	
	}
	public void duckbody(Graphics pane){
		pane.setColor(Color.lightGray);
		super.duckbody(pane);
	}
	public void duckbodyflapping(Graphics pane){
		pane.setColor(Color.lightGray);
		super.duckbodyflapping(pane);
	}
	public void duckbodyLeft(Graphics pane){
		pane.setColor(Color.lightGray);
		super.duckbodyLeft(pane);
	}
	public void duckbodyLeftflapping(Graphics pane){
		pane.setColor(Color.lightGray);
		super.duckbodyLeftflapping(pane);
	}	
	}
	
