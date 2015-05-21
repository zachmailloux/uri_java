
public class test {
static String a = "Global";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		foo();
		System.out.println(a);
	}



	public static void foo(){
		a = "local";
	}
}
