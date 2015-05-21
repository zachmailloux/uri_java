/**
 * Zachary Mailloux
 * September 9 2013
 * Monday Lab #1
 */
import java.awt.*;
import java.awt.event.*;

public class BasicElement
{
int x, y,value;
Color color;
/*
 *	The following piece of code is all we have been able to salvage after the crash
 *		of Nickie's computer.  Your job is to reconstruct the whole class, based on
 *		its use in the rest of the program.
 *

	//
	//	Drawing an element
	//
	 *  *
 */
	public BasicElement(int xloc, int yloc){
		x= xloc;
		y = yloc;
	}
	public void setValue(int height){
		value=height;
	}
	public int getValue(){
		return value;
	}
	public void setColor(Color c){
		color = c;
	}
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
		pane.setColor(color);				//		in just the right color
		pane.fillRect(x + 1, y - HEIGHT*value + 1, WIDTH - 1, HEIGHT*value - 1);
	}


}