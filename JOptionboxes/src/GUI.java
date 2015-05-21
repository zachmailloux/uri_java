import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * A JOptionPane showMessageDialog example that shows
 * how to display a component (JComponent) in a 
 * JOptionPane dialog.
 */
public class GUI
{
  public static void main(String[] args)
  {
    // create a simple jpanel
    JPanel panel = new JPanel();
    panel.setBackground(Color.BLUE);
    panel.setMinimumSize(new Dimension(200,200));
    
    // display the jpanel in a joptionpane dialog, using showMessageDialog
    JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
    JOptionPane.showMessageDialog(frame, panel);

    System.exit(0);
  }
}