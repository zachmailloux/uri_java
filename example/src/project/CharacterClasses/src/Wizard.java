import java.util.Scanner;

import javax.swing.JOptionPane;


public class Wizard {

	/**
	 * @param args
	 */
	// variables
	private String name;
	private  static int health = 4;
	static int option;
			//constructors (base)
			Wizard(){
				name = "Wizard";}
			
			//constructors
			Wizard(String n){
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
				
				//Warrior object
				Wizard wizard = new Wizard();
				
				Scanner input = new Scanner(System.in);
	
	int dragonchoice2;
	
 	System.out.println("(1) Shoot fire at it");
 	System.out.println("(2) Shoot ice at it");
 	System.out.println("(3) Shoot water at it");
 	System.out.println("(4) Flee");
 	dragonchoice2 = input.nextInt();
 	
 	int roll = dragonchoice2;
 			
 	switch (roll){
 	case 1 :
 		System.out.println(" ");
 		System.out.println("The dragon is immune to fire, and scorches you!");
 		System.out.println("You have lost 1 life");
 		wizard.healthChange(1);
	 	if(wizard.getHealth() == 0){
	 		
	 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
	 	}
	 	if (option == 1){
	 		ClassSelection.playGame();
	 	}

	
 	break;
 	
 	case 2:
 		System.out.println(" ");
 		System.out.println("The dragon melts the ice before it can have any effect on him!");
 		System.out.println("You have lost 1 life");
 		wizard.healthChange(1);
	 	if(wizard.getHealth() == 0){
	 		
	 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
	 	}
	 	if (option == 1){
	 		ClassSelection.playGame();
	 	}

	
 	break;
 	
 	case 3:
 		System.out.println(" ");
 		System.out.println("The dragon cannot stop the oncoming typhoon with his fire! He is crushed");
 		System.out.println("Victory!");
 	break;
 	
 	case 4:
 		System.out.println(" ");
 		System.out.println("You escaped with your life, but failed");
			wizard.healthChange(3);
 		option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
 	
 	if (option == 1){
 		ClassSelection.playGame();
 	}
 		break;
 	}
 	if (health != 0){
 			
 		int giantchoice2;	
 		
 			System.out.println(" ");
 			System.out.println("Next, you encounter a huge giant. Will you...");
 			System.out.println("(1) Shoot fire at him");
		 	System.out.println("(2) Shoot ice at him");
		 	System.out.println("(3) Shoot water at him");
		 	System.out.println("(4) Flee");
		 	giantchoice2 = input.nextInt();
		 	
		 	int roll2 = giantchoice2;
		 	
		 	switch (roll2){
		 	case 1:
		 		System.out.println(" ");
		 		System.out.println("The giant becomes engulfed in flames .");
		 		System.out.println("He burns to death.");
		 		System.out.println("Victory!");
		 	break;
		 
		 	case 2:
		 		System.out.println(" ");
		 		System.out.println("The giant's tough skin is impervious to the ice shards");
		 		System.out.println("You have lost 1 life");
		 		wizard.healthChange(1);
			 	if(wizard.getHealth() == 0){
			 		
			 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
			 	}
			 	if (option == 1){
			 		ClassSelection.playGame();
			 	}

	 	
		 	break;
		 		
		 	case 3:
		 		System.out.println(" ");
		 		System.out.println("The typhoon is but a wave to him.");
		 		System.out.println("It has little effect, and the giant crushes you.");
		 		System.out.println("You have lost 1 life");
		 		wizard.healthChange(1);
			 	if(wizard.getHealth() == 0){
			 		
			 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
			 	}
			 	if (option == 1){
			 		ClassSelection.playGame();
			 	}

	 	
		 	break;
		 	
		 	case 4:
		 		System.out.println(" ");
		 		System.out.println("You escaped with your life, but failed");
	 				wizard.healthChange(3);
		 		option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
		 	
		 	if (option == 1){
		 		ClassSelection.playGame();
		 	}
		 		break;}
		 	
		 		
		 	if (health != 0){
 	
 					int hydrachoice2 = 0;
 				 		
 				 			System.out.println(" ");
 				 			System.out.println("Next, you encounter a many-headed hydra. Will you...");
 				 			System.out.println("(1) Shoot fire at it");
 						 	System.out.println("(2) Shoot ice at it");
 						 	System.out.println("(3) Shoot water at it");
 						 	System.out.println("(4) Flee");
 						 	hydrachoice2 = input.nextInt();
 						 	
 						 	int roll3 = hydrachoice2;
 						 	
 						 	switch (roll3){
 						 	case 1:
 						 		System.out.println(" ");
 						 		System.out.println("The hydra is impervious to the flames because of his scales");
 						 		System.out.println("You have lost 1 life");
 						 		wizard.healthChange(1);
 							 	if(wizard.getHealth() == 0){
 							 		
 							 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
 							 	}
 							 	if (option == 1){
 							 		ClassSelection.playGame();
 							 	}

 					 	
 						 	break;
 						 
 						 	case 2:
 						 		System.out.println(" ");
 						 		System.out.println("Each of the hydra's many heads are encased in ice.");
 						 		System.out.println("You quickly kill it");
 						 		System.out.println("Victory!");
 						 	break;
 						 		
 						 	case 3:
 						 		System.out.println(" ");
 						 		System.out.println("The towering hydra is completely uneffected. You are eaten.");
 						 		System.out.println("You have lost 1 life");
 						 		wizard.healthChange(1);
 							 	if(wizard.getHealth() == 0){
 							 		
 							 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
 							 	}
 							 	if (option == 1){
 							 		ClassSelection.playGame();
 							 	}

 					 	
 						 	break;
 						 	
 						 	case 4:
 						 		System.out.println(" ");
 						 		System.out.println("You escaped with your life, but failed");
					 				wizard.healthChange(3);
 						 		option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
 							 	
 							 	if (option == 1){
 							 		ClassSelection.playGame();
 							 	}
 						 		break;}
 						 	
 						 	if (health != 0){
 							 			
 								 		int robotchoice2;	
 								 		
 								 			System.out.println(" ");
 								 			System.out.println("You are nearing the castle of the king!");
 								 			System.out.println(" ");
 								 			System.out.println("A robot servant guards the gate. Will you...");
 								 			System.out.println("(1) Shoot fire at it");
 										 	System.out.println("(2) Shoot ice at it");
 										 	System.out.println("(3) Shoot water at it");
 										 	System.out.println("(4) Flee");
 										 	robotchoice2 = input.nextInt();
 										 	
 										 	int roll4 = robotchoice2;
 										 	
 										 	switch (roll4){
 										 	case 1:
 										 		System.out.println(" ");
 										 		System.out.println("The robot's metal skin is unaffected");
 										 		System.out.println("You are killed within instants.");
 										 		System.out.println("You have lost 1 life");
 										 		wizard.healthChange(1);
 											 	if(wizard.getHealth() == 0){
 											 		
 											 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
 											 	}
 											 	if (option == 1){
 											 		ClassSelection.playGame();
 											 	}

 									 	
 										 	break;
 										 
 										 	case 2:
 										 		System.out.println(" ");
 										 		System.out.println("The robot's heat melts the ice, and he charges.");
 										 		System.out.println("You have lost 1 life");
 										 		wizard.healthChange(1);
 											 	if(wizard.getHealth() == 0){
 											 		
 											 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
 											 	}
 											 	if (option == 1){
 											 		ClassSelection.playGame();
 											 	}

 									 	
 										 	break;
 										 		
 										 	case 3:
 										 		System.out.println(" ");
 										 		System.out.println("The robot is rendered useless, and topples to the ground.");
 										 		System.out.println("You slip by.");
 										 		System.out.println("Victory!");
 										 	break;
 										 	
 										 	case 4:
 										 		System.out.println(" ");
 										 		System.out.println("You escaped with your life, but failed");
									 				wizard.healthChange(3);
 										 		option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
 											 	
 											 	if (option == 1){
 											 		ClassSelection.playGame();
 											 	}
 										 		break;}
 										 	
 											 	if (health != 0){
 										    	
 											 		int kingchoice2;
 										    	
 											 		System.out.println(" ");
 											 		System.out.println("You enter the palace, gazing up at the high arched ceiling above you.");
 										    		System.out.println("The evil king sits on the throne that stands at the top of a long flight of stairs.");
 										    		System.out.println("Extravagant tapestries and expensive china platters are everywhere.");
 										    		System.out.println(" ");
 										 			System.out.println("'Your reign has ended, king!' you say, 'It is time for your rule over this land to end!'");
 										 			System.out.println(" ");
 										 			System.out.println("'Oh, really?' he replies, 'You will have to fight me for it!'");
 										 			System.out.println(" ");
 										 			System.out.println("'That's just what I came here to do,' you say. Will you...");
 										 			System.out.println("(1) Shoot fire at him");
 										 			System.out.println("(2) Shoot ice at him");
 										 			System.out.println("(3) Shoot water at him");
 										 			System.out.println("(4) Flee");
 										 			kingchoice2 = input.nextInt();
 	 										 	
 										 			int roll5 = kingchoice2;
 	 										 	
 										 			do{
 										 			switch (roll5){
 										 			case 1:
 										 				System.out.println(" ");
 										 				System.out.println("The king's armor protects him from the heat.");
 										 				System.out.println("You are killed within instants.");
 										 				System.out.println("You have lost 2 lives");
 										 				wizard.healthChange(2);
 										 				if(wizard.getHealth() == 0){
 										 					
 										 					option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
 										 				}
 										 				if (option == 1){
 										 					ClassSelection.playGame();
 										 				}
 										 				
 	 									 	
 										 				break;
 	 										 
 										 			case 2:
 										 				System.out.println(" ");
 										 				System.out.println("The king's armor protects him from the ice shards");
 										 				System.out.println("You have lost 2 lives");
 										 				wizard.healthChange(2);
 										 				if(wizard.getHealth() == 0){
 										 					
 										 					option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
 										 				}
 										 				if (option == 1){
 	 											 		ClassSelection.playGame();
 										 				}

 	 									 	
 										 				break;
 	 										 		
 										 			case 3:
 										 				System.out.println("The king's platform at the top of the stairs is flooded.");
 										 				System.out.println("He is hurled down the stairs hard and lands at your feet, dead");
 										 				System.out.println("Victory!");
 										 				
 										 				option = JOptionPane.showConfirmDialog(null, "Play again?", "You have won, play again?", JOptionPane.YES_NO_OPTION);
										 				
										 				if (option == 0){
	 											 		ClassSelection.playGame();
										 				}
 										 				break;
 	 	 										 	
 	 	 										 		case 4:
 	 	 										 			System.out.println(" ");
 	 	 										 			System.out.println("You escaped with your life, but failed");
 	 										 				wizard.healthChange(3);
 	 	 										 		option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
										 				
										 				if (option == 1){
	 											 		ClassSelection.playGame();
										 				}
 	 	 										 			break;
 										 			}}
 										 			while (health != 0);
 										    }//end wizard
 						 		}
 				}}}}
