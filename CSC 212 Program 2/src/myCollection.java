import java.awt.Graphics;
import java.util.Random;


public class myCollection implements Collection{
	int x,y;
	int count=1;
	Ball[] court=new Ball[count];
	boolean found = false; 
	myCollection(){

	}

	
	public void add(Ball someBall) {///////////
		Ball[] temp = new Ball[count];
		for(int i = 0;i<count-1;i++){
			if(court[i]!=null){
			temp[i]=court[i];}
		}
		System.out.println("Enter add");
		temp[count-1]=someBall;
		court = temp;
		count++;
	}

	@Override
	public void remove() {
		count--;
		if(count>=1){
		Ball[] temp = new Ball[count-1];
		for(int i = 0;i<count-1;i++){
				temp[i]=court[i];
			}
		court = temp;}
		else{}

	}
	public void movement() {
		for(int i = 0;i<count-1;i++){
			court[i].movement();
		}
	}
	public void paint(Graphics pane) {
		int i = 0;
		while(i<court.length&&court[i]!=null){
			court[i].paint(pane);
			i++;
		}
		
	}
	public void collisionCheck(){
		for(int i =0;i<court.length;i++){
			 x = court[i].xloc();
			 y = court[i].yloc();
		//	 System.out.println("checked");
			 if(court[i].smashed()==false){
			for(int j=i+1;j<court.length;j++){
					if(court[j].isInside(x, y)==true){
						System.out.println("Smash confirmed.");
						court[j].smash();
						court[i].smash();
				}
			}
		}
		}
	}
	public int getAmount() {
		return count;	
	}

	@Override
	public void isEmpty() {
		// TODO Auto-generated method stub
		
	}

}
