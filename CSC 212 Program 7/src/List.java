/*
	L i s t
	=======
*/

import java.awt.*;
import java.awt.event.*;

public class List
{
	private final							//	Defines the size and spacing
 				int SIZE = Element.HEIGHT,	//		of the cells in the list
					DELTA = 2;				//		(for drawing purposes)

	//
	//	C o n s t r u c t o r s
	//	=======================
	//
	//	By default, we will start with ... nothing.
	//
	public List()
	{										//	By default, we start
		this(143, 147);						//		at an arbitrary location
	}

	public List(int x, int y)
	{
		head = null;						//	No element at the "head", yet

		this.x = x;							//	We keep track of the location
		this.y = y;
	}

	//
	//	Determines whether the list is empty or not.
	//
	public boolean isEmpty()
	{
		return head == null;
	}

	//
	//	Adds one character to the list.
	//
	public void add(char value)
	{
		CharacterElement item;

		item = new CharacterElement(value,
									x + (int) (75 * Math.random()),
									y + 2*SIZE + (int) (300 * Math.random()),
									Color.green);

		add(item);
	}

	//
	//	Adds one integer to the list.
	//
	public void add(int value)
	{
		IntegerElement item;

		item = new IntegerElement(value,
								  x + (int) (75 * Math.random()),
								  y + 2*SIZE + (int) (300 * Math.random()),
								  Color.cyan);

		add(item);
	}

	//
	//	Adds one element to the beginning of the list of nodes,
	//		by putting a new node ahead of the current head.
	//
	protected void add(Object someItem)
	{
		Node placeHolder = new Node();

		placeHolder.setElement(someItem);

		placeHolder.setNext(head);

		head = placeHolder;
	}

	//
	//	Removes the element at the head of the list (if there is any element).
	//
	public Object remove() throws ListException
	{
		if (isEmpty())
			throw new ListException("List empty");

		Object result = head.getElement();

		head = head.getNext();

		return result;
	}

	//
	//	Paints the list of elements.
	//
	public void paint(Graphics pane)
	{
		final int SIZE = Element.HEIGHT;	//	Defines the size of the cells
											//		in a node (for drawing)

		final int DELTA = 2;				//	The offset within the box/frame

		pane.setColor(Color.black);			//	Drawing the box/frame of the list
		pane.drawRect(x, y,
					  SIZE, SIZE);

		pane.setColor(Color.black);			//	Drawing the head's cell
		pane.drawRect(x + DELTA, y + DELTA, SIZE - 2*DELTA, SIZE - 2*DELTA);
		pane.setColor(Color.gray);
		pane.fillRect(x + 2*DELTA, y + 2*DELTA,
					  SIZE - 4*DELTA + 1, SIZE - 4*DELTA + 1);

		if (head == null) {
			pane.setColor(Color.red);
			pane.drawLine(x + DELTA + 1, y + DELTA + 1,
						  x + SIZE - DELTA - 1, y + SIZE - DELTA - 1);
		}
		else {
			pane.setColor(Color.black);
			pane.drawOval(x + SIZE/2 - 1, y + SIZE/2 - 1,
						  2, 2);
			pane.drawLine(x + SIZE/2, y + SIZE/2,
						  head.getX(), head.getY() + SIZE/2);

			head.paint(pane);
		}
	}

	protected Node head;				//	A reference to the first node (if any)

	private int x, y;					//	To define the location of the list
										//		(for drawing purposes, only)
}	//end of List