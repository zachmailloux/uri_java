import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;


public class Abutton {
	
	/**
	 * Coordinates of upper left corner of button's bounding box
	 */
	protected int x, y;
	
	/**
	 * Width and height of button's bounding box
	 */
	protected int width, height;
	
	/**
	 * Whether the button is raised or pushed
	 */
	protected boolean up;
	
	/**
	 * What it says on the button
	 */
	protected String label;
	
	/**
	 * lowColor is the color when the button is down, highColor when the button is up
	 */
	protected Color lowColor, highColor;
	
	/**
	 * The shape of the button
	 */
	protected Shape shape;
	
	/**
	 * Default constructor creates an arbitrary black button with no visible label
	 */
	public Abutton(){
		this("?????",						//		with a questionable label,
				 Color.black,					//		in plain black
				 43, 47,						//		at an arbitrary location,
				 143, 147);						//		and with an arbitrary size,
	}
	
	/**
	 * Creates button with the given label, color, coordinates and dimensions
	 * @param someLabel what it says on the button
	 * @param someColor the color of the button when it's "down."
	 * @param someX the left coordinate of the bounding box
	 * @param someY the top coordinate of the bounding box
	 * @param someWidth the width of the bounding box
	 * @param someHeight the height of the bounding box
	 */
	public Abutton(String someLabel,
			   Color someColor,
			   int someX, int someY,
			   int someWidth, int someHeight)
	{										//	We create a button
		setup(someLabel,					//		with a given label,
		  someColor,					//		in a given color
		  someX, someY,					//		at a given location,
		  someWidth, someHeight);		//		and with a given size,
		setShape();
	}
	
	/**
	 * 
	 * @param someLabel what it says on the button
	 * @param someColor the color of the button when it's "down."
	 * @param someX the left coordinate of the bounding box
	 * @param someY the top coordinate of the bounding box
	 * @param someWidth the width of the bounding box
	 * @param someHeight the height of the bounding box
	 */
	public void setup(String someLabel,
			  Color someColor,
			  int someX, int someY,
			  int someWidth, int someHeight)
	{
		label = someLabel;
		highColor = someColor;
		x = someX;
		y = someY;
		width = someWidth;
		height = someHeight;
		up = true;							//	Initially, the button is up
		lowColor = highColor.darker(); //the color when the button is pressed
	}
	
	/**
	 * Sets the shape of the button to a rectangle.
	 */
	public void setShape(){
		shape = new Rectangle(x, y, width, height);
	}
	
	/**
	 * Used to see if clicks are inside button
	 * @param pointX x value to be checked
	 * @param pointY y value to be checked
	 * @return true if point is inside or on border of button
	 */
	public boolean isInside(int pointX, int pointY){
		return shape.contains(pointX,pointY);
	}
	
	/**
	 * To change whether the button is "up" or "down."
	 */
	public void flip(){
		up = !up;
	}
	
	/**
	 * draws the button
	 * @param pane
	 */
	public void paint(Graphics pane){
		Graphics2D pane2 = (Graphics2D)pane; //So we can work with arbitrary shapes
		pane2.setColor(up? highColor: lowColor); //Is the button up or down?
		pane2.fill(shape);
		pane2.setColor(Color.black);
		pane2.draw(shape); //button border
		int labelWidth = pane2.getFontMetrics().stringWidth(label);
		int labelHeight = pane2.getFontMetrics().getAscent();
		pane2.drawString(label,
						x + (width - labelWidth)/2,
						y + (height + labelHeight)/2);
	}

}
