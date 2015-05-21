/*
	Defines and implements a circle.
*/

import java.awt.*;
import java.awt.event.*;

public class Circle  extends Shape
{


	//
	//	In the default constructor we generate a random circle.
	//
	public Circle()
	{
		super();
	}

	public void paint(Graphics pane)
	{
		pane.setColor(Color.cyan);			//	A circle is always cyan
		pane.fillOval(x, y, size, size);	//	We draw a circle

		pane.setColor(Color.black);			//		with a border
		pane.drawOval(x, y, size, size);
	}

					//		and its size

}	// end Circle