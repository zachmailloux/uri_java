import java.util.Scanner;

public class NumberRanges {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int number;
	
		//read input from console
				System.out.println("Enter any number in between 5 and 10: ");
				number = input.nextInt();
				
		if (number > 5 && number < 10){
			System.out.println("This is correct");
		}
		else{
			System.out.println("This is incorrect");
		}
	}

}
