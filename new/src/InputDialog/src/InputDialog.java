import javax.swing.JOptionPane;
public class InputDialog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name;
		String lname;
		int age;
		
		name = JOptionPane.showInputDialog("Enter your first name.");
		lname = JOptionPane.showInputDialog("Enter your last name.");
		age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age."));
		
		JOptionPane.showMessageDialog(null, "Your name is " + name + " " + lname + " and your age is " + age + ".");

	}

}
