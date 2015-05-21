import java.awt.*;

import java.awt.event.*;

import javax.swing.JColorChooser;

import shapes.*;
import button.*;



public class Shapes extends Frame implements MouseListener, ComponentListener {

	/**
	 * Buttons to respond to mouse clicks
	 */
	private AButton[] buttons = new AButton[4];

	
	/**
	 * One oval, rectangle and triangle
	 */
	private Oval oval;
	
	private Rect rectangle;
	
	private Triangle triangle;
	private int arraySize= 10;
	public int shapeCount= 0;
	private myShape[] myArray = new myShape[arraySize];
	/**
	 * To keep track of the size of the window
	 */
	private int windowHeight, windowWidth;

	/**
	 * To make sure we don't draw the shapes too high or overlapping the buttons
	 */
	private static final int LABEL_HEIGHT = 50, BUTTON_PANEL = 115, PANEL_HEIGHT = 250;

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
		new Shapes();
	}


	/**
	 * Sets up our Frame
	 */
	public Shapes()
	{
		final int 	BUTTON_WIDTH = 100,
		BUTTON_HEIGHT = 40,//to define the size of our buttons
		SPACE = 10;//space between buttons

		setTitle("Getting in Shape");//name, location and size of our frame
		setLocation(150,150);	

		windowWidth = 800;//can be resized, but starts out reasonably large
		windowHeight = 800;
		setSize(windowWidth,windowHeight);

		/*
		 * Set up our four buttons in the top left of the drawing window
		 */
		buttons[0] = new RegularButton("Rectangle", Color.red, SPACE, LABEL_HEIGHT + SPACE, 
				BUTTON_WIDTH, BUTTON_HEIGHT);


		buttons[1] = new OvalButton("Oval", Color.green, SPACE, 
				LABEL_HEIGHT + BUTTON_HEIGHT + SPACE * 2, BUTTON_WIDTH, BUTTON_HEIGHT);

		buttons[2] = new TriangleButton("Triangle", Color.cyan, SPACE, 
				LABEL_HEIGHT + BUTTON_HEIGHT * 2 + SPACE * 3, BUTTON_WIDTH, BUTTON_HEIGHT);

		buttons[3] = new TransparentButton("Clear", Color.blue, SPACE, 
				LABEL_HEIGHT + BUTTON_HEIGHT * 3 + SPACE * 4, BUTTON_WIDTH, BUTTON_HEIGHT);


		myWindow = new UneFenetre();//to allow for window closing
		addWindowListener(myWindow);
		
		addMouseListener(this);//to allow buttons to work
		
		addComponentListener(this);//to know when the window has been resized

		initializationComplete = true;
		
		setVisible(true);
	}

	/**
	 * The only graphical method of the class is the paint method
	 */
	public void paint(Graphics pane)
	{

		System.out.println("PAINTING");

		if(initializationComplete){
			
			/*
			 *  Note: we can use the "for each" syntax because we know all four buttons
			 *  have been instantiated.  We couldn't do that if any of the references
			 *  in the array were null.  Let's say we had an int variable numButtons that
			 *  held how many buttons had been instantiated.
			 *  We would need to use the syntax:
			 *  
			 *  for(int i = 0; i < numButtons; i++){
			 *  	buttons[i].paint(pane);
			 *  }
			 */
			for(AButton button: buttons){//makes it easy to paint when they are in 
				button.paint(pane);		//an array!
			}

		
		for(int i= 0; i<shapeCount; i++){
			myArray[i].paint(pane); //move to the next position in the array
		}

		}
	}
	
	/**
	 * There are three sets of methods that are exactly the same, except
	 * for which shape they are setting up.
	 */
	private void setArray(){
		setCoordinates();
		setColor();
		repaint();
	}



	/**
	 * To make sure randomly generated shape is entirely within visible part of window
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	private boolean validateCoordinates(int x, int y, int width, int height){
		
		/*
		 * Make sure that if the shape is to the right of any of the buttons it doesn't
		 * overlap the buttons, or that it is below.  In any case make sure
		 * it's entirely within the window.
		 */

		return((x>BUTTON_PANEL && x + width < windowWidth && y > LABEL_HEIGHT 
				&& y+height < windowHeight) || (y > PANEL_HEIGHT && y + height < windowHeight
						&& x>0 && x + width < windowWidth));
	}
	
	/**
	 * All of the methods setting the coordinates make sure that the
	 * shape is entirely within the window, (at its current size)
	 */
	private void setCoordinates(){

		int x, y, width, height;
		do{
			x = (int)(Math.random()*windowWidth);
			y = (int)(Math.random()*windowHeight);
			width = (int)(Math.random()*(windowWidth/4 - 10) + 10);
			height = (int)(Math.random()*(windowHeight/4 - 10) + 10);
		}while(!validateCoordinates(x,y,width,height));
		myArray[shapeCount-1].setup(x, y, width, height); //drop one for its placement in array
		
	}
	
	
	/**
	 * All of the methods setting color use a color chooser rather than a random color
	 */
	private void setColor(){
		Color c;
		do{
			c = JColorChooser.showDialog(this, "What color do you want your shape to be?", 
					Color.YELLOW);
		}while(c==null);
		myArray[shapeCount-1].setColor(c);
	}



	/**
	 * If the mouse click is within one of the shape buttons, it makes a new
	 * instance of that shape, (replacing any previous instance).  If it's 
	 * within the clear button it clears all the shapes.
	 */
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(shapeCount == arraySize){
			arrayResize();
		}
		if(buttons[0].isInside(x, y)){	//rectangle button
			myArray[shapeCount] = rectangle = new Rect();
			shapeCount = shapeCount + 1;
			setArray();
			repaint();
		}else if(buttons[1].isInside(x, y)){	//oval button
			myArray[shapeCount] =oval = new Oval();
			shapeCount = shapeCount + 1;
			setArray();
			repaint();
		}else if(buttons[2].isInside(x, y)){	//triangle button
			myArray[shapeCount] =triangle = new Triangle();
			shapeCount = shapeCount + 1;
			setArray();
			repaint();
		}else if (buttons[3].isInside(x, y)){	//clear button
			rectangle = null;
			oval = null;
			triangle = null;
			repaint();
		}

	}

	/**
	 * Flips the button that has been pressed
	 */
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		for(AButton b:buttons){
			if(b.isInside(x, y)){
				b.flip();
				repaint();
			}
		}

	}

	/**
	 * Flips the button that has been released
	 */
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		for(AButton b:buttons){
			if(b.isInside(x, y)){
				b.flip();
				repaint();
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	public void componentHidden(ComponentEvent event){}


	/**
	 * Makes sure shapes drawn after window is resized fit inside window.
	 */
	public void componentResized(ComponentEvent e) {
		windowWidth = getWidth();
		windowHeight = getHeight();	
	}
	private void arrayResize(){
		myShape[] temp = new myShape[arraySize*2];
		for(int i =0; i < arraySize; i++){
			temp[i] = myArray[i]; //resize the array while keeping the current shapes active.
		}
	myArray = temp;
	arraySize = arraySize * 2;
	}


	@Override
	public void componentMoved(ComponentEvent e) {}


	@Override
	public void componentShown(ComponentEvent e) {}


}
