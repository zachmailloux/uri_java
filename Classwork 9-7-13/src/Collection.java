
public class Collection {
	private int size;
	private int[] collection;//= new int[size];
	private static int DEFAULT_SIZE=5;
	
	public Collection( ){
		this(DEFAULT_SIZE);
		size =0;
		collection = new int[size];
	}
	public Collection(int theSize){
		size = theSize;
		collection = new int[size];
		//isEmpty();
	}
	
	
	
	public boolean isEmpty(){
		return (size==0);
	}
	public void add(int addedNum){
		int[]temp = collection;
		size+=1;
		collection=new int[size];
		for(int i=0;i<temp.length;i++){
			collection[i]=temp[i];
		}
		collection[collection.length-1]=addedNum;
		String list="";
		for (int j=0;j<collection.length;j++){
			list=list+" "+collection[j];
		}
		System.out.println(list);
	}
	public int remove(){
		size--;
		
		return size;	
	}
	/*/
	 * 
	 * 
	 */
}
