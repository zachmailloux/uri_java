
import java.awt.Rectangle;

public class Rect {
	//Ints
	int rx, ry;
	int velRX = 1, velRY = 2;
	
		//Spawn Nemesis
		public Rect(int startX, int startY){
		rx = startX;
		ry = startY;		
	}

	//Movement for Nemesis
	public void move(){
		if(rx < 0){
			velRX=-velRX;
			rx=0;
		}
		if(rx > 570){
			velRX=-velRX;
			rx=570;
		}
		if(ry < 0){
			velRY=-velRY;
			ry=0;
		}
		if(ry > 350){
			velRY=-velRY;
			ry=350;
		}
		rx = rx + velRX;
		ry = ry + velRY;	
	}
	//Movement for Cop
	public void moveCop(){
		if(rx < 0){
			velRX=-velRX;
			rx=0;
		}
		if(rx > 550){
			velRX=-velRX;
			rx=550;
		}
		if(ry < 0){
			velRY=-velRY;
			ry=0;
		}
		if(ry > 330){
			velRY=-velRY;
			ry=330;
		}
		rx = rx + velRX;
		ry = ry + velRY;	
	}
	//getBoundsProtagonist
	public Rectangle getBoundsProtagonist(){
		return (new Rectangle(rx,ry, 40, 40));
	}
	//getBoundsNemesis
	public Rectangle getBoundsNemesis(){
		return (new Rectangle(rx,ry, 30, 30));
	}
	//getBoundsCop
	public Rectangle getBoundsCop(){
		return (new Rectangle(rx,ry, 50, 50));
	}
}
