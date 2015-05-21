
public class NovemberTwentyTwo {

	/**
	 * Node:
	 * int item
	 * Node left
	 * Node right
	  
	  public void printInOrder(Node aRoot){
     		if(aRoot==null){//base case 
          		//do nothing
     		}
     		else{
          		printInOrder(aRoot.getLeft());
          		System.out.println(aRoot.getValue);
          		printInOrder(aRoot.getRight());
          	}
          	
		          	3
		          /	  \
		         5     6
		        / 
		       4
		     /   \
		  null   null
  
       returns 4,5,3,6
       
       
       HOW WOULD WE COULD HOW MANY NODES ARE IN THIS LIST?
		       
		           100
		          /	  \
		        2      5
		       / \    /
		      1   3  100
		     /   \
		  null   null
       
		public static int numOfNodes(Node aRoot){
			if (aRoot == null){
				return 0;
			}
		else{
			int counter = 1;
			counter = counter + numOfNodes(aRoot.getLeft());
			counter = counter + numOfNodes(aRoot.getRight());
			
		}
			
		

	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
