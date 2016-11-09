/**
 * 
 */
package com.gmail.janderic.kuk.tij4.chapter8.practice3;

public class Shape {
    
    static {
	System.out.println("Shape静态域");
    }
    
//    private static BaseRef baseRef = new BaseRef();
    
    public Shape() {
	System.out.println("Shape构造方法");
    }
    
    public void print() {
	System.out.println("Shape.print();");
    }
}
