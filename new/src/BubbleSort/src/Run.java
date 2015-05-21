import java.util.Scanner;
public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner (System.in);
		boolean swapped = false;
		int[] numbers = new int[6];
		int index = 0;
				
		for (index = 0; index < numbers.length; index++){
			System.out.println("Please input a value for number " + (index + 1) + ".");
			numbers[index] = input.nextInt();
		}
			
		do{
			
		swapped = false;
		
		for (index = 0; index < (numbers.length - 1); index++){
			
			if (numbers[index] > numbers[index + 1]){
				
				int temp = numbers[index + 1];
				
				numbers[index + 1] = numbers[index];
				numbers[index] = temp;
				swapped = true;
			}
		}
		for (index = 0; index < numbers.length; index++){
			System.out.println(numbers[index]);
		}
		} while (swapped == true);
		
		
		
		input.close();
		}
		
	}


