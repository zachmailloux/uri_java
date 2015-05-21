/*
	DataOrganizer.java

		This class defines and implements the data organizer.

		The class makes use of a collection of items, and provides very basic
	operations on that collection.

		[The class also implements all the methods required to implement a
	"MouseListener".]
*/

import java.awt.*;							//	AWT = "Abstract Window Toolkit"
import java.awt.event.*;					//		or "Another Window Toolkit"
import java.applet.*;

public class DataOrganizer implements MouseListener
{
	private final
			int COLLECTION_SIZE = 10,		//	Maximum number of items
				MAXIMUM_ITEM_VALUE = 16;	//	Maximum value of an item

	private Applet theApplet;
	
	private int x, y;	//for placing the buttons and collection

//
//	Constructors
//	============
//
	//
	//	There is not much we can do in the default constructor
	//		without having access to an aplet at the top level.
	//
	public DataOrganizer() {}

	//
	//	The following constructor uses the given applet to set the scene with the
	//		visualization of the element and the buttons to manipulate the color
	//		and the value of the element.
	//
	public DataOrganizer(Applet someApplet)
	{
		theApplet = someApplet;

		theApplet.addMouseListener(this);	//	This class will handle the mouse
		
		x = 30;
		y = 30;
		randomButton = new Abutton("Random", Color.yellow, x, y);

		y += 1.5*Abutton.BUTTON_HEIGHT;
		maximumButton = new Abutton("Maximum", Color.green, x, y);
		y += 1.1*Abutton.BUTTON_HEIGHT;
		minimumButton = new Abutton("Minimum", Color.cyan, x, y);

		y += 1.5*Abutton.BUTTON_HEIGHT;
		removeButton = new Abutton("Remove", Color.pink, x, y);

		x += 1.5*Abutton.BUTTON_WIDTH;
		y += 1*Abutton.BUTTON_HEIGHT;
	}

//
//	Definitions of the operations on the data collection associated with each of
//		the buttons.

	//
	//	Random
	//
	public void randomAction()
	{
		collection= new ArrayDataCollection(x, y);				//	We restart with nothing,
											//		then we add random items,
		for (int i = 0; i < COLLECTION_SIZE; i++) {
			Item temp = new Item();
			temp.setValue((int)(1 + MAXIMUM_ITEM_VALUE*Math.random()));
			temp.setColor(Color.orange);
			collection.add(temp);
		}
		collection.reset(null);				//	We make sure nothing is selected
	}

	//
	//	Maximum
	//
	public void maximumAction()
	{
		Item maximumItem = null,
			 someItem;

		collection.reset();						//	We start at the beginning

		while (collection.hasNext()) {
												//	What's next?
			someItem = (Item) (collection.next());

			if ( (maximumItem == null) ||		//	If it is the largest so far,
				 (someItem.getValue() > maximumItem.getValue()) )
				maximumItem = someItem;			//		we keep track of it
		}

		collection.reset(maximumItem);
	}

	//
	//	Minimum
	//
	public void minimumAction()
	{
		Item minimumItem = null,
			 someItem;

		collection.reset();

		while (collection.hasNext()) {
												//	What's next?
			someItem = (Item) (collection.next());

			if ( (minimumItem == null) ||		//	If it is the smallest so far,
				 (someItem.getValue() < minimumItem.getValue()) )
				minimumItem = someItem;			//		we keep track of it
		}

		collection.reset(minimumItem);
	}

	//
	//	Remove
	//
	public void removeAction()
	{
		collection.remove();
	}

	//
	//	The next method checks where the mouse is been clicked.
	//	Each button is associated with its own action.
	//
	private void check()
	{
		theApplet.showStatus(" ");			//	To reset the status bar

		if (randomButton.isInside(lastX, lastY)) {
			randomAction();
		}

		else if (maximumButton.isInside(lastX, lastY)) {
			maximumAction();
		}
		else if (minimumButton.isInside(lastX, lastY)) {
			minimumAction();
		}

		else if (removeButton.isInside(lastX, lastY)) {
			removeAction();
		}

		else  {
			theApplet.showStatus("What?");
		}

		theApplet.repaint();
	}

//
//	The only "graphical" method of the class is the paint method.
//
	public void paint(Graphics pane)
	{
		if (collection != null)				//	When instantiated,
			collection.paint(pane);			//		we display the element
	
		if (randomButton != null)
			randomButton.paint(pane);		//		and all of the buttons

		if (maximumButton != null)
			maximumButton.paint(pane);
		if (minimumButton != null)
			minimumButton.paint(pane);

		if (removeButton != null)
			removeButton.paint(pane);
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
		check();								//	Handle the mouse click
	}

	public void mousePressed(MouseEvent event)
	{
		lastX = event.getX();					//	Update the mouse location
		lastY = event.getY();

		flipWhenInside();						//	Flip any button hit by the mouse
	}

	public void mouseReleased(MouseEvent event)
	{
		flipWhenInside();
	}

	public void mouseEntered(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}

	private void flipWhenInside()
	{
		if (randomButton.isInside(lastX, lastY))
			randomButton.flip();

		else if (maximumButton.isInside(lastX, lastY))
			maximumButton.flip();
		else if (minimumButton.isInside(lastX, lastY))
			minimumButton.flip();

		else if (removeButton.isInside(lastX, lastY))
			removeButton.flip();

		theApplet.repaint();
	}

//
//	The instance variables
//
	private DataCollection collection;		//	To hold our items

	private Abutton randomButton,			//	One button for a random collection
					maximumButton,			//	Two buttons
					minimumButton,			//		to check statistics
					removeButton;			//	One button to remove an item

	private int lastX, lastY;				//	To keep the mouse location

}	// end DataOrganizer
