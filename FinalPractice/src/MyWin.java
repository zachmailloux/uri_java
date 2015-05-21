import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.BorderFactory;

public class MyWin extends JFrame implements ActionListener{
//Global Components
	JLabel pic;
	ImageIcon icon1;
	JButton create;
	int nlevel;
	JTextField iName;
	JTextField iLevel;
	JLabel lhp;
	JLabel lhp5;
	JLabel lmp;
	JLabel lmp5;
	JLabel lad;
	JLabel las;
	JLabel lmr;
	JLabel larmor;
	JLabel lms;
	double chp, rhp2;
	double chp5, rhp52;
	double cmp, rmp2;
	double cmp5, rmp52;
	double cad, rad2;
	double cas, ras2;
	double cmr, rmr2;
	double carmor, rarmor2;
	double cms;
	double speedOut;
	double hRegen;
	double mRegen;
	//Constructor
	MyWin(String charpic) throws MalformedURLException {
		
		super("ChampStats Alpha");
		//this.pack();
		this.setSize(300, 500);
		icon1 = new ImageIcon(new URL(charpic));
		this.setResizable(true);
		this.setVisible(true);
	}//end Constructor
	
	
	//Declare Variables
	void init(String name, double hp, double rhp, double hp5, double rhp5, double mp, double rmp, double mp5, double rmp5, double ad, double rad, double as, double ras, double mr, double rmr, double armor, double rarmor, double ms, int level) {
		chp=hp;
		rhp2=rhp;
		
		chp5=hp5;
		rhp52=rhp5;
		
		rmp2=rmp;
		cmp=mp;
		
		cmp5=mp5;
		rmp52=rmp5;
		
		cad=ad;
		rad2=rad;
		
		cas=as;
		ras2=ras;

		cmr=mr;
		rmr2=rmr;

		carmor=armor;
		rarmor2=rarmor;

		cms=ms;
		String cName=name;
		nlevel = level;
		NumberFormat attackSpeed = NumberFormat.getPercentInstance();
		attackSpeed.format(as);
		
		DecimalFormat df = new DecimalFormat("#.###");
	
		
		//int level=1;   Temp Level (Until choice created)
			
		
			speedOut = cas+(ras*(level-1));
			hRegen = chp5+(rhp5*(level-1));
			speedOut = Double.valueOf(df.format(speedOut));
			hRegen = Double.valueOf(df.format(hRegen));
			
			
			pic = new JLabel(icon1);
		 	iName = new JTextField(15);
			JLabel lName = new JLabel("Champion: ", JLabel.CENTER);
		 	iLevel = new JTextField(2);
			JLabel lLevel = new JLabel("Level: ", JLabel.CENTER);
		 	
			lhp = new JLabel("Health: "+(chp+(rhp*(level-1))), JLabel.CENTER);
		 	lhp5 = new JLabel("Health Regen: "+ hRegen,  JLabel.CENTER);
	        lmp = new JLabel("Mana: "+(cmp+(rmp*(level-1))), JLabel.CENTER);
		 	lmp5 = new JLabel("Mana Regen: "+(cmp5+(rmp5*(level-1))), JLabel.CENTER);
	        lad = new JLabel("Attack Damage: "+(cad+(rad*(level-1))), JLabel.CENTER);
	        las = new JLabel("Attack Speed: "+ speedOut, JLabel.CENTER);
	        lmr = new JLabel("Magic Resist: "+(cmr+(rmr*(level-1))), JLabel.CENTER);
	        larmor = new JLabel("Armor: "+Math.round(carmor+(rarmor*(level-1))), JLabel.CENTER);
	        lms = new JLabel("Movement Speed: "+cms, JLabel.CENTER);
	        
	        JPanel panel = new JPanel(new GridLayout(13, 6));
	        
	        panel.add(lName);
	        panel.add(iName);
	        panel.add(lLevel);
	        panel.add(iLevel);
	        panel.add(lhp);
	        panel.add(lhp5);
	        panel.add(lmp);
	        panel.add(lmp5);
	        panel.add(lad);
	        panel.add(las);
	        panel.add(lmr);
	        panel.add(larmor);
	        panel.add(lms);
	        
	        
	        //Options Panel
	        create = new JButton("Create");
	        JButton clear = new JButton("Clear");
	        //JButton blank1 = new JButton("");
	        JButton item = new JButton("Add Item");
	       // JButton blank2 = new JButton("");
	        
	       create.addActionListener(this);
	        clear.addActionListener(this);
	        
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.add(create);
	        buttonPanel.add(clear);
	        buttonPanel.add(item);
	        buttonPanel.add(pic);	        
	        
	        this.setLayout(new BorderLayout());
	        
	        this.add(panel, BorderLayout.NORTH);
	        this.add(buttonPanel, BorderLayout.SOUTH);
	        this.add(item, BorderLayout.CENTER);
	       // this.add(item, BorderLayout.CENTER);
	        
	        this.add(panel);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==create){
			nlevel = Integer.parseInt(iLevel.getText());
			if(nlevel>18){
				nlevel=18;
			}
			String choice=iName.getText();
			if(choice.equalsIgnoreCase("elise")){
				
				MyWin Elise = null;
				try {
					Elise = new MyWin("http://images.wikia.com/leagueoflegends/images/9/91/EliseSquare.png");
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Elise.init("Elise", 395, 80, 4.7, 0.6, 240, 50, 6.8, 0.65, 47.5, 3, 0.625, 0.0175, 30, 0, 12.65, 3.35, 335,nlevel);
				Elise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				close();
			}
			if(choice.equalsIgnoreCase("nasus")){
				MyWin Nasus = null;
				try {
					Nasus = new MyWin("http://images.wikia.com/leagueoflegends/images/5/58/NasusSquare.png");
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Nasus.init("Nasus", 410, 90, 7.5, 0.9, 200, 45, 6.6, 0.5, 53.3, 3.5, 0.638, 0.0348, 30, 1.25, 15, 3.5, 350, nlevel);
				Nasus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				close();
			}
			if(choice.equalsIgnoreCase("jayce")){
				MyWin Jayce = null;
				try {
					Jayce = new MyWin("http://images.wikia.com/leagueoflegends/images/a/aa/JayceSquare.png");
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Jayce.init("Jayce", 420, 90, 6, 0.8, 240, 40, 7, 0.7, 46.5, 3.5, 0.658, 0.03, 30, 0, 12.5, 3.5, 335, nlevel);
				Jayce.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
			refresh();}
	}
	public void refresh(){
		DecimalFormat df = new DecimalFormat("#.###");
		speedOut = cas+(ras2*(nlevel-1));
		hRegen = chp5+(rhp52*(nlevel-1));
		mRegen = cmp5+(rmp52*(nlevel-1));
		speedOut = Double.valueOf(df.format(speedOut));
		hRegen = Double.valueOf(df.format(hRegen));
		mRegen = Double.valueOf(df.format(mRegen));
		lhp.setText("Health: "+(chp+(rhp2*(nlevel-1))));
		lhp5.setText("Health Regen: "+ hRegen);
		lmp.setText("Mana: "+(cmp+(rmp2*(nlevel-1))));
		lmp5.setText("Mana Regen: "+ mRegen);
		lad.setText("Attack Damage: "+(cad+(rad2*(nlevel-1))));
		las.setText("Attack Speed: "+ speedOut);
		lmr.setText("Magic Resist: "+(cmr+(rmr2*(nlevel-1))));
		larmor.setText("Armor: "+Math.round(carmor+(rarmor2*(nlevel-1))));
		lms.setText("Movement Speed: "+cms);
		
	}
	public void close(){
		this.setVisible(false);
	}
	
}
