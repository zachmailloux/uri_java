import java.util.Scanner;

/**
 * 
 */

/**
 * This simple program find the sum of two numbers.
 * 
 * Input:
 * 	Two numbers from user input when prompted.
 * 
 * Output:
 * 	One number printed when sum is found.
 * 
 * @author mbessette
 *
 */
public class MyProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in); //Defines the variable keyboard
			
		System.out.println("Enter your first number to add."); //Prints prompt
		int firstInput = keyboard.nextInt();                   //Set variable from user input
		
		System.out.println("Enter your second number to add.");//Print prompt
		int secondInput = keyboard.nextInt();                  //Set variable from user input
		
		System.out.println();                                  //Prints a blank line
		System.out.print("The sum of your numbers is: ");      //Prints statement that answer is coming
		System.out.print(firstInput + secondInput);	           //Solves and prints sum
		
		
	}

}
