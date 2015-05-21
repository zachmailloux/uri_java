/*
	IntegerElement.java
*/

import java.awt.*;
import java.awt.event.*;

public class IntegerElement extends Element
{
	//
	//	The following constructor initializes all the components of an element:
	//		to hold a given integer, at a given location, in a given color.
	//
	public IntegerElement(int someValue, int someX, int someY, Color someColor)
	{
		super(someX, someY, someColor);		//	We pass the buck for some of it,
		value = someValue;					//		and we deal with the rest
	}

	//
	//	Defines the textual representation of an integer element
	//
	public String toString()
	{
		return String.valueOf(value);
	}

	//
	//	Paint an element containing an integer
	//
	public void paint(Graphics pane)
	{
		super.paint(pane);					//	We start with the basic element

		pane.setColor(Color.black);			//		then, we put the value in black
											//		... and nicely centered
		String theLabel = String.valueOf(value);
		int labelWidth = pane.getFontMetrics().stringWidth(theLabel);
		int labelHeight = pane.getFontMetrics().getAscent();
		pane.drawString(theLabel,
						x + (WIDTH - labelWidth)/2,
						y + (HEIGHT + labelHeight)/2);
	}

	private int value;						//	The "value" of the element

}	//	end of IntegerElement