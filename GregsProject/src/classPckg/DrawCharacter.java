package classPckg;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawCharacter extends JPanel{

	String class_;
	int anim;
	int posX;
	int posY;
	
	public void paint (Graphics g){
		
	}
	
	public void setAnim(int a){
		anim = a;
	}
	
	DrawCharacter(String cl, int x, int y){
		class_ = cl;
		posX = x;
		posY = y;
	}
	
	public void setClass(String cl){
		class_ = cl;
	}
}
