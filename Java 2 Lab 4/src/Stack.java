/*
	S t a c k
	=========
	
	Student: Zachary Mailloux
	Date: 10/7/13
	
*/

import java.awt.*;
import java.awt.event.*;

public class Stack
{
	private final							//	Defines the size of a basic cell
 				int SIZE = Element.HEIGHT;	//		(for drawing purposes)

	//
	//	C o n s t r u c t o r s
	//	=======================
	//
	//	By default, we will start with ... nothing.
	//
	public Stack()
	{										//	By default, we start
		this(143, 147);						//		at an arbitrary location
	}

	public Stack(int x, int y)
	{
		head = null;						//	No element at the "head", yet

		this.x = x;							//	We keep track of the location
		this.y = y;
	}

	//
	//	Determines whether the stack is empty or not.
	//
	public boolean isEmpty()
	{
		return head == null;
	}

	//
	//	Pushes one character to the list.
	//
	public void push(char value)
	{
		CharacterElement item;

		item = new CharacterElement(value,
									x + (int) (75 * Math.random()),
									y + 2*SIZE + (int) (250 * Math.random()),
									Color.green);

		push(item);
	}

	//
	//	Pushes one integer to the list.
	//
	public void push(int value)
	{
		IntegerElement item;

		item = new IntegerElement(value,
								  x + (int) (75 * Math.random()),
								  y + 2*SIZE + (int) (250 * Math.random()),
								  Color.cyan);

		push(item);
	}

	//
	//	Adds one element to the top of the stack of nodes,
	//		by putting a new node ahead of the current head.
	//
	protected void push(Element someItem)
	{
		Node placeHolder = new Node();

		placeHolder.setElement(someItem);

		placeHolder.setNext(head);

		head = placeHolder;
	}

	//
	//	Pops the element at the top of the stack (if there is any element).
	//
	public Element pop() throws ListException
	{
		if (isEmpty())
			throw new ListException("List empty");

		Element result = head.getElement();

		head = head.getNext();

		return result;
	}

	//
	//	Exchanges the first two elements at the top of the stack
	//		(if there are at least two elements).
	//
	public void exchange() throws ListException
	{
		if(head.getNext()!=null){
		exchange2();}
		else{
			
		}
	
		
	}
	public void exchange1(){
		Node temp = head.getNext(); //hold value of the second node
		Element two = temp.getElement(); //grab the from the second node
		temp.setElement(head.getElement()); //set node two's element to node 1's element
		head.setElement(two); //set node one to element two
		head.setNext(temp); //add the node
	}
	public void exchange2(){
		
		Node temp = head; //hold the head
		Node temp2 = head.getNext(); //hold 2nd
		Node temp3 = temp2.getNext(); //hold reference of the second
		temp.setNext(temp3);  //set heads reference to the second nodes references
		temp2.setNext(head); //set second node to refer to the first
		head = temp2; //set the new head to be the 2nd node
		}
		


	//
	//	Paints the stack of elements.
	//
	public void paint(Graphics pane)
	{
		final int SIZE = Element.HEIGHT;	//	Defines the size of the cells
											//		in a node (for drawing)

		final int DELTA = 2;				//	The offset within the box/frame

		pane.setColor(Color.black);			//	Drawing the box/frame of the stack
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