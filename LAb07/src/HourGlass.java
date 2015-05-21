	/**
 * Zachary Mailloux and Julian Colonia 
 */


	import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;
public class HourGlass {

		public int red, green, blue;
		private Polygon poly; //create your polygon

		public HourGlass(int x, int y){
			final int Shift = 20; // a variable to give the shape some depth
			
			int[] xValues = new int[4]; //create a x list
			int[] yValues = new int[4]; //create a y list
			x = x -5; //I changed the initial x and y values to center it
			y = y + 5;
			xValues[0] = x;
			xValues[1] = x+(Shift);
			xValues[2] = x;
			xValues[3] = x+(Shift);

			
			yValues[0] = y; 
			yValues[1] = y;
			yValues[2] = y-(Shift);
			yValues[3] = y-(Shift);
			Random random = new Random(); //starts a random
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
		
			poly = new Polygon(xValues, yValues, 4); //gives it the lists and the value 4 (limit)
			
		}
		
		public void paintHourGlass(Graphics pane){
			pane.fillPolygon(poly);
			pane.setColor(new Color(red, green, blue)); //prints that random color
		}


}
