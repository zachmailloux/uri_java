//Zachary Mailloux
//September 8th 2013
import java.util.Scanner;
public class Date {
	
	 static int totalDays = 735135; //days since 0 (supposed birth of christ)
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		toString(totalDays); //calls forward the method to show the current date
		Scanner input = new Scanner(System.in); //add scanner so that the user can add info
		String next; //define next
		do{//so that you can keep advancing through the days
		System.out.println("Type next to advance to tomorrow");
		next = input.next(); //declare next
		if(next.equalsIgnoreCase("next")){//if they say "next:"
			advance();//add 1
			toString(totalDays);//reprint date
		}
		}while(next.equalsIgnoreCase("next")); //while they said "next"
	}
	
	//the advance method is incredably simple and literally only adds one to the current amount of days
	public static void advance(){
		totalDays+=1; //add one to the total days
	}
	public static void toString(int count){
		int leap=28;//the variable for the amount of days in febuary
		int leapyear=((count/1461)*4)+1;//the 1461 is the amount of days in 4 years. The idea is to narrow out whether its leap year
		count = count%1461;
	//	System.out.println(count);
		if(count>1154){// if its greater than the days until feb 28/29th
			leap=29; //make febuary have 29 days
		}
		int year = count/365; //how many years past the last leap year
		count = count%365; //remainder days
		int month=1; //default month (January)
		int day=count; //default (however many days left)
		int daysIntoYear=31; //after january
		if(count>daysIntoYear){ //Febuary
			day = count-daysIntoYear;
			daysIntoYear+=leap;
			month =2;
		}
		if(count>daysIntoYear){ //March
			day = count-daysIntoYear;
			daysIntoYear+=31;
			month =3;
		}
		if(count>daysIntoYear){ //April
			day = count-daysIntoYear;
			daysIntoYear+=30;
			month =4;
		}
		if(count>daysIntoYear){ //May
			day = count-daysIntoYear;
			daysIntoYear+=31;
			month =5;
		}
		if(count>daysIntoYear){ //June
			day = count-daysIntoYear;
			daysIntoYear+=30;
			month =6;
		}
		if(count>daysIntoYear){ //July
			day = count-daysIntoYear;
			daysIntoYear+=31;
			month =7;
		}
		if(count>daysIntoYear){ //August
			day = count-daysIntoYear;
			daysIntoYear+=31;
			month =8;
		}
		if(count>daysIntoYear){ //Sept
			day = count-daysIntoYear;
			daysIntoYear+=30;
			month =9;
		}
		if(count>daysIntoYear){ //oct
			day = count-daysIntoYear;
			daysIntoYear+=31;
			month =10;
		}
		if(count>daysIntoYear){ //nov
			day = count-daysIntoYear;
			daysIntoYear+=30;
			month =11;
		}
		if(count>daysIntoYear){ //dec
			day = count-daysIntoYear;
			daysIntoYear+=31;
			month =12;
		}
		
		System.out.println(month+"/"+day+"/"+(year+leapyear));
		
	}
	
}
