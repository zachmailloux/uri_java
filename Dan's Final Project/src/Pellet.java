import java.awt.Color;
import java.awt.Graphics;


public abstract class Pellet {

	/**
	 * Integer values that hold the x and y coordinate of the pellets
	 */
	protected int x, y;
	
	/**
	 * Color object that holds the colour of the Pellet object as defined
	 * in then constructor
	 */
	protected Color color;
	
	/**
	 * Constructor that creates a new Pellet object.
	 * @param xLoc is the x location at which the Pellet should be drawn.
	 * @param yLoc is the y location at which the Pellet should be drawn.
	 * @param someColor is the colour that the Pellet should be.
	 */
	public Pellet(int xLoc, int yLoc, Color someColor) {
		x = xLoc;
		y = yLoc;
		color = someColor;
	}
	
	/**
	 * Method that draws a pellet at the scecified location. Also sets the colour
	 * of the pellet based on what colour was defined in the constructor
	 * @param pane is the Graphics pane that the pellet will be painted to
	 * @param xLoc is the x location at which the pellet will be created.
	 * @param yLoc is the y location at which the pellet will be created.
	 */
	public void drawPellet(Graphics pane, int xLoc, int yLoc){
		pane.setColor(color);
		pane.fillOval(xLoc, yLoc, 20, 20);
	}
	
	/**
	 * Paint method that paints the pellet to the graphics pane
	 * @param pane is the Graphics pane that the pellet will be painted to
	 */
	public void paint(Graphics pane){
		drawPellet(pane, x, y);
	}
	
	/**
	 * Getter method that returns the x value of the pellet.
	 * @return the x value of the pellet.
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * Getter method that returns the x value of the pellet.
	 * @return the x value of the pellet.
	 */
	public int getY(){
		return y;
	}

}

