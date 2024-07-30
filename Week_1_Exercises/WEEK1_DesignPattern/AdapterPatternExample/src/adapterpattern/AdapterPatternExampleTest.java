package adapterpattern;

import java.util.Scanner;

public class AdapterPatternExampleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  

        System.out.print("Choose payment gateway (PayPal/Stripe): ");
        String gateway = scanner.nextLine();

        PaymentProcessor processor;
        if (gateway.equalsIgnoreCase("PayPal")) {
            processor = new PayPalAdapter(new PayPal());
        } else if (gateway.equalsIgnoreCase("Stripe")) {
            processor = new StripeAdapter(new Stripe());
        } else {
            System.out.println("Unknown payment gateway.");
            return;
        }

        testPayment(processor, amount);
    }

    private static void testPayment(PaymentProcessor processor, double amount) {
        processor.processPayment(amount);
    }
}

