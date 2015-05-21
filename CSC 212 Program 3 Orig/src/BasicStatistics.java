/* 
	Programmer: Nickie
	
								Basic statistics
								================

	Description:

		In this program, a collection of items is organized as a list.  It allows
		the user to determine very basic statistics such as minimum and maximum.
*/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class BasicStatistics extends Applet
{
	//
	//	The init method instantiates the data organizer.
	//	
	private DataOrganizer dataOrganizer;

	public void init()
	{
		dataOrganizer = new DataOrganizer(this);

		setBackground(Color.lightGray);
	}

	//
	//	The paint method simply passes the buck to the demo itself.
	//
	public void paint(Graphics page)
	{
		if ( dataOrganizer != null )
			dataOrganizer.paint(page);
	}

}  // end BasicStatistics