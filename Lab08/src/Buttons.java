/**
  * To introduce handling mouse events.
 * 
 * @author 
 */


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class Buttons extends Frame implements MouseListener 
{
	
	/**
	 * Buttons to respond to mouse clicks
	 */
	private Abutton button1, button2, button3;

	
	
	/**
	 * A handle on the window
	 */
	private UneFenetre myWindow;
	
	/**
	 * So the System doesn't try to paint the buttons before they are initialized
	 */
	private boolean initializationComplete = false;
	
	/**
	 * We don't really need a separate class to instantiate our object...
	 * @param args none expected
	 */
	public static void main(String[] args){
		Buttons pic = new Buttons();
	}
	
	
	/**
	 * Sets up our Frame
	 */
	public Buttons()
	{
		final int 	BUTTON_WIDTH = 64,
					BUTTON_HEIGHT = 32;//to define the size of our buttons
		
		setTitle("Drawing Window");//name, location and size of our frame
		setLocation(150,150);		
		setSize(364,132);
		
		setVisible(true);
		
		/*
		 * Set up our three buttons in a row
		 */
		button1 = new Abutton("1", Color.red, 50, 50, BUTTON_WIDTH, BUTTON_HEIGHT);
		button2 = new OvalShape("2", Color.green, 150, 50, BUTTON_WIDTH, BUTTON_HEIGHT);
		button3 = new InvisButton("3", Color.blue, 250, 50, BUTTON_WIDTH, BUTTON_HEIGHT);
		
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
			button1.paint(pane);
			button2.paint(pane);
			button3.paint(pane);
			
		}
	}
	

	/**
	 * The mouseClicked method is where you collect any information you
	 * need for painting properly.  If the mouse is clicked
	 * in either button you'll want to flip that button, and you'll want to
	 * get the coordinates so you can mark where the click has taken place.
	 */
	public void mouseClicked(MouseEvent event) {
		
		int x = event.getX();
		int y = event.getY();
		
		JFrame frame = new JFrame("");
		
		if(button1.isInside(x, y)){
			JOptionPane.showMessageDialog(frame,
		    "I think you pushed button 1.");

		}
		else if(button2.isInside(x, y)){
			JOptionPane.showMessageDialog(frame,
		    "Clicking on button 2 tickles.");
		}
		else if(button3.isInside(x, y)){
			JOptionPane.showMessageDialog(frame,
		    "You pushed button 3.  I like blue.");
		}

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
	public void mousePressed(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		
		
		
		if(button1.isInside(x, y)){
			button1.flip();
			repaint();
		}
		else if(button2.isInside(x, y)){
			button2.flip();
			repaint();
		}
		else if(button3.isInside(x, y)){
			button3.flip();
			repaint();
		}
	}

	//mouseReleased is triggered on the release of the mouse button, (the
	//upstroke of a click or when it's released after being held down).
	public void mouseReleased(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		
		
		
		if(button1.isInside(x, y)){
			button1.flip();
			repaint();
		}
		else if(button2.isInside(x, y)){
			button2.flip();
			repaint();
		}
		else if(button3.isInside(x, y)){
			button3.flip();
			repaint();
		}
	}

}
