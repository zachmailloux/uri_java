import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;


public class Ball {

	// instance vars
	private Color theColor;
	private double xVeloc, yVeloc;
	private int forceOfGrav = 1;
	private double elasticity = .9;
	private double size, x, y;
	private boolean collision = false;
	private Shape ball;
	/** Constructor **/
	
	public Ball(int xLeft,int xRight,int yTop, int yBottom){
		size = 20;
		x = (Math.random() * (xRight-xLeft - 20)) + xLeft ;
		y = (Math.random() * (yBottom-yTop - 20)) + yTop ;
		if(Math.random()<.5){
			xVeloc = -10;}
		else{
			xVeloc = 10;
		yVeloc = -10;}
		Random rand = new Random();
		// Java 'Color' class takes 3 floats, from 0 to 1.
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		

		Color randomColor = new Color(r, g, b);
		theColor = randomColor;
		
		ball = new Ellipse2D.Double(x, y, 20, 20);
	}
	/** method fixes out of bounds x and y errors **/
	public void movement(){

		if(!(x>50 && x < 400)){
			if(x<50)
				x = 50;
			else if(x>400){
				x = 400;
			}
			
			xVeloc = xVeloc* (-1);
		}
		if((collision==true)){
			 collision = false;
			//System.out.println("Switched");
			if(xVeloc>0){
				xVeloc=+5;

			}
			else{
				xVeloc-=5;
			}
		//	yVeloc = ((yVeloc* (-1)) + forceOfGrav) * elasticity;
			xVeloc = (xVeloc* (-1));
		}
		x = x + xVeloc;


		if(y  >= 500){
			y = 500;
			yVeloc = ((yVeloc* (-1)) + forceOfGrav) * elasticity;
			y = y + yVeloc;
			if(y>=500){
				y= 500;
			}
		}

		else{
			yVeloc = yVeloc + forceOfGrav;
			y = y + yVeloc;
		}
		ball= new Ellipse2D.Double(x, y, 20, 20);
	}
	public void smash(){
		//System.out.println("Smash!");
		collision= ! collision;
	}
	public boolean smashed(){
		return collision;
	}
	
	public int xloc(){
		return (int) x;
	}
	public int yloc(){
		return (int) y;
	}
	public boolean isInside(int someX, int someY)
	{
		return ball.contains(someX,someY);
	}

	public void paint(Graphics pane){
		Graphics2D pane2 = (Graphics2D)pane;
		pane2.setColor(theColor);
		pane2.fill(ball);
		pane2.draw(ball);
	}



}
