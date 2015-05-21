import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.util.Random;
import javax.swing.Timer;
import Abutton.*;




public class Game extends Frame implements MouseListener, ActionListener {
	/**value for max amount of ducks*/
	private int totalducks = 20;  //the total amount of ducks in the array
	private int goldducks = 10; //total amount of gold ducks in the array
	/**create your array of ducks*/
	private Target[] Duckfield =  new Duck[totalducks]; //make your array of good ducks
	private Target[] RareDuckfield =  new RareDuck[totalducks]; //make your array of sick ducks
	private Target[] Bloodfield = new blood[totalducks]; //make your array of blood that will be in place of the ducks.
	private brush [] Brushfield = new brush[250]; //creates an array of brush grass blades
	private Target [] GoldDuckfield = new GoldenDuck[goldducks]; //creates an array of golden ducks 
	private Node tempDuck;
	private Node head;
	private Node duckList; //this will be our linked list of ducks
	/**create window*/
	private main myWindow; 
	/**create a font for the title in the bottom center*/
	private static Font monoFont = new Font("Monospaced", Font.BOLD 
			| Font.ITALIC, 65);
	private static Font monoFontsmall = new Font("Monospaced", Font.BOLD 
			| Font.ITALIC, 16);
	/**create a menu screen*/
	private boolean menuvalue = false; 
	/**value score of ducks hit*/
	private int score = 0; 
	private int badscore = 0;
	/**value missedscore to keep count of ducks missed*/
	private int missedscore = 0; 
	/**create a new random*/
	private Random random = new Random(); 
	/**create a delay that will act as the timer between actions*/
	private int delay = 15; 
	/**create your multiple buttons*/
	public Abutton menu, resume, close, newbutt; 
	/**create and instantiate your timer*/
	private Timer t = new Timer(delay, this);
	private int welcome = 0;
	private int welcomemenu = 1;
	private int welcomemenu2 = 1;
	private int ready = 1;
	private int set = 1;
	private int go = 1;
	private int time = 40;
	private int flying = 300; //this variable is used to determine how many many cycles the bird moving loop will go through before resetting the birds
	private int eventTime = 0;
	private int direction= 0; //to determine whether they're facing left or right, 0 = Right, 1 = Left
	
	/**The game constructor sets up the window,
	creates a button and then starts the overall game process*/
	public Game(){
		/**name, location and size of our frame*/
		setTitle("Duck Hunter Beta V 1.04.3");
		setLocation(150,150);		
		setSize(900,725);
		/**to allow for window closing*/
		myWindow = new main();
		addWindowListener(myWindow); 
		/**so you can handle the mouse click*/
		addMouseListener(this);
		setVisible(true); 
		/**create the menu button*/
		menu = new MenuButton("Menu", Color.yellow, 735, 650, 
				100, 50); 
		/**call the adding ducks method*/
		addingbrush();
		addingducks();
		gameReady();
		/**start the timer*/
		t.start(); 
		repaint(); 
	}
	/**the addingducks method generates 500 random ducks with random x and y coordinates 
	 and adds them to the linked list*/
	public void addingducks(){ 
		
		for (int i = 0; i < totalducks; i++){ /**for in the total amount of ducks*/
			int randX = random.nextInt(500)+200; /**create */
			int randY = random.nextInt(150)+400;
			int whatDuck = random.nextInt(10)+1;
			if(i<10){ 
				direction = 0;}
			if(i>=10){
				direction = 1;}
			//HE
			tempDuck = new Node();	// temporary Node for an item
			if(whatDuck<7){
				tempDuck.setDuck(new Duck(randX,randY, direction,true));	// put the item in the Node
			}
			else if(whatDuck>=7&&whatDuck<10){
				tempDuck.setDuck(new RareDuck(randX,randY, direction,true));	// put the item in the Node
			}
			else{
				tempDuck.setDuck(new GoldenDuck(randX,randY, direction,true));	// put the item in the Node
			}
			tempDuck.setNext(head);		// update next Node to be head
			head = tempDuck;				// Now head is first in list
			
			
			
			//RareDuckfield[i] = new RareDuck(randX,randY,direction,true); //this means that the blood will be in the same area that the ducks are.
			//Bloodfield[i] = new blood(randX,randY,direction,true);
			//GoldDuckfield[i] = new GoldenDuck(randX,randY,direction,true);
			}
		
	}
	
	public void addingbrush(){
		int xlocation = -35;
		for(int i= 0;i<250; i++){
			int rY = random.nextInt(25)+425;
			int rWidth = random.nextInt(25)+45;
			int rHeight = random.nextInt(75)+200;
			int rA1 = random.nextInt(10)+35;
			int rA2 = random.nextInt(35)+35;
			xlocation = xlocation +5;
			Brushfield[i]= new brush(xlocation,rY,rWidth,rHeight,rA1,rA2);
		}
	}
	/**The game ready method is responsible for pausing the program while changing the variables that will result in different 
	 * of the "Ready, Set, Go!" as well as the menu Opening that I have for my game.
	 */
	public void gameReady(){
		repaint();
		// printing the welcome
		try {Thread.sleep(2000);} 
		catch (InterruptedException e){} 
		welcomemenu = 0;
		//now adds the image of the good duck along with a description
		repaint();
		try {Thread.sleep(5000);} 
		catch (InterruptedException e){}
		welcomemenu2 = 0;
		//now shows and explains the duck you DON'T want to shoot.
		repaint();
		try {Thread.sleep(6000);}
		catch (InterruptedException e) {}
		welcome = 1;
		welcomemenu = 1;
		welcomemenu2 =1;
		//clears the menu and starts the "Ready, Set, Go" with the set
		ready = 0;
		repaint();
		try {Thread.sleep(2000);} 
		catch (InterruptedException e) {}
		ready = 1;
		//get rid of ready and print set
		set = 0;
		repaint();
		try {Thread.sleep(2000);} 
		catch (InterruptedException e) {}
		set =1;
		//get rid of set and print go
		go = 0;
		repaint();
		//System.out.println("gameReady"); //used for debugging
		try {Thread.sleep(2000);} 
		catch (InterruptedException e) {}
		go = 1;
		//clear the go
		repaint();
	}


	@Override
	/**
	 * The mouseclicked method will be responsible for getting the x and y location and then going through a serious of 
	 * isInside loops to determine what is being clicked, in which it then will perform a series of actions or call
	 * upon another method.
	 */
	public void mouseClicked(MouseEvent e) {
		int dosx = e.getX(); //get x location
		int dosy = e.getY(); //get y location
		if (menuvalue == true){
			if(resume.isInside(dosx, dosy)){ //if it hits the resume button
				menuvalue = false; //close the menu
				t.start(); //restart
			}
			if(newbutt.isInside(dosx, dosy)){ //if it hits the new button
				time = 40; //reset time
				menuvalue = false; //get rid of the menu
				score = 0; //reset ALL of the scores
				missedscore = 0;
				badscore = 0;
				t.start(); //restart the program
			}
			if(close.isInside(dosx, dosy)){ //close the whole program
				System.exit(0);
			}
		}
	}

	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	/**
	 * I used my mousepressed method for more sensitive clicking items such as the ducks. It starts by grabbing the x and y coordinates 
	 * and then continues to put them through a series of loops to see if they clicked on a currently visible duck or menu in which 
	 * it then performs a series of statements or calls on another method to do so.
	 */
	public void mousePressed(MouseEvent e) {
		/**if the click is inside the array of ducks*/
		int x = e.getX();
		int y = e.getY();
		Node temp = head;

			if (head != null) // if there is a head
			{
				if(head.isInside(x, y)) // and it is selected
				{
					head = head.getNext(); // update the head to the next Node, so old head is gone

				}

				else 
				{

					while(temp != null) 
					{
						if((temp.getNext() != null) &&
								(temp.getNext().isInside(x, y) == true))
						{
							
							temp.setNext(temp.getNext().getNext());
						}
						
						temp = temp.getNext();
					}
				}
			}
		
		
			if(menu.isInside(x, y)){
				t.stop();
				menuvalue = true;
			}
			repaint();
		}
	
	public void mouseReleased(MouseEvent arg0) {}

	/**
	 * My gameStart method is responsible for checking to see what word is currently "positive" in the gameReady method
	 * it will cycle through loops to see what word is valid and will then go on to print it.
	 * @param pane
	 */
	public void gameStart(Graphics pane){
		pane.setColor(Color.black);
		if(ready == 0){
			pane.setFont(monoFont);
			pane.drawString("Ready!", 330, 350);
		}
		if(set == 0){
			pane.setFont(monoFont);
			pane.drawString("Set!", 370, 350);
		}
		if(go == 0){
			pane.setFont(monoFont);
			pane.drawString("Go!", 380, 350);
		}
		if(welcome == 0){
			pane.setFont(monoFont);
			pane.drawString("Welcome to Duck Hunter", 20, 100);
			}
		if(welcomemenu == 0){
			pane.setColor(Color.black);
			pane.setFont(monoFontsmall);
			pane.drawString("The objective is to shoot as", 200, 300);
			pane.drawString("many of these ducks as you can", 200, 325);
			Target exampleduck = new Duck(530,285,direction,true);
			tempDuck = new Node();
			tempDuck.setDuck(exampleduck);
			tempDuck.paint(pane);
			head = tempDuck;}
		if(welcomemenu2 == 0){
			pane.drawString("All while avoiding these ducks that ", 160, 400);
			pane.drawString("are sick and will bring down your score", 143, 425);
			Target examplesickduck = new RareDuck(530,380,direction,true);
			tempDuck = new Node();
			tempDuck.setDuck(examplesickduck);
			head.setNext(tempDuck);
			head.getNext().paint(pane);
		}
	}
	@Override
	/**
	 * My actionPerformed method is the key part of my program. Every 2-3 second (dependent on variable) it will go through two sets of 
	 * two for loops, the first will change all the current visible ducks to not visible (this will clear the screen) only to be immediately
	 * replaced by the next set of for loops that will print a random amount of ducks on the screen. In the event that a duck is clicked it 
	 * will then be replaced by the paint method with a blood splatter. This blood splatter will stay until the next action is performed 
	 * and clears it all. The timer is also based out of this method. After each cycle of this method the timer is lowered by one 
	 * until the timer is 0 which causes the game to stop
	 */
	public void actionPerformed(ActionEvent e) {
		/**
		 * If the action Event has taken place less than 25 times or more than 50 it will portray the ducks as 
		 * having not yet flapped their wings
		 */
		if((eventTime <= 25)||(eventTime>=50)){ 
		for(int i =0; (i<totalducks);i++){
			if(Duckfield[i].getFlapping() == true){
				Duckfield[i].setFlapping(false);}
			if(RareDuckfield[i].getFlapping() == true){
				RareDuckfield[i].setFlapping(false);}
		}
		}
		if((eventTime > 25)||(eventTime>=75)){
			for(int i =0; (i<totalducks);i++){
				if(Duckfield[i].getFlapping() == false){
					Duckfield[i].setFlapping(true);}
				if(RareDuckfield[i].getFlapping() == false){
					RareDuckfield[i].setFlapping(true);}
			}
			}
		if(eventTime >= 100){
			time = time -1;//here we decrement time so that the game will end after a certain amount of cycles.
			for(int j=0; j<totalducks; j++){
				Bloodfield[j].visible = false;}
			eventTime= 0;
			repaint();}
		flying = flying +1; //increase by one
		eventTime =eventTime + 1; //used to determine when we should change the time left to play and clear the blood.
		int shiftX=1;
		int shiftY=-1;
		/**
		 * Below I create a loop that gives a chance to change at what rate the duck is flying.
		 * There's a 2/5 chance that the duck will be flying fast and a 3/5 chance that the duck will be flying slowly.
		 */
		for(int i =0; (i<goldducks);i++){
			if(i<5){ //North West Sharp
				 shiftX = -3;
				 shiftY= -3;}
			if(i>=5){ //North West
				 shiftY = -3;
				 shiftX = 3;}
			if(GoldDuckfield[i].visible == true){
				GoldDuckfield[i].x = GoldDuckfield[i].x+shiftX;
				GoldDuckfield[i].y = GoldDuckfield[i].y+shiftY;}

		}
		for(int i =0; (i<totalducks);i++){
			if(i>=0&&i<100){ //North West Sharp
				 shiftX = -1;
				 shiftY= -2;}
			if(i>=100&&i<250){ //North West
				 shiftY = -1;
				 shiftX = -1;}
			if(i>=250&&i<400){ //North East
				 shiftY= -1;
				 shiftX = 1;}
			if(i>=400&&i<500){ //North East Sharp
				 shiftX = 1;
				 shiftY= -2;}
			/**
			 * Below is a loop that checks if the duck is visible, and if it is then it goes on to make 
			 * them move at the rate in which the shift has determined. Keep in mind the way the fuck is facing 
			 * and the direction in which that duck is moving was pre-determined by having [i]>250 to face one way
			 * while having your [i]<250 to face another.
			 */
			if(RareDuckfield[i].visible == true){
				RareDuckfield[i].x = RareDuckfield[i].x+shiftX;
				RareDuckfield[i].y = RareDuckfield[i].y+shiftY;
				repaint();}
			if(Duckfield[i].visible == true){
				Duckfield[i].x = Duckfield[i].x+shiftX;
				Duckfield[i].y = Duckfield[i].y+shiftY;
				repaint();}
			if(Bloodfield[i].visible == false){
				if(Duckfield[i].visible == true||RareDuckfield[i].visible == true){ //this checks to make sure there's a duck there.
				Bloodfield[i].x = Bloodfield[i].x+shiftX;
				Bloodfield[i].y = Bloodfield[i].y+shiftY; 
				repaint();}
			}
		}
		/**
		 * This loop is designed to repaint the ducks. I have flying as a variable that will be met in its 
		 * condition after the action event has occured 500 times. It then goes on to re-draw the array.
		 */
		if (flying>=550){ 
		for(int i=0; i<totalducks; i++){ //for all the ducks in the array
			if (Duckfield[i].visible == true){ //if any ducks are still true
				missedscore = missedscore +1; //add to the missed score count
			}
			repaint();}

		for(int i=0; i<totalducks; i++){ //for all the ducks in the array
			Duckfield[i].visible = false; //make all ducks not visible
			RareDuckfield[i].visible = false; //make all sick ducks not visible
			repaint();}
		int ducks = (random.nextInt(3)+3); //creates a random number of ducks
		int chanceofgoldduck = (random.nextInt(10));
		int ducksgold = (random.nextInt(2));
		int show = (random.nextInt(10)); //creates a random number to make a chance of the sick ducks not showing
		int Rareducks =0; // reset to 0
		if(show > 3){ //chance of showing the random ducks at all
			Rareducks = (random.nextInt(2)+1);}
		if(show > 8){ //chance of showing a greater amount of sick ducks
			Rareducks = (random.nextInt(3)+3);}
		if(chanceofgoldduck >= 7){ //chance of showing one gold duck that will be very fast
		for(int i = 0; i<ducksgold; i++){
			int randomgold = random.nextInt(10);
			GoldDuckfield[randomgold].setVisible(true);
			repaint();
		}
		}
		for(int i = 0;i<ducks;i++){
			int randduck = random.nextInt(500); //this chooses a random duck out of the array of 500 ducks
			Duckfield[randduck].setVisible(true); //sets that duck to be visible
			repaint();	
		}
		for(int i = 0;i<Rareducks;i++){ //finds a random rare duck and sets it to visible
			int randduck = random.nextInt(500);
			RareDuckfield[randduck].setVisible(true);
			repaint();}
		flying = 0; //resets the counter
		}	
	}
	/** 
	 * The timegraph method is used to portray the time left of the game to the player
	 * It does this by taking the counter and subtracting one each time the loop is completed
	 * @param pane
	 */
	public void timegraph(Graphics pane){
		if(time>15){
		pane.setColor(Color.green);
		pane.fillRect(835, 360, 40, time*6);}
		if((time<=15)&&(time>5)){
		pane.setColor(Color.yellow);
		pane.fillRect(835, 360, 40, time*6);
		}
		if(time<=5){
		pane.setColor(Color.red);
		pane.fillRect(835, 360, 40, time*6);}
	}
	public void greenbackground(Graphics pane){
		pane.setColor(Color.green);
		/**left tree*/
		pane.fillOval(-25, 100, 250, 125);
		pane.fillOval(30, 90, 45, 45);
		pane.fillOval(60, 90, 35, 30);
		pane.fillOval(30, 190, 45, 45);
		pane.fillOval(160, 180, 45, 45);
		pane.fillOval(128, 185, 45, 45);
		pane.fillOval(195, 150, 45, 45);
		pane.fillOval(185, 120, 45, 45);
		pane.fillOval(175, 120, 45, 45);
		pane.fillOval(120, 100, 45, 45);
		pane.fillOval(55, 190, 45, 45);//touching trunk
		pane.fillOval(105, 185, 45, 45);//touching trunk
		pane.fillOval(85, 190, 45, 45);//touching trunk
		/** right tree*/
		pane.fillOval(500, 75, 275, 150);	
		pane.fillOval(600, 90, 45, 45);
		pane.fillOval(520, 90, 35, 30);
		pane.fillOval(600, 190, 45, 45);
		pane.fillOval(520, 175, 45, 45);
		pane.fillOval(700, 175, 45, 45);
		pane.fillOval(500, 150, 45, 45);
		pane.fillOval(735, 120, 45, 45);
		pane.fillOval(725, 120, 45, 45);
		pane.fillOval(715, 100, 45, 45);
		pane.fillOval(623,185, 45, 45);
	}
	public void treebackground(Graphics pane){
		pane.setColor(new Color(175,120,105));
		pane.fillRect(75, 220, 50, 290);
		pane.fillRect(610, 220, 60, 290);
	}
	public void ground(Graphics pane){
		pane.setColor(Color.green);
		pane.fillRect(0, 450, 900, 175);}
	
	public void data(Graphics pane){
		pane.setColor(Color.green);
		pane.drawString(("Ducks Hit"), 20, 640);
		pane.drawString("("+score+ ")", 45, 660);
		pane.drawString(("Ducks Missed"), 125, 640);
		pane.drawString("("+(missedscore)+ ")", 145, 660);
		pane.drawString(("Total Score"), 125, 680);
		pane.drawString("("+(score-missedscore-badscore)+ ")", 145, 700);
	}
	public void badscoreshown(Graphics pane){
		pane.setColor(Color.red);
		pane.drawString(("Sick Ducks Hit"), 14, 680);
		pane.drawString("("+badscore+ ")", 55, 700);
	}
	public void sky(Graphics pane){
		pane.setColor(Color.cyan);
		pane.fillRect(0, 0, 900, 600);
	}
	/**
	 * The UI method shows the backdrop and the time left string appearing about the box
	 * @param pane
	 */
	public void UI(Graphics pane){
		pane.setColor(new Color(50,50,50));
		pane.drawString(("Time Left"), 825, 340);
		pane.fillRect(0, 625, 900, 125);	
		pane.fillRect(825, 350, 60, 260);}
	/**
	 * My title method will print the title of the game at the bottom
	 * @param pane
	 */
	public void title(Graphics pane){
		pane.setColor(Color.WHITE);
		pane.setFont(monoFont);
		pane.drawString("Duck Hunter!", 225, 690);
	}
	/**
	 * My menubar method will set the menu where the other buttons will be displayed
	 * @param pane
	 */
	public void menubar(Graphics pane){
		pane.setColor(Color.GRAY);
		pane.fillRect(350, 250, 200, 250);
	}
	/**
	 * Here I will paint of so many wonderful graphics, some of which will be dependent on variables
	 * This means that the menu wont print unless I have set a value or boolean menu to true or 1
	 * It will also have a loop for both sets of ducks to see if they're visible, and then print those that are. 
	 * The paint method also sets the tall gross in the background.
	 */
	public void paint(Graphics pane){
		/**here I will have a loop that paints the array of ducks*/
		sky(pane); //the blue sky
		ground(pane); //the green ground
		treebackground(pane); //this includes the trunks of the trees
		greenbackground(pane); //this is the green grass and trees
		Node currentNode = head; //temp node
		if (currentNode != null) {
			while (currentNode!=null) {
				currentNode.paint(pane);
				currentNode = currentNode.getNext();
				
			}
				
		}
		Color darkGreen = new Color(100,200,100);
		pane.setColor(darkGreen);
		pane.fillRect(0, 450, 900, 175);
		UI(pane); //this includes the bottom background and the back panel for the time graph
		badscoreshown(pane); //the red text
		timegraph(pane); //the actual time left
		data(pane); //the green data text
		menu.paint(pane); 	 //the menu IF it is true


		if (menuvalue == true){ //if the menu bar is supposed to be active
			menubar(pane); //print it again
			/**
			 * Here I create three buttons if the menu value is true, each with a purpose, they were originally going to be my use of inheritance 
			 * but it became clear that some of the things I wanted the buttons to do would become an issue when working
			 * outside of the game class. They are in fact extensions and child classes of the Abutton class but actually 
			 * have little to no code variation.
			 */
			resume =  new ResumeButton("Resume", Color.blue, 400, 275, 
					100, 50); //create the resume button

			close =  new CloseButton("Close", Color.red, 400, 425, 
					100, 50); //create the close button
			newbutt =  new NewButton("New Game", Color.green, 400, 350, 
					100, 50); //create the new button
			resume.paint(pane);//paint the resume button
			close.paint(pane);//paint the close button
			newbutt.paint(pane);//paint the new button
			}
		gameStart(pane); //print the beginning 
		title(pane); /**print the title last because it messes with the font*/
		if(time == 0){
			t.stop();
			menuvalue = true;
			pane.setColor(Color.WHITE);
			pane.setFont(monoFont);
			pane.drawString("Your Score was "+(score-missedscore-badscore)+"!", 125, 100);	

		}
	}
}
