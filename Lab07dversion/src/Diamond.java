import java.awt.Graphics;
import java.awt.Polygon;


public class Diamond {
	private Polygon poly;
	
	public Diamond(int x, int y){
		final int RADIUS = 10;
		
		int[] xValues = new int[4];
		int[] yValues = new int[4];
		
		xValues[0] = x;
		xValues[1] = x+(RADIUS/2);
		xValues[2] = x+RADIUS;
		xValues[3] = x+(RADIUS/2);
		
		yValues[0] = y+(RADIUS/2);
		yValues[1] = y;
		yValues[2] = y+(RADIUS/2);
		yValues[3] = y+RADIUS;
	
		poly = new Polygon(xValues, yValues, 4);
	}
	
	public void paintDiamond(Graphics pane){
		pane.fillPolygon(poly);
	}
}
