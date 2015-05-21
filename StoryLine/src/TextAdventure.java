import javax.swing.JOptionPane;
import javax.swing.JFrame;
public class TextAdventure {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name;
		int age = 0;
		int option1;
		int option2;
		int option3;
		int option4;
		int option5;
		int option6;
		int option7;
		int room = 0;
		int saved = 0;
		
		name = JOptionPane.showInputDialog("Enter your name");
		
		showText("Your name is " + name);
		
		showText("You are " + name + " The great detective.");
		showText("Someone came into your office asking for your help to invetigate something.");
		showText("''It's a motel'' she said ''and in it weird things happen.''");
		showText("''There have been two disappearances, all after a blackout.''");
		showText("''I will investigate'' you say.");
		showText("later...");
		showText("You find your way to the motel.");
		showText("It doesn't look that strange, you think to yourself.");
		showText("You enter, but just after you enter the doors close");
		showText("The doors are locked but you proceed anyway. You figure that the only way out is up anyway");
		//First choice
		while(true){
		option1= Integer.parseInt(JOptionPane.showInputDialog("You are faced with a choice. You may either go up the elevator <1> or up the staircase <2>."));
		if (option1 ==2){
			break;
		}

		if (option1 == 1){
			showText("The elevator is not responding due to the power outage");
			
			age = JOptionPane.showConfirmDialog(null, "Would you like to return?" , "Return" , JOptionPane.YES_NO_OPTION);
		}//end of First choice
		if(age == 1){
			break;
		}
		}
		
		if (option1 == 2){
			showText("The staircase sounds creaky but you decide to climb it...");
			showText("You fall through the staircase and land on the bottom");
			showText("''Would you like help?'' says the policeman");
			showText("The are police at the top of the staircase offering to help you up.");
			showText("You wonder why they are there.");
			//Second Choice
			option2= Integer.parseInt(JOptionPane.showInputDialog("Will you go with the policemen <1> or ask for their badges <2>?"));
		
			if (option2 == 1){
				showText("''Yes I would like some help up thank you''");
				showText("They help you up only to find yourself becoming unconscious.");
				room = 1;
			
		}
		
		else {
			showText("''We are the police... We don't need to show our badges.''");
			//Third Choice
			option3 = Integer.parseInt(JOptionPane.showInputDialog("Are you going to with them <1> or not <2>?" ));
			if (option3 ==1){
				showText("''Yes I would like some help up thank you''");
				showText("They help you up only to find yourself becoming unconscious.");
				room = 1;
			
			}
			if(room==0){
			if(option3==2) {
				showText("''No thank you'' and you find another staircase down the hall.");
				showText("You go up the staircase to the next floor.");
				showText("You see the policemen, and they get into a fighting position.");
				showText("''You aren't going anywhere...''");
				option4= Integer.parseInt(JOptionPane.showInputDialog("Will you fight them <1> or run <2>")); 
				if(option4==1){
					showText("You run at them");
					showText("When it's too late you notice on of them pulls out a knife.");
					showText("You were killed");
					System.exit(0);
				}
				if(option4==2){
					showText("You run away.");
					showText("Get back here!");
					showText("They give chase");
					showText("You run up another flight of stairs");
					showText("They are right behind you and they are about to grab you but...");
					showText("You see a door...");
					option5= Integer.parseInt(JOptionPane.showInputDialog("Will you go into the door and close them off <1> or keep running <2>"));
					if(option5==2){
						showText("They finally catch up to you...");
						showText("They grab you");
						showText("''Your not going anywhere...''");
						showText("One of them stabs you");
						showText("You have been killed");
						System.exit(0);
					}
					if(option5==1){
						showText("You enter the room and close the door");
						showText("The dirty cops can't get to you now");
						showText("''What's in this room'' You wonder.");
						showText("You explore the room.");
						room=1;
					}
				}
				
			}
		}
			if(room==1){
				showText("You see a phone.");
				showText("''I could probably get back up if I call.''");
				option6= Integer.parseInt(JOptionPane.showInputDialog("Will you call 911 for help <1> or try to get out yourself <2>."));
				
			}	
	}

}
		if(room==1){
			showText("You see a phone.");
			option6= Integer.parseInt(JOptionPane.showInputDialog("Will you call 911 for help <1> or try to get out yourself <2>."));
			if(option6==1){
				showText("You grab the phone and dial 911");
				showText("''This is 911, what is your emergency?''");
				showText("You say...");
				showText("''I'm detective" + name + " in the Tampson Motel and am requesting backup''");
				showText("''We'll have backup there shortly''");
				saved = 1;
				
			}
		showText("''I have been expecting you " + name + ".''");
		showText("''My name Albero.''");
		showText("''I give you two choices of death.''");
		option7= Integer.parseInt(JOptionPane.showInputDialog("''You may die by the electric chair <1> or gun <2>''"));
		if(option7 == 1){
			showText("''I would prefer the electric chair.''");
			showText("''Electric chair it is...'' He said");
			showText("''3''");
			showText("''2''");
			showText("''1''");
			showText("The lever flipped but nothing happened");
			showText("''Albero... Did you forget it was a Blackout?'' You say.");
			showText("''No matter... I kill you with my pistol''");
			showText("You think you have no chance but then...");
			showText("''THIS IS THE POLICE!'' They said as they broke down the door.");
			showText("''GET ON THE GROUND!''");
			showText("''A bit late but thank you for coming,'' You say.");
			showText("''Don't mention it...''" + name + ".");
			
			
		}
		}	
}
	public static void showText(String statement){
		JOptionPane.showMessageDialog(null, statement);
	}
}