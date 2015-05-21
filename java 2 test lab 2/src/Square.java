/*
	Defines and implements a square.
*/

import java.awt.*;
import java.awt.event.*;

public class Square
{
	private final int						//	To define the size of our buttons
				BUTTON_WIDTH = Abutton.BUTTON_WIDTH,
				BUTTON_HEIGHT = Abutton.BUTTON_HEIGHT;

	//
	//	In the default constructor we generate a random square.
	//
	public Square()
	{
		randomize();
	}

	//
	//	The randomize method defines random characteristics for the square.
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
		pane.setColor(Color.green);			//	A square is always green
		pane.fillRect(x, y, size, size);	//	We draw a square

		pane.setColor(Color.black);			//		with a border
		pane.drawRect(x, y, size, size);
	}

	private int	x, y,						//	The square's location
				size;						//		and its size

}	// end Square