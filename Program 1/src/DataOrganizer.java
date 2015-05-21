import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Zachary Mailloux
 */
public class DataOrganizer extends Frame implements MouseListener
{

	/**
	 * buttons for interfacing with.
	 */
	private Abutton randomButton, maximumButton, minimumButton, removeButton;

	/**
	 * a collection of data for us to use.
	 */
	private DataCollection myData;

	/**
	 * An item used in creation of items.
	 */
	private Item tester;

	/**
	 * x coordinate and y coordinate of clicks.
	 */
	private int lastX, lastY;

	/**
	 * handling clicking of mouse to close window.
	 */
	private UneFenetre myWindow				//	A handle on the window
	= new UneFenetre();	//		(to control the close button)

	/**
	 * constructor doesn't take any parameters and does a bunch of stuff.
	 */
	public DataOrganizer()
	{
		myData = new DataCollection(); // initializes data collection

		randomButton = new Abutton("Random", Color.blue, 50, 50); //initializes all four buttons

		maximumButton = new Abutton("Maximum", Color.red, 50, 100);

		minimumButton = new Abutton("Minimum", Color.orange, 50, 150);

		removeButton = new Abutton("Remove", Color.pink, 50, 200);

		setTitle("A basic element ...");	//	We set the characteristics of our
		setLocation(50, 50);				//		drawing window
		setSize(700, 280);
		setBackground(Color.lightGray);
		setVisible(true);					//	And we make it appear

		addWindowListener(myWindow);		//	To check on the window
		addMouseListener(this);			//		and on the mouse

	}




	/**
	 * Does certain actions if the mouse click landed inside any of the buttons.
	 */
	private void check()
	{
		if (removeButton.isInside(lastX, lastY)) 
		{
			remove();

		}

		else if (randomButton.isInside(lastX, lastY)) 
		{
			random();
		}

		else if (maximumButton.isInside(lastX, lastY)) 
		{
			maximum();
		}
		else if (minimumButton.isInside(lastX, lastY)) 
		{
			minimum();
		}
	}


	/**
	 * Flip the buttons if mouse click landed inside them.
	 */
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


		repaint();
	}



	/**
	 * the Random button uses this method to make 10 randomly high sticks on the screen.
	 */
	private void random()
	{
		makeNull(); // deletes any sticks already in the array. Starting fresh.

		int keepingTrack = 0; // a variable to keep track of how many we have made.


		while (keepingTrack < 10)
		{
			tester = new Item(0, 250); // makes a stick. x location is determined later.

			int value = (int) (Math.random() * 19) + 1; // gives random number in between 1 and 20 (for height purposes)

			tester.setValue(value); // sets the height as the random number above.

			myData.add(tester); // adds tester to DataCollection array.

			keepingTrack ++; // we just created one more on our way to 10.
		}

		keepingTrack = 0; // after creation, make it 0 again for next time.


	}

	/**
	 * removes all of the object items from the DataCollection array to make room for new ones.
	 */
	private void makeNull()
	{
		myData.resetToEnd(); // gets the proper selection for removal.

		while(myData.hasNext()) // while there is one to remove, do it.
		{

			myData.remove();

			myData.resetToEnd(); // maintain proper selection
		}
	}

	/**
	 * used by maximum button, selects the highest item in the array in DataCollection.
	 */
	private void maximum()
	{

		myData.reset(); // starts it at 0

		Item placeHolderItem = null; // a placeholder to get each one

		Item maxPlaceHolderItem = null; // a placeholder for the current maximum

		int maxHeight = 0; // the maximum height of one so far.

		while (myData.hasNext()) // only go while there is one selected in DataCollection.
		{

			placeHolderItem = myData.next(); // sets the placeholder correctly.

			/*
			 * if the current is bigger than the current largest, it becomes the largest.
			 * also makes the current the largest regardless of size at the beginning.
			 */
			if (placeHolderItem.getValue() > maxHeight || maxPlaceHolderItem == null)
			{
				maxPlaceHolderItem = placeHolderItem;
				maxHeight = placeHolderItem.getValue(); // sets the max height to the new record.
			}

		}



		myData.reset(maxPlaceHolderItem); // selects the proper one in DataCollection.



	}


	/**
	 * exactly the same as maximum, except the champion is the lowest.  refer 
	 * to the maximum() method for other documentation of code.
	 */
	private void minimum()
	{
		myData.reset();

		Item placeHolderItem = null;

		Item maxPlaceHolderItem = null;

		int minHeight = 21;//highest possible height

		while (myData.hasNext())
		{

			placeHolderItem = myData.next();


			if (placeHolderItem.getValue() < minHeight || maxPlaceHolderItem == null)
			{
				maxPlaceHolderItem = placeHolderItem;
				minHeight = placeHolderItem.getValue();
			}

		}



		myData.reset(maxPlaceHolderItem);

	}

	/**
	 * removes the currently selected item in DataCollection.
	 */
	private void remove()
	{

		myData.remove();

		repaint();


	}

	/**
	 * paints the four buttons and, after initialization, the DataCollection we use.
	 */
	public void paint(Graphics pane)
	{
		randomButton.paint(pane);
		maximumButton.paint(pane);
		minimumButton.paint(pane);
		removeButton.paint(pane);

		if (myData != null)
		{
			myData.paint(pane);
		}

	}

	/**
	 * handles my mouse clicks.
	 */
	public void mouseClicked(MouseEvent arg0) {
		lastX = arg0.getX();
		lastY = arg0.getY();
		flipWhenInside();
		check();


	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
