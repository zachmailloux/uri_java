/*
	Node.java

	This class provides for the implementation of a node of a binary tree. 
*/

import java.awt.*;
import java.awt.event.*;

public class Node
{
	//
	//	C o n s t r u c t o r s :
	//	=========================
	//
	//	The default constructor creates an "empty" node at a random location
	//
	public Node()
	{
		this(275 + (int) (175 * Math.random()),
			  50 + (int) (375 * Math.random()),
			 Color.gray);
	}

	//
	//	The following constructor creates an empty node at a given location
	//
	public Node(int someX, int someY, Color someColor)
	{
		item = null;
		left = right = null;

		x = someX;
		y = someY;
		color = someColor;
		hilite = true;
	}

	//
	//	The following access methods sets/returns the item in the node
	//
	public void setItem(Object someItem)
	{
		item = someItem;
	}

	public Object getItem()
	{
		return item;
	}

	//
	//	The following access methods sets/returns the link to the left sub-tree
	//
	public void setLeft(Node someNode)
	{
		left = someNode;
	}

	public Node getLeft()
	{
		return left;
	}

	//
	//	The following access methods sets/returns the link to the right sub-tree
	//
	public void setRight(Node someNode)
	{
		right = someNode;
	}

	public Node getRight()
	{
		return right;
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
		//	For the purpose of drawing the Node, we must "materialize"
		//		the element in the node as an actual Element (in order
		//		to access its location, paint method, etc.)

		Element item = (Element) this.item;	//	Explicit casting

		final int SIZE = Element.HEIGHT;	//	Defines the size of the cells
											//		in a node (for drawing)

		final int DELTA = 2;				//	The offset within the box/frame

		pane.setColor(Color.black);			//	Drawing the box/frame of the node
		pane.drawRect(x, y,
					  3*SIZE - 2*DELTA, SIZE);

		pane.setColor(Color.black);			//	Drawing the item's cell
		pane.drawRect(x + DELTA, y + DELTA, SIZE - 2*DELTA, SIZE - 2*DELTA);
		pane.setColor(color);
		pane.fillRect(x + 2*DELTA, y + 2*DELTA,
					  SIZE - 4*DELTA + 1, SIZE - 4*DELTA + 1);
		pane.setColor(Color.black);
		pane.drawOval(x + SIZE/2 - 1, y + SIZE/2 - 1,
					  2, 2);
		pane.setColor(Color.yellow);
		pane.drawLine(x + SIZE/2, y + SIZE/2,
					  item.getX() + item.WIDTH, item.getY() + item.HEIGHT/2);
		item.paint(pane);					//	Then drawing the element in question
											//		and an arrow (or pointer)
											//		between the cell and the element

		pane.setColor(Color.black);			//	Drawing the left link's cell
		pane.drawRect(x + SIZE, y + DELTA, SIZE - 2*DELTA, SIZE - 2*DELTA);
		pane.setColor(color);
		pane.fillRect(x + SIZE + DELTA, y + 2*DELTA,
					  SIZE - 4*DELTA + 1, SIZE - 4*DELTA + 1);
		if (left == null) {
			pane.setColor(Color.red);
			pane.drawLine(x + SIZE + 1, y + DELTA + 1,
						  x + 2*SIZE - 2*DELTA - 1, y + SIZE - DELTA - 1);
		}
		else {
			pane.setColor(Color.black);
			pane.drawOval(x + 3*SIZE/2 - DELTA - 1, y + SIZE/2 - 1,
						  2, 2);
			pane.drawLine(x + 3*SIZE/2 - DELTA, y + SIZE/2,
						  left.getX(), left.getY() + SIZE/2);

			left.paint(pane);
		}

		pane.setColor(Color.black);			//	Drawing the right link's cell
		pane.drawRect(x + 2*SIZE - DELTA, y + DELTA, SIZE - 2*DELTA, SIZE - 2*DELTA);
		pane.setColor(color);
		pane.fillRect(x + 2*SIZE, y + 2*DELTA,
					  SIZE - 4*DELTA + 1, SIZE - 4*DELTA + 1);
		if (right == null) {
			pane.setColor(Color.red);
			pane.drawLine(x + 2*SIZE - DELTA + 1, y + DELTA + 1,
						  x + 3*SIZE - 3*DELTA - 1, y + SIZE - DELTA - 1);
		}
		else {
			pane.setColor(Color.black);
			pane.drawOval(x + 5*SIZE/2 - 2*DELTA - 1, y + SIZE/2 - 1,
						  2, 2);
			pane.drawLine(x + 5*SIZE/2 - 2*DELTA, y + SIZE/2,
						  right.getX(), right.getY() + SIZE/2);

			right.paint(pane);
		}
	}

	//
	//	The instance variables
	//
											//	A node is made up of
	private	Object item;					//		a reference to an item
											//		(which must be comparable), and
	private Node left,						//		2 references to the left
				 right;						//		and the right sub-trees

	protected int x, y;						//	The location of the node
	protected Color color;					//		its color, and
	protected boolean hilite = true;		//		whether it is hilighted or not

	//	NOTE:	The location of the node is defined as the top left corner of
	//			the box/frame used to display the node (i.e., element + next).

}	//	end of Node