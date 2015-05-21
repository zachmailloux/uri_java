/*
	L i s t
	=======
*/

import java.awt.*;
import java.awt.event.*;

public class List
{
	private final							//	Defines the size of a basic cell
 				int SIZE = Element.HEIGHT;	//		(for drawing purposes)

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
	//	Determines whether the List is empty or not.
	//
	public boolean isEmpty()
	{
		return head == null;
	}

	//
	//	Pushes one character to the list.
	//
	public void add(char value)
	{
		CharacterElement item;

		item = new CharacterElement(value,
									x + (int) (75 * Math.random()),
									y + 2*SIZE + (int) (250 * Math.random()),
									Color.green);

		add(item);
	}

	//
	//	Pushes one integer to the list.
	//
	public void add(int value)
	{
		IntegerElement item;

		item = new IntegerElement(value,
								  x + (int) (75 * Math.random()),
								  y + 2*SIZE + (int) (250 * Math.random()),
								  Color.cyan);

		add(item);
	}

	//
	//	Adds one element to the top of the List of nodes,
	//		by putting a new node ahead of the current head.
	//
	protected void add(Element someItem)
	{
		Node placeHolder = new Node();

		placeHolder.setElement(someItem);

		placeHolder.setNext(head);

		head = placeHolder;
	}

	//
	//	Pops the element at the top of the List (if there is any element).
	//
	public Element remove() throws ListException
	{
		if (isEmpty())
			throw new ListException("List empty");

		Element result = head.getElement();

		head = head.getNext();

		return result;
	}

	//
	//	Reverses the order of the elements in the List.
	//


		
	public void reverse() {
	    Node previous = head; //keep track of the head
	    Node current =head.getNext(); //get the one after the head
	    head.setNext(null); //set the head equal to null
	
	    while(current != null) {     //while the current node exists   
	
	        Node next = current.getNext(); //set the next node equal to the node after the current one
	        current.setNext(previous);   //set currents next equal to the previous one    
	        
	        previous = current;  //UPDATE NODES FOR THE LOOP //shift them 
	        head = current;   //set the new head to the current
	        current = next; //set the current to the next
	
	    }
	
	}
		
	

	//
	//	Paints the List of elements.
	//
	public void paint(Graphics pane)
	{
		final int SIZE = Element.HEIGHT;	//	Defines the size of the cells
											//		in a node (for drawing)

		final int DELTA = 2;				//	The offset within the box/frame

		pane.setColor(Color.black);			//	Drawing the box/frame of the List
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

	private Node head;					//	A reference to the first node (if any)

	private int x, y;					//	To define the location of the list
										//		(for drawing purposes, only)
}