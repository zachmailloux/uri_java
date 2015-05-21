import java.awt.Graphics;

/**
 * The DataCollection class holds all of the data regarding the array
 * of Items.  It has methods for selecting certain items, for removing
 * and adding items, and returning items, as well as a paint method.
 * @author Zachary Mailloux
 *
 */
public class DataCollection {

	/**
	 * The index of the currently selected item.
	 * is -1 when nothing is selected.
	 */
	private int indexSelected = -1;

	/**
	 * the index of the last item in the array.
	 * -1 if nothing is there.
	 */
	private int indexLast = -1;

	/**
	 * The array of items used to keep track of our items. 
	 * Is 10 items long.
	 */
	private Item[] myItems = new Item[10];

	/**
	 * Determines whether there is a selected item in the array or not.
	 */
	private boolean hasSelected;

	/**
	 * a placeholder item for various functions.
	 */
	private Item placeHolder;



	/**
	 * Empty constructor
	 */
	public DataCollection()
	{

	}


	/**
	 * 	Adds the given Item to the collection.
	 *  That item becomes the item currently selected.
	 * @param someItem
	 */
	public void add(Item someItem)
	{

		Item myNewItem = someItem;  // gets an item from DataOrganizer

		myItems[indexLast+1] = myNewItem; // sets it as the next item

		indexLast += 1; // increments the index

		hasSelected = false; // tells that there is nothing selected yet
	}


	/**
	 * 	Removes the selected item (if any).
	 *  No item is selected any more.
	 */
	public void remove()
	{
		/*
		 * sets to hasSelected being true if something is selected.
		 */
		if (indexSelected != -1 && myItems[indexSelected] != null)
		{
			hasSelected = true;
		}
		/*
		 * If something is selected, it walks through, taking the next item and setting
		 * it as the current item, effectively overwriting the item we want to remove.
		 * Finally, it erases the last item (to null)
		 */
		if (hasSelected==true)//if we know there is a selected
		{
			for (int i = indexSelected; i< (indexLast); i++)
			{
				myItems[i] = myItems[i+1];//every item after the selected one



			}
			if (indexLast > -1)
				myItems[indexLast] = null;//to make the end of the list dissapear 

			indexLast--;//take one off of the value
		}

		indexSelected = -1; // deselects

		hasSelected = false;

		deSelectAll(); // makes all of the items show up as not selected


	}


	/**
	 *   Resets the selected item to be at the start
	 *   of the collection (if not empty).
	 *   You can use this at the beginning of 
	 *   however you loop through the DataCollection 
	 */
	public void reset()
	{

		indexSelected = 0; // resets index of selected to be zero

		deSelectAll(); // visually deselects any that is selected

		hasSelected = true; // says there is one selected

	}

	public void resetToEnd()
	{
		indexSelected = 0; 

		hasSelected = true;

		if (indexSelected == -1) // in the case of nothing selected yet, sets the proper boolean to false
		{
			hasSelected = false;
		}
	}


	/**
	 *   Defines the selected item to be the given item
	 *   (if it is part of the collection).
	 *   Use this to select a particular item (e.g., 
	 *   for removal)
	 * @param someItem
	 */
	public void reset(Item someItem)
	{
		placeHolder = someItem; // uses a placeholder item as the one to be searched for
		boolean hasFound = false; // boolean for if we have found a match yet

		
		for (int i = 0; (i <= indexLast) && !hasFound ; i++)
		{
			if (myItems[i].getValue() == placeHolder.getValue())
			{
				indexSelected = i;

				myItems[indexSelected].select(); // wehn we find it, we visually select it

				hasFound = true; // exits loop
			}
		}



	}




	/**
	 *   Returns the currently selected item and sets
	 *   the following item as the selected item
	 *   (if any item is currently selected).
	 * @return
	 */
	public Item next()
	{

		indexSelected++; 

		if ( indexSelected > indexLast)
		{
			hasSelected = false;
		}

		return myItems[indexSelected-1];


	}


	/**
	 *   Determines whether there is a selected item.
	 *   True if a call to next() will return an Item
	 *   False if nothing is selected
	 *   Has *nothing* to do with whether there exists some further
	 *   Item that would be selected after next() is invoked.
	 * @return
	 */
	public boolean hasNext()
	{
		/*
		 * if indexSelected exceeds bounds in some way, we select nothing
		 */
		if (indexSelected == 10 || (indexSelected >-1 && myItems[indexSelected] == null))
		{
			hasSelected = false;

			indexSelected = -1;
		}

		return hasSelected;

	}

	/**
	 * Generic paint method, the only interesting thing is that it increments the X points
	 * of the items according to whatever is left for proper spacing.
	 * @param pane
	 */
	public void paint(Graphics pane)
	{
		int xForPainting = 175;

		for (int i = 0; i<= indexLast ; i++)
		{

			myItems[i].setX(xForPainting);
			myItems[i].paint(pane);
			xForPainting += 25;

		}

	}


	/**
	 * Simply goes through all items in the array visually deselecting all of them.
	 */
	public void deSelectAll()
	{
		for (int i = 0; i <= indexLast; i++)
		{
			myItems[i].deSelect();
		}
	}


}
