package hu.dpc.edu.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by vrg on 2016. 11. 07..
 */
@Component
@Scope("prototype")
public class AuditLogger {

    private String alma;

//    @Value("#{systemProperties.alma}")
    public void setAlma(String alma) {
        this.alma = alma;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
