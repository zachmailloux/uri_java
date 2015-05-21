import java.awt.Color;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


public class Wiz extends Frame implements MouseListener{
	int newx = 10;
	int newy = 10;
	public Wiz(){
		setTitle("Aww skeet skeet"); //create a title for window
		setSize(600,400);
		setLocation(150,150);	
		setBackground(Color.GREEN);
		myWindow = new main();//to allow for window closing
		addWindowListener(myWindow);
		addMouseListener(this);
		repaint();
	}
	public void paint(Graphics pane){
		hearts(pane);
	
	}
	public void hearts(Graphics pane){
		pane.setColor(Color.red);
		int xPoints[] = {newx+30, newx+50, newx+70};
		int yPoints[] = {newy+75, newy+95, newy+75};
		pane.fillPolygon(xPoints, yPoints, 3);
		pane.fillOval(newx + 28, newy + 60, 22, 20);
		pane.fillOval(newx + 48, newy + 60, 22, 20);
	}
	public void diamonds(Graphics pane){
		pane.setColor(Color.red);
		int xPoints[] = {newx+30, newx+50, newx+70};
		int yPoints[] = {newy+75, newy+95, newy+75};
		int xPointsdos[] = {newx+30, newx+50, newx+70};
		int yPointsdos[] = {newy+75, newy+55, newy+75};
		pane.fillPolygon(xPoints, yPoints, 3);
		pane.fillPolygon(xPointsdos, yPointsdos, 3);
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
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
