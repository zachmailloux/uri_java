/**
 * "A Few Words"
 * @author Daniel Dides, Alex Bouthillier, Jacobo Musali
 *
 * In the second lab you'll:
 * 		define your own class
 * 		practice String manipulation
 *
 * Given a sentence typed in at the keyboard, the program will be able
 * to determine the first and last word.  The program assumes that the
 * sentence typed in at the keyboard does not contain punctuation, and
 * that words are simply separated by spaces.
 *
 */

import java.util.Scanner;

public class Lab02 {

	/**
	 * Input: A simple line of text made up of a few words (separated
	 * by spaces)
	 * 
	 * Display: The first and last words in that line of text,
	 * 			the length of the original text and how much extra
	 * 			white space was before the first word and after the last.
	 * 
	 * 
	 * @param args no parameters expected
	 */
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);//to read input
		
		String theWholeLine;//to hold the original String
		
		Words myWords;//to work with the String
		
		System.out.println("Could you say a few words?");
		
		theWholeLine = keyboard.nextLine();//gets the whole line
		
		myWords = new Words();
		
		myWords.setString(theWholeLine); //initializes our Object
		
		String first = myWords.firstWord();//returns the first word, not including
											//any white space before or after
		
		String last = myWords.lastWord();//also does not include any white space
		
		
		int originalLength = myWords.getOriginalLength(); //includes any white space
										//before the first word or after the last
		
		int length = myWords.getStringLength();//does not include white space
		
		String trimmedString = myWords.trimmedString();//The original String without
										//any white space before or after.
		
		
		//Now it's up to you to display the trimmed String, the length of the trimmed
		//String and how much white space has been removed and the first and last
		//words in the String.
		
		System.out.println("The trimmed string is: " + "\"" + trimmedString +"\"");
		System.out.println("The length of the trimmed string is: " + length + " characters");
		System.out.println("...after omitting " + (originalLength - length) + " spaces of white space.");
		System.out.println("The first word of the string is: " + "\"" + first + "\"");
		System.out.print(" and the last word of the string is " + "\"" + last + "\"");
		
		
		

		
		

	}

}
