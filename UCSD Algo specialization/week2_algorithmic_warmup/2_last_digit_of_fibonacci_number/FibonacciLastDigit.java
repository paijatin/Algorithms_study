import java.util.*;

public class FibonacciLastDigit {
    /*private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }*/
    
    private static int getFibonacciLastDigitFast(int n) {
        int [] F = new int[n+1];
            for (int i = 0; i < n+1; i++) {
                if(i <= 1)
                    F[i] = i;
                else
                    F[i]  = (F[i - 1] + F[i - 2]) % 10;  // mod 10 will only keep the last digit
            }
        return F[n];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitFast(n);
        System.out.println(c);
    }
}

