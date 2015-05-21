/*
	O r d e r e d L i s t
	=====================
*/

public class OrderedList extends List
{
	//
	//	C o n s t r u c t o r s
	//	=======================
	//
	public OrderedList()
	{
		super();							//	In both cases,
	}

	public OrderedList(int x, int y)
	{
		super(x, y);						//		we just defer to the base class
	}

	//
	//	The following implementation of the add method assumes that the list is kept
	//		sorted in increasing order.
	//	For the purpose of ordering the objects, it is assumed that the objects
	//		stored in the list are of type Comparable.
	//
	protected void add(Object someItem)
	{
		//	The following is not going to do anything different from the base class.
		Node current=head;
		Node previous = null;
		Node placeHolder = new Node();
		placeHolder.setElement(someItem);
		while((current!=null)&& (((Comparable)someItem).compareTo(current.getElement())>=0)){
			previous = current;
			current = current.getNext();
		}
		if(previous == null){
			placeHolder.setNext(head);
			head = placeHolder;
			
		}
		else{
			previous.setNext(placeHolder);
			placeHolder.setNext(current);
		}
		
	//	super.add(someItem);			//	This is, obviously, NOT what we want.
	}
}	//	end of OrderedList