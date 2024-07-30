package StrategyPattern;

import java.util.Scanner;

public class StrategyPatternExampleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext paymentContext = new PaymentContext();

        while (true) {
            System.out.println("Select payment method (1: Credit Card, 2: PayPal, 0: Exit): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 0) {
                break;
            }

            System.out.print("Enter amount to pay: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Credit Card Number: ");
                    String cardNumber = scanner.nextLine();
                    System.out.print("Enter Card Holder Name: ");
                    String cardHolderName = scanner.nextLine();
                    paymentContext.setPaymentStrategy(new CreditCardPayment(cardNumber, cardHolderName));
                    break;
                case 2:
                    System.out.print("Enter PayPal Email: ");
                    String email = scanner.nextLine();
                    paymentContext.setPaymentStrategy(new PayPalPayment(email));
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            paymentContext.executePayment(amount);
        }

        scanner.close();
    }
}
