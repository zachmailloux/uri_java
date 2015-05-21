import java.awt.Graphics;
import java.util.Random;


public class myCollection implements Collection{
	int x,y;
	int count=1; //amount of balls in the array
	int score1 = 0; //how many balls went through the basket
	int score2 = 0;
	Ball[] court=new Ball[count]; //array of balls 
	boolean found = false; //no idea why I have this
	myCollection(){

	}

	
	public void add(Ball someBall) {///////////
		Ball[] temp = new Ball[count];//temp array
		for(int i = 0;i<count-1;i++){//go through array
			if(court[i]!=null){ //if there are balls in that array
			temp[i]=court[i];}//copy all the balls from the last array
		}
		System.out.println("Ball added");
		temp[count-1]=someBall;//add the new ball to the END of the array
		court = temp; //make court = to the temp array
		count++; //raise count
	}

	@Override
	public void remove() {
		count--; //take one away from the total number of balls
		if(count>=1){ //if theres enough balls to remove
		Ball[] temp = new Ball[count-1];//make smaller temp array
		for(int i = 0;i<count-1;i++){//copy all but the last ball
				temp[i]=court[i];//copy
			}
		court = temp;}//set court = to the temp array
		else{//if theres not enough balls to remove dont do anything
			
		}

	}
	public void movement() {
		for(int i = 0;i<count-1;i++){//makes every ball in the array move
			court[i].movement();//move
		}
	}
	public void paint(Graphics pane) {
		int i = 0;
		while(i<court.length&&court[i]!=null){//paint all of the balls in the court
			court[i].paint(pane);
			i++;
		}
		
	}
	public void collisionCheck(){
		for(int i =0;i<court.length;i++){//check each ball
			 x = court[i].xloc();//get its location
			 y = court[i].yloc();
			 if(court[i].smashed()==false){//if it hasn't already smashed into a ball
			for(int j=i+1;j<court.length;j++){//compare it to each of the other balls
					if(court[j].isInside(x, y)==true){//if its inside the other ball
						System.out.println("Smash confirmed.");//print
						court[j].smash();//make them both smash or repel
						court[i].smash();
				}
			}
		}
		}
	}
	public void hoopcheck(){
		for(int i =0;i<court.length;i++){//for every ball in our court
			 x = court[i].xloc();//get their location
			 y = court[i].yloc();
			 if((isInsideHoop1(x,y)==true)&&court[i].isFalling()==true){//if its inside our hoop's location and is falling
				score1 +=1; //add to our score1
				court[i].swoosh();//make the ball shoot down
			 }
			 if((isInsideHoop2(x,y)==true)&&court[i].isFalling()==true){//if its inside our hoop's location and is falling
					score2 +=1; //add to our score1
					court[i].swoosh();//make the ball shoot down
			 }
		}
	}
	public int getScore1(){//to return the score1
		return score1;
	}
	public int getScore2(){//to return the score1
		return score2;
	}
	public void setScore(int newscore){//used to reset the score1 and score2 back to 0
		score1 = newscore;
		score2 = newscore;
	}
	public int getAmount() {//returns the amount of balls in the array
		return count;	
	}
	public boolean isInsideHoop1(int someX, int someY)//the isInside method is used to determine if a ball is within the hoop1 area
	{
		return ((someX+10 >= 62) && (someX+10 <= 102)
				&& (someY+10 >= 415) && (someY+10 <= 421));
	}
	public boolean isInsideHoop2(int someX, int someY)//the isInside method is used to determine if a ball is within the hoop2 area
	{
		return ((someX+10 >= 373) && (someX+10 <= 413)
				&& (someY+10 >= 415) && (someY+10 <= 421));
	}

	@Override
	public void isEmpty() {
	
		
	}

}
