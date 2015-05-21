/*
	BlinkingTimer.java

		This class defines a timer updated every 10th of a second.  Each 10th of
	a second is showing as an additional square.  After a full second, when all
	squares are displayed, we restart afresh.
*/

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class BlinkingTimer					//	We want to handle the events
				implements	MouseListener,	//		from the mouse
							AlarmListener	//		and from an alarm
{
	private final
		int STARTING_X = 125,				//	To define the top left corner
			STARTING_Y = 75,				//		of the first "tick"
			SIZE = 20,						//	To define the size of a tick
			SPACE = 4;						//		and the space between ticks

//
//	Constructors
//	============
//
//	The constructor sets the scene with the buttons for the user interaction.
//
	public BlinkingTimer()
	{
	}

	public BlinkingTimer(Applet mainProgram)
	{
		theApplet = mainProgram;

		theApplet.addMouseListener(this);		//	To check on the mouse

		int x = 25;
		int y = 25;
		startButton = new Abutton("Start", Color.green, x, y);
		y += Abutton.BUTTON_HEIGHT * 1.25;
		stopButton = new Abutton("Stop", Color.cyan, x, y);
		y += Abutton.BUTTON_HEIGHT * 1.25;
		clearButton = new Abutton("Clear", Color.yellow, x, y);

		alarm = null;						//	We are not using any alarm yet
											//		(in other words, we are not 
		running = false;					//		running the animation yet)

		nticks = 0;							//	We start at the beginning
	}

//
//	In order to use an alarm, we need to provide a takeNotice method.
//	It will be invoked each time the alarm goes off.
//
	public void takeNotice()
	{
		if(running){//if the program is running
			if(nticks<9){ //create 9 squares
			nticks+=1;//one more square
			}
			else{
				nticks=0;//reset if its past 10
			}
		theApplet.repaint();//repaint
		}
	
	}

//
//	On the click of the "Start" button, we start the animation
//		(unless the animation is already going on)
//
	public void startAction()
	{
		if(alarm==null){//if there isnt an alarm
		alarm = new Alarm("Gogo",this);
		alarm.setPeriod(200);
		alarm.start();
		}
		else{
			//nothing
		}
		running=true; //make it run
	
	}

//
//	On the click of the "Stop" button, we stop the animation
//		(unless the animation is not currently running)
//
	public void stopAction()
	{
		running=false; //make it stop running
	}

//
//	On the click of the "Clear" button, we reset our ticks to the beginning of a
//		new second.
//
	public void clearAction()
	{
	//	alarm= null;
		running = false; //make it stop running
		nticks=0; //reset the squares
	}

//
//	The next method checks where the mouse is been clicked.
//	Each button is associated with its own action.
//
	private void check()
	{
		theApplet.showStatus(" ");			//	To reset the status bar

		if (startButton.isInside(lastX, lastY)) {
			startAction();
		}

		else if (stopButton.isInside(lastX, lastY)) {
			stopAction();
		}

		else if (clearButton.isInside(lastX, lastY)) {
			clearAction();
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
		if (startButton != null)			//	We draw the buttons
			startButton.paint(pane);		//		(if instantiated)
		if (stopButton != null)
			stopButton.paint(pane);
		if (clearButton != null)
			clearButton.paint(pane);

		final
			int DELTA = 2;					//	To define the space between the
											//		frame and the inside of a button
		final
			Color TICK_COLOR = Color.red;

		int x = STARTING_X,
			y = STARTING_Y;

		for (int i = 0; i < nticks; i++) {
			pane.setColor(Color.black);			//	Drawing the button frame
			pane.drawRect(x, y, SIZE, SIZE);	//		in black,

			pane.setColor(TICK_COLOR);			//	and the inside of the button
			pane.fill3DRect(x + DELTA, y + DELTA,	//	in the button color
							SIZE - (2*DELTA - 1),
							SIZE - (2*DELTA - 1),
							true);

			x += SIZE + SPACE;
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
		if (startButton.isInside(lastX, lastY))
			startButton.flip();
		else if (stopButton.isInside(lastX, lastY))
			stopButton.flip();
		else if (clearButton.isInside(lastX, lastY))
			clearButton.flip();

		theApplet.repaint();
	}

//
//	Our instance variables
//
	private Applet theApplet;		//	To get ahold of the applet
									//		associated with the main program

	private Alarm alarm;			//	We use an alarm to wake us up

	private Abutton startButton,	//	Two buttons to stop & go
					stopButton,
					clearButton;	//		and one to reset

	private int lastX, lastY;		//	To keep the mouse location

//
//	Two "state" variables to know what we are doing
//
	private int nticks;				//	How many ticks so far?
	private boolean running;		//	Are we running?

}	//	end of class BlinkingTimer
