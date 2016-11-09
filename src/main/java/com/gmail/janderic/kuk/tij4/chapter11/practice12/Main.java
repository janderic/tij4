package com.gmail.janderic.kuk.tij4.chapter11.practice12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
	List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 10);
	ArrayList<Integer> copy = new ArrayList<>(list);
	
	ListIterator<Integer> aIterator = copy.listIterator();
	ListIterator<Integer> zIterator = copy.listIterator(copy.size());
	int midIndex = copy.size() >> 1;// 中间
	for (int i = 0; i < midIndex; i++) {
	    Integer next = aIterator.next();
	    aIterator.set(zIterator.previous());
	    zIterator.set(next);
	}
	System.out.println(copy);
	
	System.out.println(1000 / 2);
	System.out.println(10 >> 1);// 取半
	
    }

}
