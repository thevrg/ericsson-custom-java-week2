package hu.dpc.edu.spring;

import hu.dpc.edu.components.AuditLogger;

/**
 * Created by vrg on 2016. 11. 08..
 */
public class AuditLoggerWrapper extends AuditLogger {
    private AuditLogger original;

    public AuditLoggerWrapper(AuditLogger original) {
        this.original = original;
    }

    @Override
    public void log(String message) {
        super.log("wrapped " + message);
    }
}
