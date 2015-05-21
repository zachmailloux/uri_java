import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;




public class SortedDataOrganizer extends DataOrganizer{
	protected DataCollection tempcollection;	//here we have our second DataCollection that we move everything into 
	Abutton sortButton; //the sort button
	Node TempList; //the node list
	public SortedDataOrganizer() {//constructor
		
	}
	public SortedDataOrganizer(Applet someapplet) {
		super(someapplet);
		y += 1.5*Abutton.BUTTON_HEIGHT;
		sortButton = new Abutton("Sort", Color.pink, x, y);
		// TODO Auto-generated constructor stub
	}
	private void flipWhenInside()
	{
		if (sortButton.isInside(lastX, lastY))
			sortButton.flip();
		
	}
	/**
	 * @param args
    **/
	public void sort()
	{
		TempList = new Node(); //we create a new linked list
		TempList.setItem(collection.next()); //take item from the collection's list of items
		while(collection!=null&&collection.hasNext()==true){ //while the collection still has items
			Node temp = new Node(); //temp node
			temp.setItem(collection.next()); //take item from collection and store it as a node
			//System.out.println("Taken node:"+temp.getItem()); //for debugging
			temp.setNext(TempList); //make it refer to the front
			TempList = temp; //update head
			
		}
		/*
		 * Below is the actual use of our merge sort. The new temp list of nodes we made will be easier to 
		 * sort based off the merge sort algorithm we had prior to this assignment. 
		 */
		TempList = mergeSort(TempList);	
		
		//below we create a new collection so that we can take the now sorted nodes from the linked list
		// and then place them in a collection so that it will appear properly
		tempcollection= new ArrayDataCollection(x, y);	
		while(TempList!=null){//while the linked list still has nodes
			System.out.println("Added node:" + TempList.getItem());//debugging purposes
			tempcollection.add(TempList.getItem());//add the item to the collection from the node list
			TempList = TempList.getNext();//update position in linked list
		}
		collection = tempcollection;//update collection
		
		
	}


	
	private Node mergeSort(Node head){
		if(head==null){ //if theres nothing in the list
			return null; //return nothing
		}
		else if(head.getNext()==null){ //if theres only one item in the list, return just the head
			return head; 
		}
		else{ //cut the list in hal
		int half = length(head)/2; //grab the half way point
		Node head1 = head; //set them both equal to head
		Node head2 = head; 
		Node current = head; //have as a temp node 
		for(int i =0; i<half-2;i++){ //go through the list
		current = current.getNext(); //traverse
	
		}
		head2 = current.getNext(); //set head two to the latter half
		current.setNext(null); //break the first list
		head1 = mergeSort(head1); //send the first half into the loop
		head2 = mergeSort(head2); //send the second half into the loop 
		return merge(head1, head2);} //merge them together
		
	}
	
	
	
	
	private Node merge(Node head1, Node head2){
	
		Node head;
		if(head1==null){ //if theres no item
			head = head2; //just add the second
		}
		else if(head2==null){ //no item
			head=head1; //add the first
		}
		else{
			//Here I tried using the compareTo method for virtually 3 hours. 
			//Even after casting, extending comparable and trying everything both I and even James Collins
			// could think of I decided to use the getValue method instead.
			//the compareTo method didn't actually compare them just returned 0 every time
			if((head1.getItem().getValue()>(head2.getItem().getValue()))){
			//	System.out.println(head1.getItem().getValue()+ " is greater than " + head2.getItem().getValue());
			head=head1; //make the head to head1
			head.setNext(merge(head1.getNext(),head2)); //then go on to add the head1's next and head2
			}
			else{ 
			//	System.out.println(head1.getItem().getValue()+ " is less than " + head2.getItem().getValue());
			head = head2;//add the head 2 
			head.setNext(merge(head1,head2.getNext()));//then go on to add the head2's next and head1
			}
		}
		return head;
	}
	
	public int length()
	{										//	It is easier determined
		return length(TempList);				//		through a utility method
	}

	public int length(Node someHead)
	{
		int result;

		if (someHead == null)				//	If the sub-list is empty,
			result = 0;						//		there are no element
		else								//	otherwise, there is the first node
			result = 1						//		then the rest
					 + length(someHead.getNext());

		return result;
	}
	
	public void paint(Graphics pane){
		super.paint(pane);
		if(sortButton != null){
			sortButton.paint(pane);
		}
	}
	public void check(){
		super.check();
		if (sortButton.isInside(lastX, lastY)) {
			sort();
		}
	}
/*	public void paint(Graphics pane)
	{
		super(Graphics Pane);
		if(sortButton != null){
			sortButton.paint(pane);
		}
		
	}
	*/
	
	protected int size;						//	Counts the number of items


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
		public Node()
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

}
