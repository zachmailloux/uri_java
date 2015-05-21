
/*Priority Queue Interface for some Type, what is the type, we don't know*/
public interface PriorityQueueInterface <T>{
			 
	/**
	 * add new element to the priority queue (no order)
	 * */
	public void enqueue(T someObject); 
	/**
	 * Remove the element with the highest priority 
	 ***/
	public T dequeue() throws Exception;
	/**
	 * Determines if the stack is empty 
	 * */
	public boolean isEmpty();
	/**
	 * Returns the top of the stack without modifying the stack
	 * @throws Exception 
	 * */
	public T peek() throws Exception;
	/**
	 * Clears the stack 
	 * */
	public void clear();
	
	/**
	 * Returns the number of elements 
	 * */
	public int getSize();

}
