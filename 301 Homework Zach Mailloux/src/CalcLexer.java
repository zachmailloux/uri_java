/**
 * A CalcLexer provides a simple scanner for a 
 * CalcParser.  We hold the string being parsed, and the
 * CalcParser uses us to read the string as a sequence
 * of tokens.
 */
public class CalcLexer {
  /**
   * The string being parsed, held in a 
   * StringTokenizer.
   */
  private java.util.StringTokenizer tokens;

  /**
   * The error message.  This will be null if there 
   * has been no error.
   */
  private String errorMessage = null;

  /**
   * The current token.
   */
  private int tokenChar;

  /**
   * If the current token is NUMBER_TOKEN, this is 
   * the number in question.
   */
  private double tokenNum;

  /**
   * Non-character values for tokenChar.  By choosing 
   * negative values we are certain not to collide 
   * with any char values stored in the int tokenChar.
   */
  public static final int NUMBER_TOKEN = -1;
  public static final int EOLN_TOKEN = -2;

  /**
   * Constructor for a CalcLexer.  Our parameter is the
   * string to be tokenized.
   * @param s the String to be tokenized
   */
  public CalcLexer(String s) {

    // We use a StringTokenizer to tokenize the string.
    // Our delimiters are the operators, parens, and 
    // white space.  By making the third parameter true
    // we instruct the StringTokenizer to return those
    // delimiters as tokens.

    tokens = new java.util.StringTokenizer(
                         s," \t\n\r+-*/()",true);

    // Start by advancing to the first token.  Note that 
    // this may get an error, which would set our 
    // errorMessage instead of setting tokenChar.

    advance();
  }

  /**
   * Advance to the next token.  We don't return
   * anything; the caller must use nextToken() to see
   * what that token is.
   */
  public void advance() {

    // White space is returned as a token by our 
    // StringTokenizer, but we will loop until something 
    // other than white space has been found.

    while (true) {

      // If we're at the end, make it an EOLN_TOKEN.

      if (!tokens.hasMoreTokens()) {
        tokenChar = EOLN_TOKEN;
        return;
      }

      // Get a token--if it looks like a number, 
      // make it a NUMBER_TOKEN.

      String s = tokens.nextToken();
      char c1 = s.charAt(0);
      if (s.length()>1 || Character.isDigit(c1)) {
        try {
          tokenNum = Double.valueOf(s).doubleValue();
          tokenChar = NUMBER_TOKEN;
        }
        catch (NumberFormatException x) {
          errorMessage = "Illegal format for a number.";
        }
        return;
      }

      // Any other single character that is not 
      // white space is a token.

      else if (!Character.isWhitespace(c1)) {
        tokenChar = c1;
        return;
      }
    }
  }

  /**
   * Return our error message.  This will be null if no 
   * error has occurred.
   *
   * @return error String or null if no error
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  /**
   * Return the value of a numeric token.  This should 
   * only be called when nextToken() reports a 
   * NUMBER_TOKEN.
   *
   * @return the double value of the number
   */
  public double getNum() {
    return tokenNum;
  }

  /**
   * Return the next token.  Repeated calls will
   * return the same token again; the caller should
   * use advance() to advance to another token.
   * @return the next token as an int
   */
  public int nextToken() {
    return tokenChar;
  }
}
