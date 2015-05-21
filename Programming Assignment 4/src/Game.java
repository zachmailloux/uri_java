import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
/*
Author:	Zachary Mailloux

File:	Game.java
*/
public class Game extends Frame implements MouseListener{
	Random random = new Random(); //create random
	private main myWindow; //create a window that you can then later close
	private Button gameButton, clearButton, exitButton; //create them buttons yo
	private int x, y; // to store the location of the click
	public int shiftOne = 0;
	public int shiftTwo = 0;
	Card cardOne, cardTwo;
	Score Score;
	
	
	public Game(){
		setTitle("Aww skeet skeet"); //create a title for window
		setSize(600,400);
		setLocation(150,150);	
		setBackground(Color.GREEN);
		myWindow = new main();//to allow for window closing
		addWindowListener(myWindow);
		addMouseListener(this);
		final int 	BUTTON_WIDTH = 64,
		BUTTON_HEIGHT = 32;//to define the size of our buttons
		gameButton = new Button("Play", Color.cyan, 300, 335, 
				BUTTON_WIDTH, BUTTON_HEIGHT);	
		clearButton = new Button("Clear", Color.red, 400, 335, 
				BUTTON_WIDTH, BUTTON_HEIGHT);
		exitButton = new Button("Exit", Color.orange, 500, 335, 
				BUTTON_WIDTH, BUTTON_HEIGHT);
		
		setVisible(true);
}
	public void paint(Graphics pane){
		pane.clearRect(0, 0, 600, 400);
		gameButton.paint(pane);//show the button
		clearButton.paint(pane);
		exitButton.paint(pane);
		blankcard(pane); //this is the white edge
		blankcardback(pane); //black back of card
		pane.drawLine(300, 275, 300, 245);
		if (cardOne != null){
			cardOne.paint(pane);}
		if (cardTwo != null){
			cardTwo.paint(pane);}
		if (Score != null){
			Score.paintScore(pane);
			Score.backDrop(pane);
			Score.backDropDos(pane);}
		

	}

	
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if(gameButton.isInside(x, y)){
			int typeOne = random.nextInt(4); //suit
			int typeTwo = random.nextInt(4);
			int p1value = random.nextInt(13); //value of card
			int p2value = random.nextInt(13);
			p1value = p1value + 2; //because 0 is not a card number, I wanted a 2 to literally equal a 2 card.
			p2value = p2value + 2;
			cardOne = new Card(p1value, 184, 50, typeOne); //paint the card
			repaint();
			cardTwo = new Card(p2value, 317, 50, typeTwo);
			Score = new Score(p1value, p2value);
			gameButton.flip(); //flip color
			repaint();
		}
		if(clearButton.isInside(x, y)){				
			clearButton.flip();
			cardOne = null; //reset everything
			cardTwo = null; 
			Score.shiftOne = 0;
			Score.shiftTwo = 0;
			Score = null;
			repaint();
		}
		if(exitButton.isInside(x, y)){				
			exitButton.flip();
			System.exit(0); //quit program
			repaint();
		}
		
	}

		
	
	public void mouseReleased(MouseEvent e) {
		if(gameButton.isInside(x, y)){
			gameButton.flip();
			repaint();
		}
		if(clearButton.isInside(x, y)){
			clearButton.flip();
			repaint();
		}
		if(exitButton.isInside(x, y)){
			exitButton.flip();
			repaint();
		}
		
	}	
	public void blankcard(Graphics pane){
	pane.setColor(Color.white);
	pane.fillRoundRect(50, 50, 100, 150, 10, 10);
	pane.fillRoundRect(450, 50, 100, 150, 10, 10);

	}
	public void blankcardback(Graphics pane){
	pane.setColor(Color.black);
	pane.fillRoundRect(52, 52, 96, 146, 10, 10);
	pane.fillRoundRect(452, 52, 96, 146, 10, 10);

	}

	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public static void main(String[] args) 
	{
		new Game();
	}
}
