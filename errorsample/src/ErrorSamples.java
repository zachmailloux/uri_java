
public class ErrorSamples {
	/*
	 * The following is a list of common errors that occur in java.
	 * The idea is that learning from these common problems you can avoid
	 * the common problems and continue on with your program.
	 */
	
	

	public static void main(String[] args) {
		//Here is a variable error
		name = "Taric";
		System.out.println(name);
		// Now you can click on the x 
		// A list of solutions will appear, you can try one of the option. 
		// The first one should do the trick, but be sure to read the options and choose the one that makes the most sense. 

	}
	
	public static void sayName(){
		//Below we have a simular error.
		// the answer to this problem is not as simple as the first. 
		// Here we can see that the variable "name" is created in one method and being used in another
		// in order to create a variable that can be used with ANY method we want to declare it outside
		// of the methods DIRECTLY after the class in your code
		System.out.println(name);	
	}

}
