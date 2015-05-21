import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;


public class Game extends Frame implements MouseListener { 

	// Data Fields
	/**
	 * Buttons that will be used to handle the "eat" action, exiting, and 
	 * the zone within which the hippo can "eat." A Buttons was used for this 
	 * as it had a very effective isInside() method.
	 */
	private Buttons eatButton, exitButton, eatZone;
	
	/**
	 * Two integer values to hold x and y values of the mouse location
	 */
	private int x = 0, y = 0;
	
	/**
	 * New Hippo object player is the player's hippo
	 */
	private Hippo player;
	
	/**
	 * New Pellet array of length 10 to hold UpScore and DownScore pellets
	 * that will appear randomly around the window.
	 */
	private Pellet[] pellets = new Pellet[10];
	
	/**
	 * Integer values to hold the x and y locations of the pellets in the array,
	 * as well as an isGood integer to determine whether or not to generate an UpScore or
	 * DownScore pellet based on random generation.
	 */
	private int pelletX = 0, pelletY = 0, isGood = 0;
	
	/**
	 * New Random generator to generate random x and y locations for the Pellet objects
	 * as well as determine whether or not to generate UpScore or DownScore pellets
	 */
	private Random r = new Random();
	
	/**
	 * Integer value timer used to determine how long a round lasts.
	 */
	private int timer = 30;
	
	/**
	 * New Score object to hold the score value 
	 */
	private Score score;
	
	/**
	 * New Image object to serve as the background of the game
	 */
	private Image background = Toolkit.getDefaultToolkit().createImage("background.jpg");
	
	/**
	 * New Image object to serve as the "eat" button
	 */
	private Image eat = Toolkit.getDefaultToolkit().createImage("eat.png");
	
	/**
	 * Constant to pertain to the default width of a button
	 */
	private final int BUTTON_WIDTH = 128;
	
	/**
	 * Constant to pertain to the default height of a button
	 */
	private final int BUTTON_HEIGHT = 64;
	
	/**
	 * Constant to control the delay between valid clicks of the "eat" button. Greater
	 * values decrease the frequency at which the "eat" button can be pressed and have
	 * the actions performed.
	 */
	private final long DELAY = 1500;
	
	/**
	 * long variable to represent the last time a valid click of the "eat" button has
	 * been pressed
	 */
	private long recentClick = 0;

	/**
	 * Default constructor
	 * 
	 * Initialises the window, constructs the three button objects, a new score object
	 * a new hippo object, repaints the frame, and tells the array to initialise and refresh
	 * the locations of the pellets
	 * @throws InterruptedException
	 */
	public Game() throws InterruptedException {
		// Window initialization
		setSize(1024, 768);
		setTitle("Hungry Hungry Hippos!");
		setResizable(false);
		CloseWindow window = new CloseWindow();
		setBackground(Color.blue);
		addWindowListener(window);
		setVisible(true);
		
		// Mouse listener to search for mouse input
		addMouseListener(this);

		
		// Constructors for new "eat" button and "exit" button
		eatButton = new Buttons("Eat!", Color.RED, (512 - BUTTON_WIDTH/2),690, BUTTON_WIDTH, BUTTON_HEIGHT);
		exitButton = new Buttons("Exit", Color.gray, 20, 720, BUTTON_WIDTH / 2, BUTTON_HEIGHT / 2);
		
		// Constructor for the eatZone button that serves to allow the program to check whether or not a pellet is
		// within the area displayed by the button
		eatZone = new Buttons("invisible string", Color.WHITE, 400, 250, 224, 200);
		
		// New score object to display and increment the core
		score = new Score();
		
		// New hippo object that serves as the hippo.
		player = new Hippo((512 - 50), 550, Color.LIGHT_GRAY);
				
		repaint();
		refreshLocations();

	}

	/**
	 * Method that loops through the Pellet array and randomly generates x and y coordinates
	 * for the pellets within the array, as well as determines whether or not to generate a good
	 * or bad pellet.
	 */
	public void assignLocation(){
		for (int i = 0; i < 10; i++){
			isGood = r.nextInt(2);
			pelletX = r.nextInt(1000);
			pelletY = r.nextInt(400);
			// Decides whether next pellet will be UpScore or DownScore
			if (isGood < 1){
				pellets[i] = new UpScore(pelletX, pelletY, Color.WHITE);
			}
			else {
				pellets[i] = new DownScore(pelletX, pelletY, Color.RED);
			}
		}
	}

	/**
	 * Method that loops through the array and sets each object in the array to null.
	 * @param pelletArray specifies which Pellet[] array to loop through
	 */
	public void clearArray(Pellet[] pelletArray){
		for (int i = 0; i < pelletArray.length; i++){
			pelletArray[i] = null;
		}
	}

	/**
	 * Method that controls the timer, clears the array each iteration, assigns random locations
	 * to the various pellets, and sleeps for 1000ms before repeating. After this loop is complete,
	 * the method prints the final score to the console and closes the application.
	 * 
	 * @throws InterruptedException
	 */
	public void refreshLocations() throws InterruptedException{
		// Loop through while timer is not empty
		while (timer > 0){
			clearArray(pellets);
			assignLocation();
			Thread.sleep(1000);
			repaint();
			timer--;
		}
		// Clear all pellets from the screen
		clearArray(pellets);
		// Print final score
		System.out.println("FINAL SCORE:\t" + score.getScore());
		// Exit application
		System.exit(0);
	}
	
	/**
	 * Method that reassigns the long variable recentClick to the current system time
	 * when the method is called
	 */
	public void setRecentClick(){
		 recentClick = System.currentTimeMillis();
	}

	/**
	 * Loops through the array to check whether or not the x and y values of each pellet are within 
	 * the confines of the "eat zone" defined above. If a pellet is found to be within the eat zone,
	 * the method then checks to see whether or not it is an UpScore or DownScore pellet and increments
	 * the score accordingly.
	 * @param myArray defines the array that is passed to the method to check the location of the pellets
	 */
	
	public void isInside(Pellet[] myArray){
		// Loops through the array checking to see if the pellets are in the at zone
		for (int i = 0; i < myArray.length; i++){
			// If the pellet is found within the eatzone, check to see if it's UpScore or DownScore
			if (eatZone.isInside(myArray[i].getX(), myArray[i].getY()) && (myArray[i] != null)){				
				if (pellets[i] instanceof UpScore){
					score.addPoint();
					System.out.println("+1");
					repaint();
				}
				else if(pellets[i] instanceof DownScore) {
					score.subtractPoint();
					System.out.println("-1");
					repaint();
				}
			}
		}
	}

	/**
	 * Paint method that paints the various buttons, hippo, background image,
	 * eat button image, and score to the screen.
	 * @param pane is the Graphics pane that these objects are painted to.
	 */
	public void paint(Graphics pane){
		
		//Paint the background image
		pane.drawImage(background, 0, 0, null);
		
		if (player != null)
			player.paint(pane);

		if (exitButton != null)
			exitButton.paint(pane);

		// Loops through the array and checks if each pellet is or is not
		// null. If not, paints the pellet.
		for (int i = 0; i < pellets.length; i++){			
			if (pellets[i] != null){
				pellets[i].paint(pane);
			}
		}
		
		score.paint(pane);
		pane.drawImage(eat, (512 - BUTTON_WIDTH/2), 690, null);
	}
	/**
	 * mouseClicked method included in the MouseListener interface, not used.
	 */
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * mouseEntered method included in the MouseListener interface, not used.
	 */
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * mouseExited method included in the MouseListener interface, not used.
	 */
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * mousePressed method included in the MouseListener interface. Used to get the x and y coordinates
	 * of the moue when the mouse button is pressed. Also checks whether or not the moue click is within
	 * the buttons, and if it is, flips the appropriate button.
	 */
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		x = e.getX();
		y = e.getY();

		if (eatButton.isInside(x, y)){
			eatButton.flip();
			repaint();
		}
		if (exitButton.isInside(x,y)){
			exitButton.flip();
			repaint();
		}
	}

	/**
	 * mouseReleased method included in the MouseListener interface. Used to handle the actions of the button
	 * as the mouse button is released.
	 */
	public void mouseReleased(MouseEvent e) {

		if (eatButton.isInside(x, y)){
			eat();
			repaint();
		}
		if (exitButton.isInside(x,y)){
			System.exit(0);
		}
	}

	/**
	 * Method that inserts a delay and controls the speed at which the "eat" button can be pressed. If the
	 * button has not been pressed too fast, it performs the function that the eat button should perform,
	 * flipping the button and calling isInside(Pellet[]) on the pellets array. The method then reassigns the value
	 * of the last recent click variable, setRecentClick();
	 */
	public void eat() {
		// Local variable of current system time
		long currentTime = System.currentTimeMillis();
		// If the difference between the last valid click and the current system time is greater than the constant
		// DELAY, then the method performs the defined functions. If not, it prints an error to the console.
		if (currentTime - recentClick > DELAY) {
			eatButton.flip();
			isInside(pellets);
			setRecentClick();
		}
		else{
			System.out.println("## Can't eat that fast! ##");
		}
		repaint();
	}
}

