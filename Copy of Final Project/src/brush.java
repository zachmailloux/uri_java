import java.awt.Color;
import java.awt.Graphics;
/**
 * The Brush class is used to draw the bushes that the ducks seemingly pop out of. 
 * I create an array of brush in my game class where it goes through and draws 
 * each blade of grass
 */

public class brush {
	public int x, y, width, height, arcOne, arcTwo;

	public brush(int xcoord, int ycoord, int enterwidth, int enterheight, int arc1, int arc2){
		x = xcoord;
		y = ycoord;
		width = enterwidth;
		height = enterheight;
		arcOne = arc1; //the give the grass its shape
		arcTwo = arc2; 
	}
	public void drawing(Graphics pane){
		Color darkGreen = new Color(100,200,100);
		pane.setColor(darkGreen);
		pane.fillArc(x, y, width, height, arcOne,arcTwo);
	}
	public void drawbrush(Graphics pane){
		drawing(pane);
	}
}
