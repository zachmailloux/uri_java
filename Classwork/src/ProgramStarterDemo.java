
public class ProgramStarterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		//=-=-=-=-=-=-=-=-=-=BINARY TREE CREATION & PRINT-OUT=-=-=-=-=-=-=-=-=-=-
		//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		//1. Create an unsorted-tree 
		Node root = new Node(100,null,null);
		
		Node a = new Node(200,null,null);
		Node b = new Node(5,null,null);
	
		root.setLeft(a);
		root.setRight(b);

		//2. what does the tree look like so far? 
		
		//3. let's print out the elements of the tree using - inOrder traversal 
		System.out.print("Printout-1 -> ");
		printInOrder(root);
	
		
		//4. let's another node to the tree 
		Node c = new Node(88, null,null);
		b.setRight(c);
		
		//5. let's print out the elements of the tree using - inOrder traversal 
		System.out.print(" \n \nPrintout-2 -> ");
		printInOrder(root);
		
		//***********************************************************************
		//***********************************************************************
		//***********************************************************************
		
			
		//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		//=-=-=-=-=-=-=-=-=-=-=-HOW MANY NODES IN THE TREE?=-=-=-=-=-=-=-=-=-=-=-
		//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		//6. Lets print-out the number of nodes in the tree 
		//System.out.println("\nNumber of nodes -> " + numOfNodes(root));
		numOfNodes(root);
		//***********************************************************************
		//***********************************************************************
		//***********************************************************************
				

	
		//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		//=-=-=-=-=-=-=-=-=-=- ADDING ITEMS TO A BINARY TREE=-=-=-=-=-=-=-=-=-=-=
	    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// As we can see adding to the tree is pretty inefficient, lets make a method
		// that adds values to the tree
		root = insert(root,new Node(99,null,null));
		
		System.out.print(" \n \nPrintout-3 -> ");
		printInOrder(root);
		
		System.out.println("\n \nNumber of nodes -> " + numOfNodes(root));
		
		//***********************************************************************
		//***********************************************************************
		//***********************************************************************
	}
	
	
	
	// InOrder prints tree elements in the following sequence: left, root, right
	public static void printInOrder(Node aRoot)
	{
		//1. base case - check of the incoming root is null
		if(aRoot == null)
		{
			return;  // btw: we can remove the explicit return method 
		}
		else
		{
			// 1. Keep traversing tree as far left as possible 
			printInOrder(aRoot.getLeft());
			
			// 2. Once we reach the base case - print the value at the root
			System.out.print(aRoot.getItem() + " ");
				
			//3. Now start traverse the tree as far right as possible
			printInOrder(aRoot.getRight());
		}
	}
	
	
	
	// This method returns the number of nodes in a tree, each time we come across
	// a root we increment a counter 
	public static int numOfNodes(Node aRoot)
	{
		// 1. Base case - root does not exist return 0
		if(aRoot == null)
		{
			return 0;
		}
		else
		{
			
			//2. Count the root 
			int counter = 1; 
			
			//3. What should we do next?
			counter += numOfNodes(aRoot.getLeft());
			counter += numOfNodes(aRoot.getRight());
			
			
			
			//4. Return the counter 
			return counter;		
		}
	}
	
	/**
	 * public int getRightMostValue(Node aRoot) throws Exception
	 * if(aRoot == null){
	 * return ERROR_Value;}
	 * 
	 * else if(aRoot.getRight()==null){
	 * 
	 * return aRoot.getItem;}
	 * 
	 * else{
	 * 
	 * return getRightMostValue(aRoot.getRight());}
	 * 		
	 * 
	 * 			   10
	 *           /    \ 
	 *         5		11
	 *       /    \		  \
	 *     4       6 		12
	 *              \ 
	 *               7
	 * if I said remove(aRoot, 6); 6 becomes 7, 7 becomes null
	 * 
	 * public Node remove(Node aRoot, int value){
	 * if (root == null){
	 * return null;}
	 * if(aRoot.getItem()==value){
	 * 		if(aRoot.getLeft()==null){
	 * 			return aRoot.getRight();}
	 * 		else if (aRoot.getRight()==null){
	 * 			return aRoot.getLeft();}
	 * 		else{
	 * 			aRoot.setItem(getRightMostValue(aRoot.getLeft());}
	 * 
	 * }
	 * 
	 */
	
	
	// This method adds a new node to the binary tree 
	// to the left or right of root depending on the value 
	public static Node insert(Node aRoot, Node theNewNode)
	{
		/**
		 * 
		 * 
		 * ON FINAL EXAM
		 * 
		 * THIS QUESTION IS KNOWN TO BE ON THE EXAM:
		 * Traversing through a binary tree using a LOOP, not recursion (likely will have to use a stack)
		 * 
		 * 
		 * findtarget(Node aRoot, Node targetNode)
		 * on exam, JUST LIKE insert but not actually changing the value
		 * 
		 */
		// 1. Base case - when we reach a null spot in the tree 
		//                we add the new node 
		if(aRoot == null)
		{
			aRoot = theNewNode;
		}
		else
		{
			// 2. If the new node is less than the root, go left! 
			if(theNewNode.getItem() <= aRoot.getItem())
			{
				aRoot.setLeft(insert(aRoot.getLeft(), theNewNode));
				// do something ... 
			}	
			else
			{
				//3. Otherwise the new node is on the right side of the root, go right! 
				// do something ... 
			}
		}
		
		// Return the root 
		return aRoot;
	}
	
}
