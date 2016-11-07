package hu.dpc.edu.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * Created by vrg on 2016. 11. 07..
 */
@Aspect
public class LoggerAspect {

    @Pointcut("execution(* hu.dpc.edu.repoimpl.InMemoryCustomerRepository.*(..))")
    public void allMethodsInInMemoryCustomerRepository() {
    }

//    @AfterReturning(pointcut = "hu.dpc.edu.spring.LoggerAspect.allMethodsInInMemoryCustomerRepository()")
    @Around("execution(* hu.dpc.edu.repoimpl.InMemoryCustomerRepository.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = 0L;

        try {
            startTime = System.nanoTime();
            final Object returnValue = joinPoint.proceed();
            return returnValue;
        } finally {
            final long endTime = System.nanoTime();
            long length = endTime - startTime;
            System.out.println(joinPoint.getSignature()
                    + "(" + Arrays.toString(joinPoint.getArgs())  + ")"
                    + " executed in " + length + " nanos");
        }

    }

}
