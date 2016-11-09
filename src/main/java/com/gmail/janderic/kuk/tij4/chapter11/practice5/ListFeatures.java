package com.gmail.janderic.kuk.tij4.chapter11.practice5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListFeatures {
    
    static void print(Object o) {
	System.out.println(o);
    }

    public static void main(String[] args) {
//	Random rand = new Random(47);
	List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
	print("1: "+ints);
	ints.add(8);
	print("2: "+ints);
	print("3: "+ints.contains(8));
	ints.remove(new Integer(8));
	Integer two = ints.get(2);
	print("4: " + two + " " + ints.indexOf(two));
	Integer nine = new Integer(9);
	print("5: "+ints.indexOf(nine));
	print("6: "+ints.remove(nine));

	print("7: "+ints.remove(two));
	print("8: "+ints);
	
	ints.add(3, 3);
	print("9: "+ints);
	
	List<Integer> subList = ints.subList(1, 4);
	print("subList: "+subList);
	print("10: "+ints.containsAll(subList));
	Collections.sort(subList);
	print("sorted subList: "+subList);
	
	print("11: "+ints.containsAll(subList));
	
	Collections.shuffle(subList);// 重新洗牌
	print("shuffled subList: "+subList);

	print("12: "+ints.containsAll(subList));
	
	ArrayList<Integer> copy = new ArrayList<>(ints);
	subList = Arrays.asList(ints.get(1), ints.get(4));
	print("subList: "+subList);
	copy.retainAll(subList);
	print("13: "+copy);
	
	copy = new ArrayList<>(ints);
	copy.remove(2);// remove by index
	print("14: "+copy);
	copy.removeAll(subList);
	print("15: "+copy);
	copy.set(1, 10);
	print("16: "+copy);
	copy.addAll(2, subList);
	print("17: "+copy);
	print("18: "+ints.isEmpty());
	ints.clear();
	
//	Integer[] array = subList.toArray(new Integer[subList.size()]);
	String[] as = {"12332", "点击点击"};
	List<String> asList = Arrays.asList(as);
	print(asList);
    }

}
