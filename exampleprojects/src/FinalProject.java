
import javax.swing.JOptionPane;
public class FinalProject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//I plan on doing a Character Creation simulator which will ask the user for information on what they want their
//character to be, using dialog boxes.  Some of the things the program will ask for include the character's name, class, statistics,
// and a race.
		//equipment to purchase (with a gold limit)
		

		String name, race, type, sword, shield, bow, dagger, wararmor, larmor, cloak, staff, robe;
		String hometown = "";
		String stats = " ";
		String pet = " ";
		String petname = " that you didn't choose ";
		int gold = 1000;
		
		name = showInput("Enter the name of your character:");
		
		showText("Welcome, "+ name + ", to the World of Fire!");
		
		race = showInput("What is the race of your choosing? (Orc, Human, Elf, or Dwarf)");
		showText("Welcome, "+ name + " the "+ race +", to our world.");
		type = showInput(name + " the " + race + ", what class do you wish to be? (Warrior, Wizard, Archer, or Rouge)");
		//start race town
		if (race.equals("Orc") || race.equals("orc")){
			hometown = showInput(name + " the " + race + ", which stronghold where you born in? \n Were you born in Dunnmik Val or the Saddened Forest?");
		}
			else if (race.equals("Human") || race.equals("human")){
				hometown = showInput(name + " the " + race + ", where you were born? \n Were you born in the Southern Hills, or the Swamp of Fire?");
			}
			else if (race.equals("Elf") || race.equals("elf")){
				hometown = showInput(name + " the " + race + ", where is your forest colony? \n Is your colony in the Saddened Forest or the Woods of Confusion?");
			}
			else if (race.equals("Dwarf") || race.equals("dwarf")){
				hometown = showInput(name + " the " + race + ", what is your city called? \n Do you come from Redas, or the distant cave-city of Rakinor?");
			}
			else{
				showText("You didn't choose a valid race, restart the program and choose one of the races");
			}
		//start statistics
		stats = showInput("What statistic do you want to be proficient in?  Health, Attack, Defense, or Dexterity?");
		showText("So, you are " + name + " the " + race + " " + type + " from " + hometown + " and you are proficient in " + stats + ".");
			showText("Alright, " + name + ", be prepared to head off on an amazing adventure through the World of Fire as a " + race + " " + type + " from " + hometown + ". \n  Head out and restore peace and order to this land of chaos!");
			showText("As you step out into the " + race + " town of " + hometown + " the midday sun shines down and you head out into the town marketplace to purchase equipment.");
			//Start gold
			if (race.equals("Orc") || race.equals ("orc") || race.equals ("Elf") || race.equals("elf")){
				sword = showInput("An " + race + " blacksmith offers you an iron sword for 100 gold. \n You have a balance of " + gold + " gold. \n Would you like to purchase the sword?");
			}
			else{
				sword = showInput("A " + race + " blacksmith offers you an iron sword for 100 gold. \n You have a balance of " + gold + " gold. \n Would you like to purchase the sword?");
			}
				if(sword.equals("Yes") || sword.equals("yes")){
					gold = gold - 100;
				}
				showText("You have " + gold + " gold left.");
				shield = showInput("A merchant is selling a finely crafted shield made of steel for 100 gold. \n You have a balance of " + gold + " gold. \n Would you like to buy the shield?");
				if(shield.equals ("Yes") || shield.equals ("yes")){
					gold = gold - 100;
				}
				showText("You have " + gold + " gold left.");
				bow = JOptionPane.showInputDialog(null, "An Elf immigrant is selling his bow for 100 gold. The bow is finely crafted from magical graywood. \n You have a balance of " + gold + " gold. \n Would you like to purchase the bow?");
				if(bow.equals("Yes") || bow.equals("yes")){
					gold = gold - 100;
				}
				showText("You have " + gold + " gold left.");
				showText("A wizard approaches you and senses that you have an aptitude for magic. \n That's what he says, anyway.  You really don't buy it.");
				staff = showInput("The wizard offers you one of his staves, a long, gnarled stick with a few stubby branches sticking out on the top. \n He says that it is a forest staff used by druids, but can be used by anyone for any purpose. \n  He says the staff costs only 50 gold.  Do you accept?");
				if(staff.equals("Yes") || staff.equals("yes")){
					gold = gold - 50;
				}
				showText("A shady character is selling a special dagger.  You are unsure of what it is made of, but it shines a deep blue in the sunlight.");
				dagger = showInput("The character is offering 200 gold for the dagger. \n You have a balance of " + gold + " gold. \n  Would you like to buy the dagger?");
				if(dagger.equals("Yes") || dagger.equals("yes")){
					gold = gold - 200;
				}
				showText("You have " + gold + " gold left.");
				showText("You step into a warrior's armor shop.  In a display case, you see some heavy armor.  By the faint red glow on the steel, you can tell that the armor is enchanted.");
				wararmor = showInput("The clerk says that the armor costs 200 gold.  You have " + gold + " gold.  Do you want to buy the heavy armor?");
				if(wararmor.equals("Yes") || wararmor.equals("yes")){
					gold = gold - 200;
				}
				showText("You have " + gold + " gold left.");
				showText("Another piece of armor catches your eye.  The armor is lightweight, yet sturdy.  The clerk says that it is made from the leather of a dire bear.");
				larmor = showInput("Do you want to buy the leather armor for 100 gold?");
				if(larmor.equals("Yes") || larmor.equals("yes")){
					gold = gold - 100;
				}
				robe = showInput("You also notice some robes.  The clerk says the robes are 100 gold.  Do you want to buy the robes?");
				if(robe.equals("yes") || robe.equals("Yes")){
					gold = gold - 100;
				}
				showText("The shady figure that offered you the dagger approaches you again.  This time, he is selling a cloak. \n He says the cloak is made of magical silk, that allows the wearer to become invisible.");
				cloak = showInput("He says the cloak is worth 500 gold, but will sell it for 50 as a limited time offer.  Do you want the cloak?");
				if(cloak.equals("Yes") || cloak.equals("yes")){
					gold = gold - 50;
					showText("The figure walks away and you try on the cloak.  After you put it on, you look down to see you are completely invisible! \n You stay invisible for about 10 seconds before becoming visible again.");
				}
				showText("You have " + gold + " gold left.");
				//start Pets
				if(race.equals("Orc") || race.equals("orc")){
					pet = showInput("As you walk out of " + hometown + ", you see an Orc struggling to keep his 4 wardogs under control.  You come up to him and he says the dogs don't get along well. \n He offers to give you one of the dogs for free. Do you accept?");
					if(pet.equals("Yes") || pet.equals("yes")){
						petname = showInput("What do you want to name your pet?");
					}
					else{
					showText("You tell him no, but thank him for the offer.  He tries to get the dogs under control again as you walk away.");
					}
				}
				if(race.equals("Human") || race.equals("human")){
					pet = showInput("As you walk out of " + hometown + ", you see a Human trying to train an armored boar to attack a target dummy. \n You come up to him and he says that most of his boars are fierce fighters, but this one doesn't like to fight. \n He offers to give you the boar for free. Do you accept?");
					if(pet.equals("Yes") || pet.equals("yes")){
						petname = showInput("What do you want to name your pet?");
						if(pet.equals("Yes") || pet.equals("yes")){
							petname = showInput("What do you want to name your pet?");
						}
							else{
								showText("You tell him no, but thank him for the offer.  He continues to train his hawks.");
							}
				}
				if(race.equals("Elf") || race.equals("elf")){
					pet = showInput("As you walk out of " + hometown + ", you see an Elf training some hawks to scout through the forest.  You come up to him and he seems happy that someone takes an interest in his hawks. \n He offers to give you one of his hawks for free to see if they will work well in other climates. Do you accept?");
					if(pet.equals("Yes") || pet.equals("yes")){
						petname = showInput("What do you want to name your pet?");
					}
						else{
							showText("You tell him no, but thank him for the offer.  He continues to train his hawks.");
						}
				}
				}
				if(race.equals("Dwarf") || race.equals("dwarf")){
					pet = showInput("As you walk out of " + hometown + ", you see a Dwarven engineer testing some prototype spider drones. \n Most of them are sucessful in clearing a makeshift obstacle course but one slips up at the end.  The engnieer seems disapointed. \n When you come up to him, he says that he is designing spider drones, but 1 still has some bugs. \n He offers you the buggy spider drone. Do you accept?");
					if(pet.equals("Yes") || pet.equals("yes")){
						petname = showInput("What do you want to name your pet?");
				}
					else{
						showText("You tell him no, but thank him for the offer.  He continues fiddling with the robot.");
					}
					}
				if(pet.equals("Yes") || pet.equals("yes") || pet.equals("no") || pet.equals("No")){
					showText("Now, you are ready to head out on a grand adventure! \n " + name + " the " + race + " " + type + ", you must head out with your pet " + petname + ", and journey far away from your homeland of " + hometown + ". \n May your proficiency in " + stats + " help you on your adventure. \n Best of luck to you in the ruthless World of Fire!");
				}
				if(sword.equals("yes") || sword.equals("Yes")){
					showText("You grip your new sword tightly.");
				}
				if(shield.equals("yes") || shield.equals("Yes")){
					showText("You feel the weight of your shield on your back");
				}
				if(bow.equals("Yes") || bow.equals("yes")){
					showText("Your bow feels light in its sling on your side");
				}
				if(dagger.equals("Yes") || dagger.equals("yes")){
					showText("The magical dagger you bought is warm in its sheath. \n Looking at it reveals that it has become a dark purple color. \n You contemplate what could have caused this change for a while.");
				}
				if(wararmor.equals("Yes") || wararmor.equals("yes")){
					showText("Your enchanted heavy armor shines a brilliant red in the sunlight.");
				}
				if(larmor.equals("Yes") || larmor.equals("yes")){
					showText("Your dire bear armor fits snuggly but feels very solid.");
				}
				if(cloak.equals("Yes") || cloak.equals("yes")){
					showText("The cloak you wear appears to make you invisible everytime you think about being invisible. \n You wonder what kind of magic the cloak must contain to be able to read the thoughts of its wearer.");
				}
				if(staff.equals("Yes") || staff.equals("yes")){
					showText("The staff you purchased seems like it won't do anything, but at the very least you could use it as a bludgeoning weapon.");
				}
				if(robe.equals("Yes") || staff.equals("yes")){
					showText("The robes you have won't protect you much, but they should focus your magical energy. \n Or at least, that's what the tag on the back says.");
				}
				showText("END OF DEMO: \n Thanks for Playing!");
								}
	public static void showText(String statement){
		JOptionPane.showMessageDialog(null, statement);
	}
	public static String showInput(String Question){
		return JOptionPane.showInputDialog(null, Question);
	}
		}
