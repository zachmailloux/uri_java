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
	public RareDuck(int randomX, int randomY){
		super(randomX, randomY);	
	}
	public void duckbody(Graphics pane){
		pane.setColor(Color.lightGray);
		pane.fillOval(x+7, y+10, 40, 25); //chest
		pane.fillOval(x+37, y+5, 20, 20); //head
		pane.fillOval(x+17, y, 20, 35); // wing
		pane.fillOval(x+2, y+12, 20, 8); //tail
	}
	public void duckwing(Graphics pane){
		pane.setColor(Color.black);
		pane.fillOval(x+15, y-2, 20, 35); // wing
		pane.drawLine(x+55, y+20, x+68, y+20); //line in the beak
	}
	public void eye(Graphics pane){
		pane.setColor(Color.black);
		pane.fillOval(x+45, y+9, 5, 5);
	}
	/**
	 * The beak method draws the beak of the duck
	 */
	public void beak(Graphics pane){
		pane.setColor(Color.ORANGE);
		pane.fillOval(x+50, y+15, 20, 10); // beak
		pane.fillOval(x+10, y+27, 15, 11); //back foot
		pane.fillOval(x+5, y+27, 11, 15); //back foot
	}
	/**
	 * The fly method is the method that calls all the other painting methods in an order that paints a duck
	 * in the proper layering format
	 */
	public void fly(Graphics pane){
		beak(pane);
		duckwing(pane);
		duckbody(pane);
		eye(pane);	
	}
}
