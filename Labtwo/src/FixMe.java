/**
 * Caesar Cipher prompts the user for input:
 * 	the message to be enciphered or deciphered
 * 	whether the message is to be enciphered or deciphered
 * 	a letter to use as a key
 * 
 * It then does the enciphering/deciphering and lets the 
 * user know what the message is when enciphered or deciphered 
 * using that key.
 * 
 * The user can continue to encipher/decipher messages
 * as long as they choose.
 */

import java.util.Scanner;


public class CaesarCipherStartup {

	/**
	 * The main method controls the program, but calls upon a helper method
	 * to do the actual enciphering/deciphering.  It is up to the main 
	 * method to interact with the user to get the input and display
	 * the output.
	 * @param args
	 */
	public static void main(String[] args) {
		
		//the user can continue to encipher/decipher messages until play
		//becomes false
		boolean play = true;
		
		//Used to get input from the user via the keyboard
		Scanner keyboard = new Scanner(System.in);
		
		//the main loop that prompts the user for input and displays
		//the output, until the user is tired of enciphering/deciphering
		do{
			//Prompt the user for the message
			
			System.out.println("Type your message");
			
			
			//Gets the message, however many words, up to when the
			//user hits enter
			String message = keyboard.nextLine();
			
			
			//Prompt the user for whether s/he wants to encode or decode
			System.out.println("Press 'e' to encode or 'd' to decode");
			
			
			
			//get the next token, (everything up to the next white space)
			String encode = keyboard.next();
			
			//We need to get the first letter entered, in case they
			//entered more than one letter, and compare it to 'e'
			
			//So we only need to compare it to the lower case, we
			//convert the input to all lower case
			encode = encode.toLowerCase();
			
			//Then we get the first character
			char first = encode.charAt(0);
			
			//You need a variable to hold whether we're enciphering or 
			//deciphering
			
			
			
			
			if(first == 'e'){//if it's e, then we're enciphering
				//What should happen here?
		
			
			
			//Now we prompt the user for the key
			
			System.out.println("Enter a key in the form of one letter");
			
			
			//And get it from the user's input
			String keyString = keyboard.next();
			char key = keyString.charAt(0);
			
			String second = " ";
			//Invoke the cipher method (and store the result)

			for(int i = 0; i<message.length();i++)
				{int letterRep = (int)(message.charAt(i));        //s is declared as int and set to the ASCII value of the
			//i positioned letter
				System.out.println("letterRep = " + letterRep);
				System.out.println("Key = " + key);
				if(letterRep >= 65 && letterRep <=90)   //Checks if s is within the appropriate range
					letterRep-=65;
					letterRep+=(key-65);                             //if so 32 is added to s's value
                      //if so 32 is subtracted from s's value
				second += (char)letterRep; 
			}
			System.out.println(second);
			


			//Display the result to the user 
			