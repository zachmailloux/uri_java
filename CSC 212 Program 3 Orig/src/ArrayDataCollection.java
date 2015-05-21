/*
	ArrayDataCollection.java

		This class defines and implements a collection of data items.

		The implementation is based on an array of Items.

*/

import java.awt.*;							//	AWT = "Abstract Window Toolkit"


public class ArrayDataCollection implements DataCollection
{


	//
	//	Sets initial capacity of array to 15, none are in collection, none are selected.
	//
	public ArrayDataCollection()
	{											//	Instantiate an array of a
		theItems = new Item[15];	//	beginning default size.
		size = 0;							//	There are no items yet
		selected = -1;						//		and no selected item either

	}
	
	public ArrayDataCollection(int someX, int someY){
		this();
		x = someX;
		y = someY;
	}
	
	//
	//  Since selected Item is highlighted, this makes sure any previously selected
	//	Item is not highlighted, and highlights the selected Item.
	//
	private void changeSelected(int newSelected){
		if(selected != -1 && selected < size){
			theItems[selected].highlight(false);
		}
		if(newSelected != -1 && newSelected < size){
			theItems[newSelected].highlight(true);
		}
		selected = newSelected;
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
		changeSelected(0);					//	We go back to the beginning
		
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
		int i = 0;							//	To run through the array
		changeSelected(-1);						//	In case we do not have a match
		while ( (selected == -1) && (i < size) ) {
			if ( theItems[i] == someItem )
				changeSelected(i);
			i++;
		}
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
		if(selected==theItems.length){
			Item[] temp = new Item[theItems.length * 2];
			for(int i = 0; i< theItems.length; i++)
				temp[i] = theItems[i];
			theItems = temp;
		}
		//set the location of the item to follow the previous
		someItem.setLocation(x + size * Item.OVERALL_WIDTH, y);
		theItems[size] = someItem;		//		Set the new element as		
		changeSelected(size++);				//	selected
	}

	//
	//	The only "graphical" method of the class is the paint method.
	//
	public void paint(Graphics pane)
	{
		if(theItems != null){
			for(int i = 0; i<size; i++)
				theItems[i].paint(pane);
		}
	}

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
	public boolean hasNext()
	{
		return (size > 0) && (selected >= 0) && (selected < size);
	}

	//
	//	n e x t
	//	=======
	//
	//	Returns the currently selected item and sets
	//		the following item as the selected item
	//		(if any item is currently selected).
	//
	public Object next()
	{
		Item result = null;

		if ((size > 0) && (selected >= 0) && (selected < size)){
			result = theItems[selected];
			changeSelected(selected + 1);
		}

		return result;
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
		if ((selected >= 0) && (selected < size)) {
			for (int i = selected ; i < size-1; i++){
				//move it down in the collection
				theItems[i] = theItems[i+1];
				//and move its location one to the left
				theItems[i].setX(theItems[i].getX()-Item.OVERALL_WIDTH);
			}
			size--;
			changeSelected(-1);
		}
	}


	private Item [] theItems;				//	Holds the items
	private int size;						//	Counts the number of items
	private int x, y;						//	holds the location of the collection
	private int selected;					//	Keeps track of the "selected" item

	

}	// end DataCollection
