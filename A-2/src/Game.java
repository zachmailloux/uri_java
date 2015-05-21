import java.awt.*;
import java.util.Random;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/** This class implements the game window and its components
 * 
 * @author Cameron Cole
 *
 */
public class Game extends Frame implements MouseListener
{
	//private UneFenetre myWindow;	//handle for window

	private int score = 0, numTie = 0, xSize, ySize, windowX, windowY, mouseX, mouseY, gap = 50;
	//gap signifies space from left side of window to first card
	
	private boolean initializationComplete = false;
	
	public Card faceDownLeft, faceDownRight, faceUpLeft, faceUpRight;
	
	public Abutton quit, reset, play;
	
	public BarGraph bar;
	
	public int getXSize()	//getter for xSize
	{
		return this.xSize;
	}
	
	public int getYSize()	//getter for ySize
	{
		return this.ySize;
	}
	public void game()
	{
		xSize = 700;	//defines size of window
		ySize = 500;
		
		windowX = 50;	//defines location of window
		windowY = 50;
		
		setTitle("Playing mini-war");	// set the title of window
		setLocation(windowX, windowY); // set location to instance variables
		setSize(xSize, ySize);	// size of window
		setBackground(Color.lightGray);	// color of background
				
		setVisible(true);
		
		setup();
	}
	private void setup()
	{				
		
		int bWidth = 110, bHeight = 40;
		
		//myWindow = new UneFenetre(); // allows window closing
		//addWindowListener(myWindow);
		
		faceDownLeft = new Card(50); //first face down card
		faceDownRight = new Card(xSize - 50 - faceDownLeft.getWidth());	//second face down card
		
		quit = new Abutton("Quit", Color.white, xSize - 50 - faceDownLeft.getWidth(), ySize - 155,
				bWidth, bHeight);	//initializes quit button
		
		reset = new Abutton("Reset", Color.white, xSize - 50 - faceDownLeft.getWidth() - gap - bWidth,
				 ySize - 155, bWidth, bHeight);	// initializes reset button
		
		play = new Abutton("Play", Color.white, xSize - 50 - faceDownLeft.getWidth() - (2*gap)
				- (2*bWidth), ySize - 155, 110, bHeight);	//initializes play button
		
		bar = new BarGraph((xSize/2), (ySize/2));	//initializes bar graph

		addMouseListener(this);
		initializationComplete = true;
	}
	
	public void paint(Graphics pane)
	{
		if (initializationComplete == true)	// only paints components if initialized
		{
		faceDownLeft.drawFaceDown(pane);	

		faceDownRight.drawFaceDown(pane);

		quit.paint(pane);	
		
		reset.paint(pane);	
		
		play.paint(pane);
		
		bar.paint(pane, score);

		}
		
		if (faceUpLeft != null && faceUpRight != null)	// only paints if they exist
		{
			faceUpLeft.drawFaceUp(pane);		
			faceUpRight.drawFaceUp(pane);
		}

	}
	
	private void round()
	{		
		Random generator = new Random();	// creates random object to generate value for cards
		int numRank, numSuit;
		
		numRank = generator.nextInt(12);	//first face up card
		numSuit = generator.nextInt(3);
		faceUpLeft = new Card((50 + faceDownLeft.getWidth() + (gap/2)), numRank, numSuit);
		
		numRank = generator.nextInt(12);	//second face up card
		numSuit = generator.nextInt(3);	
		faceUpRight = new Card((xSize - 50 - (2 * faceDownLeft.getWidth()) - gap), numRank, numSuit);

		
		if (faceUpLeft.getRank() > faceUpRight.getRank())
		{

			if (numTie > 0)	// adds score after breaking out of tie
			{
				score = score - (numTie * 2);
				numTie = 0;
			}
			else
				score --;	// else add one score (subtracting is adding score for left side)
			repaint();
		}
			
		else if (faceUpLeft.getRank() < faceUpRight.getRank())
		{
			if (numTie > 0)	// adds score after breaking out of tie
			{
				score = score + (numTie * 2);
				numTie = 0;
			}
			else				
				score++;	//else add one score
			repaint();
			
		}		
		else	
			numTie++;	// adds to tie counter if tie
	}
				
		
	public void mouseClicked(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
		
		if(play.isInside(mouseX, mouseY))	// plays game
		{
			round();
		}
		else if (reset.isInside(mouseX, mouseY))	// resets game
		{
			faceUpLeft = null;
			faceUpRight = null;
			score = 0;
			repaint();
			//bar.reset();
		}
		else if (quit.isInside(mouseX, mouseY))	// quits game
		{
			System.exit(0);
		}
	}

	/**
	 * Pushes the button in
	 */
	public void mousePressed(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		if(quit.isInside(mouseX, mouseY)){
			quit.flip();
			repaint();
		}
		if(reset.isInside(mouseX, mouseY)){
			reset.flip();
			repaint();
		}
		if(play.isInside(mouseX, mouseY)){
			play.flip();
			repaint();
		}
		
	}

	/**
	 * Lets the button pop back out
	 */
	public void mouseReleased(MouseEvent e) {
		if(quit.isInside(mouseX, mouseY)){
			quit.flip();
			repaint();
		}
		if(reset.isInside(mouseX, mouseY)){
			reset.flip();
			repaint();
		}
		if(play.isInside(mouseX, mouseY)){
			play.flip();
			repaint();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
