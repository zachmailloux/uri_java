import javax.swing.JOptionPane;
public class MessageDialogs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = null;
		
		JOptionPane.showMessageDialog(null, "Welcome, " + name + ". You, the red square, are having a very bad day. Your goal is to ruin the day of the happy green square, over and over again. You gain 1 point every time you ruin his day. But be careful! If the blue policeman square catches you, he'll take away all your points!", "Error", JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(null, "This is a warning", "Warning", JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(null,  "This is information", "Info", JOptionPane.INFORMATION_MESSAGE);

	}

}
