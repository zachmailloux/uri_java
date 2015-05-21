import java.awt.Color;
import java.awt.event.*;
import java.awt.*;

public class Main extends Frame implements MouseListener, AlarmListener {
	
	private Abutton buttonThrow, buttonFaster, buttonSlower, buttonReset, buttonRemove, buttonPhysics;
	
	private UneFenetre myWindow = new UneFenetre();	//	A handle on the window
	
	private Alarm alarm;			//	Alarm that chills pretty hard
	
	private Ball ball;
	
	private boolean running;
	
	private boolean started = false;
	
	private boolean physics = false;
	
	private String showPhysics = "Off";
	
	private int delay = 55;
	
	private int lastX, lastY;
	
	myCollection collection = new myCollection();   
	
	private final int xLeft = 50, xRight=425, yTop=150, yBottom=525;
	
	
	public Main(){
		
		setTitle("Box O' Balls");	//	We set the characteristics of our
		setLocation(50, 50);				//		drawing window
		setSize(475, 560);
		setBackground(Color.orange);
		setVisible(true);					//		and we make it appear

		addWindowListener(myWindow);		//	To check on the window
		addMouseListener(this);		
		
		int x = 25; int y = 60;					// set initial coords of ball
		
		buttonRemove = new Abutton("Remove", Color.CYAN, x, y);
		x += Abutton.BUTTON_WIDTH * 1.25;
		buttonReset = new Abutton("Reset", Color.red, x, y);
		x += Abutton.BUTTON_WIDTH * 1.25;
		buttonFaster = new Abutton("Faster", Color.green, x, y);
		buttonPhysics = new Abutton("Realistic", Color.pink,x,y+40);
		x += Abutton.BUTTON_WIDTH * 1.25;
		buttonSlower = new Abutton("Slower", Color.yellow, x, y);
		x += Abutton.BUTTON_WIDTH * 1.25;
		buttonThrow = new Abutton("Throw", Color.blue, x, y);
		
		alarm= null;//new Alarm(this);
		running = false;
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
		else if (buttonPhysics.isInside(lastX, lastY)) {
			physics =! physics;
			if(physics == true){
				showPhysics = "On";
			}
			else{
				showPhysics = "Off";
			}
		}
		
		
		else  {
			System.out.println("Invalid Action");
		}

		repaint();
	}
	
	/**notices if ball is moving and calls appropriate method
	 */
	public void takeNotice(){
		if(collection!=null){
		collection.movement();
		}
		if(physics ==true){
		collection.collisionCheck();
		}
		repaint();
	}
	/** paints the ball and starts the timer to have it run **/
	public void startThrow()
	{	
		if(alarm==null){
		collection= new myCollection();
		alarm = new Alarm(this);
		delay=55;
		alarm.setPeriod(delay);	
		alarm.setRunning(running);//allows alarm to run
		alarm.start();
		}
		ball = new Ball(xLeft,xRight,yTop,yBottom);
		collection.add(ball);
			running = true;	

	}
	
	/** method to speed up ball **/
	
	public void faster()
	{
		if(alarm != null){
			delay = delay - 4;
			if(delay >= 0)
			alarm.setPeriod(delay);
			}
	}
	
	/** method to slow down ball **/
	
	public void slower()
	{
		if(alarm != null){
		delay = delay + 4;
		alarm.setPeriod(delay);
		}
	}
	
	/** resets ball and resets the alarm/timer **/
	
	public void clearAction()
	{
		running = false;
		delay=55;
		alarm.setPeriod(delay);
		collection = null;
		alarm = null;
	}
	
	public void removeAction(){
		collection.remove();
	}
	
	public void paint(Graphics pane){
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
		pane.drawLine(xRight,yBottom,xRight,yTop);		// sets up walls for ball box
		pane.drawLine(xLeft,yBottom,xRight,yBottom);    
		pane.drawLine(xLeft,yTop,xLeft,yBottom);
		pane.drawString("Advanced Physics: "+ showPhysics, 300, 125);
		if(collection!=null){
		pane.drawString("Balls on the court: "+ Integer.toString(collection.getAmount()-1), 50, 125);
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

		repaint();
	}


}
