 import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;


public class colorchange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 UIManager UI=new UIManager();
		 UI.put("OptionPane.background", Color.blue);
		 UI.put("Panel.background", Color.blue);

		 JOptionPane.showMessageDialog(null,"Text","SetColor",JOptionPane.INFORMATION_MESSAGE);
	}

}
