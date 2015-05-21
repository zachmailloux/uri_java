import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.net.*;
	public class FinalProject extends JFrame implements ActionListener{
	
	 JButton Argonian;
	 JButton Breton;
	 JButton Elf;
	 JButton Imporial;
	 JButton Khajiat;
	 JButton Nord;
	 JButton Orc;
	 JButton Redguard;
FinalProject(String title) throws MalformedURLException {
	super(title);
	
	this.init();
	this.pack();
	this.setVisible(true);
}
		
	
	
	
	public void init() throws MalformedURLException {
	// TODO Auto-generated method stub
		int option = JOptionPane.showConfirmDialog(null, "Would you like to join the Skyrim: fire shard academy?", "Come, join us", JOptionPane.YES_NO_OPTION);
		
		if (option == 1) {
			
			JOptionPane.showMessageDialog(null, "Why not? Fine, you can quit but you are putting down a huge oppertunity.", "WHY?", JOptionPane.INFORMATION_MESSAGE);
		}
		if (option == 0) {
		
		JOptionPane.showMessageDialog(null, " Welcome to the land of the great and powerful fire shard!", " WELCOME ", JOptionPane.INFORMATION_MESSAGE);
		String name = JOptionPane.showInputDialog ("Enter Your Name");
		int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
		JOptionPane.showMessageDialog(null, "Which Race do u wish to be(Argonian, Breton, Elf, Imporial, Khajiat, Nord, Orc, Redguard)", "Race", JOptionPane.INFORMATION_MESSAGE);
		JPanel panel = new JPanel();
		ImageIcon icon1 = new ImageIcon(new URL("http://images1.wikia.nocookie.net/__cb20120220222347/wowwiki/images/b/b3/Ability_mount_feldrake.png"));
		Icon iconB = new ImageIcon(new URL("http://images3.wikia.nocookie.net/__cb20080911134357/wowwiki/images/5/58/Achievement_character_human_male.png"));
		Icon iconE = new ImageIcon(new URL("http://images1.wikia.nocookie.net/__cb20080911134135/wowwiki/images/7/71/Achievement_character_bloodelf_male.png"));
		Icon iconI = new ImageIcon(new URL("http://images1.wikia.nocookie.net/__cb20081001074958/wowwiki/images/8/84/Achievement_leader_king_varian_wrynn.png"));
		Icon iconK = new ImageIcon(new URL("http://images1.wikia.nocookie.net/__cb20120220222347/wowwiki/images/b/b3/Ability_mount_feldrake.png"));
		Icon iconN = new ImageIcon(new URL("http://images1.wikia.nocookie.net/__cb20080721045131/wowwiki/images/6/69/Ability_druid_skinteeth.png"));
		Icon iconO = new ImageIcon(new URL("http://images4.wikia.nocookie.net/__cb20070107153232/wowwiki/images/f/f5/Ability_warrior_endlessrage.png"));
		Icon iconR = new ImageIcon(new URL("http://images2.wikia.nocookie.net/__cb20091028042555/wowwiki/images/9/9b/Achievement_boss_bronjahm.png"));
		Argonian = new JButton("Argonian",icon1);
		Breton = new JButton("Breton",iconB);
		Elf = new JButton("Elf",iconE);
		Imporial = new JButton("Imporial", iconI);
		Khajiat = new JButton("Khajat",iconK);
		Nord = new JButton("Nord",iconN);
		Orc = new JButton("Orc",iconO);
		Redguard = new JButton("Redguard", iconR);
	
		Argonian.addActionListener(this);
		Breton.addActionListener(this);
		Elf.addActionListener(this);
		Imporial.addActionListener(this);
		Khajiat.addActionListener(this);
		Nord.addActionListener(this);
		Orc.addActionListener(this);
		Redguard.addActionListener(this);
		
		panel.add(Argonian);
		panel.add(Breton);
		panel.add(Elf);
		panel.add(Imporial);
		panel.add(Khajiat);
		panel.add(Nord);
		panel.add(Orc);
		panel.add(Redguard);
	
		this.add(panel);}
}

	private static final Object Object = null;
		public static void main(String[] args) throws MalformedURLException {
			// TODO Auto-generated method stub
			FinalProject Final = new FinalProject("Final Project");
			Final.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			}
		public FinalProject(){
			int option = JOptionPane.showConfirmDialog(null, "Would you like to join the Skyrim: fire shard academy?", "Come, join us", JOptionPane.YES_NO_OPTION);
			
			if (option == 1) {
				
				JOptionPane.showMessageDialog(null, "Why not? Fine, you can quit but you are putting down a huge oppertunity.", "WHY?", JOptionPane.INFORMATION_MESSAGE);
			}
			if (option == 0) {
			
			JOptionPane.showMessageDialog(null, " Welcome to the land of the great and powerful fire shard!", " WELCOME ", JOptionPane.INFORMATION_MESSAGE);
			String name = JOptionPane.showInputDialog ("Enter Your Name");
			int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
			JOptionPane.showMessageDialog(null, "Which Race do you wish to be (Argonian, Breton, Elf, Imporial, Khajiat, Nord, Orc, Redguard)", "Race", JOptionPane.INFORMATION_MESSAGE);
			//JOptionPane.showMessageDialog(null, "Welcome" + Name + "the" + )
			// MAKE PANEL HERE
			
		}
//end main

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Orc) {
			JOptionPane.showMessageDialog(this, "You're an Orc.");	
		}
		if (e.getSource() == Elf) {
			JOptionPane.showMessageDialog(this, "You're an Elf.");
		}
	
			//JOptionPane.showMessageDialoge(this, "Welcome");
	
		
		
	}
}