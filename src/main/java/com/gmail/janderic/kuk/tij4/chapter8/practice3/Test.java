package com.gmail.janderic.kuk.tij4.chapter8.practice3;

public class Test {
    public static void main(String[] args) {
//	Shape[] shapes = new Shape[2];
//	shapes[0] = new Square();
//	shapes[1] = new Circle();
//	
//	for (Shape shape : shapes) {
//	    shape.print();
//	}
	new Circle();
	
	String className = "com.gmail.janderic.kuk.tij4.chapter8.practice3.Circle";
	
//	ClassLoader loader = Test.class.getClassLoader();
	try {
//	    Class<?> loadClass = loader.loadClass(className);
	    Class<?> forName = Class.forName(className);
	    forName.newInstance();
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	    e.printStackTrace();
	}
    }
}
