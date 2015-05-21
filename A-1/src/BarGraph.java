import java.awt.*;

public class BarGraph {
	public final int WIDTH = 30;
	public final int HEIGHT = 20;
	private int x ;
	private int y ;
	private int temp;
	private int winCounter;
	private int score = 100;
	

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
		//HERE IF THE SCORE IS <0
		//change color, go other direction
	}
}