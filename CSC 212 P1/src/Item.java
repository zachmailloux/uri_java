/*
 *
 *	BasicElement.java
 *
 */

import java.awt.*;
import java.awt.event.*;

public class Item
{
	/**
	 * the height multiplyer variable of the bar.
	 */
	private int value;

	/**
	 * the color of the bar
	 */
	private Color color = Color.green;

	/**
	 * the x and y position of the bar reference for painting purposes
	 */
	private int x, y;

	/**
	 * the constructor recieves an x and y coordinate to know where to paint the bar.
	 * 
	 * @param x
	 * @param y
	 */
	public Item(int x, int y)
	{
		this.x = x;

		this.y = y;


	}

	/**
	 * sets the x position to a given position.
	 * used when painting them in a nice order when
	 * they were created out of order in the array.
	 * @param x
	 */
	public void setX( int x)
	{
		this.x = x;
	}


	/**
	 * keeps track of if the item is selected or not
	 */
	private boolean isSelected = false;


	/**
	 * recieves a color and sets it to the color variable to be used in painting the bar.
	 * @param newColor
	 */
	public void setColor(Color newColor) 
	{
		color = newColor;
		//repaint();
	}


	/**
	 * recieves an integer for the height multiplyer
	 * @param i
	 */
	public void setValue(int i) 
	{
		value = i;

	}

	/**
	 * returns the value of the height multiplyer.
	 * @return
	 */
	public int getValue() 
	{
		return value;
	}

	/**
	 * sets the isSelected boolean to true.  Literally Selects the item.
	 */
	public void select()
	{
		isSelected = true;
	}

	/**
	 * Sets the isSelected boolean to false. Literally deSelects the item.
	 */
	public void deSelect()
	{
		isSelected = false;
		color = Color.GREEN;
	}


	//
	//	Drawing an element
	//
	public void paint(Graphics pane)
	{
		final					//	The following constants define
		int					//		the visual characteristics of an element
		DELTA = 5,		//	For the size of the element's "bottom line"
		WIDTH = 20,		//		the width of the element
		HEIGHT = 10;	//		the incremental height
		//			(as a unit of the element's value)

		pane.setColor(Color.black);			//	Drawing the element's "bottom line"
		pane.drawLine(x-DELTA, y, x+WIDTH+DELTA, y);

		pane.setColor(Color.black);			//	Drawing the frame in black
		pane.drawRect(x, y - HEIGHT*value, WIDTH, HEIGHT*value);
		//		and the element itself


		if (isSelected)// if it is the selected item, the color will be different.
			color = Color.yellow;
		pane.setColor(color);	//		in just the right color
		pane.fillRect(x + 1, y - HEIGHT*value + 1, WIDTH - 1, HEIGHT*value - 1);
	}




}