
public class main {
	int n = 5;
	public main(){
		sumOfSquares(n);
	}
	public int sumOfSquares(int n){
		int total = 0;
		int numbertotal = 0;
		for (int i =1; i < n; i++){
			numbertotal = i * i;
			if((total+numbertotal)<n){
				total = total + numbertotal;
			}
		}
		
		return total;	
	}
	
}
