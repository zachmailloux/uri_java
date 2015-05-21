
/*
 * The person class is a comparable class 
 * (from a simple point of view; we have values that can be used to organize,rank,sort,etc. different people)
 * */
public class Person implements Comparable<Person>{

	/*Attributes of a person */
	private String name = "";
	private double netWorth = 0;
	
	public Person()
	{
		this("John Doe", 0);
	}
	
	public Person(String aName, int someNetWorth)
	{
		name = aName;
		netWorth = someNetWorth;
	}
	
	/*We need to implement a comapreTo method, remember this method expects
	 *to receive some type (i.e. Person, Basic Element, Anything)*/
	public int compareTo(Person aPerson) 
	{
		// We are worth more than that person 
		if(this.netWorth > aPerson.getNetWorth())
			return 1;
		// We are worth the same
		else if(this.netWorth == aPerson.getNetWorth())
			return 0;
		// I'm worth less than that person (of course your not worthless ;-)
		else
			return -1;
	}
	
	/*Setters and Getters*/
	public double getNetWorth()
	{
		return netWorth;
	}
	
	public String getName()
	{
		return name;
	}
}
