import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CollectionsDemo {
	
   public static void main(String[] args) {
        
	   CollectionsDemo cDemo = new CollectionsDemo();
   }   
   
   
   public CollectionsDemo()
   {
	      
	   // 1. Array List
	   // Array list is a resizable-array implementation of the list interface
	   List<Person> listOfPeople = new ArrayList<Person>();
	   
	   listOfPeople.add(new Person("Billy", 200)) ;
	   listOfPeople.add(new Person("Addie", 1000)) ;
	   listOfPeople.add(new Person("Shawn", 500)) ;
	   
	   for(int i = 0; i < listOfPeople.size(); i++)
	   {
		   System.out.println("Person Name: " + listOfPeople.get(i).getName() + 
				   			  " Networth: " + listOfPeople.get(i).getNetWorth());
	   }
	   
	   System.out.println("*********************************");
	   
	   // for-each
	   for(Person p : listOfPeople)
	   {
		   System.out.println("Person Name: " + p.getName() + 
		   			  " Networth: " + p.getNetWorth());
	   }
	   
	   System.out.println("*********************************");
	   
	   //Iterator 
	   Iterator<Person> pIt = listOfPeople.iterator();
	   while(pIt.hasNext())
	   {
		   
		   Person p = pIt.next();
		   System.out.println("Person Name: " + p.getName() + 
		   			  " Networth: " + p.getNetWorth());
	   }
	   
  
	   System.out.println("*********************************");
	   System.out.println("Linked-List");
	  
	   //2. Doubly-linked list implementation (previous and next node for each node)
	   List<Person> linkedListOfPeople = new LinkedList<Person>();
	     
	   linkedListOfPeople.add(new Person("Billy", 200)) ;
	   linkedListOfPeople.add(new Person("Addie", 1000)) ;
	   linkedListOfPeople.add(new Person("Shawn", 500)) ;
	   
	   for(int i = 0; i < linkedListOfPeople.size(); i++)
	   {
		   System.out.println("Person Name: " + linkedListOfPeople.get(i).getName() + 
				   			  " Networth: " + linkedListOfPeople.get(i).getNetWorth());
	   }
	   
	   linkedListOfPeople.removeAll(linkedListOfPeople); 
	   System.out.println(linkedListOfPeople.size());
	   
	   System.out.println("*********************************");
	   
	   //3. HashMap
	   Map<Integer, Person> hashMap = new HashMap<Integer, Person>();
	   
	   hashMap.put(1, new Person("Apple1", 200));
	   hashMap.put(2, new Person("Bobby", 500));
	   hashMap.put(1, new Person("Apple1984", 200));
	   
	   //Integer key = 1;
	   //Person value = hashMap.get((key));
	   //System.out.println("Key: " + key +" value: "+ value.getName()); 
	   
	   
	   Iterator<Integer> keySetIterator = hashMap.keySet().iterator();

	   while(keySetIterator.hasNext()){
	     Integer key = keySetIterator.next();
	     System.out.println("key: " + key + " value: " + hashMap.get(key).getName());
	   }
	   
	   
	   System.out.println("*********************************");
	   
	   Map<Integer, ArrayList<Person>> listHashMap = new HashMap<Integer, ArrayList<Person>>();
	   
	   ArrayList<Person> p1  = new ArrayList<Person>();
	   p1.add(new Person("Apple1", 200));
	   p1.add(new Person("Apple1984", 200));
	   
	   listHashMap.put(1, p1);
	   
	   ArrayList<Person> p2  = new ArrayList<Person>();
	   p2.add(new Person("Bobby", 200));
	   p2.add(new Person("Earl", 200));
	   
	   listHashMap.put(2, p2);
	 
	   Iterator<Integer> keySetIterator2 = listHashMap.keySet().iterator();

	   while(keySetIterator2.hasNext()){
		   
	     Integer key = keySetIterator2.next();
	     
	     Iterator<Person> hashIterators = listHashMap.get(key).iterator();
	     
	     while(hashIterators.hasNext()){
		     Person person = hashIterators.next();
		     System.out.println("key: " + key + " value: " + person.getName());
		  }
	   }
   }
   
  
   private class Person
   {
	   private String name = "";
	   private double netWorth = 0; 
	   
	   public Person(String aName, double aNetWorth)
	   {
		   name = aName;
		   netWorth = aNetWorth;
	   }
	   
	   public void setName(String aName)
	   {
		   name = aName;
	   }
	   public String getName()
	   {
		   return name;
	   }
	   public void setNetWorth(double aNetWorth)
	   {
		   netWorth = aNetWorth;
	   }
	   public double getNetWorth()
	   {
		   return netWorth;
	   }
   }
}

