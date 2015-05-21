import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Illustrates how to use more than one panel within a Frame.  This includes
 * both using LayoutManagers and how to communicate between the two panels.
 * @author dkm
 *
 */
public class LayoutDemo extends Frame {

	public LayoutDemo(){
		setTitle("Layout Demo");
		//setting the size and location of the window based on the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension bounds = new Dimension((int)(screenSize.width * .9), 
				(int)(screenSize.height * .9));
		setPreferredSize(bounds);
		int winX = (screenSize.width - bounds.width)/2;
		int winY = (screenSize.height - bounds.height)/2;
		setLocation(winX, winY);
		
		//the only effect, as far as I can tell, of explicitly setting
		//the bounds is that the panel's dimensions are set earlier and
		//the rectangle being used as a border is visible
		setBounds(0,0,bounds.width, bounds.height);
		
		//With a BorderLayout you could add a menu bar in the north, and/or 
		//whatever else you may want in the west or south.  The center is always
		//the biggest area, which is why I chose it over a flow, box or grid 
		//layout
		setLayout(new BorderLayout());
		
		//Where the shape is drawn
		DrawingPanel sketchpad = new DrawingPanel();
		
		//With a BorderLayout it doesn't matter which order you add the
		//panels, since you specify explicitly which region it goes in.
		//Only one container per region.  (You can put panels inside other
		//panels to put multiple into a single region.)
		add(sketchpad, BorderLayout.CENTER);
		
		//Separating out the controls from the drawing area.  Note that
		//it receives a reference to the drawing panel so it can invoke methods
		//there to change what is being drawn
		ControlPanel controls = new ControlPanel(sketchpad);
		
		//This puts the controls on the right side.  Try putting it in other
		//regions to see what it looks like
		add(controls, BorderLayout.EAST);
		
		//To close the window.  This is an example of an anonymous class
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//When adding components you need to invoke pack().  If you ever
		//changed the components you would need to invoke it again.
		pack();
		setVisible(true);
		
		//This is a kludgy way to let the panel know how big it is at the
		//beginning so it can draw a rectangle as a border.  
		//There are no borders in awt.
		sketchpad.setDimensions();
		repaint();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LayoutDemo();

	}

}
