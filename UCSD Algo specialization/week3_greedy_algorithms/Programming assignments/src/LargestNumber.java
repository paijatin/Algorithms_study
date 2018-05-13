import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String temp = "";
        for (int i = 0; i < a.length; i++) {
            temp += a[i];
        }
        String result = "";
        int length = temp.length();
        for(int i=0; i<length; i++) {
            int maxDigit = -1;
            int maxIndex = -1;
            for(int j=0; j<temp.length(); j++) {
                if (maxDigit < (temp.charAt(j) - '0')) {
                    maxDigit = (temp.charAt(j) - '0');
                    maxIndex = j;
                }
            }
            if(maxIndex == 0)
                temp = temp.substring(maxIndex + 1, temp.length());
            else if(maxIndex > 0 && maxIndex < (temp.length() - 1))
                temp = temp.substring(0, maxIndex) + temp.substring(maxIndex + 1, temp.length());
            else
                temp = temp.substring(0, maxIndex);
            result += (char)(maxDigit + '0');
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

