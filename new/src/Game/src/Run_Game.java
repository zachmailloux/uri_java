//TODO: Bouncing physics, Spawn as one glitch, High score, Solid high score box

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Run_Game extends JPanel implements ActionListener, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Define variables
	Rect rect1 = new Rect(200 + (int)(Math.random() * ((550 - 200) + 1)), 150 + (int)(Math.random() * ((330 - 150) + 1)));
	Rect rect2 = new Rect(200 + (int)(Math.random() * ((540 - 200) + 1)), 150 + (int)(Math.random() * ((320 - 150) + 1)));
	Rect pr = new Rect(0,0);
	Timer tm = new Timer(5, this);
	int velX = 0, velY = 0;
	int points;
	int highscore;
	int jail;
	String name;
	boolean collision;
	//Message boxes
	{
	name = JOptionPane.showInputDialog("What is your name?");
	JOptionPane.showMessageDialog(null, "Welcome, " + name + ". You are the red square, and are having a very bad day. Your goal is to ruin the day of your nemesis, the happy green square, over and over again. You gain 1 point every time you ruin his day. But be careful! If the blue policeman square catches you, you'll spend a day in jail, and he'll take away all your points!", "Instructions", JOptionPane.INFORMATION_MESSAGE);
	}
	//KeyListener+Timer
	public Run_Game(){
		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	//Paint
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.clearRect(0,0,600,400);
		//Protagonist
		g.setColor(Color.RED);
		g.fillRect(pr.rx, pr.ry, 40, 40);
		
		//Nemesis	
		g.setColor(Color.GREEN);
		g.fillRect(rect1.rx, rect1.ry, 30, 30);
		
		//Cop
		g.setColor(Color.BLUE);
		g.fillRect(rect2.rx, rect2.ry, 50, 50);
		
		//Points outline
		g.setColor(Color.BLACK);
		g.drawRect(-5,334,175,120);
		
		//Points
		
		g.drawString("High score: " + highscore, 0, 370);
		g.drawString("Days in jail: " + jail, 0, 358);
		g.drawString("Days ruined: " + points, 0, 346);
		
		tm.start();
	}
	//Boundaries for Protagonist
	public void actionPerformed(ActionEvent e){
		if(pr.rx < 0){
			velX=0;
			pr.rx=0;
		}
		if(pr.rx > 555){
			velX=0;
			pr.rx=555;
		}
		if(pr.ry < 0){
			velY=0;
			pr.ry=0;
		}
		if(pr.ry > 335){
			velY=0;
			pr.ry=335;
		}
		
		rect1.move();
		rect2.moveCop();
		
		pr.rx = pr.rx + velX;
		pr.ry = pr.ry + velY;
		//Repaint - points++
		if(checkCollision() == true);
			repaint();
		//Repaint - points=0
		if(checkCollisionCop() == true);
			repaint();
		//Repaint - two other squares
		if(checkCollisionOther() == true);
			repaint();
		}
	//Movement for Protagonist
	public void keyPressed(KeyEvent e){
		int c = e.getKeyCode();
		
		if(c == KeyEvent.VK_LEFT){
			velX = -2;
			velY = 0;
		}
		
		if(c == KeyEvent.VK_RIGHT){
			velX = 2;
			velY = 0;
		}
		if(c == KeyEvent.VK_UP){
			velX = 0;
			velY = -2;
		}
		if(c == KeyEvent.VK_DOWN){
			velX = 0;
			velY = 2;
		}
	}
	
	public void keyTyped(KeyEvent e){}
	
	public void keyReleased(KeyEvent e){
		int c = e.getKeyCode();
		
		if(c == KeyEvent.VK_DOWN || c == KeyEvent.VK_UP){
			velY = 0;
		}
		if(c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_LEFT){
			velX = 0;
		}
	}
	//Checking for collision between Protagonist and Nemesis
	public boolean checkCollision() {
        Rectangle r1 = pr.getBoundsProtagonist();
        Rectangle r2 = rect1.getBoundsNemesis();
        
        if (r1.intersects(r2)){
        	collision = true;
        	points++;
        	rect1.rx = 200 + (int)(Math.random() * ((550 - 200) + 1));
        	rect1.ry = 150 + (int)(Math.random() * ((330 - 150) + 1));
        }
        else
        	collision = false;
		return collision;
		
}
	//Checking for collision between Protagonist and Cop
	public boolean checkCollisionCop() {
        Rectangle r1 = pr.getBoundsProtagonist();
        Rectangle r2 = rect2.getBoundsCop();
        
        if (r1.intersects(r2)){
        	collision = true;
        	if(points>highscore){
        		highscore = points;
        	}
        	points = 0;
        	jail++;
        	rect2.rx = 200 + (int)(Math.random() * ((540 - 200) + 1));
        	rect2.ry = 150 + (int)(Math.random() * ((320 - 150) + 1));
        	pr.rx = 0;
        	pr.ry = 0;
        }
        else
        	collision = false;
		return collision;
	}
	//Checking for collision between Nemesis and Cop
	public boolean checkCollisionOther() {
        Rectangle r1 = rect1.getBoundsNemesis();
        Rectangle r2 = rect2.getBoundsCop();
        
        if (r1.intersects(r2)){
        	collision = true;
        	rect1.velRY = -rect1.velRY;
        	rect1.velRX = -rect1.velRX;
        	rect2.velRY = -rect2.velRY;
        	rect2.velRX = -rect2.velRX;
       	}
        else
        	collision = false;
		return collision;		
	}
	//Run game
	public static void main(String[] args){
		
		Run_Game t = new Run_Game();
		JFrame jf = new JFrame();
		jf.setTitle("Run Game");
		jf.setSize(600,400);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);

	} 
}
