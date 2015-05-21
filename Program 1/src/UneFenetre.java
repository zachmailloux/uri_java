/*
	Implements some (actually only one) of the window's useful methods.
*/

import java.awt.*;
import java.awt.event.*;

public class UneFenetre extends WindowAdapter
{

	public void windowClosing(WindowEvent event)
	{
		System.exit(0);
	}
}	// end LaFenetre