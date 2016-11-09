package com.gmail.janderic.kuk.tij4.chapter11.practice11;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorPractice {
    public void printCollection(Collection<?> c) {
	Iterator<?> i = c.iterator();
	while(i.hasNext()) {
	    Object object = i.next();
	    System.out.println(object);
	}
    }
    
    @SafeVarargs
    public static <T> T safe(T... safeString) {
	return null;
    }
    
    public static void main(String[] args) {
	IteratorPractice t = new IteratorPractice();
	t.printCollection(Arrays.asList(1,2,3,4));
	t.printCollection(new LinkedList<>());
	t.printCollection(new HashSet<>());
	
	Integer[] is = {1,2,3,4};
	
	List<Integer> asList = Arrays.asList(new Integer[]{1,2,3});
	System.out.println(asList);
	
	/**
	 * 如果传递进去的是基本类型的数组，可变参数会把这个数组当做一个参数来使用
	 */
	int[] as = {1,2,3,4};
	int[] safe = safe(as);
	Integer[] asp = {1,2,3,4};
	Integer safe1 = safe(asp);

    }
}
