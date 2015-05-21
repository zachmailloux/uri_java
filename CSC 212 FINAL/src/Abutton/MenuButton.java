package Abutton;

import java.awt.*;
/** 
 * @author zacharymailloux
 *The class MenuButton was originally intended to be used as my example of inheritance. However, upon adding more complex things 
 *that I wanted my button to do it quickly became clear that having all three buttons properly work would be beyond my level
 *of understanding what exactly is shared with other classes. 
 */

public class MenuButton extends Abutton {
	


	/**
	 * Default constructor automatically calls default constructor of parent
	 */
	public MenuButton(){}
	
	/**
	 * This constructor lets the parent class set the attributes, except the shape
	 * @param someLabel button label
	 * @param someColor button's color
	 * @param someX upper left x coordinate
	 * @param someY upper left y coordinate
	 * @param someWidth button width
	 * @param someHeight button height
	 */
	public MenuButton(String someLabel,
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
	 * A regular button is a plain old rectangle.
	 */
	public void setShape(){
		shape = new Rectangle(x, y, width, height);
	}

}
