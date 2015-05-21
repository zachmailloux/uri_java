/*
	LabDemo.java

	This class defines and implements the demo itself.
*/

import java.awt.*;							//	AWT = "Abstract Window Toolkit"
import java.awt.event.*;					//		or "Another Window Toolkit"
import java.applet.Applet;

public class LabDemo						//	We want to handle the events
				implements	MouseListener	//		from the mouse
{
	private final int DELTA = 25;			//	Spacing for the buttons and elements
//
//	Constructor
//	===========
//
//	The constructor sets the scene with the buttons for the user interaction.
//
	public LabDemo()
	{
	}

	public LabDemo(Applet mainProgram)
	{
		theApplet = mainProgram;

		theApplet.addMouseListener(this);	//	To check on the mouse

		int x = DELTA;
		int y = DELTA;
		charButton = new Abutton("'a', 'b', 'c'", Color.green, x, y);
		y += Abutton.BUTTON_HEIGHT * 1.25;
		intButton = new Abutton("1, 2, 3", Color.cyan, x, y);

		y += Abutton.BUTTON_HEIGHT * 1.5;
		popButton = new Abutton("Pop", Color.yellow, x, y);

		y += Abutton.BUTTON_HEIGHT * 1.5;
		exchangeButton = new Abutton("Exchange", Color.pink, x, y);

		x += Abutton.BUTTON_WIDTH + DELTA;	//	We instantiate a list of elements,
		y = DELTA;							//		and we set the location
		collection  = new Stack(x, y);
	}

	//
	//	The next method checks where the mouse is been clicked,
	//		and performs the associated action.
	//
	private void check()
	{
		theApplet.showStatus(" ");

		try {
			if (charButton.isInside(lastX, lastY)) {
												//	We generate a random character
				char value = "abcdefghijklmnopqrstuvwxyz".charAt((int) (26 * Math.random()));
				collection.push(value);			//		and we push it in the stack
			}
			else if (intButton.isInside(lastX, lastY)) {
												//	We generate a random integer
				int value = (int) (100 * Math.random());
				collection.push(value);			//		and we push it in the stack
			}
			else if (popButton.isInside(lastX, lastY)) {
				Element item;					//	We pop an element
				item = collection.pop();		//		and we print it out
				System.out.println("  --> " + item);

				theApplet.showStatus("  --> " + item);
			}
			else if (exchangeButton.isInside(lastX, lastY)) {
				collection.exchange();			//	Exchange the first two elements
			}
			else  {
				theApplet.showStatus("What?");
			}
		}
		catch (Exception problem) {
			System.err.println("***** We caught an exception *****");
			System.err.println("Here is the message: " +
								problem.getMessage());
			System.err.println("Here is the stack:");
			problem.printStackTrace();
			System.err.println("**********************************");

			theApplet.showStatus("Exception: " +
								problem.getMessage());
		}
		finally {
			theApplet.repaint();
		}
	}

	//
	//	The only "graphical" method of the class is the paint method.
	//
	public void paint(Graphics pane)
	{
		if (charButton != null)				//	If instantiated,
			charButton.paint(pane);			//		we display the buttons
		if (intButton != null)
			intButton.paint(pane);
		if (popButton != null)
			popButton.paint(pane);
		if (exchangeButton != null)
			exchangeButton.paint(pane);

		if (collection != null)				//		and our collection of elements
			collection.paint(pane);
	}

//
//	M o u s e L i s t e n e r
//	=========================
//
//	The implementation of the MouseListener requires the implementation of the
//		following five methods.  Each method deals with a particular event
//		associated with the mouse.
//
//	mouseClicked:	invoked when the mouse button is pressed and released at the
//					same location.
//	mousePressed:	invoked when the mouse button is pressed down
//	mouseReleased:	invoked when the mouse button is released
//	mouseEntered:	invoked when the mouse pointer moves into a component
//					(i.e., the Frame)
//	mouseExited:	invoked when the mouse pointer moves out of a component
//
	public void mouseClicked(MouseEvent event)
	{
		check();								//	To handle the mouse click
	}

	public void mousePressed(MouseEvent event)
	{
		lastX = event.getX();					//	Update the mouse location
		lastY = event.getY();

		flipWhenInside();						//	Flip any button hit by the mouse
	}

	public void mouseReleased(MouseEvent event)
	{
		flipWhenInside();						//	Flip any button hit by the mouse
	}

	public void mouseEntered(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}

	private void flipWhenInside()
	{
		if (charButton.isInside(lastX, lastY))
			charButton.flip();
		else if (intButton.isInside(lastX, lastY))
			intButton.flip();
		else if (popButton.isInside(lastX, lastY))
			popButton.flip();
		else if (exchangeButton.isInside(lastX, lastY))
			exchangeButton.flip();

		theApplet.repaint();
	}

	//
	//	The instance variables
	//
	private Applet theApplet;			//	To get a hold of the applet
										//		associated with the main program

	private Stack collection;			//	To hold our elements

	private Abutton charButton,			//	To push a character element
					intButton,			//		or an integer element,
					popButton,			//		to pop an element
					exchangeButton;		//		to exchange the top two elements

	private int lastX, lastY;			//	To keep the mouse location

}	//	end LabDemo