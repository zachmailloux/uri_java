import javax.swing.*;
import java.net.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MCCC extends JFrame implements ActionListener{
	
	private JComboBox cb;
	
	JTextField thing;
	JButton Find_It_For_Me, Exit;
	String word;
	MCCC(String title) throws MalformedURLException {
		super(title);
	   
		this.init();
		this.pack();
		this.setVisible(true);}
 public void init() throws MalformedURLException {
	     
	    JLabel lthing = new JLabel("Item/Block:");
	    
	    String[] types = {"Sword", "Axe", "Shovel"};
	    JLabel IB = new JLabel("Item/Block");		
	    
	    cb = new JComboBox(types);
	    cb.addActionListener(this);
	    
	    
	    thing = new JTextField(15);
	   
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(Color.YELLOW);
	    panel.add(lthing);
	    panel.add(thing);
	   
	    Icon icon1= new ImageIcon(new URL("http://shotbow.net/forum/images/crafting_table.png"));
	    Find_It_For_Me = new JButton("Find it for me",icon1);
        Exit = new JButton("Exit");
        
        Exit.addActionListener(this);
        Find_It_For_Me.addActionListener(this);
        thing.addActionListener(this);
        panel.add(thing);
        panel.add(Find_It_For_Me);
        panel.add(Exit);
        
        panel.add(IB);
	    panel.add(cb);
        
         
        this.add(panel);
	     
	}//end void
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		MCCC simplewin = new MCCC("Win");
		simplewin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String word;
		word = thing.getText();
		
		if (e.getSource() ==(Exit)) {
			System.exit(0);
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("pickaxe")) {
			
			  ImageIcon iconpickaxe = null;
			try {
				iconpickaxe = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Tools/craft/craft_pickaxes.gif"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Pickaxes", "About", JOptionPane.INFORMATION_MESSAGE, iconpickaxe);
			
			
		
		}
		
		if (e.getSource() ==(Find_It_For_Me) && word.equals("shovel")) {
			
			  ImageIcon iconshovel = null;
			try {
				iconshovel = new ImageIcon(new URL("file://localhost/Users/zacharymailloux/Desktop/GOLF-COURSE-LAYOUT1.jpg"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Shovels", "About", JOptionPane.INFORMATION_MESSAGE, iconshovel);
			
			
		
		}		
		if (e.getSource() ==(Find_It_For_Me) && word.equals("axe")) {
			
			  ImageIcon iconaxe = null;
			try {
				iconaxe = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Tools/craft/craft_axes.gif"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Axes", "About", JOptionPane.INFORMATION_MESSAGE, iconaxe);
			
			
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("sword")) {
			
			  ImageIcon iconsword = null;
			try {
				iconsword = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Defence/craft/craft_swords.gif"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Swords", "About", JOptionPane.INFORMATION_MESSAGE, iconsword);
			
			
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("hoe")) {
			
			  ImageIcon iconhoe = null;
			try {
				iconhoe = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Tools/craft/craft_hoes.gif"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Hoes", "About", JOptionPane.INFORMATION_MESSAGE, iconhoe);
			
			
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("cow")) {
			
			  ImageIcon iconcow = null;
			try {
				iconcow = new ImageIcon(new URL("http://24.media.tumblr.com/tumblr_mdrl8mleLX1qf3tseo1_500.gif"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "SPAMING DERPY COWS!!!", "About", JOptionPane.INFORMATION_MESSAGE, iconcow);
			
			
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("wooden planks")) {
			
			  ImageIcon iconwp = null;
			try {
				iconwp = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Basic/craft/craft_wood.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Wooden Planks", "About", JOptionPane.INFORMATION_MESSAGE, iconwp);
			
			
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("stick")) {
			
			  ImageIcon iconst = null;
			try {
				iconst = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Basic/craft/craft_stick.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Sticks", "About", JOptionPane.INFORMATION_MESSAGE, iconst);
			
			
		
		}
	
		if (e.getSource() ==(Find_It_For_Me) && word.equals("herobrine")) {
		
			
			  ImageIcon iconhb = null;
			try {
				iconhb = new ImageIcon(new URL("http://stream1.gifsoup.com/view2/1603750/minecraft-him-o.gif"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE, iconhb);
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("bow")) {
			
			
			  ImageIcon iconbow = null;
			try {
				iconbow = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Defence/craft/craft_bow.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Bow", "About", JOptionPane.INFORMATION_MESSAGE, iconbow);
		
		}       
		if (e.getSource() ==(Find_It_For_Me) && word.equals("arrow")) {
			
			
			  ImageIcon iconarrow = null;
			try {
				iconarrow = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Defence/craft/craft_arrow.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Arrow", "About", JOptionPane.INFORMATION_MESSAGE, iconarrow);
		
		}       
		if (e.getSource() ==(Find_It_For_Me) && word.equals("chestplate")) {
			
			
			  ImageIcon iconplate = null;
			try {
				iconplate = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Defence/craft/craft_chestplates.gif"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Chestplates", "About", JOptionPane.INFORMATION_MESSAGE, iconplate);
		
		}        
		if (e.getSource() ==(Find_It_For_Me) && word.equals("helmet")) {
			
			
			  ImageIcon iconhl = null;
			try {
				iconhl = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Defence/craft/craft_helmets.gif"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Helmets", "About", JOptionPane.INFORMATION_MESSAGE, iconhl);
		
		}       
		if (e.getSource() ==(Find_It_For_Me) && word.equals("leggings")) {
			
			
			  ImageIcon iconl = null;
			try {
				iconl = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Defence/craft/craft_leggings.gif"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Leggings", "About", JOptionPane.INFORMATION_MESSAGE, iconl);
		
		}        
		if (e.getSource() ==(Find_It_For_Me) && word.equals("boots")) {
			
			
			  ImageIcon iconb = null;
			try {
				iconb = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Defence/craft/craft_boots.gif"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Boots", "About", JOptionPane.INFORMATION_MESSAGE, iconb);
		
		}        
		if (e.getSource() ==(Find_It_For_Me) && word.equals("torch")) {
			
			
			  ImageIcon icontor = null;
			try {
				icontor = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Basic/craft/craft_torch.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Torches", "About", JOptionPane.INFORMATION_MESSAGE, icontor);
		
		}       
		if (e.getSource() ==(Find_It_For_Me) && word.equals("crafting table")) {
			
			
			  ImageIcon iconct = null;
			try {
				iconct = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Basic/craft/craft_workbench.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Crafting Table", "About", JOptionPane.INFORMATION_MESSAGE, iconct);
		
		}        
		if (e.getSource() ==(Find_It_For_Me) && word.equals("chest")) {
			
			
			  ImageIcon iconch = null;
			try {
				iconch = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Basic/craft/craft_chest.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Chest", "About", JOptionPane.INFORMATION_MESSAGE, iconch);
		
		}       
		if (e.getSource() ==(Find_It_For_Me) && word.equals("furnace")) {
			
			
			  ImageIcon iconfu = null;
			try {
				iconfu = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Basic/craft/craft_furnace.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Furnace", "About", JOptionPane.INFORMATION_MESSAGE, iconfu);
		
		}        
		if (e.getSource() ==(Find_It_For_Me) && word.equals("ladder")) {
			
			
			  ImageIcon iconla = null;
			try {
				iconla = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Basic/craft/craft_ladder.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Ladder", "About", JOptionPane.INFORMATION_MESSAGE, iconla);
		
		}        
		if (e.getSource() ==(Find_It_For_Me) && word.equals("fence")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Basic/craft/craft_fence.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Fence", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}        
		if (e.getSource() ==(Find_It_For_Me) && word.equals("boat")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Basic/craft/craft_boat.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Boat", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}
		
		//ginnuqewrfhwefiguwbeofiyhgroeirugroeiugergqrewgruqrgheiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiuqerghqwerhtgiuqewurghwirhgqiuwrghwhrgperuhgpieurgh
		if (e.getSource() == cb){
			switch(cb.getSelectedIndex()){
	case 0: 

			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Basic/craft/craft_boat.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Boat", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		break;
		}
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("wooden slab")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Basic/craft/craft_woodenslabs.gif"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Wooden Slabs", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("stone slab")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Basic/craft/craft_stoneslabs.gif"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Stone Slabs", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("sign")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Basic/craft/craft_sign.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Sign", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("door")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Basic/craft/craft_doors.gif"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Doors", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("fishing rod")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Tools/craft/craft_fishingrod.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Fishing Rod", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("flint and steel")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Tools/craft/craft_flintandsteel.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Flint and Steel", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("sheers")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Tools/craft/craft_shears.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Sheers", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("bucket")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Tools/craft/craft_shears.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Bucket", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("clock")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Tools/craft/craft_clock.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Clock", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("compass")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Tools/craft/craft_compass.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Compass", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("horse armor")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Defence/craft/craft_horsearmour.gif"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Horse Armor", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("glass bottle")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Brewing/craft/craft_glassbottle.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Glass Bottle", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("cauldren")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Brewing/craft/craft_cauldron.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Cauldron", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}
		if (e.getSource() ==(Find_It_For_Me) && word.equals("brewing stand")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Brewing/craft/craft_brewingstand.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Brewing Stand", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}       
		//----
		if (e.getSource() ==(Find_It_For_Me) && word.equals("glistering melon")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Brewing/craft/craft_glisteringmelon.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Glistering melon", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}
		//-----
		if (e.getSource() ==(Find_It_For_Me) && word.equals("blaze powder")) {
			
			
			  ImageIcon iconfen = null;
			try {
				iconfen = new ImageIcon(new URL("http://www.minecraft-crafting.net/app/src/Brewing/craft/craft_blazepowder.png"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        JOptionPane.showMessageDialog(null, "Blaze Powder", "About", JOptionPane.INFORMATION_MESSAGE, iconfen);
		
		}
		
	
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	//End of if ----------------------------------------------------------------
	}


	
}
