package hu.dpc.edu.spring;

import hu.dpc.edu.CustomerController;
import hu.dpc.edu.CustomerRepository;
import hu.dpc.edu.components.AuditLogger;
import hu.dpc.edu.components.CustomComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * Created by vrg on 2016. 11. 07..
 */
@ContextConfiguration("classpath:application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BetterSpringApplicationConfigTest {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerController customerController;
    @Autowired
    AuditLogger auditLogger;
    @Autowired
    CustomComponent customComponent;

    @Test
    public void testXMLConfiguration() {
        assertNotNull(customerRepository);
        assertNotNull(customerController);
        assertNotNull(auditLogger);
        assertNotNull(customComponent);
        assertSame(customerController, customComponent.getController());
        assertSame(customerRepository, customComponent.getRepository());
    }


}
