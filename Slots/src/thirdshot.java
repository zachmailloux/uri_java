 import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
public class thirdshot extends JFrame implements ActionListener{
	JButton JButtonRun, jButton, jButton2, jButton3;
	Icon icon, icon2, icon3;
	Random random = new Random();
	JOptionPane optionPane;
	Panel panel;
	JLabel label1,label2,label3;

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	
	thirdshot(String title) throws MalformedURLException {
		super(title);
		
		icon = new ImageIcon(new URL("http://icons.iconarchive.com/icons/martin-berube/food/96/apple-icon.png"));
		 icon2 = new ImageIcon(new URL("http://icons.iconarchive.com/icons/iconicon/veggies/96/bananas-icon.png"));  
		  icon3 = new ImageIcon(new URL("http://icons.iconarchive.com/icons/iconicon/veggies/96/blueberries-icon.png"));
		this.panels();
		this.pack();
		this.setVisible(true);}
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
	  
		thirdshot run = new thirdshot("Go");
		//start();
		  }
/*		public static void start() throws MalformedURLException{
		
		

			 JOptionPane.showMessageDialog(null,"Text","SetColor",JOptionPane.INFORMATION_MESSAGE);
			   JFrame panel = new JFrame();
			    JOptionPane optionPane = new JOptionPane();
			    optionPane.setMessage("        				     Choose your side!");
			    Icon icon = new ImageIcon(new URL("http://images1.wikia.nocookie.net/__cb20080830123634/wowwiki/images/4/49/Ability_warlock_improveddemonictactics.png"));
			    JButton jButton = getButton(optionPane, "Evil", icon);
			    
			    panel.setBackground(Color.black);
			    Icon icon2 = new ImageIcon(new URL("http://images1.wikia.nocookie.net/__cb20080805011857/wowwiki/images/a/a2/Ability_paladin_artofwar.png"));
			    JButton jButton2 = getButton(optionPane, "Alliance", icon2);
			    optionPane.setOptions(new Object[] { jButton,jButton2});
			    JDialog dialog = optionPane.createDialog(panel, "Guntharia World Adventure");
				UIManager UI=new UIManager();
				 UI.put("OptionPane.background", Color.blue);
				 UI.put("Panel.background", Color.pink);
				 UI.put("jButton.background", Color.orange);
			    dialog.setVisible(true);
		}*/
		public void panels() throws MalformedURLException {
			
			 panel = new Panel();
		//  optionPane = new JOptionPane();
			 
			  
			    label1 = new JLabel(icon);
			    label2 = new JLabel(icon2);
			    label3 = new JLabel(icon3);
			    //buttons();
			    JButtonRun = new JButton("Pull");
			    panel.add(label1);
			    panel.add(label2);
			    panel.add(label3);
			    panel.add(JButtonRun);
			    label1.setVisible(true);
			    
			    JButtonRun.addActionListener(this);
			    //optionPane.setOptions(new Object[] { JButtonRun,jButton,jButton2, jButton3});
			    this.add(panel);
			    panel.setVisible(true);
		}

	
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==JButtonRun){
					System.out.println("hello");
					int chance1 = random.nextInt(3);
					if(chance1 == 1){
						System.out.println("poop");
						try {
							icon = new ImageIcon(new URL("http://icons.iconarchive.com/icons/martin-berube/food/96/apple-icon.png"));
							label1 = new JLabel(icon);
							 panel.add(label1);
							 this.add(panel);
							
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if(chance1 ==2){
						try {
							icon = new ImageIcon(new URL("http://icons.iconarchive.com/icons/iconicon/veggies/96/bananas-icon.png"));
							label1 = new JLabel(icon);
							 panel.add(label1);
							 this.add(panel);
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						try {
							icon = new ImageIcon(new URL("http://icons.iconarchive.com/icons/iconicon/veggies/96/blueberries-icon.png"));
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				
					/*
					 */
					
				}
			}//end of action
		  }
	


