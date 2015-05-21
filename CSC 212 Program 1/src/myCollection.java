import java.awt.Graphics;
import java.util.Random;


public class myCollection implements DataCollection{
	Item[] List=new Item[10];
	Item selectedItem;
	int[]xloc = new int[10];
	//int[]heights = new int[10];
	int height,yloc;
	int lastIndex=0,selected=0;
	int firstIndex=0;
	int i=0;
	boolean found = false; 
	myCollection(){
		int length = 10;
		Random random;

	}

	
	public void add(Item someItem) {///////////
		
		System.out.println("Enter add");
		//heights[i]=someItem.y;
		List[lastIndex]=someItem;
		//List[lastIndex].flip();//flip on;
		lastIndex++;
		
		//System.out.println(amount);
		
	}

	@Override
	public void remove() {
		//add if statement around the whole thing
		found = false;
		int gap=0;
		Item[] temp = new Item[lastIndex-1];
		while(i<lastIndex){//&&List[i]!=null
			if(List[i].selection()==true){
				List[i]=null;
				 gap = i;
			}
		}
		for(int i = 0;i<lastIndex;i++){
			if(gap>i){
				temp[i]=List[i];
			}
			if(gap<=i){
				temp[i]=List[i+1];
			}
		}
		List=temp;
		lastIndex--;
	}

	@Override
	public void reset() {//////////
		for(int i =0;i<lastIndex;i++){
			if(List[i].selection()==true){
				List[i].flip();
			}
		}
		List[firstIndex].flip();
	}

	@Override
	public void reset(Item someItem) {
		boolean found = false;						
			if(List[firstIndex]!= null){			
				for(int i=0; i<lastIndex; i++){		
					System.out.println(List[i].getValue());
					if((List[i].getValue()==someItem.getValue()) && found == false)
					{
						List[i].flip();		
						found = true;	
					}
				}
			}
		}
		
		// TODO Auto-generated method stub
		
	

	@Override
	public boolean hasNext() {
		for(int i=0; i<lastIndex; i++){
			if(List[i].selection()==true)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public Item next() {
		System.out.println("selected = " + selected);
			for(int i=0; i<lastIndex; i++){
				if(List[i].selection()==true)
				{
					List[i].flip();
					if(i < lastIndex-1){
						List[i+1].flip();
					}
					return List[i];
			}
			}
			return null;
		}

	@Override
	public void paint(Graphics pane) {
		int i = 0;
		while(i<List.length&&List[i]!=null){
			List[i].paint(pane);
			i++;
		}
		
	}

}
