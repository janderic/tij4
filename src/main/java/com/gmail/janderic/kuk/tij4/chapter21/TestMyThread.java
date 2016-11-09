package com.gmail.janderic.kuk.tij4.chapter21;

public class TestMyThread {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyFirstThread());
		t1.start();
		Thread t2 = new Thread(new MyFirstThread());
		t2.start();
		Thread t3 = new Thread(new MyFirstThread());
		t3.start();
		Thread t4 = new Thread(new MyFirstThread());
		t4.setDaemon(true);
		t4.start();
	}
}///:~
