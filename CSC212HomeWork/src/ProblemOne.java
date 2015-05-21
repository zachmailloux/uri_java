
public class ProblemOne {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		swap(6754343);
	}
	public static void swap(int n){
		
		
		if(n<10){
			System.out.println(n);
			return;	
		}
		else{
			System.out.println(n%10);
			swap(n/10);
		}
	}
}
