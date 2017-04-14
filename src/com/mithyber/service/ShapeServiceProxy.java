package com.mithyber.service;

import com.mithyber.aspect.LoggingAspect;
import com.mithyber.model.Circle;

public class ShapeServiceProxy extends ShapeService {
    @Override
    public Circle getCircle() {
	new LoggingAspect().myLoggingAdvice();
	return super.getCircle();
    }
}
