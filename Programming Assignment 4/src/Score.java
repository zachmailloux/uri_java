import java.awt.Color;
import java.awt.Graphics;
import java.lang.Object;
public class Score {
	public static int shiftOne;
	public static int shiftTwo;
	public static int degree = 1; //used for if its a tie.
	public Score(int p1value, int p2value){
		int playerOneCard = p1value; //create a new variable for those  values
		int playerTwoCard = p2value;
		whoWon(playerOneCard, playerTwoCard); //call who won method
	}
	public void whoWon(int playerOneCard, int playerTwoCard){
		if (playerOneCard > playerTwoCard){ //who has larger card.
			if (shiftOne >= shiftTwo){ //who has a larger shift
			shiftOne = shiftOne + (10 * degree); //add to that shift
			degree = 1;
			}
			if (shiftTwo > shiftOne){ //opponent has larger shift, so take away from it
			shiftTwo = shiftTwo - (10 * degree); //subtract
			degree = 1;
			}	
		}
		if (playerTwoCard > playerOneCard){
			if (shiftTwo >= shiftOne){
			shiftTwo = shiftTwo + (10 * degree) ;
			degree = 1;
			}
			if (shiftOne > shiftTwo){
			shiftOne = shiftOne - (10 * degree);
			degree = 1;
			}
		}
		if (playerTwoCard == playerOneCard){
			degree = degree * 2; //this makes it so that in the event of a tie, its degree of change is doubled
		}
		}

	
	public void paintScore(Graphics pane){
		if (shiftOne > shiftTwo){ //whoever has the larger rectangle gets theirs printed
		pane.setColor(Color.blue);
		pane.fillRect(298-(shiftOne), 245, (shiftOne), 30);
		}
		if (shiftOne < shiftTwo){
			pane.setColor(Color.red);
			pane.fillRect(302, 245, (shiftTwo), 30);	
		}
		
		
	}
	// I understand I could have used an array of squares or a for loop of squares.
	// However I spent an ungodly amount of time trying to that with no avail so
	// I literally print green hashes on top of the large rectangle
	public void backDrop(Graphics pane){
		int start = 312;
		int edge = 25;
		for (int i = 0; i<edge; i++){
			pane.setColor(Color.GREEN);
			pane.drawLine(start, 275, start, 245);
			start = start + 10;
		}

		}
	
	public void backDropDos(Graphics pane){
		int startdos = 298;
		int edgedos = 25;
		for (int j = 0; j<edgedos; j++){
			pane.setColor(Color.GREEN);
			pane.drawLine(startdos, 275, startdos, 245);
			startdos = startdos - 10;
		}
	}
}