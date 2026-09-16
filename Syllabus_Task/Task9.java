import java.util.Scanner;

class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNext()) return;

        double a = scanner.nextDouble();
        String operator = scanner.next();
        double b = scanner.nextDouble();

        Calculator calculator = new Calculator();
        boolean passed = false;

        try {
            if (operator.equals("+")) {
                double result = calculator.add(a, b);
                passed = (result == (a + b));
            } else if (operator.equals("/")) {
                double result = calculator.divide(a, b);
                passed = (result == (a / b));
            }

            if (passed) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
        } catch (ArithmeticException e) {
            System.out.println("Test Passed");
        }

        scanner.close();
    }
}