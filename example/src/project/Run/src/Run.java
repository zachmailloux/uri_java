	import java.util.Scanner;

	public class Run {
	/**     * @param args     */    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub                
		
		//declaring variables        
		Scanner input = new Scanner(System.in);        
		float number1;        
		float number2;        
		float result;
		int option;                 
		
		System.out.println("Input first number: ");        
		number1 = input.nextFloat();                 
		System.out.println("Input second number: ");
		number2 = input.nextFloat();
		
		do{
			System.out.println(" ");        
			System.out.println("===== MENU =====");       
			System.out.println("<1> Add");       
			System.out.println("<2> Subtract");       
			System.out.println("<3> Multiply");       
			System.out.println("<4> Divide");       
			System.out.println(" ");                
			option = input.nextInt();                 
			
			switch (option){
			case 1:             result = number1 + number2;
			System.out.println(number1 + " + " + number2 + " = " + result);
			break;
			
			case 2:
				result = number1 - number2;
				System.out.println(number1 + " - " + number2 + " = " + result);
				break;
				
			case 3:             result = number1 * number2;
			System.out.println(number1 + " * " + number2 + " = " + result);
			break;
			
			case 4:
				result = number1 / number2;
				System.out.println(number1 + " / " + number2 + " = " + result);
				break;
				
			default: 
				System.out.println("Sorry, that option is not available!");
				}//end switch 
			 
				System.out.println("Would you like to continue? <1.> YES. <2> NO.");
			option = input.nextInt();
		}
			while (option == 1);
			
		System.out.println(" Goodbye!");
		}}//end main  Close
	
