/*
	Item.java
*/

import java.awt.*;
import java.awt.event.*;

public class Item
{
	public static final
		int DELTA = 5,
			WIDTH = 20,
			HEIGHT = 10,
			OVERALL_WIDTH = WIDTH + 2*DELTA;


	//
	//	Constructors
	//	============
	//
	//	Instantiates an item from scratch
	public Item()
	{
		this(0, 0, 0, Color.black);
	}

	//	Instantiates an item at a given location.
	public Item(int someX, int someY)
	{
		this(someX, someY, 0, Color.black);
	}

	//	Instantiates an item at a given location,
	//		and with a given value.
	public Item(int someX, int someY, int someValue)
	{
		this(someX, someY, someValue, Color.black);
	}

	//	Instantiates an item at a given location,
	//		with a given value, and a given color.
	public Item(int someX, int someY, int someValue, Color someColor)
	{
		setup(someX, someY, someValue, someColor);
	}

	//	Instantiates an item at a given location,
	//		with a given value, and a given color.
	public Item(int someValue, Color someColor)
	{
		setup(0, 0, someValue, someColor);
	}

	//
	//	Initializes all components of an item.
	//
	public void setup(int someX, int someY, int someValue, Color someColor)
	{
		x = someX;
		y = someY;
		value = someValue;
		color = someColor;
		hilite = false;
	}

	//
	//	Resetting the value of an item
	//
	public void reset()
	{
		value = 0;
	}

	//
	//	Accessing the value of an item
	//
	public int getValue()
	{
		return value;
	}
	public void setValue(int someValue)
	{
		value = someValue;
	}
	
	public void setLocation(int someX, int someY){
		x = someX;
		y = someY;
	}
	
	//
	//Accessing the horizontal position of the left side of an Item
	//
	public int getX(){
		return x;
	}
	public void setX(int newX){
		x = newX;
	}

	//
	//	Resetting the color of an item
	//
	public void setColor(Color someColor)
	{
		color = someColor;
	}

	//
	//	Highlighting/de-highlighting an item
	//
	public void highlight(boolean someHilite)
	{
		hilite = someHilite;
	}

	//
	//	Drawing an item
	//
	public void paint(Graphics pane)
	{
		pane.setColor(Color.black);			//	Drawing the "bottom line"
		pane.drawLine(x-DELTA, y, x+WIDTH+DELTA, y);

		pane.setColor(Color.black);
		pane.drawRect(x, y - HEIGHT*value, WIDTH, HEIGHT*value);
		pane.setColor(color);
		pane.fill3DRect(x + 2, y - HEIGHT*value + 2,
						WIDTH - 3, HEIGHT*value - 3,
						!hilite);
	}

	//
	//	The instance variables
	//
	private int x, y;						//	To define the location
	private int value;						//		the value
	private Color color;					//		and the color of an item
	private boolean hilite;					//	To highlight the item

}	//	end Item