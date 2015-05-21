/*
	Defines and implements a circle.
*/

import java.awt.*;
import java.awt.event.*;

public class Circle
{
	private final int						//	To define the size of our buttons
				BUTTON_WIDTH = Abutton.BUTTON_WIDTH,
				BUTTON_HEIGHT = Abutton.BUTTON_HEIGHT;

	//
	//	In the default constructor we generate a random circle.
	//
	public Circle()
	{
		randomize();
	}

	//
	//	The randomize method defines random characteristics for the circle.
	//
	private void randomize()
	{
		x = (int) (200 * Math.random()) + BUTTON_WIDTH * 2;
		y = (int) (200 * Math.random()) + BUTTON_HEIGHT * 2;
		size = (int) (100 * Math.random());
	}

	//
	//	The only graphical method of the class is the paint method.
	//
	public void paint(Graphics pane)
	{
		pane.setColor(Color.cyan);			//	A circle is always cyan
		pane.fillOval(x, y, size, size);	//	We draw a circle

		pane.setColor(Color.black);			//		with a border
		pane.drawOval(x, y, size, size);
	}

	private int	x, y,						//	The circle's location
				size;						//		and its size

}	// end Circle