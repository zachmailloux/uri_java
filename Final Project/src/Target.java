import java.awt.Color;
import java.awt.Graphics;

/** 
 * @author zacharymailloux
 * Abstract Class Target: This is an abstract class with the methods setVisisble, isVisible, isInside as well as numerous drawing methods. 
 */

public abstract class Target {
	
	public int x;
	public int y;
	public int width = 60;
	public int height = 40;
	public boolean visible;
	protected Color lowColor, highColor;
	/**
	 * The Target constructor takes the parameters randomX and randomY and makes varaibles x and y that the rest of 
	 * the methods in the class will be able to use.
	 * @param randomX
	 * @param randomY
	 */
	public Target(int randomX, int randomY){
	x = randomX;
	y = randomY;		
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
	 * Below are a series of methods that will be filled out by the classes that extend Target.
	 * Not every class that extends Target will have to use each one of the following paint methods.
	 * @param pane
	 */
	public void duckbody(Graphics pane){}
	public void duckwing(Graphics pane){}
	public void eye(Graphics pane){}
	public void beak(Graphics pane){}
	public void fly(Graphics pane){}
	public void splash(Graphics pane){}
	public void bloodsplash(Graphics pane){}
}
