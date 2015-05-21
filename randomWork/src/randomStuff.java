import java.util.Random;
import java.util.Scanner;


public class randomStuff {


	public static void main(String[] args) {
		
		int playerD;
		int playerH;
		int enemyH;
		int enemyD;
		
		playerH = 100;
		enemyH = 65;
		
		Random gen = new Random();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("An enemy appears!");
		do{
			System.out.println("It's your combat phase! Choose an option: \n<1> Attack \n<2> Flee");
			int choice1= input.nextInt();
			if(choice1==1){
				enemyD = gen.nextInt(10)+10; //10-20
				playerD = gen.nextInt(10)+15; //15-25
				playerH-=enemyD; //this means 10-20
				enemyH-= playerD; //this means 15-25
				System.out.println("The enemy delt " + enemyD + " to you. Your health is now "+ playerH);
				System.out.println("You delt " + playerD + " to the enemy. The enemy's health is now "+ enemyH);
			}
			else if(choice1==2){
				
			}
			
		}while((playerH>0)&&(enemyH>0));

	}

}
