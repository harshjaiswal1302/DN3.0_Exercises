package DependencyInjection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> customerData;

    public CustomerRepositoryImpl() {
        customerData = new HashMap<>();
        initializeCustomers();
    }

    private void initializeCustomers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of customers to input:");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.println("Enter customer ID:");
            String id = scanner.nextLine();
            System.out.println("Enter customer name:");
            String name = scanner.nextLine();
            System.out.println("Enter customer email:");
            String email = scanner.nextLine();
            customerData.put(id, new Customer(id, name, email));
        }
    }

    @Override
    public Customer findCustomerById(String customerId) {
        return customerData.get(customerId);
    }
}
