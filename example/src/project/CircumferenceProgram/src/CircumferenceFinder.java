import java.util.Scanner;

public class CircumferenceFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//declare variables
				Scanner input = new Scanner(System.in);
				
final float PI = 3.14f;

float radius;
float circumference;

		//read input from console
		System.out.println("Enter the radius: ");
		radius = input.nextFloat();

circumference = 2 * radius * PI;

System.out.println("The circumference is: " + circumference);
	}

}
