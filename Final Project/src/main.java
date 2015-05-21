
/**
* Implements one of the window's useful methods.
*/

import java.awt.event.*;


public class main extends WindowAdapter {
		/**
		 * The main constructor creates a new game that starts the entire game process and calls to open the window
		 * @param args
		 */
	
	public static void main(String[] args){
		Game Menu = new Game();
	}
	/**
	* So our window closes when the user hits the close button.
	*/
	public void windowClosing(WindowEvent event){
		System.exit(0);
	}

}


