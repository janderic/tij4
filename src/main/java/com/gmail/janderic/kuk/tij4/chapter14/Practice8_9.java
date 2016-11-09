package com.gmail.janderic.kuk.tij4.chapter14;

import java.lang.reflect.Field;
import java.util.LinkedList;

public class Practice8_9 {
    
    public static void printSuperInterfaces(Class<?> clazz) {
	if(clazz == null) return;
	Class<?>[] interfaces = clazz.getInterfaces();
	for (Class<?> class1 : interfaces) {
	    System.out.println("Interface: "+class1.getName());
	    printSuperInterfaces(class1);
	}
    }
    
    public static void printSuperClass(Class<?> clazz) {
	if (clazz == null) return;
	System.out.println("Class: "+clazz.getName());
	
	Field[] fields = clazz.getDeclaredFields();
	for (Field field : fields) {
	    System.out.println(field);
	}
	
	Class<?>[] interfaces = clazz.getInterfaces();
	if(interfaces.length > 0) {
	    for (Class<?> class1 : interfaces) {
		System.out.println("Interface: "+class1.getName());
		printSuperClass(class1.getSuperclass());
	    }
	}
	printSuperClass(clazz.getSuperclass());
    }
    
    public static void main(String[] args) {
//	printSuperClass(ArrayList.class);
	printSuperClass(LinkedList.class);
    }
}
