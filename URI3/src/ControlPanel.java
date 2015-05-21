import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;

/**
 * Controls for what shape is drawn, in what colors and whether large or
 * small (in the case of square or circle)
 * @author dkm
 *
 */
public class ControlPanel extends Panel implements ActionListener, ItemListener{
	
	/**
	 * To control what is drawn
	 */
	private DrawingPanel sketchpad;
	
	/**
	 * To choose the border and fill colors
	 */
	private Button[] colors;
	
	/**
	 * The color choices.  The one that isn't a Color constant is purple 
	 * (half red, half blue)
	 */
	private final Color[] INK = {Color.white, Color.yellow, Color.orange, Color.red,
			Color.green, new Color(128, 0, 128), Color.blue, Color.black};
	
	/**
	 * Polygon, square or circle
	 */
	private Checkbox[] shape;
	
	/**
	 * Small or large, active only when shape is not a polygon
	 */
	private Checkbox[] size;
	
	/**
	 * To choose fill and edge colors
	 */
	private Checkbox[] draw;
	
	/**
	 * To display which colors have been chosen for fill and edge
	 */
	private Label[] colorDisplay;
	
	/**
	 * illustrates use of BoxLayout and GridLayout
	 * @param canvas where the drawing is taking place
	 */
	public ControlPanel(DrawingPanel canvas){
		sketchpad = canvas;
		
		//This sets the layout for the whole panel, saying that the
		//components will be placed in order from top to bottom
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//The controls for choosing which shape
		Panel shapePanel = new Panel();
		//also laid out vertically
		shapePanel.setLayout(new BoxLayout(shapePanel, BoxLayout.Y_AXIS));
		
		//You need a CheckboxGroup when you want to have only one checkbox in
		//the group selected at a time
		CheckboxGroup g1 = new CheckboxGroup();
		shape = new Checkbox[3];
		//the polygon is the default, which is why its state is true
		shape[0] = new Checkbox("Polygon", g1, true);
		shape[1] = new Checkbox("Square", g1, false);
		shape[2] = new Checkbox("Circle", g1, false);
		for(int i = 0; i<3; i++){
			//it doesn't matter which order these two commands are in
			shapePanel.add(shape[i]);
			//so you can respond when they choose which shape
			shape[i].addItemListener(this);
		}
		//this adds the panel with the three checkboxes as the first component
		//(at the top) of the control panel itself
		add(shapePanel);
		
		//this panel is for selecting the border and fill colors
		Panel c = new Panel();
		//it's laid out from left to right rather than top to bottom
		c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));
		//you need another CheckboxGroup so you know whether they are
		//currently choosing the edge or the fill color (can't choose both
		//at the same time)
		CheckboxGroup g2 = new CheckboxGroup();
		draw = new Checkbox[2];
		draw[0] = new Checkbox("Edge", g2, true);
		draw[1] = new Checkbox("Fill", g2, false);
		//The labels are to show the currently selected colors for each
		colorDisplay = new Label[2];
		//No word, but space reserved so the color can be seen
		for(int i=0; i < 2; i++)
			colorDisplay[i] = new Label("     ");
		//default colors
		colorDisplay[0].setBackground(Color.black);
		colorDisplay[1].setBackground(Color.white);
		
		//Adding the two checkboxes and labels to the panel
		for(int i=0; i<2; i++){
			c.add(draw[i]);
			c.add(colorDisplay[i]);
		}
		
		//adding this as the second component (after the panel with the
		//choices for which shape)
		add(c);
		
		//this is the panel with the colors themselves
		Panel colorChoices = new Panel();
		
		//4 rows, two columns for the 8 color buttons
		colorChoices.setLayout(new GridLayout(4,2));
		colors = new Button[8];
		//Use the array of colors to set the colors of the buttons
		for(int i=0; i<8; i++){
			colors[i] = new Button();
			colors[i].setBackground(INK[i]);
			colors[i].addActionListener(this);
			//this adds the new button to the panel of buttons
			colorChoices.add(colors[i]);
		}
		//the color panel is added immediately below the horizontal panel
		//for the edge and fill color choices
		add(colorChoices);
		
		//the last panel, for selecting the size of the shape when the
		//shape is either a square or circle
		Panel sizePanel = new Panel();
		//set vertically
		sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.Y_AXIS));
		//so they can't choose large and small at the same time
		CheckboxGroup g3 = new CheckboxGroup();
		size = new Checkbox[2];
		//small is the default
		size[0] = new Checkbox("small", g3, true);
		size[1] = new Checkbox("large", g3, false);
		for(int i = 0; i<2; i++){
			size[i].addItemListener(this);
			sizePanel.add(size[i]);
			//since the default shape is polygon, these choices are grayed out
			//until the user selects square or circle
			size[i].setEnabled(false);
		}
		add(sizePanel);
		
	}

	/**
	 * Invoked when one of the buttons (not checkboxes) is clicked,
	 * this sets the color for either the edge or fill, depending
	 * on which is selected.
	 */
	public void actionPerformed(ActionEvent e) {
		//to stop looping when the button is found
		boolean buttonFound = false;
		//it will give a compiler error if set to null
		Color chosen = INK[0];
		int i = 0;
		//we won't go beyond the array since actionPerformed() is only
		//invoked when a button is clicked, so one of them must be the
		//source.
		while(!buttonFound){
			if(e.getSource()==colors[i]){
				buttonFound = true;
				chosen = INK[i];
			}
			i++;
		}
		//If the state of the edge checkbox is true, then we change the
		//edge color
		if(draw[0].getState()){
			//this changes the color next to the edge checkbox
			colorDisplay[0].setBackground(chosen);
			//this changes the color of the shape's edge
			sketchpad.setBorder(chosen);
		}//otherwise the fill checkbox must be chosen
		else{
			//this changes the color next to the fill checkbox
			colorDisplay[1].setBackground(chosen);
			//this changes the fill color of the shape itself
			sketchpad.setFill(chosen);
		}
		
	}



	/**
	 * This is invoked if the shape or large/small checkboxes are clicked.
	 * It won't be invoked if the edge/fill checkboxes are invoked because
	 * no listener was added to those checkboxes.
	 */
	public void itemStateChanged(ItemEvent e) {
		//first see if it's one of the shapes.  If it's the polygon, then
		//we need to make sure that the large/small checkboxes are grayed out.
		if(e.getSource()==shape[0]){
			for(int i=0; i<2; i++)
				size[i].setEnabled(false);
			//and we'll reset the shape to a polygon (which clears any shape
			//that was there previously)
			sketchpad.setShape(0);
		}//if it's not the polygon we'll first check to see if it's either of
		//the other two shapes
		else{
			//so we know if we must keep looking for the checkbox
			boolean sourceFound = false;
			//our loop starts at 1 since we already checked for the polygon
			//if it's either the square or circle we want to enable the large/
			//small checkboxes
			for(int i=1; i<3; i++){
				if(e.getSource()==shape[i]){
					sketchpad.setShape(i);
					for(int j = 0; j<2; j++)
						size[j].setEnabled(true);
					sourceFound = true;
				}
			}
			//If it wasn't one of the shapes, it must be the small or large
			//checkbox
			if(!sourceFound){
				if(e.getSource()==size[0]){
					//make the square or circle small
					sketchpad.setSize(false);
				}else
					//make the square or circle large
					sketchpad.setSize(true);
			}
		}
		
	}

}
