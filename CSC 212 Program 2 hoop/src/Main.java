import java.awt.Color;
import java.awt.event.*;
import java.awt.*;

/*
 * Author: Zachary Mailloux October 1st
 * Shout outs: Mom & Dad, my friend Dan, James for being cool, and my dog Coda
 * 
 */

public class Main extends Frame implements MouseListener, AlarmListener {
	
	private Abutton buttonThrow, buttonFaster, buttonSlower, buttonReset, buttonRemove, buttonPhysics, buttonHoop;
	
	private UneFenetre myWindow = new UneFenetre();	//	A handle on the window
	
	private Alarm alarm;			//	Alarm that does all of the work
	
	private Ball ball; //the temp ball that we add to our collection
	
	private boolean running; //to determine whether we are running or not
	
	private boolean physics = false; //if we apply physics to our engine
	
	private boolean hoop = false; //if we add the hoop to our engine
	
	private String showPhysics = "Off"; //to physically display whether we have physics on.
	
	private int delay = 55; //controls the frequency in which the balls move.
	
	private int lastX, lastY;
	
	myCollection collection = new myCollection(); //the collection that we use to hold our balls lulz
	
	private final int xLeft = 50, xRight=425, yTop=150, yBottom=525;
	
	
	public Main(){
		
		setTitle("Box O' Balls");	//	We set the characteristics of our
		setLocation(50, 50);				//		drawing window
		setSize(485, 575);
		setBackground(Color.cyan);
		setVisible(true);					//		and we make it appear

		addWindowListener(myWindow);		//	To check on the window
		addMouseListener(this);		
		
		int x = 25; int y = 60;					// set initial coords of ball
		
		buttonRemove = new Abutton("Remove", Color.MAGENTA, x, y);//add all of the buttons
		x += Abutton.BUTTON_WIDTH * 1.25;
		buttonReset = new Abutton("Reset", Color.red, x, y);
		x += Abutton.BUTTON_WIDTH * 1.25;
		buttonFaster = new Abutton("Faster", Color.green, x, y);
		buttonPhysics = new Abutton("Realistic", Color.pink,x-45,y+40);
		buttonHoop = new Abutton("Basketball", Color.gray,x+45,y+40);
		x += Abutton.BUTTON_WIDTH * 1.25;
		buttonSlower = new Abutton("Slower", Color.yellow, x, y);
		x += Abutton.BUTTON_WIDTH * 1.25;
		buttonThrow = new Abutton("Throw", Color.blue, x, y);
		collection = null;
		alarm= null;//set alarm = null
		running = false; //not running
	}
	
	private void check()
	{

		if (buttonThrow.isInside(lastX, lastY)) {
			startThrow();
		}

		else if (buttonFaster.isInside(lastX, lastY)) {
			faster();
		}

		else if (buttonSlower.isInside(lastX, lastY)) {
			slower();
		}

		else if (buttonReset.isInside(lastX, lastY)) {
			clearAction();
		}
		
		else if (buttonRemove.isInside(lastX, lastY)) {
			removeAction();
		}
		else if (buttonHoop.isInside(lastX, lastY)) {
			hoop =! hoop; //change hoop to true/false
			collection.setScore(0); //reset score
		}
		else if (buttonPhysics.isInside(lastX, lastY)) {
			physics =! physics; //change physics to true/false
			if(physics == true){ 
				showPhysics = "On";}//display
			else{
				showPhysics = "Off";}//display
		}
		else  {
			System.out.println("Invalid Action");
		}
		repaint();
	}
	
	/**notices if ball is moving and calls appropriate method
	 */
	public void takeNotice(){
		if(collection!=null){//if there are balls
		collection.movement();//make them move
		if(hoop==true){//if theres a hoop
		collection.hoopcheck();}//make the collection class run hoopcheck
		}
		if(physics ==true){//if physics is on
		collection.collisionCheck();//make the collection class check for collisions
		}
		repaint();
	}
	/** paints the ball and starts the timer to have it run **/
	public void startThrow()
	{	
		if(alarm==null){//if there is no alarm (if we're starting fresh)
		collection= new myCollection();//make a new instance of the collection class
		alarm = new Alarm(this);//make a new alarm
		delay=55;//set delay
		alarm.setPeriod(delay);	
		alarm.start();//START OUR ALARM!!!
		}
		ball = new Ball(xLeft,xRight,yTop,yBottom);//new ball with semi random coordinates
		collection.add(ball);//add the ball to our collection
			running = true;	//set running = true

	}
	
	/** method to speed up ball **/
	
	public void faster()
	{
		if((alarm != null)&&(delay>4)){ //if theres an alarm
			delay = delay - 4; //reduce the time between the alarm check
			alarm.setPeriod(delay);//set
			}
	}
	
	/** method to slow down ball **/
	
	public void slower()
	{
		if(alarm != null){//if theres an alarm
		delay = delay + 4; //add to the time between alarm check
		alarm.setPeriod(delay); //set
		}
	}
	
	/** resets ball and resets the alarm/timer **/
	
	public void clearAction()
	{
		if(alarm!=null){
		running = false; //stop running
		alarm.setRunning(running); //let the alarm know we are no longer running
		collection = null; //kill the collection
		alarm = null; //kill the alarm
		}
	}
	
	public void removeAction(){
		if(collection!=null){ //if the collection exists
		collection.remove();} //call the remove method which takes a ball off the end of the the array
	}
	
	public void paint(Graphics pane){ //paint dem buttons
		if(buttonThrow != null)
			buttonThrow.paint(pane);
		if(buttonFaster != null)
			buttonFaster.paint(pane);
		if(buttonSlower != null)
			buttonSlower.paint(pane);
		if(buttonReset != null)
			buttonReset.paint(pane);
		if(buttonRemove != null)
			buttonRemove.paint(pane);
		if(buttonPhysics != null)
			buttonPhysics.paint(pane);
		if(buttonHoop != null)
			buttonHoop.paint(pane);
		pane.drawLine(xRight,yBottom,xRight,yTop);		// sets up walls for ball box
		pane.drawLine(xLeft,yBottom,xRight,yBottom);    
		pane.drawLine(xLeft,yTop,xLeft,yBottom);
		pane.drawString("Advanced Physics: "+ showPhysics, 330, 125); //so the user knows if the bouncing is on
		if(hoop==true&&collection!=null){ //if the hoop is true and there is a collection
		pane.drawString("Player 1: "+ collection.getScore1(), 100, 190); //print the score
		pane.drawString("Player 2: "+ collection.getScore2(), 310, 190); //print the score
		pane.fillRect(xLeft-5, yBottom-175, 10, 176); //Left pole
		pane.fillRect(xRight-5, yBottom-175, 10, 176); //Right pole
		pane.setColor(Color.white);
		pane.fillRect(xLeft+2, yBottom-175, 10, 80);//left backboard
		pane.fillRect(xRight-12, yBottom-175, 10, 80);// right backboard
		pane.setColor(Color.orange);
		pane.fillRect(xLeft+12, yBottom-110, 40, 6); // left basket
		pane.fillRect(xRight-52, yBottom-110, 40, 6); // right basket //right 425
		}
		if(collection!=null){ //if theres a collection
		pane.setColor(Color.black);
		pane.drawString("Balls on the court: "+ Integer.toString(collection.getAmount()-1), 20, 125); //print number of balls
		pane.drawString("Ball Speed: "+ delay, 200, 45); //just so you know the speed
		collection.paint(pane);}
	
	}
	

	public void mouseClicked(MouseEvent event)
	{
		check();								//	Handle the mouse click
	}

	public void mousePressed(MouseEvent event)
	{
		lastX = event.getX();					//	Update the mouse location
		lastY = event.getY();

		flipWhenInside();						//	Flip any button hit by the mouse
	}

	public void mouseReleased(MouseEvent event)
	{
		flipWhenInside();
	}

	public void mouseEntered(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}

	private void flipWhenInside()
	{
		if (buttonThrow.isInside(lastX, lastY))
			buttonThrow.flip();
		else if (buttonSlower.isInside(lastX, lastY))
			buttonSlower.flip();
		else if (buttonFaster.isInside(lastX, lastY))
			buttonFaster.flip();
		else if (buttonReset.isInside(lastX,  lastY))
			buttonReset.flip();
		else if (buttonRemove.isInside(lastX,  lastY))
			buttonRemove.flip();
		else if (buttonPhysics.isInside(lastX,  lastY))
			buttonPhysics.flip();
		else if (buttonHoop.isInside(lastX,  lastY))
			buttonHoop.flip();
		repaint();
	}


}
