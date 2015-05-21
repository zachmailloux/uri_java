import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game extends Frame implements MouseListener {
	private int suitUserValue, numberUserValue;
	private int suitComputerValue, numberComputerValue;
	public int score = 0;
	public BarGraph bar;
	public Abutton play;
	int mouseX, mouseY; // to hold location of the clicked area
	Card myCard = new Card(100, 100);
	Card computerCard = new Card(300, 100);


	public Game() {
		setTitle("Let's Play War!"); // We set the characteristics of our
										// drawing
										// window: the location, the size, and
										// the
										// color of the background
		setLocation(50, 50);
		setSize(1000, 1000);
		setBackground(Color.lightGray);
		setUp(); //METHOD FOR MAKING BUTTONS
		setVisible(true); // And we make it appear
		addMouseListener(this); //so that we can listen for clicks
	}

	public void setUp(){
		//Check info, 500 is the xdistance in, 100 is y distance in, 110 is width, 40 is height
		play = new Abutton("Play", Color.white, 500, 100,
				110, 40);	//initializes quit button
		
		bar = new BarGraph((350), (250));
	}
	public void paint(Graphics pane) {
		
		boolean play = false;
		
		if(play==false)
		
		myCard.drawFaceDownCard(pane);
		computerCard.drawFaceDownCard(pane);
		play.paint(pane); //DRAW IT

		
		else if()
		myCard.drawFaceUpCard(pane);
		computerCard.drawFaceUpCard(pane);
		
		
		
		bar.paint(pane, score);
	

	}
	
	public void mouseClicked(MouseEvent e)
	{
		mouseX = e.getX(); //get x
		mouseY = e.getY(); // get y
		
		if(play.isInside(mouseX, mouseY))	// plays game
		{
			play = true;
			System.out.println("Test");
			randomize();
			whoWon();
			
		}
		if(clear.isInside){
			score = 0;
			
		}
		repaint();
	}

	public void randomize() {
		suitUserValue = 1 + (int) (Math.random() * ((4 - 1) + 1));
		numberUserValue = 2 + (int) (Math.random() * ((14 - 2) + 1));
		myCard.setup(suitUserValue, numberUserValue);

		suitComputerValue = 1 + (int) (Math.random() * ((4 - 1) + 1));
		numberComputerValue =  2 + (int) (Math.random() * ((14 - 2) + 1));
		computerCard.setup(suitComputerValue, numberComputerValue);
		//repaint();

	}

	public void whoWon() {
		//This whole setup in wonky
		//What does the suitvalue have anything to do with it?
		//What is they tie
		if (numberUserValue < numberComputerValue) {
			score--;
		} else if (numberUserValue > numberComputerValue) {
			score++;
		} else {
			if (suitUserValue < suitComputerValue) {
				score--;
			} else if (suitUserValue > suitComputerValue) {
				score++;
			} else {
				//idk
			}
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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
