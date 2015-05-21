/*
	L i s t E x c e p t i o n
	=========================
*/

public class ListException extends Exception
{
//	If an exception is generated/instantiated with no specific message,
//		we only signal a generic "list exception."
	public ListException()
	{
		super("List exception");
	}

//	But, if an exception is generated/instantiated with a specific message,
//		we pass it up.
	public ListException(String message)
	{
		super(message);
	}
}