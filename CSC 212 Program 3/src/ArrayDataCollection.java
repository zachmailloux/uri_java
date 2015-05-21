/*
	ArrayDataCollection.java

		This class defines and implements a collection of data items.

		The implementation is based on an array of Items.

*/

import java.awt.Graphics;
//	AWT = "Abstract Window Toolkit"


public class ArrayDataCollection implements DataCollection
{

	private int firstItemXCoord=138, //here we have our first x coordinate
				firstItemYCoord=183; //y cord
	
	public ArrayDataCollection()
	{			

	}
	
	public ArrayDataCollection(int someX, int someY){
		this();
		x = someX;
		y = someY;
	}
	


	//
	//	r e s e t
	//	=========
	//
	//	By default, the reset method resets the selected item to the beginning
	//		of the collection.
	//
	public void reset()
	{
		current = head;		//	We go back to the beginning
		
	}

	//
	//	r e s e t
	//	=========
	//
	//	Defines the selected item to be the given item
	//		(if it is part of the collection).
	//
	public void reset(Item someItem)
	{	
		selected = someItem;
	}

	//
	//	a d d
	//	=====
	//
	//	Adds the given Item to the collection.
	//	That item becomes the item currently selected.
	//
	public void add(Item someItem)
	{
		Node temporaryNode = new Node();	// temporary Node for an item
		temporaryNode.setItem(someItem);	// put the item in the Node
		temporaryNode.setNext(head);		// update next Node to be head
		head = temporaryNode;				// Now head is first in list
			//	selected
	}

	
	public void paint(Graphics pane)
	{
	Node currentNode = head; //temp node
	if (currentNode != null) { // When instantiated,
		Item e; // we display the items
		int x = firstItemXCoord; 
	    this.reset();
		while (currentNode!=null) {
			e = currentNode.getItem();//store the item
			if(e==selected){
			e.paint(pane, x, firstItemYCoord, true); //paint that one item
			}
			else{
			e.paint(pane, x, firstItemYCoord); //dont paint that its selected
			} //print that item
			x += Item.OVERALL_WIDTH; //update their x location
			currentNode = currentNode.getNext(); //keep going through the list
		}
	}
	}

	
	public boolean hasNext()
	{
		if (current!=null )	// if next selected item exists
		{
			return true;		// return true because there is an next item
		}
		else
			return false;		// no other item
	}

	//
	//	n e x t
	//	=======
	//
	//	Returns the currently selected item and sets
	//		the following item as the selected item
	//		(if any item is currently selected).
	//
	public Item next()
	{
		Node temporaryNode = current; //temp node
		current = current.getNext(); //update current
		return  temporaryNode.getItem();
	}

	//
	//	r e m o v e
	//	===========
	//
	//	Removes the selected item (if any).
	//	No item is selected any more.
	//
	public void remove()
	{
		Node temp = head; // // temporary Node that references to the head

		if (head != null) // if there is a head
		{
			if(head.getItem() == selected) // and it is selected
			{
				head = head.getNext(); // update the head to the next Node, so old head is gone

			}

			else 
			{

				while(temp != null) 
				{
					if((temp.getNext() != null) &&
							(temp.getNext().getItem() == selected))
					{
						
						temp.setNext(temp.getNext().getNext());
					}
					
					temp = temp.getNext();
				}
			}
		}

	}

			//	Holds the items
	private int size;						//	Counts the number of items
	private int x, y;						//	holds the location of the collection
	private Node current;
	private Node head;
	private Item selected;

	private class Node {
		/**
		 * reference to an Item object
		 */
		private	Item item;	
		/**
		 * a reference to the next node
		 */
		private Node next;

		/**
		 * Creates empty node, item
		 */
		private Node()
		{
			next = null;

		}

		/**
		 * Puts item in the Node
		 * @param someItem
		 */
		private void setItem(Item someItem)
		{
			item = someItem;
		}

		/**
		 * Returns item in Node
		 * @return item
		 */
		private Item getItem()
		{
			return item;
		}

		/**
		 * Sets next Node
		 * @param aNode
		 */
		private void setNext(Node aNode)
		{
			next = aNode;
		}

		/**
		 * Returns next Node of a Node
		 * @return next node
		 */
		private Node getNext()
		{
			return next;
		}

	}


}	// end DataCollection
