import java.util.Scanner;
public class Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int num_ints = 6;
		Scanner input = new Scanner(System.in);
		int numbers[] = new int[num_ints];
		
		for(int x=0; x<num_ints; x++){
			System.out.println("Enter the next number");
			numbers[x] = input.nextInt();
		}
		
		int toSort = 6;
		int first;
		int second;
		do{
			for(int y=0; y<toSort-1; y++){
				first = numbers[y];
				second = numbers[y+1];
				if(first>second){
					numbers[y] = second;
					numbers[y+1] = first;
				}
			}
			toSort--;
		}while(toSort>1);
		
		for(int n=0; n<num_ints; n++){
			System.out.println(numbers[n]);
		}
		
		input.close();
	}

}
