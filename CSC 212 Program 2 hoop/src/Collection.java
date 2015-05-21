import java.awt.Graphics;


 public interface Collection
  {
    public void add(Ball someBall);
      // Adds the given Item to the collection.
      // That item becomes the item currently selected.
  
    public void remove();
      // Removes the selected item (if any).
      // No item is selected any more.
   
    public void isEmpty();
      // Resets the selected item to be at the start
      //    of the collection (if not empty).
    public int getAmount();

	public void paint(Graphics pane);
    
  }