import java.util.Scanner;

import javax.swing.JOptionPane;

public class SeasonChecker{

	/**
	 * @param 
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		String month;
		
		System.out.println("Enter any month, and I will tell you what season it belongs in: ");
		month = input.nextLine();
		
	if(month.equals("December") || month.equals("January") || month.equals("February")){
		JOptionPane.showMessageDialog(null,  "It is winter!");
		}
	else if(month.equals("March") || month.equals("April") || month.equals("May")){
		JOptionPane.showMessageDialog(null,  "It is spring", "Error", JOptionPane.ERROR_MESSAGE);
	}
	else if(month.equals("June") || month.equals("July") || month.equals("August")){
		JOptionPane.showMessageDialog(null,  "It is summer!");
	}	
	else if(month.equals("September") || month.equals("October") || month.equals("November")){
		JOptionPane.showMessageDialog(null,  "It is fall");
	}
	else{
		JOptionPane.showMessageDialog(null,  "What world do you live on?", "Error" , JOptionPane.ERROR_MESSAGE);
	





	}}}
