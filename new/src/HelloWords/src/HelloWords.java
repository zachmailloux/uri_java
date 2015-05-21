import java.util.Scanner;
public class HelloWords {

	public static void say(String speak){
		System.out.println(speak);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String phrase;
		String word;
		Scanner input = new Scanner(System.in);
		
		say("Enter a phrase.");
		phrase = input.nextLine();
		
		say("Number of characters in your phrase: " + phrase.length());
		say("First Character: " + phrase.charAt(0));
		say("Last character: " + phrase.charAt(phrase.length() - 1));
		
		say("Position of e: " + phrase.indexOf('e'));
		say("Substring of phrase: " + phrase.substring(0, 5));
		say("Substring of phrase: " + phrase.substring(6));
		
		word = phrase.substring(0, 5);
		word = word.replace('o', 'a');
		word = word.replace('e', 'o');
		phrase = word + phrase.substring(5);
		
		say("New phrase: " + phrase);
		
		input.close();

	}

}
