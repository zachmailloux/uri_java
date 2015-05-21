
public class Queue implements QueueInterface{
	
	private static int DEFAULT_SIZE = 5;
	private int maxSize = DEFAULT_SIZE;
	private Object[] _collection;
	private int size;
	
	private int firstElementIndex = 0;
	private int lastElementIndex = -1;

	public Queue()
	{
		this(DEFAULT_SIZE);
	}
	
	public Queue(int someSize)
	{
		_collection = new Object[someSize];
		size = 0;
		maxSize = someSize;
	}
	
	public void enqueue(Object someObject) {
		
		// As long as we don't have a null pointer 
		if(_collection != null && size == _collection.length)
			doubleCollectionSize();
		
		// Okay, we are adding a new element at the end of queue
		// check to see if we need to wrap around the last Element index	
		lastElementIndex = incrementArrayIndex(lastElementIndex);
		
		_collection[lastElementIndex] = someObject;
		
		size++;
		
	}
	/**
	 * */
	public Object dequeue() throws Exception {
		
		try{
			
			// Store the old first element index
			int oldFirstIndex = firstElementIndex;
			
			// Move the first element index by 1 but check to see 
			// if we need to wrap around 
			firstElementIndex = incrementArrayIndex(firstElementIndex);
			
			// Decrement the number of elements we have so far
			size--;
			
			return _collection[oldFirstIndex];   // We can replace the three lines of code above
		}										 // with two, do you see how?
		catch(NullPointerException e) {
			e.printStackTrace();
			return null;  // other option?
		}
	}
	/**
	 * */
	public boolean isEmpty() {
		
		return false;
	}
	/**
	 * */
	public Object peek() throws Exception
	{
		
		try{
			return _collection[firstElementIndex];  // we can avoid this size-1 by adding 
		}                                // elements using the pre-increment 
		catch(NullPointerException e) { // _collection[++size] = a new object
			e.printStackTrace();
			return null;  // other option?
		}
	}
	/**
	 * */
	public void clear()
	{
		_collection = null;  // what's the other option here? 
	}
	/**
	 * */
	public int size() {
		
		return size;
	}
	/**
	 * */
	private void doubleCollectionSize()
	{
		
		System.out.println("Queue had to double collection size ");
		
		Object[] tmp = new Object[_collection.length * 2];
				
		// Copy from the first element index to the end of the collection 
		for(int i = firstElementIndex; i < _collection.length; i++)
		{
			tmp[i] = _collection[i];
		}
		
		// Now copy everything form the beginning of the collection up the 
		// the firstElementIndex 
		if(firstElementIndex !=0)
		{
			// From _collection[0] up to the firstElementIndex
			for(int i = 0; i < firstElementIndex; i++)
			{
				// start copying into temp from we we left off 
				tmp[_collection.length  + i] = _collection[i];
			}
		}
		
		// update reference
		_collection = tmp;
		
		// Make sure the last element index is at the correct location 
		lastElementIndex = firstElementIndex + (size - 1);
		System.out.println("last index at -> [" + lastElementIndex+"]");
		
	}
	
	/**
	 * I HAVE ADDED THIS METHOD TO PRINT QUEUE ELEMENTS
	 * I CAST THE OBJECTS TO INTEGERS SINCE I'M WORKING WITH 
	 * INTEGER OBJECTS, I ONLY DO THIS FOR THE SAKE OF THIS DEMO!!
	 * */
	public void printQueueElementsToConsole()
	{
		for(int i=0; i < _collection.length; i++)
		{
			if(_collection[i] == null)
				System.out.println("_collection["+i+"] = null");
			else
				System.out.println("_collection["+i+"] = " + (((Integer) (_collection[i])).intValue()));
		}
	}
	/**
	 * Given some index value, this method will determine 
	 * if that value is outside the collection length  
	 * */
	private int incrementArrayIndex(int someIndex)
	{
		if(someIndex == _collection.length-1)
			return 0;
		else
			return someIndex+1;
	}

}
