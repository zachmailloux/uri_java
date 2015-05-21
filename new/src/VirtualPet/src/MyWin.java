import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyWin extends JFrame implements ActionListener{
	JTextField name, type, color, calories;
	JButton create, clear;
	MyWin(String title){
		super(title);
		this.init();
		//this.setSize(400,650);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
	void init(){
		JLabel lname = new JLabel ("Name:");
		JLabel ltype = new JLabel("Type:");
		JLabel lcolor = new JLabel("Color:");
		JLabel lcalories = new JLabel("Calories:");
		
		name = new JTextField(10);
		type = new JTextField(10);
		color = new JTextField(10);
		calories = new JTextField(10);
		
		JPanel panel = new JPanel(new GridLayout(4,2));
		panel.add(lname);
		panel.add(name);
		panel.add(ltype);
		panel.add(type);
		panel.add(lcolor);
		panel.add(color);
		panel.add(lcalories);
		panel.add(calories);
		
		create = new JButton("Create");
		clear = new JButton("Clear");
		
		create.addActionListener(this);
		clear.addActionListener(this);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(create);
		buttonPanel.add(clear);
		
		this.setLayout(new BorderLayout());
		
		this.add(panel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == create){
			
			Pet myPet = new Pet(name.getText(), type.getText(), color.getText());
			myPet.setCalories(Integer.parseInt(calories.getText()));
			
			JOptionPane.showMessageDialog(this, "Your pet has been created.");
		}
		else {
			name.setText(" ");
			type.setText(" ");
			color.setText(" ");
			calories.setText(" ");
		}
		
	}
}