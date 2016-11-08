package hu.dpc.edu.spring;

import hu.dpc.edu.components.AuditLogger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by vrg on 2016. 11. 08..
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor preInit " + beanName );
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor postInit " + beanName );
        if (bean instanceof AuditLogger) {
            return new AuditLoggerWrapper((AuditLogger) bean);
        }
        return bean;
    }
}
