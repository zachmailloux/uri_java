/*
	Node.java


import java.awt.*;
import java.awt.event.*;

import javax.lang.model.element.Element;

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

		x = 275 + (int) (175 * Math.random());
		y = 50 + (int) (375 * Math.random());
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
	public void setElement(Comparable someElement)
	{
		element = someElement;
	}

	//
	//	The following access method returns the element in the node
	//
	public Comparable getElement()
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
		//	For the purpose of drawing the Node, we must "materialize"
		//		the element in the node as an actual Element (in order

		
	}

	//
	//	The instance variables
	//
											//	A node is made up of
	private	Comparable element;				//		a reference to an element
											//		(which must be comparable), and
	private Node next;						//		a reference to the next node

	protected int x, y;						//	The location of the node
	protected Color color;					//		its color, and
	protected boolean hilite = true;		//		whether it is hilighted or not

	//	NOTE:	The location of the node is defined as the top left corner of
	//			the box/frame used to display the node (i.e., element + next).

}	//	end of Node*/