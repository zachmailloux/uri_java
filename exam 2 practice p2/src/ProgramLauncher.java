

/*
 * A primitive implementation of queue class 
 * This demo but meant to give you an idea 
 * of how the Queue ADT could be used 
 * (some exception handling is missing, some methods need optimization)
 * (this is demonstration)
 */
public class ProgramLauncher {

	public static void main(String[] args) {
		
		// Create a queue 
		Queue myCollectionQueue = new Queue(5);
			
		//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=--==-=-=
		// Add a few Integer objects to the stack 
		myCollectionQueue.enqueue(new Integer(10));
		myCollectionQueue.enqueue(new Integer(20));
		
		System.out.println("**********************");
		System.out.println("enqueue(10), enqueue(20)");
		System.out.println("1) Queue Elements ->" );
		myCollectionQueue.printQueueElementsToConsole();
		System.out.println("**********************");
		
		// Local variable to store some references 
		Integer someValue;
		
		
		// We use a try-catch block for peek() since we throw exception in the peek()
		// Remember the peek() could encounter a null reference 
		try 
		{
			someValue =  (Integer)myCollectionQueue.peek();
			System.out.println("2) Peek top of stack -> " + someValue.intValue());	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	
		//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=--==-=-=
		// Add a few more Integer objects 
		myCollectionQueue.enqueue(new Integer(40));
		myCollectionQueue.enqueue(new Integer(6));
		myCollectionQueue.enqueue(new Integer(99));
		
		System.out.println("**********************");
		System.out.println("enqueue(40), enqueue(6), enqueue(99)");
		System.out.println("3) Queue Elements ->" );
		myCollectionQueue.printQueueElementsToConsole();
		System.out.println("**********************");
		
		// Lets use the dequeue method of the queue  
		try 
		{
			someValue =  (Integer)myCollectionQueue.dequeue();
			System.out.println("4) dequeue -> " + someValue.intValue());	
			
			someValue =  (Integer)myCollectionQueue.dequeue();
			System.out.println("5) dequeue -> " + someValue.intValue());	
			
			System.out.println("6) collection size -> " + myCollectionQueue.size());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=--==-=-=
		// Add a few more Integer objects 
		myCollectionQueue.enqueue(new Integer(100));
		myCollectionQueue.enqueue(new Integer(788));
		
		System.out.println("**********************");
		System.out.println("enqueue(100), enqueue(788)");
		System.out.println("7) Queue Elements ->" );
		myCollectionQueue.printQueueElementsToConsole();
		System.out.println("**********************");
		
		
		try 
		{
			someValue =  (Integer)myCollectionQueue.peek();
			System.out.println("8) Peek top of stack -> " + someValue.intValue());	
		}  
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=--==-=-=
		// Add a few more Integer objects 
		myCollectionQueue.enqueue(new Integer(999));
		System.out.println("**********************");
		System.out.println("enqueue(999)");
		System.out.println("9) Queue Elements ->" );
		myCollectionQueue.printQueueElementsToConsole();
		
	}
}

