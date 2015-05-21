package button;

import java.awt.Color;
import java.awt.Polygon;

public class TriangleButton extends AButton {
	
	/**
	 * Default constructor automatically calls default constructor of parent
	 */
	public TriangleButton(){}
	
	/**
	 * This constructor lets the parent class set the attributes, except the shape
	 * @param someLabel button label
	 * @param someColor button's color
	 * @param someX upper left x coordinate
	 * @param someY upper left y coordinate
	 * @param someWidth button width
	 * @param someHeight button height
	 */
	public TriangleButton(String someLabel,
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
	 * A Triangle button has a polygon with three points for its shape.
	 */
	public void setShape() {
		Polygon poly = new Polygon();
		poly.addPoint(x + width/2, y);//top point
		poly.addPoint(x, y + height);//lower left
		poly.addPoint(x + width, y + height);//lower right
		shape = poly;

	}

}
