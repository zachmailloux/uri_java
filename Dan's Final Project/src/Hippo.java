import java.awt.*;


public class Hippo {
	
	// Data Fields
	/**
	 * Integer values to hold the x and y location of the hippo object
	 */
	private int x, y;
	
	/**
	 * Color variable to hold the specified colour of the hippo object.
	 */
	private Color theColor;
	
	/**
	 * Constructor to create a new hippo at given x location, given y location,
	 * and of given colour.
	 * @param xLocation specifies the x location at which the hippo object will be created
	 * @param yLocation specifies the y location at which the hippo object will be created
	 * @param aColor specifies the colour that the hippo object will be
	 */
	public Hippo(int xLocation, int yLocation, Color aColor) {
		
		setup(xLocation, yLocation, aColor);
	}

	/**
	 * Basic method to store the parameters passed through the constructor to the instance 
	 * variables for the hippo object.
	 * @param xLocation the x location at which the hippo object will be created
	 * @param yLocation the y location at which the hippo object will be created
	 * @param aColor specifies the colour that the hippo object will be
	 */
	public void setup(int xLocation, int yLocation, Color aColor) {
		x = xLocation;
		y = yLocation;
		theColor = aColor;
	}
	
	
	/**
	 * Method that draws the basic shape of the hippo
	 * @param pane the graphics pane to which the hippo will be drawn.
	 */
	public void drawHippo(Graphics pane){
		pane.setColor(theColor);
		
		
		pane.fillOval(x-25, y, 100, 100);
		pane.fillOval(x+25, y, 100, 100);
		pane.fillOval(x-50, y+20, 200, 300);
		
		// Two ovals to make up head
		pane.setColor(Color.BLACK);
		pane.drawOval(x-25, y, 100, 100);
		pane.drawOval(x+25, y, 100, 100);
				
		pane.setColor(theColor);
		pane.fillRect(x, y-50, 100, 145);
		
		pane.fillRect(x+25, y-95, 50, 50);
		pane.fillOval(x-10, y-100, 75, 75);
		pane.fillOval(x+35, y-100, 75, 75);
		
		
	}

	/**
	 * Method that draws the eyes onto the hippo
	 * @param pane The Graphics pane to which the hippo will be drawn
	 */
	public void drawEyes(Graphics pane){
		pane.setColor(Color.WHITE);
		pane.fillOval(x+5, y-20, 40, 55);
		pane.fillOval(x+50, y-20, 40, 55);
		
		pane.setColor(Color.BLACK);
		pane.fillOval(x+15, y-20, 20, 27);
		pane.fillOval(x+60, y-20, 20, 27);
	}
	
	/**
	 * Method that draws the nostrils onto the hippo
	 * @param pane The Graphics pane to which the hippo will be drawn
	 */
	public void drawNostrils(Graphics pane){
		pane.setColor(Color.DARK_GRAY);
		pane.fillOval(x+10, y-90, 35, 20);
		pane.fillOval(x+55, y-90, 35, 20);
	}
	
	/**
	 * Paint method that paints the various components of the hippo to the Graphics pane
	 * @param pane The Graphics pane to which the hippo will be drawn
	 */
	public void paint(Graphics pane){
		drawHippo(pane);
		drawEyes(pane);
		drawNostrils(pane);
		}
}
