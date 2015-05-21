/**
 * To introduce handling mouse events.
 * 
 * @author Zach Mailloux & Brenden Smerbeck
 */


import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PrettyPicture extends Frame implements MouseListener 
{

	/**
	 * Buttons to respond to mouse clicks
	 */
	private Abutton thisButton, thatButton;
	
	/**
	 * A handle on the window
	 */
	private UneFenetre myWindow;
	
	/**
	 * So the System doesn't try to paint the buttons before they are initialized
	 */
	private boolean initializationComplete = false;
	
	
	/*
	 * You may need other instance variables and/or references so the paint
	 * method can paint what you want it to.
	 */
	
	int x, y;
	String xvalue, yvalue;
	
	
	/**
	 * Sets up our Frame
	 */
	public PrettyPicture()
	{
		final int 	BUTTON_WIDTH = 64,
					BUTTON_HEIGHT = 32;//to define the size of our buttons
		
		setTitle("Drawing Window");//name, location and size of our frame
		setLocation(150,150);		
		setSize(400,400);
		
		setVisible(true);
		
		/*
		 * Set up our two buttons in arbitrary locations
		 */
		thisButton = new Abutton("This", Color.green, 50, 50, BUTTON_WIDTH, BUTTON_HEIGHT);
		thatButton = new Abutton("That", Color.cyan, 150, 150, BUTTON_WIDTH, BUTTON_HEIGHT);
		
		myWindow = new UneFenetre();//to allow for window closing
		addWindowListener(myWindow);
		
		addMouseListener(this);//so you can handle the mouse clicks
		
		initializationComplete = true;
	}
	
	/**
	 * The only graphical method of the class is the paint method
	 */
	public void paint(Graphics pane)
	{
		
		System.out.println("PAINTING");
		
		if(initializationComplete){
			thisButton.paint(pane);
			thatButton.paint(pane);
		pane.fillOval(x, y, 7, 7);
		xvalue = String.valueOf(x);
		yvalue = String.valueOf(y);
		pane.drawString(("("+ xvalue +" , "+ yvalue+ ")"), x+10, y);

			/*
			 * Here's where you tell it what to paint based on information
			 * you've collected in the mouseClicked method.  It's up to
			 * you what to paint, but you should mark where the most recent
			 * click is in some way that centers around the point clicked, and
			 * includes the coordinates of the click.
			 */
			
			
			
			
			
			
			
			
			
			
			
		}
	}
	

	/**
	 * The mouseClicked method is where you collect any information you
	 * need for painting properly.  If the mouse is clicked
	 * in either button you'll want to flip that button, and you'll want to
	 * get the coordinates so you can mark where the click has taken place.
	 */
	public void mouseClicked(MouseEvent event) {
		
				
		//You can access the x and y coordinates of the click
		//using event.getX() and event.getY() respectively.
		x = event.getX();
		y = event.getY();
		repaint();
		
		if(thisButton.isInside(x, y))
			thisButton.flip();
		if(thatButton.isInside(x, y))
			thatButton.flip();
		
		
		
		
		
			
		
		
		
		

	}

	//You don't need to do anything with these methods (unless you want to).
	//Like the mouseClicked method, the behaviors listed inside these
	//methods (which are currently empty) will be executed when each mouse
	//event occurs.
	
	//mouseEntered is triggered when the mouse enters the frame
	public void mouseEntered(MouseEvent event) {}

	//mouseExited is triggered when the mouse leaves the frame
	public void mouseExited(MouseEvent event) {}

	//mousePressed is triggered on the downstroke of a mouse click (or if 
	//the user holds the button down)
	public void mousePressed(MouseEvent event) {}

	//mouseReleased is triggered on the release of the mouse button, (the
	//upstroke of a click or when it's released after being held down).
	public void mouseReleased(MouseEvent event) {}

}
