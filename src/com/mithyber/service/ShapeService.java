package com.mithyber.service;

import com.mithyber.aspect.Loggable;
import com.mithyber.model.Circle;
import com.mithyber.model.Triangle;

public class ShapeService {
    private Circle circle;
    private Triangle triangle;

    @Loggable
    public Circle getCircle() {
	System.out.println("Circle getter is called");
	return circle;
    }

    public void setCircle(Circle circle) {
	this.circle = circle;
    }

    public Triangle getTriangle() {
	return triangle;
    }

    public void setTriangle(Triangle triangle) {
	this.triangle = triangle;
    }
}
