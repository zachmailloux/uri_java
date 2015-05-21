import java.awt.Frame;
import java.util.Scanner;
import java.awt.Graphics;
import java.util.Random;

public class game extends Frame{
	Random random = new Random();
	public int yourFace = 0;
	public int x = 0;
	public int y = 0; 
	die dice;
	die randomdice;
	int countdown;
	public int randFace = random.nextInt(7);
	public int randX = random.nextInt(400);
	public int randY = random.nextInt(400);

	
	public game(){
		setSize(500,500);
		setTitle("To the Window, to the Wall");
		setResizable(false);
		setVisible(true);
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the die face number"); //Prints prompt
		yourFace = keyboard.nextInt();					// takes value for the face
		System.out.println("Enter a x coordinate"); //Prints prompt
		x = keyboard.nextInt(); 					// takes value for the x coordinate
		System.out.println("Enter a y coordinate"); //Prints prompt
		y = keyboard.nextInt(); 			// takes value for the y coordinate
		System.out.println("Your stats -  X value : " + x + "  Y value: " + y + "    Face value: " + yourFace);
		System.out.println("Opponents stats -  X value : " + randX + "  Y value: " + randY + "    Face value: " + randFace);
		dice = new die(yourFace,x,y); //rolls your dice
		repaint(); //I had a seriously annoying error with printing so I used this to make it work
		try { // this causes the program to wait 2 seconds
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 randomdice = new die(randFace, randX, randY); // roll opponents die
    	 whoWon(yourFace, randFace); // calculates who won
    	 repaint();

							// calls for the rollDie method with our 3 new values
		
		
	}

	public void paint(Graphics pane){
		if (dice != null){
			dice.paint(pane);}
		if (randomdice != null){
			randomdice.paint(pane);}
	}
	public void whoWon(int face1, int face2){
		if (face1 > face2){
			System.out.println("You won!");}
		else if (face1 == face2){
			System.out.println("Its a tie!");}
		else if (face1 < face2){
			System.out.println("You lost!");}
	
		
	}
}

