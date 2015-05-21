/* 
	Programmer: Nickie
	
	CSC 212					Lab #1 - A basic element
							========================

	Description:
			This first lab illustrates a very typical Java program developed as an
		application.

			You will notice that the primary class includes the main method.  The
		main method instantiates and "activates" the one object that does most
		everything in the rest of the program.
*/

public class Lab01
{
	//
	//	The main method is quite simple.
	//	The demo does everything for us.
	//	
	public static void main(String[] args) 
	{
		LabDemo theDemo = new LabDemo();

		System.out.println("Hi!");

		theDemo.action();
		
		System.out.println("Bye!");
	}

}	// end Lab01
