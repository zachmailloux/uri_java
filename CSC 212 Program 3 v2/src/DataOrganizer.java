/*
	DataOrganizer.java

		This class defines and implements the data organizer.

		The class makes use of a collection of items, and provides very basic
	operations on that collection.

		[The class also implements all the methods required to implement a
	"MouseListener".]
 */

import java.awt.*; //	AWT = "Abstract Window Toolkit"
import java.awt.event.*; //		or "Another Window Toolkit"

public class DataOrganizer extends Frame implements MouseListener {
	private static final boolean DEBUG = false;

	private static final Color DEFAULT_COLOR = Color.YELLOW,
			HIGHLIGHT_COLOR = Color.YELLOW.darker();

	private DataCollection<Item> collection; // To hold our items
	
	private Item selected;

	private final int COLLECTION_SIZE = 10, // Maximum number of items
			MAXIMUM_ITEM_VALUE = 16; // Maximum value of an item

	private int firstItemXCoord, firstItemYCoord;

	private int lastX, lastY; // To keep the mouse location

	private UneFenetre myWindow = new UneFenetre(); // A handle on the window

	private Abutton randomButton, // One button for a random collection
			maximumButton, // Two buttons
			minimumButton, // to check statistics
			removeButton; // One button to remove an item

	public DataOrganizer() {
		setTitle("Some basic elements..."); // We set the characteristics of our
		setLocation(50, 50); // drawing window
		setSize(500, 250);
		setBackground(Color.lightGray);
		setVisible(true); // And we make it appear

		addWindowListener(myWindow); // To check on the window

		addMouseListener(this); // This class will handle the mouse

		int x = 30;
		int y = 50;
		randomButton = new Abutton("Random", Color.yellow, x, y);

		y += 1.5 * Abutton.BUTTON_HEIGHT;
		maximumButton = new Abutton("Maximum", Color.green, x, y);
		y += 1.1 * Abutton.BUTTON_HEIGHT;
		minimumButton = new Abutton("Minimum", Color.cyan, x, y);

		y += 1.5 * Abutton.BUTTON_HEIGHT;
		removeButton = new Abutton("Remove", Color.pink, x, y);

		firstItemXCoord = x + Abutton.BUTTON_WIDTH + Abutton.BUTTON_WIDTH / 2; // 1.5x
																				// without
																				// casts
		firstItemYCoord = y + 1 * Abutton.BUTTON_HEIGHT;
		collection = new DataCollection<Item>(COLLECTION_SIZE);
	}

	public void action() {
		System.out.println("\nClick on one of the buttons!\n");

		repaint();

	}

	//
	// Maximum
	//
	public void maximumAction() {
		if (DEBUG)
			System.out.println("doing maximumAction()");
		Item maximumItem = null, someItem;

		collection.reset(); // We start at the beginning

		while (collection.hasNext()) {
			// What's next?
			someItem = (Item) (collection.next());
			someItem.highlight(false); // First, we de-highlight
			someItem.setColor(DEFAULT_COLOR);
			someItem.setY(firstItemYCoord);

			if ((maximumItem == null) || // If it is the largest so far,
					(someItem.getValue() > maximumItem.getValue()))
				maximumItem = someItem; // we keep track of it
		}

		collection.reset(maximumItem);

		if (maximumItem != null) { // Last, we highlight the largest
			maximumItem.highlight(true); // if there is one
			maximumItem.setColor(HIGHLIGHT_COLOR);
			selected=maximumItem;
		}
	}

	//
	// Minimum
	//
	public void minimumAction() {
		if (DEBUG)
			System.out.println("doing minimumAction()");
		Item minimumItem = null, someItem;

		collection.reset();

		while (collection.hasNext()) {
			// What's next?
			someItem = (Item) (collection.next());
			someItem.highlight(false); // First, we de-highlight
			someItem.setColor(DEFAULT_COLOR);

			if ((minimumItem == null) || // If it is the smallest so far,
					(someItem.getValue() < minimumItem.getValue()))
				minimumItem = someItem; // we keep track of it
		}
		collection.reset(minimumItem);

		if (minimumItem != null) { // Last, we highlight the smallest
			minimumItem.highlight(true); // if there is one
			minimumItem.setColor(HIGHLIGHT_COLOR);
			selected=minimumItem;
		}
	}

	//
	// M o u s e L i s t e n e r
	// =========================
	//
	// The implementation of the MouseListener requires the implementation of
	// the
	// following five methods. Each method deals with a particular event
	// associated with the mouse.
	//
	// mouseClicked: invoked when the mouse button is pressed and released at
	// the
	// same location.
	// mousePressed: invoked when the mouse button is pressed down
	// mouseReleased: invoked when the mouse button is released
	// mouseEntered: invoked when the mouse pointer moves into a component
	// (i.e., the Frame)
	// mouseExited: invoked when the mouse pointer moves out of a component
	//
	// Note that we are "listening" to mouse events that occur in conjunction
	// with the
	// Frame that implements the methods associated with the mouse. If your
	// application has several frames, each frame can deal with its own mouse
	// events in completely independent ways.
	//
	// Only the click of the mouse is of interest to this demo ... or is it?
	//
	public void mouseClicked(MouseEvent event) {
		lastX = event.getX(); // Update the mouse location
		lastY = event.getY();
		check(); // Handle the mouse click
	}

	public void mouseEntered(MouseEvent event) {
	}

	public void mouseExited(MouseEvent event) {
	}

	public void mousePressed(MouseEvent event) {
		lastX = event.getX(); // Update the mouse location
		lastY = event.getY();

		flipWhenInside(); // Flip any button hit by the mouse
	}

	public void mouseReleased(MouseEvent event) {
		lastX = event.getX(); // Update the mouse location
		lastY = event.getY();
		flipWhenInside();
		check();
	}

	//
	// The only "graphical" method of the class is the paint method.
	//
	public void paint(Graphics pane) {
		if (DEBUG)
			System.out.println("doing paint(Graphics pane); collection is "
					+ (collection == null ? "null" : "not null"));
		if (collection != null) { // When instantiated,
			Item e; // we display the items
			int x = firstItemXCoord;
			collection.reset();
			while (collection.hasNext()) {
				e = collection.next();
				if (DEBUG)
					System.out.println("painting item " + e + " at x=" + x);
				e.paint(pane, x, firstItemYCoord);
				x += Item.OVERALL_WIDTH;
			}
		}
		if (randomButton != null)
			randomButton.paint(pane); // and all of the buttons

		if (maximumButton != null)
			maximumButton.paint(pane);
		if (minimumButton != null)
			minimumButton.paint(pane);

		if (removeButton != null)
			removeButton.paint(pane);
	}

	//
	// Random
	//
	public void randomAction() {
		if (DEBUG)
			System.out.println("doing randomAction");
		collection.clear(); // We restart with nothing,
							// then we add random items,
		for (int i = 1; i <= COLLECTION_SIZE; i++) {
			collection.add(new Item((int) (1 + MAXIMUM_ITEM_VALUE
					* Math.random()), DEFAULT_COLOR));
		}
		selected = null; // We make sure nothing is selected
	}

	//
	// Remove
	//
	public void removeAction() {
		if (DEBUG)
			System.out.println("doing removeAction()");
		collection.reset(selected);
		collection.remove();
		selected=null;
		repaint();
	}

	//
	// The next method checks where the mouse is been clicked.
	// Each button is associated with its own action.
	//
	private void check() {
		// theApplet.showStatus(" "); // To reset the status bar

		if (randomButton.isInside(lastX, lastY)) {
			randomAction();
		}

		else if (maximumButton.isInside(lastX, lastY)) {
			maximumAction();
		} else if (minimumButton.isInside(lastX, lastY)) {
			minimumAction();
		}

		else if (removeButton.isInside(lastX, lastY)) {
			removeAction();
		}

		else {
			System.out.println("What?");
		}

		repaint();
	}

	private void flipWhenInside() {
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

} // end DataOrganizer