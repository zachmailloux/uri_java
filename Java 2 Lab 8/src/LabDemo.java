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
	
	//
	//	Constructor
	//	===========
	//
	//	The constructor sets the scene with the buttons to manipulate
	//		our data structure.
	//
	public LabDemo(Applet mainProgram)
	{
		final int BUTTON_WIDTH = 72,		//	To define a "standard" size button
				  BUTTON_HEIGHT = BUTTON_WIDTH/2;

		theApplet = mainProgram;

		theApplet.addMouseListener(this);		//	To check on the mouse

		int x = BUTTON_WIDTH * 1/2;			//	We instantiate our buttons
		int y = BUTTON_HEIGHT * 3/2;
		charButton = new Abutton("'a', 'b', 'c'", Color.green, x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
		y += BUTTON_HEIGHT * 1.5;
		intButton = new Abutton("1, 2, 3", Color.cyan, x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
		y += BUTTON_HEIGHT * 1.5;
		removeButton = new Abutton("Remove", Color.yellow, x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
		y += BUTTON_HEIGHT * 1.5;
		quitButton = new Abutton("Quit", Color.red, x, y, BUTTON_WIDTH, BUTTON_HEIGHT);

		x += BUTTON_WIDTH * 1.5;			//	We instantiate a list of elements,
		y = BUTTON_HEIGHT * 3/2;			//		and we set the location
		collection  = new BinarySearchTree(x, y);
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
				collection.add(value);			//		and we push it in the stack
			}
			else if (intButton.isInside(lastX, lastY)) {
												//	We generate a random integer
				int value = (int) (100 * Math.random());
				collection.add(value);			//		and we push it in the stack
			}
			else if (removeButton.isInside(lastX, lastY)) {
				Element item;					//	We remove an item, we make sure
				item = (Element) collection.remove();	//	and it is an Element,
				theApplet.showStatus("          " + item);	//	and we print it out
			}
			else  {
				theApplet.showStatus("What?");
			}
		} catch (Exception problem) {
			theApplet.showStatus("Exception: " + problem.getMessage());
			System.out.println( "***** We caught an exception *****" );
			System.out.println( "Here is the message: " +
								problem.getMessage() );
			System.out.println( "Here is the stack:" );
			problem.printStackTrace();
			System.out.println( "**********************************" );
		} finally {
			theApplet.repaint();
		}
	}

	//
	//	The only "graphical" method of the class is the paint method.
	//
	public void paint(Graphics pane)
	{
		if (quitButton != null)				//	We display the buttons
			quitButton.paint(pane);
		if (charButton != null)
			charButton.paint(pane);
		if (intButton != null)
			intButton.paint(pane);
		if (removeButton != null)
			removeButton.paint(pane);

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
//	Note that we are "listening" to mouse events that occur in conjunction with the
//		Frame that implements the methods associated with the mouse.  If your
//		application has several frames, each frame can deal with its own mouse
//		events in completely independent ways.
//
//	Only the click of the mouse is of interest to this demo  ... or is it?
//
	public void mouseClicked(MouseEvent event)
	{
		//	Note that, if the mouse is clicked, then it must have been pressed (and
		//		released at the same location).  Therefore, the mouse location has
		//		already been recorded.  We only have to handle the mouse click.
		check();								//	To handle the mouse click
	}
	public void mousePressed(MouseEvent event)
	{
		lastX = event.getX();					//	Update the mouse location
		lastY = event.getY();
		if (quitButton.isInside(lastX, lastY))	//	Highlight the button being hit
			quitButton.flip();					//		(if any)
		else if (charButton.isInside(lastX, lastY))
			charButton.flip();
		else if (intButton.isInside(lastX, lastY))
			intButton.flip();
		else if (removeButton.isInside(lastX, lastY))
			removeButton.flip();
		theApplet.repaint();					//	Refresh the window
	}

	public void mouseReleased(MouseEvent event)
	{
		if (quitButton.isInside(lastX, lastY))	//	"De-highlight" any button that
			quitButton.flip();					//		may be highlighted
		else if (charButton.isInside(lastX, lastY))
			charButton.flip();
		else if (intButton.isInside(lastX, lastY))
			intButton.flip();
		else if (removeButton.isInside(lastX, lastY))
			removeButton.flip();
		theApplet.repaint();					//	Refresh the window
	}

	public void mouseEntered(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}

	//
	//	The instance variables
	//
	private Applet theApplet;				//	To get a hold of the applet

	private BinarySearchTree collection;	//	To hold our elements

	private Abutton charButton,				//	To add/push a character element,
					intButton,				//		to add an integer element,
					removeButton,			//		to remove an element,
					quitButton;				//		and to stop playing

	private UneFenetre myWindow				//	A handle on the window
							= new UneFenetre();

	private int lastX, lastY;				//	To keep the mouse location

}	//	end LabDemo