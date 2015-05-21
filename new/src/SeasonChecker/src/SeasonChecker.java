import java.util.Scanner;
public class SeasonChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Variables
		Scanner input = new Scanner(System.in);
		String month;
		
		//Input
		System.out.println("What month is it?");
		month = input.nextLine();
		
		if (month.equals("December") || month.equals("January") || month.equals("February")){
			System.out.println("It's Winter!");
		}
		else if (month.equals("March") || month.equals("April") || month.equals("May")){
			System.out.println("It's Spring!");
		}
		else if (month.equals("June") || month.equals("July") || month.equals("August")){
			System.out.println("It's Summer!");
		}
		else if (month.equals("September") || month.equals("October") || month.equals("November")){
			System.out.println("It's Winter!");
		}
		else{
			System.out.println("Month not recognized.");
		}
		//Close
				input.close();
	}

}
