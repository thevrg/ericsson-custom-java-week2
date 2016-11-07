package hu.dpc.edu.components;

import hu.dpc.edu.Customer;
import hu.dpc.edu.CustomerController;
import org.springframework.stereotype.Component;

/**
 * Created by vrg on 2016. 11. 07..
 */
//@Component
public class FakeCustomerController implements CustomerController{
    @Override
    public void handleAddCustomer(Customer customer) {
        System.out.println("Fake implementation of handleAddCustomer");
    }

    @Override
    public void handleRemoveCustomer(Customer customer) {
        System.out.println("Fake implementation of handleRemoveCustomer");
    }
}
