import java.awt.*;
import java.util.Random;

/**	This class implements the Card class to create the face down and face up cards on the game board.
 * 
 * @author Cameron Cole
 *
 */
public class Card
{
	
	private String[] rankArray ={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	// array for strings of rank
	
	private int x, rank, suit;
	private final int WIDTH = 110, HEIGHT = 155, Y = 50; 
	private int circSide = 18, sideLength = 30, half = sideLength/2;	//variables for drawing suits
	// y represents distance from top of window to top of card level
	
	public Card(int x, int rank, int suit)	//constructor for face up card
	{
		this.x = x;
		this.rank = rank;
		this.suit = suit;
	}	
	
	public Card(int x)	//constructor for face down card
	{
		this.x = x;	
	}
	
	
	public int getWidth()	//getter for width
	{
		return this.WIDTH;
	}
	
	public int getRank()	//getter for rank
	{
		return this.rank;
	}
	
	private void drawBlank(Graphics pane)
	{
		pane.setColor(Color.white);
		pane.fillRoundRect(x, Y, WIDTH, HEIGHT, 20, 20);
		pane.setColor(Color.black);
		pane.drawRoundRect(x, Y, WIDTH, HEIGHT, 20, 20);
	}
	
	public void drawFaceUp(Graphics pane)
	{
		drawBlank(pane);

		//String myRank = "Q";		
		//myRank.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
		
		pane.setColor(Color.black);
		pane.drawString(rankArray[rank], x + 10, Y+ 15);
		
		if (suit == 0)		//if statement to draw suit
			drawClub(pane);
		else if (suit == 1)
			drawSpade(pane);
		else if (suit == 2)
			drawHeart(pane);
		else
			drawDiamond(pane);
	}
	
	public void drawFaceDown(Graphics pane)	//method to draw face down card
	{
		int cSide = 40;
		
		drawBlank(pane);
		
		pane.setColor(Color.black);
		pane.fillRoundRect(x + 3, Y + 3, WIDTH - 5, HEIGHT - 5, 20, 20);	//creates black area of face down card
		
		pane.setColor(Color.green);
		pane.drawOval((WIDTH/2) + x - (cSide/2), (HEIGHT/2) + Y - (cSide/2) - cSide, cSide, cSide);
		// creates top circle by copying the middle one and subtracting circSide from height
		
		pane.setColor(Color.red);
		//pane.drawLine((width/2) + x,(height/2) + 50,(width/2)+x,(height/2) + 50);
		pane.drawOval((WIDTH/2) + x - (cSide/2), (HEIGHT/2) + Y - (cSide/2), cSide, cSide);	
		// creates middle circle on back of card
		
		pane.setColor(Color.blue);
		pane.drawOval((WIDTH/2) + x - (cSide/2), (HEIGHT/2) + Y - (cSide/2) + cSide, cSide, cSide);
		// creates bottom circle by copying the middle one and adding circSide to height
	}
	
	private void drawClub(Graphics pane)
	{
		pane.setColor(Color.black); //color of club
		
		int circSideClub = 18;	//needs different size than instance circSide
		
		int[] xPoints ={x + (WIDTH/2) + half - 5, x + (WIDTH/2), x + (WIDTH/2) - half + 5};
		int[] yPoints ={Y + (HEIGHT/2) + half, Y + (HEIGHT/2) - 10, Y + (HEIGHT/2)+ half}; 
		//y points of triangle
		pane.fillPolygon(xPoints, yPoints, 3);	//bottom triangle
		
		pane.fillOval(x + (WIDTH/2), Y + (HEIGHT/2) - half, circSideClub, circSideClub); //first circle
		pane.fillOval(x + (WIDTH/2) - circSideClub, Y + (HEIGHT/2) - half, circSideClub, circSideClub); //second circle
		pane.fillOval(x + (WIDTH/2) - (circSideClub/2), Y + (HEIGHT/2) - circSideClub - 7, circSideClub, circSideClub); //third circle
		
	}
	
	private void drawSpade(Graphics pane)
	{
		pane.setColor(Color.black);
		
		int cSideSpade = 18; //needs different size than instance circSide
		
		int[] xPointsBot ={x + (WIDTH/2) + half - 5, x + (WIDTH/2), x + (WIDTH/2) - half + 5};
		int[] yPointsBot ={Y + (HEIGHT/2) + half, Y + (HEIGHT/2) - 10, Y + (HEIGHT/2)+ half}; 
		//y points of triangle
		pane.fillPolygon(xPointsBot, yPointsBot, 3);	//bottom triangle
		
		pane.fillOval(x + (WIDTH/2), Y + (HEIGHT/2) - half, cSideSpade, cSideSpade); //first circle
		pane.fillOval(x + (WIDTH/2) - cSideSpade, Y + (HEIGHT/2) - half, cSideSpade, cSideSpade); //second circle
		
		int[] xPointsTop ={x + (WIDTH/2) - cSideSpade + 1, x + (WIDTH/2) + cSideSpade - 1, x + (WIDTH/2)};
		int[] yPointsTop ={Y + (HEIGHT/2), Y + (HEIGHT/2), Y + (HEIGHT/2) - sideLength};
		
		pane.fillPolygon(xPointsTop, yPointsTop, 3);
		}
	
	private void drawHeart(Graphics pane)
	{
		pane.setColor(Color.red);	//color of heart
		
		int[] xPoints ={x + (WIDTH/2) + half, x + (WIDTH/2), x + (WIDTH/2) - half};	//x points of triangle
		int[] yPoints ={Y + (HEIGHT/2), Y + (HEIGHT/2) + half + 10, Y + (HEIGHT/2)};//y points of triangle
		
		pane.fillPolygon(xPoints, yPoints, 3);	//creates triangle part of the heart
		
		pane.fillOval(x + (WIDTH/2) - half - (circSide/8), Y + (HEIGHT/2) - (circSide/2), circSide, circSide);
		pane.fillOval(x + (WIDTH/2) - (circSide/8), Y + (HEIGHT/2) - (circSide/2), circSide, circSide);

	}
	
	private void drawDiamond(Graphics pane)
	{
		pane.setColor(Color.red);	//color of diamond
		
		int[] xPoints ={x + (WIDTH/2) + half, x + (WIDTH/2), x + (WIDTH/2) - half};		//x points
		int[] yPointsTop ={Y + (HEIGHT/2), Y + (HEIGHT/2) - sideLength, Y + (HEIGHT/2)};//y points for top
		
		pane.fillPolygon(xPoints, yPointsTop, 3);	// use fillPolygon to create top triangle
		
		int[] yPointsBot ={Y + (HEIGHT/2), Y + (HEIGHT/2) + sideLength, Y + (HEIGHT/2)};	//y points for bottom
		
		pane.fillPolygon(xPoints, yPointsBot, 3);	//creates bottom half of diamond
	}
}
