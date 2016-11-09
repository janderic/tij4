package com.gmail.janderic.kuk.tij4.chapter21.deadlock;

import java.util.concurrent.TimeUnit;

public class Thread1 implements Runnable {

	private Object lock1;
	private Object lock2;
	
	public Thread1(Object lock1, Object lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	
	@Override
	public void run() {
		synchronized (lock1) {
			System.out.println("Thread1 get lock1.And sleep 50ms...");
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lock2) {
				System.out.println("Thread1 get lock2.");
			}
		}
	}
	
	

}
