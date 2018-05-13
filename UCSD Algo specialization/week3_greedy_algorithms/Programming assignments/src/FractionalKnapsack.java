import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        int index= 0;
        int n = values.length;
        double [] valuePerUnitWeight = new double[n];
        boolean [] covered = new boolean[n];

        for(int i=0; i<values.length; i++) {
            valuePerUnitWeight[i] = (double)values[i]/weights[i];
            covered[i] = false;
        }
        while (capacity > 0 && index != -1) {
            index = getMaxValueIndex(valuePerUnitWeight, covered);
            if(index != -1) {
                double a = valuePerUnitWeight[index];
                if (capacity - weights[index] > 0) {
                    value = value + a * weights[index];
                    capacity -= weights[index];
                } else {
                    value = value + a * capacity;
                    capacity = 0;
                }
                covered[index] = true;
            }
        }
        return value;
    }

    private static int getMaxValueIndex(double[] arr, boolean[] covered) {
        double maxSoFar = 0.0;
        int maxIndex = -1;
        for(int i=0; i<arr.length; i++) {
            if(!covered[i] && maxSoFar < arr[i]) {
                maxSoFar = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
