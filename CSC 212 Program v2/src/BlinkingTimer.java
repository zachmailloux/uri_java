

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.applet.Applet;
import java.io.File;
import java.io.IOException;
import java.awt.Button;

public class BlinkingTimer extends Frame	//	We want to handle the events
implements	MouseListener,	//		from the mouse
AlarmListener				//		and from an alarm
{

	/**
	 * Our instance variables
	 */
	private BlinkingTimer myTimer;	//	We need a timer
	private Alarm alarm;			//	We use an alarm to wake us up
	private UneFenetre myWindow = 
			new UneFenetre();		//	A handle on the window

	/**
	 * Buttons
	 */
	private Abutton 

	throwButton,	//	Two buttons to throw ball
	fastButton,		// button to speed up animation
	slowButton,		// button to slow down animation
	resetButton,	//	and one to reset
	traceButton;
	//Button throwButton;
	public static boolean isTrace = false; // Control for trace (on & off)

	private Ball ball; 				// ball object

	private int periodTracker = 10; // to increment the period

	private int period=100; 		// initial period

	private int lastX, lastY;		//	To keep the mouse location


	/**
	 * Dimensions of Rectangle
	 */
	public static final int 
	UPPERLEFTRECX=150,		// x coordinate
	UPPERLEFTRECY = 100,	// y coordinate
	WIDTH = 500, 			// width of rectangle
	HEIGHT = 450; 			// height of rectangle


	/**
	 * To keep track of Dimensions of rectangle
	 */
	public static final int LOWERRIGHTRECX = UPPERLEFTRECX+WIDTH;
	public static final int LOWERRIGHTRECY = UPPERLEFTRECY+HEIGHT;


	//
	//	Constructors
	//	============
	//
	//	The constructor sets the scene with the buttons for the user interaction.
	//
	public BlinkingTimer()
	{
		setTitle("Blinking Timer");	//	We set the characteristics of our
		setLocation(50, 50);				//		drawing window
		setSize(700, 700);
		setBackground(Color.lightGray);
		setVisible(true);					//		and we make it appear

		addWindowListener(myWindow);		//	To check on the window
		addMouseListener(this);				//		and on the mouse
		
		int x = 25;
		int y = 25;
	//	Button throwButton = new Button("THROW");
		//this.add(throwButton);
	
		//throwButton.
		throwButton = new Abutton("THROW", Color.green, x, y);
		y += Abutton.BUTTON_HEIGHT * 1.25;
		fastButton = new Abutton("Faster", Color.cyan, x, y);
		y += Abutton.BUTTON_HEIGHT * 1.25;
		resetButton = new Abutton("CLEAR", Color.yellow, x, y);
		y += Abutton.BUTTON_HEIGHT * 1.25;
		slowButton = new Abutton("SLOWER", Color.cyan, x, y);
		y += Abutton.BUTTON_HEIGHT * 1.25;
		traceButton = new Abutton("TRACE", Color.blue, x, y);


		ball = null;			//	We are not using any ball yet 
	}

	/**
	 * For updating
	 */
	public void action()
	{
		repaint();

		System.out.println("\nClick on one of the buttons!\n");
		while (true) {//    For as long as we have energy,
			System.out.println("."); //THIS LINE IS ADDED
		}

	}

	/**
	 * In order to use an alarm, we need to provide a takeNotice method.
	 * It will be invoked each time the alarm goes off.
	 */
	public void takeNotice()
	{

		if (ball!=null){	// only if there's a ball
			ball.move(); 	// to update ball
			repaint(); 		// paint ticks
		}

	}
public double x,y,speedX,speedY;
	/**
	 * 	On the click of the "Throw" button, we start the animation
	 * 		(unless the animation is already going on)
	 */
	public void throwAction()
	{

		if(alarm==null){   	 			// if nothing is in alarm
			alarm = new Alarm(this); 	// new thread. calling constructor
			alarm.start(); 				// start thread
			alarm.setPeriod(100); 		// sets period to 10th of a second
		}

		if (ball==null){				// if there's no ball
			
			ball = new Ball();			// create new ball
		}

	}

	/**
	 * 	On the click of the "Faster" button, we speed up the animation
	 */
	public void fastAction()
	{

		if(periodTracker<=-80)	// heres a limit on how fast the ball can go

			alarm.setPeriod(period+periodTracker); // doesn't decrement

		else	

			alarm.setPeriod(period+(periodTracker-=5)); // decrement n making period faster
	}

	/**
	 * 	On the click of the "Slow" button, we slow down the animation
	 */
	public void slowAction()
	{
		alarm.setPeriod(period+(periodTracker+=5)); // increment n making period slower
	}

	/**
	 * On the click of the "Reset" button, we reset the ball to null
	 * 		keeping regular period
	 */
	public void resetAction()
	{

		ball = null; 			// no more ball
		alarm.setPeriod(100);	// back to regular speed
		periodTracker=10;		// Incremented reset back to 10
		isTrace = false;		// don't trace the ball anymore

	}
	/**
	 * Flips the switch to turn on tracing of the ball
	 */
	public void traceAction()
	{
		isTrace = true; // we now turn on the trace
	}

	/**
	 * The check method checks where the mouse is been clicked.
	 * 	Each button is associated with its own action.
	 */
	private void check()
	{

		if (throwButton.isInside(lastX, lastY)) {
			throwAction();
		}

		else if (fastButton.isInside(lastX, lastY)) {

			fastAction();

		}

		else if (slowButton.isInside(lastX, lastY)) {

			slowAction();

		}

		else if (resetButton.isInside(lastX, lastY)) {
			resetAction();
		}

		else if (traceButton.isInside(lastX, lastY)) {
			traceAction();
		}

		else  {
			System.out.println("What?");
		}

		repaint();
	}

	/**
	 * The only "graphical" method of the class is the paint method.
	 */
	public void paint(Graphics pane)
	{
		setBackground(Color.red);		//	Not so pretty.  Or is it?
		if (throwButton != null)			//	We draw the buttons
			throwButton.paint(pane);		//		(if instantiated)
		if (fastButton != null)
			fastButton.paint(pane);
		if (resetButton != null)
			resetButton.paint(pane);
		if (slowButton != null)
			slowButton.paint(pane);
		if (traceButton != null)
			traceButton.paint(pane);
		if (ball!=null){					// if there's a ball
			ball.paint(pane);				// paint ball

		}
		// we paint barrier
		pane.drawRect(UPPERLEFTRECX, UPPERLEFTRECY , WIDTH, HEIGHT);

		if (myTimer != null)		// if timer isn't null
			myTimer.paint(pane);	// we paint timer
		
	}

	/**
	 * 
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
	 */
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
	
	/**
	 * control clicking of button
	 */
	private void flipWhenInside()
	{
		if (throwButton.isInside(lastX, lastY))
			throwButton.flip();
		else if (fastButton.isInside(lastX, lastY))
			fastButton.flip();
		else if (resetButton.isInside(lastX, lastY))
			resetButton.flip();
		else if (slowButton.isInside(lastX, lastY))
			slowButton.flip();
		else if (traceButton.isInside(lastX, lastY))
			traceButton.flip();

		repaint();
	}


}	//	end of class BlinkingTimer
