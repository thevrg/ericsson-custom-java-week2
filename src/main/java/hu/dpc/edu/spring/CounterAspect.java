package hu.dpc.edu.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by vrg on 2016. 11. 07..
 */
@Aspect
public class CounterAspect {
    private AtomicLong counter = new AtomicLong();

    @Before("execution(* hu.dpc.edu.repoimpl.InMemoryCustomerRepository.*(..))")
    public void inc() {
        counter.incrementAndGet();
    }

    public long getCount() {
        return counter.get();
    }
}
