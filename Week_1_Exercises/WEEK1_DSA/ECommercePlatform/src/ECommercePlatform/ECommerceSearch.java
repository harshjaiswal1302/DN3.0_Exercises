package ECommercePlatform;
import java.util.Arrays;
import java.util.Scanner;

public class ECommerceSearch {

    // Linear search
    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    // Binary search
    public static Product binarySearch(Product[] products, String productName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = productName.compareToIgnoreCase(products[mid].getProductName());

            if (result == 0) {
                return products[mid];
            } else if (result > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Method to sort products by name
    public static void sortProductsByName(Product[] products) {
        Arrays.sort(products, (p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of products:");
        int numberOfProducts = Integer.parseInt(scanner.nextLine());
        Product[] products = new Product[numberOfProducts];

        for (int i = 0; i < numberOfProducts; i++) {
            System.out.println("Enter product ID:");
            String productId = scanner.nextLine();
            System.out.println("Enter product name:");
            String productName = scanner.nextLine();
            System.out.println("Enter product category:");
            String category = scanner.nextLine();
            products[i] = new Product(productId, productName, category);
        }

        while (true) {
            System.out.println("Choose search method: linear, binary, or exit:");
            String method = scanner.nextLine();

            if (method.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter the product name to search:");
            String searchName = scanner.nextLine();
            Product result = null;

            switch (method.toLowerCase()) {
                case "linear":
                    result = linearSearch(products, searchName);
                    break;
                case "binary":
                    sortProductsByName(products);
                    result = binarySearch(products, searchName);
                    break;
                default:
                    System.out.println("Invalid search method.");
                    continue;
            }

            if (result != null) {
                System.out.println("Product found: " + result);
            } else {
                System.out.println("Product not found.");
            }
        }

        scanner.close();
    }
}
