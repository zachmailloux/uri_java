import java.util.Scanner;


public class practice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in); 
		System.out.println("Whats your name?");
		//try typing input. 
		//when you hit . after waiting one second you will see a large list of possible things input can do
		//look over a few of them, they have descriptions on how they work. If you scroll down and find input.next()
		//you will see the term "String" after it. What that means is that the .next(); will return a String value as
		//as apposed to .nextInt() returning an integer.
		
		
		String name = input.next();
		
		System.out.println("How old are you " + name + "?");
		
		int age = input.nextInt(); //this will take the next integer entered in the console and save it as "age"
		
	
		
		if(age == 0){ //the double equals means "the same as". When comparing numbers you dont want to use "=", use "=="
			System.out.println("You're a new born");
		}
		else if(age<=3){ //"else if" is our way of adding another case to the possible outcomes. "<=" means less than OR equal to
			System.out.println("You're an infant");
		}
		else if(age<13){
			System.out.println("You're a child");
		}
		else if(age<20){
			System.out.println("You're a teenager");
		}
		else if(age<65){
			System.out.println("You're an adult");
		}
		else if(age<110){
			System.out.println("You're old");
		}
		else{ //now for the last case we use "else".
			//the else case will occur IF NO OTHER statement is met. In this case any negative or number 
			//equal to or over 110 will return the following statement
			System.out.println("Error: Not valid age");
		}
		
		
		
	}

}
