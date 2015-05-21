
public class Pet {
	
	private String name;
	private String type;
	private String color;
	private int calories;
	
		Pet(){
			name = "Sam";
			type = "dog";
			color = "black";
			setCalories(3000);
		}
		Pet(String n){
			name = n;
			type = "dog";
			color = "black";
			setCalories(3000);
		}
		Pet(String n, String t, String c){
			name = n;
			type = t;
			color = c;
			setCalories(3000);
		}
		
		//Setter for name
		void setName(String n){
			if (n.length() <= 6)
				name = n;
			else
				name = n.substring(0,5);
		}
		//Getter for name
		String getName(){
			return name;
		}
		//setType
		void setType(String t){
			type = t;
		}
		//getType
		String getType(){
			return type;
		}
		//setColor
		void setColor(String c){
			color = c;
		}
		//getColor
		String getColor(){
			return color;
		}
		int getCalories() {
			return calories;
		}
		void setCalories(int calories) {
			this.calories = calories;
		}

}
