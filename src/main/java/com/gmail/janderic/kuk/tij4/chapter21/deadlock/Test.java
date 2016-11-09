package com.gmail.janderic.kuk.tij4.chapter21.deadlock;

public class Test {
	public static void main(String[] args) {
		Object o1 = new Object();
		Object o2 = new Object();
		
		Thread t1 = new Thread(new Thread1(o1, o2));
		Thread t2 = new Thread(new Thread2(o1, o2));
		
		t1.start();
		t2.start();
	}
}
