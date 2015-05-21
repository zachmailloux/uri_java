
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

public class InvisButton extends Abutton{

	public InvisButton(String string, Color someColor, int someX, int someY,
			int someWidth, int someHeight) {
		label = string;
		x = someX;
		y = someY;
		highColor = someColor;
		width = someWidth;
		height = someHeight;
		setShape();
		// TODO Auto-generated constructor stub
	}
	public void setShape(){
		shape = new Rectangle(x, y, width, height);
	}
	public void paint(Graphics pane){
	//	pane.setColor(highColor);
	//	pane.fillRect(x,y, width, height);
		Graphics2D pane2 = (Graphics2D)pane; //So we can work with arbitrary shapes
		pane2.setColor(highColor); //Is the button up or down?
		int labelWidth = pane2.getFontMetrics().stringWidth(label);
		int labelHeight = pane2.getFontMetrics().getAscent();
		pane2.drawString(label,
				x + (width - labelWidth)/2,
				y + (height + labelHeight)/2);
	}
}
