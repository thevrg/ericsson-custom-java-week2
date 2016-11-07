package hu.dpc.edu.spring;

import hu.dpc.edu.Customer;
import hu.dpc.edu.CustomerController;
import hu.dpc.edu.CustomerRepository;
import hu.dpc.edu.components.AuditLogger;
import hu.dpc.edu.components.FakeCustomerController;
import hu.dpc.edu.controllerimpl.DefaultCustomerController;
import hu.dpc.edu.repoimpl.InMemoryCustomerRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.w3c.dom.css.Counter;

/**
 * Created by vrg on 2016. 11. 07..
 */
@Configuration
@ComponentScan("hu.dpc.edu.components")
@EnableAspectJAutoProxy
public class JavaConfig {

    @Bean
    public CustomerRepository customerRepository() {
        return new InMemoryCustomerRepository();
    }

    @Bean
    public CustomerController customerController(CustomerRepository repository) {
        return new DefaultCustomerController(repository);
    }

    @Bean
    public CounterAspect counterAspect() {
        return new CounterAspect();
    }

    @Bean
    public LoggerAspect loggerAspect() {
        return new LoggerAspect();
    }

    @Bean
    public Object hello(AuditLogger logger) {
        return new Object() {
            @Override
            public String toString() {
                logger.log("hello");
                return "hello";
            }
        };
    }

    @Bean
    @Scope("singleton")
    public Customer customer() {
        return new Customer("Bela", "Kovacs");
    }

//    @Bean
//    public CustomerController customerController2() {
//        return new DefaultCustomerController(customerRepository());
//    }
}
