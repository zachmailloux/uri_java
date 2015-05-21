import java.util.Scanner;
import java.util.Random;
public class ChanceRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String names[] = new String [7];
		Scanner input = new Scanner(System.in);
		Random generator = new Random();
		int option;
	
		
		for (int index = 0; index < names.length; index++){
			System.out.println("Enter name " + (index + 1) + ": ");
			names[index] = input.next();
		}	
		do{
		System.out.println("The winner is " + names[generator.nextInt(6)] + "!");
		System.out.println("Would you like to pick a new name? <1> YES <2> NO");
		option = input.nextInt();
		
		
		
		}while(option == 1);
		System.out.println("Goodbye!");
		input.close();
	}

}
