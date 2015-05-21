import java.util.Scanner;
public class MyArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String names[] = new String [7];
		Scanner input = new Scanner (System.in);
		int index = 0;
		do{
			System.out.println("Enter name number " + index + ": ");
			names[index] = input.next();
				index++;
		}while(index < names.length);
		input.close();
		for (int index1 = 0; index1 < names.length; index++){
			System.out.println("Name number " + index1 + " is " + names[index1]);
			index1++;
		} 
		
	}
}


