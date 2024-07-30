package FinancialForecasting;
import java.util.Scanner;

public class FinancialForecasting {

    public static double calculateFutureValue(double initialValue, double growthRate, int years) {
        // Base case: if years is 0, the future value is the initial value
        if (years == 0) {
            return initialValue;
        }
        // Recursive case: calculate the future value for the previous year and apply the growth rate
        double previousValue = calculateFutureValue(initialValue, growthRate, years - 1);
        return previousValue * (1 + growthRate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the initial value:");
        double initialValue = scanner.nextDouble();

        System.out.println("Enter the annual growth rate (as a decimal, e.g., 0.05 for 5%):");
        double growthRate = scanner.nextDouble();

        System.out.println("Enter the number of years:");
        int years = scanner.nextInt();

        double futureValue = calculateFutureValue(initialValue, growthRate, years);
        System.out.printf("The future value after %d years is: %.2f\n", years, futureValue);

        scanner.close();
    }
}
