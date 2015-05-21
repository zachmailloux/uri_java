
/*The following is a possible-start implementation of a Priority Queue*/
public class PriorityQueue<T> implements PriorityQueueInterface<T>
{
	private static int DEFAULT_SIZE = 5;
	private T[] _collection;				// collection of any type
	private int size;						// Number of active elements in the array 
	
	public PriorityQueue()
	{
		this(DEFAULT_SIZE);
	}
	
	public PriorityQueue(int someSize)
	{
		System.out.println("Queue created with an intial size -> " + DEFAULT_SIZE);
		
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// We can't have _collection = new T[size] -> why? 
		// what is T, a generic type, not an actual physical class
		// so what do we know? create an array of objects and cast them to that generic type. 
		_collection = (T[]) new Object[someSize];
		size = 0;
	}
	
	public void enqueue(T someObject)
	{
		//1. Check that the _collection is not null 
		if(_collection != null)
		{
			// 2. Check to see if our _collection is full 
			if(size == _collection.length)
			{
				//3. If our collection is full, create a new collection of size + 1
				increaseCollectionSizeByOne();
			}
			
			//4. In any case, keep adding the new generic objects 
			_collection[size] = someObject;
			
			//5. Increment the number of active members in the arry 
			size++;
		}
		else
		{
			//6. If the collection is null (for instance, we cleared the collection)
			//   we need to re- initialize the collection. I set the array back to its Default Size
			_collection = (T[]) new Object[DEFAULT_SIZE];
			
			//7. If we had to re- initialize the array, then we know that new generic object being 
			//   added goes in the first position of the array 
			_collection[0] = someObject;
			
			//8. Increment the number of active elements
			size++;
		}
	}
	
	/*Increments the collection array by one - remember we cannot change the 
	 * physical size of an array so we need to make a temporary array*/
	public void increaseCollectionSizeByOne()
	{	
		// Generic collection of size + 1
		T[] newCollection = (T[]) new Object[_collection.length + 1];
		
		// Loop through the collection and copy elements into the new collection 
		for(int i = 0; i < _collection.length; i++)
			newCollection[i] = _collection[i];
		
		// DON'T forget to update the references 
		_collection = newCollection;
	}
	
	/* This Priority Queue implementation will remove the generic object of highest priority */
	public T dequeue() throws Exception {
		
		// 1. Do do anything if we are empty 
		if(isEmpty())
			throw new Exception("empty queue");
		
		// 2. Loop through the collection to find highest priority 
		int maxIndex = 0;

		for(int i =0; i < _collection.length; i++)
		{
			
			// Remember that the _colleciton is of generic types, we still don't know what T is
			// However, we know that T should implement the Comparable interface (remember that an interface- can be used as data types)
			// So what do we do? Lets cast the _collection members to the interface type Comparable<T> in each comparison
			// Which means that the _collection members must define a compareTo method!!!
			
			if(  ((Comparable<T>)_collection[i]).compareTo(_collection[maxIndex]) > 0)   // Check if left is bigger than right
			{
				// if the statement above returns true we have found a new max index 
				maxIndex = i;   
			}
		}
		
		// 3. Store reference to highest priority 
		// In the notes I had (T)_collection[maxIndex] but the cast is not really necessary, right?
		T maximumObject = _collection[maxIndex];  
		
	
		// Now we have the index position of the max and 
		// a reference to it, lets create a new collection of size - 1
		// and copy all the elements expect for the maximum 
	
		//4. Define new collection of size less than one 
		T[] newCollection = (T[]) new Object[_collection.length - 1];
		
		
		// 5. Copy collection (except the max) into the new collection 
		int newCollectionIndex = 0;
		for(int i =0; i < _collection.length; i++)
		{
			if(i != maxIndex)
			{
				newCollection[newCollectionIndex] = _collection[i];
				newCollectionIndex++;
			}
		}
		
		//6. Update! the  (effectively removing the maximum) 
		_collection = newCollection;
		size--;
				
		//7. return a references to the maximum 
		//   (but by now it's no longer a part of the collection)
		return maximumObject;
	}
	/**
	 * */
	public boolean isEmpty() {
		
		return (size == 0);
	}
	/**
	 * */
	public T peek() throws Exception
	{
		if(isEmpty())
			throw new Exception("Queue is empty");
		
		return _collection[0];
	}
	/**
	 * */
	public void clear()
	{
		_collection = null;  // what's the other option here? 
	}
	/**
	 * */
	public int getSize() {
		
		return size;
	}
}
