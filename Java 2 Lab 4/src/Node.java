/*
	Node.java
*/

import java.awt.*;
import java.awt.event.*;

public class Node
{
	//
	//	Constructors:
	//	=============
	//
	//	The default constructor creates an "empty" node at a random location
	//
	public Node()
	{
		element = null;
		next = null;

		x = 250 + (int) (150 * Math.random());
		y = 25 + (int) (300 * Math.random());
		color = Color.gray;
		hilite = true;
	}

	//
	//	The following constructor creates an empty node at a given location
	//
	public Node(int someX, int someY, Color someColor)
	{
		element = null;
		next = null;

		x = someX;
		y = someY;
		color = someColor;
		hilite = true;
	}

	//
	//	The following access method sets the element in the node
	//
	public void setElement(Element someElement)
	{
		element = someElement;
	}

	//
	//	The following access method returns the element in the node
	//
	public Element getElement()
	{
		return element;
	}

	//
	//	The following access method sets the next node following this node
	//
	public void setNext(Node someNode)
	{
		next = someNode;
	}

	//
	//	The following access method returns the next node of this node
	//
	public Node getNext()
	{
		return next;
	}

	//
	//	The following access method resets the location of a node
	//
	public void setLocation(int someX, int someY)
	{
		x = someX;
		y = someY;
	}

	//
	//	The following access methods return the location of a node
	//
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}

	//
	//	Paints a node
	//
	public void paint(Graphics pane)
	{
		final int SIZE = Element.HEIGHT;	//	Defines the size of the cells
											//		in a node (for drawing)

		final int DELTA = 2;				//	The offset within the box/frame

		pane.setColor(Color.black);			//	Drawing the box/frame of the node
		pane.drawRect(x, y,
					  2*SIZE - DELTA, SIZE);

		pane.setColor(Color.black);			//	Drawing the element's cell
		pane.drawRect(x + DELTA, y + DELTA, SIZE - 2*DELTA, SIZE - 2*DELTA);
		pane.setColor(color);
		pane.fillRect(x + 2*DELTA, y + 2*DELTA,
					  SIZE - 4*DELTA + 1, SIZE - 4*DELTA + 1);
		pane.setColor(Color.black);
		pane.drawOval(x + SIZE/2 - 1, y + SIZE/2 - 1,
					  2, 2);
		pane.setColor(Color.yellow);
		pane.drawLine(x + SIZE/2, y + SIZE/2,
					  element.getX() + element.WIDTH, element.getY() + element.HEIGHT/2);
		element.paint(pane);				//	Then drawing the element in question
											//		and an arrow (or pointer)
											//		between the cell and the element

		pane.setColor(Color.black);			//	Drawing the next node's cell
		pane.drawRect(x + SIZE, y + DELTA, SIZE - 2*DELTA, SIZE - 2*DELTA);
		pane.setColor(color);
		pane.fillRect(x + SIZE + DELTA, y + 2*DELTA,
					  SIZE - 4*DELTA + 1, SIZE - 4*DELTA + 1);
		if (next == null) {
			pane.setColor(Color.red);
			pane.drawLine(x + SIZE + 1, y + DELTA + 1,
						  x + 2*SIZE - 2*DELTA - 1, y + SIZE - DELTA - 1);
		}
		else {
			pane.setColor(Color.black);
			pane.drawOval(x + 3*SIZE/2 - DELTA - 1, y + SIZE/2 - 1,
						  2, 2);
			pane.drawLine(x + 3*SIZE/2 - DELTA, y + SIZE/2,
						  next.getX(), next.getY() + SIZE/2);

			next.paint(pane);
		}
	}

	//
	//	The instance variables
	//
											//	A node is made up of
	private	Element element;				//		a reference to an element, and
	private Node next;						//		a reference to the next node

	protected int x, y;						//	The location of the node
	protected Color color;					//		its color, and
	protected boolean hilite = true;		//		whether it is hilighted or not

	//	NOTE:	The location of the node is defined as the top left corner of
	//			the box/frame used to display the node (i.e., element + next).

}	//	end of Node