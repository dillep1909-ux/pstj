import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Kadane's Algorithm
        int maxSoFar = arr[0];
        int currentMax = arr[0];

        for (int i = 1; i < n; i++) {
            // Either extend the current subarray or start new from arr[i]
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        System.out.println(maxSoFar);
    }
}