import java.util.Scanner;

import javax.swing.JOptionPane;

public class Archer{
	/**
	 * @param args
	 */

		// variables
		private String name;
		private  static int health = 3;
		Scanner input = new Scanner(System.in);
		static int option;
		
		//constructors (base)
		Archer(){
			name = "Archer";}
		
		//constructors
		Archer(String n){
			name = n;
		}
		
		//Setters
		public void setHealth(int h){
			int health = h;
			
		}
		
		//Getters
		public int getHealth(){
			return health;
		}		
		
		//Methods
		public void healthChange(int h){
			health = health - h;
			
		}
		
		public static void playArcher(){
			Archer archer = new Archer();
			Scanner input = new Scanner(System.in);
			
			int dragonchoice1;
			
		 	System.out.println("(1) Stab with your dagger");
		 	System.out.println("(2) Shoot at the eyes");
		 	System.out.println("(3) Shoot at the wings");
		 	System.out.println("(4) Flee");
		 	dragonchoice1 = input.nextInt();
		 	
		 	int roll = dragonchoice1;
		 			
		 	switch (roll){
		 	case 1 :
		 		System.out.println(" ");
		 		System.out.println("The dragon dodges and scorches you!");
		 		System.out.println("You have lost 1 life");
			 	archer.healthChange(1);
			 	if(archer.getHealth() == 0){
			 		
			 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
			 	}
			 	if (option == 1){
			 		ClassSelection.playGame();
			 	}
		 	break;
		 	
		 	case 2:
		 		System.out.println(" ");
		 		System.out.println("The dragon dodges and scorches you!");
		 		System.out.println("You have lost 1 life");
			 	archer.healthChange(1);
			 	if(archer.getHealth() == 0){
			 		
			 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
			 	}
			 	if (option == 1){
			 		ClassSelection.playGame();
			 	}
		 	break;
		 	
		 	case 3:
		 		System.out.println(" ");
		 		System.out.println("The dragon's wing is torn! He cannot escape, and you stab him with your dagger!");
		 		System.out.println("Victory!");
		 	break;
		 	
		 	case 4:
		 		System.out.println(" ");
		 		System.out.println("You escaped with your life, but failed");
	 				archer.healthChange(3);
		 		option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);

		 	if (option == 1){
		 		ClassSelection.playGame();
		 		break;}
		 	}
		 	if (health > 0){		 	
		 		int giantchoice1;	
		 		
		 			System.out.println(" ");
		 			System.out.println("Next, you encounter a huge giant. Will you...");
		 			System.out.println("(1) Climb up the legs and stab with your dagger");
				 	System.out.println("(2) Shoot at the eyes");
				 	System.out.println("(3) Shoot at the knees");
				 	System.out.println("(4) Flee");
				 	giantchoice1 = input.nextInt();
				 	
				 	int roll2 = giantchoice1;
				 	
				 	switch (roll2){
				 	case 1:
				 		System.out.println(" ");
				 		System.out.println("The giant flings you off before you can make your move.");
				 		System.out.println("You are flung high into the sky, and die when you land.");
				 		System.out.println("You have lost 1 life");
					 		archer.healthChange(1);
						 	if(archer.getHealth() == 0){
						 		
						 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
						 	}
						 	if (option == 1){
						 		ClassSelection.playGame();
						 	}

				 	break;
				 
				 	case 2:
				 		System.out.println(" ");
				 		System.out.println("The clumsy giant is too slow to react, and he is hit.");
				 		System.out.println("Victory!");
				 		archer.healthChange(1);
						 	if(archer.getHealth() == 0){
						 		
						 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
						 	}
						 	if (option == 1){
						 		ClassSelection.playGame();
						 	}
				 	break;
				 		
				 	case 3:
				 		System.out.println(" ");
				 		System.out.println("The arrow does not pierce the knee. ");
				 		System.out.println("You can't reload fast enough, and are crushed.");
				 		System.out.println("You have lost 1 life");
					 		archer.healthChange(1);
						 	if(archer.getHealth() == 0){
						 		
						 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
						 	}
						 	if (option == 1){
						 		ClassSelection.playGame();
						 	}

				 	break;
				 	
				 	case 4:
				 		System.out.println(" ");
				 		System.out.println("You escaped with your life, but failed");
			 				archer.healthChange(3);
				 		break;}}
		 	
				 	if (health > 0){
		 					int hydrachoice1 = 0;
		 				 		
		 				 			System.out.println(" ");
		 				 			System.out.println("Next, you encounter a many-headed hydra. Will you...");
		 				 			System.out.println("(1) Shoot at all of the heads");
		 						 	System.out.println("(2) Shoot at the heart");
		 						 	System.out.println("(3) Lure it away and shoot it in the back");
		 						 	System.out.println("(4) Flee");
		 						 	hydrachoice1 = input.nextInt();
		 						 	
		 						 	int roll3 = hydrachoice1;
		 						 	
		 						 	switch (roll3){
		 						 	case 1:
		 						 		System.out.println(" ");
		 						 		System.out.println("The hydra eats you before you can shoot even two.");
		 						 		System.out.println("You simply can't reload fast enough.");
		 						 		System.out.println("You have lost 1 life");
		 						 		archer.healthChange(1);
		 							 	if(archer.getHealth() == 0){
		 							 		
		 							 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
		 							 	}
		 							 	if (option == 1){
		 							 		ClassSelection.playGame();
		 							 	}

		 						 	break;
		 						 
		 						 	case 2:
		 						 		System.out.println(" ");
		 						 		System.out.println("The hydra is killed instantly from the arrow to the heart.");
		 						 		System.out.println("Victory!");
		 						 	break;
		 						 		
		 						 	case 3:
		 						 		System.out.println(" ");
		 						 		System.out.println("The hydra follows your bait. You rush out to shoot it. ");
		 						 		System.out.println("Unfortunately, some heads are turned backwards, and see you.");
		 						 		System.out.println("You have lost 1 life");
		 						 		archer.healthChange(1);
		 							 	if(archer.getHealth() == 0){
		 							 		
		 							 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
		 							 	}
		 							 	if (option == 1){
		 							 		ClassSelection.playGame();
		 							 	}
		 						 	break;
		 						 	
		 						 	case 4:
		 							System.out.println(" ");
		 							System.out.println("You escaped with your life, but failed");
		 							option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
						 				archer.healthChange(3);
		 					 	if (option == 1){
		 					 		ClassSelection.playGame();
		 					 	}

		 			 	
		 							break;
		 							}
		 						
		 					 	if (health > 0){
		 								 		int robotchoice1;	
		 								 		
		 								 			System.out.println(" ");
		 								 			System.out.println("You are nearing the castle of the king!");
		 								 			System.out.println("A robot servant guards the gate. Will you...");
		 								 			System.out.println("(1) Shoot at the central control box");
		 										 	System.out.println("(2) Cut the wires inside, piercing the shell");
		 										 	System.out.println("(3) Shoot at the joints");
		 										 	System.out.println("(4) Flee");
		 										 	robotchoice1 = input.nextInt();

		 										 	
		 										 	int roll4 = robotchoice1;
		 										 	
		 										 	switch (roll4){
		 										 	case 1:
		 										 		archer.healthChange(1);
		 										 		System.out.println(archer.getHealth());
		 				 							 	if(archer.getHealth() == 0){
		 				 							 		
		 				 							 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
		 				 							 	}
		 				 							 	if (option == 1){
		 				 							 		ClassSelection.playGame();
		 				 							 	}
		 										 		System.out.println(" ");
		 										 		System.out.println("The robot's control box is better protected that you thought.");
		 										 		System.out.println("You are killed within instants.");
		 										 		System.out.println("You have lost 1 life");
		 										 			
		 										 		break;
		 										 	
		 										 	case 2:
		 										 		System.out.println(" ");
		 										 		System.out.println("You charge the robot, but are instantly killed by its laser.");
		 										 		System.out.println("You have lost 1 life");
		 										 		archer.healthChange(1);
		 				 							 	if(archer.getHealth() == 0){
		 				 							 		
		 				 							 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
		 				 							 	}
		 				 							 	if (option == 1){
		 				 							 		ClassSelection.playGame();
		 				 							 	}
		 				 							 	break;
		 										 		
		 										 	case 3:
		 										 		System.out.println(" ");
		 										 		System.out.println("The robot takes the hit and topples to the ground.");
		 										 		System.out.println("He is rendered useless, and you slip by.");
		 										 		System.out.println("Victory!");
		 										 	break;
		 										 	
		 										 	case 4:
		 												System.out.println(" ");
		 												System.out.println("You escaped with your life, but failed");
		 												option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
 										 				archer.healthChange(3);
		 										 	if (option == 1){
		 										 		ClassSelection.playGame();
		 										 	}

		 								 	
		 												break;
		 												}
		 											
		 										 	if (health > 0){
		 										    	int kingchoice1;
		 										    	
		 										    	System.out.println(" ");
		 										    	System.out.println("You enter the palace, gazing up at the high arched ceiling above you.");
		 										    	System.out.println("The evil king sits in his golden armor on the throne in that stands at the top of a long flight of stairs.");
		 										    	System.out.println("Extravagant tapestries and expensive china platters are everywhere.");
		 										    	System.out.println(" ");
		 										 		System.out.println("'Your reign has ended, king!' you say, 'It is time for your rule over this land to end!'");
		 										 		System.out.println(" ");
		 										 		System.out.println("'Oh, really?' he replies, 'You will have to fight me for it!'");
		 										 		System.out.println(" ");
		 										 		System.out.println("'That's just what I came here to do,' you say. Will you...");
		 										 		System.out.println("(1) Aim for the head");
		 										 		System.out.println("(2) Aim for the heart");
		 										 		System.out.println("(3) Aim for the foot");
		 										 		System.out.println("(4) Flee");
		 										 		
		 										 		kingchoice1 = input.nextInt();
		 	 										 	
		 	 										 	int roll5 = kingchoice1;
		 	 										 	do{
		 	 										 	switch (roll5){
		 	 										 	case 1:
		 	 										 		System.out.println(" ");
		 	 										 		System.out.println("The king's armor protects him from the shot.");
		 	 										 		System.out.println("You are killed within instants.");
		 	 										 		System.out.println("You have lost 2 lives");
		 	 										 		archer.healthChange(2);
		 	 											 	if(archer.getHealth() == 0){
		 	 											 		
		 	 											 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
		 	 											 		 if (option == 0){
		 	 											 			 ClassSelection.playGame();
		 	 											 		 }}
		 	 											 		 break;
		 	 											
		 	 											case 2:
			 	 											System.out.println(" ");
			 	 										 	System.out.println("The king's helmet protects him from the shot.");
			 	 										 	System.out.println("You are killed within instants.");
			 	 										 	System.out.println("You have lost 2 lives");
			 	 										 	archer.healthChange(2);
			 	 											if(archer.getHealth() == 0){
			 	 											 		
			 	 											 	option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
		 	 											 		if (option == 0){
		 	 											 			ClassSelection.playGame();
		 	 											 		
		 	 											 		break;
		 	 											 		}}
		 	 											case 3:
			 	 											System.out.println(" ");
			 	 										 	System.out.println("The king sees the shot and moves his foot reflexively.");
			 	 										 	System.out.println("The arrow hits the leg of the throne and sends him toppling down the stairs.");
			 	 										 	System.out.println("You then decapitate him!");
			 	 										 	System.out.println("Victory!");
			 	 									
			 	 											 	option = JOptionPane.showConfirmDialog(null, "Play again?", "You have won, play again?", JOptionPane.YES_NO_OPTION);
		 	 											 		if (option == 0){
		 	 											 			ClassSelection.playGame();
		 	 											 		
		 	 											 		break;
			 										 		}
		 	 										 	case 4:
		 	 											System.out.println(" ");
		 	 											System.out.println("You escaped with your life, but failed");
		 	 											option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
 										 				archer.healthChange(3);
		 	 									 	if (option == 1){
		 	 									 		ClassSelection.playGame();
		 	 									 	}

		 	 							 	
		 	 											break;
		 	 											}
		 	 										
		 	 									 	if (option == 0){
	 	 											 			ClassSelection.playGame();	
	 	 											 		}
		 	 										 	}while (health> 0);
		 	 											 		}
		 	 										 	
		 	 										 	
		 										 	}}}
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	


