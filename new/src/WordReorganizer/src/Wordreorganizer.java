import java.util.Scanner;
public class Wordreorganizer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		boolean swapped = false;
		char[] array;
		int index=0;
		String str;
		

		System.out.println("Please enter a phrase.");
		str = input.nextLine();
		array = str.toCharArray();
		
		
		if (swapped == true){
		swapped = false;
		
		for (index = 0; index < (array.length - 1); index++){
			
			if (array[index] > array[index + 1]){
				
				char temp = array[index + 1];
				
				array[index + 1] = array[index];
				array[index] = temp;
				swapped = true;
				for (index = 0; index > array.length; index++){
				System.out.print(array[index]);
			}
		}
			
		}
		
		
		}	
		
		input.close();
			
			
		}
		

	}


