import javax.swing.JOptionPane;

public class Confirmation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int option;
		
		do{
			option = JOptionPane.showConfirmDialog(null, "Quit?", "Exit", JOptionPane.YES_NO_OPTION);
				
		}
		while(option == 1);
		}
				

}
