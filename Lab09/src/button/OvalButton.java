package button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

public class OvalButton extends AButton {
	
	/**
	 * Default constructor automatically calls default constructor of parent
	 */
	public OvalButton(){}
	
	/**
	 * This constructor lets the parent class set the attributes, except the shape
	 * @param someLabel button label
	 * @param someColor button's color
	 * @param someX upper left x coordinate
	 * @param someY upper left y coordinate
	 * @param someWidth button width
	 * @param someHeight button height
	 */
	public OvalButton(String someLabel,
	   Color someColor,
	   int someX, int someY,
	   int someWidth, int someHeight)
	{										//	We create a button
			super(someLabel,					//		with a given label,
					someColor,					//		in a given color
					someX, someY,					//		at a given location,
					someWidth, someHeight);		//		and with a given size,
			setShape();
	}
	
	/**
	 * An oval button's shape is an ellipse!
	 */
	public void setShape(){
		shape = new Ellipse2D.Double(x, y, width, height);
	}



}
