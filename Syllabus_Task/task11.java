import java.util.Scanner;

public class task11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input rows and columns
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        // Input matrix elements
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int evenCount = 0;
        int oddCount = 0;

        // Count even and odd elements
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
        }

        // Display results
        System.out.println("Number of Even elements: " + evenCount);
        System.out.println("Number of Odd elements: " + oddCount);

        sc.close();
    }
}