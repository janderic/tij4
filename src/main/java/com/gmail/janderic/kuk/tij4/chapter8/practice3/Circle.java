package com.gmail.janderic.kuk.tij4.chapter8.practice3;

public class Circle extends Shape {
    
    static {
	System.out.println("Circle静态域");
    }
    
    public Circle() {
	System.out.println("Circle构造方法");
    }
    
    @Override
    public void print() {
	System.out.println("Circle.print();");
    }
}
