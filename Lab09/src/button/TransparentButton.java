package button;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;

public class TransparentButton extends AButton {
	
	/**
	 * Default constructor automatically calls default constructor of parent
	 */
	public TransparentButton(){}
	
	/**
	 * This constructor lets the parent class set the attributes, except the shape
	 * @param someLabel button label
	 * @param someColor button's color
	 * @param someX upper left x coordinate
	 * @param someY upper left y coordinate
	 * @param someWidth button width
	 * @param someHeight button height
	 */
	public TransparentButton(String someLabel,
			   Color someColor,
			   int someX, int someY,
			   int someWidth, int someHeight)
	{										//	We create a button
		super(someLabel,					//		with a given label,
		  someColor,					//		in a given color
		  someX, someY,					//		at a given location,
		  someWidth, someHeight);		//		and with a given size,
		setShape();
	}
	
	/**
	 * Since we can't see it, it doesn't really matter what shape it is,
	 * so let's keep it simple.
	 */
	public void setShape(){
		shape = new Rectangle(x, y, width, height);
	}
	
	/**
	 * We paint only the label since the button is transparent.
	 */
	public void paint(Graphics pane){
		pane.setColor(up? highColor: lowColor);
		int labelWidth = pane.getFontMetrics().stringWidth(label);
		int labelHeight = pane.getFontMetrics().getAscent();
		pane.drawString(label,
						x + (width - labelWidth)/2,
						y + (height + labelHeight)/2);
	}

}
