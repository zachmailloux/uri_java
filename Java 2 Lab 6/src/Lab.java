/* 
								M e r g e S o r t
								=================

	Description:

		This program illustrates a possible implementation of Merge Sort, using
	linked lists.
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
		theLab = new LabDemo(this);			//	We instantiate the "demo"

		setBackground(new Color(189, 198, 222));	//	Pretty ?
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
	private LabDemo theLab;					//	A demo, that's all we need

}	// end Lab