/* 
					S t a c k i n g   u p   o u r   e l e m e n t s
					===============================================

	Description:

		This program illustrates the use of references to implement a "reference
	based" stack of elements, and to manipulate elements within the stack.
		This program also illustrates exception handling.
*/

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Lab extends Applet
{
	//
	//	The init method initializes the applet
	//
	public void init()
	{
		theLab = new LabDemo(this);					//	We instantiate the "demo"

		setBackground(new Color((int) (256*Math.random()),	//	We'll see what
								(int) (256*Math.random()),	//		happens there
								(int) (256*Math.random())));
	}

	//
	//	The paint method refreshes the applet
	//
	public void paint(Graphics pane)
	{
		if (theLab != null)
			theLab.paint(pane);
	}

	//
	//	Our instance variable(s)
	//
	private LabDemo theLab;							//	A demo, that's all we need

}	// end Lab
