package classPckg;

import java.io.Serializable;
import java.util.Random;

import javax.swing.JOptionPane;

public class Character implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String name;
	protected String class_;
	protected int strength;
	protected int magic;
	protected int stamina;
	protected int intelligence;
	protected int health;
	protected int level;
	protected int heals;
	Character () {
		name = "Name";
		this.setTheClass("Warrior");
		health=250;
		level = 1;
		heals = 5;
	}
	
	Character (String nm, String cl, int str, int ma, int sta, int intel, int hl, int lv){
		name = nm;
		class_ = cl;
		strength = str;
		magic = ma;
		stamina = sta;
		intelligence = intel;
		health = hl;
		level = lv;
		heals = 5;
	}
	public void levelUp () {
		level++;
		String popup = "";
		if(class_ == "Warrior"){
			if(level%2==0){
				this.strength ++;
				popup = popup + "Strength increased by 1!\n";
				if(level%3==0){
					this.stamina+=2;
					popup = popup + "Stamina increased by 2!\n";
				}else{
					this.stamina ++;
					popup = popup + "Stamina increased by 1!\n";
				}
			}else{
				this.strength ++;
				popup = popup + "Strength increased by 1!\n";
				this.magic++;
				popup = popup + "Magic increased by 1!\n";
				this.intelligence ++;
				popup = popup + "Intelligence increased by 1!\n";
				if(level%3==0){
					popup = popup + "Stamina increased by 1!\n";
					this.stamina++;
				}
			}
		}
		if(class_ == "Wizard"){
			if(level%2==0){
				this.magic ++;
				popup = popup + "Magic increased by 1!\n";
				if(level%3==0){
					popup = popup + "Intelligence increased by 2!\n";
					this.intelligence+=2;
				}else{
					popup = popup + "Intelligence increased by 1!\n";
					this.intelligence ++;
				}
			}else{
				this.strength ++;
				popup = popup + "Strength increased by 1!\n";
				this.magic++;
				popup = popup + "Magic increased by 1!\n";
				this.stamina ++;
				popup = popup + "Stamina increased by 1!\n";
				if(level%3==0){
					popup = popup + "Intelligence increased by 1!\n";
					this.intelligence++;
				}
			}
		}
		if(class_ == "Rogue"){
			System.out.println("Is Rogue");
			if(level%2==0){
				this.intelligence ++;
				popup = popup + "Intelligence increased by 1!\n";
				this.stamina ++;
				popup = popup + "Stamina increased by 1!\n";
				if(level%3==0){
					popup = popup + "Magic increased by 2!\n";
					this.magic+=2;
				}else{
					popup = popup + "Magic increased by 1!\n";
					this.magic ++;
				}
			}else{
				this.strength ++;
				popup = popup + "Strength increased by 1!\n";
				this.intelligence ++;
				popup = popup + "Intelligence increased by 1!\n";
				this.stamina ++;
				popup = popup + "Stamina increased by 1!\n";
				if(level%3==0){
					popup = popup + "Magic increased by 1!\n";
					this.magic++;
				}
			}
		}
		Random r = new Random();
		int newHeals = r.nextInt(6);
		String newHealS = "";
		if(newHeals>2){
			heals++;
			newHealS = "Gained a health potion!\n";
		}
		JOptionPane.showMessageDialog(null, popup+newHealS+"New enemy created!", "Level up!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public boolean hitWith(int dmg) {
		if(dmg>0){
			Random r = new Random();
			int dodge = r.nextInt(5+this.stamina);
			if(dodge>10+(this.level*0.75)){
				JOptionPane.showMessageDialog(null, "Dodged the attack!", "", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		}
		health -= dmg;
		if(health > 250){
			health = 250;
		}
		if(health <= 0){
			return true;
		}
		return false;
	}
	
	
	public void setTheClass(String cl){
		class_ = cl;
		
	}
	
}
