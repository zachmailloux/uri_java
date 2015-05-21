import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;


public class mywin extends JFrame implements ActionListener{
	JTextField name, type, color, Cow, Explosion, WhyNot, Because, ISaidSo;
	JButton Kill, Live, jButton, jButton2;
	
	mywin(String title) throws MalformedURLException {
		super(title);
		
		this.init();
		this.setSize(400, 400);
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
        Icon icon = new ImageIcon(new URL("http://images1.wikia.nocookie.net/__cb20080830123634/wowwiki/images/4/49/Ability_warlock_improveddemonictactics.png"));
	    jButton = getButton( "Evil", icon);
	    Icon icon2 = new ImageIcon(new URL("http://images1.wikia.nocookie.net/__cb20080805011857/wowwiki/images/a/a2/Ability_paladin_artofwar.png"));
	    jButton2 = getButton( "Alliance", icon2);
	    jButton2.addActionListener(this);
	    jButton.addActionListener(this);
     /*   Live.addActionListener(this);
        Kill.addActionListener(this);*/
        panel.add(jButton2);
        panel.add(jButton);
    /*    panel.add(Kill);
        
        panel.add(Live);*/
         
        this.add(panel);
	     
	}//end void
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		mywin simplewin = new mywin("Win");
		simplewin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jButton) {
			JOptionPane.showMessageDialog(this, "You live.");
			
		}
		if (e.getSource() == jButton2) {
			JOptionPane.showMessageDialog(this, "You die.");
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
