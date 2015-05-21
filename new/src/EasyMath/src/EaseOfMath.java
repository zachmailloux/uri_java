import java.util.Scanner;
public class EaseOfMath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int number;
		
		//Ask
		System.out.println("Input an integer.");
		number = input.nextInt();
		System.out.println("Squaring integer...");
		
		//Return
		System.out.println(number + " * " + number + " = " + number * number);
		
		//Close
		input.close();
	}

}
