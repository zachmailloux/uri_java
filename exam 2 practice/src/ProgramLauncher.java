

/*
 * A primitive implementation of priority queue interface 
 * This demo but meant to give you an idea 
 * of how the PriorityQueue ADT could be used 
 * (some exception handling is missing, some methods need optimization)
 * (this is demonstration)
 */
public class ProgramLauncher {
	
	
	public static void main(String[] args) {
		
		// Hey look at the following line of code, I'm defining a type PrioirtyQueueInterface which is an interface
		// How is that possible? Well in Java this allowed, what it is means is that
		// you are defining a reference variable that is of the type PriorityQueueInterface
		// but when initialize the data type you will have to use class that implement the PriorityQueueInterface
		// In our case the class PriorityQueue implements the PrioirtyQueueInterface so we can do the following
		PriorityQueueInterface< Person > myCollectionQueue = new PriorityQueue<Person>();
		
		// Of course you can have PriorityQueue< Person > myCollectionQueue = new PriorityQueue<Person>();
		// but we will talk about this in class and when it's best to do this 
		
		// At this point the myCollectionQueue variable only has references to the method defined in the BY THE INTERFACE
		// it does not have access to any other methods defined in the PriorityQueue. This is Data Abstraction at its best
		// 
		// In the future you will make use of built-in data structures such as Java's List to create collections
		// and you probably won't care of how the List  is  implemented, 
		// you'll probably care more about the functionalities it gives you. In fact in Java the 
		// List interface that is implemented by a number of different classes(i.e. ArrayList, linked-list)
		// It will up to you to determine which best serves your needs
		
		// The same logic applies to what we have been learning in class. 
		// The Stack, Queue and PrioirtyQeueue interfaces can be implemented in many different ways 
		// for instance, array-based (with different version of the internal methods such as add and remove)
		// as well link-based (node based with different versions of the add and remove methods)
		// which implementation you choose depends on your program's needs (efficient removing/add, less memory-usage, etc)
			
		// Okay, enough the long story ... lets get to business 
		
		// Now that my queue is initialized lets use it  
		
		//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=--==-=-=
		// Add a few Integer objects to the stack 
		myCollectionQueue.enqueue(new Person("Bob",10));
		myCollectionQueue.enqueue(new Person("Alex",20));
		
		System.out.println("**********************");
		System.out.println("1) enqueue(10), enqueue(20)");
		System.out.println("  Size of queue ->"  + myCollectionQueue.getSize());
		System.out.println("**********************");
		
		myCollectionQueue.enqueue(new Person("Mike", 5));
		myCollectionQueue.enqueue(new Person("Danny",91));
		myCollectionQueue.enqueue(new Person("Dave",2));
		myCollectionQueue.enqueue(new Person("Peter",93));
		myCollectionQueue.enqueue(new Person("Zoey",1));
		myCollectionQueue.enqueue(new Person("Wendy",95));
		System.out.println("**********************");
		System.out.println("2) enqueue(5), enqueue(91), enqueue(2), enqueue(93), enqueue(1), enqueue(95)");
		System.out.println("   Size of queue ->"  + myCollectionQueue.getSize());
		System.out.println("**********************");
		
		try 
		{
			Person removed = myCollectionQueue.dequeue();
			System.out.println("3) \n -dequeue -> " + 
							  removed.getName() + ", Networth -"+removed.getNetWorth());
			
			while(!myCollectionQueue.isEmpty())
			{
				Person aPerson = myCollectionQueue.dequeue();
				System.out.println(" -dequeue -> " + 
									aPerson.getName() + ", Networth -"+ aPerson.getNetWorth());
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
	}
}

