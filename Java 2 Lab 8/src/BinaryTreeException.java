/*
	B i n a r y T r e e E x c e p t i o n
	=====================================
*/

public class BinaryTreeException extends Exception
{
//	If an exception is generated/instantiated with no specific message,
//		we only signal a generic "binary tree exception."
	public BinaryTreeException()
	{
		super("Binary tree exception");
	}

//	But, if an exception is generated/instantiated with a specific message,
//		we pass it up.
	public BinaryTreeException(String message)
	{
		super(message);
	}
}