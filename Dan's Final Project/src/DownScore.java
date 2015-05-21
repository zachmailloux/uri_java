import java.awt.Color;


public class DownScore extends Pellet {

	/**
	 * Default constructor for a DownScore Pellet, a class that extends Pellet. Therefore,
	 * the constructor for DownScore invokes the super() command and uses the default
	 * constructor defined within the Pellet class.
	 * @param xLoc the x location at which the pellet will be made.
	 * @param yLoc the y location at which the pellet will be made.
	 * @param someColor the colour that the pellet will be drawn in.
	 */
	public DownScore(int xLoc, int yLoc, Color someColor) {
		super(xLoc, yLoc, someColor);
		
	}

}
