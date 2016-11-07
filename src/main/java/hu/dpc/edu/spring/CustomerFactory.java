package hu.dpc.edu.spring;

import hu.dpc.edu.Customer;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by vrg on 2016. 11. 07..
 */
public class CustomerFactory implements FactoryBean<Customer> {

    private String firstName;
    private String lastName;

    public CustomerFactory(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public Customer getObject() throws Exception {
        return new Customer(firstName, lastName);
    }

    @Override
    public Class<?> getObjectType() {
        return Customer.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
