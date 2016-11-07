package hu.dpc.edu.spring;

import hu.dpc.edu.Customer;
import hu.dpc.edu.CustomerController;
import hu.dpc.edu.CustomerRepository;
import hu.dpc.edu.components.AuditLogger;
import hu.dpc.edu.components.CustomComponent;
import hu.dpc.edu.repoimpl.InMemoryCustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by vrg on 2016. 11. 07..
 */
@ContextConfiguration(classes = JavaConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BetterSpringJavaApplicationConfigTest {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerController customerController;
    @Autowired
    AuditLogger auditLogger;
    @Autowired
    CustomComponent customComponent;
    @Autowired
    CounterAspect counterAspect;

    @Test
    public void testJavaConfiguration() {
        assertNotNull(customerRepository);
        assertNotNull(customerController);
        assertNotNull(auditLogger);
        assertNotNull(customComponent);
        assertSame(customerController, customComponent.getController());
        assertSame(customerRepository, customComponent.getRepository());
    }

    @Test
    public void testCounterAspect() {
        Customer c = new Customer();

        customerRepository.addCustomer(c);
        customerRepository.addCustomer(c);
        customerRepository.findAll();
        customerRepository.removeCustomer(1L);

        assertEquals(4, counterAspect.getCount());
        assertNotEquals(InMemoryCustomerRepository.class, customerRepository.getClass());
        System.out.println(customerRepository.getClass());
    }


}
