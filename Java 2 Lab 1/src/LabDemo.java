/*
	LabDemo.java

	This class defines and implements the demo itself.
	It also implements all the methods required to implement a "MouseListener".
*/

import java.awt.*;							//	AWT = "Abstract Window Toolkit"
import java.awt.event.*;					//		or "Another Window Toolkit"

public class LabDemo extends Frame
						implements MouseListener
{
//
//	Constructor
//	===========
//
//	The constructor defines a new frame to accommodate the drawing window.
//	It also sets the scene with the visualization of the element
//		and the buttons to manipulate the value of the element.
//
	public LabDemo()
	{
		setTitle("A basic element ...");	//	We set the characteristics of our
		setLocation(50, 50);				//		drawing window
		setSize(380, 280);
		setBackground(Color.lightGray);
		setVisible(true);					//	And we make it appear

		addWindowListener(myWindow);		//	To check on the window
		addMouseListener(this);				//		and on the mouse
		
		int x = 30;
		int y = 50;
		randomButton = new Abutton("Random", Color.yellow, x, y);

		x += 1.5*Abutton.BUTTON_WIDTH;
		bleuButton = new Abutton("Bleu", Color.blue, x, y);
		y += 1.1*Abutton.BUTTON_HEIGHT;
		blancButton = new Abutton("Blanc", Color.white, x, y);
		y += 1.1*Abutton.BUTTON_HEIGHT;
		rougeButton = new Abutton("Rouge", Color.red, x, y);

		y += 1.4*Abutton.BUTTON_HEIGHT;
		biggerButton = new Abutton("Bigger", Color.green, x, y);
		y += 1.1*Abutton.BUTTON_HEIGHT;
		smallerButton = new Abutton("Smaller", Color.cyan, x, y);

		x -= 1.5*Abutton.BUTTON_WIDTH;
		quitButton = new Abutton("Quit", Color.pink, x, y);

		x += 3.5*Abutton.BUTTON_WIDTH;
		y += 1*Abutton.BUTTON_HEIGHT;
		element = new BasicElement(x, y);
	}

	public void action()
	{
		System.out.println("\nClick on one of the buttons!\n");

		repaint();
	}

//
//	The next method checks where the mouse is been clicked.
//	Each button is associated with its own action.
//
	private void check()
	{
		if (quitButton.isInside(lastX, lastY)) {
			System.out.println("\nI hope you had fun!\n");
			System.exit(0);					//	Nothing more to do
		}

		else if (randomButton.isInside(lastX, lastY)) {
			element.setValue( (int)(1 + 10*Math.random()) );
			element.setColor( Color.yellow );
		}

		else if (bleuButton.isInside(lastX, lastY)) {
			element.setColor(Color.blue);
		}
		else if (blancButton.isInside(lastX, lastY)) {
			element.setColor(Color.white);
		}
		else if (rougeButton.isInside(lastX, lastY)) {
			element.setColor(Color.red);
		}

		else if (biggerButton.isInside(lastX, lastY)) {
			element.setValue( element.getValue()*2 );
		}
		else if (smallerButton.isInside(lastX, lastY)) {
			element.setValue( element.getValue()/2 );
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
		if (randomButton != null)			//	When instantiated,
			randomButton.paint(pane);		//		we display all the buttons

		if (bleuButton != null)				//		to choose the color,
			bleuButton.paint(pane);
		if (blancButton != null)
			blancButton.paint(pane);
		if (rougeButton != null)
			rougeButton.paint(pane);

		if (biggerButton != null)			//		to change the size,
			biggerButton.paint(pane);
		if (smallerButton != null)
			smallerButton.paint(pane);

		if (quitButton != null)				//		and to stop playing
			quitButton.paint(pane);

		if (element != null)				//	When instantiated,
			element.paint(pane);			//		we also display the element
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
		check();							//	Handle the mouse click
	}

	public void mousePressed(MouseEvent event)
	{
		lastX = event.getX();				//	Update the mouse location
		lastY = event.getY();

		flipWhenInside();					//	Flip any button hit by the mouse
	}

	public void mouseReleased(MouseEvent event)
	{
		flipWhenInside();
	}

	public void mouseEntered(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}

	private void flipWhenInside()
	{
		if (quitButton.isInside(lastX, lastY))
			quitButton.flip();

		else if (randomButton.isInside(lastX, lastY))
			randomButton.flip();

		else if (bleuButton.isInside(lastX, lastY))
			bleuButton.flip();
		else if (blancButton.isInside(lastX, lastY))
			blancButton.flip();
		else if (rougeButton.isInside(lastX, lastY))
			rougeButton.flip();

		else if (biggerButton.isInside(lastX, lastY))
			biggerButton.flip();
		else if (smallerButton.isInside(lastX, lastY))
			smallerButton.flip();

		repaint();
	}

//
//	The instance variables
//
	private BasicElement element;			//	To visualize our element

	private Abutton randomButton,			//	One button for a random element
					bleuButton,				//	Three buttons
					blancButton,			//		to choose a color
					rougeButton,
					biggerButton,			//	Two buttons
					smallerButton,			//		to to change the size
					quitButton;				//	One button to stop playing

	private UneFenetre myWindow = new UneFenetre();	//	A handle on the window

	private int lastX, lastY;				//	To keep the mouse location

}	// end LabDemo