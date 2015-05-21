import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

/**
 * A balloon that can be popped, illustrating animation that can be affected
 * by user interaction.
 * This demonstrates the use of a thread (the Alarm) that
 * handles the moving and painting of the object (in this case a balloon). We
 * need a dedicated thread so our main thread can be responsive to 
 * mouse clicks.  If we used our main thread for animation it would be spending
 * all of its time sleeping and moving and would not be responsive to the mouse.
 * @author dkm
 *
 */
public class InteractiveAnimation extends Canvas implements MouseListener,
	AlarmListener{
	
	/**
	 * Allows smooth animation
	 */
	private BufferStrategy buffer;
	
	/**
	 * Controls whether the animation is running or not
	 */
	private boolean running = false, nextTime = false;
	
	/**
	 * The thread that moves the balloon
	 */
	private Alarm clock;
	
	/**
	 * The balloon itself
	 */
	private Balloon balloon;
	
	/**
	 * size of window
	 */
	private int winWidth, winHeight;
	
	/**
	 * speed of balloon's rising - when negative will rise, when positive
	 * will fall
	 */
	private int speed = -10;
	
	/**
	 * Sets up the window and all of its attributes
	 */
	public InteractiveAnimation(){
		//we can have a Frame without being a Frame!
		Frame window = new Frame("Balloon");
		
		//setting the size and location of the window based on the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		winWidth = (int)(screenSize.width * .9);
		winHeight = (int)(screenSize.height * .9);
		window.setPreferredSize(new Dimension(winWidth, winHeight));
		int winX = (screenSize.width - winWidth)/2;
		int winY = (screenSize.height - winHeight)/2;
		window.setLocation(winX, winY);
		
		//makes sure the canvas fills the Frame
		setBounds(0,0,winWidth, winHeight);
		
		//makes our Canvas the component held in the Frame
		window.add(this);
		
		//starts out painting normally - painting will be taken over
		//by the takeNotice() method when the animation is running
		setIgnoreRepaint(false);
		
		//sets everything up to be visible
		window.pack();
		window.setResizable(false);
		window.setVisible(true);
		
		//so we can close the window and the program
		UneFenetre myWindow = new UneFenetre();
		window.addWindowListener(myWindow);
		
		//to handle mouse clicks
		addMouseListener(this);
		
		//To make the balloon rise (or fall)
		clock = new Alarm(this);
		clock.setPeriod(50);//20 frames per second
		clock.start();
		
		//necessary for double-buffering
		createBufferStrategy(2);	
		buffer = getBufferStrategy();
	}
	
	/**
	 * only appears when the animation isn't running
	 */
	public void paint(Graphics pane){
		String label = "Click to start balloon";
		int labelWidth = pane.getFontMetrics().stringWidth(label);
		int labelHeight = pane.getFontMetrics().getAscent();
		pane.drawString(label,
						(winWidth - labelWidth)/2,
						(winHeight - labelHeight)/2);
	}
	
	/**
	 * This is where the painting for the animation is done
	 */
	private void paintFrame(){
		Graphics pane = buffer.getDrawGraphics();
		
		//You have to redraw the background every time
		pane.setColor(Color.lightGray);
		pane.fillRect(0,0,winWidth,winHeight);//To cover up old paint.
		
		//now paint the balloon
		balloon.paint(pane);
		
		//Necessary commands for showing what you've just drawn
		pane.dispose();	//you don't need the Graphics any more
		buffer.show();	//what you've drawn is in the buffer
	}
	
	/**
	 * The animation is now controlled by the clock, so we don't have a rise()
	 * method with a loop. The movement occurs within takeNotice(), as
	 * long as the animation is actually running.
	 * 
	 * Note that the Alarm calls this method 20 times a second, which is
	 * why we don't need a loop.
	 */
	public void takeNotice() {
		//Only paint the balloon if the animation is running and balloon is visible
		if(running && !nextTime){
			//First, paint the balloon
			paintFrame();
			
			//this both moves the balloon and checks to see if it's out of
			//the frame
			if(!balloon.move(speed)){
				nextTime = true;//if it's out of the frame, the next time we reset
			}
		}
		//When it moves out of the frame, we need to stop the animation
		else if(nextTime){
			//These reset it to show the initial screen
			nextTime = false;
			running = false;
			setIgnoreRepaint(false);
			repaint();
		}
			
		
	}

	/**
	 * Starts the balloon if it's on reset screen
	 */
	public void mouseClicked(MouseEvent e) {
		if(!running){
			setIgnoreRepaint(true);//painting is taken over by animation
			
			//start the balloon at the bottom
			balloon = new Balloon(winWidth/2-Balloon.WIDTH/2, winHeight);
			speed = -10;//balloon is rising
			running = true;//takeNotice() will now execute
		}		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Pops the balloon if clicked inside (more responsive than mouseClicked())
	 */
	public void mousePressed(MouseEvent e) {
		if(running){
			int x = e.getX();
			int y = e.getY();
			if(balloon.isInside(x, y)){
				balloon.pop();
				speed = 10;//make it fall instead of rise
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new InteractiveAnimation();
	}

}
