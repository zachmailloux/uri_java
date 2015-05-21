/*
	Implements some (actually only one) of the window's useful methods.
*/

import java.awt.*;
import java.awt.event.*;

public class UneFenetre extends WindowAdapter
{
	//
	//	Just so we can be neat about the close button.
	//
	public void windowClosing(WindowEvent event)
	{
		System.exit(0);
	}
}	// end LaFenetre