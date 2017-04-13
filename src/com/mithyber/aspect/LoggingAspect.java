package com.mithyber.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// class becomes an aspect - we should <aop:aspectj-autoproxy /> and add bean declaration to spring.xml
@Aspect
public class LoggingAspect {

    // called before execution of method of any class "public String getName()"
    // @Before("execution(public String getName())")
    // called before a specific method of a specific class
    // @Before("execution(public String com.mithyber.model.Circle.getName())")
    // called before execution of getter method of any class
    // @Before("execution(public * get*())")
    // .. - for any number of arguments
    // @Before("execution(public * get*(..))")
    // any get method in model package
    // @Before("execution(public com.mithyber.model.* get*(..))")
    // @Before("allGetters())")
    // we can use logic operations
    @Before("allGetters() && allCircleMethods()")
    public void loggingAdvice() {
	System.out.println("Advice is here. Get Method Called");
    }

    @Before("allGetters()")
    public void secondAdvice() {
	System.out.println("Second advice is here.");
    }

    @Pointcut("execution(public * get*(..))")
    // dummy method that holds pointcut annotation
    public void allGetters() {
    }

    // @Pointcut("execution(* * com.mithyber.model.Circle.*(..))")
    @Pointcut("within(com.mithyber.model.Circle)")
    public void allCircleMethods() {
    }

    @Pointcut("within(com.mithyber.model..*)")
    public void allMethodsInModelPackage() {
    }

    @Pointcut("args(com.mithyber.model.Circle))")
    public void allMethodsThatTakeCircleAsParameter() {
    }
}
