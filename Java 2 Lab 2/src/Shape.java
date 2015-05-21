import java.awt.Graphics;


public abstract class Shape {

	protected final int						//	To define the size of our buttons
	BUTTON_WIDTH = Abutton.BUTTON_WIDTH,
	BUTTON_HEIGHT = Abutton.BUTTON_HEIGHT;
	protected int	x, y,						//	The square's location
	size;
	Shape(){
		this.randomize();
	}
	public void randomize()
	{
		x = (int) (200 * Math.random()) + BUTTON_WIDTH * 2;
		y = (int) (200 * Math.random()) + BUTTON_HEIGHT * 2;
		size = (int) (100 * Math.random());
	}
	public void paint(Graphics pane)
	{
		
	}
}
