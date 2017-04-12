package com.mithyber;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mithyber.service.ShapeService;

public class AOPMain {
    public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	try {
	    ShapeService service = context.getBean("shapeService", ShapeService.class);
	    System.out.println(service.getCircle()
		    .getName());
	    System.out.println(service.getTriangle()
		    .getName());
	} finally {
	    ((ClassPathXmlApplicationContext) context).close();
	}
    }
}
