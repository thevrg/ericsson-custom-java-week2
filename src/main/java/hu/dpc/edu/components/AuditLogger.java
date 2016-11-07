package hu.dpc.edu.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by vrg on 2016. 11. 07..
 */
@Component
@Scope("prototype")
public class AuditLogger {
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
