import javax.swing.JOptionPane;
public class ConfirmationDialog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int counter = 0;
		int option;
		
		do{
			counter++;
			JOptionPane.showMessageDialog(null, "Counter = " + counter);
			
			option = JOptionPane.showConfirmDialog(null, "Would you like to quit?", "Exit", JOptionPane.YES_NO_OPTION);
		}while (option == 1);

	}

}
