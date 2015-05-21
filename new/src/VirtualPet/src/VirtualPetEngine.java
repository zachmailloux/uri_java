import javax.swing.JFrame;
//import javax.swing.JOptionPane;
public class VirtualPetEngine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Pet myPet = new Pet();
		
		//myPet.name = "Spike";
		//myPet.type = "dog";
		//myPet.color = "black";
		
		JOptionPane.showMessageDialog(null, "My pet's name is " + myPet.getName());
		JOptionPane.showMessageDialog(null, "My pet is a " + myPet.getType());
		JOptionPane.showMessageDialog(null, "My pet's hair is " + myPet.getColor());
		*/
		
		MyWin simpleWin = new MyWin("Virtual Pet");
		simpleWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
