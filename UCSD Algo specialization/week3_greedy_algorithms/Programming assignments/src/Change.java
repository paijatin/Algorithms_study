import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        int count = 0;
        int i=0;
        int [] denominations = {10, 5, 1};
        while(m > 0) {
            count = count + m/denominations[i];
            m = m % denominations[i];
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

