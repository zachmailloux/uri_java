import java.util.Scanner;
/**
 * Input:
 * 	A string from user input when prompted.
 * 
 * Output:
 * 	A string translated to the reverse, (i.e. A to a or f to F). * 
 * 
 * @author mbessette
 *
 */
public class FixMe {
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in); //Defines the variable keyboard
		System.out.println("Say something!");      //Prints a prompt
		String input = keyboard.nextLine();        //Awaits user input and stores it as a string declared variable
		String second = "";                        //Declares and sets the variable "second" to ""
		for(int i = 0; i<input.length();i++)       //Begins loop and initializes counter
		{
			int letterRep = (int)(input.charAt(i));        //s is declared as int and set to the ASCII value of the
			                                               //i positioned letter
			if(letterRep >= 65 && letterRep <=90)          //Checks if s is within the appropriate range
				letterRep+=32;                             //if so 32 is added to s's value
			else if(letterRep>=97 && letterRep <= 122)     //If first was false, then checks if s is within this appropriate range
				letterRep-=32;                             //if so 32 is subtracted from s's value
			second += (char)letterRep;                     //the char s is added to second
		}
		System.out.println(second);                        //print the second statement
	}
}
