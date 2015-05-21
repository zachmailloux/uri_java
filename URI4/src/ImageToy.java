import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


public class ImageToy extends Component{

	/**
	 * Using a BufferedImage allows for many options... see
	 * http://docs.oracle.com/javase/tutorial/2d/images/index.html
	 * for more information on working with images
	 */
	private BufferedImage img;

	/**
	 * Used for scaling the image to fit the window
	 */
	private double winWidth, winHeight, imageWidth, imageHeight;

	/**
	 * Scales the picture so it fits into the frame
	 */
	public void paint(Graphics pane) {
		//The first four coordinates are of the frame, and the second are
		//of the source.  By setting the destination to 0,0 and the height
		//and width of the window, and setting the source to 0,0 and the
		//height and width of the source, the original image fills the frame. 
		//If you wanted to crop an image you would adjust
		//the starting or ending coordinates of the source.  If you wanted
		//it to take up a smaller part of the frame you would adjust the starting
		//or ending coordinates of the destination.
		pane.drawImage(img, 0, 0, (int)winWidth, (int)winHeight, 0, 0, 
				(int)imageWidth, (int)imageHeight, null);
	}

	public ImageToy() {
		//first load up the image
		try {
			//note that the file should be stored in the project folder, but
			//NOT the src folder
			img = ImageIO.read(new File("kitten.JPG"));
		} catch (IOException e) {
		}
		//we can have-a Frame without being a Frame!
		Frame window = new Frame("Kitten");
		
		//setting the size and location of the window based on the size
		//of the screen and the image
		
		//screen size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//image size
		imageWidth = img.getWidth(null);
		imageHeight = img.getHeight(null);
		
		//setting the frame size in relation to the screen
		winHeight = screenSize.height * .9;
		
		//make sure we preserve the ratio of width to height of the picture
		winWidth = (winHeight/imageHeight)*imageWidth;
		//in case the scaled width doesn't fit in the screen
		if(winWidth > screenSize.width){
			winWidth = screenSize.width * .9;
			winHeight = winWidth/imageWidth * imageHeight;
		}
		//now we can set the size of the window
		window.setPreferredSize(new Dimension((int)winWidth, (int)winHeight));
		
		//center the window in the screen
		int winX = (int)(screenSize.width - winWidth)/2;
		int winY = (int)(screenSize.height - winHeight)/2;
		window.setLocation(winX, winY);

		//this is an anonymous class (you could use an UneFenetre instead)
		window.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		//we add the Component with the picture to the Frame
		window.add(this);
		window.pack();
		window.setVisible(true);


	}

	public static void main(String[] args) { 
		new ImageToy();

	}



}
