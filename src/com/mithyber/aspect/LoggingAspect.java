package com.mithyber.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// class becomes an aspect - we should <aop:aspectj-autoproxy /> and add bean declaration to spring.xml
@Aspect
public class LoggingAspect {

    // called before execution of method of any class "public String getName()"
    // @Before("execution(public String getName())")
    // called before a specific method of a specific class
    // @Before("execution(public String com.mithyber.model.Circle.getName())")
    // called before execution of getter method of any class
    @Before("execution(public * get*())")
    public void loggingAdvice() {
	System.out.println("Advice is here. Get Method Called");
    }
}
