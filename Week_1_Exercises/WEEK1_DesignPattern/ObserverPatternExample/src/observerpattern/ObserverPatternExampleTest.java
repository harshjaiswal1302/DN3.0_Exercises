package observerpattern;

import java.util.Scanner;

public class ObserverPatternExampleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StockMarket stockMarket = new StockMarket();

       
        MobileApp mobileApp = new MobileApp("StockMobile");
        WebApp webApp = new WebApp("StockWeb");

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

       
        while (true) {
            System.out.print("Enter new stock price ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                double newPrice = Double.parseDouble(input);
                stockMarket.setPrice(newPrice);  
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        
        stockMarket.deregister(mobileApp);
        stockMarket.deregister(webApp);

        scanner.close();
    }
}

