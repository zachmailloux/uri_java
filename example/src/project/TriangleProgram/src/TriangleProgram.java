import java.util.Scanner;

public class TriangleProgram { 
	/**
	 * @param args
	 */    
	public static void main(String[] args) {
		// TODO Auto-generated method stub                 
		float angle1;        
		float angle2;        
		float angle3;        
		float result;        
		int option; 
		
		Scanner input = new Scanner (System.in);                 
		
		do{                         
			System.out.println("Input angle 1: ");            
			angle1 = input.nextFloat();            
			System.out.println("Input angle 2: ");            
			angle2 = input.nextFloat();            
			System.out.println("Input angle 3: ");            
			angle3 = input.nextFloat();        
			
			result = angle1 + angle2 + angle3;                         
			
			if (result == 180){                
				
				System.out.println("These angles make a triangle.");
				
				if (angle1 != angle2 && angle2 != angle3 && angle1 != angle3) {
					System.out.println("This triangle is a scalene triangle.");
					if (angle1 ==90 || angle2 == 90 || angle3 ==90){
						System.out.println("This triangle is a right triangle.");
					}
				}                
				
				else if (angle1 == angle2 && angle2 == angle3){
					System.out.println("This triangle is an equilateral triangle.");
					}   
				
				else{
					System.out.println("This triangle is an isosceles triangle.");
					if (angle1 ==90 || angle2 == 90 || angle3 ==90){
						System.out.println("This triangle is a right triangle.");
					}
					}                 
				}//end if            
			
			else{
				System.out.println("These angles do not make a triangle.");
				}//end else                         
			
			System.out.println("Would you like to try again?");
			System.out.println("(1) Yes");
			System.out.println("(2) No");
			option = input.nextInt();
			}//end do        
		while (option == 1);
		}//end main }
		
	}
