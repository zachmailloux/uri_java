/*
	LabDemo.java

	This class defines and implements the demo itself.
	It also implements the methods required to implement a "MouseListener".
*/

import java.awt.*;							//	AWT = "Abstract Window Toolkit"
import java.awt.event.*;					//		or "Another Window Toolkit"

public class GettingInShape extends Frame
							implements MouseListener
{
	private final int						//	To define the size of our buttons
				BUTTON_WIDTH = Abutton.BUTTON_WIDTH,
				BUTTON_HEIGHT = Abutton.BUTTON_HEIGHT;

//
//	Constructor
//	===========
//
//	The constructor customizes a new frame to accommodate the drawing window.
//	It sets the scene with the buttons for the user interaction.
//
	public GettingInShape()
	{
		setTitle("Getting in shape ...");	//	We set the characteristics of our
		setLocation(50, 50);				//		drawing window
		setSize(450, 400);
		setBackground(Color.orange);
		setVisible(true);					//		and we make it appear

		addWindowListener(myWindow);		//	To check on the window
		addMouseListener(this);				//		and on the mouse
		
		int x = BUTTON_WIDTH * 1/2;
		int y = BUTTON_HEIGHT * 3/2;
		squareButton = new Abutton("Square", Color.green, x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
		y += BUTTON_HEIGHT * 1.5;
		circleButton = new Abutton("Circle", Color.cyan, x, y, BUTTON_WIDTH, BUTTON_HEIGHT);

		initializationComplete = true;		//	Everything is initialized
	}

	public void action()
	{
		repaint();

		System.out.println("\nClick on one of the buttons!\n");
	}

//
//	The next method checks where the mouse is been clicked.
//	Each button is associated with its own action.
//
	private void check()
	{
		if (squareButton.isInside(lastX, lastY)) {
											//	We generate a square
			square = new Square();
		}
		else if (circleButton.isInside(lastX, lastY)) {
											//	We generate a circle
			circle = new Circle();
		}
		else  {
			System.out.println("What?");
		}
		repaint();
	}

//
//	The only "graphical" method of the class is the paint method.
//
	public void paint(Graphics pane)
	{
		if (initializationComplete) {
	
			squareButton.paint(pane);		//	We display the buttons
			circleButton.paint(pane);

			square.paint(pane);				//		and we show the shape
			circle.paint(pane);
		}
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
												//	Highlight the button being hit
		if (squareButton.isInside(lastX, lastY))
			squareButton.flip();				//		(if any)
		else if (circleButton.isInside(lastX, lastY))
			circleButton.flip();
		repaint();								//	Refresh the window
	}

	public void mouseReleased(MouseEvent event)
	{
												//	"De-highlight" any button that
		if (squareButton.isInside(lastX, lastY))
			squareButton.flip();				//		may be highlighted
		else if (circleButton.isInside(lastX, lastY))
			circleButton.flip();
		repaint();								//	Refresh the window
	}

	public void mouseEntered(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}

//
//	The instance variables
//
	private boolean initializationComplete = false;	//	Nothing is initialized yet

	private Square square;							//	Two shapes: a square
	private Shape circle;							//		and a circle to play with

	private Abutton squareButton,					//	Two buttons
					circleButton;					//		to create shapes

	private UneFenetre myWindow = new UneFenetre();	//	A handle on the window

	private int lastX, lastY;						//	To keep the mouse location

}	// end GettinInShape