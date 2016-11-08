package hu.dpc.edu.spring;

import hu.dpc.edu.Customer;
import hu.dpc.edu.CustomerController;
import hu.dpc.edu.CustomerRepository;
import hu.dpc.edu.components.AuditLogger;
import hu.dpc.edu.components.CustomComponent;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * Created by vrg on 2016. 11. 07..
 */
public class SpringApplicationConfigTest {

    @Test
    public void testXMLConfiguration() {
        try(ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("classpath:application-config.xml")) {
            final CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
            final CustomerController customerController = context.getBean("customerController", CustomerController.class);
            final AuditLogger auditLogger = context.getBean(AuditLogger.class);
            final CustomComponent customComponent = context.getBean(CustomComponent.class);


            assertNotNull(customerRepository);
            assertNotNull(customerController);
            assertNotNull(auditLogger);
            assertNotNull(customComponent);
            assertSame(customerController, customComponent.getController());
            assertSame(customerRepository, customComponent.getRepository());
        }
    }
    @Test
    public void testJavaConfiguration() {
        try(AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(JavaConfig.class)) {

            final CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
            final CustomerController customerController = context.getBean("customerController", CustomerController.class);
            final AuditLogger auditLogger = context.getBean(AuditLogger.class);
            final CustomComponent customComponent = context.getBean(CustomComponent.class);
            final Object hello = context.getBean("hello");
            final Object customer1 = context.getBean("customer");
            final Object customer2 = context.getBean("customer");


            assertNotNull(customerRepository);
            assertNotNull(customerController);
            assertNotNull(auditLogger);
            assertNotNull(customComponent);
            assertSame(customerController, customComponent.getController());
            assertSame(customerRepository, customComponent.getRepository());
            assertNotNull(hello);
            assertEquals("hello", hello.toString());
            assertEquals(Customer.class,customer1.getClass());
            assertEquals(Customer.class,customer2.getClass());
            assertSame(customer1, customer2);
        }
    }
}
