import java.util.Scanner;
public class NumberRanges {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner+Variables
		Scanner input = new Scanner(System.in);
		int num;
		
		//Input
		System.out.println("Enter an integer");
		num = input.nextInt();
		if (num > 5 && num < 10){
			System.out.println("The number is between 5 and 10");
		}
		
		else if (num <= 5){
			System.out.println("The number is 5 or less");
		}
		else{
			System.out.println("The number is 10 or more");
			
		//Close
		input.close();
		}

	}

}