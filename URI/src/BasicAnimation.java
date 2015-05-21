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
 * A balloon that rises, illustrating how a basic animation can be done.
 * This needs to be a Canvas so we can take advantage of the BufferStrategy
 * for double-buffering
 * @author dkm
 *
 */
public class BasicAnimation extends Canvas implements MouseListener{
	
	/**
	 * Allows smooth animation
	 */
	private BufferStrategy buffer;
	
	/**
	 * Controls whether the animation is running or not
	 */
	private boolean running = false;
	
	/**
	 * size of window
	 */
	private int winWidth, winHeight;
	
	
	/**
	 * location and size of balloon and string
	 */
	private int balloonX, balloonY, balloonWidth, 
		balloonHeight, stringX, stringY, stringHeight = 250;
	
	/**
	 * speed of balloon's rising - the larger the number, the faster it
	 * will go
	 */
	private int speed = 10;
	
	/**
	 * Sets up the window and all of its attributes
	 */
	public BasicAnimation(){
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
		//by the rise() method when the animation is running
		setIgnoreRepaint(false);
		
		//sets everything up to be visible
		window.pack();
		window.setResizable(false);
		window.setVisible(true);
		
		//so we can close the window and the program
		//(Note that if you try to close it while the animation is
		//running it won't respond until the balloon has cleared the
		//frame.)
		UneFenetre myWindow = new UneFenetre();
		window.addWindowListener(myWindow);
		
		//to handle mouse clicks
		addMouseListener(this);
		
		//set it once since it never changes
		balloonWidth = 50;
		balloonHeight = (int)(1.5 * balloonWidth);
		balloonX = winWidth/2 - balloonWidth/2;
		stringX = winWidth/2;
		
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
	 * this is where the painting during animation is done
	 */
	private void paintFrame(){
		//This is where the Graphics comes from
		Graphics pane = buffer.getDrawGraphics();
		
		//You have to redraw the background every time
		pane.setColor(Color.lightGray);
		pane.fillRect(0,0,winWidth,winHeight);//To cover up old paint.
		
		//Here's where you do whatever you want...
		pane.setColor(Color.red);
		pane.fillOval(balloonX, balloonY, balloonWidth, balloonHeight);
		
		pane.setColor(Color.black);
		pane.drawLine(stringX, stringY, stringX, stringY + stringHeight);
		
		//Necessary commands for displaying what you've painted
		pane.dispose();	//you don't need the Graphics any more
		buffer.show();	//what you've drawn is in the buffer
	}
	
	/**
	 * Controls the animation.
	 */
	private void rise(){
		//the loop is what makes it an animation
		while(running){

			//First paint the current frame
			paintFrame();
			
			//Don't forget to move whatever you're drawing, or else it will be
			//a dull animation!
			balloonY-=speed;
			stringY-=speed;
			
			//If it's no longer visible, we end the animation
			if(stringY + stringHeight < 0)
				running = false;
							
			//at 50 this is 20 frames per second
			try{
				Thread.sleep(50);	//The bigger the number, the slower it goes.
			}
			catch(InterruptedException e){}
		}
		
		//when the loop ends we want to go back to our other screen
		setIgnoreRepaint(false);
		repaint();
	}
	

	/**
	 * Only works when animation isn't running.  Sets up the balloon
	 * at the bottom and starts the animation.
	 */
	public void mouseClicked(MouseEvent e) {
		if(!running){
			balloonY = winHeight;
			stringY = balloonY + balloonHeight;
			running = true;
			
			//makes sure the only painting is done using the buffer
			setIgnoreRepaint(true);
			
			//starts the animation
			rise();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new BasicAnimation();

	}

}
