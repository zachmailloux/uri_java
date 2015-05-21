
public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection myCollection = new Collection();
		if(myCollection.isEmpty()==false){
			System.out.println("is not empty");
		}
		for(int i=0;i<=10;i++){
			myCollection.add(i);
		}
		myCollection.remove();
		myCollection.remove();
	}

}
