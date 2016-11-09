package com.gmail.janderic.kuk.tij4.chapter21.deadlock;

public class Thread2 implements Runnable {

	private Object lock1;
	private Object lock2;
	
	public Thread2(Object lock1, Object lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	
	@Override
	public void run() {
		synchronized (lock2) {
			System.out.println("Thread2 get lock2.");
			synchronized (lock1) {
				System.out.println("Thread2 get lock1.");
			}
		}
	}
	
	

}
