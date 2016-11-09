package com.gmail.janderic.kuk.tij4.chapter21.dcl;

public class Test {
	
	public static void main(String[] args) {
		Service s = new Service(1111111111112l);
		Service s1 = new Service(1111111111112l);
		new Thread(new MyThread(s)).start();
		new Thread(new MyThread(s1)).start();
	}
}
