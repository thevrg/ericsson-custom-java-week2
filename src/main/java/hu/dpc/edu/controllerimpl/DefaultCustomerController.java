package hu.dpc.edu.controllerimpl;

import hu.dpc.edu.Customer;
import hu.dpc.edu.CustomerController;
import hu.dpc.edu.CustomerRepository;

/**
 * Created by vrg on 2016. 11. 07..
 */
public class DefaultCustomerController implements CustomerController {

    private CustomerRepository repository;

    public DefaultCustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleAddCustomer(Customer customer) {
        repository.addCustomer(customer);
    }

    @Override
    public void handleRemoveCustomer(Customer customer) {
        repository.removeCustomer(customer.getId());
    }
}
