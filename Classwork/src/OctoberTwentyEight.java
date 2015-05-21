
public class OctoberTwentyEight {

	/**
	 * MERGE SORT
	 * we have two lists of sorted nodes:
	 * example: list1 = 2,5,8,9
	 * 			list2 = 3,10,12,17,20,78
	 * the idea is it compares the heads of both list, and adds the lower of the two
	 * it then recursively continues after changing the smaller head to the next node in THAT list only
	 * private Node merge(Node head1, Node head2){
	 * Node head;
	 * if(head1 ==null) //if the first list is empty
	 * 		head = head2; //take the item from the second list
	 * else if(head2==null) //if the second list is empty
	 * 		head == head1; //take from the first list
	 * else{
	 * if(((Comparable)(head1.getItem())).compareTo(head2.getItem())<=0){ //if the item in the first list is less
	 * head=head1; //make the head the new item
	 * head.setNext = merge(head1.getNext(),head2);} //compare again but with the next item in list 1
	 * else{
	 * head = head2; //make the head the new item
	 * head.setNext(merge(head1, head2.getNext())); //compare again but with the next item in list 2
	 * 
	 * }
	 * return head;
	 * }
	 * 
	 * First call, 2, then goes again, picks 3
	 * 
	 * public void mergeSort(){
	 * head = mergeSort(head);}
	 * 
	 * private Node mergeSort(Node head){
	 * Node head1, head2; //both of these "nodes" are actually halfs of the original list.
	 * 
	 * PRETEND THERES CODE HERE TO BREAK THE LIST OF NODES IN HALF
	 * 
	 * head1 = mergeSort(head1);
	 * head2 = mergeSort(head2);
	 * return merge(head1,head2)
	 * }
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
