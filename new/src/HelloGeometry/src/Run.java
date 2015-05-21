import javax.swing.JOptionPane;
public class Run {

	public static int ask(String message){
		return Integer.parseInt(JOptionPane.showInputDialog(message));
	}
	public static void say(String message1){
		JOptionPane.showMessageDialog(null, message1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a1;
		int a2;
		int a3;
		int option;
		
		do{
		a1 = ask("Input the first angle of a triangle.");
		
		
		a2 = ask("Input second angle.");
		
		a3 = ask("Input third angle.");
		
		if (a1 + a2 + a3 == 180){
			say("The angles sum to 180. It is a triangle.");
			//Equilateral
			if (a1 == a2 && a2 == a3){
				say("The triangle is equilateral.");
			}
			else if (a1 != a2 && a2 != a3 && a1 != a3){
				say("The triangle is scalene.");
				if (a1 == 90 || a2 == 90 || a3 == 90){
					say("The triangle is right.");
				}
			}
			else{
				say("The triangle is isosceles.");
				if (a1 == 90 || a2 == 90 || a3 == 90){
					say("The triangle is right.");
				}
			}
		}
		else{
			say("The angles sum to " + (a1 + a2 + a3) + ". It is not a triangle.");
		}
		
		option = JOptionPane.showConfirmDialog(null, "Would you like to try again?", "Exit", JOptionPane.YES_NO_OPTION);
		}while (option == 0);
		
		
		
	}

}
