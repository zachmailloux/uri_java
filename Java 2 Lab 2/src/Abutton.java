/*
	Author:	Fleury

	File:	Abutton.java
*/

import java.awt.*;

public class Abutton
{
	public final static int					//	To define the size of our buttons
				BUTTON_WIDTH = 64,
				BUTTON_HEIGHT = BUTTON_WIDTH / 2;

	//
	//	Default constructor.
	//
	public Abutton()
	{										//	By default, we create a button
		this("?????",						//		with a questionable label,
			 Color.black,					//		in plain black
			 43, 47,						//		at an arbitrary location,
			 143, 147);						//		and with an arbitrary size,
	}

	//
	//	Most specific constructor.
	//
	public Abutton(String someLabel,
				   Color someColor,
				   int someX, int someY,
				   int someWidth, int someHeight)
	{										//	We create a button
		setup(someLabel,					//		with a given label,
			  someColor,					//		in a given color
			  someX, someY,					//		at a given location,
			  someWidth, someHeight);		//		and with a given size,
	}

	//
	//	Initializes (or re-sets) the components of a button.
	//
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
		up = true;							//	Initially, the button is up
	}

	//
	//	Flips the up/down state of a button
	//
	public void flip()
	{
		up = ! up;
	}

	//
	//	Determines if a given point is inside a button.
	//	Note:  The boundary is considered within (inside) the button.
	//
	public boolean isInside(int someX, int someY)
	{
		return ((someX >= x) && (someX <= x + width)
				&& (someY >= y) && (someY <= y + height));								//	*****
	}

	//
	//	Draws/paints the button
	//
	public void paint(Graphics pane)
	{
		final int DELTA = 2;				//	To define the space between the
											//		frame and the inside of a button

		pane.setColor(Color.black);			//	Drawing the button frame
		pane.drawRect(x, y, width, height);	//		in black,

		pane.setColor(color);				//		and the inside of the button
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