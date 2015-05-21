package shapes;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;

public class Triangle extends myShape{
	

	/**
	 * To hold the shape so it doesn't have to be recreated
	 * every time it's painted.
	 */
	private Polygon poly;
	
	/**
	 * Assigns the label.
	 */
	public Triangle(){
		super();
		
	}
	
	/**
	 * Sets all of the properties
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Triangle(int x, int y, int width, int height){
		super(x,y,width,height);
		poly = new Polygon();
		poly.addPoint(x + width/2, y);//top
		poly.addPoint(x, y + height);//lower left
		poly.addPoint(x + width, y + height);//lower right
	}

	public void setup(int x, int y, int width, int height){
		super.setup(x, y, width, height);
		poly = new Polygon();
		poly.addPoint(x + width/2, y);//top
		poly.addPoint(x, y + height);//lower left
		poly.addPoint(x + width, y + height);//lower right
	}
	


	public void paint(Graphics pane) {
		pane.setColor(color);
		pane.fillPolygon(poly);
		pane.drawPolygon(poly);
		super.paint(pane);
	}

}
