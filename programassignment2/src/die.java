import java.awt.Color;
import java.awt.Graphics;
import java.lang.Object;
public class die{
	// declare variables
	private int newface, newx, newy;


	
	public die(int face, int x, int y){
	newface = face;	
	newx = x;
	newy = y;
	
	}
	public void paint(Graphics pane){
		// this method is automatically called
		
		if (newface == 1){
			blankdie(pane);
			drawOne(pane);
		}
		if (newface == 2){
			blankdie(pane);
			drawTwo(pane);
		}
		if (newface == 3){
			blankdie(pane);
			drawOne(pane);
			drawTwo(pane);
		}
		if (newface == 4){
			blankdie(pane);
			drawTwo(pane);
			drawFive(pane);
		}
		if (newface == 5){
			blankdie(pane);
			drawOne(pane);
			drawTwo(pane);
			drawFive(pane);
		}
		if (newface == 6){
			blankdie(pane);
			drawTwo(pane);
			drawFive(pane);
			drawSix(pane);
		}
	}
	

	public void blankdie(Graphics pane){
	pane.setColor(Color.black);
	pane.fillRect(newx, newy, 50, 50);
	pane.drawLine(newx, newy, (newx-10), newy - 10); // the top left line
	pane.drawLine((newx + 49), newy, (newx + 39), (newy- 10)); // the top right line
	pane.drawLine(newx, (newy + 49), (newx -10) , (newy + 39)); // the bottom left line
	pane.drawLine((newx - 10), (newy - 10), (newx+39), (newy-10)); 
	pane.drawLine((newx - 10), (newy - 10), (newx-10), (newy + 39));
	}
	public void drawOne(Graphics pane){
		pane.setColor(Color.white);
		pane.fillOval(newx + 20, newy + 20, 10, 10);
	}
	public void drawTwo(Graphics pane){
		pane.setColor(Color.white);
		pane.fillOval(newx + 5, newy + 5, 10, 10);
		pane.fillOval(newx + 35, newy + 35, 10, 10);
	}
	
	public void drawFive(Graphics pane){
		pane.setColor(Color.white);
		pane.fillOval(newx + 35, newy + 5, 10, 10);
		pane.fillOval(newx + 5, newy + 35, 10, 10);
	}
	
	public void drawSix(Graphics pane){
		pane.setColor(Color.white);
		pane.fillOval(newx + 35, newy + 20, 10, 10);
		pane.fillOval(newx + 5, newy + 20, 10, 10);
	}
}





// pane.fillOval(newx, newy, 200, 200);