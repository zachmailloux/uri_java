import java.awt.Color;
import java.awt.Graphics;
/**
 * 
 * @author zacharymailloux
 *The blood class extends the Target class and draws blood in place of wherever the duck hit was.
 */
public class blood extends Target {
	/**
	 * The blood constructor calls on the Targets Constructor to set the x and y to variables that other methods 
	 * can use to draw their picture.
	 * @param randomX
	 * @param randomY
	 */
	public blood(int randomX, int randomY, int facing, boolean isFlapping){
		super(randomX, randomY, facing,isFlapping);	
	}
	public void bloodsplash(Graphics pane){
		// below are a large series of ovals that will be drawn in order to properly display the blood
		pane.setColor(Color.red);
		pane.fillOval(x+10, y, 20, 20);
		pane.fillOval(x+7, y+1, 5, 5);
		pane.fillOval(x+8, y-3, 5, 5);
		pane.fillOval(x-6, y+4, 5, 5);
		pane.fillOval(x-11, y+12, 5, 5);
		pane.fillOval(x-9, y-7, 5, 5);
		pane.fillOval(x+23, y-23, 5, 5);
		pane.fillOval(x+16, y+14, 7, 7);
		pane.fillOval(x+19, y-12, 5, 5);
		pane.fillOval(x+27, y+32, 7, 7);
		pane.fillOval(x+31, y+19, 5, 5);
		pane.fillOval(x+14, y-18, 3, 3);
		pane.fillOval(x+10, y+21, 5, 5);
		pane.fillOval(x+23, y+24, 4, 4);
		pane.fillOval(x+23, y+13, 5, 5);
		pane.fillOval(x+12, y-14, 5, 5);
		pane.fillOval(x-7, y-19, 2, 2);
		pane.fillOval(x-8, y+14, 5, 5);
		pane.fillOval(x+17, y-12, 7, 7);
		pane.fillOval(x+6, y-1, 5, 5);
		pane.fillOval(x+12, y-1, 3, 3);
		pane.fillOval(x+22, y-10, 5, 5);
		pane.fillOval(x+32, y-15, 5, 5);
		pane.fillOval(x+42, y+10, 2, 2);
		pane.fillOval(x+37, y-5, 3, 3);
		}
	/**
	 * The splash method will call on the bloodsplash method to actually print them all on the screen 
	 */
	public void splash(Graphics pane){
		bloodsplash(pane);
	}

}
