
public class ProblemThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(iterative(6,3));
		System.out.println(recursion(4,3));
		System.out.println(recursiondos(4,3));
	}
	
	public static int iterative(int n, int power){
		int total=1;
		while(power>0){
			total = total*n;
			power-=1;
		}
		return total;
	}
	
	
	public static int recursion(int n, int power){
		if(power<=0){
			return 1;
		}
		else{
			return(n*recursion(n,power-1));
		}
	}
	
	public static int recursiondos(int x, int n){
		if(n==0){
			return 1;
		}
		else if(n%2==0){
			return (recursiondos(x,(n/2))*recursiondos(x,(n/2)));
		}
		else{
			return x*(recursiondos(x,((n-1)/2))*recursiondos(x,((n-1)/2)));
		}
	}

}
