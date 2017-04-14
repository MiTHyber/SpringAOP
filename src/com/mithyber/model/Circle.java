package com.mithyber.model;

public class Circle {
    private String name;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
	System.out.println("Circle's name \"" + name + "\" is assigned");
	throw new RuntimeException();
    }

    public String setNameAndReturn(String name) {
	this.name = name;
	System.out.println("Circle's setNameAndReturn with name \"" + name + "\" is called");
	return "Used " + name;
    }
}
