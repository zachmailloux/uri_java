import java.util.Scanner;
public class NumberOfVC {

	/**
	 * @param args
	 */
	public static void say(String speak){
		System.out.println(speak);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		String phrase;
		int vowels = 0;
		int consonants = 0;
		int other = 0;
		
		say("Enter a phrase.");
		phrase = input.nextLine();
		phrase = phrase.toLowerCase();
		for (int x = 0; x < phrase.length(); x++){
			if (phrase.charAt(x) == 'a' || phrase.charAt(x) == 'e' || phrase.charAt(x) == 'i' || phrase.charAt(x) == 'o' || phrase.charAt(x) == 'u' || phrase.charAt(x) == 'y'){
				vowels++;
			}
			else if (phrase.charAt(x) == 'q' || phrase.charAt(x) == 'w' || phrase.charAt(x) == 'r' || phrase.charAt(x) == 't' || phrase.charAt(x) == 'y' || phrase.charAt(x) == 'p' || phrase.charAt(x) == 's' || phrase.charAt(x) == 'd' || phrase.charAt(x) == 'f' || phrase.charAt(x) == 'g' || phrase.charAt(x) == 'h' || phrase.charAt(x) == 'j' || phrase.charAt(x) == 'k' || phrase.charAt(x) == 'l' || phrase.charAt(x) == 'z' || phrase.charAt(x) == 'x' || phrase.charAt(x) == 'c' || phrase.charAt(x) == 'v' || phrase.charAt(x) == 'b'|| phrase.charAt(x) == 'n' || phrase.charAt(x) == 'm'){
				consonants++;
			}
			else {
				other++; 
			}
			 
		}
		
		say("Your phrase has " + vowels + " vowels, " + consonants + " consonants, and " + other + " other characters.");
		input.close();
	}

}
