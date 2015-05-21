/* 
	CSC 212
						B i n a r y   S e a r c h   T r e e
						===================================

	Description:	This program demonstrates the use of a binary search tree.
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

		setBackground(new Color(111, 222, 111));	//	Pretty ?
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
