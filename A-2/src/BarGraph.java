import java.awt.*;

/** This class implements the bar graph component to display the score of the game.
 * 
 * @author Cameron Cole
 *
 */

public class BarGraph 
{
	public int x, y;
	public final int WIDTH = 20, HEIGHT = 30;
	
	public BarGraph(int x, int y)	//constructor for bar graph
	{
		this.x = x;
		this.y = y;
	}
	
	public void paint(Graphics pane, int score)
	{
		pane.setColor(Color.black);
		pane.drawLine(x, y - 20, x, y + 20);	//divider line
		
		if (score > 0)	//draws rectangle to the right from center for right side score
		{	
			pane.setColor(Color.green);
			pane.fillRect(x, y - 15, score * WIDTH, HEIGHT);			
		}
		else if (score < 0)	//draws rectangle from the left to the right for left side score
		{
			pane.setColor(Color.red);
			pane.fillRect(x - (WIDTH * Math.abs(score)), y - 15, WIDTH * Math.abs(score), HEIGHT);
		}
		else	//draws rectangle with size 0 to signify 0 score.
		{
			pane.fillRect(x,y,0,0);
		}
			
	}
	
}
