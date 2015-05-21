/*
	LabDemo.java

	This class defines and implements the demo itself.
	It also implements all the methods required to implement a "MouseListener".
*/

import java.awt.*;							//	AWT = "Abstract Window Toolkit"
import java.awt.event.*;					//		or "Another Window Toolkit"
import java.util.Random;

public class DataOrganizer extends Frame
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
	public DataOrganizer()
	{
		setTitle("A basic element ...");	//	We set the characteristics of our
		setLocation(50, 50);				//		drawing window
		setSize(580, 480);
		setBackground(Color.lightGray);
		setVisible(true);					//	And we make it appear

		addWindowListener(myWindow);		//	To check on the window
		addMouseListener(this);				//		and on the mouse
		
		int x = 30;
		int y = 50;
		randomButton = new Abutton("Random", Color.yellow, x, y);

		y += 50;
		maxButton = new Abutton("Maximum", Color.blue, x, y);
		y +=50;
		minButton = new Abutton("Minimum", Color.white, x, y);

		y += 50;
		removeButton = new Abutton("Remove", Color.pink, x, y);

		x += 3.5*Abutton.BUTTON_WIDTH;
		y += 1*Abutton.BUTTON_HEIGHT;
		//element = new Item(x, y);
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
		if (removeButton.isInside(lastX, lastY)) {
			collection.remove();
		//	repaint();

		}

		else if (randomButton.isInside(lastX, lastY)) {
			collection= new myCollection(); 
			started = true;
			int x = 160;
			for(int i=0;i<10;i++){
				Item item = new Item(x,y);
				x+=30;
				item.setValue(random.nextInt(100)+20);
				collection.add(item);
			}
		}

		else if (maxButton.isInside(lastX, lastY)) {
			Item maxitem=null;
			collection.reset();
			Item max = collection.next();
			System.out.println("max = " + collection.next().getValue());
			while(collection.hasNext()){
				Item item = collection.next();
				if(item.getValue()>max.getValue()){
					System.out.println("newmax");
					//max = item;
					//System.out.println("Actual max = "+max);
					maxitem = item;
				}
			}
			collection.reset(maxitem);
		
		}
		else if (minButton.isInside(lastX, lastY)) {
		
			Item minitem=null;
			int min = collection.next().getValue();
			while(collection.hasNext()){
				Item item = collection.next();
				
				if(item.getValue()<min){	
					min = item.getValue();
					minitem = item;
				}
			}
			collection.reset(minitem);
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

		if (maxButton != null)				//		to choose the color,
			maxButton.paint(pane);
		if (minButton != null)
			minButton.paint(pane);


		if (removeButton != null)				//		and to stop playing
			removeButton.paint(pane);

		if (started != false){//When instantiated,
			//System.out.println("Should print");
			collection.paint(pane);	}		//		we also display the element
	}

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
		if (removeButton.isInside(lastX, lastY))
			removeButton.flip();

		else if (randomButton.isInside(lastX, lastY))
			randomButton.flip();

		else if (maxButton.isInside(lastX, lastY))
			maxButton.flip();
		else if (minButton.isInside(lastX, lastY))
			minButton.flip();


		repaint();
	}

//
//	The instance variables
//
	DataCollection collection = new myCollection();             // A collection to play with
	//private Item element;			//	To visualize our element
	Random random = new Random();
	int[]heights = new int[10];
	private boolean started = false;
	private Abutton randomButton,			//	One button for a random element
					maxButton,				//	Three buttons
					minButton,			
					removeButton;				//	One button to stop playing

	private UneFenetre myWindow = new UneFenetre();	//	A handle on the window
	private int x=160, y=270;
	private int lastX, lastY;				//	To keep the mouse location

}	// end LabDemo