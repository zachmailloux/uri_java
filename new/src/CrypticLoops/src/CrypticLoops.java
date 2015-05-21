import java.util.Scanner;
public class CrypticLoops {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String message;
		char[] letters;
		
		
		System.out.println("Enter your message:");
		message = input.nextLine();
		
		letters = message.toCharArray();
		
		for (int index = 0; index < letters.length; index++){
			letters[index] += 3;
		}
		System.out.println("Here is your message encrypted.");
		System.out.println(letters);
		
		
		input.close();
		}
	}


