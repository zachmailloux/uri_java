/**
 * @author Daniel Dides
 * The Button class does everything to do with the Buttons. It draws them, 
 * flips them and gets the x,y coordinates to see if the click is inside them. 
 */

import java.awt.*;


public class Buttons {


	public Buttons()
	{
		this("???",
				Color.green,
				43,47, 
				143, 147);
	}

	public Buttons(String someLabel,
			Color someColor,
			int someX, int someY,
			int someWidth, int someHeight)
	{										//	We create a button
		setup(someLabel,					//		with a given label,
				someColor,					//		in a given color
				someX, someY,				//		at a given location,
				someWidth, someHeight);		//		and with a given size,
	}


	public void setup(String someLabel,
			Color someColor,
			int someX, int someY,
			int someWidth, int someHeight)
	{
		label = someLabel;
		color = someColor;
		x = someX;
		y = someY;
		width = someWidth;
		height = someHeight;
		up = true;							//	Initially, the button is not up
	}

	public void flip()
	{
		up = !up;

	}

	public boolean isInside(int someX, int someY)
	{
		return(someX>=x && someX<=(x+width) && someY>=y && someY <=(y+height));		
	}

	public void paint(Graphics pane)
	{
		final int DELTA = 2;					//		To define the space between the
												//		frame and the inside of a button

		pane.setColor(Color.black);				//		Drawing the button frame
		pane.drawRect(x, y, width, height);		//		in black,

		pane.setColor(color);					//		and the inside of the button
		pane.fill3DRect(x + DELTA, y + DELTA,	//	in the given color
				width - (2*DELTA - 1),
				height - (2*DELTA - 1),
				up);

		pane.setColor(Color.black);			//	Finally, we put the label in black
		//		... and nicely centered
		int labelWidth = pane.getFontMetrics().stringWidth(label);
		int labelHeight = pane.getFontMetrics().getAscent();
		pane.drawString(label,
				x + (width - labelWidth)/2,
				y + (height + labelHeight)/2);
	}

	private String label;					//	To hold the label,
	private Color color;					//		the color,
	private int x, y,						//		the location,
	width, height;				//		and the size of the button

	private boolean up;						//	To know if the button is up or not
}

