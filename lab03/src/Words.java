
/**
 * 
 * @author Zachary Mailloux
 *
 */

public class Words {
	/**	The instance reference myWords holds the String without 
	  any white space before the first word or after the last word */ 
	
	private String myWords;		
		
	/**	The instance variable originalLength holds the number of characters in the original String */ 

	private int originalLength;
		
		
	/**	The setString method receives a String, 
	  assumed to have no punctuation, and initializes 
	  the two data members. */ 
	
	public void setString(String someString){
		myWords = someString.trim();	
		originalLength = someString.length();
		
	}
	
	/**	The firstWord method returns the 
	  first word in myWords. */ 
	
	public String firstWord(){
		int firstWordIndex = 0;
		int firstWordSpaceIndex = myWords.indexOf(" ");
		String firstWord = myWords.substring(firstWordIndex, firstWordSpaceIndex);
		return firstWord;
	}
	
	/**	The lastWord method returns the 
	  last word in myWords. */ 
	
	public String lastWord(){
		int lastWordSpaceIndex = myWords.lastIndexOf(" ");
		
		String lastWord = myWords.substring(lastWordSpaceIndex+1);
		return lastWord.trim();
	}
	
	/**	The getStringLength method returns the 
	  length of myWords. */ 
	
	public int getStringLength(){
		int getStringLength = myWords.length();
		return getStringLength;
	}
	
	/**	The getOriginalLength method returns the 
	  length of the original, untrimmed String. */ 
	
	public int getOriginalLength(){
		return originalLength;
		
	}
	
	/**	The trimmedString method returns the 
	  complete trimmed String. */ 
	
	public String trimmedString(){
			return myWords;
	}

}
