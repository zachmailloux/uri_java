

import java.util.Random;

public class Foe {

	protected int health;
	final int WK = 1;
	final int NA = 0;
	final int STR = 2;
	protected int Atck;
	protected int Mag;
	protected int lastDmg;
	
	public Foe () {
		lastDmg = 0;
		health = 150;
		Random r = new Random();
		Atck = r.nextInt(3);
		switch(Atck){
		case NA:
			Mag = r.nextInt(3);
			break;
		case WK:
			Mag = r.nextInt(3);
			break;
		case STR:
			Mag = r.nextInt(2);
			break;
		}
	}
	
	public void respec () {
		health = 150;
		Random r = new Random();
		Atck = r.nextInt(3);
		switch(Atck){
		case NA:
			Mag = r.nextInt(3);
			break;
		case WK:
			Mag = r.nextInt(3);
			break;
		case STR:
			Mag = r.nextInt(2);
			break;
		}
	}
	
	public String atckDescription (boolean magic) {
		String desc;
		desc = "";
		if(health<=0){
			return "Enemy defeated!";
		}
		if(magic){
			switch(Mag){
			case NA:
				desc = "";
				break;
			case WK:
				desc = "This foe is weak to magic!";
				break;
			case STR:
				desc = "This foes resists magic!";
				break;
			}
		}else{
			switch(Atck){
			case NA:
				desc = "";
				break;
			case WK:
				desc = "This foe is weak to physical!";
				break;
			case STR:
				desc = "This foes resists physical!";
				break;
			}
		}
		return desc;
	}
	
	public int damageAtLevel (int level){
		int dmg=(int) (5+level*1.5);
		
		return dmg;
	}
	
	public boolean hitWith (int dmg, boolean magic){
		System.out.println(health);
		if(magic){
			switch(Mag){
			case NA:
				health -= dmg;
				lastDmg = dmg;
				break;
			case WK:
				health -= (int) (dmg*1.5);
				lastDmg = (int) (dmg*1.5);
				break;
			case STR:
				health -= (int) (dmg*0.5);
				lastDmg = (int) (dmg*0.5);
				break;
			}
		}else{
			switch(Atck){
			case NA:
				health -= dmg;
				lastDmg = dmg;
				break;
			case WK:
				health -= (int) (dmg*1.5);
				lastDmg = (int) (dmg*1.5);
				break;
			case STR:
				health -= (int) (dmg*0.5);
				lastDmg = (int) (dmg*0.5);
				break;
			}
		}
		System.out.println(health);
		if(health>=150){
			health = 150;
		}
		if(health<=0){
			return true;
		}else{
			return false;
		}
	}
}
