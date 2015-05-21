package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends myShape{

	public Oval(){
		super();
	
	}

	public Oval(int x, int y, int width, int height){
		super(x,y,width,height);
		
	}

	public void setColor(Color someColor){
		color = someColor;
	}

	public void paint(Graphics pane) {
		pane.setColor(color);
		pane.fillOval(x, y, width, height);
		pane.drawOval(x, y, width, height);
		super.paint(pane);
	}

}
