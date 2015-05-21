import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.*;
import java.awt.Shape;


public class OvalShape extends Abutton{

	public OvalShape(String someLabel,
			   Color someColor,
			   int someX, int someY,
			   int someWidth, int someHeight) {
		label = someLabel;
		x = someX;
		y = someY;
		highColor = someColor;
		width = someWidth;
		height = someHeight;
		setShape();
		up = true;							//	Initially, the button is up
		lowColor = highColor.darker(); 
	}
		
		// TODO Auto-generated constructor stub

public void setShape(){
	shape = new Ellipse2D.Double(x, y, width, height);		
	
	}
	public void paint(Graphics pane){
			//pane.setColor(highColor);
			//pane.fillOval(x,y, width, height);
			Graphics2D pane2 = (Graphics2D)pane; //So we can work with arbitrary shapes
			pane2.setColor(up? highColor: lowColor); //Is the button up or down?
			pane2.fill(shape);
			pane2.setColor(Color.black);
			pane2.draw(shape); //button border
			int labelWidth = pane2.getFontMetrics().stringWidth(label);
			int labelHeight = pane2.getFontMetrics().getAscent();
			pane2.drawString(label,
							x + (width - labelWidth)/2,
							y + (height + labelHeight)/2);
	
	}
}
