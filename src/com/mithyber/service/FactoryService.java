package com.mithyber.service;

import com.mithyber.model.Circle;
import com.mithyber.model.Triangle;

public class FactoryService {
    public Object getBean(String beanType) {
	if ("shapeService".equals(beanType))
	    return new ShapeService();
	if ("circle".equals(beanType))
	    return new Circle();
	if ("triangle".equals(beanType))
	    return new Triangle();
	return null;
    }
}
