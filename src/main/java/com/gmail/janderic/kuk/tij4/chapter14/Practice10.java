package com.gmail.janderic.kuk.tij4.chapter14;

import java.util.AbstractList;
import java.util.List;

public class Practice10 {
    public static void type(Class<?> clazz) {
	System.out.println(clazz+"::");
	if(clazz.isPrimitive())
	    System.out.println("是基本数据类型");
	if(clazz.isArray())
	    System.out.println("是数组");
	if(clazz.isEnum())
	    System.out.println("是枚举");
//	if(clazz.isInstance())
	if(clazz.isLocalClass())
	    System.out.println("是本地类？");
	if(clazz.isInterface())
	    System.out.println("是接口");
	if(clazz.isMemberClass())
	    System.out.println("是成员类？");
	if(clazz.isSynthetic())
	    System.out.println("是合成类？");
	
	Class<?> cls = AbstractList.class;
	if(clazz.isAssignableFrom(cls)) {
	    if(clazz.isInterface())
		System.out.println("是"+clazz.getName()+"的实现");
	    else
		System.out.println("是"+clazz.getName()+"的子类");
	}
    }
    
    public static void main(String[] args) {
	type(List.class);
    }
}
