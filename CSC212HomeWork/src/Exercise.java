 public class Exercise {

       public static int f(int n) {
          //  Precondition: n >= 0.
    	   
          System.out.println("Method f entered,"
                             + " n = " + n);
          switch (n) {
             case 0: case 1: case 2:
                return n + 1;
             default:
                return f(n-2) * f(n-4);
          } // end of switch
       } // end of f
	
 
       /*
        * f(6)*f(4)
        * f(6) = f(4) * 3
        * f(4) = 3* 1
        */
       public static void main(String[] args) {
          System.out.println("f(18) = " + f(11));
          //WONT WORK WITH PRIME NUMBERS OR ODD NUMBERS GREATER THAN 1
       } // end of main
    } // end of Exercise