
//Java Util
import java.util.Random;
//Java io
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//Java Awt
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
//Javax Swing
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;

public class GUIDisplay extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	JPanel master;
	JTextField nameField;
	JComboBox<String> cb;
	Character you;
	Foe foe;
	String[] types;
	JLabel str,mag,sta,itl,lvl;
	JButton save,open,cont,attack,spell,gaurd,heal,fQuit,fView,help;
	float anim;
	float dx;
	boolean update, manual;
	int mode;
	//DrawCharacter dC;
	public GUIDisplay () {
		//Initialize via super
		super("Game");
		//Initialize specifics
		update = false;
		manual = false;
		mode = 1;
		this.setSize(576,205);
		init();
		this.setIgnoreRepaint(true);
		this.setVisible(true);
		this.setResizable(false);
		anim = 0;
		dx = 0.5f;
	}
	
	public void update () {
		
		anim += dx;
		if(anim>=5){
			dx = -dx;
		}
		if(anim<=-5){
			dx = -dx;
		}
		update = !update;
		if(update){
			this.repaint();
		}
	}
	public void paint (Graphics g){ 
		super.paint(g);
		if(mode==1){
		int width = 10;
		int height = 16;
		int indent = 92;
		g.setColor(Color.RED);
		g.fillRoundRect(indent, 50, you.strength*width, height, 2, 2);
		g.setColor(Color.BLUE);
		g.fillRoundRect(indent, 50+height, you.magic*width, height, 2, 2);
		g.setColor(Color.GREEN);
		g.fillRoundRect(indent, 50+(height*2), you.stamina*width, height, 2, 2);
		g.setColor(Color.MAGENTA);
		g.fillRoundRect(indent, 50+(height*3), you.intelligence*width, height, 2, 2);
		}else{
			if(you.health > 200){
				g.setColor(new Color(0,155,0));
			}else if(you.health>150){
				g.setColor(new Color(0,255,0));
			}else if(you.health>100){
				g.setColor(new Color(255,255,0));
			}else if(you.health>50){
				g.setColor(new Color(255,128,0));
			}else{
				g.setColor(new Color(255,0,0));
			}
			g.fillRoundRect(20, 190 - (int) (you.health*0.6), 30,  (int) (you.health*0.6), 2, 2);
		}
		//Character
		//dC.repaint();
		int x = 400;
		int y = 100;
		if(mode==2){
			x=100;
		}
		if(you.class_=="Warrior"){
			g.setColor(new Color(0,14,71));
			g.fillRoundRect(x,y+35,16,60,5,5);
			g.fillRoundRect(x+17,y+35,16,60,5,5);
			g.setColor(new Color(138,138,138));
		    int an = (int) (anim*0.5);
		    int wx[] = {x-5,x-5,x-70,x-70};
		    int wy[] = {y+30+an,y+40+an,y-10+an,y-20+an};
		    g.fillPolygon(wx,wy,4);
		    g.setColor(new Color(94, 61, 22));
		    g.fillRoundRect(x-12,(int) (y-20+anim*0.5),15,60,5,5);
		    g.setColor(new Color(66, 40, 0));
		    g.fillRoundRect(x,(int) (y-20+anim*0.25),40,60,5,5);
		    g.setColor(new Color(94, 61, 22));
		    g.fillRoundRect(x+32,(int) (y-20+anim*0.5),15,60,5,5);
		    g.setColor(new Color(224, 196, 155));
		    g.fillOval(x+3,(int) (y-32+anim*0.25-17.5),30,35);
		    g.setColor(new Color(184, 184, 184));
		    int px[] = {x-2,x+6,x+18,x+30,x+38};
		    int py[] = {y-35,y-47,y-55,y-47,y-35};
		    g.fillPolygon(px ,py , 5);
		    g.setColor(new Color(0, 0, 0));
		    g.fillOval(x+8,y-32,4,5);
		    g.fillOval(x+23,y-32,4,5);
		    
		}
		if(you.class_=="Wizard"){
			g.setColor(new Color(130, 130, 130));
			g.fillRoundRect(x-12,(int) (y-20+anim*0.5),15,60,5,5);
			g.setColor(new Color(102, 102, 102));
			g.fillRoundRect(x,(int) (y-20+anim*0.25),40,80,5,5);
			g.fillRoundRect(x,y+40,40,50,5,5);
			g.setColor(new Color(130, 130, 130));
			g.fillRoundRect(x+32,(int) (y-20+anim*0.5),15,60,5,5);
			g.setColor(new Color(224, 196, 155));
			g.fillOval(x+3,(int) (y-32+anim*0.25-17.5),30,35);
			g.setColor(new Color(0, 0, 0));
			g.fillOval(x+8,y-35,4,5);
			g.fillOval(x+23,y-35,4,5);
			g.setColor(new Color(77, 62, 0));
		    int an = (int) (anim*0.5);
		    int wx[] = {x-5,x-10,x-25,x-20};
		    int wy[] = {y+80+an,y+80+an,y-20+an,y-20+an};
		    g.fillPolygon(wx,wy,4);
		    g.setColor(new Color(179, 179, 179));
		    g.fillOval(x+5,y-25,10,20);
		    g.fillOval(x+12,y-20,10,20);
		    g.fillOval(x+20,y-25,10,20);
		    g.fillOval(x+9,y-15,10,20);
		    g.fillOval(x+17,y-15,10,20);
		}
		if(you.class_=="Rogue"){
			g.setColor(new Color(26, 26, 26));
			g.fillRoundRect(x,y+35,16,60,5,5);
			g.fillRoundRect(x+17,y+35,16,60,5,5);
			g.setColor(new Color(138,138,138));
		    int an = (int) (anim*0.5);
		    int wx[] = {x-5,x-5,x-40,x-40};
		    int wy[] = {y+30+an,y+40+an,y+12+an,y+8+an};
		    g.fillPolygon(wx,wy,4);
		    g.setColor(new Color(46, 25, 0));
		    g.fillOval(x,(int) (y-53+anim*0.25),37,42);
		    g.setColor(new Color(46, 46, 46));
		    g.fillRoundRect(x-12,(int) (y-20+anim*0.5),15,60,5,5);
		    g.setColor(new Color(0, 0, 0));
		    g.fillRoundRect(x,(int) (y-20+anim*0.25),40,60,5,5);
		    g.setColor(new Color(26, 26, 26));
		    g.fillRoundRect(x+32,(int) (y-20+anim*0.5),15,60,5,5);
		    g.setColor(new Color(128, 111, 88));
		    g.fillOval(x+3,(int) (y-49+anim*0.25),30,35);
		    g.setColor(new Color(0, 0, 0));
		    g.fillOval(x+8,y-35,4,5);
		    g.fillOval(x+23,y-35,4,5);
		}
		if(mode==2){
			g.setColor(new Color(30, 46, 0));
			g.fillRoundRect(180+220,215-80,16,60,5,5);
			g.fillRoundRect(197+220,215-80,16,60,5,5);
			g.setColor(new Color(77,62,0));
		    int an = (int) (anim*0.5);
		    int wx[] = {400-5,400-5,400-70,400-80,400-70};
		    int wy[] = {y+30-an,y+40-an,y+5-an,y-15-an,y-35-an};
		    g.fillPolygon(wx,wy,5);
		    g.setColor(new Color(32, 71, 0));
		    g.fillRoundRect(168+220,(int) (160-anim*0.5)-80,15,60,5,5);
		    g.setColor(new Color(64, 48, 0));
		    g.fillRoundRect(180+220,(int) (160-anim*0.25)-80,40,60,5,5);
		    g.setColor(new Color(32, 71, 0));
		    g.fillRoundRect(212+220,(int) (160-anim*0.5)-80,15,60,5,5);
		    g.setColor(new Color(14, 71, 0));
		    g.fillOval(198+220-15,(int) (148+anim*0.25)-80-17,30,35);
		    g.setColor(new Color(255, 0, 0));
		    g.fillOval(190+220-2,147-82,4,5);
		    g.fillOval(205+220-2,147-82,4,5);
		}
	}
	
	private void init () {

		JLabel nameLabel = new JLabel("Enter name: ");
		nameField = new JTextField(30);

		//dC = new DrawCharacter("Warrior", 300,100);
		
        you = new Character();
        setStatsForClass();
        foe = new Foe();
		String[] types = {"Warrior", "Wizard", "Rogue"};
        JLabel msg = new JLabel("Select class: ");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
        cb = new JComboBox<String>(types);
        cb.addActionListener(this);
        
        str = new JLabel("Strength: "+you.strength);
        mag = new JLabel("Magic: "+you.magic);
        sta = new JLabel("Stamina: "+you.stamina);
        itl = new JLabel("Intelligence: "+you.intelligence);
        lvl = new JLabel("Level: "+you.level);
        
        save = new JButton("Save");
        open = new JButton("Open");
        cont = new JButton("Finish");
        attack = new JButton("Attack");
        spell = new JButton("Spell");
        heal = new JButton("Heal (x"+you.heals+")");
        fQuit = new JButton("Quit");
        fView = new JButton("View Stats");
        help = new JButton("Help");
        save.addActionListener(this);
        open.addActionListener(this);
        cont.addActionListener(this);
        attack.addActionListener(this);
        spell.addActionListener(this);
        heal.addActionListener(this);
        fQuit.addActionListener(this);
        fView.addActionListener(this);
        help.addActionListener(this);
        
        
        c.gridx = 0;
        c.gridy = 0;
        panel.add(nameLabel, c);
        c.gridx = 1;
        c.gridwidth = 4;
        panel.add(nameField, c);
        c.gridwidth = 1;
        c.gridx = 5;
        panel.add(msg, c);
        c.gridx = 6;
        panel.add(cb, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(str, c);
        c.gridy = 3;
        panel.add(mag, c);
        c.gridy = 4;
        panel.add(sta, c);
        c.gridy = 5;
        panel.add(itl, c);
        c.gridy = 6;
        panel.add(save, c);
        c.gridy = 7;
        panel.add(open, c);
        c.gridy = 8;
        panel.add(cont, c);
        c.gridy = 8;
        c.gridx = 1;
        panel.add(lvl, c);
        c.gridy = 8;
        c.gridx = 6;
        panel.add(help, c);
        
        JPanel createPanel = new JPanel();
        
        createPanel.setLayout(new BorderLayout());
        createPanel.add(panel, BorderLayout.NORTH);
        
        JPanel fightPanel = new JPanel(new BorderLayout());
        
        JPanel commands = new JPanel();
        commands.add(attack);
        commands.add(spell);
        commands.add(heal);
        JPanel quit = new JPanel( new GridLayout(2,1));
        quit.add(fQuit);
        quit.add(fView);
        
        fightPanel.add(commands,BorderLayout.SOUTH);
        fightPanel.add(quit,BorderLayout.EAST);
        
        master = new JPanel(new CardLayout());
        master.add(createPanel, "1");
        master.add(fightPanel, "2");
        
        this.add(master);
	}


	public void setStatsForClass() {
		if(!manual){
		if(you.class_ == "Warrior"){
			you.strength = 12;
			you.magic = 4;
			you.stamina = 8;
			you.intelligence = 7;
		}
		if(you.class_ == "Wizard"){
			you.strength = 5;
			you.magic = 12;
			you.stamina = 5;
			you.intelligence = 9;
		}
		if(you.class_ == "Rogue"){
			you.strength = 7;
			you.magic = 6;
			you.stamina = 10;
			you.intelligence = 6;
		}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == cb){
			switch (cb.getSelectedIndex()){
	        
	        case 0:
	            you.setTheClass("Warrior");
	            setStatsForClass();
	            break;
	             
	        case 1:
	            you.setTheClass("Wizard");
	            setStatsForClass();
	            break;
	             
	        case 2:
	            you.setTheClass("Rogue");
	            setStatsForClass();
	            break;
	         
			}
			manual = false;
			
			str.setText("Strength: "+you.strength);
	        mag.setText("Magic: "+you.magic);
	        sta.setText("Stamina: "+you.stamina);
	        itl.setText("Intelligence: "+you.intelligence);
		}
		else{
		if(e.getSource() == save){
            you.name = nameField.getText();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
             
            int result = fileChooser.showSaveDialog(this);
             
            if (result == JFileChooser.CANCEL_OPTION)
                return;
             
            File fileName = fileChooser.getSelectedFile();
             
            if (fileName == null || fileName.getName().equals("")){
                JOptionPane.showMessageDialog(this, "Invalid File Name");
            }//end if
            else{
                try{
                    ObjectOutputStream output = new ObjectOutputStream (new FileOutputStream (fileName));
                    output.writeObject(you);
                    output.flush();
                    output.close();
                }//end try
                catch (IOException exp){
                    JOptionPane.showMessageDialog(this, "Error opening file.");
                }//end catch
            }
		}else{
		if(e.getSource() == open){
			JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(this);
             
            if (result == JFileChooser.CANCEL_OPTION)
                return;
             
            File fileName = fileChooser.getSelectedFile();
             
            if (fileName == null || fileName.getName().equals("")){
                JOptionPane.showMessageDialog(this, "Invalid File Name");
            }//end if
            else {
                try{
                	ObjectInputStream input = new ObjectInputStream (new FileInputStream (fileName));
                     
                    you = (Character) input.readObject();
                    str.setText("Strength: "+you.strength);
        	        mag.setText("Magic: "+you.magic);
        	        sta.setText("Stamina: "+you.stamina);
        	        itl.setText("Intelligence: "+you.intelligence);
        	        lvl.setText("Level: "+you.level);
                    input.close();
                    manual = true;
                    cb.setSelectedItem(you.class_);
                    nameField.setText(you.name);
                }//end try
                catch(ClassNotFoundException exp){
                    JOptionPane.showMessageDialog(this, "Error opening file");
                }//end catch
                catch (IOException exp){
                    JOptionPane.showMessageDialog(this,  "Error opening file");
                }//end catch
                 
            }
		}
		else{
		if(e.getSource() == cont){
			int option = JOptionPane.showConfirmDialog(this, "Are you sure that you would like to continue?\nIt would be wise to SAVE your character before continuing.", "", JOptionPane.INFORMATION_MESSAGE);
			if(option==0){ 
			CardLayout cl = (CardLayout) master.getLayout();
		     cl.show(master, "2");
		     mode = 2;
			}
		}else{
		if(e.getSource() == attack){
			System.out.println("Attacked for "+you.strength*2.5+" damage!");
			heal.setText("Heal (x"+you.heals+")");
			if (foe.hitWith((int) (you.strength*2.5), false)){
				JOptionPane.showMessageDialog(this, "Enemy defeated!", "", JOptionPane.INFORMATION_MESSAGE);
				you.levelUp();
				foe.respec();
				int option = JOptionPane.showConfirmDialog(this, "Would you like to save?\nYou will not be able to save in the middle of a battle!");
				if(option == 0){
					//SAVE
					JFileChooser fileChooser = new JFileChooser();
		            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		             
		            int result = fileChooser.showSaveDialog(this);
		             
		            if (result == JFileChooser.CANCEL_OPTION)
		                return;
		             
		            File fileName = fileChooser.getSelectedFile();
		             
		            if (fileName == null || fileName.getName().equals("")){
		                JOptionPane.showMessageDialog(this, "Invalid File Name");
		            }//end if
		            else{
		                try{
		                    ObjectOutputStream output = new ObjectOutputStream (new FileOutputStream (fileName));
		                    output.writeObject(you);
		                    output.flush();
		                    output.close();
		                }//end try
		                catch (IOException exp){
		                    JOptionPane.showMessageDialog(this, "Error opening file.");
		                }//end catch
		            }
				}
			}else{
				String st = foe.atckDescription(false);
				JOptionPane.showMessageDialog(this, "Attacked for "+foe.lastDmg+" damage!\n"+st, "", JOptionPane.INFORMATION_MESSAGE);
				
				JOptionPane.showMessageDialog(this, "Took "+foe.damageAtLevel(you.level)+" damage.", "", JOptionPane.INFORMATION_MESSAGE);
				if(you.hitWith(foe.damageAtLevel(you.level))){
					JOptionPane.showMessageDialog(this, "GAME OVER", "GAME OVER", JOptionPane.WARNING_MESSAGE);
					CardLayout cl = (CardLayout) master.getLayout();
				     cl.show(master, "1");
				     mode = 1;
				     you = new Character();
				     str.setText("Strength: "+you.strength);
	     	         mag.setText("Magic: "+you.magic);
	     	         sta.setText("Stamina: "+you.stamina);
	     	         itl.setText("Intelligence: "+you.intelligence);
	     	         lvl.setText("Level: "+you.level);
	                 cb.setSelectedItem(you.class_);
	                 nameField.setText(you.name);
				}
			}
			
		}else{
		if(e.getSource() == spell){
			System.out.println("Casted spell for "+you.magic*2.5+" damage!");
			if (foe.hitWith((int) (you.magic*2.5), true)){
				JOptionPane.showMessageDialog(this, "Enemy defeated!", "", JOptionPane.INFORMATION_MESSAGE);
				you.levelUp();
				foe.respec();
				int option = JOptionPane.showConfirmDialog(this, "Would you like to save?\nYou will not be able to save in the middle of a battle!");
				if(option == 0){
					//SAVE
					JFileChooser fileChooser = new JFileChooser();
		            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		             
		            int result = fileChooser.showSaveDialog(this);
		             
		            if (result == JFileChooser.CANCEL_OPTION)
		                return;
		             
		            File fileName = fileChooser.getSelectedFile();
		             
		            if (fileName == null || fileName.getName().equals("")){
		                JOptionPane.showMessageDialog(this, "Invalid File Name");
		            }//end if
		            else{
		                try{
		                    ObjectOutputStream output = new ObjectOutputStream (new FileOutputStream (fileName));
		                    output.writeObject(you);
		                    output.flush();
		                    output.close();
		                }//end try
		                catch (IOException exp){
		                    JOptionPane.showMessageDialog(this, "Error opening file.");
		                }//end catch
		            }
				}
				heal.setText("Heal (x"+you.heals+")");
			}else{
				String st = foe.atckDescription(true);
				JOptionPane.showMessageDialog(this, "Casted a spell for "+foe.lastDmg+" damage!\n"+st, "", JOptionPane.INFORMATION_MESSAGE);
				
				JOptionPane.showMessageDialog(this, "Took "+foe.damageAtLevel(you.level)+" damage.", "", JOptionPane.INFORMATION_MESSAGE);
				if(you.hitWith(foe.damageAtLevel(you.level))){
					JOptionPane.showMessageDialog(this, "GAME OVER", "GAME OVER", JOptionPane.WARNING_MESSAGE);
					CardLayout cl = (CardLayout) master.getLayout();
				     cl.show(master, "1");
				     mode = 1;
				     you = new Character();
				     str.setText("Strength: "+you.strength);
	     	         mag.setText("Magic: "+you.magic);
	     	         sta.setText("Stamina: "+you.stamina);
	     	         itl.setText("Intelligence: "+you.intelligence);
	     	         lvl.setText("Level: "+you.level);
	                 cb.setSelectedItem(you.class_);
	                 nameField.setText(you.name);
				}
			}
		}
		else{
		if(e.getSource() == heal){
			if(you.heals>0){
			you.hitWith(-you.level*8-(you.intelligence*2));
			you.heals--;
			heal.setText("Heal (x"+you.heals+")");
			JOptionPane.showMessageDialog(this, "Took "+foe.damageAtLevel(you.level)+" damage.", "", JOptionPane.INFORMATION_MESSAGE);
			if(you.hitWith(foe.damageAtLevel(you.level))){
				JOptionPane.showMessageDialog(this, "GAME OVER", "GAME OVER", JOptionPane.WARNING_MESSAGE);
				CardLayout cl = (CardLayout) master.getLayout();
			     cl.show(master, "1");
			     mode = 1;
			     you = new Character();
			     str.setText("Strength: "+you.strength);
     	         mag.setText("Magic: "+you.magic);
     	         sta.setText("Stamina: "+you.stamina);
     	         itl.setText("Intelligence: "+you.intelligence);
     	         lvl.setText("Level: "+you.level);
                 cb.setSelectedItem(you.class_);
                 nameField.setText(you.name);
			}
			}
		}
		else{
		if(e.getSource() == fQuit){
			int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?\nAll unsaved progress will be lost!");
			if(option == 0){
				System.exit(0);
			}
		}else{
		if(e.getSource() == fView){
			int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to leave?\nAll unsaved progress will be lost!");
			if(option == 0){
				CardLayout cl = (CardLayout) master.getLayout();
			     cl.show(master, "1");
			     mode = 1;
			     str.setText("Strength: "+you.strength);
     	         mag.setText("Magic: "+you.magic);
     	         sta.setText("Stamina: "+you.stamina);
     	         itl.setText("Intelligence: "+you.intelligence);
     	         lvl.setText("Level: "+you.level);
     	         manual = true;	
                 cb.setSelectedItem(you.class_);
                 nameField.setText(you.name);
			}
		}
		else{
		if(e.getSource() == help){
		JOptionPane.showMessageDialog(this, "This is a simple RPG game.\nStrength signifies attack strength.\nMagic signifies spell strength.\nIntelligence increases healing effects.\nStamina increases dodging rate.\nWhen you defeat an enemy some stats increase and you may get a new health potion.\nDifferent classes have different starting stats.\n", "Help", JOptionPane.INFORMATION_MESSAGE);
		}
		}
		}
		}
		}
		}
		}
		}
		}
		}
		
	}
}
