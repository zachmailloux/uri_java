import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Ball extends Thread {

	/**
	 * We need speed for the ball
	 */
	private double speedX, speedY;

	/**
	 * x and y positions
	 */
	private double x, y;

	/**
	 * to change color
	 */
	private int color = (int) (Math.random()*4)+1;

	/**
	 * Gravity factor
	 */
	private float GRAVITY = 1.5f;

	/**
	 * Bounce factor
	 */
	private float BOUNCE = 1f;

	/**
	 * Diameter of ball
	 */
	private int DIAMETER = 30;

	/**
	 * to paint the ball giving trace effect
	 */
	private int traceFactor = 100000;

	/**
	 * Want to generate a random x,y location, and x,y speed
	 */
	public Ball(){
		x= (Math.random()*300)+160; // random x
		y= (Math.random()*300);		// random y

		speedX= (-10+20*Math.random()); //random x speed
		speedY = (-5+5*Math.random());	//random y speed 
	}

	/**
	 * Were we update the speed, and x y positions
	 */
	public void move(){
		
		speedY = (speedY + GRAVITY); // incorporate gravity

		x = x + speedX; // incorporate speed with location

		y = y + speedY; // incorporate speed with location

		barrier(); // check if ball is out of bounds

	}

	/**
	 * Checks whether ball is in bounds
	 */
	public void barrier(){
		// if it hits right wall
		if(x > BlinkingTimer.LOWERRIGHTRECX - DIAMETER)
			changeSpeedX();		// switch x speed once hit side

		// if it hits left wall
		if(x < (BlinkingTimer.UPPERLEFTRECX) ){ //120
			changeSpeedX();		// switch x speed once hit side
			x = BlinkingTimer.UPPERLEFTRECX;	// force ball in bounds

		}
		// if it hits bottom
		if(y > BlinkingTimer.LOWERRIGHTRECY-DIAMETER){
			changeSpeedY(); // change direction
			y = BlinkingTimer.LOWERRIGHTRECY-DIAMETER; // force ball in bounds
		}
	}

	/**
	 * changes direction of ball
	 */
	public void changeSpeedY()

	{
		speedY = -speedY*BOUNCE;  // change y direction
	}

	/**
	 * changes direction of ball
	 */
	public void changeSpeedX()

	{
		speedX = -speedX*BOUNCE;   // change x direction
	}

	/**
	 * The only "graphical" method of the class is the paint method.
	 */
	public void paint(Graphics pane){
		
		// set scene for background
		pane.setColor(Color.white);
		pane.fillRect(150, 100 , 500, 450);

		// only if we want it to trace
		if(BlinkingTimer.isTrace == true){

			for(int i = 0 ; i<traceFactor ; i++){
				// alternating colors
				if(i % 2 == 0){
					pane.setColor(Color.black); // set the color black
				}
				else{
					pane.setColor(Color.red); // set the color red
				}
				// paints ball
				pane.fillOval((int)x, (int)y, DIAMETER, DIAMETER);
			}
		}

		else{  
			// to alternate color of ball each time its thrown
			if(color == 1)
				pane.setColor(Color.yellow);

			else if (color == 2)
				pane.setColor(Color.blue);

			else if (color == 3)
				pane.setColor(Color.green);

			else if (color == 4)
				pane.setColor(Color.black);

		}
		// paint ball
		pane.fillOval((int)x, (int)y, DIAMETER, DIAMETER);
	}

}
