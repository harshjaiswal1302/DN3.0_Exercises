package DependencyInjection;

public interface CustomerRepository {
    Customer findCustomerById(String customerId);
}
