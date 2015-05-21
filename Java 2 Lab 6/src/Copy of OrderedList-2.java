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
	//	The following method sorts the whole list.
	//	It makes use of a utility method which implements merge sort.
	//
	public void sort()
	{
		head = mergeSort(head);
	}
	
	private Node mergeSort(Node head){
		if(head==null){ //if theres nothing in the list
			return null; //return nothing
		}
		else if(head.getNext()==null){ //if theres only one item in the list, return just the head
			return head; 
		}
		else{ //cut the list in half
		
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
			if((head1.getElement()).compareTo(head2.getElement())<=0){ //compare
			head=head1; //make the head to head1
			head.setNext(merge(head1.getNext(),head2)); //then go on to add the head1's next and head2
			}
			else{ 
			head = head2;//add the head 2 
			head.setNext(merge(head1,head2.getNext()));//then go on to add the head2's next and head1
			}
		}
		return head;
	}

	//
	//	The following method sorts a list using some sort of a sort.
	//


}	//	end of OrderedList