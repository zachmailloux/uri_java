import java.util.Scanner;



public class consoles { 
	//Above is the class. A class is a "mini program" in which there are subprograms called "methods"
	//Public is a visibility modifier. Public means any other class can use it
	// private means its hidden, but thats for a later lesson
	//Notice the open bracket, if you highlight it, you will see a box around the corresponding bracket on the bottom
	//That means that everything inside of those brackets "belong to it". It's common to have a problem with your code
	// that is caused purely because you are missing a bracket
	//This means that the 

	public static void main(String[] args){ 
		//for now know that the main method automatically runs whenever you start your program.
		
		
		//Basic printing
		
		System.out.println("Hello World!");
		System.out.print("Example");
		System.out.print("See?");
		//System.out.println() allows you to display information in the console (box below). 
		//the ln at the end of print means that the whole line will be dedicated to that statement. 
		//when we say just print they will print on the next available space.
		
		//We can also use System.out.println() to do math.
		System.out.println(2+2);//here the 4 will be added to the end of the two previous lines.
		System.out.println(3/4);//This line of code will return a 0 because Java naturally deals with integers unless told otherwise.
		System.out.println(10%3); // the % is the remainder symbol. So it returns the value left over after you subtract 3 from 10 as many times as you can
		
		//Printing both text and numbers
		System.out.println("Za"+"ch "+"Mailloux");//now the + signs here are simply saying "and". This allows you to combine multiple things into one phrase
		System.out.println("Paul is"+20+"years old"); 
		//now notice that the s20y. this is because the 20 appears RIGHT after the s, so we can change this by adding spaces before and after the words around the number
		
		System.out.println("Paul is "+20+" years old"); //like so
		
		System.out.println("2 + 2 = "+ 2+2);//Now the reason this returns 2 + 2 = 22 is because once we use text, or a "String", it assumes that you want to add the numbers as a string value;
		System.out.println("2 + 2 = "+ (2+2)); //to fix this you add the sum of (2+2)
		
		
		//Variables
		//Some basic DATA TYPES that are very common are Strings, ints, doubles, chars and floats.
		
		String name = "Paul"; // a string is a line of text, or a word.
		//we saved the word "Paul" to the variable name.
		System.out.println(name);//this will print the value that name represents
		
		int age = 20; // a int is an integer ( whole number ). So now whenever I say age it will be replaced with 20
		//The reason these variables are so useful is that you can have a whole program based around someones age, 
		//so rather than have to go through the program and change 20 to a different number all over the place, you
		//can just say age = 32 so that the whole program knows.
		System.out.println(age);
	
		double weight = 140.5;
		//doubles are numbers in which you can have decimals. If you are working with whole numbers however you should
		//always try to use integers as they take up less memory and in the large scale save computing time
		System.out.println(name + " is " + age + " years old and weighs "+ weight + " pounds");
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your name:");
		
		name = input.next();
		
		System.out.println("Hello "+ name);
		
		
		
	}
}
