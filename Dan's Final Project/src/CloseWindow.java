import java.awt.event.*;


public class CloseWindow extends WindowAdapter {
		
		/**
		 *  Closes the window when the user hits "close"
		 */
		public void windowClosing(WindowEvent event){
			System.exit(0);
		}

	}

