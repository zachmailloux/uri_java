
public interface QueueInterface {
			 
	/**
	 * Pushed object to the back of the stack 
	 * */
	public void enqueue(Object someObject);   
	/**
	 * Pops top element of the stack and returns that element 
	 ***/
	public Object dequeue() throws Exception;
	/**
	 * Determines if the stack is empty 
	 * */
	public boolean isEmpty();
	/**
	 * Returns the top of the stack without modifying the stack
	 * @throws Exception 
	 * */
	public Object peek() throws Exception;
	/**
	 * Clears the stack 
	 * */
	public void clear();
	
	/**
	 * Returns the number of elements 
	 * */
	public int size();

}
