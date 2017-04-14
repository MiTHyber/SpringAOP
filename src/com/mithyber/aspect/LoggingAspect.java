package com.mithyber.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

// class becomes an aspect - we should <aop:aspectj-autoproxy /> and add bean declaration to spring.xml
//@Aspect
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
    // @Before("allGetters() && allCircleMethods()")
    // @Before("allCircleMethods()")
    // JoinPoint gives info about current called method
    // getTarget() - reference to object that triggered advice
    // public void loggingAdvice(JoinPoint joinPoint) {
    // Circle circle = (Circle) joinPoint.getTarget();
    // System.out.println("Advice is here. " + joinPoint);
    // }

    // @Before("allGetters()")
    // public void secondAdvice() {
    // System.out.println("Second advice is here.");
    // }

    // @Before("args(name))")
    // public void beforeStringArgumentMethod(String name) {
    // System.out.println("Before a method that takes a String argument is called. Arg is " + name);
    // }

    // @After doesn't care if exception was thrown or not
    // @After("args(name))")
    // @AfterReturning runs only if method is successful
    // @AfterReturning(pointcut = "args(name))", returning = "returnString")
    // public void afterStringArgumentMethodReturningString(String name, String returnString) {
    // System.out.println("After a method that takes a String argument is called. Arg was " + name + ". "
    // + returnString + " was returned.");
    // }

    // @AfterThrowing runs only if exception was thrown
    // @AfterThrowing(pointcut = "args(name))", throwing = "exception")
    // public void afterStringArgumentMethodThrowsRuntimeException(String name, RuntimeException exception) {
    // System.out.println("After a method that takes a String argument throws an exception. Arg was " + name
    // + ". Exception was " + exception);
    // }

    // applying advice to marked by annotation methods
    // @Around("@annotation(com.mithyber.aspect.Loggable)")
    // @Around("allGetters()")
    // ProceedingJoinPoint is help to run target method (but we can ignore it if we want)
    // if method is returning something u should do it - but u can return whatever u want
    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
	Object returnValue = null;
	// proceed calls the actual target method
	System.out.println("Before running the method");
	try {
	    returnValue = proceedingJoinPoint.proceed();
	    System.out.println("After returning from the method");
	} catch (Throwable e) {
	    System.out.println("After throwing from the method");
	    // if u need exception to propagate
	    throw e;
	}
	System.out.println("Aftter finally (always run)");
	return returnValue;
    }

    // @Pointcut("execution(public * get*(..))")
    // dummy method that holds pointcut annotation
    // public void allGetters() {
    // }

    // @Pointcut("execution(* * com.mithyber.model.Circle.*(..))")
    // @Pointcut("within(com.mithyber.model.Circle)")
    // public void allCircleMethods() {
    // }
    //
    // @Pointcut("within(com.mithyber.model..*)")
    // public void allMethodsInModelPackage() {
    // }
    //
    // @Pointcut("args(com.mithyber.model.Circle))")
    // public void allMethodsThatTakeCircleAsParameter() {
    // }

    public void myLoggingAdvice() {
	System.out.println("Logging from the advice");
    }
}
