import java.util.Scanner;

public class Fibonacci {
	private static long calc_fib(int n) {
		long [] F = new long [n+1];
		for(int i=0; i<=n; i++) {
			if (i <= 1)
				F[i] = i;
			else {
				F[i] = F[i-1] + F[i-2];
			}	  
		}

		return F[n];
	}

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    //System.out.println("Enter a num: ");
    int n = in.nextInt();
    
    System.out.println(calc_fib(n));
    
  }
}
