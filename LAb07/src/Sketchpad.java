import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
* Zachary Mailloux and Julian Colonia 
*/


public class Sketchpad extends Frame implements MouseListener {
	
	//You'll need an array of stars (or some other polygon)
	
	private HourGlass[] HourGlass =  new HourGlass[100];
	
	
	/**
	 * A handle on the window
	 */
	private UneFenetre myWindow;
	
	/**
	 * So we can clear all the stars (or whatever polygon you're using)
	 */
	private Abutton clear;
	
	/**
	 * To hold the coordinates of the latest mouse click
	 */
	private int x, y;
	private int counter = 0;
	
	/**
	 * Sets up the window, the button and ???
	 */
	public Sketchpad(){
		
		setTitle("Stars!");
		setSize(400,400);
		setLocation(150,150);	
		setBackground(Color.lightGray);
		
		myWindow = new UneFenetre();//to allow for window closing
		addWindowListener(myWindow);
		
		addMouseListener(this);
		
		final int 	BUTTON_WIDTH = 64,
		BUTTON_HEIGHT = 32;//to define the size of our buttons
		clear = new Abutton("Clear", Color.green, 10, 35, 
				BUTTON_WIDTH, BUTTON_HEIGHT);		
		
		setVisible(true);
	}

	/**
	 * What do you need to do here?
	 */
	public void mouseClicked(MouseEvent e) {

		if (!(clear.isInside(x, y))){ //if its not in the green rectangle
			HourGlass[counter] = new HourGlass(x, y); //add a new HourGlass to our array of Hour Glasses
			counter++;
		}
		repaint();
		
	}

	/**
	 * Pushes the button in
	 */
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if(clear.isInside(x, y)){
			counter = 0;
			clear.flip();
			repaint();
		}
		
	}

	/**
	 * Lets the button pop back out
	 */
	public void mouseReleased(MouseEvent e) {
		if(clear.isInside(x, y)){
			clear.flip();
			repaint();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * What do you need to do here?
	 */
	public void paint(Graphics pane){
		pane.clearRect(0, 0, 400, 400);
		clear.paint(pane);//show the button
		for(int i=0; i<counter; i++){
			HourGlass[i].paintHourGlass(pane);}
	}
	
	/**
	 * If it's only one line, it doesn't really need a separate class...
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new Sketchpad();
	}

}
