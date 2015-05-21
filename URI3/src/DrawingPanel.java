import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Depending on whether you're drawing a polygon or a circle or square, (which
 * decision is made in the control panel), this either centers the circle or 
 * square around the mouseclick or it adds another point to the polygon.  The
 * fill and border color of the shape is determined in the control panel as well.
 * @author dkm
 *
 */
public class DrawingPanel extends Panel implements MouseListener{
	
	/**
	 * This is of the panel itself for the sake of drawing a pseudo border
	 */
	private int width, height;
	
	/**
	 * The colors of the outline and fill of the shape
	 */
	private Color fill, border;
	
	/**
	 * if 0, it's a polygon; 1 is a square and 2 is a circle
	 */
	private int whichShape = 0;
	
	/**
	 * If a square or circle is large, it's got twice the width of the small
	 */
	private boolean isLarge = false;
	
	/**
	 * Used for placing a square or circle
	 */
	private int centerX, centerY;
	
	/**
	 * Starts out with no points - the first click adds the first point
	 */
	private Polygon poly;
	
	/**
	 * Start out with an empty polygon with black border and white fill as default
	 */
	public DrawingPanel(){
		addMouseListener(this);
		fill = Color.white;
		border = Color.black;
		poly = new Polygon();
	}
	
	/**
	 * Kludgy way of getting the dimensions of the panel after it's visible.
	 * Used for drawing a pseudo-border
	 */
	public void setDimensions(){
		width = getWidth();
		height = getHeight();
	}
	
	/**
	 * Sets whether a polygon, square or circle
	 * @param shape if 0, polygon, if 1, square, if 2 circle
	 */
	public void setShape(int shape){
		whichShape = shape;
		poly.reset();//starts a new polygon
		repaint();
	}
	
	/**
	 * Sets whether square or circle is large or small
	 * @param size if true the size will be large
	 */
	public void setSize(boolean size){
		isLarge = size;
		repaint();
	}
	
	/**
	 * 
	 * @param c the fill color of the shape
	 */
	public void setFill(Color c){
		fill = c;
		repaint();
	}
	
	/**
	 * 
	 * @param edge the color of the border of the shape
	 */
	public void setBorder(Color edge){
		border = edge;
		repaint();
	}
	
	/**
	 * paints the border and whichever shape was chosen
	 * @param pane
	 */
	public void paint(Graphics pen){
		//so we can change the thickness of the edge (and border)
		//and also for drawing and filling the polygon
		Graphics2D pane = (Graphics2D)pen;
		
		//So the color of the edge of the shape is more visible
		pane.setStroke(new BasicStroke(3));
		
		//Our kludgy pseudo-border for the panel
		pane.setColor(Color.black);
		pane.drawRect(0, 0, width, height-2);
		
		//if it's a polygon
		if(whichShape==0){
			pane.setColor(fill);
			pane.fill(poly);
			pane.setColor(border);
			pane.draw(poly);
		}else{
			int half = 30;
			if(isLarge)
				half = 2*half;
			pane.setColor(fill);
			if(whichShape==1)
				pane.fillRect(centerX-half, centerY-half, half*2, half*2);
			else
				pane.fillOval(centerX-half, centerY-half, half*2, half*2);
			pane.setColor(border);
			if(whichShape==1)
				pane.drawRect(centerX-half, centerY-half, half*2, half*2);
			else
				pane.drawOval(centerX-half, centerY-half, half*2, half*2);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * more responsive than mouseClicked(), this either adds a point to
	 * the polygon or it changes where the circle or square is centered
	 */
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(whichShape==0)
			poly.addPoint(x, y);
		else{
			centerX = x;
			centerY = y;
		}
		repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
