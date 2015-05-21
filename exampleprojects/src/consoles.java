

//IMPORT THIS for popups!!!!
import javax.swing.JOptionPane;

//Advanced programmers import these.
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class consoles {

	public static void main(String[] args){

		String name;
		
		//The line below asks for your name and stores in a variable
		name = JOptionPane.showInputDialog("Enter your name");
		
		
		// This line below says your name and welcomes you
		JOptionPane.showMessageDialog(null, "Welcome "+ name+ " to Java!");
		
		
		//The line below shows an error message
		JOptionPane.showMessageDialog(null, "Welcome to iD Tech", "Welcome", JOptionPane.ERROR_MESSAGE);
		
		//**************
		 //**ATTENTION**
		//**************
		//The line of code below is for advanced programmers.
		picture();
		//Type the following statement
		//     JOptionPane.
		//When you hit the period ( . ) a menu will pop up
		// in that menu are TONS of options of cool pop ups
		// some seem overwhelming but some are super easy
		// and very easy to use. 
	}
	
	/*
	 * The following code is a method, this is for students who are advanced in JOptionPane 
	 * feel that they are ready for something challenging
	 */
	
	public static void picture(){
			ImageIcon icon1 = null;
			JPanel panel = new JPanel();
			try
			{
				icon1 = new ImageIcon(new URL("http://images3.wikia.nocookie.net/__cb20080805014120/wowwiki/images/0/03/Inv_helmet_137.png"));
			}
			catch(Exception ex){}
			panel.add(new JLabel(icon1));
			panel.add(new JLabel("blah blah blah"));
			Object[] options = {};
			JOptionPane pane = new JOptionPane();
			pane.showOptionDialog(null, panel, "About", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
		
	}
}
