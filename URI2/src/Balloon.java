import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


public class Balloon {

	/**
	 * We use a Shape so we can check to see if a click is inside the balloon
	 */
	private Ellipse2D.Double balloon;
	
	/**
	 * The width of the unpopped balloon
	 */
	public static int WIDTH = 50;

	/**
	 * location and size of balloon and string
	 */
	private int winHeight, balloonX, balloonY, balloonWidth, 
		balloonHeight, stringX, stringY, stringHeight = 250;

	/**
	 * Sets the balloon at coordinates given
	 * @param x left side
	 * @param y top
	 */
	public Balloon(int x, int y){
		balloonWidth = WIDTH;
		balloonHeight = (int)(1.5 * balloonWidth);
		balloonX = x;
		balloonY = y;
		stringX = balloonX + balloonWidth/2;
		stringY = balloonY + balloonHeight;
		winHeight = y;
		balloon = new Ellipse2D.Double(balloonX, balloonY, 
				balloonWidth, balloonHeight);
	}
	
	/**
	 * checks if coordinates are within the balloon
	 * @param x
	 * @param y
	 * @return true if coordinates are within the balloon
	 */
	public boolean isInside(int x, int y){
		return balloon.contains(x, y);
	}

	/**
	 * Deflates the balloon without moving the string, so sets the location
	 * relative to the string. (If a popped balloon is popped again the
	 * coordinates and size aren't changed.)
	 */
	public void pop(){
		balloonWidth = 10;
		balloonHeight = 15;
		balloonX = stringX -balloonWidth/2;
		balloonY = stringY - balloonHeight;
		balloon = new Ellipse2D.Double(balloonX, balloonY, 
				balloonWidth, balloonHeight);
	}

	/**
	 * Paints a red balloon and string
	 * @param pen
	 */
	public void paint(Graphics pen){

		//We need a Graphics2D to fill the Shape (the balloon itself)
		Graphics2D pane = (Graphics2D)pen;
		pane.setColor(Color.red);
		pane.fill(balloon);

		//Now draw the string
		pane.setColor(Color.black);
		pane.drawLine(stringX, stringY, stringX, stringY + stringHeight);

	}
	
	/**
	 * Moves the balloon up (if speed is negative) or down the given number
	 * of pixels and checks to see if the balloon is still visible
	 * @param speed if negative, the number of pixels up; otherwise the number
	 * of pixels down
	 * @return true if the balloon or string is still visible after being moved
	 */
	public boolean move(int speed){
		boolean isVisible = true;
		
		//first move the balloon
		balloonY += speed;
		
		//We need to replace our balloon with a new one in the new location
		balloon = new Ellipse2D.Double(balloonX, balloonY, 
				balloonWidth, balloonHeight);
		
		//next move the string
		stringY += speed;
		
		//if it's falling and the top of the balloon is below the window
		if(speed > 0 && balloonY >= winHeight)
			isVisible = false;
		//if it's rising and the bottom of the string is above the window
		else if(speed < 0 && (stringY + stringHeight) < 0)
			isVisible = false;
		return isVisible;
	}

}
