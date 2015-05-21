/**
 * A CalcParser is a calculator that evaluates a String
 * containing a numeric expression.  We handle numbers,
 * the operators +,-,*, and / with the usual precedence
 * and associativity, and parentheses.
 */
public class CalcParser {

  /**
   * We use a CalcLexer object to tokenize the input
   * string.
   */
  private CalcLexer lexer;

  /**
   * Our error message or null if there has been 
   * no error.
   */
  private String errorMessage = null;

  /**
   * The result of evaluating the expression (if 
   * no error).
   */
  private String value;

  /**
   * Constructor for CalcParser.  This actually does 
   * all the work. We parse and evaluate the string from
   * here.  Our caller should then use the 
   * getErrorMessage() method to see if there has been
   * an error and, if not, the getValue() method to get
   * the value we calculated.
   *
   * @param s the string to be parsed
   */
  public CalcParser(String s) {

    // First make a CalcLexer to hold the string.  This
    // will get an error immediately if the first token
    // is bad, so check for that.

    lexer = new CalcLexer(s);
    errorMessage = lexer.getErrorMessage();
    if (errorMessage != null) return;

    // Now parse the expression and get the result.

    value = parseExpression();
    if (errorMessage != null) return;

    // After the expression we should be at the end of
    // the input.

    match(CalcLexer.EOLN_TOKEN);
    if (errorMessage != null) return;

  }

  /**
   * Get the error message or null if none.
   *
   * @return the error message or null
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  /**
   * Get the value of the expression as a string.  This
   * should only be called if getErrorMessage() returned
   * null.
   *
   * @return the value of the expression as a String
   */
  public String getValue() {
    return value;
  }

  /**
   * Match a given token and advance to the next.  
   * This utility is used by our parsing routines.  
   * If the given token does not match
   * lexer.nextToken(), we generate an appropriate
   * error message.  Advancing to the next token may
   * also cause an error.
   *
   * @param token the token that must match
   */
  private void match(int token) {

    // First check that the current token matches the
    // one we were passed; if not, make an error.

    if (lexer.nextToken() != token) {
      if (token == CalcLexer.EOLN_TOKEN)
        errorMessage = 
          "Unexpected text after the expression.";
      else if (token == CalcLexer.NUMBER_TOKEN) 
        errorMessage = "Expected a number.";
      else errorMessage = 
             "Expected a " + ((char) token) + ".";
      return;
    }

    // Now advance to the next token.

    lexer.advance();
      errorMessage = lexer.getErrorMessage();
  }

  /**
   * Parse an expression.  If any error occurs we 
   * return immediately.
   *
   * @return the double value of the expression 
   * or garbage in case of errors.
   */
  private String parseExpression() {

    // <expression> ::= 
    //    <mulexp> { ('+' <mulexp>) | ('-' <mulexp>) }

    String result = parseMulexp();
    if (errorMessage != null) return result;

    while (true) {
      if (lexer.nextToken() == '+') {
        match('+');
        if (errorMessage != null) return result;
        result += "\n" + parseMulexp() +"\nadd";
        if (errorMessage != null) return result;
      }
      else if (lexer.nextToken() == '-') {
        match('-');
        if (errorMessage != null) return result;
        result += "\n"+ parseMulexp() +" \nsubtract";
        if (errorMessage != null) return result;
      }
      else return result;
    }
  }


  /**
   * Parse a mulexp, a subexpression at the precedence
   * level of * and /.  If any error occurs we return
   * immediately.
   *
   * @return the double value of the mulexp or
   * garbage in case of errors.
   */
  private String parseMulexp() {

    // <mulexp> ::= 
    //   <rootexp> { ('*' <rootexp>) | ('/' <rootexp>) }

    String result = parseRootexp();
    if (errorMessage != null) return result;

    while (true) {
      if (lexer.nextToken() == '*') {
        match('*');
        if (errorMessage != null) return result;
        result += "\n"+parseRootexp()+"\nmultiply";
        if (errorMessage != null) return result;
      }
      else if (lexer.nextToken() == '/') {
        match('/');
        if (errorMessage != null) return result;
        result += "\n"+ parseRootexp()+"\ndivide";
        if (errorMessage != null) return result;
      }
      else return result;
    }
  }

  /**
   * Parse a rootexp, which is a constant or
   * parenthesized subexpression.  If any error occurs
   * we return immediately.
   *
   * @return the double value of the rootexp or garbage
   * in case of errors
   */
  private String parseRootexp() {
    String result = null;

    // <rootexp> ::= '(' <expression> ')'

    if (lexer.nextToken() == '(') {
      match('(');
      if (errorMessage != null) return result;
      result = parseExpression();
      if (errorMessage != null) return result;
      match(')');
      if (errorMessage != null) return result;
    }

    // <rootexp> ::= number

    else if (lexer.nextToken()==CalcLexer.NUMBER_TOKEN){
      result = "push " + lexer.getNum();
      if (errorMessage != null) return result;
      match(CalcLexer.NUMBER_TOKEN);
      if (errorMessage != null) return result;
    }

    else {
      errorMessage = 
        "Expected a number or a parenthesis.";
    }

    return result;
  }

}
