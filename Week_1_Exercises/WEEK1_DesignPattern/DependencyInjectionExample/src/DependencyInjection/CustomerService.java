package DependencyInjection;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findCustomerById(String customerId) {
        return customerRepository.findCustomerById(customerId);
    }
}
