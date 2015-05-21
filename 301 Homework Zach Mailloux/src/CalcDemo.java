import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * This is an applet for demonstrating the CalcLexer and CalcParser classes.  We present 
 * a graphical interface that allows the user to enter an expression, and shows the result
 * of parsing and evaluating that expression.  This can be run either as an 
 * applet or as an application.
 */
public class CalcDemo extends JApplet {
	private static final long serialVersionUID = 0L;

	/**
	 * A Label for the result of evaluating the last expression.
	 */
	private JLabel resultLabel;

	/**
	 * The TextField in which expressions are entered.
	 */
	private JTextField expressionField;

	/**
	 * Create our GUI components.
	 */
	@Override public void init() {

		// Boilerplate: create components on event-dispatching thread.
		try {
			javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					createGUI();
				}
			});
		} catch (Exception e) {
			System.err.println("createGUI didn't successfully complete");
		}

	}

	/**
	 * Create the GUI components.  This initializes the applet.
	 */
	public void createGUI() {

		// First, create the Labels, and the TextField where the user will
		// enter expressions.

		JLabel expressionLabel = new JLabel(" Enter expression: ", JLabel.RIGHT);
		resultLabel = new JLabel(" ", JLabel.CENTER);
		expressionField = new JTextField(20);
		expressionField.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent evt) {
				CalcParser parser = new CalcParser(expressionField.getText());
				System.out.println(parser);
				String error = parser.getErrorMessage();
				if (error==null) { // if no error, display value in black
					resultLabel.setText(parser.getValue());
					resultLabel.setForeground(Color.BLACK);
				}
				else { // if error, display it in red
					resultLabel.setText(error);
					resultLabel.setForeground(Color.RED);
				}
			}
		});

		// Create an inner Panel for the Label/TextField line.

		JPanel top = new JPanel(new BorderLayout());
		top.add(expressionLabel, BorderLayout.WEST);
		top.add(expressionField, BorderLayout.CENTER);
		
		// Finally, our content Panel: we will use a BorderLayout with the Label/TextField
		// line in the north border, and the result Label in the south.
	
		Container content = getContentPane();
		content.add(top, BorderLayout.NORTH);
		content.add(resultLabel, BorderLayout.SOUTH);
	}

	/**
	 * A main method, so we can be run as an application, as well as a JApplet.
	 */
	public static void main(String[] args) {
		final JApplet applet = new CalcDemo();
		applet.init();
		final JFrame frame = new JFrame("Calc Demo");
		frame.setContentPane(applet.getContentPane());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}