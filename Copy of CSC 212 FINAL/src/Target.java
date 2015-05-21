import java.awt.Color;
import java.awt.Graphics;

/** 
 * @author zacharymailloux
 * Abstract Class Target: This is an abstract class with the methods setVisisble, isVisible, isInside as well as numerous drawing methods. 
 */

public abstract class Target {
	
	public int x;
	public int y;
	protected int width = 60;
	protected int height = 40;
	public int birdfacing;
	protected boolean flapping;
	public boolean visible;
	/**
	 * The Target constructor takes the parameters randomX and randomY and makes varaibles x and y that the rest of 
	 * the methods in the class will be able to use.
	 * @param randomX
	 * @param randomY
	 */
	public Target(int randomX, int randomY, int facing, boolean isFlapping){
	x = randomX;
	y = randomY;	
	birdfacing = facing;
	flapping = isFlapping;
	}
	/**
	 * My setFlapping method changes the birds variable of flapping to either true or false
	 * @param isFlapping
	 */
	public void setFlapping(boolean isFlapping){
	    flapping = isFlapping;
	}
	public int typeOfDuck(){
		return 2;
		
	}
	/**
	 * The getFlapping method determines whether isFlapping is true or false at that time
	 * @return
	 */
	public boolean getFlapping(){
	    return flapping;
	}
	/**
	 * My setVisible method simply turns the boolean visible variable to true.
	 * @param visible
	 */
	public void setVisible(boolean visible){
		this.visible = visible;
		}
	/**
	 * My isVisisble method checks to see whether the duck is true or false at that time and then returns it 
	 * @return
	 */
	public boolean isVisible(){ //if the duck is visible return true.
		if(visible == true){
		return true;
		}
		else{ //otherwise return false
		return false;
		}
	}
	/**
	 * My isInside method checks to determine whether the x and y from the click method in my Game class is within the 
	 * boundaries of a square around the duck (very close the size of the duck).
	 * @param someX
	 * @param someY
	 * @return
	 */
	public boolean isInside(int someX, int someY)
	{
		return(someX>=x && someX<=(x+width) && someY>=y && someY <=(y+height));	//to determine whether it is inside the bird or not
	}
	public boolean visible(){
			return(false);	
	}

	/**
	 * The duckbody method draws the body of the duck
	 */
	public void duckbody(Graphics pane){
		pane.fillOval(x+7, y+10, 40, 25); //chest
		pane.fillOval(x+37, y+5, 20, 20); //head
		pane.fillOval(x+17, y, 20, 35); // wing
		pane.fillOval(x+2, y+12, 20, 8); //tail
	}
	/**
	 * The duckwing method draws the black backdrop of the wing.
	 */
	public void duckwing(Graphics pane){
		pane.setColor(Color.black);
		pane.fillOval(x+15, y-2, 20, 35); // wing
		pane.drawLine(x+55, y+20, x+68, y+20); //line in the beak
	}
	public void duckbodyflapping(Graphics pane){
		pane.fillOval(x+7, y+10, 40, 25); //chest
		pane.fillOval(x+37, y+5, 20, 20); //head
		pane.fillOval(x+17, y+12, 20, 35); // wing
		pane.fillOval(x+2, y+12, 20, 8); //tail
	}
	public void duckwingflapping(Graphics pane){
		pane.setColor(Color.black);
		pane.fillOval(x+15, y+14, 20, 35); // wing
		pane.drawLine(x+55, y+20, x+68, y+20); //line in the beak
	}
	/**
	 * The eye method draws the eye of the duck
	 */
	public void eye(Graphics pane){
		pane.setColor(Color.black);
		pane.fillOval(x+45, y+9, 5, 5);
	}
	/** The beak method draws the beak of the duck
	 */
	public void beak(Graphics pane){
		pane.setColor(Color.ORANGE);
		pane.fillOval(x+50, y+15, 20, 10); // beak
		pane.fillOval(x+10, y+27, 15, 11); //back foot
		pane.fillOval(x+5, y+27, 11, 15); //back foot
	}

	public void duckbodyLeft(Graphics pane){
		pane.fillOval(x+23, y+10, 40, 25); //chest
		pane.fillOval(x+13, y+5, 20, 20); //head
		pane.fillOval(x+34, y, 20, 35); // wing
		pane.fillOval(x+49, y+12, 20, 8); //tail
	}
	/**
	 * The duckwing method draws the black backdrop of the wing.
	 */
	public void duckwingLeftflapping(Graphics pane){
		pane.setColor(Color.black);
		pane.fillOval(x+36, y+12, 20, 35); // wing
		pane.drawLine(x+3, y+20, x+15, y+20); //line in the beak
	}
	public void duckbodyLeftflapping(Graphics pane){
		pane.fillOval(x+23, y+10, 40, 25); //chest
		pane.fillOval(x+13, y+5, 20, 20); //head
		pane.fillOval(x+34, y+10, 20, 35); // wing
		pane.fillOval(x+49, y+12, 20, 8); //tail
	}
	/**
	 * The duckwing method draws the black backdrop of the wing.
	 */
	public void duckwingLeft(Graphics pane){
		pane.setColor(Color.black);
		pane.fillOval(x+36, y-2, 20, 35); // wing
		pane.drawLine(x+3, y+20, x+15, y+20); //line in the beak
	}
	/**
	 * The eye method draws the eye of the duck
	 */
	public void eyeLeft(Graphics pane){
		pane.setColor(Color.black);
		pane.fillOval(x+18, y+9, 5, 5);
	}
	/** The beak method draws the beak of the duck
	 */
	public void beakLeft(Graphics pane){
		pane.setColor(Color.ORANGE);
		pane.fillOval(x+2, y+15, 20, 10); // beak
		pane.fillOval(x+50, y+27, 15, 11); //back foot
		pane.fillOval(x+55, y+27, 11, 15); //back foot
	}
	public void fly(Graphics pane){
		if((birdfacing == 1)&&(flapping == true)){
			beak(pane);
			duckwing(pane);
			duckbody(pane);
			eye(pane);}
		if((birdfacing == 1)&&(flapping == false)){
			beak(pane);
			duckwingflapping(pane);
			duckbodyflapping(pane);
			eye(pane);}
		if((birdfacing == 0)&&(flapping ==true)){
			beakLeft(pane);
			duckwingLeft(pane);
			duckbodyLeft(pane);
			eyeLeft(pane);}	
		if((birdfacing == 0)&&(flapping ==false)){
			beakLeft(pane);
			duckwingLeftflapping(pane);
			duckbodyLeftflapping(pane);
			eyeLeft(pane);}	
	}
	/**
	 * Below are a series of methods that will be filled out by the classes that extend Target.
	 * Not every class that extends Target will have to use each one of the following paint methods.
	 * @param pane
	 */

	public void splash(Graphics pane){}
	public void bloodsplash(Graphics pane){}
	public void boomsplash(Graphics pane){}
	public void boom(Graphics pane){}
}
