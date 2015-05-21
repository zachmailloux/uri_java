import java.awt.Graphics;

 public interface DataCollection
  {
    public void add(Item someItem);
      // Adds the given Item to the collection.
      // That item becomes the item currently selected.
  
    public void remove();
      // Removes the selected item (if any).
      // No item is selected any more.
   
    public void reset();
      // Resets the selected item to be at the start
      //    of the collection (if not empty).
    
    public void reset(Item someItem);
      // Defines the selected item to be the given item
      //    (if it is part of the collection).
    
    public boolean hasNext();
      // Determines whether there is a selected item
      //    (in other words, it returns true if an
      //    invocation to next would return an Item).
    
    public Item next();
      // Returns the currently selected item and sets
      //    the following item as the selected item
      //    (if any item is currently selected).
    
    public void paint(Graphics pane);
      // Paints the entire collection of items
      //    (possibly including a selected item).
    
  }