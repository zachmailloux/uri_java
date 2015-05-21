import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;


public class Ball {

	// instance vars
	private Color theColor; //color
	private double xVeloc, yVeloc; //their velocity
	private int forceOfGrav = 1; //current value of gravity
	private double elasticity = .9; //bounce
	private double size, x, y; 
	private boolean collision = false; //for collision purposes
	private boolean falling = false;
	private Shape ball; //using balls not ovals
	/** Constructor **/

	public Ball(int xLeft,int xRight,int yTop, int yBottom){
		size = 20; //thickness
		x = (Math.random() * (xRight-xLeft - 20)) + xLeft ;
		y = (Math.random() * (yBottom-yTop - 20)) + yTop ;
		if(Math.random()<.5){
			xVeloc = -10;} //random left down
		else{
			xVeloc = 10; //random right
			yVeloc = -10;} //going up
		Random rand = new Random();//for random color purposes
		// Java 'Color' class takes 3 floats, from 0 to 1.
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();


		Color randomColor = new Color(r, g, b);
		theColor = randomColor;

		ball = new Ellipse2D.Double(x, y, 20, 20); //new ball made with those x and y values
	}
	/** method fixes out of bounds x and y errors **/
	public void movement(){

		if(!(x>50 && x < 400)){ //if it hits the edges
			if(x<50)
				x = 50; //stop it
			else if(x>400){
				x = 400; //stop it
			}
			xVeloc = xVeloc* (-1); //make it bounce
		}
		if((collision==true)){ //if it collided with another ball
			collision = false; //set collision = false so that it may hit another ball
			xVeloc = (xVeloc* (-1)); //make it repel
		}
		

		if(y  >= 500){ //if it hits bottom
			y = 500; //stop it
			yVeloc = ((yVeloc* (-1)) + forceOfGrav) * elasticity; //make it go up with respect to gravity
			y = y + yVeloc; //moves the ball
		}

		else{
			yVeloc = yVeloc + forceOfGrav; //make it fall (faster)
			y = y + yVeloc; //literally make it go down
		}
		x = x + xVeloc; 
		ball= new Ellipse2D.Double(x, y, 20, 20); //create a new ball for that new placement
	}
	public void smash(){
		collision= ! collision; //set collision to either true/false
	}
	public void swoosh(){
		y=y+20; //after touching the net the ball is show down to avoid the score being counted multiple times
	}
	public boolean smashed(){
		return collision; //returns if a collision has occurred 
	}

	public int xloc(){
		return (int) x; //x location
	}
	
	public int yloc(){
		return (int) y; //y location
	}
	
	public boolean isFalling(){ //the is falling method is used to determine weather or not the ball can go in the hoop
		if(yVeloc>=0){
			falling = true;
		}
		else{
			falling = false;
		}
		return falling;
	}
	
	public boolean isInside(int someX, int someY)//the method checks to see if x and y coordinates are within the current ball
	{
		return ball.contains(someX+5,someY+5);//the +5 is so that it doesn't base it off the top left corner and checks the middle-ish area.
	}

	public void paint(Graphics pane){
		Graphics2D pane2 = (Graphics2D)pane;
		pane2.setColor(theColor);
		pane2.fill(ball);
		pane2.draw(ball);
	}



}
