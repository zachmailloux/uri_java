package shapes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class myShape {
	
	/**
	 * The location, dimensions and label
	 */
	protected int x, y, width, height, number; 
	
	/**
	 * Its fill color
	 */
	protected Color color;
	
	/**
	 * To keep track of how many have been instantiated - used for label
	 */
	protected static int count;
	public myShape(){
		number = ++count;
	}
	
	public myShape(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		number = ++count;
	}
	public void setup(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public static void reset(){
		count = 0;
	}
	public void setColor(Color someColor){
		color = someColor;
	}
	public void paint(Graphics pane) {
		pane.setColor(Color.BLACK);
		int labelWidth = pane.getFontMetrics().stringWidth("" + number);//width of number
		int labelHeight = pane.getFontMetrics().getAscent();
		pane.drawString("" + number,						//centers the number in the
						x + (width - labelWidth)/2,			//shape
						y + (height + labelHeight)/2);

	}
}
