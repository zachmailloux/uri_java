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
		Duck = null;
		next = null;
		// the x and y coordinates are random so that it will have a random location for the item (duck) in the linked list
		x = 275 + (int) (175 * Math.random());
		y = 50 + (int) (375 * Math.random());
		color = Color.gray;
		duckHit = true;
	}

	//
	//	The following constructor creates an empty node at a given location
	//
	public Node(int someX, int someY)
	{
		Duck = null;
		next = null;

		x = someX;
		y = someY;
		duckHit = true;
	}

	//
	//	The following access method sets the Duck in the node
	//
	public void setDuck(Target someDuck)
	{
		Duck = someDuck;
	}

	//
	//	The following access method returns the Duck in the node
	//
	public Target getDuck()
	{
		return Duck;
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
	//	The following method lets you know if you're inside the duck
	//
	public boolean isInside(int someX, int someY){
		return Duck.isInside(x, y);
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
		//		the Duck in the node as an actual Duck (in order
		//		to access its location, paint method, etc.)
		Duck.fly(pane);
		
	}

	//
	//	The instance variables
	//
											//	A node is made up of
	private	Target Duck;					//		a reference to an Duck
	private Node next;						//		a reference to the next node

	protected int x, y;						//	The location of the node
	protected Color color;					//		its color, and
	protected boolean duckHit = true;		//		whether it is hilighted or not

	//	NOTE:	The location of the node is defined as the top left corner of
	//			the box/frame used to display the node (i.e., Duck + next).

}	//	end of Node