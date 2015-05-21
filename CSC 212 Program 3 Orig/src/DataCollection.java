/*
	DataCollection.java

		This interface defines a collection of data items.


*/

import java.awt.Graphics;							//	AWT = "Abstract Window Toolkit"


public interface DataCollection
{




	//
	//	r e s e t
	//	=========
	//
	//	By default, the reset method resets the selected item to the beginning
	//		of the collection.
	//
	public void reset();
	

	//
	//	r e s e t
	//	=========
	//
	//	Defines the selected item to be the given item
	//		(if it is part of the collection).
	//
	public void reset(Item someItem);

	//
	//	a d d
	//	=====
	//
	//	Adds the given Item to the collection.
	//	That item becomes the item currently selected.
	//
	public void add(Item someItem);

	//
	//	The only "graphical" method of the class is the paint method.
	//
	public void paint(Graphics pane);

//
//	I t e r a t o r
//	===============
//
//	The Iterator interface requires the implementation of the following methods.
//
//	boolean	hasNext():	returns true if the executing object contains one or more
//						objects that have not been returned by the next method.
//	Object	next():		returns a reference to the next object in the Iterator.
//	void	remove():	removes the item most recently returned by the next method
//						from the underlying collection.
//

	//
	//	h a s N e x t
	//	=============
	//
	//	Determines whether the selected item is
	//		followed by another item.
	//
	public boolean hasNext();

	//
	//	n e x t
	//	=======
	//
	//	Returns the currently selected item and sets
	//		the following item as the selected item
	//		(if any item is currently selected).
	//
	public Object next();


	//
	//	r e m o v e
	//	===========
	//
	//	Removes the selected item (if any).
	//	No item is selected any more.
	//
	public void remove();


}	// end DataCollection
