import java.awt.Color;
import java.awt.Graphics;
import java.lang.Object;
public class Card {

	private int newfacevalue, newx, newy, newsuit;


	
	public Card(int facevalue, int x, int y, int suit){
	newfacevalue = facevalue; 	
	newx = x;
	newy = y;
	newsuit = suit;
	}
	public void paint(Graphics pane){
		// this method is automatically called
		cardBack(pane);
		blankCard(pane);
		
		//Here the if suit loops are to determine what color the number should be printed in
		if (newfacevalue < 11){ //this is for the first cards between 2-10.
			if(newsuit == 0 || newsuit == 1){
				pane.setColor(Color.red);
				String stringValue = Integer.toString(newfacevalue);
				pane.drawString(stringValue, newx + 10, newy +15);	
			}
			if(newsuit == 2 || newsuit == 3){
				pane.setColor(Color.black);
				String stringValue = Integer.toString(newfacevalue);
				pane.drawString(stringValue, newx + 10, newy +15);	
			}
		}
		// After the 10 card I chose to manually determine is printed card.
		
		if (newfacevalue == 11){
			if(newsuit == 0 || newsuit == 1){
				pane.setColor(Color.red);
				pane.drawString("J", newx + 10, newy +15);	
			}
			if(newsuit == 2 || newsuit == 3){
				pane.setColor(Color.black);
				pane.drawString("J", newx + 10, newy +15);	
			}
		}
		if (newfacevalue == 12){
			if(newsuit == 0 || newsuit == 1){
				pane.setColor(Color.red);
				pane.drawString("Q", newx + 10, newy +15);	
			}
			if(newsuit == 2 || newsuit == 3){
				pane.setColor(Color.black);
				pane.drawString("Q", newx + 10, newy +15);	
					}
		}
		if (newfacevalue == 13){
			if(newsuit == 0 || newsuit == 1){
				pane.setColor(Color.red);
				pane.drawString("K", newx + 10, newy +15);	
			}
			if(newsuit == 2 || newsuit == 3){
				pane.setColor(Color.black);
				pane.drawString("K", newx + 10, newy +15);	
					}
		}
		if (newfacevalue == 14){
			if(newsuit == 0 || newsuit == 1){
				pane.setColor(Color.red);
				pane.drawString("A", newx + 10, newy +15);	
			}
			if(newsuit == 2 || newsuit == 3){
				pane.setColor(Color.black);
				pane.drawString("A", newx + 10, newy +15);	
					}
		}	
	//Here I choose what suit will be printed
	if (newsuit == 0){
		hearts(pane);
	}
	if (newsuit == 1){
		diamonds(pane);
	}
	if (newsuit == 2){
		clovers(pane);
	}
	if (newsuit == 3){
		clubs(pane);
	}	
	}

	public void hearts(Graphics pane){
		pane.setColor(Color.red);
		int xPoints[] = {newx+30, newx+50, newx+70};
		int yPoints[] = {newy+75, newy+95, newy+75};
		pane.fillPolygon(xPoints, yPoints, 3);
		pane.fillOval(newx + 28, newy + 60, 22, 20);
		pane.fillOval(newx + 48, newy + 60, 22, 20);
	}
	public void diamonds(Graphics pane){
		pane.setColor(Color.red);
		int xPoints[] = {newx+30, newx+50, newx+70};
		int yPoints[] = {newy+75, newy+95, newy+75};
		int xPointsdos[] = {newx+30, newx+50, newx+70};
		int yPointsdos[] = {newy+75, newy+55, newy+75};
		pane.fillPolygon(xPoints, yPoints, 3);
		pane.fillPolygon(xPointsdos, yPointsdos, 3);
		}
	public void clovers(Graphics pane){
		pane.setColor(Color.black);
		pane.fillRect(newx+45, newy+75, 10, 20);
		pane.fillOval(newx + 28, newy + 70, 22, 20);
		pane.fillOval(newx + 48, newy + 70, 22, 20);
		pane.fillOval(newx + 38, newy + 55, 22, 20);
	}
	public void clubs(Graphics pane){
		pane.setColor(Color.black);
		pane.fillRect(newx+44, newy+75, 10, 20);
		pane.fillOval(newx + 28, newy + 70, 22, 20);
		pane.fillOval(newx + 48, newy + 70, 22, 20);
		int xPointsdos[] = {newx+30, newx+50, newx+70};
		int yPointsdos[] = {newy+75, newy+55, newy+75};
		pane.fillPolygon(xPointsdos, yPointsdos, 3);
	}
	public void blankCard(Graphics pane){
	pane.setColor(Color.white);
	pane.fillRoundRect(newx+2, newy+2, 96, 146, 10, 10);

	}
	public void cardBack(Graphics pane){
		pane.setColor(Color.black);
		pane.fillRoundRect(newx, newy, 100, 150, 10, 10);
	}
}
