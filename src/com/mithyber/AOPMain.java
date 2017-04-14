package com.mithyber;

import com.mithyber.service.FactoryService;
import com.mithyber.service.ShapeService;

public class AOPMain {
    public static void main(String[] args) {
	// ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	// try {
	// ShapeService service = context.getBean("shapeService", ShapeService.class);
	// service.getCircle();
	// // service.getCircle()
	// // .setName("Dummy name");
	// // service.getCircle()
	// // .setNameAndReturn("Dummy name");
	// // System.out.println(service.getCircle()
	// // .getName());
	// // System.out.println(service.getTriangle()
	// // .getName());
	// } finally {
	// ((ClassPathXmlApplicationContext) context).close();
	// }
	FactoryService factoryService = new FactoryService();
	ShapeService service = (ShapeService) factoryService.getBean("shapeService");
	service.getCircle();
    }
}
