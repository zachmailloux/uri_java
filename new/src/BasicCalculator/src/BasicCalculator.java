import java.util.Scanner;
public class BasicCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Scanner input = new Scanner (System.in);
		float number1;
		float number2;
		float result;
		int option;
		
		System.out.println("Input first number.");
		number1 = input.nextFloat();
		
		System.out.println("Input second number.");
		number2 = input.nextFloat();
		
		do {
		
		System.out.println(" ");
		System.out.println("===MENU===");
		System.out.println("<1> ADD");
		System.out.println("<2> SUBTRACT");
		System.out.println("<3> MULTIPLY");
		System.out.println("<4> DIVIDE");
		System.out.println(" ");
		
		option = input.nextInt();
		
		//Switch
		switch (option){
		
		case 1:
			result = number1 + number2;
			System.out.println(number1 + " + " + number2 + " = " + result);
			break;
		case 2:
			result = number1 - number2;
			System.out.println(number1 + " - " + number2 + " = " + result);
			break;
		case 3:
			result = number1 * number2;
			System.out.println(number1 + " * " + number2 + " = " + result);
			break;
		case 4:
			result = number1 / number2;
			System.out.println(number1 + " / " + number2 + " = " + result);
			break;
		}
		System.out.println("Woulf you like to continue? <1.> YES. <2.> NO.");
		option = input.nextInt();
		
		}
		while (option == 1);
		
		System.out.println("Goodbye!");

		//Close
				input.close();
	}

}
