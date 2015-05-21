import java.util.Scanner;
public class Flow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int x;
		
		do {
		
		System.out.println("Declare a value for variable x.");
		x = input.nextInt();
		
		}while (x >= 0);
		
		
		//Goodbye
		System.out.println("Bye!");
		
		input.close();

	}

}
