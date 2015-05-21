import javax.swing.JOptionPane;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name;
		int age;
		
		name = JOptionPane.showInputDialog("Enter your name");
		
		age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
		
		JOptionPane.showMessageDialog(null,  "Your name is " + name + ", and you are " + age + " years old.");
		
		
	}

}
