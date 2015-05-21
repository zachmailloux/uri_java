import java.awt.Color;

/**
 * @author Patrick Correia
 * 
 * This class defines and implements a collection of data items.
 * The implementation is based on an linked list.
 * 
 * @param <T> the Class of object to be stored
 */
public class DataCollection<T>
{
	private boolean DEBUG = false;

	/**
	 * Keep track of selected item
	 */
	private Item selected;

	/**
	 * Keep track of 1st node
	 */
	private Node head; 

	/**
	 * Keep track of where we are in list
	 */
	private Node currentNode ; 

	/**
	 * Constructor does nothing, just to satisfy requirement
	 *  of not altering DataOrgranizer
	 * @param someMaximumSize 
	 */
	public DataCollection(int someMaximumSize)
	{		

	}

	/**
	 * Adds the given Item to the collection.
	 * That item becomes the item currently selected.
	 * @param someItem
	 */
	public void add(Item someItem)
	{
		Node temporaryNode = new Node();	// temporary Node for an item

		temporaryNode.setItem(someItem);	// put the item in the Node
		temporaryNode.setNext(head);		// update next Node to be head

		head = temporaryNode;				// Now head is first in list


	}

	/**
	 * The clear method remove all items.
	 */
	public void clear()
	{
		head = null; // simply break the list by setting the head to null

	}

	/**
	 * 
	 * @return true if next() will return an item
	 */
	public boolean hasNext()
	{
		if (currentNode!=null )	// if next selected item exists
		{
			return true;		// return true because there is an next item
		}
		else
			return false;		// no other item
	}

	/**
	 * 	Returns the currently selected item and sets
	 *		the following item as the selected item
	 *		(if any item is currently selected).
	 *
	 */
	@SuppressWarnings("unchecked") //for the cast
	public Item next()
	{
		Node temporaryNode;
		temporaryNode = currentNode;
		currentNode = currentNode.getNext();
		return  temporaryNode.getItem();
	}

	/**
	 * Remove the selected item (if any)
	 * POSTCONDITION: Nothing is selected
	 */
	public void remove()
	{
		Node temporaryNode = head; // // temporary Node that references to the head

		if (head != null) // if there is a head
		{
			if(head.getItem() == selected) // and it is selected
			{
				head = head.getNext(); // update the head to the next Node, so old head is gone

			}

			else
			{

				while(temporaryNode != null) // Heres our loop running through each node starting with the head
				{
					// if this node exists && its the selected
					if((temporaryNode.getNext() != null) &&
							(temporaryNode.getNext().getItem() == selected))
					{
						// looses link with selected node and links up to the node after the one thats selected
						temporaryNode.setNext(temporaryNode.getNext().getNext());
					}
					// if selected wasn't found on first pass, now we refer to the next node
					// loop started with 2nd node, if selected not found goes to third node
					// and repeats
					temporaryNode = temporaryNode.getNext();
				}
			}
		}

	}

	/**
	 * Select the item at the beginning of the collection (if any)
	 */
	public void reset()
	{
		currentNode=head;  // head is null so current node (pointer) will be set to null also
	}

	/**
	 * If someItem is in the collection, select it
	 * @param someItem that might be in the collection
	 */
	public void reset(Item someItem)
	{
		// we set are item to be the target item
		selected = someItem;

		if(DEBUG) System.out.println("selected is now "+selected);
	}
	/**
	 * *************************************************************
	 * @author Patrick Correia  
	 * 
	 * This class defines a Node, 
	 * and the operations that can be used along with a Node
	 */
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

	}	//	end Node

}	// end DataCollection