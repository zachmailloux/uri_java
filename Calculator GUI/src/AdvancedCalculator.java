import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class AdvancedCalculator {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		//declaring variables	
	
		
		Scanner input = new Scanner(System.in);
		float number1;
		float number2;
		float number3;
		float number4;
		double pi = Math.PI;
		double result = 0;
		int option=0;
		
		int again = 1;
		Icon iconA = new ImageIcon(new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXh2DlKKXKJasGtF7V1zFuKeCT0FZjefrjfpmnpGU01VoatQqgrA"));
		// PASTE IMAGE URL IN THE LINE BELOWWWWWW
		Icon iconB = new ImageIcon(new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXh2DlKKXKJasGtF7V1zFuKeCT0FZjefrjfpmnpGU01VoatQqgrA"));
		JOptionPane.showMessageDialog(null,("Hello and welcome to Remmy's Calculator! \n                   Click 'Ok' to continue"),null, again, iconA);
		do{
			
			Object[] selectionValues = null;
			Object initialSelectionValue = null;
			int messageType = 0;
			option  = Integer.parseInt((String) JOptionPane.showInputDialog(null, "===========Menu=========== \n <1> Add \n <2> Subtract \n <3> Multiply \n <4> Divide \n <5> Find the area of a shape ", "Remmy's Calculator", messageType, iconB, selectionValues, initialSelectionValue));
	//	option = Integer.parseInt(JOptionPane.showInputDialog("===========Menu=========== \n <1> Add \n <2> Subtract \n <3> Multiply \n <4> Divide \n <5> Find the area of a shape "));
		
	/*	System.out.println(null,( "==== MENU ===="));
		JOptionPane.showMessageDialog(null,("<1> Add"));
		JOptionPane.showMessageDialog(null,("<2> Subtract"));
		JOptionPane.showMessageDialog(null,("<3> Multiply"));
		JOptionPane.showMessageDialog(null,("<3> Divide"));
		JOptionPane.showMessageDialog(null,(" "));*/

		
		switch (option){
		case 1:
			number1 = Integer.parseInt(JOptionPane.showInputDialog("input number 1"));
			number2 = Integer.parseInt(JOptionPane.showInputDialog("input number 2"));
			result = number1 + number2;	
			JOptionPane.showMessageDialog(null,(number1 + "+" + number2 + " = " + result));
			break;
			case 2:
			number1 = Integer.parseInt(JOptionPane.showInputDialog("input number 1"));
			number2 = Integer.parseInt(JOptionPane.showInputDialog("input number 2"));
			result  = number1 - number2;
			JOptionPane.showMessageDialog(null,(number1  + " - " + number2+ " = " + result));
			break;
			case 3:
				number1 = Integer.parseInt(JOptionPane.showInputDialog("input number 1"));
				number2 = Integer.parseInt(JOptionPane.showInputDialog("input number 2"));
				result = number1 * number2;
			JOptionPane.showMessageDialog(null,(number1 + " * " + number2 + " = " + result));
			break;
			case 4:
				number1 = Integer.parseInt(JOptionPane.showInputDialog("input number 1"));
				number2 = Integer.parseInt(JOptionPane.showInputDialog("input number 2"));
				result = number1 / number2;
			JOptionPane.showMessageDialog(null,(number1 + " / " + number2 + " = " + result));
			break;
			case 5:
				number1 = Integer.parseInt(JOptionPane.showInputDialog("What shape would you like to find the area of? (Inches)  \n <1> Square \n <2> Circle \n <3> Triangle \n <4> Rectangle \n <5> Trapezoid \n <6> Cube (3D)"));
				if (number1 == 1){
					//ask for side length then return
					 number3 = Integer.parseInt(JOptionPane.showInputDialog("input the lenth on one side of the square"));
					result = number3 * number3 ;}
				else if (number1 == 2){
				number3 = Integer.parseInt(JOptionPane.showInputDialog("input the radius of the circle"));
				result = number3 * pi * pi;}
				else if (number1 == 3){
				 number3 = Integer.parseInt(JOptionPane.showInputDialog("input the base of the triangle"));
				 number4 = Integer.parseInt(JOptionPane.showInputDialog("input the height of the triangle"));
				result = number3 * number4 / 2;}
				else if (number1 == 4){
				 number3 = Integer.parseInt(JOptionPane.showInputDialog("input the width of the rectangle"));
				 number4 = Integer.parseInt(JOptionPane.showInputDialog("input the height of the other side of the rectangle"));
				result = number3 * number4;
				}
				else if (number1 == 5){
					number1 = Integer.parseInt(JOptionPane.showInputDialog("input the lenght of the top of the Trapezoid"));
					number2 = Integer.parseInt(JOptionPane.showInputDialog("input the lenght of the bottom of the Trapezoid"));
					number3 = Integer.parseInt(JOptionPane.showInputDialog("input the height of the Trapezoid"));
				    result = ((number1 + number2) / 2) * number3;
				}
				else if(number1 == 6){
					number1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the width of the cube"));
					number2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the height of the cube"));
					number3 = Integer.parseInt(JOptionPane.showInputDialog("Enter the depth of the cube"));
					result = number1 * number2 * number3;
				}
				    else{ 
					JOptionPane.showMessageDialog(null,("sorry, that option is not avalable!"));
				}
				}
		JOptionPane.showMessageDialog(null, "The area is " + result + " square inches");
		again = JOptionPane.showConfirmDialog(null, "would you like to continue?", "exit", JOptionPane.YES_NO_OPTION);
		    
		
			
		
		}//end switch
		while (again == 0);
	
		
		//end do
		
	

		JOptionPane.showMessageDialog(null,("goodbye!"));
	}
		
		}
		
