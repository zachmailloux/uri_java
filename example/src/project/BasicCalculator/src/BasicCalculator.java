import java.util.Scanner;

public class BasicCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Scanner input = new Scanner(System.in);
		
		int number1;
		int number2;
		
		System.out.println("Welcome to BasicCalculator!");
		System.out.println("Type in 2 numbers here:");
		number1 = input.nextInt();
		number2 = input.nextInt();

		int operator;

		System.out.println("Now select an operater by typing in the number associated with it.");
		System.out.println("(1) Addition");
		System.out.println("(2) Subtraction");
		System.out.println("(3) Multiplication");
		System.out.println("(4) Division");
		operator = input.nextInt();

		int roll = operator;
		int result; 

		switch (roll){
		case 1 :
			result = number1 + number2;
			System.out.println(result);
			break;
		case 2 :
			result = number1 - number2;
			System.out.println(result);
			break;
		case 3 :
			result = number1 * number2;
			System.out.println(result);
			break;
		case 4 :
			result = number1 / number2;
			System.out.println(result);
			break;
			
}

}}
