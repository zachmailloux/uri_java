package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends myShape{

	public Rect(){
		super();
		
	}

	public Rect(int x, int y, int width, int height){
		super();
		
	}


	public void paint(Graphics pane) {
		pane.setColor(color);
		pane.fillRect(x, y, width, height);
		pane.drawRect(x, y, width, height);
		super.paint(pane);
	}

}
