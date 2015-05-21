import java.util.Scanner;

import javax.swing.JOptionPane;

public class Warrior{
	/**
	 * @param args
	 */

		// variables
		private String name;
		private  static int health = 3;
		Scanner input = new Scanner(System.in);
		static int option;
		
		//constructors (base)
		Warrior(){
			name = "Warrior";}
		
		//constructors
		Warrior(String n){
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
			Warrior warrior = new Warrior();
			
			Scanner input = new Scanner(System.in);
			
		// Warrior's story
			
			int dragonchoice3;
				
			System.out.println("(1) Charge & stab");
			System.out.println("(2) Approach blocking & stab");
			System.out.println("(3) Throw your knife ");
			System.out.println("(4) Flee");
			dragonchoice3 = input.nextInt();
			
			int roll = dragonchoice3;
			
			switch (roll){
			case 1 :
				System.out.println(" ");
				System.out.println("The dragon quickly scorches you. That was very reckless!");
				System.out.println("You have lost 1 life");
			 	warrior.healthChange(1);
			 	if(warrior.getHealth() == 0){
			 		
			 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
			 	}
			 	if (option == 1){
			 		ClassSelection.playGame();
			 	}
		 	
				break;
					
			case 2:
				System.out.println(" ");
				System.out.println("The dragon cannot burn you, but still eats you when you get near");
				System.out.println("You have lost 1 life");
			 	warrior.healthChange(1);
			 	if(warrior.getHealth() == 0){
			 		
			 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
			 	}
			 	if (option == 1){
			 		ClassSelection.playGame();
			 	}
		 	
				break;
				
			case 3:
				System.out.println(" ");
				System.out.println("The dragon does not expect a such a small missile from a fully armored warrior.");
				System.out.println("He is pierced in the heart, and dies.");
				System.out.println("Victory!");
				break;
				
			case 4:
				System.out.println(" ");
				System.out.println("You escaped with your life, but failed");
				option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
				warrior.healthChange(3);
		 	if (option == 1){
		 		ClassSelection.playGame();
		 	}

				break;
			}
			 	if (health != 0){
				
				int giantchoice3;	
							 											 		
					System.out.println(" ");
					System.out.println("Next, you encounter a huge giant. Will you...");
					System.out.println("(1) Charge & stab");
					System.out.println("(2) Approach blocking & stab");
					System.out.println("(3) Throw your knife ");
					System.out.println("(4) Flee");
					giantchoice3 = input.nextInt();
					
					int roll2 = giantchoice3;
					
					switch (roll2){
					case 1:
						System.out.println(" ");
						System.out.println("The clumsy giant is too slow, so you quickly defeat it.");
						System.out.println("Victory!");
						break;
						
					case 2:
						System.out.println(" ");
						System.out.println("You approach slowly enough that the giant can crush you, even though he is clumsy");
						System.out.println("You have lost 1 life");
					 	warrior.healthChange(1);
					 	if(warrior.getHealth() == 0){
					 		
					 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
					 	}
					 	if (option == 1){
					 		ClassSelection.playGame();
					 	}
				 	
						break;
						
					case 3:
						System.out.println(" ");
						System.out.println("The small dagger has barely any effect on the giant.");
						System.out.println("You have lost 1 life");
					 	warrior.healthChange(1);
					 	if(warrior.getHealth() == 0){
					 		
					 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
					 	}
					 	if (option == 1){
					 		ClassSelection.playGame();
					 	}
				 	
						break;
						
					case 4:
						System.out.println(" ");
						System.out.println("You escaped with your life, but failed");
						warrior.healthChange(3);
						option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
				 	
				 	if (option == 1){
				 		ClassSelection.playGame();
				 	}

		 	
						break;
						}
					
				 	if (health != 0){
						
						int hydrachoice3 = 0;
							 											 				 		
						System.out.println(" ");
						System.out.println("Next, you encounter a many-headed hydra. Will you...");
						System.out.println("(1) Charge & stab");
						System.out.println("(2) Approach blocking & stab");
						System.out.println("(3) Throw your knife ");
						System.out.println("(4) Flee");
						hydrachoice3 = input.nextInt();
						
						int roll3 = hydrachoice3;
						
						switch (roll3){
						case 1:
							System.out.println(" ");
							System.out.println("The hydra eats you quickly");
							System.out.println("You have lost 1 life");
					 		warrior.healthChange(1);
						 	if(warrior.getHealth() == 0){
						 		
						 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
						 	}
						 	if (option == 1){
						 		ClassSelection.playGame();
						 	}

				 	
							break;
							
						case 2:
							System.out.println(" ");
							System.out.println("You manage to block the heads and stab the hydra's heart");
							System.out.println("You quickly kill it");
							System.out.println("Victory!");
							break;
							
						case 3:
							System.out.println(" ");
							System.out.println("The towering hydra is completely uneffected. You are eaten.");
							System.out.println("You have lost 1 life");
					 		warrior.healthChange(1);
						 	if(warrior.getHealth() == 0){
						 		
						 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
						 	}
						 	if (option == 1){
						 		ClassSelection.playGame();
						 	}

				 	
							break; 											 						 		
						case 4:
							System.out.println(" ");
							System.out.println("You escaped with your life, but failed");
				 				warrior.healthChange(3);
							option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
					 	break;	}
						
					 	if (option == 1){
					 		ClassSelection.playGame();
					 	}
				 	
					
						 	if (health != 0){
							
							int robotchoice3;	
							
							System.out.println(" ");
							System.out.println("You are nearing the castle of the king!");
							System.out.println(" ");
							System.out.println("A robot servant guards the gate. Will you...");
							System.out.println("(1) Charge & stab");
							System.out.println("(2) Approach blocking & stab");
							System.out.println("(3) Throw your knife ");
							System.out.println("(4) Flee");
							robotchoice3 = input.nextInt();
							
							int roll4 = robotchoice3;
							
							switch (roll4){
							case 1:
								System.out.println(" ");
								System.out.println("You charge the robot, but are instantly killed by its laser.");
								System.out.println("You have lost 1 life");
						 		warrior.healthChange(1);
							 	if(warrior.getHealth() == 0){
							 		
							 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
							 	}
							 	if (option == 1){
							 		ClassSelection.playGame();
							 	}

					 	
								break;
								
							case 2:
								System.out.println(" ");
								System.out.println("The the robot releases a lightning bolt that is conducted through your shield");
								System.out.println("You have lost 1 life");
						 		warrior.healthChange(1);
							 	if(warrior.getHealth() == 0){
							 		
							 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
							 	}
							 	if (option == 1){
							 		ClassSelection.playGame();
							 	}

					 	
								break;
								
							case 3:
								System.out.println(" ");
								System.out.println("You cut through a joint with the knife. The robot is rendered useless, and topples to the ground.");
								System.out.println("You slip by.");
								System.out.println("Victory!");
								break;
								
							case 4:
								System.out.println(" ");
								System.out.println("You escaped with your life, but failed");
								option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
						 	
								break;
							}
								
						 	if (option == 1){
						 		ClassSelection.playGame();
						 	}
								
							
							 	if (health != 0){
								
								int kingchoice3;
								
								System.out.println(" ");
								System.out.println("You enter the palace, gazing up at the high arched ceiling above you.");
								System.out.println("The evil king sits on the throne that stands at the top of a long flight of stairs.");
								System.out.println("Extravagant tapestries and expensive china platters are everywhere.");
								System.out.println(" ");
								System.out.println("'Your reign has ended, king!' you say, 'It is time for your rule over this land to end!'");
								System.out.println(" ");
								System.out.println(" ");
								System.out.println("'That's just what I came here to do,' you say. Will you...");
								System.out.println("'Oh, really?' he replies, 'You will have to fight me for it!'");
								System.out.println("(1) Charge & stab");
								System.out.println("(2) Approach blocking & stab");
								System.out.println("(3) Throw your knife ");
								System.out.println("(4) Flee");
								kingchoice3 = input.nextInt();
								
								
								 	int roll5 = kingchoice3;
								 	
								 	do{
								 	switch (roll5){
								 	case 1:
								 		System.out.println(" ");
								 		System.out.println("The king blocks and stabs you as you crash into him");
								 		System.out.println("You are killed within instants.");
								 		System.out.println("You have lost 2 lives");
								 		warrior.healthChange(2);
									 	if(warrior.getHealth() == 0){
									 		
									 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
									 	}
									 	if (option == 1){
									 		ClassSelection.playGame();
									 	}

								 	break;
								 
								 	case 2:
								 		System.out.println(" ");
								 		System.out.println("The king calls his guards before you can reach him with your slow approach. You are executed.");
								 		System.out.println("You have lost 2 lives");
								 		warrior.healthChange(2);
									 	if(warrior.getHealth() == 0){
									 		
									 		 option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
									 	}
									 	if (option == 1){
									 		ClassSelection.playGame();
									 	}

							 	
								 	break;
								 		
								 	case 3:
								 		System.out.println(" ");
								 		System.out.println("You kill the king before he even gets up!");
								 		System.out.println("Victory!");
		
									 		 option = JOptionPane.showConfirmDialog(null, "Play again?", "You have won, play again?", JOptionPane.YES_NO_OPTION);
									 	
									 	if (option == 0){
									 		ClassSelection.playGame();
									 	
									 	}
								 	break;
								 	
								 	case 4:
								 		System.out.println(" ");
								 		System.out.println("You escaped with your life, but failed");
								 		warrior.healthChange(3);
								 			option = JOptionPane.showConfirmDialog(null, "Quit?", "You have lost", JOptionPane.YES_NO_OPTION);
								 		
								 		if (option == 1){
								 			 ClassSelection.playGame();
								 		 }
								 		break;
								 		
								 	}
							 	
								 	
							 	}
								 	while(health != 0);
							}}}
			 	
			}
		

}}
					
							
	