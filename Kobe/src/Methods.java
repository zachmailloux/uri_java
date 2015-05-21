import javax.swing.JOptionPane;
 
public class Methods {

	/**
	 * 
	 * @param args
	 */
     
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
      String name;
      int age;
    	
      name = JOptionPane.showInputDialog("Enter your name", "TYPE NAME HERE");//This
      //this is to get the name of the user
       
      JOptionPane.showMessageDialog(null,  "Hello there " + name, "ERROR", JOptionPane.ERROR_MESSAGE);
      
       JOptionPane.showMessageDialog(null, "We've been watching you for a while...", "WARNING", JOptionPane.INFORMATION_MESSAGE);
       
       JOptionPane.showMessageDialog(null, "We want your Beard.. Your Large... amazing... Superior Beard..", "WARNING THEY WANT YOUR BEAUTIFUL BEARD!", JOptionPane.WARNING_MESSAGE);
    
       JOptionPane.showMessageDialog(null, "And we will get that beard of yours.. Even if we have to lick you..", "ERROR", JOptionPane.ERROR_MESSAGE);

       JOptionPane.showMessageDialog(null, "And your face.... OHHH YOUR BEAUTIFUL FACE! IT LOOKS BETTER THAN A NORMAL FACE!", "COMPLIMENT", JOptionPane.INFORMATION_MESSAGE);
    
       JOptionPane.showMessageDialog(null, "Oh.. And your wonderful taste in Women! Its amazing how you found 'Ms." + name + "' and immediatly stole her Cardiac Muscle!", "COMPLIMENT", JOptionPane.INFORMATION_MESSAGE);
       
       JOptionPane.showMessageDialog(null, "And your bottlecap collection is amazing! So extensive! No two are the same, and it looks like a rainbow! My favorite color!", "COMPLIMENT", JOptionPane.INFORMATION_MESSAGE);
    
       JOptionPane.showMessageDialog(null, "Also your programing skills are the best I have ever seen! I envy you...", "COMPLIMENT - JEALOUSY DETECTED!", JOptionPane.WARNING_MESSAGE);
       
       
       
    }//end main
     
 
} 