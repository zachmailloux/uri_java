/*
	B i n a r y S e a r c h T r e e
	
	ZACHARY MAILLOUX 
	11/25/13
	LAB 08 
	
	===============================
*/

import java.awt.*;
import java.awt.event.*;

public class BinarySearchTree extends BinaryTree
{
	private final							//	Defines the size of a basic cell
 				int SIZE = Element.HEIGHT;	//		(for drawing purposes)

	//
	//	C o n s t r u c t o r s
	//	=======================
	//
	public BinarySearchTree()
	{
		super();							//	In either case,
	}

	public BinarySearchTree(int x, int y)
	{
		super(x, y);						//		we refer to the base class
	}

	//
	//	Adds one element to the tree.
	//
	protected void add(Object someItem)
	{
		Node placeHolder = new Node();		//	We instantiate a node,

		placeHolder.setItem(someItem);		//		we fill it with the given item,

		root = add(placeHolder, root);		//		and we add the node to the tree
	}

	//
	//	Adds a given node to a given sub-tree.
	//	The node is assumed to contain a (Comparable) item.
	//	Returns the "modified" tree, with the added node.
	//
	private Node add(Node someNode, Node someRoot)
	{
		Node result;						//	To hold the "modified" tree

		if (someRoot == null) {				//	If the sub-tree is empty
			someNode.setRight(null);
			someNode.setLeft(null);
			result = someNode;				//		it will contain that single node
		}
		else {								//	Otherwise
			if (((Comparable) (someNode.getItem())).compareTo(someRoot.getItem()) < 0) {
				Node leftSubTree = add(someNode, someRoot.getLeft());
				someRoot.setLeft(leftSubTree);
			}
			else {
				Node rightSubTree = add(someNode, someRoot.getRight());
				someRoot.setRight(rightSubTree);
			}
			result = someRoot;				//	The root has not changed
		}

		return result;						//	We return the "modified" tree
	}

	//
	//	Removes (i.e., returns and deletes) the smallest element from the tree
	//		(if there is any element).
	//
	public Object remove() throws BinaryTreeException
	{
											//	If there is nothing to remove
		if (isEmpty())						//		we have a problem!
			throw new BinaryTreeException("Empty binary tree");

		Object result;						//	Our result
											//		is the smallest in the tree
		result = getSmallest(root);			//	We get it,
		root = deleteSmallest(root);		//		then we delete it

		return result;						//	Voilà!
	}

	//
	//	The following method determines (and returns) the smallest item stored in
	//		the tree.
	//
	//	Note:  It is assumed that the given tree is not empty.
	//
	Object min = null;
	//Node temp = null;
	private Object getSmallest(Node someRoot)
	{
		if(someRoot.getLeft()!=null){ //if there is a left
		min = getSmallest(someRoot.getLeft()); //go to that left
		}
		if(someRoot.getLeft()==null){ //if theres no left
		min = someRoot;//make the root the smallest
		}
		return min;//return smallest
		/*******************************************************************************
		 *		This is just the right place for your getSmallest method.
		 *		Recursion is required, but it also seems like a good choice for
		 *   	your implementation.
		 *******************************************************************************/
	}

	//
	//	The following method deletes the smallest item stored in the tree.
	//
	//	It returns the resulting tree.
	//
	//	Note:  It is assumed that the given tree is not empty.
	//
	private Node deleteSmallest(Node someRoot)
	{
		
		if(someRoot.getLeft()!=null){ //if there is a left
			someRoot.setLeft(deleteSmallest(someRoot.getLeft())); //set the left to the result of the recursive call
			return someRoot; //return new root
			}
		else if(someRoot.getLeft()==null&&someRoot.getRight()!=null){ //if theres no left but still a right
			return someRoot.getRight(); //set it skip the root and go to the roots right
			}
		else{
			return null;
			}
		
	
		/*******************************************************************************
		 *
		 *		This is just the right place for your deleteSmallest method.
		 *
		 *		Again, recursion is required, and it still seems like a good choice
		 *	for your implementation.
		 *
		 *******************************************************************************/

		//return (Node) min; //return root which was the smallest deleted
	}
}