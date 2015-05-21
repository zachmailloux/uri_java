import javax.swing.*;

import java.awt.Color;
import java.net.*;

public class images
{
    public static void main(String[] args) throws Exception
    {
    	String name;
    	UIManager UI=new UIManager();
		 UI.put("OptionPane.background", Color.blue);
		 UI.put("Panel.background", Color.pink);
		 UI.put("Button.background", Color.orange);
	
       // final ImageIcon icon = new ImageIcon(new URL("http://www.gravatar.com/avatar/a1ab0af4997654345d7a949877f8037e?s=128&d=identicon&r=PG"));
       // JOptionPane.showMessageDialog(null, "Blah blah blah", "About", JOptionPane.INFORMATION_MESSAGE, icon);
      //  http://www.iconarchive.com/show/sleek-xp-basic-icons-by-deleket/Money-icon.html
        //	final ImageIcon icon = new ImageIcon(new URL("http://digital-art-gallery.com/oid/72/600x600_12908_Orc_2d_cartoon_orc_warrior_picture_image_digital_art.jpg"));
        	final ImageIcon icon1 = new ImageIcon(new URL("http://images3.wikia.nocookie.net/__cb20080805014120/wowwiki/images/0/03/Inv_helmet_137.png"));
        	final ImageIcon icon2 = new ImageIcon(new URL("http://images2.wikia.nocookie.net/__cb20080805014113/wowwiki/images/1/1f/Inv_helmet_136.png"));
        JOptionPane.showMessageDialog(null, "The orcs lay ahead of us", "About", JOptionPane.INFORMATION_MESSAGE, icon1);
  
        name = JOptionPane.showInputDialog(icon2);
    }
}