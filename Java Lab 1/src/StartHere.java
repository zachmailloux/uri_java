import java.util.Scanner;//for keyboard input

/**
 * Every class should have javadoc comments immediately above the class
 * header saying what the class represents and what methods are available.
 * The purpose of this class is to be used in a demonstration of the tools
 * in Eclipse.
 * @author dkm
 *
 */
public class StartHere {

	/**
	 * The main method gives examples of output to monitor, input from the
	 * keyboard and variable declarations.
	 * @param args not used in this application
	 */
	public static void main(String[] args) {
		
		//The Scanner takes input from the keyboard
		Scanner keyboard = new Scanner(System.in);
		
		//Prompt the user
		System.out.println("Enter an integer");
		
		//Stores the number the user enters in the variable num
		int num = keyboard.nextInt();
		
		//We assign the value on the right to the variable on the left of the assignment
		//operator
		num = num + 1;
		
		//Prompt for another number
		System.out.println("Enter a floating point number");
		
		//Store it in a variable of type double
		double fraction = keyboard.nextDouble();
		
		//Display the difference
		System.out.println("The difference between the first number and " +
				"the second is " + (num - fraction));
	}

}
