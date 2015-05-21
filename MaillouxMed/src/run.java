import java.net.MalformedURLException;

import javax.swing.JFrame;


public class run {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	static int level = 1;
	
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		MyWin Default = new MyWin("http://images3.wikia.nocookie.net/__cb20120730015739/leagueoflegends/images/9/95/ChampionSquare.png");
		Default.init("-", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, level);
		Default.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		String choice=Default.iName.getText();
		if(choice.equalsIgnoreCase("elise")){
			MyWin Elise = new MyWin("http://images.wikia.com/leagueoflegends/images/9/91/EliseSquare.png");
			Elise.init("Elise", 395, 80, 4.7, 0.6, 240, 50, 6.8, 0.65, 47.5, 3, 0.625, 0.0175, 30, 0, 12.65, 3.35, 335,1);
			Elise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		if(choice.equalsIgnoreCase("nasus")){
			MyWin Nasus = new MyWin("http://images.wikia.com/leagueoflegends/images/5/58/NasusSquare.png");
			Nasus.init("Nasus", 410, 90, 7.5, 0.9, 200, 45, 6.6, 0.5, 53.3, 3.5, 0.638, 0.0348, 30, 1.25, 15, 3.5, 350,1);
			Nasus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		/*if(choice.equalsIgnorCase("nasus")){
			MyWin Jayce = new MyWin("http://images.wikia.com/leagueoflegends/images/a/aa/JayceSquare.png");
			Jayce.init("Jayce", 420, 90, 6, 0.8, 240, 40, 7, 0.7, 46.5, 3.5, 0.658, 0.03, 30, 0, 12.5, 3.5, 335);
			Jayce.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		}
		
		
		
		//MyWin Elise = new MyWin("http://images.wikia.com/leagueoflegends/images/9/91/EliseSquare.png");
		//Elise.init("Elise", 395, 80, 4.7, 0.6, 240, 50, 6.8, 0.65, 47.5, 3, 0.625, 0.0175, 30, 0, 12.65, 3.35, 335,1);
		//Elise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//MyWin Nasus = new MyWin("http://images.wikia.com/leagueoflegends/images/5/58/NasusSquare.png");
		//Nasus.init("Nasus", 410, 90, 7.5, 0.9, 200, 45, 6.6, 0.5, 53.3, 3.5, 0.638, 0.0348, 30, 1.25, 15, 3.5, 350);
		//Nasus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//MyWin Jayce = new MyWin("http://images.wikia.com/leagueoflegends/images/a/aa/JayceSquare.png");
		//Jayce.init("Jayce", 420, 90, 6, 0.8, 240, 40, 7, 0.7, 46.5, 3.5, 0.658, 0.03, 30, 0, 12.5, 3.5, 335);
		//Jayce.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
