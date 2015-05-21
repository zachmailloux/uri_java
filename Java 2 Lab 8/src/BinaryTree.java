/*
	B i n a r y T r e e
	===================
*/

import java.awt.*;
import java.awt.event.*;

public class BinaryTree
{
	private final							//	Defines the size of a basic cell
 				int SIZE = Element.HEIGHT;	//		(for drawing purposes)

	//
	//	C o n s t r u c t o r s
	//	=======================
	//
	//	By default, we will start with ... nothing.
	//
	public BinaryTree()
	{										//	By default, we start
		this(143, 147);						//		at an arbitrary location
	}

	public BinaryTree(int x, int y)
	{
		root = null;						//	No element at the "head", yet

		this.x = x;							//	We keep track of the location
		this.y = y;
	}

	//
	//	Determines whether the list is empty or not.
	//
	public boolean isEmpty()
	{
		return root == null;
	}

	//
	//	Determines the size of the whole tree (or the size of a sub-tree).
	//
	public int size()
	{										//	It is easier determined
		return size(root);					//		through a utility method
	}

	public int size(Node someRoot)
	{
		int result;

		if (someRoot == null)				//	If the sub-tree is empty,
			result = 0;						//		there are no elements
		else								//	otherwise, there is the root
			result = 1						//		and the left and the right
					 + size(someRoot.getLeft())
					 + size(someRoot.getRight());

		return result;
	}

	//
	//	Adds one character to the tree.
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
	//	Adds one integer to the tree.
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
	//	Adds one element to the tree.
	//
	protected void add(Object someItem)
	{
		Node placeHolder = new Node();

		placeHolder.setItem(someItem);

		if (Math.random() < 0.5) {
			placeHolder.setLeft(root);
			placeHolder.setRight(null);
		}
		else {
			placeHolder.setLeft(null);
			placeHolder.setRight(root);
		}

		root = placeHolder;
	}

	//
	//	Removes an element from the tree (if there is any element).
	//
	public Object remove() throws BinaryTreeException
	{
		if (isEmpty())
			throw new BinaryTreeException("Empty binary tree");

		Object result = root.getItem();

/*
		head = head.getNext();
*/

		return result;
	}

	//
	//	Paints all the elements in the tree.
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

		if (root == null) {
			pane.setColor(Color.red);
			pane.drawLine(x + DELTA + 1, y + DELTA + 1,
						  x + SIZE - DELTA - 1, y + SIZE - DELTA - 1);
		}
		else {
			pane.setColor(Color.black);
			pane.drawOval(x + SIZE/2 - 1, y + SIZE/2 - 1,
						  2, 2);
			pane.drawLine(x + SIZE/2, y + SIZE/2,
						  root.getX(), root.getY() + SIZE/2);

			root.paint(pane);
		}
	}

	protected Node root;				//	A reference to the first node (if any)

	private int x, y;					//	To define the location of the list
										//		(for drawing purposes, only)
}