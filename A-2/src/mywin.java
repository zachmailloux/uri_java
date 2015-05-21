import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;


public class mywin extends JFrame implements ActionListener{
	JTextField name, type, color, Cow, Explosion, WhyNot, Because, ISaidSo;
	JButton Kill, Live, jButton, jButton2, jButton3;
	
	mywin(String title) throws MalformedURLException {
		super(title);
		
		this.init();
		this.setSize(600, 400);
		this.setVisible(true);}
 public void init() throws MalformedURLException {
	     
	/*    JLabel lname = new JLabel("Name:");
	    JLabel ltype = new JLabel("Type:");
	    JLabel lcolor = new JLabel("Color:");
	    JLabel lCow = new JLabel("Cow:");
	    JLabel lExplosion = new JLabel("Explosion:");
	    JLabel lWhyNot = new JLabel("WhyNot:");
	    JLabel lBecause = new JLabel("Because:");
	    JLabel lISaidSo = new JLabel("ISaidSo:");*/
/*	    
	    name = new JTextField(15);
	    type = new JTextField(15);
	    color = new JTextField(15);
	    Cow = new JTextField(15);
	    Explosion = new JTextField(25);
	    WhyNot = new JTextField(15);
	    Because = new JTextField(15);
	    ISaidSo = new JTextField(15);*/
	    
	    JPanel panel = new JPanel();
	  	UIManager UI=new UIManager();
			 UI.put("OptionPane.background", Color.blue);
			 UI.put("Panel.background", Color.pink);
			 UI.put("Button.background", Color.orange);
	/*    panel.add(lname);
	    panel.add(name);
	    panel.add(ltype);
	    panel.add(type);
	    panel.add(lcolor);
	    panel.add(color);
	    panel.add(lCow);
	    panel.add(Cow);
	    panel.add(lExplosion);
	    panel.add(Explosion);
	    panel.add(lWhyNot);
	    panel.add(WhyNot);
	    panel.add(lBecause);
	    panel.add(Because);
	    panel.add(lISaidSo);
	    panel.add(ISaidSo);*/
	     
	/*    Live = new JButton("Live");
        Kill = new JButton("Die");*/
	    
        Icon icon = new ImageIcon(new URL("http://images4.wikia.nocookie.net/__cb20060829232242/wowwiki/images/e/e7/Ability_warrior_savageblow.png"));
	    jButton = getButton( "Warrior", icon);
	    Icon icon2 = new ImageIcon(new URL("http://images4.wikia.nocookie.net/__cb20070120233341/wowwiki/images/c/cd/Inv_staff_draenei_a_03.png"));
	    jButton2 = getButton( "Mage", icon2);
	    Icon icon3 = new ImageIcon(new URL("http://images4.wikia.nocookie.net/__cb20060928003061/wowwiki/images/1/15/Ability_hunter_criticalshot.png"));
	    jButton = getButton( "Hunter", icon3);
	    jButton2.addActionListener(this);
	    jButton3.addActionListener(this);
	    jButton.addActionListener(this);
     /*   Live.addActionListener(this);
        Kill.addActionListener(this);*/
        panel.add(jButton2);
        panel.add(jButton3);
        panel.add(jButton);
    /*    panel.add(Kill);
        
        panel.add(Live);*/
         
        this.add(panel);
	     
	}//end void
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		FinalP simplewin = new mywin("Win");
		simplewin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jButton) {
			JOptionPane.showMessageDialog(this, "Warriors");	
		}
		if (e.getSource() == jButton2) {
			JOptionPane.showMessageDialog(this, "Mage's are of a elite breed that use spells to dominate their opponents");
		}
		if (e.getSource() == jButton3) {
			JOptionPane.showMessageDialog(this, "A Hunter aye? They're of a quick and nimble type");
		}
	
	}

	  public static  JButton getButton (String text, Icon icon) {
		    final JButton button = new JButton(text, icon);
		    ActionListener actionListener = new ActionListener() {
		      public void actionPerformed1(ActionEvent actionEvent) {
		        // Return current text label, instead of argument to method
		    	
		    	
		        System.out.println(button.getText());
		      }

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		    };
		    button.addActionListener(actionListener);
		    return button;
		  }
}