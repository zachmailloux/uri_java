package button;
import java.awt.*;

public abstract class AButton {
	
	/**
	 * Location & dimensions of button
	 */
	protected int x, y, width, height;
	
	/**
	 * True if the button isn't pushed
	 */
	protected boolean up;
	
	/**
	 * What it says in the center of the button
	 */
	protected String label;
	
	/**
	 * If the button is up it's filled with highColor,
	 * when down it's filled with lowColor
	 */
	protected Color lowColor, highColor;
	
	/**
	 * The shape of the button
	 */
	protected Shape shape;
	
	/**
	 * Default constructor sets button up with arbitrary values
	 */
	public AButton(){
		this("?????",						//		with a questionable label,
				 Color.black,					//		in plain black
				 43, 47,						//		at an arbitrary location,
				 145, 145);						//		and with an arbitrary size,
	}
	
	public AButton(String someLabel,
	   Color someColor,
	   int someX, int someY,
	   int someWidth, int someHeight){
		//	We create a button
		setup(someLabel,					//		with a given label,
				someColor,					//		in a given color
				someX, someY,					//		at a given location,
				someWidth, someHeight);		//		and with a given size,
	}
	
	/**
	 * Sets up all of the button's attributes
	 * @param someLabel
	 * @param someColor
	 * @param someX
	 * @param someY
	 * @param someWidth
	 * @param someHeight
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
		up = true;							//	Initially, the button is not up
		lowColor = highColor.darker();
	}
	

	/**
	 * Sets the buttons shape
	 */
	public abstract void setShape();
	
	/**
	 * True if the point whose x and y are given is within the button
	 * @param pointX
	 * @param pointY
	 * @return
	 */
	public boolean isInside(int pointX, int pointY){
		return shape.contains(pointX,pointY);
	}
	
	/**
	 * Switches it from up to down or down to up
	 */
	public void flip(){
		up = !up;
	}
	
	/**
	 * Draws the button
	 * @param pane
	 */
	public void paint(Graphics pane){
		Graphics2D pane2 = (Graphics2D)pane;
		pane2.setColor(up? highColor: lowColor);
		pane2.fill(shape);
		pane2.setColor(Color.black);
		pane2.draw(shape);
		int labelWidth = pane2.getFontMetrics().stringWidth(label);
		int labelHeight = pane2.getFontMetrics().getAscent();
		pane2.drawString(label,
						x + (width - labelWidth)/2,
						y + (height + labelHeight)/2);
	}

}
