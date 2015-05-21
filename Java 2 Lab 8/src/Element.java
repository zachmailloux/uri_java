/*
	Element.java
*/

import java.awt.*;
import java.awt.event.*;

public abstract class Element implements Comparable
{
	public final static int WIDTH = 36,		//	To define the standard size
				  			HEIGHT = 24;	//		of the elements

	//
	//	Constructors:
	//	=============
	//
	//	The default constructor does nothing
	//
	public Element()
	{
		x = 0;
		y = 0;
		color = Color.gray;
		hilite = true;
	}

	//
	//	The following constructor initializes all components of an element
	//
	public Element(int someX, int someY, Color someColor)
	{
		x = someX;
		y = someY;
		color = someColor;
		hilite = true;
	}

	//
	//	The following access method resets the location of an element
	//
	public void setLocation(int someX, int someY)
	{
		x = someX;
		y = someY;
	}

	//
	//	The following access methods return the location of an element
	//
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}

	//
	//	The following method implements the comparable interface (we use the
	//		alphanumeric ordering on the string representation of the elements).
	//
	public int compareTo(Object element)
	{
		return toString().compareTo(element.toString());
	}

	//
	//	Paints an element
	//
	public void paint(Graphics pane)
	{
		final int DELTA = 2;				//	The offset within the box/frame

		pane.setColor(Color.black);			//	Drawing the box/frame of the element
		pane.drawRect(x, y,
					  WIDTH, HEIGHT);

		pane.setColor(color);				//		and the inside of the element
		pane.fill3DRect(x + DELTA, y + DELTA,
						WIDTH - 2*DELTA + 1, HEIGHT - 2*DELTA + 1,
						hilite);
	}

	//
	//	The instance variables
	//
	protected int x, y;						//	The location of the element
	protected Color color;					//		its color, and
	protected boolean hilite = true;		//		whether it is hilighted or not

	//	NOTE:	The location of the element is defined as the top left corner of
	//			the box/frame used to display the element.

}	//	end of Element