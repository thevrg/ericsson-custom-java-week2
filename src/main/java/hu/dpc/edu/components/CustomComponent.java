package hu.dpc.edu.components;

import hu.dpc.edu.CustomerController;
import hu.dpc.edu.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by vrg on 2016. 11. 07..
 */
@Component
public class CustomComponent {

    private AuditLogger logger;
    private CustomerController controller;

//    @Autowired
    private CustomerRepository repository;

//
    public CustomComponent() {
        System.out.println("Parameterless constructor called");
    }

    @Autowired
    public CustomComponent(AuditLogger logger, CustomerController controller) {
        System.out.println("CustomComponent(AuditLogger logger, CustomerController controller) was used");
        this.logger = logger;
        this.controller = controller;
    }

    public CustomComponent(AuditLogger logger, CustomerController controller, CustomerRepository repository) {
        this.logger = logger;
        this.controller = controller;
        this.repository = repository;
    }

    public AuditLogger getLogger() {
        return logger;
    }

    @Autowired
    public void setRepository(CustomerRepository repository) {
        this.repository = repository;
        System.out.println("alma has been called with " + repository + ", logger: " + logger);
    }

    @Autowired
    public void setLogger(AuditLogger logger) {
        this.logger = logger;
    }

    public CustomerController getController() {
        return controller;
    }

    public CustomerRepository getRepository() {
        return repository;
    }
}
