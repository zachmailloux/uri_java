import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class otherImagetwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
