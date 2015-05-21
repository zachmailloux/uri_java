 import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
public class thirdshot {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	static Icon icon2;
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
	  
		alliance();
		start();
		  }
		public static void start() throws MalformedURLException{
		
		

			 JOptionPane.showMessageDialog(null,"Text","SetColor",JOptionPane.INFORMATION_MESSAGE);
			   JFrame frame = new JFrame();
			    JOptionPane optionPane = new JOptionPane();
			    optionPane.setMessage("        				     Choose your side!");
			    Icon icon = new ImageIcon(new URL("http://images1.wikia.nocookie.net/__cb20080830123634/wowwiki/images/4/49/Ability_warlock_improveddemonictactics.png"));
			    JButton jButton = getButton(optionPane, "Evil", icon);
			    
			    frame.setBackground(Color.black);
			    Icon icon2 = new ImageIcon(new URL("http://images1.wikia.nocookie.net/__cb20080805011857/wowwiki/images/a/a2/Ability_paladin_artofwar.png"));
			    JButton jButton2 = getButton(optionPane, "Alliance", icon2);
			    optionPane.setOptions(new Object[] { jButton,jButton2});
			    JDialog dialog = optionPane.createDialog(frame, "Guntharia World Adventure");
				UIManager UI=new UIManager();
				 UI.put("OptionPane.background", Color.blue);
				 UI.put("Panel.background", Color.pink);
				 UI.put("jButton.background", Color.orange);
			    dialog.setVisible(true);
		}
		public static void alliance() throws MalformedURLException {
			   JFrame frame = new JFrame();
			    JOptionPane optionPane = new JOptionPane();
			    optionPane.setMessage("        				                   Choose your class!");
			    Icon icon = new ImageIcon(new URL("http://images4.wikia.nocookie.net/__cb20060829232242/wowwiki/images/e/e7/Ability_warrior_savageblow.png"));
			    JButton jButton = getButton(optionPane, "Warrior", icon);
			    jButton.addMouseListener(null);
			    Icon icon2 = new ImageIcon(new URL("http://images4.wikia.nocookie.net/__cb20070120233341/wowwiki/images/c/cd/Inv_staff_draenei_a_03.png"));
			    JButton jButton2 = getButton(optionPane, "Mage", icon2);
			    jButton2.addActionListener(null);
			    Icon icon3 = new ImageIcon(new URL("http://images4.wikia.nocookie.net/__cb20060928003061/wowwiki/images/1/15/Ability_hunter_criticalshot.png"));
			    JButton jButton3 = getButton(optionPane, "Hunter", icon3);
			    jButton3.addActionListener(null);
			    optionPane.setOptions(new Object[] { jButton,jButton2, jButton3});
			    JDialog dialog = optionPane.createDialog(frame, "Guntharia World Adventure");
			    dialog.setVisible(true);
		}
		  public static  JButton getButton(final JOptionPane optionPane, String text, Icon icon) {
		    final JButton button = new JButton(text, icon);
		    ActionListener actionListener = new ActionListener() {
		      public void actionPerformed1(ActionEvent actionEvent) {
		        // Return current text label, instead of argument to method
		    	optionPane.setValue(button.getText());
		    	
		        System.out.println(button.getText());
		      }

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==getButton(optionPane, "Mage", icon2)){
					try {
						start();
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		    };
		    button.addActionListener(actionListener);
		    return button;
		  }
	}


