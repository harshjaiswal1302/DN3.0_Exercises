package SortCustomerOrders;
import java.util.Arrays;
import java.util.Scanner;

public class SortOrders {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() < orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() >= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i+1] and orders[high] (or pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of orders:");
        int numberOfOrders = Integer.parseInt(scanner.nextLine());
        Order[] orders = new Order[numberOfOrders];

        for (int i = 0; i < numberOfOrders; i++) {
            System.out.println("Enter order ID:");
            String orderId = scanner.nextLine();
            System.out.println("Enter customer name:");
            String customerName = scanner.nextLine();
            System.out.println("Enter total price:");
            double totalPrice = Double.parseDouble(scanner.nextLine());
            orders[i] = new Order(orderId, customerName, totalPrice);
        }

        System.out.println("Choose sorting method: bubble, quick, or exit:");
        String method = scanner.nextLine();

        switch (method.toLowerCase()) {
            case "bubble":
                bubbleSort(orders);
                break;
            case "quick":
                quickSort(orders, 0, orders.length - 1);
                break;
            case "exit":
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid sorting method.");
                return;
        }

        System.out.println("Sorted orders by total price:");
        for (Order order : orders) {
            System.out.println(order);
        }

        scanner.close();
    }
}

