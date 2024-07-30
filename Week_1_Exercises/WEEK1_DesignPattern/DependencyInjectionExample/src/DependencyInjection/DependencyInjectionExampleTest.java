package DependencyInjection;
import java.util.Scanner;

import java.util.Scanner;

public class DependencyInjectionExampleTest {
    public static void main(String[] args) {
        // Create the repository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        Scanner scanner = new Scanner(System.in);

        // Get user input for customer ID
        System.out.println("Enter customer ID to find: ");
        String customerId = scanner.nextLine();

        // Find and display customer details
        Customer customer = customerService.findCustomerById(customerId);
        if (customer != null) {
            System.out.println("Customer found:");
            System.out.println("ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
        } else {
            System.out.println("Customer not found.");
        }

        scanner.close();
    }
}

