import java.util.Scanner;

public class fixmetwo {
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Say something!");
		String input = keyboard.nextLine();
		String second = "";
		for(int i = 0; i<input.length(); i++)
		{
			int s = (int)(input.charAt(i));
			if(s >= 65 && s <=90) //a-z
				s+=32;
			else if(s>=97 && s <= 122)//A-Z
				s-=32;
			second += (char)s;
		}
	}
}

