
public class Node {
	
	
	private int item;
	private Node left;
	private Node right;
	
	
	public Node()
	{
		item = 0; 
		left = null;
		right = null;
	}
	
	public Node (int anItem)
	{
		item = anItem;
		left = null;
		right = null;
	}
	
	public Node(int anItem, Node aLeft, Node aRight)
	{
		item = anItem;
		left = aLeft;
		right = aRight;
	}
	
	
	// SETTERS 
	public void setItem(int anItem)
	{
		item = anItem;
	}
	
	public void setLeft(Node aLeft)
	{
		left = aLeft;
	}
	
	public void setRight(Node aRight)
	{
		right = aRight;
	}
	
	//GETTERS
	public int getItem()
	{
		return item;
	}
	
	public Node getLeft()
	{
		return left;
	}
	
	public Node getRight()
	{
		return right;
	}
}
