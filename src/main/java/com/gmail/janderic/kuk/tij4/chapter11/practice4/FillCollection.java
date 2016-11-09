package com.gmail.janderic.kuk.tij4.chapter11.practice4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class FillCollection {
    private GenerateMovie generator = new GenerateMovie();
    
    public Collection<String> fill(Collection<String> c, int size) {
	for (int i = 0; i < size; i++) {
	    c.add(generator.next());
	}
	return c;
    }
    public String[] fill(String[] array) {
	for (int i = 0; i < array.length; i++) {
	    array[i] = generator.next();
	}
	return array;
    }
    
    public static void main(String[] args) {
	FillCollection c = new FillCollection();
	System.out.println(Arrays.toString(c.fill(new String[10])));
	System.out.println(c.fill(new ArrayList<String>(), 5));
	System.out.println(c.fill(new LinkedList<String>(), 5));
	System.out.println(c.fill(new HashSet<String>(), 5));
	System.out.println(c.fill(new LinkedHashSet<String>(), 5));
	System.out.println(c.fill(new TreeSet<String>(), 5));
    }
}
