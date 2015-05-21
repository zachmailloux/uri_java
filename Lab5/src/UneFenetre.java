/**
 * Implements one of the window's useful methods.
 */
/**
 * To introduce handling mouse events.
 * 
 * @author Zach Mailloux & Brenden Smerbeck
 */

import java.awt.event.*;


public class UneFenetre extends WindowAdapter {
	
	/**
	 * So our window closes when the user hits the close button.
	 */
	public void windowClosing(WindowEvent event){
		System.exit(0);
	}

}
