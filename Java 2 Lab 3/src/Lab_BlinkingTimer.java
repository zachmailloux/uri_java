/*
	Author:	Gaston
							B l i n k i n g   T i m e r
							===========================
	Description:
			This program use basic animation to display a "blinking timer."
*/

import java.awt.*;
import java.applet.Applet;

public class Lab_BlinkingTimer extends Applet
{
	//
	//	The init method initializes the applet
	//
	public void init()
	{
		myTimer = new BlinkingTimer(this);	//	We instantiate the "timer"
	}

	//
	//	The paint method refreshes the applet
	//
	public void paint(Graphics pane)
	{
		setBackground(Color.lightGray);		//	Not so pretty.  Or is it?

		if (myTimer != null)
			myTimer.paint(pane);
	}

	//
	//	Our instance variables
	//
	private BlinkingTimer myTimer;			//	We need a timer

}	// end Lab
