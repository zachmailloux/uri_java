import java.util.Scanner;
public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Variables
		Scanner input = new Scanner(System.in);
		String name;
		int age;
		float weight;
		
		//Console input
		System.out.println("Enter your name:");
		name = input.nextLine();
		
		System.out.println("How old are you?");
		age = input.nextInt();
		
		System.out.println("How much do you weigh?");
		weight = input.nextFloat();
		
		//Console speaking
		System.out.println("My name is "+name);
		System.out.println("I am "+age+" years old");
		System.out.println("I weigh "+weight+" pounds");
		
		//Close
		input.close();
		
	}

}
