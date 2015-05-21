/**
 * Zachary Mailloux
 * September 9 2013
 * Monday Lab #1
 */
import java.awt.*;
import java.awt.event.*;

public class Item
{
int x, y,value;
boolean selected = false;
boolean up =true;
	


	public Item(int xloc, int yloc){
		x= xloc;
		y = yloc;
	}
	
	public void setValue(int height){
		value=height;
	}
	public int getValue(){
		return value;
	}
	public boolean selection(){
		return selected;
	}
	public void flip()
	{
		selected = ! selected;
		System.out.println("Flipped");
		up = !up;
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
		pane.drawRect(x, y - value, WIDTH, value);
											//		and the element itself
		pane.setColor(Color.orange);	//		in just the right color
		pane.fill3DRect(x + 1, y - value + 1, WIDTH - 1, value - 1,up);
	//	pane.fillRect(x + 1, y - value + 1, WIDTH - 1, value - 1);
	}


}